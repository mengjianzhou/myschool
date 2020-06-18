package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.entity.PersonEntity;
import com.robert.myschool.mapper.PersonMapper;
import com.robert.myschool.service.PersonService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.PersonVO;
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
 * @since 2020/6/18
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, PersonEntity> implements PersonService {

  @Override
  public Pager getList(Pager pager) {
    Page page = new Page();
    page.setCurrent(pager.getPageIndex());
    page.setSize(pager.getPageSize());
    IPage<PersonEntity> resultPage = baseMapper.selectPage(page, null);
    List<PersonEntity> personEntityList = resultPage.getRecords();
    List<PersonVO> personVOList = new ArrayList<>();
    for (PersonEntity personEntity : personEntityList) {
      PersonVO personVO = new PersonVO();
      BeanUtils.copyProperties(personEntity, personVO);
      personVOList.add(personVO);
    }
    pager.setList(personVOList);
    return pager;
  }

  @Override
  public void addPerson(PersonVO personVO) {
    PersonEntity personEntity = new PersonEntity();
    BeanUtils.copyProperties(personVO, personEntity);
    baseMapper.insert(personEntity);
  }

  @Override
  public void updatePerson(PersonVO personVO) {
    PersonEntity personEntity = new PersonEntity();
    BeanUtils.copyProperties(personVO, personEntity);
    baseMapper.updateById(personEntity);
  }

  @Override
  public void deletePerson(Integer id) {
    baseMapper.deleteById(id);
  }

}
