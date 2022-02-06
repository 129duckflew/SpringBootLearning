package cn.duckflew.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    /**
     * 用户名
     */
    String username;
    /**
     * 密码
     */
    String password;

    /**
     * 权限
     * @ignore
     */
    List<String> roles;
}
