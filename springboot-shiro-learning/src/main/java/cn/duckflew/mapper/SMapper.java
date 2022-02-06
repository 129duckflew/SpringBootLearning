package cn.duckflew.mapper;

import cn.duckflew.entity.S;
import cn.duckflew.entity.SExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SMapper {
    int countByExample(SExample example);

    int deleteByExample(SExample example);

    int deleteByPrimaryKey(String sno);

    int insert(S record);

    int insertSelective(S record);

    List<S> selectByExample(SExample example);

    S selectByPrimaryKey(String sno);

    int updateByExampleSelective(@Param("record") S record, @Param("example") SExample example);

    int updateByExample(@Param("record") S record, @Param("example") SExample example);

    int updateByPrimaryKeySelective(S record);

    int updateByPrimaryKey(S record);
}