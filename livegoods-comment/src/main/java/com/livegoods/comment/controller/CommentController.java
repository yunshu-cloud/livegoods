package com.livegoods.comment.controller;

import com.livegoods.comment.service.CommentService;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    // 分页查询商品评论
    @GetMapping("/comment")
    public LivegoodsResult getCommentByItemId(@RequestParam(value = "id") String itemId,int page,@RequestParam(defaultValue = "5")int rows){
        return commentService.findCommentByItemId(itemId,page,rows);
    }
}
