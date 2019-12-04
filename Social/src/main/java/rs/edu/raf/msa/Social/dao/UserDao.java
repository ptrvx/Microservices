package rs.edu.raf.msa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.msa.demo.domain.model.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    public User findUserById(Long id);


}
