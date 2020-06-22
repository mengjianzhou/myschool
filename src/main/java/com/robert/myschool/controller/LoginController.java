package com.robert.myschool.controller;

import com.robert.myschool.common.Result;
import com.robert.myschool.service.LoginService;
import com.robert.myschool.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private LoginService loginService;

  @PostMapping
  public Result<Boolean> doLogin(@RequestBody UserVO userVO) {
    return new Result<>(loginService.doLogin(userVO));
  }


}
