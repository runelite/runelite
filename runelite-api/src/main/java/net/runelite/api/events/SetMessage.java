package net.runelite.api.events;

import lombok.Data;
import net.runelite.api.ChatMessageType;
import net.runelite.api.MessageNode;

/**
 * An event where a {@link MessageNode} has had its message set.
 * <p>
 * Called whenever a message is received in the chat box.
 * <p>
 * Editing the {@link #messageNode} properties will reflect the change when
 * the message in the chat is rendered. The original values of the message
 * are held by the other fields of this event.
 */
@Data
public class SetMessage
{
	/**
	 * The updated message node.
	 */
	private MessageNode messageNode;
	/**
	 * The set message type.
	 */
	private ChatMessageType type;
	/**
	 * The name of the player that sent the message.
	 */
	private String name;
	/**
	 * The sender of the message (ie. clan name).
	 */
	private String sender;
	/**
	 * The new message value.
	 */
	private String value;
}
