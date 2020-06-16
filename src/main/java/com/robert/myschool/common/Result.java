package com.robert.myschool.common;

import java.io.Serializable;
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
public class Result<T> implements Serializable {

  private String code;

  private String msg;

  private T data;

  public Result(){

  }

  public Result(T obj) {
    this.data = obj;
    this.code = "200";
    this.msg = "success";
  }

  public Result fail(){
    Result<Object> objectResult = new Result<>();
    objectResult.code = "500";
    objectResult.msg = "系统异常";
    return objectResult;
  }

}
