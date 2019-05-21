package com.sale_system.service;
 
import java.util.List;
import java.util.Map;

import com.sale_system.pojo.Commodity;
 
public interface CommodityService{  
	
	public Commodity selectCommodityById(int id);//只查询一个，常用于修改  
	
    public List<Commodity> selectAllCommodity(Map<String,Object> map);//根据条件查询多个结果
    
    public boolean insertCommodity(Commodity commodity);//插入，用实体作为参数  
    
    public boolean updateCommodity(Commodity commodity);//修改，用实体作为参数  
    
    public boolean deleteCommodityById(int id);//按id删除，删除一条
}   
