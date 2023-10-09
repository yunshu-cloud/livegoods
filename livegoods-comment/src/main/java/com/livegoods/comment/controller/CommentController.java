package com.livegoods.comment.controller;

import com.livegoods.comment.service.CommentService;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 新增评论
     * @param orderId
     * @param comment
     * @return
     */
    @PostMapping("/feelback")
    public LivegoodsResult feelback(String orderId,String comment){
        return commentService.feelback(orderId,comment);
    }
}
