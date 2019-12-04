package rs.edu.raf.msa.demo.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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

    public User() {
        super();
    }

    public User(String name) {
        this();
        this.name = name;
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

}
