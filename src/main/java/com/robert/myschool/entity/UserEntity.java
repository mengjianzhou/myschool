package com.robert.myschool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/22
 */
@TableName("user")
@Data
public class UserEntity {

  @TableId(value="id",type= IdType.AUTO)
  private Integer id;

  private String username;

  private String password;

  private String role;

}
