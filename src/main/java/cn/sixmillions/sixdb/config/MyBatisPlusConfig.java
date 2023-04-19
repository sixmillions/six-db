package cn.sixmillions.sixdb.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis-Plus配置
 *
 * @author six
 */
@Configuration
@MapperScan("cn.sixmillions.sixdb.mapper")
public class MyBatisPlusConfig {
}
