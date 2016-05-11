package com.Action;

import java.util.Date;

import com.Beans.StudentBean;
import com.DBUtility.SqlStudent;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport{
	private String studentId;
	private StudentBean stu;
	private String message;
	public String execute()
	{
		stu.setUpdateTime(new Date());
		SqlStudent ss=new SqlStudent();
		if(ss.updateStudent(stu))
		{
			message="更新成功";
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public StudentBean getStu() {
		return stu;
	}
	public void setStu(StudentBean stu) {
		this.stu = stu;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
