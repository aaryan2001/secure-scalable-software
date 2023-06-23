/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.jpa;

import entity.Myuser;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aarya
 */


public class MyuserDB {

    private EntityManager em = null;

    public MyuserDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ED-EntityPU");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManger() {
        return em;
    }

    public Myuser findMyuser(String userid) {
        return em.find(Myuser.class, userid);
    }

    public boolean createMyuser(Myuser myuser) throws Exception {
        try {
            if (findMyuser(myuser.getUserid()) != null) {
                return false;
            }
            em.getTransaction().begin();
            em.persist(myuser); 
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public boolean createRecord(MyuserDTO myuserDTO) {
        Myuser myuser = this.myDTO2DAO(myuserDTO);
        boolean result = false;
        try {
            result = this.createMyuser(myuser);
        } catch (Exception ex) {
        }
        return result;
    }

    private Myuser myDTO2DAO(MyuserDTO myDTO) {
        Myuser myuser = new Myuser();
        myuser.setUserid(myDTO.getUserid());
        myuser.setName(myDTO.getName());
        myuser.setPassword(myDTO.getPassword());
        myuser.setEmail(myDTO.getEmail());
        myuser.setPhone(myDTO.getPhone());
        myuser.setAddress(myDTO.getAddress());
        myuser.setSecqn(myDTO.getSecQn());
        myuser.setSecans(myDTO.getSecAns());
        return myuser;
    }

    public MyuserDTO getRecord(String userId) {

        Myuser myuser = new Myuser();
        myuser.setUserid(userId);

        em.getTransaction().begin();
        Myuser user = em.find(Myuser.class, userId);
        em.getTransaction().commit();
        MyuserDTO myuserDTO = new MyuserDTO(user.getUserid(), user.getName(),
                user.getPassword(), user.getEmail(), user.getPhone(),
                user.getAddress(), user.getSecans(), user.getSecqn());
        return myuserDTO;

    }

    public boolean updateRecord(MyuserDTO myuserDTO) {
        MyuserDTO foundUser = getRecord(myuserDTO.getUserid());
        if (foundUser == null) {
            return false;
        }
        Myuser myuser = this.myDTO2DAO(myuserDTO);
        System.out.println("MERGING :" + myuserDTO.getName());
        em.getTransaction().begin();
        em.merge(myuser);
        em.getTransaction().commit();
        return true;
    }

    public boolean deleteRecord(String userId) {
        MyuserDTO foundUser = getRecord(userId);
        if (foundUser == null) {
            return false;
        }
        Myuser myuser = this.myDTO2DAO(foundUser);
        System.out.println("DELETING: " + myuser.getName());
        em.getTransaction().begin();
        Myuser myuser2 = em.merge(myuser);
        em.remove(myuser2);
        em.getTransaction().commit();
        return true;
    }

}
