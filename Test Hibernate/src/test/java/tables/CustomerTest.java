package tables;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import util.HibernateUtilities;

public class CustomerTest {

    @Test
    public void addCustomer() {
        Transaction transaction = null;

        try (SessionFactory factory = HibernateUtilities.getSessionFactory();
             Session session = factory.openSession()
        ) {
            transaction = session.beginTransaction();

            Customer customer = new Customer();
            customer.setFirstName("Mihai");
            customer.setLastName("Andrei");

            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
        }
    }
}