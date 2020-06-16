package com.robert.myschool.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/16
 */
@Data
@TableName("account_info")
public class AccountEntity {

  private Integer id;

  private String name;

  private BigDecimal money;

  private String address;

  private String state;

  private String date;

  private String thumb;

}
