package Lesson20;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "arrayEmployee")
public class ArrayEmployee {

    @XmlElement(name ="employee")
    @JsonProperty("employee")
    List<Employee> listEmployee;
}
