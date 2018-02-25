package com.table.dailymanage.notice;

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
 * A data access object (DAO) providing persistence and search support for
 * TbNotice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.table.dailymanage.notice.TbNotice
 * @author MyEclipse Persistence Tools
 */
public class TbNoticeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TbNoticeDAO.class);
	// property constants
	public static final String PUBLISH_MAN_ALIAS = "publishManAlias";
	public static final String PUBLISH_MAN_NAME = "publishManName";
	public static final String SUBJECT = "subject";
	public static final String CONTENT = "content";

	public void save(TbNotice transientInstance) {
		log.debug("saving TbNotice instance");
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

	public void delete(TbNotice persistentInstance) {
		log.debug("deleting TbNotice instance");
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

	public TbNotice findById(java.lang.Integer id) {
		log.debug("getting TbNotice instance with id: " + id);
		try {
			TbNotice instance = (TbNotice) getSession().get("com.table.dailymanage.notice.TbNotice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbNotice instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TbNotice as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPublishManAlias(String publishManAlias) {
		String propertyName = PUBLISH_MAN_ALIAS;
		String value = publishManAlias;
		Transaction tx = null;
		log.debug("finding TbNotice instance with property: " + propertyName + ", value: " + value);
		try {
			tx = getSession().beginTransaction();
			String queryString = "from TbNotice as e where e." + propertyName + " = " + "'" + value + "'" ;
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
		log.debug("finding all TbNotice instances");
		try {
			String queryString = "from TbNotice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}