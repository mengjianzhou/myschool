package com.robert.myschool.utils;

import com.robert.myschool.entity.OrderEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/27
 */
public class DecimalUtils {

  public static BigDecimal getSum(List<OrderEntity> orderEntityList) {
    BigDecimal total = orderEntityList.stream().map(OrderEntity::getAmount).reduce(BigDecimal::add)
        .get();
    return total;
  }

  public static void main(String[] args) {
    List<OrderEntity> orderList = null;
    for (OrderEntity orderEntity : orderList) {
      orderEntity.getAmount();
    }
    System.out.println(getSum(orderList));
  }

}
