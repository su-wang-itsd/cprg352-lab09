/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.DBUtil;
import dataaccess.RoleDB;
import java.util.List;
import javax.persistence.EntityManager;
import models.Role;

/**
 *
 * @author 845593
 */
public class RoleService {
    
    private RoleDB roleDB=new RoleDB();
    public List<Role> getAll() throws Exception{
            EntityManager em = DBUtil.getEmFactory().createEntityManager();

    return roleDB.getAll();
    }
    
}
