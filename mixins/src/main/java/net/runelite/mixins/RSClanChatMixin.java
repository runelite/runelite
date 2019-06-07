package net.runelite.mixins;

import api.events.ClanMemberJoined;
import api.events.ClanMemberLeft;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClanChat;
import rs.api.RSClanMate;
import rs.api.RSClient;
import rs.api.RSUser;
import rs.api.RSUsername;

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
		client.getCallbacks().postDeferred(event);
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
		client.getCallbacks().postDeferred(event);
	}
}
