package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.entity.RoleEntity;
import com.robert.myschool.mapper.RoleMapper;
import com.robert.myschool.service.RoleService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.RoleVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

  @Override
  public Pager<RoleVO> getRolePager(Pager pager) {
    Page page = new Page();
    page.setCurrent(pager.getPageIndex());
    page.setSize(pager.getPageSize());
    Page<RoleEntity> roleEntityPager = baseMapper.selectPage(page, null);
    List<RoleEntity> records = roleEntityPager.getRecords();
    List<RoleVO> roleVOList = convert2VOList(records);
    pager.setList(roleVOList);
    return pager;
  }

  @Override
  public void addRole(RoleVO roleVO) {
    RoleEntity roleEntity = new RoleEntity();
    BeanUtils.copyProperties(roleVO, roleEntity);
    baseMapper.insert(roleEntity);
  }

  @Override
  public void update(RoleVO roleVO) {
    RoleEntity roleEntity = new RoleEntity();
    BeanUtils.copyProperties(roleEntity, roleVO);
    baseMapper.updateById(roleEntity);
  }

  @Override
  public void deleteById(Integer id) {
    baseMapper.deleteById(id);
  }

  private List<RoleVO> convert2VOList(List<RoleEntity> records) {
    List<RoleVO> roleVOList = new ArrayList<>();
    for (RoleEntity roleEntity : records) {
      RoleVO roleVO = new RoleVO();
      BeanUtils.copyProperties(roleEntity, roleVO);
      roleVOList.add(roleVO);
    }
    return roleVOList;
  }

}
