package com.ldw.joke;

public class JokePicture
{
	//这里定义的名字必须和json里的名字一样
	String showapi_res_code = null;
	String showapi_res_error = null;
	Body showapi_res_body = null;
	
	

	public Body getShowapi_res_body()
	{
		return showapi_res_body;
	}

	public void setShowapi_res_body(Body showapi_res_body)
	{
		this.showapi_res_body = showapi_res_body;
	}

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

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "showapi_res_code = " +showapi_res_code + "showapi_res_error = "+showapi_res_error ;
	}
	
	
}
