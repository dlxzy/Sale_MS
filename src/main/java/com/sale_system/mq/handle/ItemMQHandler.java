package com.sale_system.mq.handle;
 
//import java.io.IOException;
//import java.util.List;
import java.util.Map;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import com.sale_system.pojo.Commodity;
import com.sale_system.service.CommodityService;
 
public class ItemMQHandler {
	
	@Autowired
	private CommodityService commodityService;
	   
//	/**
//	 * 更新数据库中的商品数据，完成数据同步
//	 * @throws IOException 
//	 * @throws ServletException 
//	 * */
//	@SuppressWarnings("unchecked")
//	public void execute(HttpServletRequest request,HttpServletResponse response,String msg) throws ServletException, IOException{
//		if(!StringUtils.isNullOrEmpty(msg)){
//			Map<String,Object> msgMap = (Map<String, Object>) JSON.parse(msg);
//			//获取商品同步信息
//			String jsonStr = (String) msgMap.get("itemObject");
//			JSONObject jsonObject = JSON.parseObject(jsonStr);
//			Commodity commodity = convertMapToCommodity(jsonObject);
//			//获取同步类型
//			String type = (String) msgMap.get("type");
//			if(type.equals("insert")){
//				commodityService.insertCommodity(commodity);
//			}else if(type.equals("update")){
//				if(commodityService.selectCommodityById(commodity.getId())!=null){
//					//如果ID存在，进行编辑
//					commodityService.updateCommodity(commodity);
//				}else{
//					//如果ID不存在，执行插入操作
//					commodityService.insertCommodity(commodity);
//				}
//			}else if(type.equals("delete")){
//				if(commodityService.selectCommodityById(commodity.getId())!=null){
//					//如果ID存在，进行删除
//					commodityService.deleteCommodityById(commodity.getId());
//				}
//			}
//			
//			if(!(type.equals(""))||type!=null){
//				List<Commodity> commodityList = commodityService.selectAllCommodity(null);
//				request.setAttribute("commodityList",commodityList);
//				 request.getRequestDispatcher("/commodity/home.jsp").forward(request, response);  
//			}
//		}
//		
//	}
       
    
	/**
	 * 更新数据库中的商品数据，完成数据同步
	 * */
	@SuppressWarnings("unchecked")
	public void execute(String msg){
		if(!StringUtils.isNullOrEmpty(msg)){
			Map<String,Object> msgMap = (Map<String, Object>) JSON.parse(msg);
			//获取商品同步信息
			String jsonStr = (String) msgMap.get("itemObject");
			JSONObject jsonObject = JSON.parseObject(jsonStr);
			Commodity commodity = convertMapToCommodity(jsonObject);
			//获取同步类型
			String type = (String) msgMap.get("type");
			if(type.equals("insert")){
				commodityService.insertCommodity(commodity);
			}else if(type.equals("update")){
				if(commodityService.selectCommodityById(commodity.getId())!=null){
					//如果ID存在，进行编辑
					commodityService.updateCommodity(commodity);
				}else{
					//如果ID不存在，执行插入操作
					commodityService.insertCommodity(commodity);
				}
			}else if(type.equals("delete")){
				if(commodityService.selectCommodityById(commodity.getId())!=null){
					//如果ID存在，进行删除
					commodityService.deleteCommodityById(commodity.getId());
				}
			}
		}
	}
 
 
	private Commodity convertMapToCommodity(JSONObject jsonObject) {
		Commodity commodity = new Commodity();
		if(jsonObject!=null){
			if(jsonObject.get("id")!=null){
				commodity.setId(Integer.parseInt(jsonObject.get("id").toString()));
			}
			if(jsonObject.get("name")!=null){
				commodity.setName(jsonObject.get("name").toString());
			}
			if(jsonObject.get("price")!=null){
				commodity.setPrice(Double.parseDouble(jsonObject.get("price").toString()));
			}
			if(jsonObject.get("desc")!=null){
				commodity.setDesc(jsonObject.get("desc").toString());
			}
			if(jsonObject.get("weight")!=null&&!StringUtils.isNullOrEmpty(jsonObject.get("weight").toString())){
				commodity.setWeight(Integer.parseInt(jsonObject.get("weight").toString()));
			}
			if(jsonObject.get("model")!=null){
				commodity.setModel(jsonObject.get("model").toString());
			}
		}
		return commodity;
	}
}

