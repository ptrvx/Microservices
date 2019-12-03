package rs.edu.raf.msa.Social.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "following", fetch = FetchType.LAZY)
    private List<User> followers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="follow")
    private List<User> following;

    public User() {
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public User(String name) {
        this();
        this.name = name;
    }



}
