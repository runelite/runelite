/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
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
package net.runelite.client.plugins.barbarianassault;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Barbarian Assault"
)
public class BarbarianAssaultPlugin extends Plugin
{
	private final List<MenuEntry> entries = new ArrayList<>();

	private static final int BA_ALL_KILLED_INDEX = 4;

	private Font font;
	private Image clockImage;
	private int inGameBit = 0;

	@Inject
	private Client client;

	@Inject
	private BarbarianAssaultConfig config;

	@Inject
	private BarbarianAssaultOverlay overlay;

	@Provides
	BarbarianAssaultConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BarbarianAssaultConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		font = FontManager.getRunescapeFont()
			.deriveFont(Font.BOLD, 24);

		synchronized (ImageIO.class)
		{
			clockImage = ImageIO.read(getClass().getResourceAsStream("clock.png"));
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getVar(Varbits.IN_GAME_BA) == 1 &&
				overlay.getCurrentRound() == null &&
				client.getLocalPlayer() != null)
		{
			switch (client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.CAPE))
			{
				case ItemID.ATTACKER_ICON:
					overlay.setCurrentRound(new Round(Role.ATTACKER));
					break;
				case ItemID.COLLECTOR_ICON:
					overlay.setCurrentRound(new Round(Role.COLLECTOR));
					break;
				case ItemID.DEFENDER_ICON:
					overlay.setCurrentRound(new Round(Role.DEFENDER));
					break;
				case ItemID.HEALER_ICON:
					overlay.setCurrentRound(new Round(Role.HEALER));
					break;
			}
		}
	}

	@Subscribe
	public void onVarbitChange(VarbitChanged event)
	{
		int inGame = client.getVar(Varbits.IN_GAME_BA);

		if (inGameBit != inGame && inGameBit == 1)
		{
			// end of game
			overlay.setCurrentRound(null);
		}

		inGameBit = inGame;
	}

	@Subscribe
	public void onMessageEvent(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SERVER
			&& event.getMessage().startsWith("All of the Penance"))
		{
			String[] message = event.getMessage().split(" ");
			Round round = overlay.getCurrentRound();
			if (round != null)
			{
				switch (message[BA_ALL_KILLED_INDEX])
				{
					case "Healers":
						round.setHealersKilled(true);
						break;
					case "Runners":
						round.setRunnersKilled(true);
						break;
					case "Fighters":
						round.setFightersKilled(true);
						break;
					case "Rangers":
						round.setRangersKilled(true);
						break;
				}
			}
		}
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	public Font getFont()
	{
		return font;
	}

	public Image getClockImage()
	{
		return clockImage;
	}
}
