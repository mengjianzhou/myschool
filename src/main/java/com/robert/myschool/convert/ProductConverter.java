package com.robert.myschool.convert;

import com.robert.myschool.entity.ProductEntity;
import com.robert.myschool.vo.ProductVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/17
 */
public class ProductConverter {

  public static List<ProductVO> convet2VOList(List<ProductEntity> productEntityList) {
    List<ProductVO> productVOList = new ArrayList<>();
    for (ProductEntity entity : productEntityList) {
      ProductVO productVO = new ProductVO();
      BeanUtils.copyProperties(entity, productVO);
      productVOList.add(productVO);
    }
    return productVOList;
  }

}
