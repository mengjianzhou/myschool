package com.robert.myschool.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/6/16
 */
@Configuration
@EnableWebMvc
public class WebConfiguration{

  @Bean
  public MappingJackson2HttpMessageConverter MyHttpMessageConverter(){
    // 1.创建一个 Convert
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    // 2. 创建objectmapper
    ObjectMapper objectMapper = new ObjectMapper();
    // 配置时间格式
    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

    converter.setObjectMapper(objectMapper);
    return converter;
  }
}
