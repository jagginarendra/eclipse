package org.com.jaggi.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class DemoResource {

	@GET
	@Path("annoations")
	public String getDemo(@MatrixParam("param") String matrixparam, @HeaderParam("CustomHeaderParam") String header,@CookieParam("name") String cookie){
		return "Hello "+matrixparam+" "+header;
	}
	
}
