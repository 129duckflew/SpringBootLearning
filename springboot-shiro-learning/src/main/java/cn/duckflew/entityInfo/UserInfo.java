package cn.duckflew.entityInfo;

import cn.duckflew.entity.TRole;
import lombok.Data;

import java.security.Permission;
import java.util.List;

@Data
public class UserInfo
{
    private int userId;
    private String username;
    private List<TRole> roles;
    private List<Permission> permissions;
}
