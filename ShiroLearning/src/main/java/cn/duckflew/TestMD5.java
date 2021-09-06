package cn.duckflew;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestMD5
{
    public static void main(String[] args)
    {
        Md5Hash md5Hash=new Md5Hash("123","salt");
        String s = md5Hash.toHex();
        System.out.println(s);
    }
}
