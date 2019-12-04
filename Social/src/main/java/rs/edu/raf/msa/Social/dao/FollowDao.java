package rs.edu.raf.msa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.edu.raf.msa.demo.domain.model.Follow;
import rs.edu.raf.msa.demo.domain.model.User;

import java.util.Collection;
import java.util.List;

public interface FollowDao extends JpaRepository<Follow, Long> {

    public List<Follow> findFollowsByFollowedId(Long id);

    public List<Follow> findFollowsByFollowerId(Long id);
}
