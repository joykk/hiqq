package com.Action;

import java.util.ArrayList;

import com.Beans.StudentBean;
import com.DBUtility.SqlStudent;
import com.opensymphony.xwork2.ActionSupport;

public class SerchAcation extends ActionSupport{

	private String search;//where条件部分
	private String message;
	private ArrayList<StudentBean> studentList;
	public String execute(){
		if(!checkSql(search))
		{//where里面没有更新和删除
			SqlStudent ss=new SqlStudent();
			studentList=ss.getStudentListBySearch(search);
			message="查询成功，符合条件的有"+studentList.size()+"条数据";
			return SUCCESS;
		}else{
			message="查询失败，注意限制条件里面不能出现update、delete等修改的关键字，也不能有分号";
			return ERROR;
		}
	}
	/**
	 * 检测search里面有没有关键字：update，delete
	 * @return
	 */
	private boolean checkSql(String search)
	{
		search=search.toUpperCase();
		return search.contains("UPDATE")||search.contains("DELETE")||
				search.contains("DROP")||search.contains("ALTER")||search.contains(";");
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<StudentBean> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<StudentBean> studentList) {
		this.studentList = studentList;
	}
	
}
