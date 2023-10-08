package com.livegoods.detail.controller;

import com.livegoods.commons.pojo.Item;
import com.livegoods.detail.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailController {
    @Autowired
    private DetailService detailService;

    /**
     * 根据商品id查询商品详情
     * @param id
     * @return
     */
    @GetMapping("/details")
    public Item findDetails(String id){
        Item item = detailService.getDetails(id);
        return item;
    }
}
