package api;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Component
public class Controller {
    
    @PersistenceContext
    protected EntityManager em;

    public Controller(EntityManager em) {
        this.em = em;
    }
}
