/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
 * Copyright (c) 2020, Sean 'Furret' Hill <https://github.com/hisean1>
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

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;

import java.awt.*;
import javax.inject.Inject;
import lombok.Getter;
import lombok.AllArgsConstructor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
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
public class BarbarianAssaultPlugin extends Plugin
{
	private static final int BA_WAVE_NUM_INDEX = 2;
	private static final int BA_WAVE_COUNT = 10;
	private static final String START_WAVE = "1";
	private static final String ENDGAME_REWARD_NEEDLE_TEXT = "<br>5";
	private static final String CONFIG_GROUP = "barbarianAssault";

	final int[] childIDsOfPointsWidgets = new int[]{33, 32, 25, 26, 24, 28, 31, 27, 29, 30, 21, 22, 19};

	private int pointsHealer, pointsDefender , pointsCollector, pointsAttacker, totalEggsCollected, totalIncorrectAttacks, totalHealthReplenished;
/*
    @AllArgsConstructor
	public enum RunCategory
    {
        SOLOHEALWR("Solo Heal WR"),
        DUOHEALWR("Duo Heal WR"),
        LEECHWR("Leech WR"),
        SOLOHEALPB("Solo Heal PB"),
        DUOHEALPB("Duo Heal PB"),
        LEECHPB("Leech PB"),
        CUSTOM("Custom");

        private String name = "";

        @Override
        public String toString()
        {
            return name;
        }
    }*/

	private static final Gson GSON = new Gson();

	private Font font;
	private Image clockImage;
	private int inGameBit = 0;
	private String currentWave = START_WAVE;
	private GameTimer gameTime;

	private String[] waveGoal = {"0:30", "0:37", "0:43", "0:42", "0:48", "1:01", "1:09", "1:12", "1:21", "1:48"};

	//private HashMap<runCategory, Boolean> timeMap = new HashMap<>();

	@Getter
	private Round currentRound;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BarbarianAssaultConfig config;

	@Inject
	private TimerOverlay timerOverlay;

	@Inject
	private HealerOverlay healerOverlay;

	@Provides
	BarbarianAssaultConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BarbarianAssaultConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(timerOverlay);
		overlayManager.add(healerOverlay);
		font = FontManager.getRunescapeFont()
			.deriveFont(Font.BOLD, 24);

		clockImage = ImageUtil.getResourceStreamFromClass(getClass(), "clock.png");

/*
		// Set which times to read splits for
		timeMap.put(runCategory.SOLOHEALWR, config.soloHealWR());
		timeMap.put(runCategory.DUOHEALWR, config.duoHealWR());
		timeMap.put(runCategory.LEECHWR, config.leechWR());
		timeMap.put(runCategory.SOLOHEALPB, config.soloHealPB());
		timeMap.put(runCategory.DUOHEALPB, config.duoHealPB());
		timeMap.put(runCategory.LEECHPB, config.leechPB());
		timeMap.put(runCategory.CUSTOM, config.custom());
*/

		// Save splits for current WRs and custom times
		saveTime(RunCategory.SOLOHEALWR, new String[] {"0:30", "1:10", "1:56", "2:42", "3:32", "4:40", "5:51", "7:07", "8:32", "10:20"});
		saveTime(RunCategory.DUOHEALWR, new String[] {"0:30", "1:11", "1:57", "2:41", "3:33", "4:34", "5:38", "6:48", "8:11", "9:57"});
		saveTime(RunCategory.LEECHWR, new String[] {"0:32", "1:14", "2:04", "2:55", "3:52", "4:57", "6:10", "7:27", "8:56", "10:50"});
		saveTime(RunCategory.CUSTOM, parseWaveTimesFromString(config.getDesiredWaveSplits()));

