package com.hibernate.demo;

import com.entities.Instructor;
import com.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {
    public static void main(String[] args) {

        SessionFactory  sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            Instructor instructor =
                    new Instructor("Daffy",
                            "Duck",
                            "duck.d@outlook.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail("youtube.com/duck_d",
                                        "Daffy Duck");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
