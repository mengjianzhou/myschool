package com.robert.myschool.service;

import com.robert.myschool.vo.UserVO;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/22
 */
public interface LoginService {

  Boolean doLogin(UserVO userVO);
}
