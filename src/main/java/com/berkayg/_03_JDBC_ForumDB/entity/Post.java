package com.berkayg._03_JDBC_ForumDB.entity;

public class Post {
    private Long id;
    private Long userid;
    private String title;
    private String content;
    private Long sharedDate;

    public Post() {
    }

    public Post(Long userid, String title, String content) {
        this.userid = userid;
        this.title = title;
        this.content = content;
        this.sharedDate = System.currentTimeMillis();
    }

    public Post(Long id, Long userid, String title, String content, Long sharedDate) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.content = content;
        this.sharedDate = sharedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String subject) {
        this.title = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSharedDate() {
        return sharedDate;
    }

    public void setSharedDate(Long sharedDate) {
        this.sharedDate = sharedDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", sharedDate=").append(sharedDate);
        sb.append('}');
        return sb.toString();
    }
}
