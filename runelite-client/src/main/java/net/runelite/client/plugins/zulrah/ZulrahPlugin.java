package net.runelite.client.plugins.zulrah;

import com.google.common.base.Preconditions;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.*;
import net.runelite.api.vars.InterfaceTab;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.externals.utils.ExtUtils;
import net.runelite.client.plugins.zulrah.constants.ZulrahType;
import net.runelite.client.plugins.zulrah.overlays.*;
import net.runelite.client.plugins.zulrah.rotationutils.RotationType;
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahData;
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahPhase;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@PluginDescriptor(
		name = "Zulrah",
		description = "All-in-One tool to help during the Zulrah fight",
		tags = {"zulrah", "zul", "andra", "snakeling", "zhuri/nicole", "girls rule boys drool"},
		enabledByDefault = false
)
@PluginDependency(ExtUtils.class)
public class ZulrahPlugin extends Plugin
{
	private static final Logger log = LoggerFactory.getLogger(ZulrahPlugin.class);
	@Inject
	private Client client;
	@Inject
	private KeyManager keyManager;
	@Inject
	private InfoBoxManager infoBoxManager;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private InstanceTimerOverlay instanceTimerOverlay;
	@Inject
	private PhaseOverlay phaseOverlay;
	private ZulrahType zulrahType;
	@Inject
	private PrayerHelperOverlay prayerHelperOverlay;
	@Inject
	private PrayerMarkerOverlay prayerMarkerOverlay;
	@Inject
	private SceneOverlay sceneOverlay;
	@Inject
	private ZulrahConfig config;
	private NPC zulrahNpc = null;
	private int stage = 0;
	private int phaseTicks = -1;
	private int attackTicks = -1;
	private int totalTicks = 0;
	private RotationType currentRotation = null;
	private List<RotationType> potentialRotations = new ArrayList<RotationType>();
	private final Map<LocalPoint, Integer> projectilesMap = new HashMap<LocalPoint, Integer>();
	private final Map<GameObject, Integer> toxicCloudsMap = new HashMap<GameObject, Integer>();
	private static boolean flipStandLocation = false;
	private static boolean flipPhasePrayer = false;
	private static boolean zulrahReset = false;
	private final Collection<NPC> snakelings = new ArrayList<NPC>();
	private boolean holdingSnakelingHotkey = false;
	private Counter zulrahTotalTicksInfoBox;
	public static final BufferedImage[] ZULRAH_IMAGES = new BufferedImage[3];
	private static final BufferedImage CLOCK_ICON = ImageUtil.loadImageResource(ZulrahPlugin.class, "clock.png");
	private final BiConsumer<RotationType, RotationType> phaseTicksHandler = (current, potential) -> {
		if (zulrahReset) 
	{
			phaseTicks = 38;
		}
		else
		{
			ZulrahPhase p = current != null ? getCurrentPhase((RotationType)((Object)current)) : getCurrentPhase((RotationType)((Object)potential));
			Preconditions.checkNotNull(p, "Attempted to set phase ticks but current Zulrah phase was somehow null. Stage: " + stage);
			phaseTicks = p.getAttributes().getPhaseTicks();
		}
	};


	/*Automated prayer part WaRp*/
	@Inject
	private ExtUtils utils;
	private ExecutorService executor;
	private Robot robot;
	int start = 0;
	int stop = 0;
	/*Automated prayer part End*/


	@Provides
	ZulrahConfig provideConfig(ConfigManager configManager) 
	{
		return configManager.getConfig(ZulrahConfig.class);
	}

	protected void startUp() throws AWTException {
		executor = Executors.newSingleThreadExecutor();
		robot = new Robot();
		overlayManager.add(instanceTimerOverlay);
		overlayManager.add(phaseOverlay);
		overlayManager.add(prayerHelperOverlay);
		overlayManager.add(prayerMarkerOverlay);
		overlayManager.add(sceneOverlay);
		keyManager.registerKeyListener((KeyListener) this);
	}

	protected void shutDown() 
	{
		executor.shutdown();
		robot = null;
		reset();
		overlayManager.remove(instanceTimerOverlay);
		overlayManager.remove(phaseOverlay);
		overlayManager.remove(prayerHelperOverlay);
		overlayManager.remove(prayerMarkerOverlay);
		overlayManager.remove(sceneOverlay);
		keyManager.unregisterKeyListener((KeyListener) this);
	}

