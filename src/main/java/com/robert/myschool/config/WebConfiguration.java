package com.robert.myschool.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
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

  private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
  private static final String DATE_PATTERN = "yyyy-MM-dd";

  @Bean
  public Converter<String, LocalDateTime> localDateTimeConverter() {
    return new Converter<String, LocalDateTime>() {
      @Override
      public LocalDateTime convert(String source) {
        if (source.trim().length() == 0)
          return null;
        // 先尝试ISO格式: 2019-07-15T16:00:00
        try {
          return LocalDateTime.parse(source);
        } catch (Exception e) {
          return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        }
      }
    };
  }

  @Bean
  public Converter<String, LocalDate> localDateConverter() {
    return new Converter<String, LocalDate>() {
      @Override
      public LocalDate convert(String source) {
        if (source.trim().length() == 0)
          return null;
        try {
          return LocalDate.parse(source);
        } catch (Exception e) {
          return LocalDate.parse(source, DateTimeFormatter.ofPattern(DATE_PATTERN));
        }
      }
    };
  }

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
    JavaTimeModule module = new JavaTimeModule();
    LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
    return builder -> {
      builder.simpleDateFormat(DATE_TIME_PATTERN);
      builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_PATTERN)));
      builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
      builder.modules(module);
    };
  }

  @Bean
  public MappingJackson2HttpMessageConverter MyHttpMessageConverter(){
    // 1.创建一个 Convert
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    // 2. 创建objectmapper
    ObjectMapper objectMapper = new ObjectMapper();
    // 配置时间格式
    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    converter.setObjectMapper(objectMapper);
    return converter;
  }
}
