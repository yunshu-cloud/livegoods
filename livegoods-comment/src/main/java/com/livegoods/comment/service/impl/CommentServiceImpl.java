package com.livegoods.comment.service.impl;

import com.livegoods.comment.dao.CommentDao;
import com.livegoods.comment.dao.OrderDao;
import com.livegoods.comment.service.CommentService;
import com.livegoods.commons.pojo.Comment;
import com.livegoods.commons.pojo.Order;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 分页查询
     * @param itemId
     * @param page
     * @param rows
     * @return
     */
    @Override
    public LivegoodsResult findCommentByItemId(String itemId, int page, int rows) {
        Query query = new Query();
        query.addCriteria(Criteria.where("itemId").is(itemId));
        query.with(PageRequest.of(page,rows));

        // 分页查询
        List<Comment> commentByPageQuery = commentDao.findCommentByPageQuery(query);
        long count = commentByPageQuery==null?0:commentByPageQuery.size();
        // 隐藏用户名，手机号
        for (Comment comment : commentByPageQuery) {
            String username = comment.getUsername().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
            comment.setUsername(username);
        }
        LivegoodsResult result = LivegoodsResult.ok(commentByPageQuery);

        // 计算总页数
        long totalPages = (count % rows == 0) ? (count / rows) : (count / rows + 1);
        if((page+1)<totalPages){
            result.setHasMore(true);
        }else{
            result.setHasMore(false);
        }
        return result;
    }


}
