/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.client.plugins.slayer;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.eventbus.Subscribe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import joptsimple.internal.Strings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import static net.runelite.api.Skill.SLAYER;

import net.runelite.api.NpcID;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.vars.SlayerUnlock;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Slayer",
	description = "Show additional slayer task related information",
	tags = {"combat", "notifications", "overlay", "tasks"}
)
@Slf4j
public class SlayerPlugin extends Plugin
{
	//Chat messages
	private static final Pattern CHAT_GEM_PROGRESS_MESSAGE = Pattern.compile("^(?:You're assigned to kill|You have received a new Slayer assignment from .*:) (?:the )?(.*?)(?: in the Wilderness)?(?:; only | \\()(\\d*)(?: more to go\\.|\\))$");
	private static final String CHAT_GEM_COMPLETE_MESSAGE = "You need something new to hunt.";
	private static final Pattern CHAT_COMPLETE_MESSAGE = Pattern.compile("(?:\\d+,)*\\d+");
	private static final String CHAT_CANCEL_MESSAGE = "Your task has been cancelled.";
	private static final String CHAT_CANCEL_MESSAGE_JAD = "You no longer have a slayer task as you left the fight cave.";
	private static final String CHAT_SUPERIOR_MESSAGE = "A superior foe has appeared...";
	private static final String CHAT_BRACELET_SLAUGHTER = "Your bracelet of slaughter prevents your slayer";
	private static final Pattern CHAT_BRACELET_SLAUGHTER_REGEX = Pattern.compile("Your bracelet of slaughter prevents your slayer count decreasing. It has (\\d{1,2}) charge[s]? left.");
	private static final String CHAT_BRACELET_EXPEDITIOUS = "Your expeditious bracelet helps you progress your";
	private static final Pattern CHAT_BRACELET_EXPEDITIOUS_REGEX = Pattern.compile("Your expeditious bracelet helps you progress your slayer (?:task )?faster. It has (\\d{1,2}) charge[s]? left.");
	private static final String CHAT_BRACELET_SLAUGHTER_CHARGE = "Your bracelet of slaughter has ";
	private static final Pattern CHAT_BRACELET_SLAUGHTER_CHARGE_REGEX = Pattern.compile("Your bracelet of slaughter has (\\d{1,2}) charge[s]? left.");
	private static final String CHAT_BRACELET_EXPEDITIOUS_CHARGE = "Your expeditious bracelet has ";
	private static final Pattern CHAT_BRACELET_EXPEDITIOUS_CHARGE_REGEX = Pattern.compile("Your expeditious bracelet has (\\d{1,2}) charge[s]? left.");
	private static final Pattern COMBAT_BRACELET_TASK_UPDATE_MESSAGE = Pattern.compile("^You still need to kill (\\d+) monsters to complete your current Slayer assignment");

	//NPC messages
	private static final Pattern NPC_ASSIGN_MESSAGE = Pattern.compile(".*Your new task is to kill\\s*(\\d*) (.*)\\.");
	private static final Pattern NPC_ASSIGN_BOSS_MESSAGE = Pattern.compile("^Excellent. You're now assigned to kill (?:the )?(.*) (\\d+) times.*Your reward point tally is (.*)\\.$");
	private static final Pattern NPC_CURRENT_MESSAGE = Pattern.compile("You're still hunting (.*); you have (\\d*) to go\\..*");

	//Reward UI
	private static final Pattern REWARD_POINTS = Pattern.compile("Reward points: ((?:\\d+,)*\\d+)");

	private static final int GROTESQUE_GUARDIANS_REGION = 6727;

	private static final int EXPEDITIOUS_CHARGE = 30;
	private static final int SLAUGHTER_CHARGE = 30;

	@Inject
	private Client client;

	@Inject
	private SlayerConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private SlayerOverlay overlay;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private Notifier notifier;

	@Inject
	private ClientThread clientThread;

	@Inject
	private TargetClickboxOverlay targetClickboxOverlay;

