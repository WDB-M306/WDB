package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connector {

    EntityManagerFactory entityManagerFactory = null;

    public Connector(String persistenceUnit) {
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
    }

    public EntityManager getEntityManagerInstance() {
        return entityManagerFactory.createEntityManager();
    }
}
