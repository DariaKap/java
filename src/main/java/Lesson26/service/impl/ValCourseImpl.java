package Lesson26.service.impl;

import Lesson24.DBBook;
import Lesson26.service.ValCourse;
import lombok.SneakyThrows;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ValCourseImpl implements ValCourse {
    private final Map<String, BigDecimal> dataCourse = new HashMap<>();

    @SneakyThrows
    public ValCourseImpl(){
        Properties DATA_SETTINGS = new Properties();
        DATA_SETTINGS.load(DBBook.class.getResourceAsStream("/data.properties"));
        final Content getResult = Request.Get(DATA_SETTINGS.getProperty("cbrUrlAPI"))
                .execute().returnContent();
        JSONObject currencies = new JSONObject(getResult.toString()).getJSONObject("Valute");
        Set<String> valueSet = currencies.keySet();
        for (String s : valueSet) {
            dataCourse.put(s, currencies.getJSONObject(s).getBigDecimal("Value"));
        }
    }
    @Override
    public BigDecimal getCurrentCoursesVal(String charCode) {
        return dataCourse.get(charCode);
    }
}