	@Inject
	private TargetMinimapOverlay targetMinimapOverlay;

	@Getter(AccessLevel.PACKAGE)
	private List<NPC> highlightedTargets = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int amount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int expeditiousChargeCount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int slaughterChargeCount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private String taskName;

	@Getter(AccessLevel.PACKAGE)
	private int streak;

	@Getter(AccessLevel.PACKAGE)
	private int points;

	private static final double EPSILON = 1e-6;
	private static final Map<Integer, Integer> NPC_DEATH_ANIMATIONS = new HashMap<>();

	// perhaps rather than relying on getting the npc ids for specific monsters correct from the cache dump
	// it would make sense to add a method with signature public static List<Integer> getIdsForName(String name)
	// that returns the ids for all npcs that have a name that exactly matches the searched for name
	// this way this map would instead be doing for (int id : getIdsForName("Gargoyle")) {NPC_DEATH_ANIMATIONS.put(id, AnimationID.GARGOYLE_DEATH);}
	static
	{
		NPC_DEATH_ANIMATIONS.put(NpcID.GARGOYLE, AnimationID.GARGOYLE_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.GARGOYLE_413, AnimationID.GARGOYLE_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.GARGOYLE_1543, AnimationID.GARGOYLE_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.MARBLE_GARGOYLE, AnimationID.MARBLE_GARGOYLE_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.MARBLE_GARGOYLE_7408, AnimationID.MARBLE_GARGOYLE_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.ROCKSLUG, AnimationID.ROCKSLUG_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.ROCKSLUG_422, AnimationID.ROCKSLUG_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.LIZARD, AnimationID.LIZARD_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.ZYGOMITE, AnimationID.ZYGOMITE_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.ZYGOMITE_474, AnimationID.ZYGOMITE_DEATH);
		// TODO: DUSK_7888 DUSK_7889

		// TODO: GIANT_ROCKSLUG
		// TODO: SMALL_LIZARD
		// TODO: DESERT_LIZARD

		// TODO: ANCIENT_ZYGOMITE

		// Does ZYOGMITE_DEATH work for ANCIENT_ZYGOMITE?
		// Does ROCKSLUG_DEATAH work for GIANT_ROCKSLUG?
		// Does GARGOYLE_DEATH work for DUSK?
		// Does LIZARD_DEATH work for SMALL_LIZARD and DESERT_LIZARD
		// TODO: must be filled in with death animations of npcs that die with hp > 0
	}

	private TaskCounter counter;
	private int cachedXp;
	private Instant infoTimer;
	private boolean loginFlag;
	private List<String> targetNames = new ArrayList<>();

	private int gainsThisTick = -1;
	private List<NPC> deadThisTick = new ArrayList<>();
	private Map<String, List<Double>> xpMap;

