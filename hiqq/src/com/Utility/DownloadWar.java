package com.Utility;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadWar extends ActionSupport {

	public String execute()
	{
		try {
			download(ServletActionContext.getResponse());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	private boolean download(HttpServletResponse response) throws IOException {
		int status = 0;
		byte b[] = new byte[1024];
		FileInputStream in = null;
		ServletOutputStream out2 = null;
		try {
			response.setHeader("content-disposition",
					"attachment; filename=hiqq.war");
			in = new FileInputStream("/usr/tomcat/tomcat/webapps/hiqq.war");
			out2 = response.getOutputStream();
			while (status != -1) {
				status = in.read(b);
				out2.write(b);
			}
			out2.flush();
			return true;
		} catch (Exception e) {
			System.out.println("GG你来晚了");
		} finally {
			if (in != null)
				in.close();
			if (out2 != null)
				out2.close();
		}
		return false;
	}
}
