package com.table.outmanage.oof;

import com.hbconfig.BaseHibernateDAO;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for TbOof
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.table.outmanage.oof.TbOof
 * @author MyEclipse Persistence Tools
 */
public class TbOofDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TbOofDAO.class);
	// property constants
	public static final String ALIAS = "alias";
	public static final String NAME = "name";
	public static final String DEPARTMENT = "department";
	public static final String CONTENT = "content";
	public static final String STATE = "state";

	public void save(TbOof transientInstance) {
		log.debug("saving TbOof instance");
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

	public void delete(TbOof persistentInstance) {
		log.debug("deleting TbOof instance");
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

	public TbOof findById(java.lang.Integer id) {
		log.debug("getting TbOof instance with id: " + id);
		try {
			TbOof instance = (TbOof) getSession().get("com.table.outmanage.oof.TbOof", id);
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
		log.debug("finding TbOof instance with property: " + propertyName + ", value: " + value);
		try {
			tx = getSession().beginTransaction();
			String queryString = "from TbOof as e where e." + propertyName + " = " + "'" + value + "'" ;
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
		log.debug("finding all TbOof instances");
		try {
			String queryString = "from TbOof";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}