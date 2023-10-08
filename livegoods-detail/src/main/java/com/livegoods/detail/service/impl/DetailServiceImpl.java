package com.livegoods.detail.service.impl;

import com.livegoods.commons.pojo.Item;
import com.livegoods.detail.dao.ItemDao;
import com.livegoods.detail.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private ItemDao itemDao;

    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;


    @Cacheable(cacheNames = "com:livegoods:details",key = "'getDetails('+#id+')'")
    @Override
    public Item getDetails(String id) {
        // 根据主键查询
        Item item = itemDao.findItemById(id);

        // 把图片的相对路径改成绝对路径
        ArrayList<String> imgs = new ArrayList<>();
        for (String img : item.getImgs()){
            imgs.add(nginxPrefix+img);
        }

        item.setImgs(imgs);

        return item;
    }
}
