package entity.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Page.findPageById", query = "SELECT p FROM Page AS p WHERE p.id = ?1"),
        @NamedQuery(name= "Page.findPageByTitle", query = "SELECT p FROM Page AS p WHERE p.title LIKE '?1%'"),
        @NamedQuery(name = "Page.findAllPageByAuthorId", query ="SELECT p FROM Page AS p WHERE p.authorId = ?1")
})
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long         id;
    private String       title;
    private String       content;
    private Tag[]        tags;
    private Attachment[] attachments;
    private long         authorId;
    
    private Page ()
    {
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
    public String getContent () {
        return content;
    }
    public void setContent (String content) {
        this.content = content;
    }
    public Tag[] getTags() {
        return tags;
    }
    public void setTags(Tag[] tags) {
        this.tags = tags;
    }
    public Attachment[] getAttachments () {
        return attachments;
    }
    public void setAttachments (Attachment[] attachments) {
        this.attachments = attachments;
    }
    public long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
