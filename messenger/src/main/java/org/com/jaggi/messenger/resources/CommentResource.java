package org.com.jaggi.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.com.jaggi.messenger.model.Comment;
import org.com.jaggi.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	CommentService commentService = new CommentService();
	
	
	@GET
	@Path("/{commentId}")
	public List<Comment> getAllComments(@PathParam("messageId") int messageId,@PathParam("commentId") int commentId)
	{
		System.out.println("getAllComments()");
		return commentService.getAllComments(messageId);
	}
		
	@POST
	public Comment addComment(@PathParam("messageId") int messageId,Comment comment ){
		
		System.out.println("addComment()");
		return commentService.addComment(messageId, comment);
	}
	
	
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") int messageId,@PathParam("commentId") int commentId,Comment comment){
		
		comment.setId(commentId);
		System.out.println("updateComment()");
		return commentService.updateComment(messageId, comment);
		
	}
	
	
	@DELETE
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_XML)
	public void deleteComment(@PathParam("messageId") int messageId,@PathParam("commentId") int commentId){
		
		System.out.println("deleteComment()");
		commentService.removeComment(messageId,commentId);
				
	}
	
}
