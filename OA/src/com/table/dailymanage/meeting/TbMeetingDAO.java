package com.table.dailymanage.meeting;

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
 * TbMeeting entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.table.dailymanage.meeting.TbMeeting
 * @author MyEclipse Persistence Tools
 */
public class TbMeetingDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TbMeetingDAO.class);
	// property constants
	public static final String HOST = "host";
	public static final String PUBLISH_MAN_ALIAS = "publishManAlias";
	public static final String PUBLISH_MAN_NAME = "publishManName";
	public static final String SUBJECT = "subject";
	public static final String ADDRESS = "address";
	public static final String CONTENT = "content";

	public void save(TbMeeting transientInstance) {
		log.debug("saving TbMeeting instance");
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

	public void delete(TbMeeting persistentInstance) {
		log.debug("deleting TbMeeting instance");
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

	public TbMeeting findById(java.lang.Integer id) {
		log.debug("getting TbMeeting instance with id: " + id);
		try {
			TbMeeting instance = (TbMeeting) getSession().get("com.table.dailymanage.meeting.TbMeeting", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByPublishManAlias(String publishManAlias) {
		String propertyName = PUBLISH_MAN_ALIAS;
		String value = publishManAlias;
		Transaction tx = null;
		log.debug("finding TbMeeting instance with property: " + propertyName + ", value: " + value);
		try {
			tx = getSession().beginTransaction();
			String queryString = "from TbMeeting as e where e." + propertyName + " = " + "'" + value + "'" ;
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
		log.debug("finding all TbMeeting instances");
		try {
			String queryString = "from TbMeeting";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findByTimeRange(String time_start, String time_end) {
		log.debug("finding TbMeeting instances by time range");
		try {
			String queryString = "from TbMeeting where time >= " + "'" + time_start + "'" + " and time <= " + "'" + time_end + "'";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by time range failed", re);
			throw re;
		}
	}

}