package com.livegoods.comment.dao;

import com.livegoods.commons.pojo.Comment;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface CommentDao {
    // 新增评论
    void save(Comment comment);

    List<Comment> findCommentByPageQuery(Query query);
}
