package com.livegoods.banner.service.impl;

import com.livegoods.banner.dao.BannerDao;
import com.livegoods.banner.service.BannerService;
import com.livegoods.commons.pojo.Banner;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;

    @Override
    public LivegoodsResult getBanners() {
        LivegoodsResult result = new LivegoodsResult();
        try{
            Query query = new Query();
            query.with(PageRequest.of(0,4));
            List<Banner> banners = bannerDao.selectBanners(query);
            result.setStatus(200);

            ArrayList<Object> imageResults = new ArrayList<>();
            for (Banner banner : banners) {
                imageResults.add(nginxPrefix+banner.getUrl());
            }
            result.setResults(imageResults);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(500);
            result.setMsg("轮播图查询失败");
        }
        return result;
    }
}
