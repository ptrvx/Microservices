package rs.edu.raf.msa.demo.domain.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    public Comment() {
    }

    public Comment(User user, Post post, String content) {
        this.content = content;
        this.user = user;
        this.post = post;
        this.datetime = LocalDateTime.now();
    }


}
