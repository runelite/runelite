/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>, SoyChai <https://github.com/SoyChai>
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
package net.runelite.client.plugins.experiencedrop;

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.IntStream;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import static net.runelite.api.ScriptID.XPDROP_DISABLED;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.HiscoreManager;
import net.runelite.client.game.NPCManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.attackstyles.AttackStyle;
import static net.runelite.client.plugins.attackstyles.AttackStyle.ACCURATE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.AGGRESSIVE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CONTROLLED;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE_CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.LONGRANGE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.OTHER;
import static net.runelite.client.plugins.attackstyles.AttackStyle.RANGING;
import net.runelite.client.plugins.attackstyles.WeaponType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;

@PluginDescriptor(
	name = "XP Drop",
	description = "Enable customization of the way XP drops are displayed",
	tags = {"experience", "levels", "tick"}
)
public class XpDropPlugin extends Plugin
{
	private static final int XPDROP_PADDING = 2; // space between xp drop icons
	private static final Duration WAIT = Duration.ofSeconds(5);

	@Inject
	private Client client;

	@Inject
	private XpDropConfig config;

	private int tickCounter = 0;
	private int previousExpGained;
	private boolean hasHit = false;
	private boolean hasDropped = false;
	private boolean correctPrayer;
	private Skill lastSkill = null;
	private Map<Skill, Integer> previousSkillExpTable = new EnumMap<>(Skill.class);
	private PrayerType currentTickPrayer;
	private AttackStyle attackStyle;
	private int attackStyleVarbit = -1;
	private int equippedWeaponTypeVarbit = -1;
	private int castingModeVarbit = -1;
	private int opponentHealth = -1;
	private int xpGains = 0;
	private AttackStyle[] offensiveStyles = {ACCURATE, AGGRESSIVE, DEFENSIVE, CONTROLLED, RANGING, LONGRANGE, CASTING, DEFENSIVE_CASTING};

	@Getter(AccessLevel.PACKAGE)
	private int damage = 0;

	@Getter(AccessLevel.PACKAGE)
	private Actor lastOpponent;

	private Instant lastTime;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private XpDropOverlay overlay;

	@Inject
	private NPCManager npcManager;

	@Inject
	private HiscoreManager hiscoreManager;

