package org.com.jaggi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.com.jaggi.messenger.database.DatabaseClass;
import org.com.jaggi.messenger.model.Comment;
import org.com.jaggi.messenger.model.Message;

public class CommentService {

	private static Map<Integer,Message> messages =	DatabaseClass.getMessages();
	
	
	public List<Comment> getAllComments(int messageId){
		
		Map<Integer,Comment> comments = messages.get(messageId).getComments();
		
		return new ArrayList<Comment>(comments.values());
	}
	

	public Comment getCommenet(int messageId,int commentId){
		System.out.println("CommentService getComment()");
		Map<Integer,Comment> comments = messages.get(messageId).getComments();
		
		return comments.get(commentId);
	}
	
	
	public Comment addComment(int messageId,Comment comment){
		
		System.out.println("CommentService addComment()");
		Map<Integer,Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	
	
	
	public Comment removeComment(int messageId,int commentId){
		System.out.println("CommentService removeComment()");
		Map<Integer,Comment> comments = messages.get(messageId).getComments();
		
		return comments.remove(commentId);
	}


	public Comment updateComment(int messageId, Comment comment) {
		// TODO Auto-generated method stub
		System.out.println("CommentService updateComment()");
		Map<Integer,Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() == 0)
		return null;
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	
	
	
}
