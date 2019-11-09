package tables;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import util.HibernateUtilities;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void addItem() {
        Transaction transaction = null;

        try (SessionFactory factory = HibernateUtilities.getSessionFactory();
             Session session = factory.openSession()
        ) {
            transaction = session.beginTransaction();

            ItemCategory category = session.load(ItemCategory.class, 1L);
            Item item = new Item();
            item.setCategory(category);
            item.setName("Samsung");
            item.setPrice(5555.55);

            session.save(item);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
        }
    }

}