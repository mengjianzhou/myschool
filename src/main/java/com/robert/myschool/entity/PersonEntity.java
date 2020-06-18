package com.robert.myschool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/18
 */
@TableName("person")
@Data
public class PersonEntity {

  @TableId(value="id",type= IdType.AUTO)
  private Integer id;

  private String name;

  private Integer gender;

  private Integer age;

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime birthday;

  private String position;

}
