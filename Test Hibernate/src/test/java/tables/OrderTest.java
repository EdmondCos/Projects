package tables;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import util.HibernateUtilities;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class OrderTest {
    @Test
    public void addOrder() {
        Transaction transaction = null;

        try (SessionFactory factory = HibernateUtilities.getSessionFactory();
             Session session = factory.openSession()
        ) {
            transaction = session.beginTransaction();

            Order order = new Order();
            order.setCreatedDate(LocalDate.now());
            Customer customer = session.load(Customer.class, 1L);
            order.setCustomer(customer);

            Set<Item> items = new HashSet<>();
            long l = 1;
            while (true) {
                try {
                    Item item = session.load(Item.class, l++);
                    item.getName();
                    items.add(item);
                } catch (ObjectNotFoundException e) {
                    break;
                }
            }
            order.setItems(items);

            double value = 0;
            for (Item i : items) {
                value = value + i.getPrice();
            }
            order.setValue(value);

            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
        }
    }

}