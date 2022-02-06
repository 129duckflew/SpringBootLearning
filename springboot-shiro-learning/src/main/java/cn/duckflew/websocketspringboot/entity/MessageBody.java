package cn.duckflew.websocketspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBody
{
    private String content;
    private String from;
    private String to;
}
