package com.robert.myschool.service;

import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.PersonVO;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/18
 */
public interface PersonService {

  Pager getList(Pager pager);

  void addPerson(PersonVO personVO);

  void updatePerson(PersonVO personVO);

  void deletePerson(Integer id);

}
