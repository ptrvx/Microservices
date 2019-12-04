package rs.edu.raf.msa.Social.service;

import rs.edu.raf.msa.Social.domain.model.Post;

import java.util.List;

public interface PostService {

    public Post get(Long id);

    public Post post(Long userId, String content);

    public List<Post> user(Long id);

}
