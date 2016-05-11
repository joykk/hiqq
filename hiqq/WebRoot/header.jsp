<%@ page pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="csshiqq/header.css">
<%@taglib prefix="s" uri="/struts-tags" %>
<div id="header">
<div id="hd1">
<h1>合租信息交流</h1>
<form action="SerchAcation.action" method="post">
<input class="search" name="search" type="text"  style="width: 80%" value="${search}"/><button type="submit">搜索</button><a href="explain.jsp">搜索说明</a>
</form>
</div>
	<div id="add">
	<a id="add" href="addStudent.jsp">我要加入</a>&nbsp;&nbsp;<s:a action="IndexAction.action">刷新</s:a>
	<br><br>
	${message}
	</div>
	<div id="out">
	<a id="out" href="#">EXIT</a>
	</div>
</div>