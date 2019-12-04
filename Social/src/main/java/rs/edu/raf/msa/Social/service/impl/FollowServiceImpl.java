package rs.edu.raf.msa.Social.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.msa.Social.dao.FollowDao;
import rs.edu.raf.msa.Social.dao.UserDao;
import rs.edu.raf.msa.Social.domain.model.Follow;
import rs.edu.raf.msa.Social.domain.model.User;
import rs.edu.raf.msa.Social.service.FollowService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    private FollowDao followDao;
    private UserDao userDao;

    @Autowired
    public FollowServiceImpl(FollowDao followDao, UserDao userDao) {
        this.followDao = followDao;
        this.userDao = userDao;
    }

    @Override
    public Boolean follow(Long id, Long followId) {
        User follower = userDao.findUserById(id);
        User followed = userDao.findUserById(followId);

        if (follower == null || followed == null)
            return false;

        this.followDao.save(new Follow(follower, followed));
        return true;
    }

    @Override
    public List<User> getFollowing(Long id) {
        List<User> col = new ArrayList<>();

        for (Follow f : followDao.findFollowsByFollowerId(id)) {
            col.add(f.getFollowed());
        }
        return col;
    }

    @Override
    public List<User> getFollowers(Long id) {
        List<User> col = new ArrayList<>();

        for (Follow f : followDao.findFollowsByFollowedId(id)) {
            col.add(f.getFollower());
        }
        return col;
    }
}
