package net.runelite.client.plugins.fightcave;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.NPCManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

@Slf4j
@PluginDescriptor(
		name = "Fight Cave",
		enabledByDefault = false,
		description = "Displays current and upcoming wave monsters in the Fight Caves and what to pray at TzTok-Jad",
		tags = {"bosses", "combat", "minigame", "overlay", "pve", "pvm", "jad", "fire", "cape", "wave","willem","fun"}
)
public class FightCavePlugin extends Plugin
{
	static final int MAX_WAVE = 63;
	@Getter(AccessLevel.PACKAGE)
	static final List<EnumMap<WaveMonster, Integer>> WAVES = new ArrayList<>();
	private static final Pattern WAVE_PATTERN = Pattern.compile(".*Wave: (\\d+).*");
	private static final int FIGHT_CAVE_REGION = 9551;
	private static final int MAX_MONSTERS_OF_TYPE_PER_WAVE = 2;
	public static final int TZTOK_JAD_RANGE_ATTACK = 2652;
	public static final int TZTOK_JAD_MELEE_ATTACK = 2655;
	public static final int TZTOK_JAD_MAGIC_ATTACK = 2656;
	public static final int TOK_XIL_RANGE_ATTACK = 2633;
	public static final int TOK_XIL_MELEE_ATTACK = 2628;
	public static final int KET_ZEK_MELEE_ATTACK = 2644;
	public static final int KET_ZEK_MAGE_ATTACK = 2647;
	public static final int MEJ_KOT_MELEE_ATTACK = 2637;
	public static final int MEJ_KOT_HEAL_ATTACK = 2639;

	static
	{
		final WaveMonster[] waveMonsters = WaveMonster.values();

		// Add wave 1, future waves are derived from its contents
		final EnumMap<WaveMonster, Integer> waveOne = new EnumMap<>(WaveMonster.class);
		waveOne.put(waveMonsters[0], 1);
		WAVES.add(waveOne);

		for (int wave = 1; wave < MAX_WAVE; wave++)
		{
			final EnumMap<WaveMonster, Integer> prevWave = WAVES.get(wave - 1).clone();
			int maxMonsterOrdinal = -1;

			for (int i = 0; i < waveMonsters.length; i++)
			{
				final int ordinalMonsterQuantity = prevWave.getOrDefault(waveMonsters[i], 0);

				if (ordinalMonsterQuantity == MAX_MONSTERS_OF_TYPE_PER_WAVE)
				{
					maxMonsterOrdinal = i;
					break;
				}
			}

			if (maxMonsterOrdinal >= 0)
			{
				prevWave.remove(waveMonsters[maxMonsterOrdinal]);
			}

			final int addedMonsterOrdinal = maxMonsterOrdinal >= 0 ? maxMonsterOrdinal + 1 : 0;
			final WaveMonster addedMonster = waveMonsters[addedMonsterOrdinal];
			final int addedMonsterQuantity = prevWave.getOrDefault(addedMonster, 0);

			prevWave.put(addedMonster, addedMonsterQuantity + 1);

			WAVES.add(prevWave);
		}
	}

	@Inject
	private Client client;

	@Inject
	private NPCManager npcManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private WaveOverlay waveOverlay;

	@Inject
	private FightCaveOverlay fightCaveOverlay;

	@Getter(AccessLevel.PACKAGE)
	private Set<FightCaveContainer> fightCaveContainer = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private int currentWave = -1;
	@Getter(AccessLevel.PACKAGE)
	private boolean validRegion;
	@Getter(AccessLevel.PACKAGE)
	private List<Integer> mageTicks = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private List<Integer> rangedTicks = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private List<Integer> meleeTicks = new ArrayList<>();

	static String formatMonsterQuantity(final WaveMonster monster, final int quantity)
	{
		return String.format("%dx %s", quantity, monster);
	}

