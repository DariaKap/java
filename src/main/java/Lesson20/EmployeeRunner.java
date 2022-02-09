package Lesson20;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.SneakyThrows;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.nio.file.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRunner {

    @SneakyThrows
    public static void main(String[] args) {
        Department department = new Department("IT", "Пермь");

        Employee employeeFirst = new Employee(54,
                "ivanov_ii",
                "Иванов Иван Иванович",
                department,
                new Position("Бизнес-аналитик", new BigDecimal(45_000)));
        Employee employeeTwo = new Employee(55,
                "andreev_ka",
                "Андреев Кирилл Андреевич",
                department,
                new Position("Старший бизнес-аналитик", new BigDecimal(55_000)));
        Employee employeeThree = new Employee(56,
                "parshakov_ia",
                "Паршаков Иван Александрович",
                department,
                new Position("Бизнес-аналитик", new BigDecimal(47_000)));
        Employee employeeFour = new Employee(57,
                "federov_pv",
                "Федоров Петр Васильевич",
                department,
                new Position("Разработчик", new BigDecimal(60_000)));
        ArrayEmployee arrayEmployee = new ArrayEmployee(List.of(employeeFirst, employeeTwo, employeeThree, employeeFour));

        JAXBContext context = JAXBContext.newInstance(ArrayEmployee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Path xmlPath = Path.of("src", "main", "resources", "employee.xml");
        Path jsonPath = Path.of("src", "main", "resources", "employee.json");
        System.out.println("Сохранение данных в xml");
        marshaller.marshal(arrayEmployee, Files.newOutputStream(xmlPath));

        InputStream inputStream = Files.newInputStream(xmlPath);
        Document xmlDocument = getXML(inputStream);
        System.out.println("Сотрудники с зарплатой выше среднего:" + getEmployeeWithSalaryAboveAvg(xmlDocument));

        String json = XML.toJSONObject(String.join("\n", Files.readAllLines(xmlPath))).toString();
        System.out.println("Сохранение данных в json");
        Files.writeString(jsonPath, json, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        System.out.println("Сотрудники находящиеся на нечетных позициях");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        ArrayEmployee empFromJson = mapper.readValue(jsonPath.toFile(), new TypeReference<>(){});
        System.out.println(empFromJson.getListEmployee().stream().filter(employee -> empFromJson.getListEmployee().indexOf(employee) % 2 == 1).collect(Collectors.toList()));
    }

    @SneakyThrows
    private static Document getXML(InputStream inputStream) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        return builder.parse(inputStream);
    }

    @SneakyThrows
    private static double getAvgSalary (Document xmlDocument) {
        XPath xPath = XPathFactory.newInstance().newXPath();
        Double result = (Double) xPath.compile("sum(//position/@salary) div count(//position/@salary)").evaluate(xmlDocument, XPathConstants.NUMBER);
        return result != null ? result.doubleValue() : 0;
    }

    @SneakyThrows
    private static List<String> getEmployeeWithSalaryAboveAvg(Document xmlDocument) {
        double avgSalary =  getAvgSalary(xmlDocument);
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.compile("//position[@salary > " + avgSalary + "]/ancestor::employee/@fullName").evaluate(xmlDocument, XPathConstants.NODESET);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            result.add(nodeList.item(i).getNodeValue());
        }
        return result;
    }
}