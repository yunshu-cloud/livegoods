package com.livegoods.detail.dao;

import com.livegoods.commons.pojo.Item;

// 查询商品详情
public interface ItemDao {
    Item findItemById(String id);
}
