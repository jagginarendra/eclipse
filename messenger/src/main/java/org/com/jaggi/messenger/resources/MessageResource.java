package org.com.jaggi.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.com.jaggi.messenger.model.Message;
import org.com.jaggi.messenger.resources.beans.MessageFilterBean;
import org.com.jaggi.messenger.service.MessageService;

@Path("message")
public class MessageResource {

	MessageService ms = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessage(@BeanParam MessageFilterBean filterBean ) {
		
		if(filterBean.getYear() > 0 )
			return ms.getAllMessageForYear(filterBean.getYear());
		else if(filterBean.getStart() > 0 && filterBean.getSize() > 0)
			return ms.getAllMessagePaginated(filterBean.getStart(), filterBean.getSize());
		else
			return ms.getAllMessage();
	}
	
	
	
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") int messageId ){
		
		System.out.println("calledddd");
		return ms.getMessage(messageId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		System.out.println("addMessage");
		return ms.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Message updateMessage(@PathParam("messageId") int messageId,Message message){
		
		message.setId(messageId);
		System.out.println("update");
		return ms.updateMessage(message);
		
	}
	
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public void deleteMessage(@PathParam("messageId") int messageId){
		
		System.out.println("delete");
		ms.removeMessage(messageId);
				
	}
	
	
	// For sub resource Comments
	// /message/id/comment
	
	
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
	
	
	
	
	
	
}
