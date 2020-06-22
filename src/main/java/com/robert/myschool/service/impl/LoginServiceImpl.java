package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.entity.UserEntity;
import com.robert.myschool.mapper.UserMapper;
import com.robert.myschool.service.LoginService;
import com.robert.myschool.vo.UserVO;
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
public class LoginServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements LoginService {

  @Override
  public Boolean doLogin(UserVO userVO) {
    UserEntity userEntity = baseMapper.selectOne(
        new LambdaQueryWrapper<UserEntity>()
            .eq(UserEntity::getUsername, userVO.getUsername())
            .eq(UserEntity::getPassword, userVO.getPassword()));
    return userEntity != null;
  }

}
