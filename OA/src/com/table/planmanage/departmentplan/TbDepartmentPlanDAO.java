package com.table.planmanage.departmentplan;

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
 * TbDepartmentPlan entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.table.planmanage.departmentplan.TbDepartmentPlan
 * @author MyEclipse Persistence Tools
 */
public class TbDepartmentPlanDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TbDepartmentPlanDAO.class);
	// property constants
	public static final String PUBLISH_MAN_ALIAS = "publishManAlias";
	public static final String PUBLISH_MAN_NAME = "publishManName";
	public static final String DEPARTMENT = "department";
	public static final String SUBJECT = "subject";
	public static final String CONTENT = "content";

	public void save(TbDepartmentPlan transientInstance) {
		log.debug("saving TbDepartmentPlan instance");
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

	public void delete(TbDepartmentPlan persistentInstance) {
		log.debug("deleting TbDepartmentPlan instance");
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

	public TbDepartmentPlan findById(java.lang.Integer id) {
		log.debug("getting TbDepartmentPlan instance with id: " + id);
		try {
			TbDepartmentPlan instance = (TbDepartmentPlan) getSession()
					.get("com.table.planmanage.departmentplan.TbDepartmentPlan", id);
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
		log.debug("finding TbDepartmentPlan instance with property: " + propertyName + ", value: " + value);
		try {
			tx = getSession().beginTransaction();
			String queryString = "from TbDepartmentPlan as e where e." + propertyName + " = " + "'" + value + "'" ;
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
		log.debug("finding all TbDepartmentPlan instances");
		try {
			String queryString = "from TbDepartmentPlan";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}