		// Placeholder PBs
		saveTime(RunCategory.SOLOHEALPB, new String[] {"0:30", "1:10", "1:55", "2:42", "3:31", "4:36", "5:54", "7:12", "8:40", "10:30"});
		saveTime(RunCategory.DUOHEALPB, new String[] {"0:30", "1:10", "1:55", "2:42", "3:31", "4:36", "5:54", "7:12", "8:40", "10:30"});
		saveTime(RunCategory.LEECHPB, new String[] {"0:30", "1:10", "1:55", "2:42", "3:31", "4:36", "5:54", "7:12", "8:40", "10:30"});

		// Read in the custom wave end times
		if (config.category() == RunCategory.CUSTOM)
		{
			// Only overwrite if string looks valid
			if (parseWaveTimesFromString(config.getDesiredWaveTimes()).length == 10) {
				waveGoal = parseWaveTimesFromString((config.getDesiredWaveTimes()));
			}
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(timerOverlay);
		overlayManager.remove(healerOverlay);
		gameTime = null;
		currentWave = START_WAVE;
		inGameBit = 0;
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		switch (event.getGroupId())
		{
			case WidgetID.BA_REWARD_GROUP_ID:
			{
				Widget rewardWidget = client.getWidget(WidgetInfo.BA_REWARD_TEXT);
				Widget pointsWidget = client.getWidget(WidgetID.BA_REWARD_GROUP_ID, 14); //RUNNERS_PASSED

				// Wave 10 ended
				if (config.waveTimes() && rewardWidget != null && rewardWidget.getText().contains(ENDGAME_REWARD_NEEDLE_TEXT) && gameTime != null)
				{
					gameTime = null;
					ChatMessageBuilder message = new ChatMessageBuilder()
						.append("Attacker: ")
						.append(Color.red, pointsAttacker+80+"")
						.append(" |  Healer: ")
						.append(Color.GREEN, pointsHealer+80+"")
						.append(" | Defender: ")
						.append(Color.blue, pointsDefender+80+"")
						.append(" | Collector: ")
						.append(Color.yellow, pointsCollector+80+"")
						.append(System.getProperty("line.separator"))
						.append(totalEggsCollected + " eggs collected, "+ totalHealthReplenished + "HP vialed and " + totalIncorrectAttacks+" wrong attacks.");

					if(config.pointBreakdown())
					{
						chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.CONSOLE).runeLiteFormattedMessage(message.build()).build());
					}
				}
				// Wave 1-9 ended
				else if(pointsWidget != null && client.getVar(Varbits.IN_GAME_BA) == 0)
				{
					int wavePoints_Attacker, wavePoints_Defender, wavePoints_Healer, wavePoints_Collector, waveEggsCollected, waveHPReplenished, waveFailedAttacks;

					wavePoints_Attacker = wavePoints_Defender = wavePoints_Healer = wavePoints_Collector = Integer.parseInt(client.getWidget(WidgetID.BA_REWARD_GROUP_ID, childIDsOfPointsWidgets[0]).getText()); //set base pts to all roles
					waveEggsCollected = waveHPReplenished = waveFailedAttacks = 0;

					// Gather post-wave info from points widget
					for (int i = 0; i < childIDsOfPointsWidgets.length; i++)
					{
						int value = Integer.parseInt(client.getWidget(WidgetID.BA_REWARD_GROUP_ID, childIDsOfPointsWidgets[i]).getText());

						switch (i)
						{
							case 1:
							case 2:
							case 3:
								wavePoints_Attacker += value;
								break;
							case 4:
							case 5:
								wavePoints_Defender += value;
								break;
							case 6:
								wavePoints_Collector += value;
								break;
							case 7:
							case 8:
							case 9:
								wavePoints_Healer += value;
								break;
							case 10:
								waveEggsCollected = value;
								totalEggsCollected += value;

								break;
							case 11:
								waveFailedAttacks = value;
								totalIncorrectAttacks += value;
								break;
							case 12:
								waveHPReplenished = value;
								totalHealthReplenished += value;
								break;
						}
					}

					pointsCollector += wavePoints_Collector;
					pointsHealer += wavePoints_Healer;
					pointsDefender += wavePoints_Defender;
					pointsAttacker += wavePoints_Attacker;

					ChatMessageBuilder message = new ChatMessageBuilder()
							.append("Attacker: ")
							.append(Color.red, wavePoints_Attacker+"")
							.append(" |  Healer: ")
							.append(Color.GREEN, wavePoints_Healer+"")
							.append(" | Defender: ")
							.append(Color.blue, wavePoints_Defender+"")
							.append(" | Collector: ")
							.append(Color.yellow, wavePoints_Collector+"")
							.append(System.getProperty("line.separator"))
							.append(waveEggsCollected + " eggs collected, "+ waveHPReplenished + "HP vialed and " + waveFailedAttacks+" wrong attacks.");

					if(config.pointBreakdown())
					{
						chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.CONSOLE).runeLiteFormattedMessage(message.build()).build());
					}
				}

				break;
			}
			case WidgetID.BA_ATTACKER_GROUP_ID:
			{
				setRound(Role.ATTACKER);
				break;
			}
			case WidgetID.BA_DEFENDER_GROUP_ID:
			{
				setRound(Role.DEFENDER);
				break;
			}
			case WidgetID.BA_HEALER_GROUP_ID:
			{
				setRound(Role.HEALER);
				break;
			}
			case WidgetID.BA_COLLECTOR_GROUP_ID:
			{
				setRound(Role.COLLECTOR);
				break;
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.GAMEMESSAGE
			&& event.getMessage().startsWith("---- Wave:"))
		{
			String[] message = event.getMessage().split(" ");
			currentWave = message[BA_WAVE_NUM_INDEX];

			if (currentWave.equals(START_WAVE))
			{
				gameTime = new GameTimer();
				pointsHealer = pointsDefender = pointsCollector = pointsAttacker = totalEggsCollected = totalIncorrectAttacks = totalHealthReplenished = 0;
			}
			else if (gameTime != null)
			{
				gameTime.setWaveStartTime();
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int inGame = client.getVar(Varbits.IN_GAME_BA);

		if (inGameBit != inGame)
		{
			if (inGameBit == 1)
			{
				currentRound = null;

				// Use an instance check to determine if this is exiting a game or a tutorial
				// After exiting tutorials there is a small delay before changing IN_GAME_BA back to
				// 0 whereas when in a real wave it changes while still in the instance.
				if (config.waveTimes() && gameTime != null && client.isInInstancedRegion())
				{
				    int curWave = 0;
				    try
                    {
                        curWave = Integer.parseInt(currentWave);
                    }
				    catch (NumberFormatException nfex)
                    {
                        return;
                    }

				    // Display relevant post-wave info based on plugin settings
				    waveEnd(curWave, gameTime.getTime(false));
				}
			}
		}

		inGameBit = inGame;
	}

	private void setRound(Role role)
	{
		// Prevent changing rounds when a round is already set, as widgets can be
		// loaded multiple times in game from eg. opening and closing the horn
		// of glory.
		if (currentRound == null)
		{
			currentRound = new Round(role);
		}
	}

	private void waveEnd(int waveNum, String time)
	{
		if (waveNum < 1 || waveNum > BA_WAVE_COUNT)
		{
			final String errormsg = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append("waveNum: " + waveNum)
					.build();

			chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.CONSOLE)
					.runeLiteFormattedMessage(errormsg)
					.build());
			return;
		}

		// Display wave durations
		if (config.waveTimes())
		{
			announceTime(waveNum, gameTime.getTime(true));
		}

		// Compare splits against all checked times
		if (config.waveSplits())
		{
			announceTime(waveNum, config.category(), time);

			/*
			for (runCategory c : timeMap.keySet()) {
				if (timeMap.get(c)) {
					announceTime(waveNum, c, time);
				}
			}*/
		}
	}

	private void announceTime(int waveNum, String time)
	{
		// Error if waveNum is invalid
		if (waveNum < 1 || waveNum > BA_WAVE_COUNT)
		{
			final String errormsg = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append("Invalid waveNum: " + waveNum)
					.build();

			chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.CONSOLE)
					.runeLiteFormattedMessage(errormsg)
					.build());
			return;
		}

		String timeMessage = "";

		// Write a wave time message if the option is checked
		if (config.waveTimes())
		{
			// Include a goal comparison if the option is checked
			if (config.waveCompare())
			{
				timeMessage = new ChatMessageBuilder()
					.append(ChatColorType.NORMAL)
					.append("Wave " + waveNum + " goal: ")
					.append(Color.BLUE, waveGoal[waveNum - 1])
					.append(ChatColorType.NORMAL)
					.append(" || Duration: ")
					.append(compareSplitColor(time, waveGoal[waveNum - 1]), time)
					.build();
			}
			else
			{
				timeMessage = new ChatMessageBuilder()
					.append(ChatColorType.NORMAL)
					.append("Wave " + waveNum + " duration: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(time)
					.build();
			}

			chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.CONSOLE)
					.runeLiteFormattedMessage(timeMessage)
					.build());
		}
	}

	private void announceTime(int waveNum, RunCategory category, String time)
	{
		String[] compareTimes = getTimes(category);
		if (waveNum < 1 || waveNum > compareTimes.length)
        {
            return;
        }

		final String timeMessage = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append(category.toString() + " - Wave " + waveNum + " pace: ")
			.append(Color.BLUE, compareTimes[waveNum-1])
			.append(ChatColorType.NORMAL)
			.append(" || Split: ")
			.append(compareSplitColor(time, compareTimes[waveNum-1]), time + " (" + (timeToSeconds(time) - timeToSeconds(compareTimes[waveNum-1]) ) + "s)")
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(timeMessage)
			.build());
	}

	private Color compareSplitColor(String split, String pace)
	{
		if (timeToSeconds(split) < timeToSeconds(pace))
		{
			return Color.GREEN;
		}
		else if (timeToSeconds(split) > timeToSeconds(pace))
		{
			return Color.RED;
		}
		else
		{
			return Color.BLUE;
		}
	}

	private int timeToSeconds(String time)
	{
		String times[] = time.split(":");
		try {
			if (times.length == 1) {
				return Integer.parseInt(time);
			}
			else if(times.length == 2)
			{
				return (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
			}
			else
			{
				return 0;
			}
		}
		catch (NumberFormatException nfex)
		{
			return -1;
		}
	}

	private String[] parseWaveTimesFromString(String timeString)
	{
		String[] timeArray = timeString.split("[,\\s\n]");

		if (timeArray.length != 10)
		{
			// bad
            return new String[0];
		}
		return timeArray;
	}
/*
	private String runCategoryString(runCategory category)
	{
		switch (category)
		{
			case SOLOHEALWR:
				return "Solo Heal WR";
			case DUOHEALWR:
				return "Duo Heal WR";
			case LEECHWR:
				return "Leech WR";
			case SOLOHEALPB:
				return "Solo Heal PB";
			case DUOHEALPB:
				return "Duo Heal PB";
			case LEECHPB:
				return "Leech PB";
			case CUSTOM:
				return "Custom";
			default:
				return "Invalid Run Category";
		}
	}*/

	private void saveTime(RunCategory category, String[] times)
	{
		if (times == null || times.length == 0)
		{
			configManager.unsetConfiguration(CONFIG_GROUP, category.toString());
			return;
		}

		String json = GSON.toJson(times);
		configManager.setConfiguration(CONFIG_GROUP, category.toString(), json);
	}

	private String[] getTimes(RunCategory category)
	{
		String json = configManager.getConfiguration(CONFIG_GROUP, category.toString());
		if (Strings.isNullOrEmpty(json))
		{
			return new String[0];
		}

		// CHECKSTYLE:OFF
		return GSON.fromJson(json, new TypeToken<String[]>(){}.getType());
		// CHECKSTYLE:ON
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
