package com.datasure.common.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface BaseDao<T> 
{
	// 根据ID加载实体
	T get(Class<T> entityClazz , Serializable id) throws DataAccessException;
	// 保存实体
	Serializable save(T entity) throws DataAccessException;
	// 更新实体
	void update(T entity) throws DataAccessException;
	// 删除实体
	void delete(T entity) throws DataAccessException;
	// 根据ID删除实体
	void delete(Class<T> entityClazz , Serializable id) throws DataAccessException;
	// 获取所有实体
	List<T> findAll(Class<T> entityClazz) throws DataAccessException;
	// 获取实体总数
	long findCount(Class<T> entityClazz) throws DataAccessException;
}