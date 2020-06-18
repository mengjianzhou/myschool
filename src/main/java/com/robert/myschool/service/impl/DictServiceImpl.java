package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.entity.DictEntity;
import com.robert.myschool.mapper.DictMapper;
import com.robert.myschool.service.DictService;
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
public class DictServiceImpl extends ServiceImpl<DictMapper, DictEntity> implements DictService {

  @Override
  public String getDictValue(DictEntity dictEntity) {
    String resultValue = "";
    DictEntity resultDictEntity = baseMapper.selectOne(
        new LambdaQueryWrapper<DictEntity>().eq(DictEntity::getDictType, dictEntity.getDictType())
            .eq(DictEntity::getDictKey, dictEntity.getDictKey()));
    if (resultDictEntity != null) {
      resultValue = resultDictEntity.getDictValue();
    }
    return resultValue;
  }
}
