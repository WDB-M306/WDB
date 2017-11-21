package persistence;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Page.findPageById", query = "SELECT p FROM Page AS p WHERE p.id = ?1"),
        @NamedQuery(name= "Page.findPageByTitle", query = "SELECT p FROM Page AS p WHERE p.title = ?1"),
        @NamedQuery(name= "Page.findPageByTags", query = "SELECT p FROM Page AS p WHERE p.tags = ?1"),
        @NamedQuery(name = "Page.findAllPageByAuthorId", query ="SELECT p FROM Page AS p WHERE p.authorId = ?1")
})
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String contentLink;
    private String tags;
    private String attatchementLink;
    private long authorId;

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
