package com.livegoods.comment.dao.impl;

import com.livegoods.comment.dao.CommentDao;
import com.livegoods.commons.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

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
}