	void loadXpJson()
	{
		final InputStream xpFile = getClass().getResourceAsStream("/slayer_xp.json");
		Gson gson = new Gson();
		xpMap = gson.fromJson(new InputStreamReader(xpFile), new TypeToken<Map<String, List<Double>>>()
		{

		}.getType());
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(targetClickboxOverlay);
		overlayManager.add(targetMinimapOverlay);

		loadXpJson();

		if (client.getGameState() == GameState.LOGGED_IN
			&& config.amount() != -1
			&& !config.taskName().isEmpty())
		{
			points = config.points();
			streak = config.streak();
			setExpeditiousChargeCount(config.expeditious());
			setSlaughterChargeCount(config.slaughter());
			clientThread.invoke(() -> setTask(config.taskName(), config.amount()));
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(targetClickboxOverlay);
		overlayManager.remove(targetMinimapOverlay);
		removeCounter();
		highlightedTargets.clear();
		xpMap.clear();
	}

	@Provides
	SlayerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SlayerConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGING_IN:
				cachedXp = 0;
				taskName = "";
				amount = 0;
				loginFlag = true;
				highlightedTargets.clear();
				break;
			case LOGGED_IN:
				if (config.amount() != -1
					&& !config.taskName().isEmpty()
					&& loginFlag)
				{
					points = config.points();
					streak = config.streak();
					setExpeditiousChargeCount(config.expeditious());
					setSlaughterChargeCount(config.slaughter());
					setTask(config.taskName(), config.amount());
					loginFlag = false;
				}
				break;
		}
	}

	private void save()
	{
		config.amount(amount);
		config.taskName(taskName);
		config.points(points);
		config.streak(streak);
		config.expeditious(expeditiousChargeCount);
		config.slaughter(slaughterChargeCount);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		if (isTarget(npc))
		{
			highlightedTargets.add(npc);
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();
		highlightedTargets.remove(npc);
	}

	@Subscribe
	/**
	 * Xp drops happen on the tick an npc dies which IS NOT the tick it despawns
	 * so detecting death can be done on the animation change plus the isDead()
	 * method on the NPC
	 */
	public void onAnimationChanged(AnimationChanged e)
	{
		if (!(e.getActor() instanceof NPC))
		{
			return;
		}

		final NPC npc = (NPC) e.getActor();
		int id = npc.getId();
		final Integer deathAnim = NPC_DEATH_ANIMATIONS.get(id);
		// note that the reason for the below code checking explicit death animations is because there are some odd
		// cases in the game that could throw us off - most notably desert lizards and rock slugs that can be not dead
		// yet even when npc.isDead() returns true (b/c 0 hp != dead for them) and also the fact that they can be dead
		// at greater than 0 hp (for example desert lizards can be killed at 4 or less hp with the ice thing) so they
		// could throw an animation change and be dying but not trigger the npc.isDead() check.

		// when we aren't special casing the death animation we can just do a simple isDead check
		if (deathAnim == null)
		{
			if (npc.isDead())
			{
				deadThisTick.add(npc);
			}
		}
		// otherwise when we are checking for the death animation explicitly we only add to deadThisTick if
		// the animation matches the expected death animation
		else
		{
			if (deathAnim == npc.getAnimation())
			{
				deadThisTick.add(npc);
			}
		}
	}

	/**
	 * Finds the xp for a given npc using the xp + combat level data provided
	 * from the JSON - since scrapping from the wiki isn't perfectly accurate
	 * we make some estimations
	 *
	 * precondition is that xpCombatLevel array is non-null - if it is null
	 * we can simply return -1 to indicate no slayer xp because this npc
	 * has no associated xpCombatLevel array
	 *
	 * 1. first check to see if anywhere in the xp + combat level data this
	 *    creature name give slayer xp - if it doesn't just return -1 and
	 *    be done with this - if it does give slayer xp then continue
	 * 2. now check to see if we can find the xp for this combat level where
	 *    that xp is greater than 0. note that we don't just find the xp for
	 *    this combat level - this is because for some monsters the wiki
	 *    only has slayer xp data for some combat levels and has it unknown
	 *    for the other combat levels. this way we only return the combat level
	 *    related xp data for a monster if it is know
	 * 3. finally if the slayer xp data for the monster was unknown for the given
	 *    level we estimate the slayer xp by using one of the slayer xps for a level
	 *    that does have xp given
	 * 4. note that if a monster gives no slayer xp for any level it will return
	 *    -1 so we don't accidentally misscount non-slayer targets dying as giving
	 *    slayer xp
	 *
	 * @param npc the npc we are estimating slayer xp for
	 * @param xpCombatLevel the data mapping combat lvl -> xp for this npc name
	 * @return our best guess for the slayer xp for this npc
	 */
	private double findXpForNpc(NPC npc, List<Double> xpCombatLevel)
	{
		if (xpCombatLevel == null)
		{
			return -1;
		}
		boolean givesSlayerXp = false;
		for (int i = 0; i < xpCombatLevel.size() - 1; i += 2)
		{
			if (xpCombatLevel.get(i) > 0)
			{
				givesSlayerXp = true;
			}
		}
		if (!givesSlayerXp)
		{
			return -1;
		}
		boolean foundCombatLevel = false;
		for (int i = 0; i < xpCombatLevel.size() - 1; i += 2)
		{
			if (Math.abs(xpCombatLevel.get(i + 1) - npc.getCombatLevel()) < EPSILON
				&& xpCombatLevel.get(i) > 0)
			{
				foundCombatLevel = true;
			}
		}
		if (foundCombatLevel)
		{
			for (int i = 0; i < xpCombatLevel.size() - 1; i += 2)
			{
				if (Math.abs(xpCombatLevel.get(i + 1) - npc.getCombatLevel()) < EPSILON)
				{
					return xpCombatLevel.get(i);
				}
			}
		}
		else
		{
			for (int i = 0; i < xpCombatLevel.size() - 1; i += 2)
			{
				if (xpCombatLevel.get(i) > 0)
				{
					return xpCombatLevel.get(i);
				}
			}
		}
		return -1;
	}

	// the knapsack problem solver used only finds the maximum value that could have been put into the sack, not the items required
	// to obtain that value so now we must use that maximum value information to compute the items that actually would obtain
	// that value
	private List<Map.Entry<NPC, Integer>> reconstructItemsInSack(int [] [] sackTable, List<Map.Entry<NPC, Integer>> orderedIntXpDrops, int i, int w)
	{
		if (i == 0)
		{
			return new ArrayList<>();
		}
		if (sackTable[i][w] > sackTable[i - 1][w])
		{
			List<Map.Entry<NPC, Integer>> list = reconstructItemsInSack(sackTable, orderedIntXpDrops,
					i - 1, w - orderedIntXpDrops.get(i - 1).getValue());
			list.add(orderedIntXpDrops.get(i - 1));
			return list;
		}
		else
		{
			return reconstructItemsInSack(sackTable, orderedIntXpDrops, i - 1, w);
		}
	}

	private int stuffNpcsIntoXp(List<Map.Entry<NPC, Double>> potentialXpDrops, int gains)
	{
		// add one to max gains allowed for knapsack optimization
		// since xp is only sent to us as integers but is stored on servers
		// (and therefore gained as) a double
		int fudgedGains = gains + 1;

		// scale the problem up by a factor of 10 since knapsack problem is solved better with integers
		// and xp drops can have a single number after the decimal point
		int tenFudgedGains = fudgedGains * 10;
		List<Map.Entry<NPC, Integer>> orderedIntXpDrops = potentialXpDrops.stream()
			.map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), (int) (entry.getValue() * 10)))
			.collect(Collectors.toCollection(ArrayList::new));

		// see https://en.wikipedia.org/wiki/Knapsack_problem for psuedocode for 0/1 knapsack problem
		// extended to bounded knapsack problem by simply having multiples of each item that has multiples
		int itemCount = orderedIntXpDrops.size();

		int[] [] sackMatrix = new int[itemCount + 1] [tenFudgedGains + 1];
		for (int i = 1; i <= itemCount; i++)
		{
			for (int j = 0; j <= tenFudgedGains; j++)
			{
				if (orderedIntXpDrops.get(i - 1).getValue() > j)
				{
					sackMatrix[i][j] = sackMatrix[i - 1][j];
				}
				else
				{
					// note that for our purposes of the knapsack problem we want the value of each item exactly
					// equal to the weight of the item. this ensures that the maximum sack value we calculated is
					// equal to the max sack weight which means it is the maximum amount of xp from kills that we
					// can shove into the xp drop the player received
					sackMatrix[i][j] = Math.max(
						sackMatrix[i - 1][j],
						sackMatrix[i - 1][j - orderedIntXpDrops.get(i - 1).getValue()] +
							(orderedIntXpDrops.get(i - 1).getValue()));
				}
			}
		}
		return reconstructItemsInSack(sackMatrix, orderedIntXpDrops, itemCount, tenFudgedGains).size();
	}

	int estimateKillCount(List<NPC> died, int gains)
	{
		// first determine potential xp drops given by all npcs that died this tick by grabbing the slayer xp
		// info from the map made out of the data in slayer_xp.json
		List<Map.Entry<NPC, Double>> potentialXpDrops = new ArrayList<>();
		for (NPC dead : died)
		{
			List<Double> xpCombatLevel = xpMap.get(dead.getName());
			double xp = findXpForNpc(dead, xpCombatLevel);
			potentialXpDrops.add(new AbstractMap.SimpleEntry<NPC, Double>(dead, xp));
		}
		// we can attempt to determine exactly how many npcs died to give this amount of xp
		// by using a solver for the knapsack problem
		int estimatedCount = stuffNpcsIntoXp(potentialXpDrops, gains);
		// if the knapsack solver gets 0 we want to make sure that we think at least 1 enemy died
		// if xp was gained
		if (estimatedCount <= 0 && gains > 0)
		{
			estimatedCount = 1;
		}
		// cannot have an estimate larger than the number of enemies that died this tick - note
		// that this may happen if the player gets slayer xp from a quest while a task is running
		// this should make sure that the quest xp (hopefully) does not get registered as a kill
		if (estimatedCount > died.size())
		{
			estimatedCount = died.size();
		}
		return estimatedCount;
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (gainsThisTick > 0)
		{
			int killed = estimateKillCount(deadThisTick, gainsThisTick);
			for (int i = 0; i < killed; i++)
			{
				killedOne();
			}
		}

		// we only need to track the npcs that died and xp gains on a tick by tick basis so when we receive the game
		// tick we reset both of these - this is viable because the onGameTick method will be called after we
		// get onExperienceChanged and onAnimationChanged - note that this means that if the order of those methods
		// changes then this will break - therefore we need a test in the slayer plugin that verifies that the runelite
		// always makes these things go in that order, i.e. (xp change + animation change before game tick)
		deadThisTick.clear();
		gainsThisTick = -1;

		Widget npcDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		if (npcDialog != null)
		{
			String npcText = Text.sanitizeMultilineText(npcDialog.getText()); //remove color and linebreaks
			final Matcher mAssign = NPC_ASSIGN_MESSAGE.matcher(npcText); //number, name
			final Matcher mAssignBoss = NPC_ASSIGN_BOSS_MESSAGE.matcher(npcText); // name, number, points
			final Matcher mCurrent = NPC_CURRENT_MESSAGE.matcher(npcText); //name, number

			if (mAssign.find())
			{
				setTask(mAssign.group(2), Integer.parseInt(mAssign.group(1)));
			}
			else if (mAssignBoss.find())
			{
				setTask(mAssignBoss.group(1), Integer.parseInt(mAssignBoss.group(2)));
				points = Integer.parseInt(mAssignBoss.group(3).replaceAll(",", ""));
			}
			else if (mCurrent.find())
			{
				setTask(mCurrent.group(1), Integer.parseInt(mCurrent.group(2)));
			}
		}

		Widget braceletBreakWidget = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
		if (braceletBreakWidget != null)
		{
			String braceletText = Text.removeTags(braceletBreakWidget.getText()); //remove color and linebreaks
			if (braceletText.contains("bracelet of slaughter"))
			{
				slaughterChargeCount = SLAUGHTER_CHARGE;
				config.slaughter(slaughterChargeCount);
			}
			else if (braceletText.contains("expeditious bracelet"))
			{
				expeditiousChargeCount = EXPEDITIOUS_CHARGE;
				config.expeditious(expeditiousChargeCount);
			}
		}

		Widget rewardsBarWidget = client.getWidget(WidgetInfo.SLAYER_REWARDS_TOPBAR);
		if (rewardsBarWidget != null)
		{
			for (Widget w : rewardsBarWidget.getDynamicChildren())
			{
				Matcher mPoints = REWARD_POINTS.matcher(w.getText());
				if (mPoints.find())
				{
					points = Integer.parseInt(mPoints.group(1).replaceAll(",", ""));
					break;
				}
			}
		}

		if (infoTimer != null)
		{
			Duration timeSinceInfobox = Duration.between(infoTimer, Instant.now());
			Duration statTimeout = Duration.ofMinutes(config.statTimeout());

			if (timeSinceInfobox.compareTo(statTimeout) >= 0)
			{
				removeCounter();
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String chatMsg = Text.removeTags(event.getMessage()); //remove color and linebreaks

		if (chatMsg.startsWith(CHAT_BRACELET_SLAUGHTER))
		{
			Matcher mSlaughter = CHAT_BRACELET_SLAUGHTER_REGEX.matcher(chatMsg);

			amount++;
			slaughterChargeCount = mSlaughter.find() ? Integer.parseInt(mSlaughter.group(1)) : SLAUGHTER_CHARGE;
			config.slaughter(slaughterChargeCount);
		}

		if (chatMsg.startsWith(CHAT_BRACELET_EXPEDITIOUS))
		{
			Matcher mExpeditious = CHAT_BRACELET_EXPEDITIOUS_REGEX.matcher(chatMsg);

			amount--;
			expeditiousChargeCount = mExpeditious.find() ? Integer.parseInt(mExpeditious.group(1)) : EXPEDITIOUS_CHARGE;
			config.expeditious(expeditiousChargeCount);
		}

		if (chatMsg.startsWith(CHAT_BRACELET_EXPEDITIOUS_CHARGE))
		{
			Matcher mExpeditious = CHAT_BRACELET_EXPEDITIOUS_CHARGE_REGEX.matcher(chatMsg);

			if (!mExpeditious.find())
			{
				return;
			}

			expeditiousChargeCount = Integer.parseInt(mExpeditious.group(1));
			config.expeditious(expeditiousChargeCount);
		}
		if (chatMsg.startsWith(CHAT_BRACELET_SLAUGHTER_CHARGE))
		{
			Matcher mSlaughter = CHAT_BRACELET_SLAUGHTER_CHARGE_REGEX.matcher(chatMsg);
			if (!mSlaughter.find())
			{
				return;
			}

			slaughterChargeCount = Integer.parseInt(mSlaughter.group(1));
			config.slaughter(slaughterChargeCount);
		}

		if (chatMsg.endsWith("; return to a Slayer master."))
		{
			Matcher mComplete = CHAT_COMPLETE_MESSAGE.matcher(chatMsg);

			List<String> matches = new ArrayList<>();
			while (mComplete.find())
			{
				matches.add(mComplete.group(0).replaceAll(",", ""));
			}

			switch (matches.size())
			{
				case 0:
					streak = 1;
					break;
				case 1:
					streak = Integer.parseInt(matches.get(0));
					break;
				case 3:
					streak = Integer.parseInt(matches.get(0));
					points = Integer.parseInt(matches.get(2));
					break;
				default:
					log.warn("Unreachable default case for message ending in '; return to Slayer master'");
			}
			setTask("", 0);
			return;
		}

		if (chatMsg.equals(CHAT_GEM_COMPLETE_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE_JAD))
		{
			setTask("", 0);
			return;
		}

		if (config.showSuperiorNotification() && chatMsg.equals(CHAT_SUPERIOR_MESSAGE))
		{
			notifier.notify(CHAT_SUPERIOR_MESSAGE);
			return;
		}

		Matcher mProgress = CHAT_GEM_PROGRESS_MESSAGE.matcher(chatMsg);

		if (mProgress.find())
		{
			String gemTaskName = mProgress.group(1);
			int gemAmount = Integer.parseInt(mProgress.group(2));
			setTask(gemTaskName, gemAmount);
			return;
		}

		final Matcher bracerProgress = COMBAT_BRACELET_TASK_UPDATE_MESSAGE.matcher(chatMsg);

		if (bracerProgress.find())
		{
			final int taskAmount = Integer.parseInt(bracerProgress.group(1));
			setTask(taskName, taskAmount);

			// Avoid race condition (combat brace message goes through first before XP drop)
			amount++;
		}
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		if (event.getSkill() != SLAYER)
		{
			return;
		}

		int slayerExp = client.getSkillExperience(SLAYER);

		gainsThisTick = slayerExp;

		if (slayerExp <= cachedXp)
		{
			return;
		}

		if (cachedXp == 0)
		{
			// this is the initial xp sent on login
			cachedXp = slayerExp;
			return;
		}

		cachedXp = slayerExp;
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("slayer"))
		{
			return;
		}

		if (config.showInfobox())
		{
			clientThread.invoke(this::addCounter);
		}
		else
		{
			removeCounter();
		}
	}

	@VisibleForTesting
	void killedOne()
	{
		if (amount == 0)
		{
			return;
		}

		amount--;
		if (doubleTroubleExtraKill())
		{
			amount--;
		}

		config.amount(amount); // save changed value

		if (!config.showInfobox())
		{
			return;
		}

		// add and update counter, set timer
		addCounter();
		counter.setText(String.valueOf(amount));
		infoTimer = Instant.now();
	}

	private boolean doubleTroubleExtraKill()
	{
		return WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID() == GROTESQUE_GUARDIANS_REGION &&
				SlayerUnlock.GROTESQUE_GARDIAN_DOUBLE_COUNT.isEnabled(client);
	}

	private boolean isTarget(NPC npc)
	{
		if (targetNames.isEmpty())
		{
			return false;
		}

		String name = npc.getName();
		if (name == null)
		{
			return false;
		}

		name = name.toLowerCase();

		for (String target : targetNames)
		{
			if (name.contains(target))
			{
				NPCComposition composition = npc.getTransformedComposition();
				if (composition != null && Arrays.asList(composition.getActions()).contains("Attack"))
				{
					return true;
				}
			}
		}
		return false;
	}

	private void rebuildTargetNames(Task task)
	{
		targetNames.clear();

		if (task != null)
		{
			Arrays.stream(task.getTargetNames())
				.map(String::toLowerCase)
				.forEach(targetNames::add);

			targetNames.add(taskName.toLowerCase().replaceAll("s$", ""));
		}
	}

	private void rebuildTargetList()
	{
		highlightedTargets.clear();

		for (NPC npc : client.getNpcs())
		{
			if (isTarget(npc))
			{
				highlightedTargets.add(npc);
			}
		}
	}

	private void setTask(String name, int amt)
	{
		taskName = name;
		amount = amt;
		save();
		removeCounter();
		addCounter();
		infoTimer = Instant.now();

		Task task = Task.getTask(name);
		rebuildTargetNames(task);
		rebuildTargetList();
	}

	private void addCounter()
	{
		if (!config.showInfobox() || counter != null || Strings.isNullOrEmpty(taskName))
		{
			return;
		}

		Task task = Task.getTask(taskName);
		int itemSpriteId = ItemID.ENCHANTED_GEM;
		if (task != null)
		{
			itemSpriteId = task.getItemSpriteId();
		}

		BufferedImage taskImg = itemManager.getImage(itemSpriteId);
		final String taskTooltip = ColorUtil.prependColorTag("%s</br>", new Color(255, 119, 0))
			+ ColorUtil.wrapWithColorTag("Pts:", Color.YELLOW)
			+ " %s</br>"
			+ ColorUtil.wrapWithColorTag("Streak:", Color.YELLOW)
			+ " %s";
		counter = new TaskCounter(taskImg, this, amount);
		counter.setTooltip(String.format(taskTooltip, capsString(taskName), points, streak));

		infoBoxManager.addInfoBox(counter);
	}

	private void removeCounter()
	{
		if (counter == null)
		{
			return;
		}

		infoBoxManager.removeInfoBox(counter);
		counter = null;
	}

	//Utils
	private String capsString(String str)
	{
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
