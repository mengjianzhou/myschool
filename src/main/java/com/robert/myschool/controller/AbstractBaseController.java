package com.robert.myschool.controller;

import com.robert.myschool.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/27
 */
@Controller
public class AbstractBaseController {

  @Autowired
  protected OrderService orderService;

}
