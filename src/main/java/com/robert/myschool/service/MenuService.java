package com.robert.myschool.service;

import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.MenuVO;
import com.robert.myschool.vo.MenuViewVO;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/18
 */
public interface MenuService {

  MenuViewVO getMenuView();

  Pager getMenuList(Pager pager, MenuVO level);

  void addMenu(MenuVO menuVO);

  void updateMenu(MenuVO menuVO);

  void deleteById(Integer id);
}
