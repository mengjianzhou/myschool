package com.robert.myschool.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/25
 */
@Data
@TableName("order_info")
public class OrderEntity {

  private Integer id;

  private String name;

}
