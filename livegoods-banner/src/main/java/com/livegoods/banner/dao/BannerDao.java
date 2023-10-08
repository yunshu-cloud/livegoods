package com.livegoods.banner.dao;

import com.livegoods.commons.pojo.Banner;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface BannerDao {
    List<Banner> selectBanners(Query query);
}
