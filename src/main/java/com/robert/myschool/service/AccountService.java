package com.robert.myschool.service;

import com.robert.myschool.entity.AccountEntity;
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

  List<AccountEntity> getAccountList();

}
