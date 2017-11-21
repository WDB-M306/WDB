package entity.data;

public class Tag
{
    private long   id;
    private String label;
    
    public Tag (String label)
    {
        this.label = label;
    }
    
    public long getId ()
    {
        return id;
    }
    
    public void setId (long id)
    {
        this.id = id;
    }
    
    public String getLabel ()
    {
        return label;
    }
    
    public void setLabel (String label)
    {
        this.label = label;
    }
}
