package com.robert.myschool.config;

import java.lang.reflect.Method;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/25
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

//  @Autowired
//  private RedisConnectionFactory redisConnectionFactory;
//
//  @Bean
//  public RedisConnectionFactory redisConnectionFactory() {
//    RedisConfiguration redisConfiguration = new
//        RedisStandaloneConfiguration("127.0.0.1", 6379);
//    ((RedisStandaloneConfiguration) redisConfiguration).setDatabase(1);
//
//    //根据配置和客户端配置创建连接
//    LettuceConnectionFactory lettuceConnectionFactory = new
//        LettuceConnectionFactory(redisConfiguration);
//    lettuceConnectionFactory.afterPropertiesSet();
//
//    return lettuceConnectionFactory;
//  }
//
//  @Bean
//  public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//    redisTemplate.setKeySerializer(new StringRedisSerializer());
//    return redisTemplate;
//  }

  @Bean
  @Override
  public KeyGenerator keyGenerator() {
    return new KeyGenerator() {
      @Override
      public Object generate(Object target, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        sb.append(target.getClass().getName());
        sb.append(method.getName());
        for (Object obj : params) {
          sb.append(obj.toString());
        }
        return sb.toString();
      }
    };
  }

}
