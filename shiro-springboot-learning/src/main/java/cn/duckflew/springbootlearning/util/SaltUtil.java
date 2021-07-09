package cn.duckflew.springbootlearning.util;

import java.util.Random;

public class SaltUtil
{
    public static String getSalt( int n)
    {
        char[] chs="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()".toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            stringBuilder.append(chs[random.nextInt(chs.length)]);
        }
        return stringBuilder.toString();
    }
}
