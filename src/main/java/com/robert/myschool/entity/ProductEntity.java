package com.robert.myschool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/17
 */
@Data
@TableName("product")
public class ProductEntity {

  @TableId(value="id",type= IdType.AUTO)
  private Integer id;

  private String productName;

  private String productClass;

  private String productBrand;

  private String productDesc;

  private BigDecimal salesPrice;

  private Integer stockQuantity;

  private String pic;

}
