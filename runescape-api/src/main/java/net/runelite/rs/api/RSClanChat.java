package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSClanChat extends RSUserList<RSClanMate>
{
	@Import("owner")
	String getClanOwner();

	@Import("name")
	String getClanChatName();
}
