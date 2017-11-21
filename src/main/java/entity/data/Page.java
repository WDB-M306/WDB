package entity.data;

public class Page
{
    private long       id;
    private String     title;
    private String     content;
    private Tag[]      tags;
    private Attachment attachment;
    private User       author;
    
    public Page() {}
    
    public Page (String title, String content, Tag[] tags, Attachment attachment, User author)
    {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.attachment = attachment;
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
    
    public Tag[] getTags ()
    {
        return tags;
    }
    
    public void setTags (Tag[] tags)
    {
        this.tags = tags;
    }
    
    public Attachment getAttachment ()
    {
        return attachment;
    }
    
    public void setAttachment (Attachment attachment)
    {
        this.attachment = attachment;
    }
    
    public User getAuthorId ()
    {
        return author;
    }
    
    public void setAuthorId (User author)
    {
        this.author = author;
    }
}
