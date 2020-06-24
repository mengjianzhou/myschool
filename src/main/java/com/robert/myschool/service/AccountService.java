package com.robert.myschool.service;

import com.robert.myschool.entity.AccountEntity;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.AccountVO;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/16
 */
public interface AccountService {

  Pager<AccountVO> getAccountList(Pager pager);

  void addAccount(AccountVO accountVO);

  void deleteAccount(Integer id);

  void updateAccount(AccountVO accountVO);

  List<AccountEntity> getAccountList();
}
