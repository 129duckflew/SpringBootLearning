package cn.duckflew.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "book")
@EnableConfigurationProperties(Book.class)
public class Book
{
    /**
     * book.author=\u6768\u6d0b
     * book.name=springboot实战之旅
     * book.value=${random.value}
     * book.intValue=${random.int}
     * book.longValue=${random.long}
     * book.uuid=${random.uuid}
     * book.randomNumber=${random.int(1000)}
     * book.title=${book.name}
     */
    private String name;
    private String author;
    private String value;
    private int intValue;
    private long longValue;
    private String uuid;
    private int randomNumber;
    private String title;

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

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public int getIntValue()
    {
        return intValue;
    }

    public void setIntValue(int intValue)
    {
        this.intValue = intValue;
    }

    public long getLongValue()
    {
        return longValue;
    }

    public void setLongValue(long longValue)
    {
        this.longValue = longValue;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public int getRandomNumber()
    {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber)
    {
        this.randomNumber = randomNumber;
    }

    public void setRandomValue(int randomValue)
    {
        this.randomNumber = randomValue;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
