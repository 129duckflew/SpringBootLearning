package cn.duckflew.mapper;

import cn.duckflew.entity.P;
import cn.duckflew.entity.PExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PMapper {
    int countByExample(PExample example);

    int deleteByExample(PExample example);

    int deleteByPrimaryKey(String pno);

    int insert(P record);

    int insertSelective(P record);

    List<P> selectByExample(PExample example);

    P selectByPrimaryKey(String pno);

    int updateByExampleSelective(@Param("record") P record, @Param("example") PExample example);

    int updateByExample(@Param("record") P record, @Param("example") PExample example);

    int updateByPrimaryKeySelective(P record);

    int updateByPrimaryKey(P record);
}