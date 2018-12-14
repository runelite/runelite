/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.mixins;

import net.runelite.api.ChatMessageType;
import net.runelite.api.events.SetMessage;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSMessageNode;

@Mixin(RSMessageNode.class)
public abstract class RSMessageNodeMixin implements RSMessageNode
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	private String runeLiteFormatMessage;

	@Inject
	private int rl$timestamp;

	@Inject
	RSMessageNodeMixin()
	{
		rl$timestamp = (int) (System.currentTimeMillis() / 1000L);

		final SetMessage setMessage = new SetMessage();
		setMessage.setMessageNode(this);
		setMessage.setType(getType());
		setMessage.setName(getName());
		setMessage.setSender(getSender());
		setMessage.setValue(getValue());
		setMessage.setTimestamp(rl$timestamp);
		client.getCallbacks().post(setMessage);
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
	@MethodHook(value = "setMessage", end = true)
	public void setMessage(int type, String name, String sender, String value)
	{
		// Message nodes get reused after a time by calling setMessage.
		// Clear the runelite formatted message then.
		runeLiteFormatMessage = null;
		rl$timestamp = (int) (System.currentTimeMillis() / 1000L);

		final SetMessage setMessage = new SetMessage();
		setMessage.setMessageNode(this);
		setMessage.setType(ChatMessageType.of(type));
		setMessage.setName(name);
		setMessage.setSender(sender);
		setMessage.setValue(value);
		setMessage.setTimestamp(rl$timestamp);
		client.getCallbacks().post(setMessage);
	}
}
