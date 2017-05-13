package org.rahul.messenger.model;

import java.util.Date;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.rahul.messenger.database.DatabaseC1;

@XmlRootElement
public class Message 
{
	private long id;
	private String message;
	private Date created;  
	private String author;
	@XmlElement
	public long getId() {
		return id;
	}
	private Map<Long,Message> messages = DatabaseC1.getAllMessage();
	public Message()
	{
	messages.put(1L,new Message(1L, "Hello World", new Date()));
		messages.put(2L, new Message(2L, "Hey Koushik", new Date()));
	}
	public Message(long id, String message, Date created) {
		super();
		this.id = id;
		this.message = message;
		this.created = created;
		this.author = author;
	}
	@XmlElement 
	public String getMessage() {
		return message;
	}
	@XmlElement 
	public Date getCreated() {
		return created;
	}
	
	@XmlElement 
	public String getAuthor() {
		return author;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

}
