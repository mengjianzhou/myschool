package com.robert.myschool.controller;

import com.robert.myschool.common.Result;
import com.robert.myschool.service.MenuService;
import com.robert.myschool.vo.MenuViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/18
 */
@RestController
@RequestMapping("menu")
public class MenuController {

  @Autowired
  private MenuService menuService;

  @GetMapping("/view")
  public Result<MenuViewVO> getMenuView() {
    MenuViewVO menuViewVO = menuService.getMenuView();
    return new Result<>(menuViewVO);
  }

}
