<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>新添</title>
<script type="text/javascript" src="JS/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="csshiqq/explain.css">
</head>
<body>
	<hr>
	<div id="content">
		<form action="AddStudentAction.action" method="post">
			<table>
				<tr>
					<td>姓名</td>
					<td><input name="stu.name" type="text" value="${stu.name}">
						<input name="stu.studentId" type="hidden" value="${stu.studentId}"><label>当然真实姓名最好</label></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="radio" name="stu.sex" value="男"
						checked="checked" />男 <input type="radio" name="stu.sex" value="女" />女&nbsp;<label>随便填d=====(￣▽￣*)b，反正不会是人妖</label></td>
				</tr>
				<tr>
					<td>报道时间</td>
					<td><select name="stu.arriveTime">
							<option value="2016-7-2">2016-7-2</option>
							<option value="2016-7-16">2016-7-16</option>
					</select></td>
				</tr>
				<tr>
					<td>报道地点</td>
					<td><select name="stu.position">
							<option value="深圳">深圳</option>
							<option value="上海">上海</option>
							<option value="北京">北京</option>
					</select><label>应该就这几个地方吧(。﹏。*)</label></td>
				</tr>
				<tr>
					<td>爱好</td>
					<td><input name="stu.hobby" type="text" value="${stu.hobby}"><label>一定要认真填哟，哈哈，找好室友就靠它了</label></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input name="stu.remark" type="text" value="${stu.remark}"><label>打呼噜？(*￣3￣)╭求包养？</label></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input name="stu.phone" type="text" value="${stu.phone}"><label>必须填一个呀！</label></td>
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
					<td>口令提示</td>
					<td><input name="stu.question" type="text"
						value="${stu.question}"><label>修改，删除全靠它！</label></td>
				</tr>
				<tr>
					<td>口令</td>
					<td><input name="stu.answer" type="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input name="add" type="submit" value="添加"></td>
				</tr>
			</table>

		</form>
	</div>
	${message}
</body>
</html>
