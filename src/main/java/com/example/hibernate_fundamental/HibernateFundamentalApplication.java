package com.example.hibernate_fundamental;


import com.example.hibernate_fundamental.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Properties;

public class HibernateFundamentalApplication {

	public static void main(String[] args) {
        System.out.println("Hello, Hibernate!");
        // Open a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        // Start transaction
        Transaction tx = session.beginTransaction();
        // Create a new project
        Project project = new Project("New Project", LocalDate.of(2024, 12, 31));
        // Persist the project
        session.persist(project);
        // Commit transaction
        tx.commit();

        // Fetch the project
        Project fetchedProject = session.get(Project.class, project.getId());
        System.out.println("Fetched Project: " + fetchedProject.getName() + ", Deadline: " + fetchedProject.getDeadline());

        // Close the session
        session.close();
        // Shutdown Hibernate
        HibernateUtil.getSessionFactory().close();
	}
}
