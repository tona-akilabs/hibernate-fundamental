package com.example.hibernate_fundamental;

import com.example.hibernate_fundamental.entity.Account;
import com.example.hibernate_fundamental.entity.Project;
import com.example.hibernate_fundamental.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();
            config.setProperties(buildConnection());

            // Add annotated classes
            config.addAnnotatedClass(Project.class);
            config.addAnnotatedClass(Account.class);
            config.addAnnotatedClass(User.class);

            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static Properties buildConnection() {
        Properties settings = new Properties();
        settings.put("hibernate.connection.driver_class", "org.h2.Driver");
        settings.put("hibernate.connection.url", "jdbc:h2:mem:test");
        settings.put("hibernate.connection.username", "sa");
        settings.put("hibernate.connection.password", "");
        settings.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        settings.put("hibernate.hbm2ddl.auto", "update");
        settings.put("hibernate.show_sql", true);
        settings.put("hibernate.format_sql", true);
        //settings.put("hibernate.use_sql_comments", true);
        return settings;
    }
}
