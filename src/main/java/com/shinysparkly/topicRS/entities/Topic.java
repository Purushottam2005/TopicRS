package com.shinysparkly.topicRS.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "getTopicByID", query="select t from Topic t where t.TopicID = :id")

public class Topic implements Serializable 
{
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long TopicID;
   private String TopicTitle;
	private String TopicXML;

	// ====================================

	public Long getTopicID() 
	{
		return TopicID;
	}
	public void setId(Long TopicID) 
	{
		this.TopicID = TopicID;
	}
	
	public String getTopicTitle() 
	{
		return TopicTitle;
	}
	public void setTopicTitle(String TopicTitle) 
	{
		this.TopicTitle = TopicTitle;
	}
	
	public String getTopicXML() 
	{
		return TopicXML;
	}
	public void setTopicXML(String TopicXML) 
	{
		this.TopicXML = TopicXML;
	}
	
	
}
