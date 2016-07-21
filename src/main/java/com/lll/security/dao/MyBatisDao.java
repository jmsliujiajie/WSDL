package com.lll.security.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lll.util.orm.MyBatisPage;

/**
 * @description Mybatis的dao基类
 * @date 20130426
 */
public class MyBatisDao extends SqlSessionDaoSupport implements IMyBatisDao {
	private static Logger logger = LoggerFactory.getLogger(MyBatisDao.class);
	
	/** 
	 * @description  保存并返回boolean类型
	 * @date 2013-5-4 
	 * @param key
	 * @param object
	 * @return true or false
	 */
	public boolean saveAndReturnFlag(String key, Object object) {
		 boolean flag = false;
		try {
			logger.debug(" 执行增加 ");
			flag = this.getSqlSession().insert(key, object) > 0 ? true : false;
			logger.debug(" 对应Mapper: = " + key);
			logger.debug(" Mapper入参: = " + object);
		} catch (Exception e) {
			logger.error("执行 SQL " + key + " 出错 ！！！！" + e.getMessage());
			return false;
		}
		return flag;
	}
	
	/** 
	 * @description  通过主键删除，并返回boolean类型
	 * @date 2013-5-4 
	 * @param key
	 * @param id
	 * @return	true or false
	 */
	public boolean deleteByIdAndReturnFlag(String key, Serializable id) {
		boolean flag = false;
		try {
			logger.debug(" 执行删除  按id删除");
			flag = getSqlSession().delete(key, id)> 0 ? true : false;
			logger.debug(" 对应Mapper: = " + key);
			logger.debug(" Mapper入参: = " + id);
		} catch (Exception e) {
			flag=false;
			logger.error("执行 SQL " + key + " 出错 ！！！！" + e.getMessage());
		}
		return flag;
	}
	/** 
	 * @description  通过OBJ删除，并返回boolean类型
	 * @date 2013-5-4 
	 * @param key
	 * @param Obj
	 * @return	true or false
	 */
	public boolean deleteByOjbAndReturnFlag(String key, Object object) {
		boolean flag = false;
		try {
			logger.debug(" 执行删除  按id删除");
			flag = getSqlSession().delete(key, object)> 0 ? true : false;
			logger.debug(" 对应Mapper: = " + key);
			logger.debug(" Mapper入参: = " + object);
		} catch (Exception e) {
			flag=false;
			logger.error("执行 SQL " + key + " 出错 ！！！！" + e.getMessage());
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String key, Object params) {
		try {
			logger.debug(" 执行查询-返回<T>");
			logger.debug(" 对应Mapper: = " + key);
			logger.debug(" Mapper入参: = " + params);
			return (T) getSqlSession().selectOne(key, params);
		} catch (Exception e) {
			logger.error("执行 SQL " + key + " 出错 ！！！！" + e.getMessage());
			return null;
		}

	}

	
	/** 
	 * @description  通过OBJ修改，并返回boolean类型
	 * @date 2013-5-4 
	 * @param key
	 * @param obj
	 * @return	true or false
	 */
	public boolean updateByObjAndReturnFlag(String key, Object object) {
		boolean flag = false;
		try {
			logger.debug(" 执行修改");
			logger.debug(" 对应Mapper: = " + key);
			logger.debug(" Mapper入参: = " + object);
			flag = getSqlSession().update(key, object)> 0 ? true : false;
		} catch (Exception e) {
			flag=false;
			logger.error("执行 SQL " + key + " 出错 ！！！！" + e.getMessage());
		}
		return flag;
	}

	public <T> List<T> getList(String key) {
		try {
			logger.debug(" 执行查询-返回List<T>，无入参");
			logger.debug(" 对应Mapper: = " + key);
			logger.debug(" Mapper入参: = " + "空");
			return getSqlSession().selectList(key);
		} catch (Exception e) {
			logger.error("执行 SQL " + key + " 出错 ！！！！" + e.getMessage());
			return null;
		}
	}

	public <T> List<T> getList(String key, Object params) {
		try {
			logger.debug(" 执行查询-返回List<T>，有入参");
			logger.debug(" 对应Mapper: = " + key);
			logger.debug(" Mapper入参: = " + params);
			return getSqlSession().selectList(key, params);
		} catch (Exception e) {
			logger.error("执行 SQL " + key + " 出错 ！！！！" + e.getMessage());
			return null;
		}
	}

	public int getCount(String key, Map<String, Object> conditions) {
		return Integer.parseInt(getSqlSession().selectOne(key, conditions)
				.toString());
	}

	/**
	 * @description 加载分页方法，查询sql的结果count set进MyBatisPage中
	 * @date 2013-4-27
	 * @param key
	 * @param page
	 * @param conditions
	 */
	public void initPage(String key, MyBatisPage page,
			Map<String, Object> conditions) {
		int total = page.getTotalCount();
		if (total == -1) {
			try {
				int lastPoint = key.lastIndexOf(".");
				key = key.substring(0,lastPoint)+".cnt_"+key.substring(lastPoint+1, key.length());
				logger.debug(" 准备执行initPage: = " + key);
				total = get(key, conditions);
				logger.debug(" 对应Mapper: = " + key);
				logger.debug(" 传入Map参数: = " + conditions);
				logger.debug("Total Count: " + String.valueOf(total));
				page.setTotalCount(total);
			} catch (Exception e) {
				logger.error("执行 SQL " + key + " 出错 ！！！！" + e.getMessage());
			}

		}

	}

	/**
	 * @description 分页基类
	 * @date 2013-4-27
	 * @param key
	 * @param page
	 * @param conditions
	 */
	public <T> List<T> getPageList(String key, MyBatisPage page,
			Map<String, Object> conditions) {
		try {
			if (page == null)
				return null;
			initPage(key, page, conditions);
			int page_end = page.getFirst() + page.getPageSize() - 1;
			conditions.put("start", page.getFirst());
			conditions.put("end", page_end);
			
			if (!"".equals(page.getOrder()) && null != page.getOrder()) {
				conditions.put("order", page.getOrder());
				conditions.put("orderBy", page.getOrderBy());
			}
			int lastPoint = key.lastIndexOf(".");
			key = key.substring(0,lastPoint)+".page_"+key.substring(lastPoint+1, key.length());
			logger.debug(" 当前页数：" + page.getPageNo());
			logger.debug(" 当前每页条数：" + page.getPageSize());
			logger.debug(" 对应Mapper: = " + key);
			logger.debug(" 传入Map参数: = " + conditions);
			return getSqlSession().selectList(key, conditions);
		} catch (Exception e) {
			logger.error("执行 SQL " + key + " 出错 ！！！！" + e.getMessage());
			return null;
		}
	}

}
