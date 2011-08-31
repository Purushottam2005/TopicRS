package com.shinysparkly.topicRS.services.rest;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.shinysparkly.topicRS.entities.Topic;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/topic")
@Stateless
@Produces({"application/xml"})
public class TopicManager 
{
	@PersistenceContext(unitName="topicPU") 
	private EntityManager em;
    
	@GET
	@Path("/{id}")
	public String getRawTopicByID(@PathParam("id") Long id)
	{
        System.out.println("getting");
		try
		{
		   Topic t = em.find(Topic.class, id);
		   
		   //
		   return t.getTopicXML();
		}
		catch(EntityNotFoundException ex)
		{
		   throw new WebApplicationException(Response.status(404).entity("topic not found").build());
                   //(Response.Status.NOT_FOUND);
		   //return Response.status(404).entity("topic not found").build();
		}

	}
 
    //@Path("/{id}/{container}")
	
}


//make sure title and exists and matches

//replace skynet injection points