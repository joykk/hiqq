package com.Action;
import java.util.Date;

import com.Beans.StudentBean;
import com.DBUtility.SqlStudent;
import com.Utility.MD5;
import com.opensymphony.xwork2.ActionSupport;
public class AddStudentAction extends ActionSupport {
	private StudentBean stu;
	private String message;
	public String execute()
	{
		pagebean();
		SqlStudent ss=new SqlStudent();
		if(ss.insert(stu))
		{
			message="添加成功";
			return SUCCESS;
		}
		else{
			message="添加失败";
			return ERROR;
		}
	}
	/**
	 * 封装Bean
	 */
	public void pagebean()
	{
		stu.setStatus("是");//默认"是"
		stu.setUpdateTime(new Date());//当前时间
		stu.setAnswer(MD5.stringMD5(stu.getAnswer()));//加密
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
