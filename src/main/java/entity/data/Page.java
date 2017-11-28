package entity.data;

public class Page
{
    private long       id;
    private String     title;
    private String     content;
    private DataTag[]  dataTags;
    private Attachment attachment;
    private User       author;
    
    public Page() {}
    
    public Page (String title, String content, DataTag[] dataTags, Attachment attachment, User author)
    {
        this.title = title;
        this.content = content;
        this.dataTags = dataTags;
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
    
    public DataTag[] getDataTags ()
    {
        return dataTags;
    }
    
    public void setDataTags (DataTag[] dataTags)
    {
        this.dataTags = dataTags;
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
