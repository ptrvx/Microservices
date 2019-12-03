package rs.edu.raf.msa.Social.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.msa.Social.dao.UserDao;
import rs.edu.raf.msa.Social.domain.model.User;
import rs.edu.raf.msa.Social.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public User get(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    public User save(String name) {
        return userDao.save(new User(name));
    }

    @Override
    public Boolean delete(Long id) {
        try {
            userDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Integer follow(Long userId, Long followId) {
        return userDao.follow(userId, followId);
    }
}
