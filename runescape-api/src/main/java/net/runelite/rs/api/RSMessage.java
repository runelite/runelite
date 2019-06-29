package net.runelite.rs.api;

import net.runelite.api.MessageNode;
import net.runelite.mapping.Import;

public interface RSMessage extends MessageNode
{
	@Import("count")
	@Override
	int getId();

	@Import("type")
	int getRSType();

	@Import("sender")
	@Override
	String getName();

	@Import("sender")
	@Override
	void setName(String name);

	@Import("prefix")
	@Override
	String getSender();

	@Import("prefix")
	@Override
	void setSender(String sender);

	@Import("text")
	@Override
	String getValue();

	@Import("text")
	@Override
	void setValue(String value);

	@Import("isFromFriend")
	@Override
	boolean isFromFriend();

	@Import("senderUsername")
	RSUsername getSenderUsername();
}
