package com.livegoods.hotproduct.service;

import com.livegoods.commons.vo.LivegoodsResult;

public interface HotProductService {
    LivegoodsResult getHotProduct(String city);
}
