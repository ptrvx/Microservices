package rs.edu.raf.msa.Social.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.msa.Social.domain.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    public User findUserById(Long id);


}
