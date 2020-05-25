package com.robert.myschool.service.impl;

import com.robert.myschool.convert.StudentConverter;
import com.robert.myschool.entity.StudentEntity;
import com.robert.myschool.mapper.StudentMapper;
import com.robert.myschool.service.StudentService;
import com.robert.myschool.utils.DateUtil;
import com.robert.myschool.vo.StudentVO;
import java.util.ArrayList;
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

  @Override
  public void add(StudentVO studentVO) {
    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setName(studentVO.getName());
    studentEntity.setBirthday(DateUtil.parseYYYYMMDD(studentVO.getBirthday()));
    studentMapper.add(studentEntity);
  }

  @Override
  public void batchAdd(StudentVO studentVO) {
    long startTime = System.currentTimeMillis();
    System.out.println();
    StudentEntity studentEntity = new StudentEntity();
    for (int i = 1; i <= studentVO.getBatchQuantity(); i++) {
      studentEntity.setName(studentVO.getName() + i);
      studentEntity.setBirthday(DateUtil.parseYYYYMMDD(studentVO.getBirthday()));
      studentMapper.add(studentEntity);
    }
    System.out.println("[batchAdd]"+String.valueOf(System.currentTimeMillis()-startTime));
  }

  @Override
  public void batchAdd2(StudentVO studentVO) {
    long startTime = System.currentTimeMillis();
    List<StudentEntity> list = new ArrayList<>();
    for (int i = 1; i <= studentVO.getBatchQuantity(); i++) {
      StudentEntity studentEntity = new StudentEntity();
      studentEntity.setName(studentVO.getName() + i);
      studentEntity.setBirthday(DateUtil.parseYYYYMMDD(studentVO.getBirthday()));
      list.add(studentEntity);
    }
    studentMapper.batchAdd(list);
    System.out.println("[batchAdd]"+String.valueOf(System.currentTimeMillis()-startTime));
  }
}
