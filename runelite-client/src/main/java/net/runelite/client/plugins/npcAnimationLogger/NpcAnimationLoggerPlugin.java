package net.runelite.client.plugins.npcAnimationLogger;

import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.WorldView;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Slf4j
@PluginDescriptor(
    name = "NPC Animation Logger",
    description = "Logs NPC animations when they interact with the player",
    tags = {"NPC", "animation", "logger"},
    enabledByDefault = false
)
public class NpcAnimationLoggerPlugin extends Plugin {

  private static final String LOG_FILE_NAME = "NPCAnimationIDs.log";

  @Inject
  private Client client;

  @Inject
  private WorldView worldView;

  @Inject
  private NpcAnimationLoggerConfig config;

  private final Map<Integer, Integer> npcPreviousAnimations = new HashMap<>();
  private int tickCount = 0;
  private FileHandler fileHandler;
  private boolean isPluginEnabled = false;

  @Provides
  NpcAnimationLoggerConfig provideConfig(ConfigManager configManager) {
    return configManager.getConfig(NpcAnimationLoggerConfig.class);
  }

  @Override
  protected void startUp() throws Exception {
    isPluginEnabled = true;
    tickCount = 0;
    setupFileLogger();
    log.info("NPC Animation Logger started!");
  }

  @Override
  protected void shutDown() throws Exception {
    isPluginEnabled = false;
    npcPreviousAnimations.clear();
    tickCount = 0;
    closeFileHandler();
    log.info("NPC Animation Logger stopped!");
  }

  @Subscribe
  public void onGameTick(GameTick event) {
    if (!isPluginEnabled) return;

    tickCount++;
    for (NPC npc : worldView.npcs()) {
      if (shouldSkipNpc(npc)) {
        continue;
      }
      logNpcAnimationIfChanged(npc);
    }
  }

  private void setupFileLogger() {
    try {
      fileHandler = new FileHandler(LOG_FILE_NAME, false);
      fileHandler.setFormatter(new SimpleFormatter());
      Logger.getLogger("").addHandler(fileHandler);
    } catch (IOException e) {
      log.error("Failed to set up file logger", e);
    }
  }

  private void closeFileHandler() {
    if (fileHandler != null) {
      fileHandler.close();
    }
  }

  private boolean shouldSkipNpc(NPC npc) {
    return config.logTargetingOnly() && npc.getInteracting() != client.getLocalPlayer();
  }

  private void logNpcAnimationIfChanged(NPC npc) {
    int currentAnimation = npc.getAnimation();
    int npcId = npc.getIndex();

    if (npcPreviousAnimations.getOrDefault(npcId, -1) != currentAnimation) {
      logNpcAnimation(npc, currentAnimation);
      npcPreviousAnimations.put(npcId, currentAnimation);
    }
  }

  private void logNpcAnimation(NPC npc, int currentAnimation) {
    String logMessage = formatLogMessage(npc, currentAnimation);
    log.info(logMessage);
  }

  private String formatLogMessage(NPC npc, int currentAnimation) {
    return String.format("Tick: %d | NPC: %s | Animation ID: %d | Targeting: %s",
        tickCount,
        npc.getName(),
        currentAnimation,
        (npc.getInteracting() == client.getLocalPlayer() ? "You" : "Other"));
  }
}