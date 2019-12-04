package rs.edu.raf.msa.demo.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    private User user;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @OneToMany
    private List<Comment> comments;

    public Post() {
    }

    public Post(Long id) {
        this.id = id;
    }

    public Post(String content, User user) {
        this.content = content;
        this.user = user;
        this.datetime = LocalDateTime.now();
        this.comments = new ArrayList<>();
    }


}
