package com.Action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.Beans.StudentBean;
import com.DBUtility.SqlStudent;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 访问权限
 * @author zhangyi
 *
 */
public class IndexAction extends ActionSupport{
	private String key;//与form一致
	private ArrayList<StudentBean> studentList;
	private static String passkey="123";
	public String execute()
	{
		if(ServletActionContext.getRequest().getSession().getAttribute("passkey")!=null)
		{
			SqlStudent ss=new SqlStudent();
			studentList=ss.getStudentList(1);
			return SUCCESS;
		}
		try{
			if(key.equals(passkey))
			{
				ServletActionContext.getRequest().getSession().setAttribute("passkey", passkey);
				SqlStudent ss=new SqlStudent();
				studentList=ss.getStudentList(1);
				return SUCCESS;
			}
		}catch(Exception e){}
		return LOGIN;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public ArrayList<StudentBean> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<StudentBean> studentList) {
		this.studentList = studentList;
	}
	
}
