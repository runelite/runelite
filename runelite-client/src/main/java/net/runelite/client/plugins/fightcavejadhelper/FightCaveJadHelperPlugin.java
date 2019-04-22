package net.runelite.client.plugins.fightcavejadhelper;

import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Fight Cave - Jad",
	description = "Show what to pray against Jad",
	tags = {"bosses", "combat", "minigame", "overlay", "prayer", "pve", "pvm"},
		type = PluginType.PVM,
        enabledByDefault = false
)
public class FightCaveJadHelperPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private FightCaveJadHelperOverlay overlay;

	@Getter(AccessLevel.PACKAGE)
	@Nullable
	private JadAttack attack;

	private NPC jad;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		jad = null;
		attack = null;
	}

	@Subscribe
	public void onNpcSpawned(final NpcSpawned event)
	{
		final int id = event.getNpc().getId();

		if (id == NpcID.TZTOKJAD || id == NpcID.TZTOKJAD_6506)
		{
			jad = event.getNpc();
		}
	}

	@Subscribe
	public void onNpcDespawned(final NpcDespawned event)
	{
		if (jad == event.getNpc())
		{
			jad = null;
			attack = null;
		}
	}

	@Subscribe
	public void onAnimationChanged(final AnimationChanged event)
	{
		if (event.getActor() != jad)
		{
			return;
		}

		if (jad.getAnimation() == JadAttack.MAGIC.getAnimation())
		{
			attack = JadAttack.MAGIC;
		}
		else if (jad.getAnimation() == JadAttack.RANGE.getAnimation())
		{
			attack = JadAttack.RANGE;
		}
	}
}
