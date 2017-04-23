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
package net.runelite.cache.downloader.requests;

public class HelloHandshake
{
	public static final int RESPONSE_OK = 0;
	public static final int ACCOUNT_DISABLED = 4;
	public static final int ACCOUNT_ONLINE = 5;
	public static final int RESPONSE_OUTDATED = 6;
	public static final int WORLD_FULL = 7;
	public static final int SERVER_OFFLINE = 8;
	public static final int LIMITED_EXCEEDED = 9;
	public static final int BAD_SESSION_ID = 10;
	public static final int ACCOUNT_HIJACK = 11;
	public static final int MEMBERS_WORLD = 12;
	public static final int COULD_NOT_COMPLETE_LOGIN = 13;
	public static final int SERVER_BEING_UPDATED = 14;
	public static final int TOO_MANY_ATTEMPTS = 16;
	public static final int MEMBERS_ONLY_AREA = 17;
	public static final int ACCOUNT_LOCKED = 18;
	public static final int CLOSED_BETA = 19;
	public static final int INVALID_LOGINSERVER = 20;
	public static final int MALFORMED_PACKET = 22;
	public static final int NO_REPLY_FROM_LOGINSERVER = 23;
	public static final int ERR_LOADING_PROFILE = 24;
	public static final int UNEXPECTED_LOGINSERVER_RESPONSE = 25;
	public static final int IP_BANNED = 26;
	public static final int SERVICE_UNAVAILABLE = 27;
	public static final int NO_DISPLAY_NAME = 31;
	public static final int BILLING_ERROR = 32;
	public static final int ACCOUNT_INACCESSABLE = 37;
	public static final int VOTE_TO_PLAY = 38;
	public static final int NOT_ELIGIBLE = 55;
	public static final int NEED_AUTHENTICATOR = 56;
	public static final int AUTHENTICATOR_CODE_WRONG = 57;

	private byte type = 15; // handshake type
	private int revision;

	public int getRevision()
	{
		return revision;
	}

	public void setRevision(int revision)
	{
		this.revision = revision;
	}

	public byte getType()
	{
		return type;
	}

	public void setType(byte type)
	{
		this.type = type;
	}

}
