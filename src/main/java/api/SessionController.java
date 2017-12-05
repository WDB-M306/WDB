package api;


import entity.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class SessionController extends Controller
{
    @Autowired
    StandardPasswordEncoder passwordEncoder;
    
    public SessionController (EntityManager em)
    {
        super(em);
    }
    
    @RequestMapping(method = POST, value = "/login")
    public void login(@RequestBody Login login, HttpSession session) throws Exception
    {
        if (login == null)
        {
            return;
        }
    
        if (session.getAttribute("User") != null)
        {
            throw new Exception("Already logged in");
        }
    
        User user = em.createNamedQuery("User.findUserByUsername", User.class).setParameter(1, login.getUsername()).getSingleResult();
    
        if (user == null)
        {
            throw new Exception("Invalid credentials");
        }
        
        if (passwordEncoder.matches(login.getPassword(), user.getPassword()))
        {
            session.setAttribute("User", user);
        }
        else
        {
            throw new Exception("Invalid credentials");
        }
    }
    
    @RequestMapping(method = POST, value = "/logout")
    public void logout(HttpSession session)
    {
        session.removeAttribute("User");
    }
}

class Login
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