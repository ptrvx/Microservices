package rs.edu.raf.msa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.msa.demo.domain.model.Post;

import java.util.List;

@Repository
public interface PostDao extends JpaRepository<Post, Long> {

    public Post getById(Long id);

    public List<Post> getPostsByUserIdOrderByDatetimeDesc(Long id);
}
