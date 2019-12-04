package rs.edu.raf.msa.Social.service;

import rs.edu.raf.msa.Social.domain.model.User;

public interface UserService {

    public User get(Long id);

    public User save(String name);

    public Boolean delete(Long id);

}
