package cn.duckflew.shirospringbootlearning.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties(ConfigBean1.class)
@PropertySource("classpath:test1.properties")
@ConfigurationProperties(prefix = "com.book")
@Component
public class ConfigBean1
{
    private String name;
    private String author;

    public ConfigBean1()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    @Override
    public String toString()
    {
        return "ConfigBean1{" + "name='" + name + '\'' + ", author='" + author + '\'' + '}';
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }
}
