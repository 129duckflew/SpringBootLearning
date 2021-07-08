package cn.duckflew.demo.mapper;

import cn.duckflew.demo.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-07-08
 */
@Component
public interface TUserMapper extends BaseMapper<TUser> {

    @Select("select * from t_user where username= #{principal}")
    TUser selectByUsername(String principal);
}
