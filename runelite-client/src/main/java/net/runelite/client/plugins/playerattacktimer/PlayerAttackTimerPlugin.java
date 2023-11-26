package net.runelite.client.plugins.playerattacktimer;

import com.google.common.base.Splitter;
import com.google.inject.Provides;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.playerattacktimer.AttackTimerMap.ATTACK_TIMER_MAP;
import net.runelite.client.ui.overlay.OverlayManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@PluginDescriptor(
    name = "Player Attack Timer",
    enabledByDefault = false,
    description = "Display the tick delay for your current weapon.<br>Helps with lazy prayer flicking and flinching.",
    tags = {"player", "attack", "tick", "timer", "delay"}
)
public class PlayerAttackTimerPlugin extends Plugin
{

  private static Logger logger = LoggerFactory.getLogger(PlayerAttackTimerPlugin.class);
  private final Map<Integer, AnimationTickMapEntry> customAnimationTickMap = new HashMap<>();

  private static final Splitter NEWLINE_SPLITTER = Splitter
      .on("\n")
      .omitEmptyStrings()
      .trimResults();

  @Inject
  private Client client;

  @Inject
  PlayerAttackTimerConfig config;

  @Inject
  private OverlayManager overlayManager;

  @Inject
  private PlayerOverlay playerOverlay;

//  @Inject
//  private PrayerOverlay prayerOverlay;

  @Getter(AccessLevel.PACKAGE)
  private int ticksUntilNextAnimation;

  @Provides
  PlayerAttackTimerConfig getConfig(final ConfigManager configManager)
  {
    return configManager.getConfig(PlayerAttackTimerConfig.class);
  }

  @Override
  protected void startUp()
  {
    overlayManager.add(playerOverlay);
    parseCustomAnimationConfig(config.customAnimations());
  }

  @Override
  protected void shutDown()
  {
    overlayManager.remove(playerOverlay);

    customAnimationTickMap.clear();
  }

  @Subscribe
  private void onConfigChanged(final ConfigChanged event)
  {
    if (!event.getGroup().equals("playerattacktimer"))
    {
      return;
    }

    switch (event.getKey())
    {
      case "customAnimations":
        parseCustomAnimationConfig(config.customAnimations());
        break;
      default:
        break;
    }
  }

  @Subscribe
  private void onGameTick(final GameTick event)
  {
    if (ticksUntilNextAnimation > 0)
    {
      --ticksUntilNextAnimation;
    }

    //soundtest
//    if (ticksUntilNextAnimation == 1) {
//      SoundPlayer.playSound("/tick_sound.wav");
//    }

    final Player player = client.getLocalPlayer();

    if (ticksUntilNextAnimation > 0 || player == null)
    {
      return;
    }

    final int animationId = player.getAnimation();

    var entry = customAnimationTickMap.getOrDefault(animationId, ATTACK_TIMER_MAP.get(animationId));
    if (entry != null)
    {
      ticksUntilNextAnimation = entry.delay;
    }
  }

  private void parseCustomAnimationConfig(final String config)
  {
    ConfigParser.parse(config).ifPresent(map -> {

      customAnimationTickMap.clear();
      customAnimationTickMap.putAll(map);
      logger.debug("TEST123: {}", customAnimationTickMap);
    });
  }
}