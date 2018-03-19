package cn.example.life.demo.valide;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import javax.validation.*;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by 季先生 on 2018/3/14 10:26.
 */
@Slf4j
public class TestHibernateValide {
    @Test
    public void validTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Student student = new Student();
//        student.setAge(30);
        student.setId("asdfasf");
        student.setName("");
        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
        log.info(constraintViolations + "");
        print( student);
    }

    private void print(@Valid Student student){
        log.info("student info:{}",student);
    }
}

@Getter
@Setter
@ToString
@Slf4j
class Student {
    @NotBlank(message = "id不能为null")
    private String id;
    @NotEmpty(message = "名字不能为null")
    private String name;
//    @Length(min = 15, max = 20, message = "年龄不符合条件")
//    private Integer age;
}