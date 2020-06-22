package com.robert.myschool.controller;

import com.robert.myschool.common.Result;
import com.robert.myschool.service.RoleService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.RoleVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/22
 */
@RestController
@RequestMapping("role")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @GetMapping("page")
  public Result<Pager<RoleVO>> getRolePager(Pager pager) {
    Pager<RoleVO> resultPager = roleService.getRolePager(pager);
    return new Result<>(resultPager);
  }

  @GetMapping("list")
  public Result<List<RoleVO>> getRoleList() {
    List<RoleVO> roleVOList = roleService.getRoleList();
    return new Result<>(roleVOList);
  }

  @PostMapping
  public Result<Boolean> addRole(@RequestBody RoleVO roleVO) {
    roleService.addRole(roleVO);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("update")
  public Result<Boolean> updateRole(@RequestBody RoleVO roleVO) {
    roleService.update(roleVO);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("/delete/{id}")
  public Result<Boolean> deleteById(@PathVariable("id") Integer id) {
    roleService.deleteById(id);
    return new Result<>(Boolean.TRUE);
  }

}
