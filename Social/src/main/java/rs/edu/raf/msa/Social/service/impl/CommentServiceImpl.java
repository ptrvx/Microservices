package rs.edu.raf.msa.Social.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.msa.Social.dao.CommentDao;
import rs.edu.raf.msa.Social.domain.model.Comment;
import rs.edu.raf.msa.Social.domain.model.Post;
import rs.edu.raf.msa.Social.domain.model.User;
import rs.edu.raf.msa.Social.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public Comment get(Long id) {
        return commentDao.getById(id);
    }

    @Override
    public Comment send(Long userId, Long postId, String content) {
        return commentDao.save(new  Comment(new User(userId), new Post(postId), content));
    }

    @Override
    public List<Comment> post(Long postId) {
        return commentDao.getCommentsByPostIdOrderByDatetimeDesc(postId);
    }
}
