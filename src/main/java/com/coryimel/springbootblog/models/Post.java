package com.coryimel.springbootblog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue
    private Long id;
//    @Column(nullable = false, length = 100)
    private String title;
//    @Column(nullable = false)
    private String body;


    public Long getId() {
        return id;
    }

    public void setId(Long idIn) {
        id = idIn;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
