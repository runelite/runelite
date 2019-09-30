/*
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.playerinfo;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.SpriteID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import static net.runelite.client.plugins.playerinfo.PlayerInfoCustomIndicator.IndicatorType;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Player Information",
	description = "An alternative to the Minimap Orbs",
	tags = {"combat", "overlay"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
public class PlayerInfoPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private PlayerInfoConfig config;

	@Inject
	private SpriteManager spriteManager;

	@Getter(AccessLevel.PACKAGE)
	private boolean enableHealth;
	@Getter(AccessLevel.PACKAGE)
	private boolean enablePrayer;
	@Getter(AccessLevel.PACKAGE)
	private boolean enableEnergy;
	@Getter(AccessLevel.PACKAGE)
	private boolean enableSpec;
	@Getter(AccessLevel.PACKAGE)
	private boolean enableWorld;
	@Getter(AccessLevel.PACKAGE)
	private Color colorHigh;
	@Getter(AccessLevel.PACKAGE)
	private Color colorMed;
	@Getter(AccessLevel.PACKAGE)
	private Color colorLow;

	@Provides
	PlayerInfoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PlayerInfoConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();

		clientThread.invoke(() ->
		{
			if (client.getGameState().ordinal() < GameState.LOGIN_SCREEN.ordinal())
			{
				return false;
			}

			BufferedImage healthImg = spriteManager.getSprite(SpriteID.MINIMAP_ORB_HITPOINTS_ICON, 0);
			BufferedImage prayerImg = spriteManager.getSprite(SpriteID.MINIMAP_ORB_PRAYER_ICON, 0);
			BufferedImage energyImg = spriteManager.getSprite(SpriteID.MINIMAP_ORB_RUN_ICON, 0);
			BufferedImage combatImg = spriteManager.getSprite(SpriteID.MINIMAP_ORB_SPECIAL_ICON, 0);
			BufferedImage worldImg = spriteManager.getSprite(SpriteID.MINIMAP_ORB_WORLD_MAP_PLANET, 0);

			infoBoxManager.addInfoBox(new PlayerInfoCustomIndicator(healthImg, this, client, IndicatorType.HEALTH));
			infoBoxManager.addInfoBox(new PlayerInfoCustomIndicator(prayerImg, this, client, IndicatorType.PRAYER));
			infoBoxManager.addInfoBox(new PlayerInfoCustomIndicator(energyImg, this, client, IndicatorType.ENERGY));
			infoBoxManager.addInfoBox(new PlayerInfoCustomIndicator(combatImg, this, client, IndicatorType.SPECIAL));
			infoBoxManager.addInfoBox(new PlayerInfoCustomIndicator(worldImg, this, client, IndicatorType.WORLD));

			return true;
		});
	}

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(i -> i instanceof PlayerInfoCustomIndicator);
	}

	private void updateConfig()
	{
		this.enableHealth = config.enableHealth();
		this.enablePrayer = config.enablePrayer();
		this.enableEnergy = config.enableEnergy();
		this.enableSpec = config.enableSpec();
		this.enableWorld = config.enableWorld();
		this.colorHigh = config.colorHigh();
		this.colorMed = config.colorMed();
		this.colorLow = config.colorLow();
	}
}
