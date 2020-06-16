package com.robert.myschool.convert;

import com.robert.myschool.entity.AccountEntity;
import com.robert.myschool.vo.AccountVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/16
 */
public class AccountConverter {

  public static List<AccountVO> convert2VOList(List<AccountEntity> entityList) {
    List<AccountVO> accountVOList = new ArrayList<>();
    for (AccountEntity accountEntity : entityList) {
      AccountVO accountVO = new AccountVO();
      BeanUtils.copyProperties(accountEntity, accountVO);
      accountVOList.add(accountVO);
    }
    return accountVOList;
  }

}
