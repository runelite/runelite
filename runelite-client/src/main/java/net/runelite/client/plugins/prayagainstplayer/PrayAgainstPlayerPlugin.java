/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.prayagainstplayer;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.SpriteID;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Pray Against Player",
	description = "Use plugin in PvP situations for best results!!",
	tags = {"highlight", "pvp", "overlay", "players"},
	type = PluginType.PVP,
	enabledByDefault = false
)

/**
 * I am fully aware that there is plenty of overhead and is a MESS!
 * If you'd like to contribute please do!
 */
@Singleton
public class PrayAgainstPlayerPlugin extends Plugin
{

	private static final int[] PROTECTION_ICONS = {
		SpriteID.PRAYER_PROTECT_FROM_MISSILES,
		SpriteID.PRAYER_PROTECT_FROM_MELEE,
		SpriteID.PRAYER_PROTECT_FROM_MAGIC
	};
	private static final Dimension PROTECTION_ICON_DIMENSION = new Dimension(33, 33);
	private static final Color PROTECTION_ICON_OUTLINE_COLOR = new Color(33, 33, 33);
	private final BufferedImage[] ProtectionIcons = new BufferedImage[PROTECTION_ICONS.length];

	private List<PlayerContainer> potentialPlayersAttackingMe;
	private List<PlayerContainer> playersAttackingMe;

	@Inject
	private Client client;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PrayAgainstPlayerOverlay overlay;

	@Inject
	private PrayAgainstPlayerOverlayPrayerTab overlayPrayerTab;

	@Inject
	private PrayAgainstPlayerConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private Color attackerPlayerColor;
	@Getter(AccessLevel.PACKAGE)
	private Color potentialPlayerColor;
	private int attackerTargetTimeout;
	private int potentialTargetTimeout;
	private int newSpawnTimeout;
	private boolean ignoreFriends;
	private boolean ignoreClanMates;
	private boolean markNewPlayer;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawTargetPrayAgainst;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawPotentialTargetPrayAgainst;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawTargetPrayAgainstPrayerTab;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawTargetsName;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawPotentialTargetsName;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawTargetHighlight;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawPotentialTargetHighlight;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawTargetTile;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawPotentialTargetTile;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawUnknownWeapons;

