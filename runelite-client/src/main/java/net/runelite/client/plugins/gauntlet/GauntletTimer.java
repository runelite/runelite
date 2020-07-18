/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package net.runelite.client.plugins.gauntlet;

import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

class GauntletTimer extends Overlay {

    private final Client client;

    private final GauntletPlugin plugin;
    private final GauntletConfig config;

    private final PanelComponent panelComponent = new PanelComponent();

    public enum RaidState {
        UNKNOWN, IN_RAID, IN_BOSS;
    }

    public long timeRaidStart = -1L;
    public long timeBossEnter = -1L;

    public RaidState currentState = RaidState.UNKNOWN;

    /**
     * Resets the timer.
     */
    public void resetStates() {
        timeRaidStart = -1L;
        timeBossEnter = -1L;

        currentState = RaidState.UNKNOWN;
    }

    /**
     * This is called when the player resets the plugin mid-raid. We do not want to confuse the timer.
     * <p>
     * TODO: Originally, this function will disable the timer if the plugin is started mid raid.
     * Unfortunately, VARBITS can't be checked unless you're on the client thread.
     * I've no idea how to access RL's task handler.
     * Good luck to you. If you restart plugin mid raid, oh well. Your timer's going to be inaccurate.
     */
    public void initStates() {
        timeRaidStart = -1L;
        timeBossEnter = -1L;

        if (GauntletUtils.inRaid(client)) {
            currentState = RaidState.IN_RAID;
            if (GauntletUtils.inBoss(client)) {
                currentState = RaidState.IN_BOSS;
            }
        } else
            currentState = RaidState.UNKNOWN;
    }

    /**
     * Converts the different between two epoch times into minutes:seconds format.
     *
     * @param epochA long
     * @param epochB long
     * @return String
     */
    private String calculateElapsedTime(long epochA, long epochB) {
        long max = Math.max(epochA, epochB);
        long min = Math.min(epochA, epochB);

        long elapsedEpoch = max - min;
        long seconds = elapsedEpoch / 1000L;

        long minutes = seconds / 60L;
        seconds = seconds % 60;

        if (seconds == 0) {
            return minutes + ":00";
        }

        if (seconds < 10) {
            return minutes + ":0" + seconds;
        }

        return minutes + ":" + seconds;
    }

    /**
     * Called when varbit changes. See if the the raid state has changed.
     */
    public void checkStates(boolean checkVarps) {
        final Player p = client.getLocalPlayer();

        if (p == null || !plugin.completeStartup)
            return;

        if (checkVarps) {
            if (currentState == RaidState.UNKNOWN) {
                if (GauntletUtils.inRaid(client) && p.getHealthRatio() != 0) { // Player has started a new raid.
                    if (!GauntletUtils.inBoss(client)) {
                        currentState = RaidState.IN_RAID;
                        timeRaidStart = System.currentTimeMillis();
                    } else {
                        currentState = RaidState.IN_RAID;
                        timeRaidStart = timeBossEnter = System.currentTimeMillis();
                    }
                }
            } else if (currentState == RaidState.IN_RAID) {
                if (GauntletUtils.inRaid(client)) {
                    if (GauntletUtils.inBoss(client)) {  // Player has begun the boss fight.
                        printPrepTime();
                        currentState = RaidState.IN_BOSS;
                        timeBossEnter = System.currentTimeMillis();
                    }
                } else { // Player has died or left the raid.
                    printPrepTime();
                    resetStates();
                }
            } else if (currentState == RaidState.IN_BOSS) {
                if (!GauntletUtils.inBoss(client) || !GauntletUtils.inRaid(client)) { // Player has killed the boss.
                    resetStates();
                }
            }
        } else {
            if (currentState == RaidState.IN_BOSS) {
                if (p.getHealthRatio() == 0) { // Boss has killed the player.
                    printBossTime();
                    resetStates();
                }
            }
        }
    }

    private void printPrepTime() {
        if (!config.displayTimerChat() || timeRaidStart == -1L)
            return;

        String elapsedTime = calculateElapsedTime(System.currentTimeMillis(), timeRaidStart);
        this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Preparation time: <col=ff0000>" + elapsedTime + "<col=000000>.", null);
    }

    private void printBossTime() {
        if (!config.displayTimerChat() || timeRaidStart == -1L || timeBossEnter == -1L)
            return;

        String elapsedBossTime = calculateElapsedTime(System.currentTimeMillis(), timeBossEnter);
        String elapsedPrepTime = calculateElapsedTime(timeRaidStart, timeBossEnter);
        String elapsedTotalTime = calculateElapsedTime(System.currentTimeMillis(), timeRaidStart);

        this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Challenge duration: <col=ff0000>" + elapsedTotalTime + "<col=000000>.", null);
        this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Preparation time: <col=ff0000>" + elapsedPrepTime + "<col=000000>. Player death time: <col=ff0000>" + elapsedBossTime + "<col=000000>.", null);
    }

    @Inject
    public GauntletTimer(Client client, GauntletPlugin plugin, GauntletConfig config) {
        super(plugin);

        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        setPriority(OverlayPriority.HIGH);

        this.client = client;
        this.plugin = plugin;
        this.config = config;

        getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Gauntlet Timer Overlay"));
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (currentState == RaidState.UNKNOWN) {
            return null;
        }

        panelComponent.getChildren().clear();

        panelComponent.getChildren().add(TitleComponent.builder().text("Gauntlet Timer").color(Color.WHITE).build());

        if (timeRaidStart == -1L) { // User restarted the plugin mid raid. Timer is inaccurate.
            panelComponent.getChildren().add(LineComponent.builder().left("Inactive").right("0:00").build());
        } else {
            String elapsedPrepTime, elapsedBossTime, elapsedTotalTime;
            elapsedTotalTime = calculateElapsedTime(System.currentTimeMillis(), timeRaidStart);

            if (currentState == RaidState.IN_RAID) {
                elapsedPrepTime = calculateElapsedTime(timeRaidStart, System.currentTimeMillis());
                elapsedBossTime = "0:00";
            } else {
                elapsedPrepTime = calculateElapsedTime(timeRaidStart, timeBossEnter);
                elapsedBossTime = calculateElapsedTime(System.currentTimeMillis(), timeBossEnter);
            }

            panelComponent.getChildren().add(LineComponent.builder().left("Preparation").right(elapsedPrepTime).build());
            panelComponent.getChildren().add(LineComponent.builder().left("Boss Fight").right(elapsedBossTime).build());
            panelComponent.getChildren().add(LineComponent.builder().left("Total Time").right(elapsedTotalTime).build());
        }

        return panelComponent.render(graphics);
    }
}
