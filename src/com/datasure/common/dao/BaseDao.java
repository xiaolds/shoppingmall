package com.datasure.common.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface BaseDao<T> 
{
	// ����ID����ʵ��
	T get(Class<T> entityClazz , Serializable id) throws DataAccessException;
	// ����ʵ��
	Serializable save(T entity) throws DataAccessException;
	// ����ʵ��
	void update(T entity) throws DataAccessException;
	// ɾ��ʵ��
	void delete(T entity) throws DataAccessException;
	// ����IDɾ��ʵ��
	void delete(Class<T> entityClazz , Serializable id) throws DataAccessException;
	// ��ȡ����ʵ��
	List<T> findAll(Class<T> entityClazz) throws DataAccessException;
	// ��ȡʵ������
	long findCount(Class<T> entityClazz) throws DataAccessException;
}