	@Provides
	PrayAgainstPlayerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PrayAgainstPlayerConfig.class);
	}

	private void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			loadProtectionIcons();
		}
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();

		potentialPlayersAttackingMe = new ArrayList<>();
		playersAttackingMe = new ArrayList<>();
		overlayManager.add(overlay);
		overlayManager.add(overlayPrayerTab);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		overlayManager.remove(overlayPrayerTab);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(InteractingChanged.class, this, this::onInteractingChanged);
		eventBus.subscribe(PlayerDespawned.class, this, this::onPlayerDespawned);
		eventBus.subscribe(PlayerSpawned.class, this, this::onPlayerSpawned);
	}

	private void onAnimationChanged(AnimationChanged animationChanged)
	{
		if ((animationChanged.getActor() instanceof Player) && (animationChanged.getActor().getInteracting() instanceof Player) && (animationChanged.getActor().getInteracting() == client.getLocalPlayer()))
		{
			Player sourcePlayer = (Player) animationChanged.getActor();

			// is the client is a friend/clan and the config is set to ignore friends/clan dont add them to list
			if (client.isFriended(sourcePlayer.getName(), true) && this.ignoreFriends)
			{
				return;
			}
			if (client.isClanMember(sourcePlayer.getName()) && this.ignoreClanMates)
			{
				return;
			}

			if ((sourcePlayer.getAnimation() != -1) && (!isBlockAnimation(sourcePlayer.getAnimation())))
			{
				// if attacker attacks again, reset his timer so overlay doesn't go away
				if (findPlayerInAttackerList(sourcePlayer) != null)
				{
					resetPlayerFromAttackerContainerTimer(findPlayerInAttackerList(sourcePlayer));
				}
				// if he attacks and he was in the potential attackers list, remove him
				if (!potentialPlayersAttackingMe.isEmpty() && potentialPlayersAttackingMe.contains(findPlayerInPotentialList(sourcePlayer)))
				{
					removePlayerFromPotentialContainer(findPlayerInPotentialList(sourcePlayer));
				}
				// if he's not in the attackers list, add him
				if (findPlayerInAttackerList(sourcePlayer) == null)
				{
					PlayerContainer container = new PlayerContainer(sourcePlayer, System.currentTimeMillis(), (this.attackerTargetTimeout * 1000));
					playersAttackingMe.add(container);
				}
			}
		}
	}

	private void onInteractingChanged(InteractingChanged interactingChanged)
	{
		// if someone interacts with you, add them to the potential attackers list
		if ((interactingChanged.getSource() instanceof Player) && (interactingChanged.getTarget() instanceof Player))
		{
			Player sourcePlayer = (Player) interactingChanged.getSource();
			Player targetPlayer = (Player) interactingChanged.getTarget();
			if ((targetPlayer == client.getLocalPlayer()) && (findPlayerInPotentialList(sourcePlayer) == null))
			{ //we're being interacted with

				// is the client is a friend/clan and the config is set to ignore friends/clan dont add them to list
				if (client.isFriended(sourcePlayer.getName(), true) && this.ignoreFriends)
				{
					return;
				}
				if (client.isClanMember(sourcePlayer.getName()) && this.ignoreClanMates)
				{
					return;
				}

				PlayerContainer container = new PlayerContainer(sourcePlayer, System.currentTimeMillis(), (this.potentialTargetTimeout * 1000));
				potentialPlayersAttackingMe.add(container);
			}
		}
	}

	private void onPlayerDespawned(PlayerDespawned playerDespawned)
	{
		PlayerContainer container = findPlayerInAttackerList(playerDespawned.getPlayer());
		PlayerContainer container2 = findPlayerInPotentialList(playerDespawned.getPlayer());
		if (container != null)
		{
			playersAttackingMe.remove(container);
		}
		if (container2 != null)
		{
			potentialPlayersAttackingMe.remove(container2);
		}
	}

	private void onPlayerSpawned(PlayerSpawned playerSpawned)
	{
		if (this.markNewPlayer)
		{
			Player p = playerSpawned.getPlayer();

			if (client.isFriended(p.getName(), true) && this.ignoreFriends)
			{
				return;
			}
			if (client.isClanMember(p.getName()) && this.ignoreClanMates)
			{
				return;
			}

			PlayerContainer container = findPlayerInPotentialList(p);
			if (container == null)
			{
				container = new PlayerContainer(p, System.currentTimeMillis(), (this.newSpawnTimeout * 1000));
				potentialPlayersAttackingMe.add(container);
			}
		}
	}

	private PlayerContainer findPlayerInAttackerList(Player player)
	{
		if (playersAttackingMe.isEmpty())
		{
			return null;
		}
		for (PlayerContainer container : playersAttackingMe)
		{
			if (container.getPlayer() == player)
			{
				return container;
			}
		}
		return null;
	}

	private PlayerContainer findPlayerInPotentialList(Player player)
	{
		if (potentialPlayersAttackingMe.isEmpty())
		{
			return null;
		}
		for (PlayerContainer container : potentialPlayersAttackingMe)
		{
			if (container.getPlayer() == player)
			{
				return container;
			}
		}
		return null;
	}

	/**
	 * Resets player timer in case he attacks again, so his highlight doesn't go away so easily
	 *
	 * @param container
	 */
	private void resetPlayerFromAttackerContainerTimer(PlayerContainer container)
	{
		removePlayerFromAttackerContainer(container);
		PlayerContainer newContainer = new PlayerContainer(container.getPlayer(), System.currentTimeMillis(), (this.attackerTargetTimeout * 1000));
		playersAttackingMe.add(newContainer);
	}

	void removePlayerFromPotentialContainer(PlayerContainer container)
	{
		if ((potentialPlayersAttackingMe != null) && (!potentialPlayersAttackingMe.isEmpty()))
		{
			potentialPlayersAttackingMe.remove(container);
		}
	}

	void removePlayerFromAttackerContainer(PlayerContainer container)
	{
		if ((playersAttackingMe != null) && (!playersAttackingMe.isEmpty()))
		{
			playersAttackingMe.remove(container);
		}
	}

	private boolean isBlockAnimation(int anim)
	{
		switch (anim)
		{
			case AnimationID.BLOCK_DEFENDER:
			case AnimationID.BLOCK_NO_SHIELD:
			case AnimationID.BLOCK_SHIELD:
			case AnimationID.BLOCK_SWORD:
			case AnimationID.BLOCK_UNARMED:
				return true;
			default:
				return false;
		}
	}

	List<PlayerContainer> getPotentialPlayersAttackingMe()
	{
		return potentialPlayersAttackingMe;
	}

	List<PlayerContainer> getPlayersAttackingMe()
	{
		return playersAttackingMe;
	}

	//All of the methods below are from the Zulrah plugin!!! Credits to it's respective owner
	private void loadProtectionIcons()
	{
		for (int i = 0; i < PROTECTION_ICONS.length; i++)
		{
			final int resource = PROTECTION_ICONS[i];
			ProtectionIcons[i] = rgbaToIndexedBufferedImage(ProtectionIconFromSprite(spriteManager.getSprite(resource, 0)));
		}
	}

	private static BufferedImage rgbaToIndexedBufferedImage(final BufferedImage sourceBufferedImage)
	{
		final BufferedImage indexedImage = new BufferedImage(
			sourceBufferedImage.getWidth(),
			sourceBufferedImage.getHeight(),
			BufferedImage.TYPE_BYTE_INDEXED);

		final ColorModel cm = indexedImage.getColorModel();
		final IndexColorModel icm = (IndexColorModel) cm;

		final int size = icm.getMapSize();
		final byte[] reds = new byte[size];
		final byte[] greens = new byte[size];
		final byte[] blues = new byte[size];
		icm.getReds(reds);
		icm.getGreens(greens);
		icm.getBlues(blues);

		final WritableRaster raster = indexedImage.getRaster();
		final int pixel = raster.getSample(0, 0, 0);
		final IndexColorModel resultIcm = new IndexColorModel(8, size, reds, greens, blues, pixel);
		final BufferedImage resultIndexedImage = new BufferedImage(resultIcm, raster, sourceBufferedImage.isAlphaPremultiplied(), null);
		resultIndexedImage.getGraphics().drawImage(sourceBufferedImage, 0, 0, null);
		return resultIndexedImage;
	}

	private static BufferedImage ProtectionIconFromSprite(final BufferedImage freezeSprite)
	{
		final BufferedImage freezeCanvas = ImageUtil.resizeCanvas(freezeSprite, PROTECTION_ICON_DIMENSION.width, PROTECTION_ICON_DIMENSION.height);
		return ImageUtil.outlineImage(freezeCanvas, PROTECTION_ICON_OUTLINE_COLOR);
	}

	BufferedImage getProtectionIcon(WeaponType weaponType)
	{
		switch (weaponType)
		{
			case WEAPON_RANGED:
				return ProtectionIcons[0];
			case WEAPON_MELEE:
				return ProtectionIcons[1];
			case WEAPON_MAGIC:
				return ProtectionIcons[2];
		}
		return null;
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("prayagainstplayer"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.attackerPlayerColor = config.attackerPlayerColor();
		this.potentialPlayerColor = config.potentialPlayerColor();
		this.attackerTargetTimeout = config.attackerTargetTimeout();
		this.potentialTargetTimeout = config.potentialTargetTimeout();
		this.newSpawnTimeout = config.newSpawnTimeout();
		this.ignoreFriends = config.ignoreFriends();
		this.ignoreClanMates = config.ignoreClanMates();
		this.markNewPlayer = config.markNewPlayer();
		this.drawTargetPrayAgainst = config.drawTargetPrayAgainst();
		this.drawPotentialTargetPrayAgainst = config.drawPotentialTargetPrayAgainst();
		this.drawTargetPrayAgainstPrayerTab = config.drawTargetPrayAgainstPrayerTab();
		this.drawTargetsName = config.drawTargetsName();
		this.drawPotentialTargetsName = config.drawPotentialTargetsName();
		this.drawTargetHighlight = config.drawTargetHighlight();
		this.drawPotentialTargetHighlight = config.drawPotentialTargetHighlight();
		this.drawTargetTile = config.drawTargetTile();
		this.drawPotentialTargetTile = config.drawPotentialTargetTile();
		this.drawUnknownWeapons = config.drawUnknownWeapons();
	}
}
