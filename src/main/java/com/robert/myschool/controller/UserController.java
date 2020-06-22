package com.robert.myschool.controller;

import com.robert.myschool.common.Result;
import com.robert.myschool.service.UserService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/22
 */
@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("page")
  public Result<Pager<UserVO>> getList(Pager pager) {
    Pager<UserVO> resultPager = userService.getPager(pager);
    return new Result<>(resultPager);
  }

  @PostMapping
  public Result<Boolean> addUser(@RequestBody UserVO userVO) {
    userService.addUser(userVO);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("update")
  public Result<Boolean> updateUser(@RequestBody UserVO userVO) {
    userService.updateUser(userVO);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("delete/{id}")
  public Result<Boolean> deleteUser(@PathVariable Integer id) {
    userService.deleteById(id);
    return new Result<>(Boolean.TRUE);
  }

}
