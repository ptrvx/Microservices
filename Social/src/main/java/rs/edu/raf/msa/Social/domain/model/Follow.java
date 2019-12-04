package rs.edu.raf.msa.demo.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Follow {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower")
    private User follower;

    @ManyToOne
    @JoinColumn(name = "followed")
    private User followed;

    public Follow() {
    }
    public Follow(User follower, User followed) {
        this.follower = follower;
        this.followed = followed;
    }
    public Follow(Long id, User follower, User followed) {
        this.id = id;
        this.follower = follower;
        this.followed = followed;
    }
}
