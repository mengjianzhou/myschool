package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.entity.AccountEntity;
import com.robert.myschool.mapper.AccountMapper;
import com.robert.myschool.service.AccountService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/16
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountEntity> implements
    AccountService {

  @Override
  public List<AccountEntity> getAccountList() {
    return baseMapper.selectList(null);
  }

}
