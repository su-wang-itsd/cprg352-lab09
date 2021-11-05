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
import models.Role;
import models.User;

/**
 *
 * @author 845593
 */
public class RoleDB {
     public List<Role> getAll() throws Exception {
         EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Role> lists;
             lists = em.createNamedQuery("Role.findAll",Role.class).getResultList();
            return lists;
        } finally {
            em.close();
        }
    }
}
