package com.qh.cloud.dao;

import java.util.List;

import com.qh.cloud.utils.PageUtils;

/**
 * 基类Dao
 * @author QingHang
 * @date 2017年1月11日
 */
public interface BaseDao<T> {
	
	//获取所有
	public List<T> findList();
	
	//查询总数
	public Integer findCount();
	
	//根据条件分页查找
	public List<T> findByParam(PageUtils<T> pageUtils);
	
	//根据条件查找总数
	public Integer findCountByParam(PageUtils<T> pageUtils);
	
	//根据id进行查询
	public T findById(Long id);
	public T findById(int id);
	
	//保存
	public int save(T t);
	
	//修改
	public int update(T t);
	
	// 删除
	public int deleteById(int id);
	public int deleteById(Long id);
	
	//批量插入
	public void batchSave(List<T> list);
	
	//批量更新
	public void batchUpdate(List<T> list);
	
	//批量删除
	public void batchDelete(List<T> list);
	
}
