/**
 * 
 */
package com.mango.jtt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

/**
 * @author HHL
 *
 * @date 2016年11月30日
 */
@Repository
public class MangoDaoImpl implements IMangoDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	//定义一个获取jdbc连接的方法
	public Connection getConnection() throws SQLException {
		return SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
	}

	/* (non-Javadoc)
	 * @see com.mango.jtt.dao.MangoDao#list(java.lang.String)
	 */
	@Override
	public List list(String querySql, Map<String, Object> map) {
		Query<?> query = currentSession().createQuery(querySql);
		if (map != null) {
			for (String key : map.keySet()) {
				if (querySql.indexOf(":" + key) != -1) {
					query.setParameter(key, map.get(key));
				}
			}
		}
		return query.getResultList();
	}

	@Override
	public Object get(Class clazz, Long productId) {
		return currentSession().get(clazz, productId);
	}

	@Override
	public void saveBean(Object object) {
		currentSession().save(object);

	}

	@Override
	public void updateBean(Object object) {
		currentSession().update(object);

	}

}
