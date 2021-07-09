package cn.duckflew.springbootlearning.mapper;

import cn.duckflew.springbootlearning.entity.TRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class TUserMapperTest
{

    @Autowired
    TUserMapper tUserMapper;
    @Test
    void selectByUsername()
    {
    }

    @Test
    void selectRolesByUsername()
    {
        List<TRole> roles = tUserMapper.selectRolesByUsername("xiaochen");
        for (TRole role : roles)
        {
            System.out.println(role);
        }
    }
}