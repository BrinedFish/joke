package com.ldw.joke;

import java.util.List;

public class Body
{
	String allNum = null;
	String allPages = null;
	List<Contentlist> contentlist = null;
	String currentPage = null;
	String maxResult = null;
	
	
	
	public List<Contentlist> getContentlist()
	{
		return contentlist;
	}
	public void setContentlist(List<Contentlist> contentlist)
	{
		this.contentlist = contentlist;
	}
	public String getAllNum()
	{
		return allNum;
	}
	public void setAllNum(String allNum)
	{
		this.allNum = allNum;
	}
	public String getAllPages()
	{
		return allPages;
	}
	public void setAllPages(String allPages)
	{
		this.allPages = allPages;
	}
	public String getCurrentPage()
	{
		return currentPage;
	}
	public void setCurrentPage(String currentPage)
	{
		this.currentPage = currentPage;
	}
	public String getMaxResult()
	{
		return maxResult;
	}
	public void setMaxResult(String maxResult)
	{
		this.maxResult = maxResult;
	}
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub

		return "allNum"+allNum+"allPages"+allPages+"currentPage"+currentPage+"maxResult"+maxResult;
	}
	
	
}
