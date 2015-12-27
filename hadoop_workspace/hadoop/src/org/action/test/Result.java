package org.action.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Result extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2720342705973759842L;
	String query;
	List<String> list2;
	List<String> list;
	
	
	public List<String> getList2() {
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(request.getParameter("data"));
		System.out.println(query);
		list2=new ArrayList<String>();
		list2.add("aaaa");
		list2.add("bbaa");
		list2.add("cccca");
		return list2;
	}

	public void setList2(List<String> list2) {
		this.list2 = list2;
	}

	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<String> getList() {
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(request.getParameter("data"));
		System.out.println(query);
		list=new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		return list;
		
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
