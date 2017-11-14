package persistence;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findUserById", query = "SELECT u FROM User AS u WHERE u.id = ?1"),
        @NamedQuery(name= "User.findUserByUsername", query = "SELECT u FROM User AS u WHERE u.username = ?1"),
        @NamedQuery(name = "User.findAllUserByDeactivated", query ="SELECT u FROM User AS u WHERE u.deactivated = ?1")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String username;

    private String password;
    private boolean deactivated;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isDeactivated() {
        return deactivated;
    }
    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }
}
