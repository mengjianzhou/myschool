package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.entity.DictEntity;
import com.robert.myschool.entity.MenuEntity;
import com.robert.myschool.mapper.MenuMapper;
import com.robert.myschool.service.DictService;
import com.robert.myschool.service.MenuService;
import com.robert.myschool.vo.MenuVO;
import com.robert.myschool.vo.MenuViewVO;
import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/18
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {

  @Autowired
  private DictService dictService;

  @Override
  public MenuViewVO getMenuView() {

    List<MenuEntity> menuEntityList = baseMapper
        .selectList(new LambdaQueryWrapper<MenuEntity>().eq(MenuEntity::getParentId, 0));
    if (!CollectionUtils.isEmpty(menuEntityList)) {
      for (MenuEntity menuEntity : menuEntityList) {
        setSubMenus(menuEntity);
      }
    }

    List<MenuVO> menuViewVOList = convert2MenuVOList(menuEntityList);
    MenuViewVO menuViewVO = new MenuViewVO();
    menuViewVO.setItems(menuViewVOList);
    DictEntity dictEntity = new DictEntity();
    dictEntity.setDictType("menu_config");
    dictEntity.setDictKey("collapse");
    String collapse = dictService.getDictValue(dictEntity);
    menuViewVO.setCollapse(Boolean.parseBoolean(collapse));

    return menuViewVO;
  }

  private List<MenuVO> convert2MenuVOList(List<MenuEntity> menuEntityList) {
    List<MenuVO> menuVOList = new ArrayList<>();
    for (MenuEntity menuEntity : menuEntityList) {
      MenuVO menuVO = new MenuVO();
      BeanUtils.copyProperties(menuEntity, menuVO);
      menuVO.setIndex(menuEntity.getPath());
      List<MenuEntity> subs = menuEntity.getSubs();
      if(!CollectionUtils.isEmpty(subs)){
        menuVO.setSubs(convert2MenuVOList(subs));
      }
      menuVOList.add(menuVO);
    }
    return menuVOList;
  }

  private void setSubMenus(MenuEntity menuEntity) {
    List<MenuEntity> subMenuEntityList = baseMapper
        .selectList(
            new LambdaQueryWrapper<MenuEntity>().eq(MenuEntity::getParentId, menuEntity.getId()));
    if (!CollectionUtils.isEmpty(subMenuEntityList)) {
      menuEntity.setSubs(subMenuEntityList);
      for (MenuEntity submenuEntity : subMenuEntityList) {
        setSubMenus(submenuEntity);
      }
    }
  }


}
