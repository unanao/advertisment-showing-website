package com.free4lab.utils.sql.entitymanager;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 * @author MyEclipse Persistence Tools
 */
public class EntityManagerHelper {
	
	private static final EntityManagerFactory emf; 
	private static final ThreadLocal<EntityManager> threadLocal;
	private static final Logger logger;
	
	static {
		emf = Persistence.createEntityManagerFactory("BancaiPU"); 
		threadLocal = new ThreadLocal<EntityManager>();
		logger = Logger.getLogger("BancaiPU");
	}
		
	public static EntityManager getEntityManager() {
		EntityManager manager = threadLocal.get();		
		if (manager == null || !manager.isOpen()) {
			manager = emf.createEntityManager();
			threadLocal.set(manager);
		}
		return manager;
	}
	
	 public static void closeEntityManager() {
        EntityManager em = threadLocal.get();
        threadLocal.set(null);
        if (em != null) em.close();
    }
    
    public static void beginTransaction() {
    	if (getEntityManager().getTransaction().isActive()) {
    		getEntityManager().getTransaction().rollback();
    		logger.log(Level.SEVERE, "A transaction is still active before another begin, we have to roll back it!");
    	}
    	getEntityManager().getTransaction().begin();
    }
    
    public static void commit() {
    	getEntityManager().getTransaction().commit();
    }  
    
    public static void rollback() {
    	getEntityManager().getTransaction().rollback();
    } 
    
    public static Query createQuery(String query) {
		return getEntityManager().createQuery(query);
	}
	
	public static void log(String info, Level level, Throwable ex) {
    	logger.log(level, info, ex);
    }
	
	public static void delete(Class<?> clazz,Integer id) {
		EntityManagerHelper.log("deleting " + clazz.getName()+" instance", Level.INFO, null);
		try {
			Object entity = getEntityManager().getReference(clazz,
					id);
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}
	
	public static void delete(Class<?> clazz,int id) {
		EntityManagerHelper.log("deleting " + clazz.getName()+" instance", Level.INFO, null);
		try {
			Object entity = getEntityManager().getReference(clazz,
					id);
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	} 
	
	
}

