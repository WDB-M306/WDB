package entity.data;

public class User
{
    private long    id;
    private String  username;
    private boolean active;
    private long[]  pageIds;
    
    public User (String username)
    {
        this.username = username;
    }
    
    public User (String username, boolean active)
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
