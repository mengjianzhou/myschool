package com.robert.myschool.service;

import com.robert.myschool.convert.StudentConverter;
import com.robert.myschool.entity.StudentEntity;
import com.robert.myschool.mapper.StudentMapper;
import com.robert.myschool.vo.StudentVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/21
 */
@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentMapper studentMapper;

  @Override
  public List<StudentVO> getList() {
    List<StudentEntity> list = studentMapper.getList();
    List<StudentVO> voList = StudentConverter.convert(list);
    return voList;
  }
}
