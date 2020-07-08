package com.hibernate.demo;

import com.entities.Instructor;
import com.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DelateInstructorDemo {
    public static void main(String[] args) {

        SessionFactory  sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor =
                    session.get(Instructor.class, 2);
            if(instructor != null){
                //also delate instrutorDetal
                //CascadeType.ALL
                session.delete(instructor);
            }
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
