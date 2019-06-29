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
package net.runelite.protocol.api.login;

public enum HandshakeResponseType
{
	RESPONSE_OK(0),
	LOGGED_IN(2),
	INVALID_USERNAME_OR_PASSWORD(3),
	ACCOUNT_DISABLED(4),
	ACCOUNT_ONLINE(5),
	RESPONSE_OUTDATED(6),
	WORLD_FULL(7),
	SERVER_OFFLINE(8),
	LIMITED_EXCEEDED(9),
	BAD_SESSION_ID(10),
	ACCOUNT_HIJACK(11),
	MEMBERS_WORLD(12),
	COULD_NOT_COMPLETE_LOGIN(13),
	SERVER_BEING_UPDATED(14),
	TOO_MANY_ATTEMPTS(16),
	MEMBERS_ONLY_AREA(17),
	ACCOUNT_LOCKED(18),
	CLOSED_BETA(19),
	INVALID_LOGINSERVER(20),
	PROFILE_TRANSFER(21),
	MALFORMED_PACKET(22),
	NO_REPLY_FROM_LOGINSERVER(23),
	ERR_LOADING_PROFILE(24),
	UNEXPECTED_LOGINSERVER_RESPONSE(25),
	IP_BANNED(26),
	SERVICE_UNAVAILABLE(27),
	NO_DISPLAY_NAME(31),
	BILLING_ERROR(32),
	ACCOUNT_INACCESSABLE(37),
	VOTE_TO_PLAY(38),
	NOT_ELIGIBLE(55),
	NEED_AUTHENTICATOR(56),
	AUTHENTICATOR_CODE_WRONG(57);

	private final byte value;

	HandshakeResponseType(int value)
	{
		this.value = (byte) value;
	}

	public byte getValue()
	{
		return value;
	}

	public static HandshakeResponseType of(byte value)
	{
		for (HandshakeResponseType type : values())
		{
			if (type.value == value)
			{
				return type;
			}
		}
		return null;
	}
}
