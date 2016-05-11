<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>合租信息</title>
    <link rel="stylesheet" type="text/css" href="csshiqq/index.css">
  </head>
  <body>
 	 <div id="content">
    	<jsp:include page="header.jsp" flush="true" />
    	<hr/>
    	<hr/>
    	<table>
    	<s:iterator value="studentList" var="stu">
    	<tr>
    	<td >姓名:${stu.name}</td><td >性别:${stu.sex}</td><td >报道时间:${stu.arriveTime}</td><td>报道地点:${stu.position}</td><td >最后修改时间:${stu.updateTime}</td>
    	</tr>
    	<tr>
    	<td colspan="2">爱好:${stu.hobby}</td><td colspan="3">说明:${stu.remark}</td>
    	</tr>
    	<tr>
    	<td >电话:${stu.phone}</td><td >微信:${stu.wechat}</td><td >qq:${stu.qq}</td>
    	<td>
	    	<s:url id="edit" action="KeyPassAction">
	    		<s:param name="studentId">${stu.studentId}</s:param>
	    	</s:url>
	    	<s:a href="%{edit}">修改</s:a>
    	</td>
    	<td ><s:url id="del" action="KeyPass2Action">
	    		<s:param name="studentId">${stu.studentId}</s:param>
	    	</s:url>
	    	<s:a href="%{del}">删除</s:a></td>
    	</tr>
    	<tr><td colspan="5"><hr/></td></tr>
    	</s:iterator>
    	</table>
    </div>
    <jsp:include page="footer.jsp" flush="true" />
  </body>
</html>
