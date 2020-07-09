package net.runelite.client.plugins.coxhelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;

@Slf4j
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Singleton
public class Olm
{
	private final Client client;
	private final CoxPlugin plugin;
	private final CoxConfig config;

	private final List<WorldPoint> healPools = new ArrayList<>();
	private final List<WorldPoint> portals = new ArrayList<>();
	private final Set<Victim> victims = new HashSet<>();
	private int portalTicks = 10;
	private Actor acidTarget = null;

	private boolean active = false; // in fight
	private boolean firstPhase = false;
	private boolean finalPhase = false;

	private NPC hand = null;
	private int lastHandAnimation = -2;
	private NPC head = null;
	private int lastHeadAnimation = -2;

	private int tickCycle = -1;
	private int specialCycle = 1;

	private boolean crippled = false;
	private int crippleTicks = 45;

	private PrayAgainst prayer = null;
	private long lastPrayTime = 0;

	@Inject
	private Olm(final Client client, final CoxPlugin plugin, final CoxConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	public void startPhase()
	{
		this.firstPhase = !this.active;
		this.active = true;
		this.tickCycle = -1;
		this.specialCycle = 1;
		this.crippled = false;
		this.crippleTicks = 45;
		this.prayer = null;
		this.lastPrayTime = 0;
		this.lastHeadAnimation = -2;
		this.lastHandAnimation = -2;
	}

	public void hardRest()
	{
		this.active = false;
		this.firstPhase = false;
		this.finalPhase = false;
		this.hand = null;
		this.head = null;
		this.lastHeadAnimation = -2;
		this.lastHandAnimation = -2;
		this.tickCycle = -1;
		this.specialCycle = 1;
		this.healPools.clear();
		this.portals.clear();
		this.portalTicks = 10;
		this.victims.clear();
		this.acidTarget = null;
		this.crippled = false;
		this.crippleTicks = 45;
		this.prayer = null;
		this.lastPrayTime = 0;
	}

	void setPrayer(PrayAgainst pray)
	{
		this.prayer = pray;
		this.lastPrayTime = System.currentTimeMillis();
	}

	void cripple()
	{
		this.crippled = true;
		this.crippleTicks = 45;
	}

	void uncripple()
	{
		this.crippled = false;
		this.crippleTicks = 45;
	}

	public int ticksUntilNextAction()
	{
		return this.tickCycle % 4 == 0 ? 1 : 4 - (this.tickCycle % 4) + 1;
	}

	public int actionCycle()
	{
		return (int) Math.ceil((double) this.tickCycle / 4);
	}

	public void update()
	{
		this.updateVictims();
		this.updateCrippleSticks();
		this.updateSpecials();
		this.incrementTickCycle();
		this.headAnimations();
		this.handAnimations();
	}

	public void incrementTickCycle()
	{
		if (this.tickCycle == 16)
		{
			this.incrementSpecialCycle();
			this.tickCycle = 1;
		}
		else if (this.tickCycle != -1)
		{
			this.tickCycle++;
		}
	}

	public void incrementSpecialCycle()
	{
		if ((this.specialCycle == 3 && !this.finalPhase) || this.specialCycle == 4)
		{
			this.specialCycle = 1;
		}
		else
		{
			this.specialCycle++;
		}
	}

	public void specialSync(int currentAnimation)
	{
		this.tickCycle = 1;
		switch (currentAnimation)
		{
			case OlmID.OLM_LEFT_HAND_CRYSTALS:
				this.specialCycle = 2;
				break;
			case OlmID.OLM_LEFT_HAND_LIGHTNING:
				this.specialCycle = 3;
				break;
			case OlmID.OLM_LEFT_HAND_PORTALS:
				this.specialCycle = this.finalPhase ? 4 : 1;
				break;
			case OlmID.OLM_LEFT_HAND_HEAL:
				this.specialCycle = 1;
				break;
		}
	}

	void updateCrippleSticks()
	{
		if (!this.crippled)
		{
			return;
		}

		this.crippleTicks--;
		if (this.crippleTicks <= 0)
		{
			this.crippled = false;
			this.crippleTicks = 45;
		}
	}

	void updateVictims()
	{
		if (this.victims.size() > 0)
		{
			this.victims.forEach(Victim::updateTicks);
			this.victims.removeIf(victim -> victim.getTicks() <= 0);
		}
	}

	void updateSpecials()
	{
		this.healPools.clear();
		this.portals.clear();
		this.client.clearHintArrow();

		for (GraphicsObject o : this.client.getGraphicsObjects())
		{
			if (o.getId() == GraphicID.OLM_TELEPORT)
			{
				this.portals.add(WorldPoint.fromLocal(this.client, o.getLocation()));
			}
			if (o.getId() == GraphicID.OLM_HEAL)
			{
				this.healPools.add(WorldPoint.fromLocal(this.client, o.getLocation()));
			}
			if (!this.portals.isEmpty())
			{
				this.portalTicks--;
				if (this.portalTicks <= 0)
				{
					this.client.clearHintArrow();
					this.portalTicks = 10;
				}
			}
		}
	}

	private void headAnimations()
	{
		if (this.head == null)
		{
			return;
		}

		int currentAnimation = this.head.getAnimation();
	log.warn("headanimation: " +currentAnimation);
		if (currentAnimation == this.lastHeadAnimation)
		{
			return;
		}

		switch (currentAnimation)
		{
			case OlmID.OLM_MIDDLE:
				if (this.lastHeadAnimation == OlmID.OLM_RISING_2 || this.lastHeadAnimation == OlmID.OLM_ENRAGED_RISING_2)
				{
					this.tickCycle = this.firstPhase ? 3 : 0;
				}
				break;
			case OlmID.OLM_ENRAGED_LEFT:
			case OlmID.OLM_ENRAGED_MIDDLE:
			case OlmID.OLM_ENRAGED_RIGHT:
				this.finalPhase = true;
				break;
		}

		this.lastHeadAnimation = currentAnimation;
	}

	private void handAnimations()
	{
		if (this.hand == null)
		{
			return;
		}

		int currentAnimation = this.head.getAnimation();

		if (currentAnimation == this.lastHandAnimation)
		{
			return;
		}

		switch (currentAnimation)
		{
			case OlmID.OLM_LEFT_HAND_CRYSTALS:
			case OlmID.OLM_LEFT_HAND_LIGHTNING:
			case OlmID.OLM_LEFT_HAND_PORTALS:
			case OlmID.OLM_LEFT_HAND_HEAL:
				this.specialSync(currentAnimation);
				break;
			case OlmID.OLM_LEFT_HAND_CRIPPLING:
				this.cripple();
				break;
			case OlmID.OLM_LEFT_HAND_UNCRIPPLING1:
			case OlmID.OLM_LEFT_HAND_UNCRIPPLING2:
				this.uncripple();
				break;
		}

		this.lastHandAnimation = currentAnimation;
	}
}
