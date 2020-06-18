package com.robert.myschool.vo;

import java.util.List;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/18
 */
@Data
public class MenuVO {

  private Integer id;

  private Integer parentId;

  private String title;

  private String index;

  private String icon;

  private List<MenuVO> subs;

}
