package com.example.hibernate_fundamental;

import com.example.hibernate_fundamental.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private static SessionFactory sessionFactory;

    @BeforeAll
    static void setUp() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // test config with H2
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();
    }

    @AfterAll
    static void tearDown() {
        sessionFactory.close();
    }

    @Test
    void testPersistAndFetchAccount() {
        Account account = new Account();
        account.setCredit(500.0);
        account.setRate(0.03);

        // Save
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(account);
        session.getTransaction().commit();
        session.close();

        // Fetch
        Session session2 = sessionFactory.openSession();
        Account fetched = session2.get(Account.class, account.getId());
        session2.close();

        assertNotNull(fetched);
        assertEquals(500.0, fetched.getCredit());
        assertEquals(0.03, fetched.getRate());
    }
}
