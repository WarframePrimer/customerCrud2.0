<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
        <title>客户信息列表</title>
        <link href="<%=basePath %>css/all.css" rel="stylesheet" type="text/css" />
    </head>
    <body style="background: #e1e9eb;">
        <form action="#" id="mainForm" method="post">
            <div class="right">
                <div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
                <div class="rightCont">
                    <p class="g_title fix">内容列表 <a class="btn03" href='<c:url value="/customer/save"/>'>新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href='<c:url value="/customer/batchedDeleteCustomers.do"/>'>删 除</a></p>
                    <table class="tab1">
                        <tbody>
                            <tr>
                                <td width="90" align="right">查询条件1:</td>
                                <td>
                                    <input type="text" class="allInput" value=""/>
                                </td>
                                <td width="90" align="right">演示字段2：</td>
                                <td>
                                    <input type="text" class="allInput" value=""/>
                                </td>
                                <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="zixun fix">
                        <table class="tab2" width="100%">
                            <tbody>
                                <tr>
                                    <th><input type="checkbox" id="all" onclick="#"/></th>
                                    <th>客户编号</th>
						            <th>客户姓名</th>
						            <th>性别</th>
						            <th>客户出生日期</th>
						            <th>联系方式</th>
						            <th>邮箱地址</th>
						            <th>客户描述</th> 
                                    <th>操作</th>
                                </tr>
                             
                                
                                <c:forEach items="${page.list}" var="customer" varStatus="status">
                                
                                	<c:if test="${status.count %2 eq 0 }">
                                		<tr style="background-color:#ECF6EE;">
                                	</c:if>
                                   	<c:if test="${status.count %2 eq 1 }">
                                   	
                                   		<tr>
                                   	</c:if>
                                   	
                                        <td><input type="checkbox" /></td>
                                        <td>${customer.cid }</td>
                                        <td>${customer.cname }</td>
                                        <td>${customer.gender }</td>
                                        <td>${customer.birthday }</td>
						               <td>${customer.cellphone }</td>
						               <td>${customer.email }</td>
						               <td>${customer.description }</td>
                                        <td>
                                            <a href='<c:url value="/customer/preUpdate.do?cid=${customer.cid }"/>'>修改</a>&nbsp;&nbsp;&nbsp;
                                            <a href='<c:url value="/customer/deleteCustomer.do?cid=${customer.cid }"/>'>删除</a>
                                        </td>
                                        
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class='page fix'>
                            共 <b>${page.totalPage }</b> 条
                            <a href='<c:url value="/customer/listCustomerByPage?pageNow=1"/>' class='first'>首页</a>
                            <c:if test="${page.hasPre }">
                            	<a href='<c:url value="/customer/listCustomerByPage?pageNow=${page.pageNow-1 }"/>' class='pre'>上一页</a>
                            </c:if>
                            
                            当前第<span>${page.pageNow } / ${page.totalPage }</span>页
                            <c:if test="${page.pageNow<page.totalPage }">
                            	<a href='<c:url value="/customer/listCustomerByPage?pageNow=${page.pageNow+1 }"/>' class='next'>下一页</a>
                            </c:if>
                            <a href='<c:url value="/customer/listCustomerByPage?pageNow=${page.totalPage }"/>' class='last'>末页</a>
                            跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
                            <a href='###' class='go'>GO</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>