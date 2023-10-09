package com.livegoods.comment.service.impl;

import com.livegoods.comment.dao.CommentDao;
import com.livegoods.comment.dao.OrderDao;
import com.livegoods.comment.service.CommentService;
import com.livegoods.commons.pojo.Comment;
import com.livegoods.commons.pojo.Order;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    public LivegoodsResult feelback(String orderId, String comment) {
        try {
//            Order order = orderDao.findById(orderId);
            Order order = new Order();
            order.setUsername("13312345678");
            order.setItemId("6522b92540ae6056f31651e1");

            //创建评论对象
            Comment commentObj = new Comment();
            commentObj.setUsername(order.getUsername());
            commentObj.setComment(comment);
            commentObj.setItemId(order.getItemId());
            commentObj.setStar(3);
            commentDao.save(commentObj);

            //更新订单里面的评论状态
            orderDao.updateCommentState(orderId,2);

            return LivegoodsResult.ok("添加评论成功");
        } catch (Exception exception) {
            exception.printStackTrace();
            return LivegoodsResult.error("添加评论失败");
        }
    }



}
