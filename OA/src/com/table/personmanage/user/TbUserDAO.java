package com.table.personmanage.user;

import com.hbconfig.BaseHibernateDAO;


import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.table.personmanage.user.TbUser
 * @author MyEclipse Persistence Tools
 */
public class TbUserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TbUserDAO.class);
	// property constants
	public static final String ALIAS = "alias";
	public static final String PASSWORD = "password";
	public static final String AUTHORITY = "authority";
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String DEPARTMENT = "department";
	public static final String JOB = "job";
	public static final String EMAIL = "email";
	public static final String OFFICE_TEL = "officeTel";
	public static final String TEL = "tel";
	public static final String FAMILY_TEL = "familyTel";
	public static final String ADDRESS = "address";
	public static final String BEST_EMPLOYEE = "bestEmployee";

	public void save(TbUser transientInstance) {
		log.debug("saving TbUser instance");
		try {
			
			Transaction tx = getSession().beginTransaction();
			getSession().save(transientInstance);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbUser persistentInstance) {
		log.debug("deleting TbUser instance");
		try {
			Transaction tx = getSession().beginTransaction();
			getSession().delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbUser findById(java.lang.Integer id) {
		log.debug("getting TbUser instance with id: " + id);
		try {
			TbUser instance = (TbUser) getSession().get("com.table.personmanage.user.TbUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByAlias(String alias) {
		
		String propertyName = ALIAS;
		String value = alias;
		Transaction tx = null;
		log.debug("finding TbUser instance with property: " + propertyName + ", value: " + value);
		try {
			tx = getSession().beginTransaction();
			String queryString = "from TbUser as e where e." + propertyName + " = " + "'" + value + "'" ;
			List list = getSession().createQuery(queryString).list();
			tx.commit();
			return list;
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
	         e.printStackTrace();
	         throw e;  
		}
		catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		
	}

	public List findAll() {
		log.debug("finding all TbUser instances");
		try {
			String queryString = "from TbUser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}