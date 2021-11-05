/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Role;
import models.User;

/**
 *
 * @author 845593
 */
public class UserDB {
 
    public List<User> getAll() throws Exception {
    
         EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<User> lists=new ArrayList<>();
             lists = em.createNamedQuery("User.findAll",User.class).getResultList();
            return lists;
        } finally {
            em.close();
        }
    }

    public User get(String email) throws Exception {
           EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            User user;
             user = em.find(User.class,email);
            return user;
        } finally {
            em.close();
        }
    }

public void update(String previousEmail, String email, String firstName,String lastName,boolean status,Role role,String password) throws Exception {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
             EntityTransaction trans=em.getTransaction();
        try {
            User user;
             user = em.find(User.class,previousEmail);
             user.setFirstName(firstName);
             user.setLastName(lastName);
             user.setActive(status);
             user.setPassword(password);
       
             user.setRole(role);
                   trans.begin();
             em.merge(user);
             trans.commit();
          
        } catch(Exception ex){
        trans.rollback();
        } finally {
            em.close();
        }
        
   
    }



public void delete(String email) throws Exception {
                       EntityManager em = DBUtil.getEmFactory().createEntityManager();
             EntityTransaction trans=em.getTransaction();
        try {
      
            User user;
             user = em.find(User.class,email);
                   trans.begin();
             em.remove(user);
             trans.commit();
          
        }catch(Exception ex){
        trans.rollback();
        } 
        finally {
            em.close();
        }
        
   
    }




public void insert( String email, String firstName,String lastName,boolean status,Role role,String password) throws Exception {
                     EntityManager em = DBUtil.getEmFactory().createEntityManager();
             EntityTransaction trans=em.getTransaction();
        try {
            User user=new User(email);
            user.setActive(status);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            
             user.setRole(role);
             role.getUserList().add(user);
             trans.begin();
             em.persist(user);
             em.merge(role);
             trans.commit();
        } catch(Exception ex){
        trans.rollback();
        } finally {
            em.close();
        }
        
   
    }


}