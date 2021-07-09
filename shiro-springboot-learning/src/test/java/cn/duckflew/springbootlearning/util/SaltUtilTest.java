package cn.duckflew.springbootlearning.util;

import org.junit.jupiter.api.Test;

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