package cn.duckflew.shirospringbootlearning.service;

import cn.duckflew.shirospringbootlearning.entity.TRole;
import cn.duckflew.shirospringbootlearning.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.management.relation.Role;
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

    TUser findById(int id);

    String register(TUser tUser);

    List<TRole> getUserRoles(String username);
}
