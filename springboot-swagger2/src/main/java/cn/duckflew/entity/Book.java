package cn.duckflew.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("书籍实体类")
public class Book {
    @ApiModelProperty(value = "id",name="编号" ,required = true,example = "35",hidden = false)
    private Integer id;

    @ApiModelProperty(value = "书名",name="书名" ,required = true,example = "黄金时代",hidden = false)
    private String name;

    @ApiModelProperty(value = "作者",name="作者" ,required = true,example = "王小波",hidden = false)
    private String author;

}