package com.livegoods.recommendation.dao.impl;

import com.livegoods.commons.pojo.Item;
import com.livegoods.recommendation.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Item> selectRecommendation(Query query) {
        return mongoTemplate.find(query, Item.class);
    }
}
