package cn.duckflew.springbootlearning.service;

import cn.duckflew.springbootlearning.entity.TRole;
import cn.duckflew.springbootlearning.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
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
