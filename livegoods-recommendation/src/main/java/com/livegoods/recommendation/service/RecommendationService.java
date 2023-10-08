package com.livegoods.recommendation.service;

import com.livegoods.commons.vo.LivegoodsResult;

public interface RecommendationService {
    // 查询热门推荐商品信息，查询条件是所在城市
    LivegoodsResult getRecommendation(String city);
}
