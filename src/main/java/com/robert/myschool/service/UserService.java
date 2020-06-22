package com.robert.myschool.service;

import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.UserVO;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/22
 */
public interface UserService {

  Pager<UserVO> getPager(Pager pager);

  void addUser(UserVO userVO);

  void updateUser(UserVO userVO);

  void deleteById(Integer id);

}
