package com.robert.myschool.utils;

import java.io.Serializable;
import java.util.List;
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
public class Pager<T> implements Serializable {

  private Integer pageIndex;
  private Integer pageSize;
  private Long total;
  private Integer pages;
  private List<T> list;

}
