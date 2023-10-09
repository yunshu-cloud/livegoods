package com.livegoods.comment.dao;

public interface OrderDao {
    void updateCommentState(String orderId,int commentState);
}
