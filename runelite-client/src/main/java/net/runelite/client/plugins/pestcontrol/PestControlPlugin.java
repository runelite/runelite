/*
 *  Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.pestcontrol;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.pestcontrol.config.NpcHighlightStyle;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Pest Control",
	description = "Show helpful information for the Pest Control minigame",
	tags = {"minigame", "overlay"}
)
public class PestControlPlugin extends Plugin
{
	private static final Set<Integer> SPLATTER_IDS = ImmutableSet.of(
		NpcID.SPLATTER,
		NpcID.SPLATTER_1690,
		NpcID.SPLATTER_1691,
		NpcID.SPLATTER_1692,
		NpcID.SPLATTER_1693
	);

	private static final Set<Integer> SHIFTER_IDS = ImmutableSet.of(
		NpcID.SHIFTER,
		NpcID.SHIFTER_1695,
		NpcID.SHIFTER_1696,
		NpcID.SHIFTER_1697,
		NpcID.SHIFTER_1698,
		NpcID.SHIFTER_1699,
		NpcID.SHIFTER_1700,
		NpcID.SHIFTER_1701,
		NpcID.SHIFTER_1702,
		NpcID.SHIFTER_1703
	);

	private static final Set<Integer> RAVAGER_IDS = ImmutableSet.of(
		NpcID.RAVAGER,
		NpcID.RAVAGER_1705,
		NpcID.RAVAGER_1706,
		NpcID.RAVAGER_1707,
		NpcID.RAVAGER_1708
	);

	private static final Set<Integer> SPINNER_IDS = ImmutableSet.of(
		NpcID.SPINNER,
		NpcID.SPINNER_1710,
		NpcID.SPINNER_1711,
		NpcID.SPINNER_1712,
		NpcID.SPINNER_1713
	);

	private static final Set<Integer> TORCHER_IDS = ImmutableSet.of(
		NpcID.TORCHER,
		NpcID.TORCHER_1715,
		NpcID.TORCHER_1716,
		NpcID.TORCHER_1717,
		NpcID.TORCHER_1718,
		NpcID.TORCHER_1719,
		NpcID.TORCHER_1720,
		NpcID.TORCHER_1721,
		NpcID.TORCHER_1722,
		NpcID.TORCHER_1723
	);

	private static final Set<Integer> DEFILER_IDS = ImmutableSet.of(
		NpcID.DEFILER,
		NpcID.DEFILER_1725,
		NpcID.DEFILER_1726,
		NpcID.DEFILER_1727,
		NpcID.DEFILER_1728,
		NpcID.DEFILER_1729,
		NpcID.DEFILER_1730,
		NpcID.DEFILER_1731,
		NpcID.DEFILER_1732,
		NpcID.DEFILER_1733
	);

	private static final Set<Integer> BRAWLER_IDS = ImmutableSet.of(
		NpcID.BRAWLER,
		NpcID.BRAWLER_1735,
		NpcID.BRAWLER_1736,
		NpcID.BRAWLER_1737,
		NpcID.BRAWLER_1738
	);

	private	static final Set<Integer> PORTAL_SHIELD_IDS = ImmutableSet.of(
		NpcID.PORTAL_1751,
		NpcID.PORTAL_1752,
		NpcID.PORTAL_1753,
		NpcID.PORTAL_1754
	);

	private	static final Set<Integer> PORTAL_ACTIVE_IDS = ImmutableSet.of(
		NpcID.PORTAL_1747,
		NpcID.PORTAL_1748,
		NpcID.PORTAL_1749,
		NpcID.PORTAL_1750
	);

	private	static final Set<Integer> PORTAL_PURPLE_IDS = ImmutableSet.of(
		NpcID.PORTAL_1747,
		NpcID.PORTAL_1751
	);

	private	static final Set<Integer> PORTAL_BLUE_IDS = ImmutableSet.of(
		NpcID.PORTAL_1748,
		NpcID.PORTAL_1752
	);

	private	static final Set<Integer> PORTAL_YELLOW_IDS = ImmutableSet.of(
		NpcID.PORTAL_1749,
		NpcID.PORTAL_1753
	);

	private	static final Set<Integer> PORTAL_RED_IDS = ImmutableSet.of(
		NpcID.PORTAL_1750,
		NpcID.PORTAL_1754
	);

	private	static final Set<Integer> INGAME_VOID_KNIGHT_IDS = ImmutableSet.of(
		NpcID.VOID_KNIGHT_2950,
		NpcID.VOID_KNIGHT_2951,
		NpcID.VOID_KNIGHT_2952,
		NpcID.VOID_KNIGHT_2953
	);

	// Combat 40+ (3 points)
	private final int NOVICE_BANNER = 25620;
	private final int NOVICE_GANGPLANK = 14315;

	// Combat 70+ (4 points)
	private final int INTERMEDIATE_BANNER = 25621;
	private final int INTERMEDIATE_GANGPLANK = 25631;

	// Combat 100+ (5 points)
	private final int VETERAN_BANNER = 25622;
	private final int VETERAN_GANGPLANK = 25632;

	private final Pattern SHIELD_DROP = Pattern.compile("The ([a-z]+), [^ ]+ portal shield has dropped!", Pattern.CASE_INSENSITIVE);

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Client client;

	@Inject
	private WidgetOverlay widgetOverlay;

	@Inject
	private NpcHighlightOverlay npcHighlightOverlay;

	@Inject
	private PortalOverlay portalOverlay;

	@Inject
	private PestControlConfig config;

	@Getter
	private Game game;

	@Getter(AccessLevel.PACKAGE)
	private HashMap<Integer, List<NPC>> aliveNpcList = new HashMap<Integer, List<NPC>>();

	@Getter(AccessLevel.PACKAGE)
	private HashMap<Integer, NpcHighlightContext> highlightedNpcList = new HashMap<Integer, NpcHighlightContext>();

	@Provides
	PestControlConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PestControlConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		loadPlugin();
	}

	@Override
	protected void shutDown() throws Exception
	{
		unloadPlugin();
	}

	private void loadPlugin()
	{
		if(config.spinnerHighlight() != NpcHighlightStyle.OFF){
			highlightedNpcList.put(NpcID.SPINNER, new NpcHighlightContext(
				config.spinnerHighlight(),
				config.spinnerColor(),
				true
			));
		}

		if(config.brawlerHighlight() != NpcHighlightStyle.OFF){
			highlightedNpcList.put(NpcID.BRAWLER, new NpcHighlightContext(
				config.brawlerHighlight(),
				config.brawlerColor(),
				false
			));
		}

		if(config.splatterHighlight() != NpcHighlightStyle.OFF){
			highlightedNpcList.put(NpcID.SPLATTER, new NpcHighlightContext(
				config.splatterHighlight(),
				config.splatterColor(),
				false
			));
		}

		if(config.shifterHighlight() != NpcHighlightStyle.OFF){
			highlightedNpcList.put(NpcID.SHIFTER, new NpcHighlightContext(
				config.shifterHighlight(),
				config.shifterColor(),
				false
			));
		}

		if(config.defilerHighlight() != NpcHighlightStyle.OFF){
			highlightedNpcList.put(NpcID.DEFILER, new NpcHighlightContext(
				config.defilerHighlight(),
				config.defilerColor(),
				false
			));
		}

		if(config.ravagerHighlight() != NpcHighlightStyle.OFF){
			highlightedNpcList.put(NpcID.RAVAGER, new NpcHighlightContext(
				config.ravagerHighlight(),
				config.ravagerColor(),
				false
			));
		}

		if(config.torcherHighlight() != NpcHighlightStyle.OFF){
			highlightedNpcList.put(NpcID.TORCHER, new NpcHighlightContext(
				config.torcherHighlight(),
				config.torcherColor(),
				false
			));
		}

		overlayManager.add(widgetOverlay);
		overlayManager.add(npcHighlightOverlay);
		overlayManager.add(portalOverlay);
	}

	private void unloadPlugin()
	{
		overlayManager.remove(widgetOverlay);
		overlayManager.remove(npcHighlightOverlay);
		overlayManager.remove(portalOverlay);

		highlightedNpcList.clear();

		if(game != null){
			if(config.showHintArrow() && client.hasHintArrow()){
				client.clearHintArrow();
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("pestcontrol"))
		{
			unloadPlugin();
			loadPlugin();
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		// See if we are in a game or not
		if (client.getWidget(WidgetInfo.PEST_CONTROL_BLUE_SHIELD) == null)
		{
			if (game != null)
			{
				log.debug("Pest control game has ended");
				game = null;
			}

			return;
		}

		if (game == null)
		{
			log.debug("Pest control game has started");
			game = new Game(client);
		}

		if(!game.isPortalLocationsSet())
		{
			game.loadPortalLocations();
		}

		game.updatePortalNpcs();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING && client.getWidget(WidgetInfo.PEST_CONTROL_BLUE_SHIELD) == null)
		{
			aliveNpcList.clear();
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (game != null && chatMessage.getType() == ChatMessageType.SERVER)
		{
			Matcher matcher = SHIELD_DROP.matcher(chatMessage.getMessage());
			if (matcher.lookingAt())
			{
				game.fall(matcher.group(1));
			}
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		final NPC npc = event.getNpc();
		final int npcId = npc.getId();
		int parentNpcId = getParentNpcId(npcId);

		if(parentNpcId == 0){
			return;
		}

		if(!highlightedNpcList.containsKey(parentNpcId))
		{
			return;
		}

		List npcList = aliveNpcList.get(parentNpcId);

		if(npcList == null){
			npcList = new ArrayList<NPC>();
			aliveNpcList.put(parentNpcId, npcList);
		}

		npcList.add(npc);
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if(game == null)
		{
			return;
		}

		final NPC npc = event.getNpc();
		final int npcId = npc.getId();

		NPC arrowNpc = client.getHintArrowNpc();

		// Handle portal NPCs
		if(npc == game.getBlue().getNpc())
		{
			game.getBlue().setNpc(null);
			game.updatePortalNpcs();
			if(arrowNpc != null && arrowNpc == npc)
			{
				client.setHintArrow(game.getBlue().getLocation());
			}
			return;
		}
		if(npc == game.getRed().getNpc())
		{
			game.getRed().setNpc(null);
			game.updatePortalNpcs();
			if(arrowNpc != null && arrowNpc == npc)
			{
				client.setHintArrow(game.getRed().getLocation());
			}
			return;
		}
		if(npc == game.getYellow().getNpc())
		{
			game.getYellow().setNpc(null);
			game.updatePortalNpcs();
			if(arrowNpc != null && arrowNpc == npc)
			{
				client.setHintArrow(game.getYellow().getLocation());
			}
			return;
		}
		if(npc == game.getPurple().getNpc())
		{
			game.getPurple().setNpc(null);
			game.updatePortalNpcs();
			if(arrowNpc != null && arrowNpc == npc)
			{
				client.setHintArrow(game.getPurple().getLocation());
			}
			return;
		}

		// Handle normal npc's
		int parentNpcId = getParentNpcId(npcId);
		if(parentNpcId == 0){
			return;
		}

		if(!aliveNpcList.containsKey(parentNpcId)){
			return;
		}

		List npcList = aliveNpcList.get(parentNpcId);

		if(npcList != null){
			npcList.remove(npc);
		}
	}

	private int getParentNpcId(int npcID){
		if (SHIFTER_IDS.contains(npcID)){
			return NpcID.SHIFTER;
		}
		if (RAVAGER_IDS.contains(npcID)){
			return NpcID.RAVAGER;
		}
		if (SPINNER_IDS.contains(npcID)){
			return NpcID.SPINNER;
		}
		if (SPLATTER_IDS.contains(npcID)){
			return NpcID.SPLATTER;
		}
		if (TORCHER_IDS.contains(npcID)){
			return NpcID.TORCHER;
		}
		if (DEFILER_IDS.contains(npcID)){
			return NpcID.DEFILER;
		}
		if (BRAWLER_IDS.contains(npcID)){
			return NpcID.BRAWLER;
		}

		return 0;
	}

	public static boolean isBrawler(int npcId)
	{
		return BRAWLER_IDS.contains(npcId);
	}

	public static boolean isIngameVoidKnight(int npcId)
	{
		return INGAME_VOID_KNIGHT_IDS.contains(npcId);
	}

	public static boolean isActivePortal(int npcId)
	{
		return PORTAL_ACTIVE_IDS.contains(npcId);
	}

	public static boolean isShieldedPortal(int npcId)
	{
		return PORTAL_SHIELD_IDS.contains(npcId);
	}

	public static boolean isPortal(int npcId) {
		return (isActivePortal(npcId) || isShieldedPortal(npcId));
	}

	public static boolean isPurplePortal(int npcId)
	{
		return PORTAL_PURPLE_IDS.contains(npcId);
	}

	public static boolean isBluePortal(int npcId)
	{
		return PORTAL_BLUE_IDS.contains(npcId);
	}

	public static boolean isYellowPortal(int npcId)
	{
		return PORTAL_YELLOW_IDS.contains(npcId);
	}

	public static boolean isRedPortal(int npcId)
	{
		return PORTAL_RED_IDS.contains(npcId);
	}
}
