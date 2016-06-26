package com.datasure.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.datasure.common.dao.BaseDao;

public class BaseDaoHibernate3<T> extends HibernateDaoSupport
implements BaseDao<T>
{
	// 根据ID加载实体
	public T get(Class<T> entityClazz, Serializable id) 
				throws DataAccessException
	{
		return getHibernateTemplate().get(entityClazz, id);
	}
	
	// 保存实体
	public Serializable save(T entity) throws DataAccessException
	{
		return getHibernateTemplate().save(entity);
	}
	
	// 更新实体
	public void update(T entity) throws DataAccessException
	{
		getHibernateTemplate().saveOrUpdate(entity);
	}
	
	// 删除实体
	public void delete(T entity) throws DataAccessException
	{
		getHibernateTemplate().delete(entity);
	}
	
	// 根据ID删除实体
	public void delete(Class<T> entityClazz, Serializable id)
				throws DataAccessException
	{
		delete(get(entityClazz , id));
	}
	
	//根据HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) throws DataAccessException{
		return (List<T>)getHibernateTemplate().find(hql);
	}
	
	//根据带参数的HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object...params) throws DataAccessException{
		
		//创建查询
		Query query = getSession().createQuery(hql);
		//设置参数
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i+"", params[i]);
		}
		return (List<T>) query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> entityClazz) throws DataAccessException
	{
		return (List<T>)getHibernateTemplate().find("select en from "
			+ entityClazz.getSimpleName() + " en");
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public long findCount(Class<T> entityClazz) throws DataAccessException
	{
		List<Long> list = (List<Long>)getHibernateTemplate().find(
			"select count(*) from " + entityClazz.getSimpleName() + " en");
		return list.get(0);
	}
	/**
	 * 使用hql 语句进行分页查询操作
	 * @param hql 需要查询的hql语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(final String hql,
		final int pageNo, final int pageSize) throws DataAccessException
	{
		// 通过一个HibernateCallback对象来执行查询
		List<T> list = getHibernateTemplate()
			.execute(new HibernateCallback<List<T>>()
		{
			// 实现HibernateCallback接口必须实现的方法
			public List<T> doInHibernate(Session session)
			{
				// 执行Hibernate分页查询
				List<T> result = session.createQuery(hql)
					.setFirstResult((pageNo - 1) * pageSize)
					.setMaxResults(pageSize)
					.list();
				return result;
			}
		});
		return list;
	}
	
	/**
	 * 使用hql 语句进行分页查询操作
	 * @param hql 需要查询的hql语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @param params 如果hql带占位符参数，params用于传入占位符参数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(final String hql , final int pageNo, 
		final int pageSize , final  Object... params) throws DataAccessException
	{
		// 通过一个HibernateCallback对象来执行查询
		List<T> list = getHibernateTemplate()
			.execute(new HibernateCallback<List<T>>()
		{
			// 实现HibernateCallback接口必须实现的方法
			public List<T> doInHibernate(Session session)
			{
				// 执行Hibernate分页查询
				Query query = session.createQuery(hql);
				// 为包含占位符的HQL语句设置参数
				for(int i = 0 , len = params.length ; i < len ; i++)
				{
					query.setParameter(i + "" , params[i]);
				}
				List<T> result = query.setFirstResult((pageNo - 1) * pageSize)
					.setMaxResults(pageSize)
					.list();
				return result;
			}
		});
		return list;
	}
}
