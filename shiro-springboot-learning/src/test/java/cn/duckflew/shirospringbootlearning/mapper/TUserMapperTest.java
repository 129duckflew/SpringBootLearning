package cn.duckflew.shirospringbootlearning.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.relation.Role;
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
        List<Role> roles = tUserMapper.selectRolesByUserId(1);
        for (Role role : roles)
        {
            System.out.println(role);
        }
    }
}