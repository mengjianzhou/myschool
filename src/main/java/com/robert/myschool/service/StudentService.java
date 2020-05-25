package com.robert.myschool.service;

import com.robert.myschool.vo.StudentVO;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/21
 */
public interface StudentService {

  List<StudentVO> getList();

  void add(StudentVO studentVO);

  void batchAdd(StudentVO studentVO);

  void batchAdd2(StudentVO studentVO);
}
