package rs.edu.raf.msa.Social.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // TODO Problem: Recursive calls for nested users
    @ManyToMany(mappedBy = "following", fetch = FetchType.LAZY)
    private Set<User> followers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="follow")
    private Set<User> following;

    public User() {
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
    }

    public User(String name) {
        this();
        this.name = name;
    }



}
