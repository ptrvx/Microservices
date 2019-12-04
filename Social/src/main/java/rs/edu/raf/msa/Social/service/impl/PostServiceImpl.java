package rs.edu.raf.msa.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.msa.demo.dao.PostDao;
import rs.edu.raf.msa.demo.domain.model.Post;
import rs.edu.raf.msa.demo.domain.model.User;
import rs.edu.raf.msa.demo.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostDao postDao;

    @Autowired
    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Post get(Long id) {
        return postDao.getById(id);
    }

    @Override
    public Post post(Long userId, String content) {
        return postDao.save(new Post(content, new User(userId)));
    }

    @Override
    public List<Post> user(Long id) {
        return postDao.getPostsByUserIdOrderByDatetimeDesc(id);
    }
}
