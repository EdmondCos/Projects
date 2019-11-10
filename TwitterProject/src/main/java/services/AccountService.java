package services;

import dao.AccountRepository;
import entities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.HibernateUtilities;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.*;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;


    public Set<Account> getAllAccounts() {
        Set<Account> results = new HashSet<>();
        for (Account account : accountRepository.findAll()) {
            results.add(account);
        }
        return results;
    }

    public Account getAccount(String email) {
        return accountRepository.findById(email).get();
    }

    public boolean saveNewAccount(Account account) {
        try {
            accountRepository.findById(account.getEmail()).get();
        } catch (java.util.NoSuchElementException e) {
            try {
                accountRepository.save(account);
            } catch (Exception ex) {
                return false;
            }
            modifyDatabase(account, true);
            return true;
        }
        return false;
    }

    public boolean exisitsAccount(Account account) {
        Account exisiting;
        try {
            exisiting = accountRepository.findById(account.getEmail()).get();
        } catch (java.util.NoSuchElementException e) {
            return false;
        }
        return exisiting.getPassword().equals(account.getPassword());
    }

    public void delete(String email) {
        modifyDatabase(accountRepository.findById(email).get(), false);
        accountRepository.deleteById(email);
    }

    public void loadAccountDatabase() {
        List<Account> results = new ArrayList<>();
        try {
            SessionFactory factory = HibernateUtilities.getSessionFactory();
            Session session = factory.openSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
            criteria.from(Account.class);
            results = session.createQuery(criteria).getResultList();

//            results = session.createQuery("SELECT accounts FROM accounts", Account.class).getResultList();

        } catch (Exception ignored) {
        }

        for (Account account : results) {
            accountRepository.save(account);
        }
    }

    private void modifyDatabase(Account account, boolean bol) {
        Transaction transaction = null;

        try (SessionFactory factory = HibernateUtilities.getSessionFactory();
             Session session = factory.openSession()
        ) {
            transaction = session.beginTransaction();

            if (bol) {
                session.saveOrUpdate(account);
            } else {
                session.delete(account);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
