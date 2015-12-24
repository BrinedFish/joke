package com.ldw.joke;

public class Contentlist
{
	String ct = null;
	String img = null;
	String title = null;
	String type = null;
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
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "ct = " +"img = "+img + "title = " + "type = " + type;
	}
	
	
}
