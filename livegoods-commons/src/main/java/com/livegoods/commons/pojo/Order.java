package com.livegoods.commons.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Order {
    // 订单id
    private String id;

    // 用户手机号作为用户名
    private String username;

    //商品主键
    private String itemId;

    // 商品标题
    private String title;

    // 房屋类型
    private String houseType;

    // 租赁方式
    private String rentType;

    // 价格
    private String price;

    // 图片
    private String img;

    // 评论状态
    private int commentState;
}
