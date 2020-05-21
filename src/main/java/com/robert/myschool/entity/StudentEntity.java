package com.robert.myschool.entity;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/21
 */
@Data
public class StudentEntity {

  private Integer id;

  private String name;

  private LocalDateTime birthday;

}
