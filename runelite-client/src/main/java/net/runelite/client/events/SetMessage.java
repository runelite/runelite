package net.runelite.client.events;

import net.runelite.api.ChatMessageType;
import net.runelite.api.MessageNode;

/**
 * called when a message node's message is set
 *
 * @author Adam
 */
public class SetMessage
{
	private MessageNode messageNode;
	private ChatMessageType type;
	private String name;
	private String sender;
	private String value;

	public MessageNode getMessageNode()
	{
		return messageNode;
	}

	public void setMessageNode(MessageNode messageNode)
	{
		this.messageNode = messageNode;
	}

	public ChatMessageType getType()
	{
		return type;
	}

	public void setType(ChatMessageType type)
	{
		this.type = type;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSender()
	{
		return sender;
	}

	public void setSender(String sender)
	{
		this.sender = sender;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
}
