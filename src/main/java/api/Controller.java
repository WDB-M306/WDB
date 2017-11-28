package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class Controller {

    protected EntityManager em;

    public Controller(EntityManager em) {
        this.em = em;
    }
}
