package com.robert.myschool.controller;

import com.robert.myschool.service.StudentService;
import com.robert.myschool.vo.StudentVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

  @PostMapping("/add")
  public boolean add(@RequestBody StudentVO studentVO) {
    studentService.add(studentVO);
    return true;
  }

  @PostMapping("/batchAdd")
  public boolean batchAdd(@RequestBody StudentVO studentVO) {
    studentService.batchAdd(studentVO);
    return true;
  }

  @PostMapping("/batchAdd2")
  public boolean batchAdd2(@RequestBody StudentVO studentVO) {
    studentService.batchAdd2(studentVO);
    return true;
  }

}
