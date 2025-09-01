package com.example.hibernate_fundamental;


import com.example.hibernate_fundamental.entity.Project;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateFundamentalApplication {

	public static void main(String[] args) {
        System.out.println("Hello, Hibernate!");
        HibernateUtil.getSessionFactory();
        /*Configuration config = new Configuration();
        config.setProperties(HibernateFundamentalApplication.buildConnection());
        // Add annotated classes
        config.addAnnotatedClass(Project.class);

        SessionFactory sessionFactory = config.buildSessionFactory();*/
	}

    private static Properties buildConnection() {
        Properties settings = new Properties();
        settings.put("hibernate.connection.driver_class", "org.h2.Driver");
        settings.put("hibernate.connection.url", "jdbc:h2:mem:test");
        settings.put("hibernate.connection.username", "sa");
        settings.put("hibernate.connection.password", "");
        settings.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        settings.put("hibernate.hbm2ddl.auto", "update");
        settings.put("hibernate.show_sql", "true");
        return settings;
    }
}
