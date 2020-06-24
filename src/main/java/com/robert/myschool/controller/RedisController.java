package com.robert.myschool.controller;

import cn.hutool.json.JSONUtil;
import com.robert.myschool.entity.AccountEntity;
import com.robert.myschool.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
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
@RequestMapping("data")
public class RedisController {

  @Autowired
  private RedisTemplate<String, List<AccountEntity>> redisTemplate;

  @Autowired
  private RedisTemplate redisTemplate2;

  @Autowired
  private AccountService accountService;

  @RequestMapping("t1")
  @CachePut(value = "test", key = "'t1'")
  public String getData() {
    List<AccountEntity> accountList = accountService.getAccountList();
    return JSONUtil.toJsonStr(accountList);
  }

  @RequestMapping("t2")
  @Cacheable(value = "test", key = "'t2'")
  public String getData2() {
    List<AccountEntity> accountList = accountService.getAccountList();
    return JSONUtil.toJsonStr(accountList);
  }

  @RequestMapping("t3")
  @Caching(
      evict={@CacheEvict(value="test", key="'t1'"), @CacheEvict(value="test", key="'t2'")}
  )
  public boolean deleteData() {
    return true;
  }

  @RequestMapping("t4")
  public void t4(){
    redisTemplate2.opsForValue().set("aa", "aa01");
  }

  @RequestMapping("t5")
  public void t5(){
    redisTemplate2.opsForHash().put("fruit","apple", 100);
    redisTemplate2.opsForHash().put("fruit", "pear", 200);
  }

  @RequestMapping("t6")
  public void t6(){
    redisTemplate2.opsForList().leftPush("animal", "panda");
    redisTemplate2.opsForList().leftPush("animal", "dog");
  }

}
