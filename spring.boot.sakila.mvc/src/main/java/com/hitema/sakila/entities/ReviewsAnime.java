package com.hitema.sakila.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reviews_anime", schema = "goodreads", catalog = "")
public class ReviewsAnime {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "anime_id")
    private Animes anime;
    @Basic
    @Column(name = "review", nullable = true, length = -1)
    private String review;
    @Basic
    @Column(name = "note", nullable = true)
    private Integer note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }


}
