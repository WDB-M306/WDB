package entity.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@NamedQueries({@NamedQuery(name = "User.findUserById", query = "SELECT u FROM User AS u WHERE u.id = ?1"), @NamedQuery(
        name = "User.findUserByUsername",
        query = "SELECT u FROM User AS u WHERE u.username = ?1"), @NamedQuery(name = "User.findAllUserByActive",
        query = "SELECT u FROM User AS u WHERE u.active = ?1")})
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long    id;
    @Column(unique = true)
    private String  username;
    private String  password;
    private boolean active;
    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date last_changed;
    
    public Date getLast_changed ()
    {
        return last_changed;
    }
    
    public void setLast_changed (Date last_changed)
    {
        this.last_changed = last_changed;
    }
    
    @OneToMany(mappedBy = "author")
    private List<Page> pages;
    
    public User(){}
    
    public User (String username, String password)
    {
        this.username = username;
        this.password = password;
        this.active = true;
    }
    
    public long getId ()
    {
        return id;
    }
    
    public void setId (long id)
    {
        this.id = id;
    }
    
    public String getUsername ()
    {
        return username;
    }
    
    public void setUsername (String username)
    {
        this.username = username;
    }
    
    public String getPassword ()
    {
        return password;
    }
    
    public void setPassword (String password)
    {
        this.password = password;
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
