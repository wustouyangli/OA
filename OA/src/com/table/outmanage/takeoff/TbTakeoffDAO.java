package com.table.outmanage.takeoff;

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
 	* A data access object (DAO) providing persistence and search support for TbTakeoff entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.table.outmanage.takeoff.TbTakeoff
  * @author MyEclipse Persistence Tools 
 */
public class TbTakeoffDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TbTakeoffDAO.class);
		//property constants
	public static final String ALIAS = "alias";
	public static final String NAME = "name";
	public static final String DEPARTMENT = "department";
	public static final String CONTENT = "content";
	public static final String STATE = "state";



    
    public void save(TbTakeoff transientInstance) {
        log.debug("saving TbTakeoff instance");
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
    
	public void delete(TbTakeoff persistentInstance) {
        log.debug("deleting TbTakeoff instance");
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
    
    public TbTakeoff findById( java.lang.Integer id) {
        log.debug("getting TbTakeoff instance with id: " + id);
        try {
            TbTakeoff instance = (TbTakeoff) getSession()
                    .get("com.table.outmanage.takeoff.TbTakeoff", id);
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
		log.debug("finding TbTakeoff instance with property: " + propertyName + ", value: " + value);
		try {
			tx = getSession().beginTransaction();
			String queryString = "from TbTakeoff as e where e." + propertyName + " = " + "'" + value + "'" ;
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
		log.debug("finding all TbTakeoff instances");
		try {
			String queryString = "from TbTakeoff";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
}