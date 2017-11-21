package entity.domain;

public class PageEntity {

    private long id;
    private String title;
    private String contentLink;
    private String tags;
    private String attatchementLink;
    private long authorId;

    public PageEntity(String title, String contentLink, String tags, String attatchementLink, long authorId) {
        this.title = title;
        this.contentLink = contentLink;
        this.tags = tags;
        this.attatchementLink = attatchementLink;
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContentLink() {
        return contentLink;
    }
    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getAttatchementLink() {
        return attatchementLink;
    }
    public void setAttatchementLink(String attatchementLink) {
        this.attatchementLink = attatchementLink;
    }
    public long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
