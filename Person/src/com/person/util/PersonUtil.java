/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.person.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import com.person.DAO.PersonDAO;
import com.person.DAO.Implement.PersonDAOImpl;/**
 *
 * @author IT-PC
 */
public class PersonUtil {
    private static final SessionFactory sessionFactory;
    private static final PersonDAO personDao;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            personDao = new PersonDAOImpl(sessionFactory);
        } catch (Throwable e) {
            System.err.println("Inisialisasi sessionFactory gagal "+e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static PersonDAO getPersonDao() {
        return personDao;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
