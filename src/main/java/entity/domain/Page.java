package entity.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = "Page.findPageById", query = "SELECT p FROM Page AS p WHERE p.id = ?1"),
        @NamedQuery(name = "Page.findPageByTitle", query = "SELECT p FROM Page AS p WHERE p.title LIKE '?1%'"),
        @NamedQuery(name = "Page.findAllPageByAuthorId", query = "SELECT p FROM Page AS p WHERE p.author = ?1"),
        @NamedQuery(name = "Page.findAll", query = "SELECT p FROM Page AS p")
})
public class Page
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long             id;
    private String           title;
    private String           content;
    
    @ManyToMany(targetEntity = Tag.class)
    @JoinTable(name = "page_tags", joinColumns =
    @JoinColumn(name = "page_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName="id"))
    private List<Tag>         tags;
    
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="author_id")
    private User author;
    
    public Page ()
    {
    }
    
    public Page (String title, String content, List<Tag> tags, User author)
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.author = author;
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
    
    public User getAuthor ()
    {
        return author;
    }
    
    public void setAuthor (User author)
    {
        this.author = author;
    }
}
