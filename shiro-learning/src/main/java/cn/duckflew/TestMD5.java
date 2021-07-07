package cn.duckflew;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestMD5
{
    public static void main(String[] args)
    {
        Md5Hash md5Hash=new Md5Hash("123","X0DAS1D",1024);
        String s = md5Hash.toHex();
        System.out.println(s);
    }
}
