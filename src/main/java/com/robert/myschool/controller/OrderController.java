package com.robert.myschool.controller;

import com.robert.myschool.service.OrderService;
import com.robert.myschool.vo.OrderVO;
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
 * @since 2020/5/25
 */
@RestController
@RequestMapping("order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @RequestMapping("list")
  public List<OrderVO> getList(){
    return orderService.getList();
  }

}
