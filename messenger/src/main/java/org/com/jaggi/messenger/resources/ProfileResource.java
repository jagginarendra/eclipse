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
import org.com.jaggi.messenger.model.Profile;
import org.com.jaggi.messenger.service.ProfileService;

@Path("profile")
public class ProfileResource {

	ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles() {
		
		
		return profileService.getAllProfile();
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_XML)
	public Profile getProfile(@PathParam("profileName") String profileName ){
		
		System.out.println("called");
		return profileService.getProfile(profileName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile Profile){
		System.out.println("addProfile");
		return profileService.addProfile(Profile);
	}
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile Profile){
		
		Profile.setId(profileName);
		System.out.println("update");
		return profileService.updateProfile(Profile);
		
	}
	
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_XML)
	public void deleteProfile(@PathParam("profileName") String profileName){
		
		System.out.println("delete");
		profileService.removeProfile(profileName);
				
	}
	
}
