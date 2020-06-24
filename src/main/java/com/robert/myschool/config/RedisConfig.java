package com.robert.myschool.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.lang.reflect.Method;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

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

  @Bean
  public <T> RedisTemplate<String, T> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Jdk8Module());
    mapper.registerModule(new JavaTimeModule());

    GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer =
        new GenericJackson2JsonRedisSerializer(mapper);

    RedisTemplate<String, T> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
    redisTemplate.setHashKeySerializer(RedisSerializer.string());
    redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
    return redisTemplate;
  }

  @Bean
  public RedisTemplate redisTemplate2(RedisConnectionFactory redisConnectionFactory) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Jdk8Module());
    mapper.registerModule(new JavaTimeModule());

    GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer =
        new GenericJackson2JsonRedisSerializer(mapper);

    StringRedisTemplate redisTemplate = new StringRedisTemplate();
    redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    return redisTemplate;
  }


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
