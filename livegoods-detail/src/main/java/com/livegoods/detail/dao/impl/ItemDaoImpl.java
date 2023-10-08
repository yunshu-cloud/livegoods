package com.livegoods.detail.dao.impl;

import com.livegoods.commons.pojo.Item;
import com.livegoods.detail.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Item findItemById(String id) {
        return mongoTemplate.findById(id, Item.class);
    }
}
