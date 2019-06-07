package net.runelite.mixins;

import api.HeadIcon;
import static api.HeadIcon.MAGIC;
import static api.HeadIcon.MELEE;
import static api.HeadIcon.RANGED;
import static api.HeadIcon.RANGE_MAGE;
import api.events.NpcActionChanged;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSNPCDefinition;

@Mixin(RSNPCDefinition.class)
public abstract class RSNPCDefinitionMixin implements RSNPCDefinition
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@Override
	public HeadIcon getOverheadIcon()
	{
		switch (getRsOverheadIcon())
		{
			case 0:
				return MELEE;
			case 1:
				return RANGED;
			case 2:
				return MAGIC;
			case 6:
				return RANGE_MAGE;
			default:
				return null;
		}
	}

	@FieldHook("actions")
	@Inject
	public void actionsHook(int idx)
	{
		NpcActionChanged npcActionChanged = new NpcActionChanged();
		npcActionChanged.setNpcDefinition(this);
		npcActionChanged.setIdx(idx);
		client.getCallbacks().post(npcActionChanged);
	}
}
