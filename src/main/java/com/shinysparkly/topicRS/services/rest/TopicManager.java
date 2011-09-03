package com.shinysparkly.topicRS.services.rest;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.shinysparkly.topicRS.entities.Topic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

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
        String outputXML="";
        
        Topic t = em.find(Topic.class, id);

        //topic doesn't exist so throw a 404
        if (t == null)throw new WebApplicationException(404);

        if ("".equals(t.getTopicXML().trim()))
            outputXML = "<section><title>"+t.getTopicTitle()+"</title><para/></section>";
        else
            outputXML = t.getTopicXML();
        
        return outputXML;

	}
 
    //@Path("/{id}/{container}")
	
    
}


//make sure title and exists and matches

//replace skynet injection points