package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.convert.AccountConverter;
import com.robert.myschool.entity.AccountEntity;
import com.robert.myschool.mapper.AccountMapper;
import com.robert.myschool.service.AccountService;
import com.robert.myschool.utils.DateUtil;
import com.robert.myschool.utils.Pager;
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
  public Pager<AccountVO> getAccountList(Pager pager) {
    Page<AccountEntity> page = new Page<>();
    page.setCurrent(pager.getPageIndex());
    page.setSize(pager.getPageSize());
    IPage resultPage = baseMapper.selectPage(page, null);
    List<AccountEntity> entityList = resultPage.getRecords();
    List<AccountVO> accountVOList = AccountConverter.convert2VOList(entityList);
    Pager<AccountVO> resultPager = new Pager<>();
    resultPager.setPageIndex(pager.getPageIndex());
    resultPager.setPageSize(pager.getPageSize());
    resultPager.setTotal(resultPage.getTotal());
    resultPager.setList(accountVOList);
    return resultPager;
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

  @Override
  public List<AccountEntity> getAccountList() {
    return baseMapper.selectList(null);
  }

}
