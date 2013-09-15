package com.free4lab.utils.sql;

import java.util.logging.Logger;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.free4lab.utils.sql.entitymanager.EntityManagerHelper;

/**
 * 基础DAO，这是一个抽象类，请DAO继承此类
 * @author yicou
 */
public abstract class AbstractDAO<T> {

    /**
     * 获取实体名称，内部使用
     * @return
     */
    public String getClassName() {
        return getEntityClass().getName();
    }

    /**
     * 获取实体类型，需要继承，内部使用
     * @return
     */
    public abstract Class<?> getEntityClass();

    /**
     * 获取数据库持久单元名称，需要继承，内部使用
     * @return
     */
    public abstract String getPUName();

    /**
     * 获取JPA数据库管理器，需要继承，内部使用
     * @return
     */

    protected Logger logger = null;

    protected Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(getClassName());
        }
        return logger;
    }

    protected void log(String info, Level level, Throwable ex) {
        getLogger().log(level, info, ex);
    }

    /**
     * 保存一个数据库实例
     */
    public void save(T entity) {

    	EntityManager em = EntityManagerHelper.getEntityManager();

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }
        em.getTransaction().begin();

        log("saving " + getClassName() + " instance", Level.INFO, null);
        try {
            em.persist(entity);
            log("save successful", Level.INFO, null);
            em.getTransaction().commit();
        } catch (RuntimeException re) {
            log("save failed", Level.SEVERE, re);
            em.getTransaction().rollback();
            throw re;
        }

    }
    
    /**
     * 保存一个数据库实例，没有事务保护
     */
    public void saveNoTransaction(T entity) {

    	EntityManager em = EntityManagerHelper.getEntityManager();

        log("saving " + getClassName() + " instance", Level.INFO, null);
        try {
            em.persist(entity);
            log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            log("save failed", Level.SEVERE, re);
            throw re;
        }

    }

    /**
     * 通过主键删除一个数据库实例
     */
    public void deleteByPrimaryKey(Object primaryKey) {

    	EntityManager em = EntityManagerHelper.getEntityManager();

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }
        em.getTransaction().begin();
        log("deleting " + getClassName() + " instance", Level.INFO, null);
        try {
            Object entity = em.getReference(getEntityClass(),
                    primaryKey);
            em.remove(entity);
            log("delete successful", Level.INFO, null);
            em.getTransaction().commit();
        } catch (RuntimeException re) {
            log("delete failed", Level.SEVERE, re);
            em.getTransaction().rollback();
            throw re;
        }
    }
    
    /**
     * 通过主键删除一个数据库实例 --无事物保护，使用时需要自己进行事务保护
     */
	public void deleteByPrimaryKeyNoTranscation(Object primaryKey) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		log("deleting " + getClassName() + " instance", Level.INFO, null);
		try {
			Object entity = em.getReference(getEntityClass(), primaryKey);
			em.remove(entity);
		} catch (RuntimeException re) {
			log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}
	
	/**
	 * 删除不在value中的内容
	 * @param column
	 * @param value  value 必须为对应类型的list
	 */
	public void deleteByPropertyNotIn(String column, Object value)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		String queryString = null;

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }
		
        try 
        {	 
       	 	EntityManagerHelper.beginTransaction();
       	 	
            queryString = "delete from " + getClassName() + 
            		" table where table." + column + " not in (:value)";
            
            log(queryString, Level.INFO, null);
            
            Query query = em.createQuery(queryString);
            query.setParameter("value", value);
            query.executeUpdate();
            
            EntityManagerHelper.commit();
        } catch (RuntimeException re) {
            log(queryString, Level.SEVERE, re);
            EntityManagerHelper.rollback();
            throw re;
        }
	}
	
	/**
     * 根据表中列的名字删除表中的记录
     * @param column 列名
     * @param value  列的值
     */
    public void deleteBy2Column(String column1, Object value1, 
    							  String column2, Object value2)
	{
		String deleteStr = "DELETE FROM " + getClassName() + " table where table."
		         + column1 + "=:value1" + " AND table." + column2  + "=:value2";
		EntityManager em = EntityManagerHelper.getEntityManager();

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }

		log(deleteStr + value1 + value2, Level.INFO, null);
		try 
        {	 
       	 	EntityManagerHelper.beginTransaction();
       	 	
			Query query = em.createQuery(deleteStr);
			query.setParameter("column1", value1);
			query.setParameter("column2", value2);
			
			query.executeUpdate();
			
			EntityManagerHelper.commit();
		} 
		catch (RuntimeException re) 
		{
			log(deleteStr + value1 + value2, Level.SEVERE, re);
			EntityManagerHelper.rollback();
			
			throw re;
		}
	}

	
    /**
     * 根据表中列的名字删除表中的记录
     * @param column 列名
     * @param value  列的值
     */
    public void deleteByColumnNoTranscation(String column, Object value)
	{
		String deleteStr = getDeleteStr(column);
		
		updateExcuteNoTranscation(deleteStr, value);
	}

	/**
	 * @param table
	 * @param column
	 * @return
	 */
	private String getDeleteStr(String column)
	{
		return ("DELETE FROM " + getClassName() + " table where table."
		         + column + "= :columnValue");
	}
    
    /**
     * 用于执行根据 1个列的名字对其进行的操作 
     * @param queryStr
     * @param value
     */
    private void updateExcuteNoTranscation(String queryStr, Object value)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();

		log(queryStr + value, Level.INFO, null);
		
		try 
		{
			Query query = em.createQuery(queryStr);
			query.setParameter("columnValue", value);
			
			query.executeUpdate();
		} 
		catch (RuntimeException re) 
		{
			log(queryStr + value, Level.SEVERE, re);
			throw re;
		}
	}

    /**
     * 更新一个数据库实例
     */
    public T update(T entity) {

    	EntityManager em = EntityManagerHelper.getEntityManager();

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }
        em.getTransaction().begin();

        log("updating " + getClassName() + " instance", Level.INFO, null);
        try {
            T result = em.merge(entity);
            log("update successful", Level.INFO, null);
            em.getTransaction().commit();
            return result;
        } catch (RuntimeException re) {
            log("update failed", Level.SEVERE, re);
            em.getTransaction().rollback();
            throw re;
        }
    }
    
    /**
     *  没有事务保护情况下，更新一个数据库实例
     */
    public T updateNoTransaction(T entity) {
        log("updating " + getClassName() + " instance", Level.INFO, null);
        try {
            T result = EntityManagerHelper.getEntityManager().merge(entity);
            log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * 通过主键寻找数据库实例
     * @param pKey 主键
     * @return
     */
    @SuppressWarnings("unchecked")
    public T findByPrimaryKey(Object pKey) {
        log("finding " + getClassName() + " instance with primary key: " + pKey,
                Level.INFO, null);
        try {
            Object instance = EntityManagerHelper.getEntityManager().find(getEntityClass(), pKey);
            return (T) instance;
        } catch (RuntimeException re) {
            log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * 通过id寻找实体
     * @param id
     * @return
     */
    public T findById(Integer id) {
        return findByPrimaryKey(id);
    }

    /**
     * 通过属性查找
     */
    @SuppressWarnings("unchecked")
    public List<T> findByProperty(String propertyName,
            final Object value) {
    	EntityManager em = EntityManagerHelper.getEntityManager();
    	
        log("finding " + getClassName() + " instance with property: "
                + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from " + getClassName() + " model where model."
                    + propertyName + "= :propertyValue";
            Query query = em.createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find by property name failed",
                    Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * 查找从start开始的count个实体
     * @param start
     * @param count
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> findByProperty(String propertyName,
            final Object value,int start,int count) {
        log("finding " + getClassName() + " instance with property: "
                + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from " + getClassName() + " model where model."
                    + propertyName + "= :propertyValue";
            Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            query.setFirstResult(start);
            query.setMaxResults(count);
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find by property name failed",
                    Level.SEVERE, re);
            throw re;
        }
    }
    
    public long countByProperty(String propertyName,final Object value){
    	 log("counting " + getClassName() + " instance with property: "
                 + propertyName + ", value: " + value, Level.INFO, null);
         try {
             final String queryString = "select count(*) from " + getClassName() + " model where model."
                     + propertyName + "= :propertyValue";
             Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
             query.setParameter("propertyValue", value);
             return (Long)query.getSingleResult();
         } catch (RuntimeException re) {
             log("find by property name failed",
                     Level.SEVERE, re);
             throw re;
         }
    }
    
    /**
     * 查询表中有多少元素
     * @return
     */
    public long count4Table()
    {
    	log("counting " + getClassName() + " table ", Level.INFO, null);
        try 
        {
            final String queryString = "select count(*) from " + getClassName() + " model";
            Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
            return (Long)query.getSingleResult();
        } 
        catch (RuntimeException re) 
        {
            log("counting for table", Level.SEVERE, re);
            throw re;
        }
    }
    
    /**
     * 根据hql获取总的个数
     * @param query Query Object
     * @return
     */
    public long countByQuery(Query query){
   	 log("counting By query object" + getClassName() + query, Level.INFO, null);
        try {
            return (Long)query.getSingleResult();
        } catch (RuntimeException re) {
            log("counting By query object failed",Level.SEVERE, re);
            throw re;
        }
   }
    
    /**
     * 查找所有
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        log("finding all " + getClassName() + " instances", Level.INFO,
                null);
        try {
            final String queryString = "select model from " + getClassName() + " model";
            Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }
    /**
     * 查找从start开始的count个实体
     * @param start
     * @param count
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll(int start,int count){
    	log("finding " + count + getClassName() + " instances start from " + start, Level.INFO,
                null);
        try {
            final String queryString = "select model from " + getClassName() + " model";
            Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
            query.setFirstResult(start);
            query.setMaxResults(count);
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

 /**
	 * 根据查询语言获取对象
	 * 
	 * @param query 
	 * 			Query Object
	 * @return 返回的对象
	 */
	@SuppressWarnings("unchecked")
	public List<T> listByQuery(Query query, int start, int max)
	{
		log("query by Query object", Level.INFO, null);
		try
		{
			query.setFirstResult(start);
            query.setMaxResults(max);
			return query.getResultList();
		}
		catch (RuntimeException re)
		{
			log("query by Query object" + "failed", Level.SEVERE, re);
			throw re;
		}
	}
}
