package net.runelite.cache.protocol.packets;

public enum HandshakeResponseType
{
	RESPONSE_OK(0),
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

	private HandshakeResponseType(int value)
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