	@Provides
	XpDropConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XpDropConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		lastOpponent = null;
		overlayManager.add(overlay);
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			attackStyleVarbit = client.getVar(VarPlayer.ATTACK_STYLE);
			equippedWeaponTypeVarbit = client.getVar(Varbits.EQUIPPED_WEAPON_TYPE);
			castingModeVarbit = client.getVar(Varbits.DEFENSIVE_CASTING_MODE);
			updateAttackStyle(
				equippedWeaponTypeVarbit,
				attackStyleVarbit,
				castingModeVarbit);
		}
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		Widget widget = event.getWidget();

		int group = WidgetInfo.TO_GROUP(widget.getId());

		if (group != WidgetID.EXPERIENCE_DROP_GROUP_ID)
		{
			return;
		}

		if (widget.isHidden())
		{
			return;
		}

		if (config.hideSkillIcons())
		{
			if (widget.getSpriteId() > 0)
			{
				widget.setHidden(true);
				return;
			}
			else if (!widget.getText().isEmpty())
			{
				// Align text accordingly to take up hidden skill icon space
				int width = 0;
				for (Widget w : widget.getParent().getDynamicChildren())
				{
					if (w.getSpriteId() != -1)
					{
						if (width > 0)
						{
							// Add in space between sprites
							width += XPDROP_PADDING;
						}
						width += w.getWidth(); // width of sprite
					}
				}

				final int xpDropPosition = client.getVar(Varbits.EXPERIENCE_TRACKER_POSITION);
				switch (xpDropPosition)
				{
					case 2: // left
						int cur = widget.getRelativeX();
						cur -= width;
						widget.setRelativeX(cur);
						break;
					case 0: // right
						break;
					case 1: // center
						cur = widget.getRelativeX();
						cur -= width / 2;
						widget.setRelativeX(cur);
						break;
				}
			}
		}

		PrayerType prayer = currentTickPrayer;
		if (prayer == null)
		{
			resetTextColor(widget);
			return;
		}

		String text = widget.getText();
		final IntStream spriteIDs =
			Arrays.stream(widget.getParent().getDynamicChildren()).mapToInt(Widget::getSpriteId);

		if (text != null)
		{
			int color = widget.getTextColor();

			switch (prayer)
			{
				case MELEE:
					if (spriteIDs.anyMatch(id ->
						id == SpriteID.SKILL_ATTACK || id == SpriteID.SKILL_STRENGTH || id == SpriteID.SKILL_DEFENCE
							|| correctPrayer))
					{
						color = config.getMeleePrayerColor().getRGB();
						correctPrayer = true;
					}
					break;
				case RANGE:
					if (spriteIDs.anyMatch(id -> id == SpriteID.SKILL_RANGED || correctPrayer))
					{
						color = config.getRangePrayerColor().getRGB();
						correctPrayer = true;
					}
					break;
				case MAGIC:
					if (spriteIDs.anyMatch(id -> id == SpriteID.SKILL_MAGIC || correctPrayer))
					{
						color = config.getMagePrayerColor().getRGB();
						correctPrayer = true;
					}
					break;
			}

			widget.setTextColor(color);
		}
	}

	private void resetTextColor(Widget widget)
	{
		int defaultColorIdx = client.getVar(Varbits.EXPERIENCE_DROP_COLOR);
		int defaultColor = DefaultColors.values()[defaultColorIdx].getColor().getRGB();
		widget.setTextColor(defaultColor);
	}

	private PrayerType getActivePrayerType()
	{
		for (XpPrayer prayer : XpPrayer.values())
		{
			if (client.isPrayerActive(prayer.getPrayer()))
			{
				return prayer.getType();
			}
		}
		return null;
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		// Detect hitting a 0
		if (lastOpponent != null)
		{
			int health = calculateHealth(lastOpponent);
			if (health != -1 && opponentHealth != -1 && health == opponentHealth && hasHit)
			{
				damage = 0;
				hasHit = false;
			}
		}

		// Handle getting XP gains
		if (hasDropped)
		{
			if (xpGains != 0 && attackStyle.getSkills().length > 1 && attackStyle != LONGRANGE)
			{
				damage = (int) (xpGains / (attackStyle.getSkills().length * 1.3));
			}
			else if (xpGains != 0)
			{
				damage = xpGains / 4;
			}

			xpGains = 0;
			hasDropped = false;
		}

		// Clear opponent
		if (lastOpponent != null && lastTime != null && client.getLocalPlayer().getInteracting() == null)
		{
			if (Duration.between(lastTime, Instant.now()).compareTo(WAIT) > 0)
			{
				lastOpponent = null;
			}
		}

		currentTickPrayer = getActivePrayerType();
		correctPrayer = false;

		final int fakeTickDelay = config.fakeXpDropDelay();

		if (fakeTickDelay == 0 || lastSkill == null)
		{
			return;
		}

		// If an xp drop was created this tick, reset the counter
		if (hasDropped)
		{
			hasDropped = false;
			tickCounter = 0;
			return;
		}

		if (++tickCounter % fakeTickDelay != 0)
		{
			return;
		}

		client.runScript(XPDROP_DISABLED, lastSkill.ordinal(), previousExpGained);
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		final Skill skill = event.getSkill();
		final int xp = client.getSkillExperience(skill);

		lastSkill = skill;

		Integer previous = previousSkillExpTable.put(skill, xp);
		if (previous != null)
		{
			opponentHealth = calculateHealth(lastOpponent);
			previousExpGained = xp - previous;
			if (skill != Skill.HITPOINTS && Arrays.stream(offensiveStyles).anyMatch(attackStyle::equals))
			{
				xpGains += previousExpGained;
			}

			hasDropped = true;
			hasHit = true;
		}
	}

	private void updateAttackStyle(int equippedWeaponType, int attackStyleIndex, int castingMode)
	{
		AttackStyle[] attackStyles = WeaponType.getWeaponType(equippedWeaponType).getAttackStyles();
		if (attackStyleIndex < attackStyles.length)
		{
			attackStyle = attackStyles[attackStyleIndex];
			if (attackStyle == null)
			{
				attackStyle = OTHER;
			}
			else if ((attackStyle == CASTING) && (castingMode == 1))
			{
				attackStyle = DEFENSIVE_CASTING;
			}
		}
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		if (event.getSource() != client.getLocalPlayer())
		{
			return;
		}

		Actor opponent = event.getTarget();

		if (opponent == null)
		{
			lastTime = Instant.now();
			return;
		}
		else if (opponent.getName().equalsIgnoreCase("fishing spot"))
		{
			lastTime = Instant.now().minus(WAIT);
			return;
		}

		damage = 0;
		lastOpponent = opponent;
		opponentHealth = calculateHealth(opponent);
	}

	private int calculateHealth(Actor target)
	{
		if (target == null || target.getName() == null)
		{
			return -1;
		}

		final int healthScale = target.getHealth();
		final int healthRatio = target.getHealthRatio();
		final String targetName = Text.removeTags(target.getName());

		Integer maxHealth = -1;
		if (target instanceof NPC)
		{
			maxHealth = npcManager.getHealth(targetName, target.getCombatLevel());
		}
		else if (target instanceof Player)
		{
			final HiscoreResult hiscoreResult = hiscoreManager.lookupAsync(targetName, HiscoreEndpoint.NORMAL);
			if (hiscoreResult != null)
			{
				final int hp = hiscoreResult.getHitpoints().getLevel();
				if (hp > 0)
				{
					maxHealth = hp;
				}
			}
		}

		if (healthRatio < 0 || healthScale <= 0 || maxHealth == null)
		{
			return -1;
		}

		return (int) ((maxHealth * healthRatio / healthScale) + 0.5f);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (attackStyleVarbit == -1 || attackStyleVarbit != client.getVar(VarPlayer.ATTACK_STYLE))
		{
			attackStyleVarbit = client.getVar(VarPlayer.ATTACK_STYLE);
			updateAttackStyle(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE), attackStyleVarbit,
				client.getVar(Varbits.DEFENSIVE_CASTING_MODE));
		}

		if (equippedWeaponTypeVarbit == -1 || equippedWeaponTypeVarbit != client.getVar(Varbits.EQUIPPED_WEAPON_TYPE))
		{
			equippedWeaponTypeVarbit = client.getVar(Varbits.EQUIPPED_WEAPON_TYPE);
			updateAttackStyle(equippedWeaponTypeVarbit, client.getVar(VarPlayer.ATTACK_STYLE),
				client.getVar(Varbits.DEFENSIVE_CASTING_MODE));
		}

		if (castingModeVarbit == -1 || castingModeVarbit != client.getVar(Varbits.DEFENSIVE_CASTING_MODE))
		{
			castingModeVarbit = client.getVar(Varbits.DEFENSIVE_CASTING_MODE);
			updateAttackStyle(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE), client.getVar(VarPlayer.ATTACK_STYLE),
				castingModeVarbit);
		}
	}
}
