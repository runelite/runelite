package net.runelite.client.plugins.easy.pvp;

import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import java.util.HashSet;
import java.util.Set;

@PluginDescriptor(
        name = "EasyPvP",
        description = "EasyPvP.",
        tags = {"EasyPVP", "easy"}
)

@Slf4j
public class EasyPvpPlugin extends Plugin {

    private int inWildy;

    @Inject
    private Client client;

    @Inject
    private EasyPvpConfig config;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private EasyPvpOverlay overlay;

    @Getter(AccessLevel.PACKAGE)
    private Set<Player> targets = new HashSet<>();

    private String target;
    private boolean prayMage;
    private WorldPoint location;
    private String spell;
    private int currentExperience;
    private int gainedExperience;

    @Provides
    EasyPvpConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(EasyPvpConfig.class);
    }

    @Override
    public void startUp() {
        prayMage = false;
        spell = "";
        overlayManager.add(overlay);
        log.debug("EasyPvP Started.");
    }

    @Override
    public void shutDown() {
        overlayManager.remove(overlay);
        log.debug("EasyPvP Stopped.");
    }

    @Subscribe
    public void onGameTick(GameTick event) {

        inWildy = client.getVar(Varbits.IN_WILDERNESS);

        if (inWildy == 0) {
            targets.clear();
            return;
        }

        Widget wildyText = client.getWidget(WidgetInfo.PVP_WILDERNESS_LEVEL);

        if (wildyText == null) {
            return;
        }

        int wildyLevel = Integer.parseInt(wildyText.getText().split(":")[1].trim());


        if (config.getShowAttackablePlayers()) {
            for (Player player : client.getPlayers()) {
                if (Math.abs(player.getCombatLevel() - client.getLocalPlayer().getCombatLevel()) <= wildyLevel) { // && !player.equals(client.getLocalPlayer())
                    targets.add(player);
                } else targets.remove(player);
            }
        }
    }

//    @Subscribe
//    public void onGameStateChanged(GameStateChanged event) {
//        if (event.getGameState() == GameState.LOGGED_IN) {
//            currentExperience = client.getSkillExperience(Skill.MAGIC);
//        }
//    }
//
//    @Subscribe
//    public void onMenuOptionClicked(MenuOptionClicked event) {
//        if (event.getMenuTarget().contains("->")) {
//            target = Text.removeTags(event.getMenuTarget()).split(" -> ")[1];
//            spell = Text.removeTags(event.getMenuTarget()).split(" -> ")[0];
//            log.debug("{} - {}", spell, target);
//            prayMage = false;
//        }
//    }
//
//    @Subscribe
//    public void onExperienceChanged(ExperienceChanged event) {
//        if (event.getSkill() == Skill.MAGIC) {
//            gainedExperience = client.getSkillExperience(Skill.MAGIC) - currentExperience;
//            currentExperience = client.getSkillExperience(Skill.MAGIC);
//            long frozenTime = calculateFreezeTime(gainedExperience, spell, prayMage);
//            if (frozenTime > 0) {
//                for (Player player : client.getPlayers()) {
//                    if (player.getName().equals(target)) {
//                        location = player.getWorldLocation();
//                        if (player.getOverheadIcon() != null && player.getOverheadIcon().equals(HeadIcon.MAGIC)) {
//                            prayMage = true;
//                            break;
//                        }
//                        targets.add(new Markable(player, location, System.currentTimeMillis(), frozenTime));
//                        log.debug("Marked Target {}", player.getName());
//                    }
//                }
//            }
//        }
//    }
//
//    public long calculateFreezeTime(int experience, String spell, boolean protectionPrayer) {
//        long freezeTime = 0;
//        switch (spell) {
//            case "Bind":
//                if (experience > 30) {
//                    if (protectionPrayer) {
//                        freezeTime = 2500;
//                    } else {
//                        freezeTime = 5000;
//                    }
//                }
//                break;
//            case "Snare":
//                if (experience > 60) {
//                    if (protectionPrayer) {
//                        freezeTime = 5000;
//                    } else {
//                        freezeTime = 10000;
//                    }
//                }
//                break;
//            case "Entangle":
//                if (experience > 89) {
//                    if (protectionPrayer) {
//                        freezeTime = 7500;
//                    } else {
//                        freezeTime = 15000;
//                    }
//                }
//                break;
//            case "Ice Rush":
//                if (experience > 34) {
//                    freezeTime = 5000;
//                }
//                break;
//            case "Ice Burst":
//                if (experience > 40) {
//                    freezeTime = 10000;
//                }
//                break;
//            case "Ice Blitz":
//                if (experience > 46) {
//                    freezeTime = 15000;
//                }
//                break;
//            case "Ice Barrage":
//                if (experience > 52) {
//                    freezeTime = 20000;
//                }
//                break;
//        }
//        return freezeTime;
//    }

}