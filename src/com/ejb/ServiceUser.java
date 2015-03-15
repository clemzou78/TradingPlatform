package com.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.User;
import com.connection.HibernateUtil;

/**
 * Session Bean implementation class ServiceUser
 */
@Stateless
@LocalBean
public class ServiceUser {

    /**
     * Default constructor. 
     */
    public ServiceUser() {
        // TODO Auto-generated constructor stub
    }
    
    public List getAllUsers(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM User u";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.close();
		return results;

	}
    
	public User recupByName(String username){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM User u WHERE u.username = '"+username+"'";
		Query query = session.createQuery(hql);
		List results = query.list();
		
		session.close();
		if (results.size()==0) return null;
		return (User) results.get(0);
	}
}
