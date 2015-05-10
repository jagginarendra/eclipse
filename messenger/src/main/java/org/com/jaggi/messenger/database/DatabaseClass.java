package org.com.jaggi.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.com.jaggi.messenger.model.Message;
import org.com.jaggi.messenger.model.Profile;

public class DatabaseClass {

	
	private static Map<Integer,Message> messages = new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();
	
	public static Map<Integer,Message> getMessages(){
		
		return messages;
	}
	public static Map<String,Profile> getProfiles(){
		
		return profiles;
	}
}
