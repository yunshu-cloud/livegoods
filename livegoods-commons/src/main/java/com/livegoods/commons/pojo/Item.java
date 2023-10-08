package com.livegoods.commons.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Item {
    // 商品id
    private String id;

    // 商品标题
    private String title;

    // 商品销量
    private Long sales;

    // 是否为推荐商品
    private Boolean recommendation;

    // 商品价格
    private Long price;

    // 城市
    private String city;

    // 租赁方式-整租/合租
    private String rentType;

    //房屋类型
    private String houseType;

    // 房屋图片
    private List<String> imgs;

    // 预定时间
    private Date buytime;

    // 是否出租
    private Boolean isRented;

    //热门排序|权重，数学
    private Byte recoSort;

    // 房屋特性， Map集合。集合存储数据内容为： years: "建造年份", type: "房屋类型，几室几厅", level: "所在楼层", style: "装修标准", orientation: "房屋朝向"
    private Map<String, String> info;
}
