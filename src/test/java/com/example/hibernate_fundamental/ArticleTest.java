package com.example.hibernate_fundamental;

import com.example.hibernate_fundamental.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArticleTest {
    private static SessionFactory sessionFactory;

    @BeforeAll
    static void setUp() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // test config with H2
                .addAnnotatedClass(Article.class)
                .buildSessionFactory();
    }

    @AfterAll
    static void tearDown() {
        sessionFactory.close();
    }

    @Test
    void testPersistAndFetchArticle() {
        Article article = new Article();
        String title = "\u200Bការ\u200Bសង្គ្រោះ\u200B\u200Bប៉េណាល់ទី\u200Bរបស់ Raya \u200Bយប់មិញ\u200B\u200Bអស្ចារ្យ\u200B\u200B\u200Bហ្នឹង\u200Bវីរបុរស\u200B Arsenal \u200Bម្នាក់\u200Bនេះ\u200B\u200B";
        article.setTitle(title);
        String content = "Atalanta និង Arsenal បញ្ចប់\u200Bត្រឹម\u200Bលទ្ធផល\u200Bស្មើ\u200Bគ្នា០-០ សម្រាប់\u200Bការ\u200Bប្រកួត\u200Bបើក\u200Bឆាក\u200B UEFA Champions League \u200Bទទួល\u200Bបាន\u200Bម្នាក់\u200B១\u200Bពិន្ទុ\u200Bក្នុង\u200Bការ\u200Bប្រកួត\u200B\u200Bលើ\u200Bទឹក\u200Bដី\u200Bរបស់\u200Bក្រុម\u200B\u200Bអ៊ីតាលី។ ក្នុង\u200Bការ\u200Bប្រកួត\u200Bនោះ\u200Bគេ\u200Bមើល\u200Bឃើញ\u200Bថា អ្នក\u200Bចាំ\u200Bទី\u200Bរបស់\u200Bក្រុម\u200Bផ្ញៀវ David Raya បាន\u200Bសង្គ្រោះ\u200Bបាល់\u200Bប៉េណាល់ទី\u200B និង\u200Bបាល់\u200Bបន្ថែម\u200Bប៉េណាល់ទី\u200B\u200B\u200Bនោះ\u200Bបាន\u200Bល្អ\u200Bមែន\u200Bទែន\u200B។\u200B\n" +
                "\n" +
                "David Raya អ្នក\u200Bចាំ\u200B\u200Bទី\u200Bរបស់ Arsenal បាន\u200Bសង្គ្រោះ\u200B\u200Bបាល់\u200Bចំនួន\u200Bពីរ\u200B\u200Bលើក\u200Bពី\u200Bការ\u200Bស៊ុត\u200Bប៉េណាល់ទី១\u200Bលើក\u200B \u200B\u200Bនិង\u200Bបាល់\u200Bតែត\u200Bពេល\u200B\u200Bឡង\u200Bត្រឡប់\u200Bមកវិញ\u200Bហើយ \u200Bតែត\u200Bបន្ថែម\u200Bដោយ\u200Bខ្សែ\u200Bប្រយុទ្ធ\u200B\u200B Reteguiរបស់\u200B\u200Bក្រុម Atalanta មួយ\u200Bលើក\u200Bទៀត \u200B\u200Bប៉ុន្តែ\u200B\u200Bត្រូវ\u200B\u200Bបាន Devid Raya ជួយ\u200Bបាន\u200Bទាំង\u200Bពីរ។"
                + "\n" + "\u200B\u200Bក្រុម\u200Bទាំង\u200Bពីរ\u200Bមាន\u200Bការ\u200Bស៊ុត\u200Bគ្នា\u200Bទៅវិញ\u200Bទៅ\u200Bមក \u200Bបើ\u200Bទោះ\u200Bជា\u200B\u200Bមាន\u200Bការ\u200Bស៊ុត\u200Bប៉េណាល់ទី\u200Bក៏\u200Bដោយ\u200Bក៏\u200Bនៅ\u200Bតែ\u200Bមិន\u200Bអាច\u200Bមាន\u200Bគ្រាប់\u200Bបាល់\u200B។ គេ\u200Bមើល\u200Bឃើញ\u200Bថា\u200Bនា\u200Bទី\u200Bទី\u200B៥០\u200Bខ្សែការពារ\u200B\u200Bរបស់\u200Bក្រុម\u200B Arsenal បាន\u200Bទាញ\u200Bខ្សែ\u200Bប្រយុទ្ធ\u200Bរបស់\u200Bក្រុម\u200Bម្ចាស់\u200Bផ្ទះ Atalanta ហើយ\u200Bបង្កើត\u200B\u200Bឱកាស\u200Bឲ្យ\u200Bក្រុម\u200Bម្ចាស់\u200Bផ្ទះ\u200Bមាន\u200Bបាល់\u200Bពិន័យ\u200B១១\u200Bម៉ែត្រ។ យ៉ាង\u200Bណា\u200Bក្រោយ\u200Bពេល\u200B\u200B\u200Bអាជ្ញាកណ្ដាល\u200Bសម្រេច\u200Bផ្ដល់\u200Bបាល់\u200Bពិន័យ\u200Bនោះ Raya \u200Bហក់\u200Bទះ\u200Bយ៉ាង\u200Bល្អ ហើយ\u200Bពេល\u200B\u200Bបាល់\u200Bនោះ\u200Bឡង\u200Bត្រឡប់\u200Bមក\u200Bកាន់\u200Bខ្សែ\u200Bប្រយុទ្ធRetegui វិញ\u200Bគេ\u200Bក៏\u200Bតែត\u200Bបន្ថែម\u200Bប៉ុន្តែ\u200Bត្រូវ\u200Bបាន Raya សង្គ្រោះ\u200Bបាល់\u200B\u200Bនោះ\u200Bបាន\u200Bម្ដង\u200Bទៀត\u200B។\n" +
                "\n" +
                "បើ\u200B\u200Bក្រឡេក\u200Bទៅ\u200Bមើល\u200Bអតីត\u200Bកាល\u200Bការ\u200Bសង្គ្រោះ\u200Bបាល់\u200Bនេះ\u200B\u200Bពិត\u200Bជា\u200Bល្អ\u200Bខ្លាំង\u200Bណាស់ ដែល\u200Bវា\u200Bពិត\u200Bជា\u200Bការ\u200Bសង្គ្រោះ\u200Bបាល់\u200Bដ៏\u200Bអស្ចារ្យ\u200Bដូច\u200Bកាល\u200B\u200B\u200Bការ\u200Bសង្រ្គោះ\u200Bរបស់\u200Bអតីត\u200Bអ្នក\u200Bចាំា\u200Bទី\u200B និង\u200Bវីរបុរស\u200B\u200Bរបស់\u200B Arsenal លោក Devid Seaman \u200Bពី\u200Bការ\u200Bស៊ុត\u200Bរបស់\u200Bខ្សែ\u200Bប្រយុទ្ធ\u200B Paul Peschisolido \u200Bនៃ\u200B\u200B\u200Bក្រុម Sheffield United \u200Bកាល\u200Bឆ្នាំ\u200B២០០៣ វគ្គ\u200Bពាក់\u200Bកណ្ដាល\u200Bផ្ដាច់\u200B\u200Bព្រ័ត្រ FA Cup \u200Bយ៉ាង\u200Bដូច្នេះ\u200Bដែរ\u200B។";
        article.setContent(content);
        // Save
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(article);
        session.getTransaction().commit();
        session.close();

        // Fetch
        Session session2 = sessionFactory.openSession();
        Article fetched = session2.get(Article.class, article.getId());
        session2.close();

        assertNotNull(fetched);
        assertEquals(title, fetched.getTitle());
        assertEquals(content, fetched.getContent());
    }
}
