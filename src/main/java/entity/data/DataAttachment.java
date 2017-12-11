package entity.data;

import java.util.Date;


public class DataAttachment
{
    private long   id;
    private String fileName;
    private long   size;
    private Date   date;
    
    public DataAttachment (String fileName)
    {
        this.fileName = fileName;
    }
    
    public DataAttachment (String fileName, long size, Date date)
    {
        this.fileName = fileName;
        this.size = size;
        this.date = date;
    }
    
    public long getId ()
    {
        return id;
    }
    
    public void setId (long id)
    {
        this.id = id;
    }
    
    public String getFileName ()
    {
        return fileName;
    }
    
    public void setFileName (String fileName)
    {
        this.fileName = fileName;
    }
    
    public long getSize ()
    {
        return size;
    }
    
    public void setSize (long size)
    {
        this.size = size;
    }
    
    public Date getDate ()
    {
        return date;
    }
    
    public void setDate (Date date)
    {
        this.date = date;
    }
}
