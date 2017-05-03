/**
 * 
 */
package com.mango.jtt.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author HHL
 *
 * @date 2016Äê11ÔÂ30ÈÕ
 */
@Repository
public class MangoDaoImpl implements IMangoDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
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
	public Object get(Class clazz, String productId) {
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
