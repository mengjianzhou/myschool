package com.robert.myschool.convert;

import com.robert.myschool.entity.StudentEntity;
import com.robert.myschool.utils.DateUtil;
import com.robert.myschool.vo.StudentVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/21
 */
public class StudentConverter {

  public static List<StudentVO> convert(List<StudentEntity> list) {
    List<StudentVO> voList = new ArrayList<>();
    for (StudentEntity stuEntity : list) {
      StudentVO studentVO = new StudentVO();
      BeanUtils.copyProperties(stuEntity, studentVO);
      studentVO.setBirthday(DateUtil.formatYYYYMMDD(stuEntity.getBirthday()));
      voList.add(studentVO);
    }
    return voList;
  }

}
