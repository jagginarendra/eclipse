package org.com.jaggi.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	private int id;
	private String postedBy;
	private Date createdOn;
	private String message;
	private Map<Integer,Comment> comments = new HashMap<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public Message(){
		
	}
	
	@XmlTransient
	public Map<Integer, Comment> getComments() {
		return comments;
	}
	
	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}
	public Message(int id,Date createdOn,String message,String postedBy){
		
		this.id = id;
		this.createdOn = createdOn;
		this.postedBy = postedBy;
		this.message = message;
		
	}
	
}
