package com.livegoods.commons.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Comment {
    //用户名
    private String username;

    //评论内容
    private String comment;

    //评分
    private int star;

    //商品Id
    private String itemId;
}
