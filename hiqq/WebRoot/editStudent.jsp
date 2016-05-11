<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改</title>
<script type="text/javascript" src="JS/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="csshiqq/explain.css">
</head>
<body>
 <hr>
 <form action="UpdateAction.action" method="post">
   <table>
     <tr>
       <td>姓名</td>
       <td><input name="stu.name" type="text" value="${stu.name}"> 
       <input name="stu.studentId" type="hidden" value="${stu.studentId}"></td>
     </tr>
      <tr>
       <td>性别</td>
       <td><input type="radio" name="stu.sex" value="男" checked="checked"/>男 
       <input type="radio" name="stu.sex" value="女"  />女</td>
     </tr>
     <tr>
       <td>报道时间</td>
       <td>
       <select name="stu.arriveTime" >
		  <option value ="2016-7-2">2016-7-2</option>
		  <option value ="2016-7-16">2016-7-16</option>
		</select>
		</td>
     </tr>
      <tr>
       <td>报道地点</td>
       <td> 
       <select name="stu.position">
		  <option value ="深圳">深圳</option>
		  <option value ="上海">上海</option>
		  <option value ="北京">北京</option>
		</select>
		</td>
     </tr>
       <tr>
       <td>爱好</td>
       <td><input name="stu.hobby" type="text" value="${stu.hobby}"></td>
     </tr>
      <tr>
       <td>备注</td>
       <td><input name="stu.remark" type="text" value="${stu.remark}"></td>
     </tr>
      <tr>
       <td>电话</td>
       <td><input name="stu.phone" type="text" value="${stu.phone}"></td>
     </tr>
      <tr>
       <td>微信</td>
       <td><input name="stu.wechat" type="text" value="${stu.wechat}"></td>
     </tr>
      <tr>
       <td>qq</td>
       <td><input name="stu.qq" type="text" value="${stu.qq}"></td>
     </tr>
      <tr>
       <td></td>
       <td><input name="add" type="submit" value="更新"></td>
     </tr>
   </table>
 </form>
 ${message}
</body>
</html>
