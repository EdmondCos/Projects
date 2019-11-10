package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilities {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder()
                        .configure() // searches and configures settings from hibernate.cfg.xml
                        .build();
                // Create session factory
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
