package org.com.jaggi.messenger.model;

import java.util.Date;

public class Comment {

	private int id;
	private String comment;
	private String author;
	private Date created;
	
	
	public Comment(){
		
	}
	
	public Comment(int id,String comment,String author){
		
		this.id = id;
		this.comment = comment;
		this.author = author;
		created = new Date();
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
}
