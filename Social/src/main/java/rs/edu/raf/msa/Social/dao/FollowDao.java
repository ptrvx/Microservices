package rs.edu.raf.msa.Social.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.edu.raf.msa.Social.domain.model.Follow;

import java.util.List;

public interface FollowDao extends JpaRepository<Follow, Long> {

    public List<Follow> findFollowsByFollowedId(Long id);

    public List<Follow> findFollowsByFollowerId(Long id);
}
