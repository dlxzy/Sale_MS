<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品销售系统首页</title>
  </head>
  
  <body>
    <h1>商品销售系统</h1>
    <hr/>
    <a href="toAdd.action">
    <button style="background-color:#173e65;color:#ffffff;width:70px;">添加</button>
    </a>
  	<c:if test="${commodityList!=null}">
	  <table style="margin-top: 10px;width:700px;text-align:center;" border=1>  
	    <tr>  
	      <td>序号</td><td>商品名称</td><td>价格</td><td>商品描述</td>
	      <td>重量</td><td>型号规格</td>
	   </tr>  
      	 <c:forEach items="${commodityList}" var="item" varStatus="status">  
		     <tr>  
		       <td>${status.index+1}</td><td>${item.name }</td>
		       <td>${item.price}</td><td>${item.desc }</td>  
		       <td>${item.weight}</td><td>${item.model}</td>
		     </tr>  
	     </c:forEach>  
	    </table> 
   </c:if>
   <c:if test="${commodityList==null}">
       <b>搜索结果为空！</b>
   </c:if>
  </body>
</html>
 

