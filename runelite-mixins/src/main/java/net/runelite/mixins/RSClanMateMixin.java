package net.runelite.mixins;

import net.runelite.api.ClanMemberRank;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSClanMate;

@Mixin(RSClanMate.class)
public abstract class RSClanMateMixin implements RSClanMate
{
	@Override
	@Inject
	public String getUsername()
	{
		return getRsName().getName();
	}

	@Override
	@Inject
	public ClanMemberRank getRank()
	{
		return ClanMemberRank.valueOf(getRSRank());
	}
}
