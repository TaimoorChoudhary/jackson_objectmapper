package model;

import java.util.StringJoiner;

/**
 * @author Taimoor Choudhary
 */
public class Post {
    private Long userId;
    private Long id;
    private String title;
    private String body;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Post.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("body='" + body + "'")
                .toString();
    }
}
