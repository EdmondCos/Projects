package tables;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import util.HibernateUtilities;

import static org.junit.Assert.*;

public class ItemCategoryTest {

    @Test
    public void addCategory() {
        Transaction transaction = null;

        try (SessionFactory factory = HibernateUtilities.getSessionFactory();
             Session session = factory.openSession()
        ) {
            transaction = session.beginTransaction();
            ItemCategory category = new ItemCategory();
            category.setName("Phones");

            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
        }
    }

}