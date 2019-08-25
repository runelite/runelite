package net.runelite.rs.api;

import net.runelite.api.ChatLineBuffer;
import net.runelite.mapping.Import;

public interface RSChatChannel extends ChatLineBuffer
{
	@Import("messages")
	@Override
	RSMessage[] getLines();

	@Import("count")
	@Override
	int getLength();

	@Import("count")
	void setLength(int length);
}
