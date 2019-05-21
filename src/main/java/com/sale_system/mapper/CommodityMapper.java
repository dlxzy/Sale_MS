package com.sale_system.mapper;

import java.util.List;
import java.util.Map;

import com.sale_system.pojo.Commodity;

public interface CommodityMapper {
	
	  public Commodity selectCommodityById(int id);//只查询一个，常用于修改  
	  
	  public List<Commodity> selectAllCommodity(Map<String,Object> map);//根据条件查询多个结果
	  
	  public int insertCommodity(Commodity commodity);//插入，用实体作为参数  
	  
	  public int updateCommodity(Commodity commodity);//修改，用实体作为参数  
	  
	  public int deleteCommodityById(int id);//按id删除，删除一条

}
