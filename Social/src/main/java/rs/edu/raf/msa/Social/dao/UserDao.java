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

    // TODO problem: multiple entries with same values -- solved: nativeQuery, koristim from user jer follow tabela moze biti prazna a user ne
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO follow SELECT DISTINCT :userId, :followId FROM user WHERE NOT EXISTS(SELECT 1 FROM follow WHERE followers_id=:userId AND following_id=:followId);", nativeQuery = true)
    public Integer follow(Long userId, Long followId);

}
