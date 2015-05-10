package org.com.jaggi.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.com.jaggi.messenger.database.DatabaseClass;
import org.com.jaggi.messenger.model.Profile;

public class ProfileService {

	private static Map<String,Profile> profiles =	DatabaseClass.getProfiles();
	
	
	public ProfileService(){
		
		//System.out.println("Default constructor");
		profiles.put("sachin" ,new Profile("sachin", new Date(), "Sachin" , "Tendulkar"));
		profiles.put("sourav" ,new Profile("sourav", new Date(), "Sourav" , "Ganguly"));
	}
		
	
	public List<Profile> getAllProfile(){
			
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		//System.out.println(" get called");
		return profiles.get(profileName);
	}
	
	public Profile updateProfile(Profile profile){
		
		if(profile.getId().equals(""))
				return null;
		else{
			profiles.put(profile.getId(), profile);
			return profile;
		}
	}
	
	
	public void removeProfile(String  profileName){
		
		
		System.out.println(profiles.size());
		profiles.remove(profileName);
		System.out.println(profiles.size());
		
		
	}
	
	public Profile addProfile(Profile profile){
		profile.setId("abc");
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
	
	
	
	
}
