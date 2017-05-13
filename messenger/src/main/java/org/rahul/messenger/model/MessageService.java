package org.rahul.messenger.model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.rahul.messenger.database.DatabaseC1;

public class MessageService extends Employee
{

	
	DatabaseC1 c1 = new DatabaseC1();
	private Map<Long,Message> messages = c1.getAllMessage();

	public MessageService()
	{
		/*messages.put(1L, new Message(1,"Hello World","koushik"));
		messages.put(2L, new Message(2,"Hello Jersey","koushik"));*/
	}

	
	public Message getAllMessageForTheYear(int year)
	{
		Calendar cal = Calendar.getInstance();
		List<Message> messageForTheYea = new ArrayList();
		for(Message message: messages.values())
		{
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year)
			{
				messageForTheYea.add(message);
			}
		}
		return  (Message) messageForTheYea;
	}
	public List<Message> getAllMessage()
	{
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id)
	{
		return messages.get(id);
	}
	
	
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
		{
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Message removeMessage(long id)
	{
		return messages.remove(id);
	}
	/*public List<Message> getAllMessage()
	{
		Message m1 = new Message(1L, "Hello World", "Koushik");
		Message m2 = new Message(2L, "Hey Koushik", "Gontu");
		List <Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	*/
	/*public List<Employee> getAllMessage()
	{
		Employee emp1=new Employee(1,"Rahul Ratra",56000);  
		List<Employee> k1 = new ArrayList<Employee>();
		k1.add(emp1);
		return k1;
	}
	*/
}
