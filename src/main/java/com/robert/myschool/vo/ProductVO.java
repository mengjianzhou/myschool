package com.robert.myschool.vo;

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
public class ProductVO {

  private Integer id;

  private String productName;

  private String productClass;

  private String productBrand;

  private String productDesc;

  private BigDecimal salesPrice;

  private Integer stockQuantity;

}
