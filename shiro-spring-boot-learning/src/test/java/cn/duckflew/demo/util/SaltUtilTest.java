package cn.duckflew.demo.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaltUtilTest
{

    @Test
    void getSalt()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println(SaltUtil.getSalt(4));
        }
    }
}