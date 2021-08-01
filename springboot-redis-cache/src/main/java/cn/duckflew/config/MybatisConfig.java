package cn.duckflew.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn/duckflew/mapper")
public class MybatisConfig
{
}
