package cn.duckflew.demo.service;

import cn.duckflew.demo.entity.TUser;
import cn.duckflew.demo.mapper.TUserMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

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
}
