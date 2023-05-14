package AlgoritmicBlog.AlgoritmicBlog.BD;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long post_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String anons;

    @Column(name = "full_text", nullable = false)
    private String fullText;

    /*@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String tag;

    @Column(name = "created_data", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_data")
    private LocalDateTime updatedAt;*/

    // Constructors, getters and setters

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public Post() {
    }

    public Post(String title, String anons, String fullText) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
    }
}

