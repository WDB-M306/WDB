package api;

import entity.data.DataPage;
import entity.data.DataUser;
import entity.domain.Page;
import entity.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping("/user")
public class UserController extends Controller
{
    @Autowired
    private StandardPasswordEncoder passwordEncoder;
    
    @Bean
    public static StandardPasswordEncoder standardPasswordEncoder() {
        return new StandardPasswordEncoder();
    }
    
    public UserController (EntityManager em)
    {
        super(em);
    }
    
    @RequestMapping(method = GET)
    DataUser[] getUsers ()
    {
        Query query = em.createNamedQuery("User.findAllUserByActive", User.class);
        query.setParameter(1, true);
        
        if (query.getMaxResults() == 0) return new DataUser[0];
        
        List<User> userList  = query.getResultList();
        DataUser[] dataUsers = new DataUser[userList.size()];
        
        for (int i = 0; i < userList.size(); i++)
        {
            dataUsers[i] = dataFromDomain(userList.get(i));
        }
        
        return dataUsers;
    }
    
    public static DataUser dataFromDomain (User user)
    {
        return new DataUser(user.getId(), user.getUsername(), user.isActive());
    }
    
    @RequestMapping(method = GET, value = "/{userId}/page")
    public DataPage[] getPages(@PathVariable long userId)
    {
        User user = em.find(User.class, userId);
    
        Page[] pages = em.createNamedQuery("Page.findAllPageByAuthorId", Page.class).setParameter(1, user).getResultList().toArray(new Page[0]);
        
        DataPage[] dataPages = new DataPage[pages.length];
    
        for (int i = 0; i < pages.length; i++)
        {
            dataPages[i] = PageController.dataFromDomain(pages[i]);
        }
        
        return dataPages;
    }
    
    @RequestMapping(method = GET, value = "/{userId}")
    DataUser getUserById (@PathVariable long userId)
    {
        Query query = em.createNamedQuery("User.findUserById");
        query.setParameter(1, userId);
        
        User user = ((User) query.getSingleResult());
        
        return dataFromDomain(user);
    }
    
    @RequestMapping(method = POST)
    @Transactional
    public void createUser (@RequestBody NewUser newUser)
    {
        if (newUser == null)
        {
            return;
        }
        
        User user = new User(newUser.getUsername(), passwordEncoder.encode(newUser.getPassword()));
        em.persist(user);
    }
    
    @RequestMapping(method = PUT, value = "/{userId}")
    @Transactional
    public void updatePassword (
            @PathVariable long userId,
            @RequestBody PasswordChange pw, HttpSession session) throws Exception
    {
        User user = ((User) session.getAttribute("User"));
        
        if (user == null)
        {
            throw new Exception("User not logged in");
        }
        
        Query query = em.createNamedQuery("User.findUserById");
        query.setParameter(1, userId);
        
        User user1 = ((User) query.getSingleResult());
        
        if (passwordEncoder.matches(pw.getOldPassword(), user.getPassword()) && user.getId() == user1.getId())
        {
            user.setPassword(passwordEncoder.encode(pw.getNewPassword()));
            em.merge(user);
            
            session.setAttribute("User", user);
        }
        else
        {
            throw new Exception("Wrong password");
        }
    }
    
    @RequestMapping(method = DELETE, value = "/")
    @Transactional
    public void deleteUser(@RequestBody String password, HttpSession session) throws Exception
    {
        User user = ((User) session.getAttribute("User"));
    
        if (user == null)
        {
            throw new Exception("User not logged in");
        }
        
        if (passwordEncoder.matches(password, user.getPassword()))
        {
            Query query = em.createNamedQuery("User.findUserById");
            query.setParameter(1, user.getId());
    
            User user1 = ((User) query.getSingleResult());
            em.remove(user1);
            session.removeAttribute("User");
        }
        else
        {
            throw new Exception("Wrong password");
        }
    }
}

class NewUser
{
    private String username;
    private String password;
    
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
}

class PasswordChange
{
    private String oldPassword;
    private String newPassword;
    
    public String getOldPassword ()
    {
        return oldPassword;
    }
    
    public void setOldPassword (String oldPassword)
    {
        this.oldPassword = oldPassword;
    }
    
    public String getNewPassword ()
    {
        return newPassword;
    }
    
    public void setNewPassword (String newPassword)
    {
        this.newPassword = newPassword;
    }
}
