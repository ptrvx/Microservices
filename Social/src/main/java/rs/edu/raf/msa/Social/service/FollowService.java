package rs.edu.raf.msa.demo.service;

import rs.edu.raf.msa.demo.domain.model.User;

import java.util.List;

public interface FollowService {

    public Boolean follow(Long id, Long followId);

    public List<User> getFollowing(Long id);

    public List<User> getFollowers(Long id);

}
