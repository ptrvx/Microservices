package rs.edu.raf.msa.demo.service;

import rs.edu.raf.msa.demo.domain.model.User;

public interface UserService {

    public User get(Long id);

    public User save(String name);

    public Boolean delete(Long id);

}
