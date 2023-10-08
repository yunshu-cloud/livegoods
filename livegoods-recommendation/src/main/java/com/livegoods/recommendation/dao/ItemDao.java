package com.livegoods.recommendation.dao;

import com.livegoods.commons.pojo.Item;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface ItemDao {
    List<Item> selectRecommendation(Query query);
}
