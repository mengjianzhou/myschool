package com.robert.myschool.controller;

import com.robert.myschool.common.Result;
import com.robert.myschool.service.MenuService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.MenuVO;
import com.robert.myschool.vo.MenuViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  菜单管理
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

  @GetMapping("/list")
  public Result<Pager<MenuVO>> getMenuList(Pager pager, MenuVO menuVO) {
    Pager resultPager = menuService.getMenuList(pager, menuVO);
    return new Result<>(resultPager);
  }

  @PostMapping
  public Result<Boolean> addMenu(@RequestBody MenuVO menuVO) {
    menuService.addMenu(menuVO);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("update")
  public Result<Boolean> updateMenu(@RequestBody MenuVO menuVO) {
    menuService.updateMenu(menuVO);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("/delete/{id}")
  public Result<Boolean> deleteMenu(@PathVariable Integer id) {
    menuService.deleteById(id);
    return new Result<>(Boolean.TRUE);
  }


}
