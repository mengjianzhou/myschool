package com.robert.myschool.controller;

import com.robert.myschool.common.Result;
import com.robert.myschool.service.ProductService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @since 2020/6/17
 */
@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("list")
  public Result<Pager<ProductVO>> getList(Pager pager) {
    Pager<ProductVO> result = productService.getList(pager);
    return new Result<>(result);
  }

  @PostMapping
  public Result<Boolean> addProduct(@RequestBody ProductVO productVO) {
    productService.addProduct(productVO);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("/delete/{id}")
  public Result<Boolean> deleteProduct(@PathVariable("id") Integer id) {
    productService.deleteProduct(id);
    return new Result<>(Boolean.TRUE);
  }

  @PostMapping("/update")
  public Result<Boolean> updateProduct(@RequestBody ProductVO productVO) {
    productService.updateProduct(productVO);
    return new Result<>(Boolean.TRUE);
  }

}
