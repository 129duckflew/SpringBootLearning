package cn.duckflew.service;

import cn.duckflew.entity.TRole;
import cn.duckflew.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-07-08
 */
public interface TUserService extends IService<TUser> {


    String register(TUser tUser);

    List<TRole> getUserRolesByUsername(String username);
}
