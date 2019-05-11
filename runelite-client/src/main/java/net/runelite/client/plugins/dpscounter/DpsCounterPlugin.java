package net.runelite.client.plugins.dpscounter;

import com.google.inject.Binder;
import com.google.inject.Inject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ws.PartyMember;
import net.runelite.client.ws.PartyService;
import net.runelite.client.ws.WSClient;

@PluginDescriptor(
	name = "DPS Counter",
	description = "counts dps?"
//
)
public class DpsCounterPlugin extends Plugin
{
	private int lastXp = -1;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PartyService partyService;

	@Inject
	private WSClient wsClient;

	@Inject
	private DpsOverlay dpsOverlay;

	private Boss boss;
	private NPC npc;
	@Getter(AccessLevel.PACKAGE)
	private final Map<String, DpsMember> members = new ConcurrentHashMap<>();

	@Override
	public void configure(Binder binder)
	{
		//super.configure(binder);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(dpsOverlay);
		wsClient.registerMessage(DpsUpdate.class);
		//super.startUp();
	}

	@Override
	protected void shutDown()
	{
		wsClient.unregisterMessage(DpsUpdate.class);
		overlayManager.remove(dpsOverlay);
		boss = null;
		//super.shutDown();
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged interactingChanged) {
		Actor source = interactingChanged.getSource();
		Actor target = interactingChanged.getTarget();

		if (source != client.getLocalPlayer()) {
			return;
		}

		if (target instanceof NPC) {
			int npcId = ((NPC) target).getId();
			Boss boss = Boss.findBoss(npcId);
			if (boss != null) {
				this.boss = boss;
				npc = (NPC) target;
			//	boss = Boss.ABYSSAL_SIRE;
			}
		}
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged experienceChanged)
	{
		if (experienceChanged.getSkill() != Skill.HITPOINTS)
		{
			return;
		}

		final int xp = client.getSkillExperience(Skill.HITPOINTS);
		if (boss == null || lastXp < 0 || xp < lastXp)
		{
			lastXp = xp;
			return;
		}

		final int delta = xp - lastXp;
		final int hit = getHit(boss.getModifier(), delta);
//		final int hit = getHit(1.0f, delta);
		lastXp = xp;

		// Update local member
		PartyMember localMember = partyService.getLocalMember();
		Player player = client.getLocalPlayer();
		// If not in a party, user local player name
		final String name = localMember == null ? player.getName() : localMember.getName();
		DpsMember dpsMember = members.computeIfAbsent(name, n -> new DpsMember(name));
		dpsMember.addDamage(hit);
//		System.out.println("HIT "+ hit);

		if (!partyService.getMembers().isEmpty())
		{
			// Check the player is attacking the boss
			if (npc != null && player.getInteracting() == npc)
			{
				final DpsUpdate specialCounterUpdate = new DpsUpdate(npc.getId(), hit);
				specialCounterUpdate.setMemberId(partyService.getLocalMember().getMemberId());
				wsClient.send(specialCounterUpdate);
			}
		}
	}

	@Subscribe
	public void onDpsUpdate(DpsUpdate dpsUpdate) {
		if (partyService.getLocalMember().getMemberId().equals(dpsUpdate.getMemberId()))
		{
			return;
		}

		String name = partyService.getMemberById(dpsUpdate.getMemberId()).getName();
		if (name == null)
		{
			return;
		}

		DpsMember dpsMember = members.computeIfAbsent(name, n -> new DpsMember(name));
		dpsMember.addDamage(dpsUpdate.getHit());

	}

	private int getHit(float modifier, int deltaExperience)
	{
		float modifierBase = 1f / modifier;
		float damageOutput = (deltaExperience * modifierBase) / 1.3333f;
		return Math.round(damageOutput);
	}
}
