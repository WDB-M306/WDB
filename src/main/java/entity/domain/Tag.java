package entity.domain;

import org.springframework.web.servlet.tags.form.SelectTag;

import javax.persistence.*;


@Entity
@NamedQueries({
        @NamedQuery(name = "Tag.findTagById", query = "SELECT t FROM Tag AS t WHERE t.id = ?1"),
        @NamedQuery(name = "Tag.findTagByName", query = "SELECT t FROM Tag AS t WHERE t.name = ?1"),
        @NamedQuery(name = "Tag.selectAll", query = "SELECT t FROM TAG AS t")
})
public class Tag
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long   id;
    private String name;
    private String entries;
    
    public Tag (String name)
    {
        this.name = name;
    }
    
    public long getId ()
    {
        return id;
    }
    
    public void setId (long id)
    {
        this.id = id;
    }
    
    public String getName ()
    {
        return name;
    }
    
    public void setName (String name)
    {
        this.name = name;
    }
    
    public String getEntries ()
    {
        return entries;
    }
    
    public void setEntries (String entries)
    {
        this.entries = entries;
    }
}
