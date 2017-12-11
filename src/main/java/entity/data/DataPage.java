package entity.data;

public class DataPage
{
    private long             id;
    private String           title;
    private String           content;
    private DataTag[]        dataTags;
    private DataAttachment[] dataAttachments;
    private long         author;
    
    public DataPage () {}
    
    public DataPage (String title, String content, DataTag[] dataTags, DataAttachment[] dataAttachments, long author)
    {
        this.title = title;
        this.content = content;
        this.dataTags = dataTags;
        this.dataAttachments = dataAttachments;
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
    
    public DataAttachment[] getDataAttachments ()
    {
        return dataAttachments;
    }
    
    public void setDataAttachments (DataAttachment[] dataAttachments)
    {
        this.dataAttachments = dataAttachments;
    }
    
    public long getAuthor ()
    {
        return author;
    }
    
    public void setAuthor (long author)
    {
        this.author = author;
    }
}
