package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.convert.ProductConverter;
import com.robert.myschool.entity.ProductEntity;
import com.robert.myschool.mapper.ProductMapper;
import com.robert.myschool.service.ProductService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.ProductVO;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/17
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductEntity> implements ProductService {

  @Override
  public void addProduct(ProductVO productVO) {
    ProductEntity productEntity = new ProductEntity();
    BeanUtils.copyProperties(productVO, productEntity);
    baseMapper.insert(productEntity);
  }

  @Override
  public Pager<ProductVO> getList(Pager pager) {
    Page page = new Page();
    page.setSize(pager.getPageSize());
    page.setCurrent(pager.getPageIndex());
    IPage<ProductEntity> productEntityIPager = baseMapper.selectPage(page, null);
    List<ProductVO> productVOList = ProductConverter.convet2VOList(productEntityIPager.getRecords());
    pager.setList(productVOList);
    pager.setTotal(productEntityIPager.getTotal());
    return pager;
  }

}
