package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.convert.OrderConverter;
import com.robert.myschool.entity.OrderEntity;
import com.robert.myschool.mapper.OrderMapper;
import com.robert.myschool.service.OrderService;
import com.robert.myschool.vo.OrderVO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/25
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements
    OrderService {

  @Override
  public List<OrderVO> getList() {
    List<OrderEntity> orderVOList = baseMapper.selectList(new LambdaQueryWrapper<>());
    return OrderConverter.convert2OrderList(orderVOList);
  }

}
