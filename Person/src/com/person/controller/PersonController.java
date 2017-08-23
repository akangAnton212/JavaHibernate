/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.person.controller;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.ParseConversionEvent;
import com.person.DAO.PersonDAO;
import com.person.model.Person;
import com.person.util.PersonUtil;
/**
 *
 * @author IT-PC
 */
public class PersonController {
     Person person = new Person();
    PersonDAO personDAO = PersonUtil.getPersonDao();
    String header[] = {"Id", "Nama", "Telepon", "Alamat"};

    public void insert(String nama, String telepon, String alamat){
        person.setNama(nama);
        person.setTelepon(telepon);
        person.setAlamat(alamat);
        personDAO.insert(person);
    }

    public void update(String id, String nama, String telepon, String alamat){
        person.setId(Integer.parseInt(id));
        person.setNama(nama);
        person.setTelepon(telepon);
        person.setAlamat(alamat);
        personDAO.update(person);
    }

    public void delete(String id, String nama, String telepon, String alamat){
        person.setId(Integer.parseInt(id));
        person.setNama(nama);
        person.setTelepon(telepon);
        person.setAlamat(alamat);
        personDAO.delete(person);
    }

    public void SelectAll(JTable table){
        List<Person> list = personDAO.SelectAll();
        Object data[][] = new Object[list.size()][4];
        int i = 0;
        for(Person manusia : list){
            data[i][0] = manusia.getId();
            data[i][1] = manusia.getNama();
            data[i][2] = manusia.getTelepon();
            data[i][3] = manusia.getAlamat();
            ++i;
        }
        table.setModel(new DefaultTableModel(data, header));
    }

    public void GetByName(String nama, JTable table){
        List<Person> list = personDAO.GetByName(nama);
        Object data[][] = new Object[list.size()][4];
        int i = 0;
        for(Person manusia : list){
            data[i][0] = manusia.getId();
            data[i][1] = manusia.getNama();
            data[i][2] = manusia.getTelepon();
            data[i][3] = manusia.getAlamat();
            ++i;
        }
        table.setModel(new DefaultTableModel(data, header));
    }
}
