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

  public Integer getParentId() {
    if (parentId == null) {
      parentId = 0;
    }
    return parentId;
  }

  private String title;

  private String index;

  private String icon;

  private Integer level;

  private List<MenuVO> subs;

  private boolean leafFlag;

}
