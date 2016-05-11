<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title></title>
  </head>
   <body style="width: 100%;height: 100%;margin: 0;padding: 0">
    <form action="KeyPass2Action.action" method="post">
    <div style="width: 200px;height: 50xp;margin: auto;padding: auto">
    口令提示:${stu.question}
      <input name="answer2" type="text">
    	<input name="注册" type="submit" value="校验">
    	<input name="studentId" type="hidden" value="${studentId}">
    	<input name="command" type="hidden" value="${command}">
    <br/>${message}
   </div>
    </form>
    <jsp:include page="footer.jsp" flush="true" />
  </body>
</html>
