package com.livegoods.hotproduct.dao;

import com.livegoods.commons.pojo.Item;

import java.util.List;
import org.springframework.data.mongodb.core.query.Query;

public interface ItemDao {
    List<Item> getHotProduct(Query query);
}
