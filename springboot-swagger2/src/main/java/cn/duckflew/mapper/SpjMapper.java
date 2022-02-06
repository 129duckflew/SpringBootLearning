package cn.duckflew.mapper;

import cn.duckflew.entity.Spj;
import cn.duckflew.entity.SpjExample;
import cn.duckflew.entity.SpjKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpjMapper {
    int countByExample(SpjExample example);

    int deleteByExample(SpjExample example);

    int deleteByPrimaryKey(SpjKey key);

    int insert(Spj record);

    int insertSelective(Spj record);

    List<Spj> selectByExample(SpjExample example);

    Spj selectByPrimaryKey(SpjKey key);

    int updateByExampleSelective(@Param("record") Spj record, @Param("example") SpjExample example);

    int updateByExample(@Param("record") Spj record, @Param("example") SpjExample example);

    int updateByPrimaryKeySelective(Spj record);

    int updateByPrimaryKey(Spj record);
}