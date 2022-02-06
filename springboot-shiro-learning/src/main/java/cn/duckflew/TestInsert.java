package cn.duckflew;

import cn.duckflew.dao.WuGangDao;
import cn.duckflew.entity.WuGang;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
public class TestInsert
{

    @Autowired
    WuGangDao wuGangDao;

    @Test
    public void insert()
    {
        Scanner scanner = new Scanner(System.in);
        String data=scanner.next();
        while (!data.equals("exit"))
        {
            WuGang wuGang = new WuGang();
            wuGang.setName(data);
            wuGangDao.insert(wuGang);
            data=scanner.next();
        }
    }
}