	@Provides
	FightCaveConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FightCaveConfig.class);
	}

	@Override
	public void startUp()
	{
		if (client.getGameState() == GameState.LOGGED_IN && regionCheck())
		{
			validRegion = true;
			overlayManager.add(waveOverlay);
			overlayManager.add(fightCaveOverlay);
		}
	}

	@Override
	public void shutDown()
	{
		overlayManager.remove(waveOverlay);
		overlayManager.remove(fightCaveOverlay);
		currentWave = -1;
	}

	@Subscribe
	private void onChatMessage(ChatMessage event)
	{
		if (!validRegion)
		{
			return;
		}

		final Matcher waveMatcher = WAVE_PATTERN.matcher(event.getMessage());

		if (event.getType() != ChatMessageType.GAMEMESSAGE || !waveMatcher.matches())
		{
			return;
		}

		currentWave = Integer.parseInt(waveMatcher.group(1));
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (regionCheck())
		{
			validRegion = true;
			overlayManager.add(waveOverlay);
			overlayManager.add(fightCaveOverlay);
		}
		else
		{
			validRegion = false;
			overlayManager.remove(fightCaveOverlay);
			overlayManager.remove(fightCaveOverlay);
		}

		fightCaveContainer.clear();
	}

	@Subscribe
	private void onNpcSpawned(NpcSpawned event)
	{
		if (!validRegion)
		{
			return;
		}

		NPC npc = event.getNpc();

		switch (npc.getId())
		{
			case NpcID.TZTOKJAD:
			case NpcID.TZTOKJAD_6506:
			case NpcID.TZKIH:
			case NpcID.TZKIH_2190:
			case NpcID.TZKIH_3116:
			case NpcID.TZKIH_3117:
			case NpcID.TZKEK:
			case NpcID.TZKEK_2192:
			case NpcID.TZKEK_3118:
			case NpcID.TZKEK_3119:
			case NpcID.TZKEK_3120:
			case NpcID.YTHURKOT:
			case NpcID.YTHURKOT_7701:
			case NpcID.YTHURKOT_7705:
			case NpcID.TOKXIL_3121:
			case NpcID.TOKXIL_3122:
			case NpcID.YTMEJKOT:
			case NpcID.YTMEJKOT_3124:
			case NpcID.KETZEK:
			case NpcID.KETZEK_3126: //Orange one
				fightCaveContainer.add(new FightCaveContainer(npc));
				break;
		}
	}

	@Subscribe
	private void onNpcDespawned(NpcDespawned event)
	{
		if (!validRegion)
		{
			return;
		}

		NPC npc = event.getNpc();

		switch (npc.getId())
		{
			case NpcID.TOKXIL_3121:
			case NpcID.TOKXIL_3122:
			case NpcID.YTMEJKOT:
			case NpcID.YTMEJKOT_3124:
			case NpcID.KETZEK:
			case NpcID.KETZEK_3126:
			case NpcID.TZTOKJAD:
			case NpcID.TZTOKJAD_6506:
				fightCaveContainer.removeIf(c -> c.getNpc() == npc);
				break;
		}
	}

	@Subscribe
	private void onGameTick(GameTick Event)
	{
		if (!validRegion)
		{
			return;
		}

		mageTicks.clear();
		rangedTicks.clear();
		meleeTicks.clear();

		for (FightCaveContainer npc : fightCaveContainer)
		{
			if (npc.getTicksUntilAttack() >= 0)
			{
				npc.setTicksUntilAttack(npc.getTicksUntilAttack() - 1);
			}

			for (int anims : npc.getAnimations())
			{
				if (anims == npc.getNpc().getAnimation())
				{
					if (npc.getTicksUntilAttack() < 1)
					{
						npc.setTicksUntilAttack(npc.getAttackSpeed());
					}

					switch (anims)
					{
						case TZTOK_JAD_RANGE_ATTACK:
							npc.setAttackStyle(FightCaveContainer.AttackStyle.RANGE);
							break;
						case TZTOK_JAD_MAGIC_ATTACK:
							npc.setAttackStyle(FightCaveContainer.AttackStyle.MAGE);
							break;
						case TZTOK_JAD_MELEE_ATTACK:
							npc.setAttackStyle(FightCaveContainer.AttackStyle.MELEE);
							break;
					}
				}
			}

			if (npc.getNpcName().equals("TzTok-Jad"))
			{
				continue;
			}

			switch (npc.getAttackStyle())
			{
				case RANGE:
					if (npc.getTicksUntilAttack() > 0)
					{
						rangedTicks.add(npc.getTicksUntilAttack());
					}
					break;
				case MELEE:
					if (npc.getTicksUntilAttack() > 0)
					{
						meleeTicks.add(npc.getTicksUntilAttack());
					}
					break;
				case MAGE:
					if (npc.getTicksUntilAttack() > 0)
					{
						mageTicks.add(npc.getTicksUntilAttack());
					}
					break;
			}
		}

		Collections.sort(mageTicks);
		Collections.sort(rangedTicks);
		Collections.sort(meleeTicks);
	}

	private boolean regionCheck()
	{
		return ArrayUtils.contains(client.getMapRegions(), FIGHT_CAVE_REGION);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("fightcave"))
		{
			return;
		}

		if (event.getKey().equals("mirrorMode"))
		{
			overlayManager.remove(waveOverlay);
			overlayManager.remove(fightCaveOverlay);
			overlayManager.add(waveOverlay);
			overlayManager.add(fightCaveOverlay);

		}
	}
}