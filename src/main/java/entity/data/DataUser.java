package entity.data;

public class DataUser
{
    private long    id;
    private String  username;
    private boolean active;
    private long[]  pageIds;
    
    public DataUser (String username)
    {
        this.username = username;
    }
    
    public DataUser (long id, String username, boolean active)
    {
        this.id = id;
        this.username = username;
        this.active = active;
    }
    
    public DataUser (String username, boolean active)
    {
        this.username = username;
        this.active = active;
    }
    
    private long getId ()
    {
        return id;
    }
    
    private void setId (long id)
    {
        this.id = id;
    }
    
    private long[] getPageIds ()
    {
        return pageIds;
    }
    
    private void setPageIds (long[] pageIds)
    {
        this.pageIds = pageIds;
    }
    
    public String getUsername ()
    {
        return username;
    }
    
    public void setUsername (String username)
    {
        this.username = username;
    }
    
    public boolean isActive ()
    {
        return active;
    }
    
    public void setActive (boolean active)
    {
        this.active = active;
    }
}
