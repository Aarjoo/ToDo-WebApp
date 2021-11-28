package com.tcs.todoapp.Model;

import java.util.Date;

import javax.validation.constraints.Size;

public class ToDo
{
	private int id;
	private String user;
	
	@Size(min = 10, message="enter atleast 10 characters")
	private String desc;
	private boolean isDone;
	private Date date;
	public ToDo(int id, String user, String desc, boolean isDone, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.isDone = isDone;
		this.date = date;
	}
	public ToDo() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public boolean isDone() {
		return isDone;
	}
	
	public boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", user=" + user + ", desc=" + desc + ", isDone=" + isDone + ", date=" + date + "]";
	}
	
	
}