package com.robert.myschool.vo;

import com.robert.myschool.enums.AccountStatus;
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
public class AccountVO {

  private Integer id;

  private String name;

  private BigDecimal money;

  private String address;

  private String state;

  public String getState() {
    return AccountStatus.getDescByCode(state);
  }

  private String date;

  private String thumb;

}
