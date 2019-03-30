/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
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

import com.google.inject.Provides;
import java.awt.Font;
import java.awt.Image;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.kit.KitType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Barbarian Assault",
	description = "Show a timer to the next call change and game/wave duration in chat.",
	tags = {"minigame", "overlay", "timer"}
)
public class BarbarianAssaultPlugin extends Plugin {
	private static final int BA_WAVE_NUM_INDEX = 2;
	private static final String START_WAVE = "1";
	private static final String ENDGAME_REWARD_NEEDLE_TEXT = "<br>5";

	@Getter
	private int collectedEggCount = 0;
	@Getter
	private int HpHealed = 0;
	@Getter
	private int totalCollectedEggCount = 0;
	@Getter
	private int totalHpHealed = 0;

	private Font font;
	private Image clockImage;
	private int inGameBit = 0;
	private String currentWave = START_WAVE;
	private GameTimer gameTime;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BarbarianAssaultConfig config;

	@Inject
	private BarbarianAssaultOverlay overlay;

	@Provides
	BarbarianAssaultConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(BarbarianAssaultConfig.class);
	}

	@Override
	protected void startUp() throws Exception {
		overlayManager.add(overlay);
		font = FontManager.getRunescapeFont()
				.deriveFont(Font.BOLD, 24);

		clockImage = ImageUtil.getResourceStreamFromClass(getClass(), "clock.png");
	}

	@Override
	protected void shutDown() throws Exception {
		overlayManager.remove(overlay);
		gameTime = null;
		currentWave = START_WAVE;
		inGameBit = 0;
		collectedEggCount = 0;
		HpHealed = 0;
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event) {
		if (event.getGroupId() == WidgetID.BA_REWARD_GROUP_ID) {
			Widget rewardWidget = client.getWidget(WidgetInfo.BA_REWARD_TEXT);
			String amt,type,totalMsg,total;
			amt=type=totalMsg=total="";
			if (config.waveTimes() && rewardWidget != null && rewardWidget.getText().contains(ENDGAME_REWARD_NEEDLE_TEXT) && gameTime != null) {
				if (config.showHpCount() && HpHealed > 0) {
					totalMsg = "; Total Healed: ";
					total = ""+totalHpHealed;
				}
				else if (config.showEggCount() && collectedEggCount > 0) {
					totalMsg = "; Total Collected: ";
					total = ""+totalCollectedEggCount;
				}

				announceTime("Game finished, duration: ", gameTime.getTime(false),type, amt, totalMsg, total);
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event) {
		if (event.getType() == ChatMessageType.SERVER
				&& event.getMessage().startsWith("---- Wave:")) {
			String[] message = event.getMessage().split(" ");
			currentWave = message[BA_WAVE_NUM_INDEX];
			collectedEggCount = 0;
			HpHealed = 0;

			if (currentWave.equals(START_WAVE)) {
				gameTime = new GameTimer();
			} else if (gameTime != null) {
				gameTime.setWaveStartTime();
			}
		} else if (event.getType() == ChatMessageType.SERVER
				&& event.getMessage().contains("egg explode")) {
			collectedEggCount -= 2;
		} else if (event.getType() == ChatMessageType.SERVER
				&& event.getMessage().contains("healed")) {
			String message = event.getMessage();
			String[] tokens = message.split(" ");
			if (Integer.parseInt(tokens[2]) > 0) {
				int Hp = Integer.parseInt(tokens[2]);
				HpHealed += Hp;
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event) {
		if (client.getVar(Varbits.IN_GAME_BA) == 0 || client.getLocalPlayer() == null || overlay.getCurrentRound() != null) {
			return;
		}
		switch (client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.CAPE)) {
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

	@Subscribe
	public void onVarbitChanged(VarbitChanged event) {
		int inGame = client.getVar(Varbits.IN_GAME_BA);
		String amt,type,totalMsg,total;
		amt=type=totalMsg=total="";
		if (inGameBit != inGame) {
			if (inGameBit == 1) {
				overlay.setCurrentRound(null);

				if (config.waveTimes() && gameTime != null) {
					if (config.showHpCount() && HpHealed > 0) {
						amt = "" + HpHealed;
						type = "; Healed: ";
						totalMsg = "; Total Healed: ";
						total = ""+totalHpHealed;
					}
					else if (config.showEggCount() && collectedEggCount > 0) {
						amt = "" + collectedEggCount;
						type = "; Collected: ";
						totalMsg = "; Total Collected: ";
						total = ""+totalCollectedEggCount;
					}
					if (currentWave.equals("10"))
					{
						totalMsg=total="";
					}
					announceTime("Wave " + currentWave + " duration: ", gameTime.getTime(true), type, amt, totalMsg, total);
				}

			}
		}

		inGameBit = inGame;
	}

	@Subscribe
	public void onItemDespawned(ItemDespawned event)
	{
		if (client.getVar(Varbits.IN_GAME_BA) == 0 || !isEgg(event.getItem().getId()))
		{
			return;
		}
		if (isUnderPlayer(event.getTile()))
		{
			collectedEggCount++;
		}
	}

	private void announceTime(String preText, String time, String type, String amt, String totalMsg, String total) {
		totalCollectedEggCount += collectedEggCount;
		totalHpHealed += HpHealed;

		final String chatMessage = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append(preText)
				.append(ChatColorType.HIGHLIGHT)
				.append(time)
				.append(ChatColorType.NORMAL)
				.append(type)
				.append(ChatColorType.HIGHLIGHT)
				.append(amt)
				.append(ChatColorType.NORMAL)
				.append(totalMsg)
				.append(ChatColorType.HIGHLIGHT)
				.append(total)
				.build();

		chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.GAME)
				.runeLiteFormattedMessage(chatMessage)
				.build());
	}

	private boolean isEgg(int itemID)
	{
		if (itemID == ItemID.RED_EGG || itemID == ItemID.GREEN_EGG
			|| itemID == ItemID.BLUE_EGG || itemID == ItemID.YELLOW_EGG)
		{
			return true;
		}
		return false;
	}

	private boolean isUnderPlayer(Tile tile) {
		Player local = client.getLocalPlayer();
		if (local == null)
		{
			return false;
		}

		return (tile.getWorldLocation().equals(local.getWorldLocation()));
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