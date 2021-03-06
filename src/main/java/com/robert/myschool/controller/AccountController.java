package com.robert.myschool.controller;

import com.robert.myschool.common.Result;
import com.robert.myschool.convert.AccountConverter;
import com.robert.myschool.entity.AccountEntity;
import com.robert.myschool.service.AccountService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.AccountVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
  public Result<Pager<AccountVO>> getAccountPage(Pager pager) {
    Pager<AccountVO> resultPager = accountService.getAccountList(pager);
    return new Result<>(resultPager);
  }

  @PostMapping
  public Result<Boolean> addAccount(@RequestBody AccountVO accountVO) {
    accountService.addAccount(accountVO);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("/delete/{id}")
  public Result<Boolean> deleteAccount(@PathVariable("id") Integer id) {
    accountService.deleteAccount(id);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("/update")
  public Result<Boolean> updateAccount(@RequestBody AccountVO accountVO) {
    accountService.updateAccount(accountVO);
    return new Result<>(Boolean.TRUE);
  }

}
