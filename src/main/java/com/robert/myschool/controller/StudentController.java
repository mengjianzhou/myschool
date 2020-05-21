package com.robert.myschool.controller;

import com.robert.myschool.service.StudentService;
import com.robert.myschool.vo.StudentVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/21
 */
@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @RequestMapping("list")
  public List<StudentVO> getList() {
    return studentService.getList();
  }

}
