package net.runelite.api.events;

import lombok.Data;
import net.runelite.api.ChatMessageType;
import net.runelite.api.MessageNode;

/**
 * called when a message node's message is set
 *
 * @author Adam
 */
@Data
public class SetMessage
{
	private MessageNode messageNode;
	private ChatMessageType type;
	private String name;
	private String sender;
	private String value;
}
