package com.example.hibernate_fundamental;

import com.example.hibernate_fundamental.entity.Person;
import com.example.hibernate_fundamental.enums.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private static SessionFactory sessionFactory;

    @BeforeAll
    static void setUp() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // test config with H2
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
    }

    @AfterAll
    static void tearDown() {
        sessionFactory.close();
    }

    @Test
    void testPersistAndFetchPerson() {
        Person person = new Person();
        person.setId(1L);
        person.setName("John Doe");
        person.setGender(Gender.MALE); // Testing the converter
        // Save
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(person);
        session.getTransaction().commit();
        session.close();

        // Fetch
        Session session2 = sessionFactory.openSession();
        Person fetched = session2.get(Person.class, person.getId());
        session2.close();

        assertNotNull(fetched);
        assertEquals("John Doe", fetched.getName());
        assertEquals("MALE", fetched.getGender().name());
    }
}
