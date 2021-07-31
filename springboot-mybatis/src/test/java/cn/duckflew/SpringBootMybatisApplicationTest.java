package cn.duckflew;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.io.File;

class SpringBootMybatisApplicationTest
{

    @Autowired
    DataSource dataSource;
    @Test
    void main()
    {
        System.out.println(dataSource.getClass());
    }

    @Test
    public void rename()
    {
        String path="E:\\331T阿里云盘资源2021年7月19日";
        File dic = new File(path);
        dfs(dic);
    }
    public void dfs(File dic)
    {
        if (dic.isDirectory())
        {
            File[] files = dic.listFiles();
            for (File file : files)
            {
                dfs(file);
            }
        }
        else {
            if (dic.getName().endsWith(".jpg"))
            {
                String path = dic.getPath();
                String substring = path.substring(0, path.length() - 4);
                boolean b = dic.renameTo(new File(substring + ".txt"));
                System.out.println(dic.getName());
            }
        }
    }
}