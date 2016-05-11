package com.Action;

import org.apache.struts2.ServletActionContext;

import com.Beans.StudentBean;
import com.DBUtility.SqlStudent;
import com.Utility.MD5;
import com.opensymphony.xwork2.ActionSupport;

public class KeyPass2Action extends ActionSupport{
	private int studentId=-1;
	private String message;
	private StudentBean stu;
	private String answer2=null;
	boolean b1;
	boolean b2;
	public String execute()
	{
		SqlStudent ss=new SqlStudent();
		stu=ss.getStuBean(studentId);
		String pwd=(String) ServletActionContext.getRequest().getSession().getAttribute("pwd");
		b1=null==pwd;
		if(b1)
		{//如果session中没有保存过口令
			if(answer2==null)
			{//从index跳转来
				return LOGIN;
			}else{
				//从提交口令页跳转来，验证口令是否对应正确
				b2=MD5.stringMD5(answer2).equals(stu.getAnswer());
				if(b2)
				{
					if(ss.delStudent(studentId))
					{
						return SUCCESS;
					}else{
						return ERROR;
					}
					
				}else{
					message="输入错误";
					return LOGIN;
				}
			}
		}else{
			//session中已经有口令，判断匹配
			try{
				if(pwd.equals(stu.getAnswer())||MD5.stringMD5(answer2).equals(stu.getAnswer()))
				{
					if(ss.delStudent(studentId))
					{
						return SUCCESS;
					}else{
						return ERROR;
					}
				}else{
					message="口令不匹配";
					return LOGIN;
				}
			}catch(Exception es){
				message="口令不匹配";
				return LOGIN;
			}
		}
	}
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public StudentBean getStu() {
		return stu;
	}
	public void setStu(StudentBean stu) {
		this.stu = stu;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	
}
