package cn.duckflew.shirospringbootlearning.mapper;

import cn.duckflew.shirospringbootlearning.entity.TRole;
import cn.duckflew.shirospringbootlearning.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
import java.util.List;

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

//    @Results(
//          value = {
//                  @Result(column = "r.id" ,property = "id", id = true),
//                  @Result(column = "r.name", property = "name")
//          }
//    )
    @Select("SELECT r.id,r.name FROM t_user u LEFT JOIN t_user_role ur ON u.id = ur.`user_id` LEFT JOIN t_role r ON r.`id` = ur.`role_id` where u.username=#{username} ")
    List<TRole> selectRolesByUserId(String  username);
}
