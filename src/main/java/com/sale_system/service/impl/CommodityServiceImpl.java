package com.sale_system.service.impl;
 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sale_system.mapper.CommodityMapper;
import com.sale_system.pojo.Commodity;
import com.sale_system.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService{  
	@Autowired
	private CommodityMapper commodityMapper;
	
	//只查询一个，常用于修改  
	public Commodity selectCommodityById(int id){
		return commodityMapper.selectCommodityById(id);
	}
	//根据条件查询多个结果
    public List<Commodity> selectAllCommodity(Map<String,Object> map){
    	return commodityMapper.selectAllCommodity(map);
    }
    
    //插入，用实体作为参数  
    public boolean insertCommodity(Commodity commodity){
    	return commodityMapper.insertCommodity(commodity)>0;
    }
    //修改，用实体作为参数
    public boolean updateCommodity(Commodity commodity){
    	return commodityMapper.updateCommodity(commodity)>0;
    } 
    //按id删除，删除一条
    public boolean deleteCommodityById(int id){
    	return commodityMapper.deleteCommodityById(id)>0;
    }
}   
