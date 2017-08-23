/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.person.DAO;
import java.util.List;
import org.hibernate.HibernateException;
import com.person.model.Person;
/**
 *
 * @author IT-PC
 */
public interface PersonDAO {
    public void insert(Person person) throws HibernateException;

    public void update(Person person) throws HibernateException;

    public void delete(Person person) throws HibernateException;

    List <Person> SelectAll() throws HibernateException;

    List<Person> GetByName(String nama) throws HibernateException;

}
