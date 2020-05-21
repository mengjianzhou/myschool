package com.robert.myschool.mapper;

import com.robert.myschool.entity.StudentEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/21
 */
@Mapper
public interface StudentMapper {

  @Select("select * from student")
  List<StudentEntity> getList();
}
