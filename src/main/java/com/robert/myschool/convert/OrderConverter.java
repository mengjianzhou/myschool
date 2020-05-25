package com.robert.myschool.convert;

import com.robert.myschool.entity.OrderEntity;
import com.robert.myschool.vo.OrderVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/25
 */
public class OrderConverter {

  public static List<OrderVO> convert2OrderList(List<OrderEntity> orderEntityList) {
    List<OrderVO> orderVOList = new ArrayList<>();
    for (OrderEntity orderEntity : orderEntityList) {
      OrderVO orderVO = new OrderVO();
      BeanUtils.copyProperties(orderEntity, orderVO);
      orderVOList.add(orderVO);
    }
    return orderVOList;
  }

}
