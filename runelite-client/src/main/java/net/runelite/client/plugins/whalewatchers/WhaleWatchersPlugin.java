package net.runelite.client.plugins.whalewatchers;

import com.google.inject.Provides;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.Player;
import net.runelite.api.PlayerComposition;
import net.runelite.api.Skill;
import net.runelite.api.SkullIcon;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import static net.runelite.api.WorldType.*;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.WorldUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.NotNull;

@PluginDescriptor(
	name = "Whale Watchers",
	description = "A Plugin to save help whales in the wild",
	tags = {"whale watchers", "whale", "protect item", "warning", "pklite"},
	enabledByDefault = true,
	hidden = false,
	developerPlugin = false,
	type = PluginType.PVP,
	loadWhenOutdated = false
)
public class WhaleWatchersPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private WhaleWatchersConfig config;

	@Inject
	private WhaleWatchersOverlay overlay;

	@Inject
	private WhaleWatchersProtOverlay whaleWatchersProtOverlay;

	@Inject
	private WhaleWatchersSmiteableOverlay whaleWatchersSmiteableOverlay;

	@Inject
	private WhaleWatchersGloryOverlay whaleWatchersGloryOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemManager itemManager;

	public boolean enableOverlay = false;
	private int lastXP = 0;
	public int damageDone = 0;
	public int damageTaken = 0;
	public boolean inCombat = false;
	private int tickCountdown = 0;
	@Getter
	private boolean displaySmiteOverlay;
	@Getter
	private boolean displayGloryOverlay;

	@Provides
	WhaleWatchersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WhaleWatchersConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(whaleWatchersProtOverlay);
		overlayManager.add(whaleWatchersSmiteableOverlay);
		overlayManager.add(whaleWatchersGloryOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(whaleWatchersProtOverlay);
		overlayManager.remove(whaleWatchersSmiteableOverlay);
		overlayManager.remove(whaleWatchersGloryOverlay);
	}


	@Subscribe
	public void onHitsplatApplied(HitsplatApplied event)
	{
		if (config.showDamageCounter())
		{
			if (!(event.getActor() == client.getLocalPlayer() |
				event.getActor() == client.getLocalPlayer().getInteracting()))
			{
				return;
			}
			if (isAttackingPlayer(client) || inCombat)
			{
				inCombat = true;

				if (event.getActor() == client.getLocalPlayer())
				{
					damageTaken += event.getHitsplat().getAmount();

				}
				if (event.getActor() == client.getLocalPlayer().getInteracting())
				{
					damageDone += event.getHitsplat().getAmount();
				}
			}
		}
	}


	/**
	 * final Player target = (Player) event.getTarget();
	 * if (lastInteracting == null)
	 * {
	 * lastInteracting = target;
	 * inCombat = true;
	 * interactingStarted = System.currentTimeMillis();
	 * }
	 * List<String> optionsList = Arrays.asList(client.getPlayerOptions());
	 * <p>
	 * if (target == lastInteracting || target == null)
	 * {
	 * inCombat = true;
	 * lastInteracting = target;
	 * interactingStarted = System.currentTimeMillis();
	 * }
	 * if (target != lastInteracting && target != null && lastInteracting != null)
	 * {
	 * damageDone = 0;
	 * damageTaken = 0;
	 * interactingStarted = System.currentTimeMillis();
	 * inCombat = true;
	 * }
	 **/

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (config.gloryWarning() && event.getItemContainer().equals(InventoryID.EQUIPMENT))
		{
			final int amuletID = ObjectUtils.defaultIfNull(client.getLocalPlayer()
				.getPlayerComposition().getEquipmentId(KitType.AMULET), 0);
			if (amuletID == ItemID.AMULET_OF_GLORY)
			{
				displayGloryOverlay = true;
			}
			else
			{
				displayGloryOverlay = false;
			}
		}
		else
		{
			displayGloryOverlay = false;
		}
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		final Skill skill = event.getSkill();
		final Player player = client.getLocalPlayer();
		if (skill.equals(Skill.HITPOINTS))
		{
			if (player.getInteracting() instanceof Player)
			{
				//lient.getLogger().info(String.valueOf(Math.round((client.getSkillExperience(skill) - lastXP) / 1.33)) + 2);
				lastXP = client.getSkillExperience(skill);
			}
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (config.showDamageCounter() && event.getMenuAction().equals(MenuAction.SPELL_CAST_ON_PLAYER))
		{
			inCombat = true;
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (config.showDamageCounter())
		{
			if (client.getVar(VarPlayer.ATTACKING_PLAYER) == -1)
			{
				if (inCombat)
				{
					//damageTaken = 0;
					//damageDone = 0;
					tickCountdown = 10;
				}
			}
		}

		if (config.protectItemWarning())
		{
			try
			{
				if (client.getLocalPlayer().getSkullIcon() == (SkullIcon.SKULL))
				{
					if (client.getVar(Varbits.PRAYER_PROTECT_ITEM) == 0 && client.getVar(Varbits.IN_WILDERNESS) == 1 ||
						client.getWorldType().contains(PVP))
					{
						enableOverlay = true;
					}
					if (client.getVar(Varbits.PRAYER_PROTECT_ITEM) == 1 || client.getVar(Varbits.IN_WILDERNESS) == 0 ||
						client.getWorldType().contains(HIGH_RISK) || client.getWorld() == 365)
					{
						enableOverlay = false;
					}
				}
				else
				{
					enableOverlay = false;
				}
			}
			catch (NullPointerException e)
			{

			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{

		if (tickCountdown > 0 && tickCountdown < 11)
		{
			tickCountdown--;
			if (tickCountdown == 1)
			{
				if (!isAttackingPlayer(client))
				{
					inCombat = false;
					damageDone = 0;
					damageTaken = 0;
					return;
				}
			}
		}

		if (config.smiteableWarning() && (client.getVar(Varbits.IN_WILDERNESS) == 1 || isPvpWorld(client.getWorldType())))
		{
			if (client.getLocalPlayer().getSkullIcon() != null && client.getLocalPlayer().getSkullIcon().equals(SkullIcon.SKULL))
			{
				final int currentHealth = client.getLocalPlayer().getHealth();
				final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
				if (currentPrayer <= (Math.ceil(currentHealth / 4)))
				{
					displaySmiteOverlay = true;
				}
				else
				{
					displaySmiteOverlay = false;
				}
			}
			else
			{
				displaySmiteOverlay = false;
			}
		}
		else
		{
			displaySmiteOverlay = false;
		}
	}

	public boolean isAttackingPlayer(@NotNull Client c)
	{
		if (client.getVar(Varbits.IN_WILDERNESS) == 1 && client.getLocalPlayer().getInteracting() != null)
		{
			return true;
		}
		int varp = c.getVar(VarPlayer.ATTACKING_PLAYER);
		return varp != -1;
	}

}
