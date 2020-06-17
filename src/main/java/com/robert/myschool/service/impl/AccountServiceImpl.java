package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.entity.AccountEntity;
import com.robert.myschool.mapper.AccountMapper;
import com.robert.myschool.service.AccountService;
import com.robert.myschool.utils.DateUtil;
import com.robert.myschool.vo.AccountVO;
import java.time.LocalDateTime;
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

  @Override
  public void addAccount(AccountVO accountVO) {
    AccountEntity accountEntity = new AccountEntity();
    accountEntity.setName(accountVO.getName());
    accountEntity.setMoney(accountVO.getMoney());
    accountEntity.setAddress(accountVO.getAddress());
    accountEntity.setThumb("http://pic.51yuansu.com/pic3/cover/03/85/66/5c11e1fa1ac16_610.jpg");
    accountEntity.setDate(DateUtil.formatYYYYMMDD(LocalDateTime.now()));
    accountEntity.setState("1");
    baseMapper.insert(accountEntity);
  }

  @Override
  public void deleteAccount(Integer id) {
    baseMapper.deleteById(id);
  }

  @Override
  public void updateAccount(AccountVO accountVO) {
    AccountEntity accountEntity = new AccountEntity();
    accountEntity.setId(accountVO.getId());
    accountEntity.setMoney(accountVO.getMoney());
    accountEntity.setAddress(accountVO.getAddress());
    baseMapper.updateById(accountEntity);
  }

}