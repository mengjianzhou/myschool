package com.robert.myschool.service;

import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.RoleVO;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/22
 */
public interface RoleService {

  Pager<RoleVO> getRolePager(Pager pager);

  void addRole(RoleVO roleVO);

  void update(RoleVO roleVO);

  void deleteById(Integer id);
}
