package entity.data;

public class DataTag
{
    private long   id;
    private String label;
    
    public DataTag (String label)
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
