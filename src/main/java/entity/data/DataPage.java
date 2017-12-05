package entity.data;

public class DataPage
{
    private long         id;
    private String       title;
    private String       content;
    private DataTag[]    dataTags;
    private Attachment[] attachments;
    private DataUser     author;
    
    public DataPage () {}
    
    public DataPage (String title, String content, DataTag[] dataTags, Attachment[] attachments, DataUser author)
    {
        this.title = title;
        this.content = content;
        this.dataTags = dataTags;
        this.attachments = attachments;
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
    
    public Attachment[] getAttachments ()
    {
        return attachments;
    }
    
    public void setAttachments (Attachment[] attachments)
    {
        this.attachments = attachments;
    }
    
    public DataUser getAuthorId ()
    {
        return author;
    }
    
    public void setAuthorId (DataUser author)
    {
        this.author = author;
    }
}
