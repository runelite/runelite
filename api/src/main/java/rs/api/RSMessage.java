package rs.api;

import api.MessageNode;
import net.runelite.mapping.Import;

public interface RSMessage extends MessageNode
{
	@Import("count")
	@Override
	int getId();

	@Import("type")
	int getRSType();

	@Import("prefix")
	@Override
	String getName();

	@Import("prefix")
	@Override
	void setName(String name);

	@Import("sender")
	@Override
	String getSender();

	@Import("sender")
	@Override
	void setSender(String sender);

	@Import("text")
	@Override
	String getValue();

	@Import("text")
	@Override
	void setValue(String value);
}
