/*
 * Copyright (c) 2017, Ron <https://github.com/raiyni>
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

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration of chat mode types for sending messages.
 */
@AllArgsConstructor
@Getter
public enum ChatModeType
{
	/**
	 * Message mode type for sending public chat.
	 */
	PUBLIC(0),
	/**
	 * Message mode type for sending clan chat.
	 */
	CLAN(2);

	private final int type;

	private static final Map<Integer, ChatModeType> CHAT_MODE_TYPES = new HashMap<>();

	static
	{
		for (ChatModeType chatModeType : values())
		{
			CHAT_MODE_TYPES.put(chatModeType.type, chatModeType);
		}
	}

	/**
	 * Utility method that maps the type value to its respective
	 * {@link ChatModeType} value.
	 *
	 * @param type the raw type
	 * @return appropriate chat mode type, or {@link #PUBLIC}
	 */
	public static ChatModeType of(int type)
	{
		return CHAT_MODE_TYPES.getOrDefault(type, PUBLIC);
	}
}
