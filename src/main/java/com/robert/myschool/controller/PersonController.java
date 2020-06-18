package com.robert.myschool.controller;

import com.robert.myschool.common.Result;
import com.robert.myschool.service.PersonService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/18
 */
@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping("list")
  public Result<Pager<PersonVO>> getList(Pager pager) {
    Pager resultPager = personService.getList(pager);
    return new Result<>(resultPager);
  }

  @PostMapping
  public Result<Boolean> addPerson(@RequestBody PersonVO personVO) {
    personService.addPerson(personVO);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("update")
  public Result<Boolean> updatePerson(@RequestBody PersonVO personVO) {
    personService.updatePerson(personVO);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("/delete/{id}")
  public Result<Boolean> deletePerson(@PathVariable Integer id) {
    personService.deletePerson(id);
    return new Result<>();
  }

}
