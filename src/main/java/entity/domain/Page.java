package entity.domain;

import sun.management.ThreadInfoCompositeData;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = "Page.findPageById", query = "SELECT p FROM Page AS p WHERE p.id = ?1"),
        @NamedQuery(name = "Page.findPageByTitle", query = "SELECT p FROM Page AS p WHERE p.title LIKE '?1%'"),
        @NamedQuery(name = "Page.findAllPageByAuthorId", query = "SELECT p FROM Page AS p WHERE p.authorId = ?1"),
        @NamedQuery(name = "Page.findAll", query = "SELECT p FROM Page AS p")
})
public class Page
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long             id;
    private String           title;
    private String           content;
    @OneToMany(targetEntity = Tag.class)
    private List<Tag>        tags;
    @OneToMany(targetEntity = Attachment.class)
    private List<Attachment> attachments;
    private long             authorId;
    
    public Page ()
    {
    }
    
    public Page (String title, String content, List<Tag> tags, long authorId)
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.authorId = authorId;
        this.attachments = new ArrayList<>();
    }
    
    public long getId ()
    {
        return id;
    }
    
    public void setId (long id)
    {
        this.id = id;
    }
    
    public String getTitle ()
    {
        return title;
    }
    
    public void setTitle (String title)
    {
        this.title = title;
    }
    
    public String getContent ()
    {
        return content;
    }
    
    public void setContent (String content)
    {
        this.content = content;
    }
    
    public List<Tag> getTags ()
    {
        return tags;
    }
    
    public void setTags (List<Tag> tags)
    {
        this.tags = tags;
    }
    
    public List<Attachment> getAttachments ()
    {
        return attachments;
    }
    
    public void setAttachments (List<Attachment> attachments)
    {
        this.attachments = attachments;
    }
    
    public long getAuthorId ()
    {
        return authorId;
    }
    
    public void setAuthorId (long authorId)
    {
        this.authorId = authorId;
    }
}
