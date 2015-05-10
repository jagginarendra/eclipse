package org.com.jaggi.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.com.jaggi.messenger.database.DatabaseClass;
import org.com.jaggi.messenger.model.Message;


public class MessageService {

	private static Map<Integer,Message> messages =	DatabaseClass.getMessages();
	
	public MessageService(){
		
		//System.out.println("Default constructor");
		messages.put(1, new Message(1, new Date(), "This is Message1", "Jaggi"));
		messages.put(2, new Message(2, new Date(), "This is Message2", "Ashwin"));
		messages.put(3, new Message(3, new Date(), "This is Message3", "Akash"));
	}
	
	public List<Message> getAllMessage(){
			
		return new ArrayList<Message>(messages.values());
	}
	
	
	public List<Message> getAllMessageForYear(int year){
		
		List<Message> list = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message :  messages.values()){
			cal.setTime(message.getCreatedOn());
			if(cal.get(Calendar.YEAR) == year)
				list.add(message);
		}
			
			
		
		return list;
	}
	
	
	public List<Message> getAllMessagePaginated(int start , int size){
		List<Message> list = new ArrayList<Message>(messages.values());
		if(start-1+size-1 > messages.size())
			return null;
		else
			
		return list.subList(start-1, start+size-1);
	}
	
	
	
	public Message getMessage(int id){
		//System.out.println(" get called");
		return messages.get(id);
	}
	
	public Message updateMessage(Message message){
		
		if(message == null)
				return null;
		else{
			messages.put(message.getId(), message);
			return message;
		}
	}
	
	
	public void removeMessage(int id){
		
		System.out.println(messages.size());
		messages.remove(id);
		System.out.println(messages.size());
		
		
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	
	
	
	
	
	
}
