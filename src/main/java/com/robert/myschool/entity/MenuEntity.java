package com.robert.myschool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.List;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/18
 */
@Data
@TableName("menu")
public class MenuEntity {

  @TableId(value="id",type= IdType.AUTO)
  private Integer id;

  private Integer parentId;

  private String title;

  @TableField("path")
  private String path;

  private String icon;

  private transient List<MenuEntity> subs;

}
