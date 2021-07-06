package cn.duckflew.springsecuritylearning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.DocFlavor;
import java.io.*;
import java.nio.charset.StandardCharsets;

@SpringBootTest
public class Hexo
{

    String path="D:\\Program Files\\MyHexoBlog\\source\\_posts";
    @Test
    public void test() throws IOException
    {
        File srcDir=new File(path);
        File[] files = srcDir.listFiles();
        for (File file : files)
        {
            Long length = file.length();
            byte []data=new byte[length.intValue()];
            FileInputStream inputStream=new FileInputStream(file);
            inputStream.read(data);
            inputStream.close();
            String filename=file.getName().substring(0,file.getName().length()-3);
            String preContent="---\n title: "+filename+"\n---\n";
            String blogContent = new String(data, StandardCharsets.UTF_8);

            FileOutputStream fileOutputStream =new FileOutputStream(file);
            String allContent=preContent+blogContent;
            fileOutputStream.write(allContent.getBytes());
            fileOutputStream.close();
        }

    }
}
