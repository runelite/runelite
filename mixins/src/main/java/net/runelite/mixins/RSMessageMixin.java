package net.runelite.mixins;

import api.ChatMessageType;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSMessage;

@Mixin(RSMessage.class)
public abstract class RSMessageMixin implements RSMessage
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private String runeLiteFormatMessage;

	@Inject
	private int rl$timestamp;

	@Inject
	RSMessageMixin()
	{
		rl$timestamp = (int) (System.currentTimeMillis() / 1000L);
	}

	@Inject
	@Override
	public ChatMessageType getType()
	{
		return ChatMessageType.of(getRSType());
	}

	@Inject
	@Override
	public String getRuneLiteFormatMessage()
	{
		return runeLiteFormatMessage;
	}

	@Inject
	@Override
	public void setRuneLiteFormatMessage(String runeLiteFormatMessage)
	{
		this.runeLiteFormatMessage = runeLiteFormatMessage;
	}

	@Inject
	@Override
	public int getTimestamp()
	{
		return rl$timestamp;
	}

	@Inject
	@Override
	public void setTimestamp(int timestamp)
	{
		this.rl$timestamp = timestamp;
	}

	@Inject
	@MethodHook(value = "set", end = true)
	public void setMessage(int type, String name, String sender, String value)
	{
		// Message nodes get reused after a time by calling setMessage.
		// Clear the runelite formatted message then.
		runeLiteFormatMessage = null;
		rl$timestamp = (int) (System.currentTimeMillis() / 1000L);
	}
}
