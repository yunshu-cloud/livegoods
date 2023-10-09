package com.livegoods.comment.dao.impl;

import com.livegoods.comment.dao.CommentDao;
import com.livegoods.commons.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增评论
     * @param comment
     */
    @Override
    public void save(Comment comment) {
        mongoTemplate.save(comment);
    }

    @Override
    public List<Comment> findCommentByPageQuery(Query query) {
        return mongoTemplate.find(query,Comment.class);
    }
}
