package com.livegoods.comment.service;

import com.livegoods.commons.vo.LivegoodsResult;

// 商品评论服务类
public interface CommentService {
    LivegoodsResult feelback(String orderId,String comment);
    LivegoodsResult findCommentByItemId(String itemId,int page,int rows);
}
