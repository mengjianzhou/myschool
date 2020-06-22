package com.robert.myschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.myschool.entity.DictEntity;
import com.robert.myschool.entity.MenuEntity;
import com.robert.myschool.mapper.MenuMapper;
import com.robert.myschool.service.DictService;
import com.robert.myschool.service.MenuService;
import com.robert.myschool.utils.Pager;
import com.robert.myschool.vo.MenuVO;
import com.robert.myschool.vo.MenuViewVO;
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
    List<MenuEntity> menuEntityList = baseMapper.selectList(null);
    List<MenuEntity> rootList = getByParentId(menuEntityList, 0);
    setSubMenuEntityList(rootList, menuEntityList);
    List<MenuVO> menuViewVOList = convert2MenuVOList(rootList);
    MenuViewVO menuViewVO = new MenuViewVO();
    menuViewVO.setItems(menuViewVOList);
    DictEntity dictEntity = new DictEntity();
    dictEntity.setDictType("menu_config");
    dictEntity.setDictKey("collapse");
    String collapse = dictService.getDictValue(dictEntity);
    menuViewVO.setCollapse(Boolean.parseBoolean(collapse));
    return menuViewVO;
  }

  private void setSubMenuEntityList(List<MenuEntity> rootList, List<MenuEntity> menuEntityList) {
    for (MenuEntity menuEntity : rootList) {
      List<MenuEntity> subs = getByParentId(menuEntityList, menuEntity.getId());
      menuEntity.setSubs(subs);
    }
  }

  @Override
  public Pager getMenuList(Pager pager, MenuVO menuVO) {
    Page page = new Page();
    page.setCurrent(pager.getPageIndex());
    page.setSize(pager.getPageSize());
    IPage<MenuEntity> menuEntityIPage = baseMapper
        .selectPage(page,
            new LambdaQueryWrapper<MenuEntity>()
                .eq(MenuEntity::getLevel, menuVO.getLevel())
                .eq(MenuEntity::getParentId, menuVO.getParentId()));
    List<MenuEntity> menuEntityList = menuEntityIPage.getRecords();
    List<MenuEntity> allMenuEntityList = baseMapper.selectList(null);
    setLeafFlag(0, allMenuEntityList, 1);
    for (MenuEntity menuEntity : menuEntityList) {
      for (MenuEntity entity : allMenuEntityList) {
        if (menuEntity.getId().equals(entity.getId())) {
          menuEntity.setLeafFlag(entity.isLeafFlag());
        }
      }
    }
    List<MenuVO> menuVOList = convert2MenuVOList(menuEntityList);
    pager.setList(menuVOList);
    pager.setTotal(menuEntityIPage.getTotal());
    return pager;
  }


  @Override
  public void addMenu(MenuVO menuVO) {
    MenuEntity menuEntity = new MenuEntity();
    BeanUtils.copyProperties(menuVO, menuEntity);
    menuEntity.setPath(menuVO.getIndex());
    baseMapper.insert(menuEntity);
  }

  @Override
  public void updateMenu(MenuVO menuVO) {
    MenuEntity menuEntity = new MenuEntity();
    BeanUtils.copyProperties(menuVO, menuEntity);
    menuEntity.setPath(menuVO.getIndex());
    baseMapper.insert(menuEntity);
  }

  @Override
  public void deleteById(Integer id) {
    baseMapper.deleteById(id);
  }

  private List<MenuVO> convert2MenuVOList(List<MenuEntity> menuEntityList) {
    List<MenuVO> menuVOList = new ArrayList<>();
    for (MenuEntity menuEntity : menuEntityList) {
      MenuVO menuVO = new MenuVO();
      BeanUtils.copyProperties(menuEntity, menuVO);
      menuVO.setIndex(menuEntity.getPath());
      List<MenuEntity> subs = menuEntity.getSubs();
      if (!CollectionUtils.isEmpty(subs)) {
        menuVO.setSubs(convert2MenuVOList(subs));
      }
      menuVOList.add(menuVO);
    }
    return menuVOList;
  }



  public List<MenuEntity> getByParentId(List<MenuEntity> menuEntityList, Integer parentId) {
    List<MenuEntity> resultList = new ArrayList<>();
    for (MenuEntity menuEntity : menuEntityList) {
      if (menuEntity.getParentId().equals(parentId)) {
        resultList.add(menuEntity);
      }
    }
    return resultList;
  }


  private void setLeafFlag(Integer parentId, List<MenuEntity> menuEntityList, Integer level) {
    for (MenuEntity menuEntity : menuEntityList) {
      if (level == menuEntity.getLevel() && menuEntity.getParentId() == parentId) {
        if (!CollectionUtils.isEmpty(getChildList(menuEntity.getId(), menuEntityList, level + 1))) {
          menuEntity.setLeafFlag(true);
          setLeafFlag(menuEntity.getId(), menuEntityList, level + 1);
        }
      }
    }
  }

  private List<MenuEntity> getChildList(Integer parentId, List<MenuEntity> menuEntityList,
      Integer level) {
    List<MenuEntity> levelList = new ArrayList<>();
    for (MenuEntity menuEntity : menuEntityList) {
      if (level == menuEntity.getLevel() && menuEntity.getParentId() == parentId) {
        levelList.add(menuEntity);
      }
    }
    return levelList;
  }

}
