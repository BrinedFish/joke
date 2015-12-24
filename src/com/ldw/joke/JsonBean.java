package com.ldw.joke;

import java.util.List;

public class JsonBean
{
	String showapi_res_code = null;
	String showapi_res_error = null;
	
	public String getShowapi_res_code()
	{
		return showapi_res_code;
	}

	public void setShowapi_res_code(String showapi_res_code)
	{
		this.showapi_res_code = showapi_res_code;
	}

	public String getShowapi_res_error()
	{
		return showapi_res_error;
	}

	public void setShowapi_res_error(String showapi_res_error)
	{
		this.showapi_res_error = showapi_res_error;
	}

	public static class Body
	{
		public static  String allNum = null;
		public static String allPages = null;
		public static  List<Contentlist> mList = null;
		public static class Contentlist
		{
			public static String ct = null;
			public static String img = null;
			public static String title = null;
			public static String type = null;
			public String getCt()
			{
				return ct;
			}
			public void setCt(String ct)
			{
				this.ct = ct;
			}
			public String getImg()
			{
				return img;
			}
			public void setImg(String img)
			{
				this.img = img;
			}
			public String getTitle()
			{
				return title;
			}
			public void setTitle(String title)
			{
				this.title = title;
			}
			public String getType()
			{
				return type;
			}
			public void setType(String type)
			{
				this.type = type;
			}
			
		}
		public static String currentPage = null;
		public static String maxResult = null;
		public static String getAllNum()
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
		public List<Contentlist> getmList()
		{
			return mList;
		}
		public void setmList(List<Contentlist> mList)
		{
			this.mList = mList;
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
		
		
	}
}