	private void reset() 
	{
		zulrahNpc = null;
		stage = 0;
		phaseTicks = -1;
		attackTicks = -1;
		totalTicks = 0;
		currentRotation = null;
		potentialRotations.clear();
		projectilesMap.clear();
		toxicCloudsMap.clear();
		flipStandLocation = false;
		flipPhasePrayer = false;
		instanceTimerOverlay.resetTimer();
		zulrahReset = false;
		clearSnakelingCollection();
		holdingSnakelingHotkey = false;
		handleTotalTicksInfoBox(true);
		log.debug("Zulrah Reset!");
	}


	public void keyPressed(KeyEvent e) 
	{
		if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES && config.snakelingMesHotkey().matches(e)) 
	{
			holdingSnakelingHotkey = true;
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES && config.snakelingMesHotkey().matches(e)) 
	{
			holdingSnakelingHotkey = false;
		}
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event) 
	{
		if (event.getGroup().equalsIgnoreCase("znzulrah")) 
	{
			switch (event.getKey()) 
	{
				case "snakelingSetting":
				{
					if (config.snakelingSetting() != ZulrahConfig.SnakelingSettings.ENTITY) 
	{
						clearSnakelingCollection();
					}
					if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES) break;
					holdingSnakelingHotkey = false;
					break;
				}
				case "totalTickCounter":
				{
					if (config.totalTickCounter()) break;
					handleTotalTicksInfoBox(true);
				}
			}
		}
	}

	private void clearSnakelingCollection() 
	{
		snakelings.forEach(npc -> ZulrahPlugin.setHidden(npc, false));
		snakelings.clear();
	}

	@Subscribe
	private void onClientTick(ClientTick event) 
	{
		if (client.getGameState() != GameState.LOGGED_IN || zulrahNpc == null) 
	{
			return;
		}
		if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.ENTITY) 
	{
			snakelings.addAll(client.getNpcs().stream().filter(npc -> npc != null && npc.getName() != null && npc.getName().equalsIgnoreCase("snakeling") && npc.getCombatLevel() == 90).collect(Collectors.toList()));
			snakelings.forEach(npc -> ZulrahPlugin.setHidden(npc, true));
		}
	}

	@Subscribe
	private void onGameTick(GameTick event) 
	{
		if (client.getGameState() != GameState.LOGGED_IN || zulrahNpc == null) 
		{
			return;
		}
		++totalTicks;
		if (attackTicks >= 0) 
	{
			--attackTicks;
		}
		if (phaseTicks >= 0) 
	{
			--phaseTicks;
		}
		if (projectilesMap.size() > 0) 
	{
			projectilesMap.values().removeIf(v -> v <= 0);
			projectilesMap.replaceAll((k, v) -> v - 1);
		}
		if (toxicCloudsMap.size() > 0) 
	{
			toxicCloudsMap.values().removeIf(v -> v <= 0);
			toxicCloudsMap.replaceAll((k, v) -> v - 1);
		}
		handleTotalTicksInfoBox(false);
	}

	@Subscribe
	private void onAnimationChanged(AnimationChanged event) 
	{
		if (!(event.getActor() instanceof NPC)) 
	{
			return;
		}
		NPC npc = (NPC)((Object)event.getActor());
		if (npc.getName() != null && !npc.getName().equalsIgnoreCase("zulrah")) 
		{
			return;
		}
		switch (npc.getAnimation()) 
	{
			case 5071:
			{
				zulrahNpc = npc;
				instanceTimerOverlay.setTimer();
				potentialRotations = RotationType.findPotentialRotations(npc, stage);
				phaseTicksHandler.accept(currentRotation, potentialRotations.get(0));
				log.debug("New Zulrah Encounter Started");
				break;
			}
			case 5073:
			{
				++stage;
				if (currentRotation == null) 
	{
					potentialRotations = RotationType.findPotentialRotations(npc, stage);
					currentRotation = potentialRotations.size() == 1 ? potentialRotations.get(0) : null;
				}
				phaseTicksHandler.accept(currentRotation, potentialRotations.get(0));
				break;
			}
			case 5072:
			{
				if (zulrahReset) 
	{
					zulrahReset = false;
				}
				if (currentRotation == null || !isLastPhase(currentRotation)) break;
				stage = -1;
				currentRotation = null;
				potentialRotations.clear();
				snakelings.clear();
				flipStandLocation = false;
				flipPhasePrayer = false;
				zulrahReset = true;
				log.debug("Resetting Zulrah");
				break;
			}
			case 5069:
			{
				attackTicks = 4;
				if (currentRotation == null || !getCurrentPhase(currentRotation).getZulrahNpc().isJad()) break;
				flipPhasePrayer = !flipPhasePrayer;
				break;
			}
			case 5806:
			case 5807:
			{
				attackTicks = 8;
				flipStandLocation = !flipStandLocation;
				break;
			}
			case 5804:
			{
				reset();
			}
		}
	}

	@Subscribe
	private void onFocusChanged(FocusChanged event) 
	{
		if (!event.isFocused()) 
	{
			holdingSnakelingHotkey = false;
		}
	}

	@Subscribe
	private void onMenuEntryAdded(MenuEntryAdded event) 
	{
		if (config.snakelingSetting() != ZulrahConfig.SnakelingSettings.MES || zulrahNpc == null || zulrahNpc.isDead()) 
	{
			return;
		}
		if (!holdingSnakelingHotkey && event.getTarget().contains("Snakeling") && event.getOption().equalsIgnoreCase("attack")) 
	{
			NPC npc = client.getCachedNPCs()[event.getIdentifier()];
			if (npc == null) 
	{
				return;
			}
			client.setMenuEntries(Arrays.copyOf(client.getMenuEntries(), client.getMenuEntries().length - 1));
		}
	}

	/*Automated Zulrah part thanks Ganom <3 stole it from you*/
	private boolean isUsed = false;
	private void clickPrayer(Prayer prayer)
	{
		if (client.isPrayerActive(prayer) || client.getBoostedSkillLevel(Skill.PRAYER) < 1 && isUsed)
		{
			return;
		}
		isUsed = true;
		final Widget widget = client.getWidget(prayer.getWidgetInfo());

		if (widget == null)
		{
			return;
		}

		final Rectangle bounds = widget.getBounds();
		if(client.getVarbitValue(VarClientInt.INVENTORY_TAB) != InterfaceTab.PRAYER.getId())
		{
		log.debug("[Thread] Starting prayer Toggle");
		robot.keyPress(KeyEvent.VK_F2);
		}
		executor.submit(() ->
		{
			log.debug("[Thread] Starting prayer Thread");
			try
			{
				Thread.sleep(1400);
			}
			catch (InterruptedException e)
			{
				log.debug("[Thread] Error on sleep: " + e);
				return;
			}
			log.debug("[Thread] Clicking prayer");
			utils.click(bounds);

			try
			{
				Thread.sleep(getMillis());
				isUsed = false;
				}
				catch (InterruptedException e) {
				log.debug("[Thread] Error on sleep: " + e);
				return;
				}
		});
	}
	public int getMillis()
	{
		return (int) (Math.random() * 1212 + 2421);
	}

	private void beforeClickPrayer(Projectile p)
	{

		if (p.getStartCycle() == start && p.getEndCycle() == p.getEndCycle())
		{
			log.debug("Not our missile or same one..");
			return;
		}
		if (p.getId() == ProjectileID.ZULRAH_MAGE)
		{
			clickPrayer(Prayer.PROTECT_FROM_MAGIC);
		}

		if (p.getId() == ProjectileID.ZULRAH_RANGE)
		{
			clickPrayer(Prayer.PROTECT_FROM_MISSILES);
		}
		start = p.getStartCycle();
		stop = p.getEndCycle();

	}

	@Subscribe
	private void onProjectileMoved(ProjectileMoved event) 
	{
		if (zulrahNpc == null) 
	{
			return;
		}
		Projectile p = event.getProjectile();

		switch (p.getId()) 
	{
			case 1045:
			case 1047:
			{
				projectilesMap.put(event.getPosition(), p.getRemainingCycles() / 30);
			}
			break;
		case ProjectileID.ZULRAH_RANGE:

			if (!client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES))
			{
				beforeClickPrayer(p);
			}
			break;
		case ProjectileID.ZULRAH_MAGE:

			if (!client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC))
			{
				beforeClickPrayer(p);
			}
			break;
	}
	}

	@Subscribe
	private void onGameObjectSpawned(GameObjectSpawned event) 
	{
		if (zulrahNpc == null) 
	{
			return;
		}
		GameObject obj = event.getGameObject();
		if (obj.getId() == 1044) log.debug("range");
		if (obj.getId() == 1046) log.debug("mage");
		if (obj.getId() == 11700) 
		{
			toxicCloudsMap.put(obj, 30);
		}
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged event) 
	{
		if (zulrahNpc == null) 
	{
			return;
		}
		switch (event.getGameState()) 
	{
			case LOADING:
			case CONNECTION_LOST:
			case HOPPING:
			{
				reset();
			}
		}
	}

	@Nullable
	private ZulrahPhase getCurrentPhase(RotationType type) 
	{
		return stage >= type.getZulrahPhases().size() ? null : type.getZulrahPhases().get(stage);
	}

	@Nullable
	private ZulrahPhase getNextPhase(RotationType type) 
	{
		return isLastPhase(type) ? null : type.getZulrahPhases().get(stage + 1);
	}

	private boolean isLastPhase(RotationType type) 
	{
		return stage == type.getZulrahPhases().size() - 1;
	}

	public Set<ZulrahData> getZulrahData() 
	{
		LinkedHashSet<ZulrahData> zulrahDataSet = new LinkedHashSet<ZulrahData>();
		if (currentRotation == null) 
	{
			potentialRotations.forEach(type -> zulrahDataSet.add(new ZulrahData(getCurrentPhase((RotationType)((Object)type)), getNextPhase((RotationType)((Object)type)))));
		}
		else
		{
			zulrahDataSet.add(new ZulrahData(getCurrentPhase(currentRotation), getNextPhase(currentRotation)));
		}
		return zulrahDataSet.size() > 0 ? zulrahDataSet : Collections.emptySet();
	}

	private void handleTotalTicksInfoBox(boolean remove) 
	{
		if (remove) 
	{
			infoBoxManager.removeInfoBox(zulrahTotalTicksInfoBox);
			zulrahTotalTicksInfoBox = null;
		}
		else if (config.totalTickCounter())
	{
			if (zulrahTotalTicksInfoBox == null) 
	{
				zulrahTotalTicksInfoBox = new Counter(CLOCK_ICON, this, totalTicks);
				zulrahTotalTicksInfoBox.setTooltip("Total Ticks Alive");
				infoBoxManager.addInfoBox(zulrahTotalTicksInfoBox);
			}
			else
			{
				zulrahTotalTicksInfoBox.setCount(totalTicks);
			}
		}
	}

	private static void setHidden(Renderable renderable, boolean hidden) 
	{
		Method setHidden = null;
		try
		{
			setHidden = renderable.getClass().getMethod("setHidden", Boolean.TYPE);
		}
		catch (NoSuchMethodException e) 
	{
			log.debug("Couldn't find method setHidden for class {}", renderable.getClass());
			return;
		}
		try
		{
			setHidden.invoke(renderable, hidden);
		}
		catch (IllegalAccessException | InvocationTargetException e) 
	{
			log.debug("Couldn't call method setHidden for class {}", renderable.getClass());
		}
	}

	public NPC getZulrahNpc() 
	{
		return zulrahNpc;
	}

	public int getPhaseTicks() 
	{
		return phaseTicks;
	}

	public int getAttackTicks() 
	{
		return attackTicks;
	}

	public RotationType getCurrentRotation() 
	{
		return currentRotation;
	}

	public Map<LocalPoint, Integer> getProjectilesMap() 
	{
		return projectilesMap;
	}

	public Map<GameObject, Integer> getToxicCloudsMap() 
	{
		return toxicCloudsMap;
	}

	public static boolean isFlipStandLocation() 
	{
		return flipStandLocation;
	}

	public static boolean isFlipPhasePrayer() 
	{
		return flipPhasePrayer;
	}

	public static boolean isZulrahReset() 
	{
		return zulrahReset;
	}

	static
	{
		ZulrahPlugin.ZULRAH_IMAGES[0] = ImageUtil.loadImageResource(ZulrahPlugin.class, "zulrah_range.png");
		ZulrahPlugin.ZULRAH_IMAGES[1] = ImageUtil.loadImageResource(ZulrahPlugin.class, "zulrah_melee.png");
		ZulrahPlugin.ZULRAH_IMAGES[2] = ImageUtil.loadImageResource(ZulrahPlugin.class, "zulrah_magic.png");
	}
}
