package com.example.hibernate_fundamental;

import com.example.hibernate_fundamental.entity.Profile;
import com.example.hibernate_fundamental.helper.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {
    private static SessionFactory sessionFactory;

    @BeforeAll
    static void setUp() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // test config with H2
                .addAnnotatedClass(Profile.class)
                .buildSessionFactory();
    }

    @AfterAll
    static void tearDown() {
        sessionFactory.close();
    }

    @Test
    void testPersistAndFetchProfile() {
        final Profile profile = new Profile();
        profile.setName("John Doe");
        Map<String, Object> skills = new HashMap<>();
        /*skills.put("Java", new Skill("expert", 5));
        skills.put("Python", new Skill("intermediate", 3));*/

        Map<String, Object> javaSkill = new HashMap<>();
        javaSkill.put("level", "expert");
        javaSkill.put("experience", 5);
        skills.put("Java", javaSkill);

        Map<String, Object> pythonSkill = new HashMap<>();
        pythonSkill.put("level", "intermediate");
        pythonSkill.put("experience", 3);
        skills.put("Python", pythonSkill);
        profile.setSkills(skills);

        // Save
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(profile);
        session.getTransaction().commit();
        session.close();

        // Fetch
        Session session2 = sessionFactory.openSession();
        Profile fetched = session2.get(Profile.class, profile.getId());
        session2.close();
        assertNotNull(fetched);
        assertEquals("John Doe", fetched.getName());
        assertEquals(2, fetched.getSkills().size());
    }
}
