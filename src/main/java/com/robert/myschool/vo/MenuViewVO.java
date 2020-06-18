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
public class MenuViewVO {

  private List<MenuVO> items;

  private boolean collapse;

}
