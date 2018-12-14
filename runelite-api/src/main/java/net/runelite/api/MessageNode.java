/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.api;

/**
 * Represents a message in the chatbox.
 */
public interface MessageNode
{
	/**
	 * Get the id for this message node
	 *
	 * @return
	 */
	int getId();

	/**
	 * Gets the type of message.
	 *
	 * @return the message type
	 */
	ChatMessageType getType();

	/**
	 * Gets the name of the player that sent the message.
	 *
	 * @return the player name
	 */
	String getName();

	/**
	 * Sets the name of the player that sent the message.
	 *
	 * @param name the new player name
	 */
	void setName(String name);

	/**
	 * Gets the sender of the message (ie. clan name).
	 *
	 * @return the message sender
	 */
	String getSender();

	/**
	 * Sets the sender of the message.
	 *
	 * @param sender the new message sender
	 */
	void setSender(String sender);

	/**
	 * Gets the message contents.
	 *
	 * @return the message contents
	 */
	String getValue();

	/**
	 * Sets the message contents.
	 *
	 * @param value the new message contents
	 */
	void setValue(String value);

	/**
	 * Gets the overriden message format.
	 *
	 * @return the message format
	 */
	String getRuneLiteFormatMessage();

	/**
	 * Sets the overriden message format.
	 * <p>
	 * If this value is not null, the message contents as returned by
	 * {@link #getValue()} will be replaced with the format set here
	 * when a message is processed.
	 *
	 * @param runeLiteFormatMessage the new message format
	 */
	void setRuneLiteFormatMessage(String runeLiteFormatMessage);

	/**
	 * Get the timestamp for the message, in seconds from the unix epoch.
	 *
	 * @return
	 */
	int getTimestamp();

	/**
	 * Set the timestamp of the message
	 *
	 * @param timestamp
	 */
	void setTimestamp(int timestamp);
}
