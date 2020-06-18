package com.robert.myschool.vo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import lombok.Data;
import org.springframework.core.Constants;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/18
 */
@Data
public class PersonVO {

  private Integer id;

  private String name;

  private Integer gender;

  private String genderDesc;

  public String getGenderDesc() {
    return gender == 1 ? "男" : "女";
  }

  private Integer age;

  public Integer getAge() {
    if (birthday != null) {
      LocalDate birthDate = birthday.toLocalDate();
      LocalDate nowDate = LocalDate.now();
      age = birthDate.until(nowDate).getYears();

    }
    return age;
  }

  private LocalDateTime birthday;

  private String position;

}
