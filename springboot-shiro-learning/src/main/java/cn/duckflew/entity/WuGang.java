package cn.duckflew.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("wugang")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WuGang
{

    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
}
