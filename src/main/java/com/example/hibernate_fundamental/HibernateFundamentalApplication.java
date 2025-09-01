package com.example.hibernate_fundamental;


import com.example.hibernate_fundamental.entity.Account;
import com.example.hibernate_fundamental.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

public class HibernateFundamentalApplication {

	public static void main(String[] args) {
        System.out.println("Hello, Hibernate!");
        // Open a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        projectExample(session);
        accountExample(session);
        // Close the session
        session.close();
        // Shutdown Hibernate
        HibernateUtil.getSessionFactory().close();
	}

    private static void projectExample(Session session) {
        // Start transaction
        Transaction tx = session.beginTransaction();
        Project project = new Project("New Project", LocalDate.of(2024, 12, 31));
        // Persist the project
        session.persist(project);
        // Commit transaction
        tx.commit();
        // Fetch the project
        Project fetchedProject = session.get(Project.class, project.getId());
        System.out.println("Fetched Project: " + fetchedProject.getName() + ", Deadline: " + fetchedProject.getDeadline());
    }

    private static void accountExample(Session session) {
        Transaction tx = session.beginTransaction();
        Account account = new Account(100000d, 0.05);
        // Persist the account
        session.persist(account);
        tx.commit();
        System.out.println(account);
        // Fetch the account
        // Account fetchedAccount = session.get(Account.class, account.getId());
        // Account fetchedAccount = session.find(Account.class, account.getId());
        /*Account fetchedAccount = session.createQuery("FROM accounts WHERE id = :id", Account.class)
                .setParameter("id", account.getId())
                .getSingleResult();*/
        Account fetchedAccount = session.createQuery("FROM Account WHERE id = :id", Account.class)
                .setParameter("id", account.getId())
                .getSingleResult();
        System.out.println(fetchedAccount);
        System.out.println("Fetched Account: Credit = " + fetchedAccount.getCredit() + ", Rate = " + fetchedAccount.getRate() + ", Interest = " + fetchedAccount.getInterest());

        // Example: select all accounts
        List<Object[]> results = session.createNativeQuery(
                        "SELECT id, credit, rate, credit * rate AS interest FROM accounts")
                .getResultList();

        for (Object[] row : results) {
            System.out.println("ID: " + row[0] + ", Credit: " + row[1] + ", Rate: " + row[2] + ", Interest: " + row[3]);
        }
    }
}
