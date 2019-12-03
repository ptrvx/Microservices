package rs.edu.raf.msa.Social.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rs.edu.raf.msa.Social.domain.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    public User findUserById(Long id);

    // TODO problem: multiple entries with same values
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO follow VALUES(:userId, :followId);", nativeQuery = true)
    public Integer follow(Long userId, Long followId);



}
