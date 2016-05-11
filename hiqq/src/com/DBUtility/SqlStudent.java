package com.DBUtility;

import java.sql.SQLException;
import java.util.ArrayList;

import com.Beans.StudentBean;
import com.mysql.jdbc.ResultSet;

public class SqlStudent {

	static int pagesize=2000;//分页大小，2000为未分页
	/**
	 *插入一个student
	 * @param student
	 * @return
	 */
	public boolean insert(StudentBean student) {
		String sql=String.format("insert into t_student (name,sex,arriveTime,"
				+ "position,phone,wechat,qq,status,hobby,remark,updateTime,question,"
				+ "answer)values('%s','%s','%s','%s','%s','%s','%s','%s','%s',"
				+ "'%s','%s','%s','%s');",student.getName(),student.getSex(),student.getArriveTime().toLocaleString(),
				student.getPosition(),student.getPhone(),student.getWechat(),student.getQq(),
				student.getStatus(),student.getHobby(),student.getRemark(),student.getUpdateTime().toLocaleString(),
				student.getQuestion(),student.getAnswer());
		try{
			boolean b=SqlHelper.executeNonQuery(sql)==1;
			SqlHelper.Close();
			return b;
		}catch(Exception es){
			
		}
		return false;
	}
	/**
	 *计算有多少页数据,获得最大页码
	 * @return
	 */
	public int countPage(){
		int count=-1;
		String sql="select count(*) from t_student";
		ResultSet rs=SqlHelper.executeQuery(sql);
		try {
			if(rs.next())
			{
				count=rs.getInt(0);
				count/=pagesize;
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return count;
	}
	/**
	 * 获得分页查询student
	 * @return
	 */
	public ArrayList<StudentBean> getStudentList(int page){
		page--;//同程序计数习惯一致
		String limt=" limit "+page*pagesize+","+(page+1)*pagesize;
		String sql="select * from t_student "+limt;
		ResultSet rs=SqlHelper.executeQuery(sql);
		ArrayList<StudentBean> studentList=new ArrayList<StudentBean>();
			try {
				while(rs.next())
				{
					StudentBean student=new StudentBean();
					student.setStudentId(rs.getInt("studentId"));
					student.setName(rs.getString("name"));
					student.setSex(rs.getString("sex"));
					student.setArriveTime(rs.getDate("arriveTime"));
					student.setPosition(rs.getString("position"));
					student.setPhone(rs.getString("phone"));
					student.setWechat(rs.getString("wechat"));
					student.setQq(rs.getString("qq"));
					student.setStatus(rs.getString("status"));
					student.setHobby(rs.getString("hobby"));
					student.setRemark(rs.getString("remark"));
					student.setUpdateTime(rs.getDate("updateTime"));
					student.setQuestion(rs.getString("question"));
					student.setAnswer(rs.getString("answer"));
					studentList.add(student);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				SqlHelper.Close();
			}
			return studentList;
	}
	/**
	 *从数据库 获得studentBean
	 * @param studentId
	 * @return
	 */
	public StudentBean getStuBean(int studentId) {
		String sql="select * from t_student where studentId ="+studentId;
		ResultSet rs=SqlHelper.executeQuery(sql);
		StudentBean student = null;
		try {
			if(rs.next())
			{
				student=new StudentBean();
				student.setStudentId(rs.getInt("studentId"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setArriveTime(rs.getDate("arriveTime"));
				student.setPosition(rs.getString("position"));
				student.setPhone(rs.getString("phone"));
				student.setWechat(rs.getString("wechat"));
				student.setQq(rs.getString("qq"));
				student.setStatus(rs.getString("status"));
				student.setHobby(rs.getString("hobby"));
				student.setRemark(rs.getString("remark"));
				student.setQuestion(rs.getString("question"));
				student.setAnswer(rs.getString("answer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return student;
	}
	/**
	 * 删除一条记录
	 * @param studentId
	 * @return
	 */
	public boolean delStudent(int studentId) {
		String sql="delete from t_student where studentId ="+studentId;
		boolean b=SqlHelper.executeNonQuery(sql)==1;
		SqlHelper.Close();
		return b;
	}
	/**
	 * 更新信息
	 * @param student
	 * @return
	 */
	public boolean updateStudent(StudentBean student)
	{
		String sql=String.format("update t_student set name='%s',sex='%s',arriveTime='%s',"
				+ "position='%s',phone='%s',wechat='%s',qq='%s',hobby='%s',"
				+ "remark='%s',updateTime='%s' where studentId='%s'",student.getName(),
				student.getSex(),student.getArriveTime().toLocaleString(),
				student.getPosition(),student.getPhone(),student.getWechat(),student.getQq(),
				student.getHobby(),student.getRemark(),student.getUpdateTime().toLocaleString(),
				student.getStudentId());
		System.out.println(sql);
		boolean b=SqlHelper.executeNonQuery(sql)==1;
		SqlHelper.Close();
		return b;
	}
	/**
	 * 按照where条件查询满足的student
	 * @param search
	 * @return
	 */
	public ArrayList<StudentBean> getStudentListBySearch(String search) {
		String sql="select * from t_student "+search;
		ResultSet rs=SqlHelper.executeQuery(sql);
		ArrayList<StudentBean> studentList=new ArrayList<StudentBean>();
			try {
				while(rs.next())
				{
					StudentBean student=new StudentBean();
					student.setStudentId(rs.getInt("studentId"));
					student.setName(rs.getString("name"));
					student.setSex(rs.getString("sex"));
					student.setArriveTime(rs.getDate("arriveTime"));
					student.setPosition(rs.getString("position"));
					student.setPhone(rs.getString("phone"));
					student.setWechat(rs.getString("wechat"));
					student.setQq(rs.getString("qq"));
					student.setStatus(rs.getString("status"));
					student.setHobby(rs.getString("hobby"));
					student.setRemark(rs.getString("remark"));
					student.setUpdateTime(rs.getDate("updateTime"));
					student.setQuestion(rs.getString("question"));
					student.setAnswer(rs.getString("answer"));
					studentList.add(student);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				SqlHelper.Close();
			}
			return studentList;
	}
}
