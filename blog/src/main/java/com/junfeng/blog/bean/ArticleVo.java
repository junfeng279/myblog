package com.junfeng.blog.bean;

/**
 * @Author junfeng
 * @Date 2018/8/9 0:11
 * Created by adminstor on 2018/8/9.
 */
public class ArticleVo {
    private Integer cid;

    private String title;

    private String slug;

    private double created;

    private double modified;

    private String content;

    private Integer authorId;

    private String authorName;

    private String type;

    private String status;

    private String tags;

    private String categories;

    private Integer commentsNum;

    private Integer hit;

    private boolean allowComment;

    private boolean allowPing;

    private boolean allowFeed;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public double getModified() {
        return modified;
    }

    public void setModified(double modified) {
        this.modified = modified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public boolean isAllowComment() {
        return allowComment;
    }

    public void setAllowComment(boolean allowComment) {
        this.allowComment = allowComment;
    }

    public boolean isAllowPing() {
        return allowPing;
    }

    public void setAllowPing(boolean allowPing) {
        this.allowPing = allowPing;
    }

    public boolean isAllowFeed() {
        return allowFeed;
    }

    public void setAllowFeed(boolean allowFeed) {
        this.allowFeed = allowFeed;
    }
}
