package com.example.hibernate_fundamental;

import com.example.hibernate_fundamental.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.proxy.ClobProxy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private static SessionFactory sessionFactory;

    @BeforeAll
    static void setUp() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // test config with H2
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    @AfterAll
    static void tearDown() {
        sessionFactory.close();
    }

    @Test
    void testPersistAndFetchProduct() throws Exception{
        final Product product = new Product();
        product.setName("Laptop");
        String warranty = "My product warranty";
        product.setWarranty(ClobProxy.generateProxy(warranty));
        // Save
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();
        session.close();

        // Fetch
        Session session2 = sessionFactory.openSession();
        Product fetched = session2.get(Product.class, product.getId());
        session2.close();
        assertNotNull(fetched);
        assertEquals("Laptop", fetched.getName());
        // assertEquals(warranty, fetched.getWarranty().getSubString(1, (int) fetched.getWarranty().length()));
    }
}
