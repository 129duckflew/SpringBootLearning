package cn.duckflew.shirospringbootlearning.mapper;

import cn.duckflew.shirospringbootlearning.entity.TRole;
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
        List<TRole> roles = tUserMapper.selectRolesByUserId("xiaochen");
        for (TRole role : roles)
        {
            System.out.println(role);
        }
    }
}