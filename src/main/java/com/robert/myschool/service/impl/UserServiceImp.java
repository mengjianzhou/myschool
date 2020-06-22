package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.entity.UserEntity;
import com.robert.myschool.mapper.UserMapper;
import com.robert.myschool.service.UserService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.UserVO;
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
public class UserServiceImp extends ServiceImpl<UserMapper, UserEntity> implements UserService {

  @Override
  public Pager<UserVO> getPager(Pager pager) {
    Page page = new Page();
    page.setSize(pager.getPageSize());
    page.setCurrent(pager.getPageIndex());
    IPage<UserEntity> resultPager = baseMapper.selectPage(page, null);
    List<UserEntity> userEntityList = resultPager.getRecords();
    List<UserVO> userVOList = convert2VOList(userEntityList);
    pager.setList(userVOList);
    return pager;
  }

  @Override
  public void addUser(UserVO userVO) {
    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(userVO, userEntity);
    baseMapper.insert(userEntity);
  }

  @Override
  public void updateUser(UserVO userVO) {
    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(userVO, userEntity);
    baseMapper.updateById(userEntity);
  }

  @Override
  public void deleteById(Integer id) {
    baseMapper.deleteById(id);
  }

  @Override
  public void updateUserRole(UserVO userVO) {
    UserEntity userEntity = new UserEntity();
    userEntity.setId(userVO.getId());
    userEntity.setRole(userVO.getRole());
    baseMapper.updateById(userEntity);
  }

  private List<UserVO> convert2VOList(List<UserEntity> userEntityList) {
    List<UserVO> userVOList = new ArrayList<>();
    for (UserEntity entity : userEntityList) {
      UserVO userVO = new UserVO();
      BeanUtils.copyProperties(entity, userVO);
      userVOList.add(userVO);
    }
    return userVOList;
  }

}
