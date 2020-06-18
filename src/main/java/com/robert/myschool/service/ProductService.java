package com.robert.myschool.service;

import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.ProductVO;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/17
 */
public interface ProductService {

  void addProduct(ProductVO productVO);

  Pager<ProductVO> getList(Pager pager);

  void deleteProduct(Integer id);

  void updateProduct(ProductVO productVO);

}
