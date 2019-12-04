package rs.edu.raf.msa.Social.service;

import rs.edu.raf.msa.Social.domain.model.Comment;

import java.util.List;

public interface CommentService {

    public Comment get(Long id);

    public Comment send(Long userId, Long postId, String content);

    public List<Comment> post(Long postId);

}
