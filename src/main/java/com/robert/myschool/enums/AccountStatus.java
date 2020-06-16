package com.robert.myschool.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/16
 */
public enum AccountStatus {

  SUCCESS("1", "成功"),
  FAIL("2", "失败"),
  ;

  private String code;

  private String desc;

  private AccountStatus(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getDescByCode(String code) {
    for (AccountStatus item : values()) {
      if(item.code.equals(code)){
        return item.desc;
      }
    }
    return "";
  }


}
