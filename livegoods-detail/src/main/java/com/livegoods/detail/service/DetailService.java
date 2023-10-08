package com.livegoods.detail.service;

import com.livegoods.commons.pojo.Item;

// 查询商品服务接口
public interface DetailService {
    Item getDetails(String id);

}
