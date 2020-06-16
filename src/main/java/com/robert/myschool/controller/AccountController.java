package com.robert.myschool.controller;

import com.robert.myschool.common.Result;
import com.robert.myschool.convert.AccountConverter;
import com.robert.myschool.entity.AccountEntity;
import com.robert.myschool.service.AccountService;
import com.robert.myschool.vo.AccountVO;
import java.util.List;
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
 * @since 2020/6/16
 */
@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired
  private AccountService accountService;

  @GetMapping("page")
  public Result<List<AccountVO>> getAccountPage() {
    List<AccountEntity> entityList = accountService.getAccountList();
    List<AccountVO> accountVOList = AccountConverter.convert2VOList(entityList);
    return new Result<>(accountVOList);
  }

}
