package net.runelite.mixins;

import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ClanMemberLeft;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClanChat;
import net.runelite.rs.api.RSClanMate;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSUser;
import net.runelite.rs.api.RSUsername;

@Mixin(RSClanChat.class)
public abstract class RSClanChatMixin implements RSClanChat
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@Override
	public void rl$add(RSUsername name, RSUsername prevName)
	{
		RSClanMate member = findByName(name);
		if (member == null)
		{
			return;
		}

		ClanMemberJoined event = new ClanMemberJoined(member);
		client.getCallbacks().postDeferred(ClanMemberJoined.class, event);
	}

	@Inject
	@Override
	public void rl$remove(RSUser nameable)
	{
		RSClanMate member = findByName(nameable.getRsName());
		if (member == null)
		{
			return;
		}

		ClanMemberLeft event = new ClanMemberLeft(member);
		client.getCallbacks().postDeferred(ClanMemberLeft.class, event);
	}
}
