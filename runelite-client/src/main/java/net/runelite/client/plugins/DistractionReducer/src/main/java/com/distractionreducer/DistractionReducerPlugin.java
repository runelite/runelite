package net.runelite.client.plugins.distractionreducer;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.AnimationChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import java.util.Set;
import net.runelite.client.callback.ClientThread;
import lombok.extern.slf4j.Slf4j;

@PluginDescriptor(
        name = "Distraction Reducer",
        description = "Blacks out the screen while skilling to reduce distractions",
        tags = {"woodcutting", "fishing", "mining", "cooking", "herblore", "crafting", "fletching", "smithing", "skilling", "overlay"}
)
@Slf4j
public class DistractionReducerPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private DistractionReducerConfig config;

    @Inject
    private DistractionReducerOverlay distractionReducerOverlay;

    private int idleTicks = 0;
    private static final int MAX_IDLE_TICKS = 2;

    private static final Set<Integer> WOODCUTTING_ANIMATION_IDS = Set.of(
            AnimationID.WOODCUTTING_BRONZE, AnimationID.WOODCUTTING_IRON, AnimationID.WOODCUTTING_STEEL,
            AnimationID.WOODCUTTING_BLACK, AnimationID.WOODCUTTING_MITHRIL, AnimationID.WOODCUTTING_ADAMANT,
            AnimationID.WOODCUTTING_RUNE, AnimationID.WOODCUTTING_DRAGON, AnimationID.WOODCUTTING_INFERNAL,
            AnimationID.WOODCUTTING_3A_AXE, AnimationID.WOODCUTTING_CRYSTAL, AnimationID.WOODCUTTING_TRAILBLAZER
    );

    private static final Set<Integer> SMITHING_ANIMATION_IDS = Set.of(
            AnimationID.SMITHING_ANVIL, AnimationID.SMITHING_SMELTING, AnimationID.SMITHING_CANNONBALL
    );

    private static final Set<Integer> FISHING_ANIMATION_IDS = Set.of(
            AnimationID.FISHING_BARBTAIL_HARPOON, AnimationID.FISHING_BAREHAND, AnimationID.FISHING_BIG_NET,
            AnimationID.FISHING_CAGE, AnimationID.FISHING_CRYSTAL_HARPOON, AnimationID.FISHING_DRAGON_HARPOON,
            AnimationID.FISHING_HARPOON, AnimationID.FISHING_INFERNAL_HARPOON, AnimationID.FISHING_KARAMBWAN,
            AnimationID.FISHING_NET, AnimationID.FISHING_OILY_ROD, AnimationID.FISHING_POLE_CAST,
            AnimationID.FISHING_PEARL_ROD, AnimationID.FISHING_PEARL_FLY_ROD, AnimationID.FISHING_PEARL_BARBARIAN_ROD,
            AnimationID.FISHING_PEARL_ROD_2, AnimationID.FISHING_PEARL_FLY_ROD_2, AnimationID.FISHING_PEARL_BARBARIAN_ROD_2,
            AnimationID.FISHING_TRAILBLAZER_HARPOON
    );

    private static final Set<Integer> COOKING_ANIMATION_IDS = Set.of(
            AnimationID.COOKING_FIRE, AnimationID.COOKING_RANGE, AnimationID.COOKING_WINE
    );

    private static final Set<Integer> HERBLORE_ANIMATION_IDS = Set.of(
            AnimationID.HERBLORE_POTIONMAKING, AnimationID.HERBLORE_MAKE_TAR
    );

    private static final Set<Integer> CRAFTING_ANIMATION_IDS = Set.of(
            AnimationID.CRAFTING_LEATHER, AnimationID.CRAFTING_GLASSBLOWING, AnimationID.CRAFTING_SPINNING,
            AnimationID.CRAFTING_POTTERS_WHEEL, AnimationID.CRAFTING_POTTERY_OVEN
    );

    private static final Set<Integer> FLETCHING_ANIMATION_IDS = Set.of(
            AnimationID.FLETCHING_BOW_CUTTING, AnimationID.FLETCHING_STRING_NORMAL_SHORTBOW,
            AnimationID.FLETCHING_STRING_NORMAL_LONGBOW, AnimationID.FLETCHING_STRING_OAK_SHORTBOW,
            AnimationID.FLETCHING_STRING_OAK_LONGBOW, AnimationID.FLETCHING_STRING_WILLOW_SHORTBOW,
            AnimationID.FLETCHING_STRING_WILLOW_LONGBOW, AnimationID.FLETCHING_STRING_MAPLE_SHORTBOW,
            AnimationID.FLETCHING_STRING_MAPLE_LONGBOW, AnimationID.FLETCHING_STRING_YEW_SHORTBOW,
            AnimationID.FLETCHING_STRING_YEW_LONGBOW, AnimationID.FLETCHING_STRING_MAGIC_SHORTBOW,
            AnimationID.FLETCHING_STRING_MAGIC_LONGBOW
    );

    private static final Set<Integer> MINING_ANIMATION_IDS = Set.of(
            AnimationID.MINING_BRONZE_PICKAXE, AnimationID.MINING_IRON_PICKAXE, AnimationID.MINING_STEEL_PICKAXE,
            AnimationID.MINING_BLACK_PICKAXE, AnimationID.MINING_MITHRIL_PICKAXE, AnimationID.MINING_ADAMANT_PICKAXE,
            AnimationID.MINING_RUNE_PICKAXE, AnimationID.MINING_DRAGON_PICKAXE, AnimationID.MINING_DRAGON_PICKAXE_UPGRADED,
            AnimationID.MINING_DRAGON_PICKAXE_OR, AnimationID.MINING_INFERNAL_PICKAXE, AnimationID.MINING_3A_PICKAXE,
            AnimationID.MINING_CRYSTAL_PICKAXE, AnimationID.MINING_TRAILBLAZER_PICKAXE, AnimationID.MINING_GILDED_PICKAXE,
            AnimationID.MINING_MOTHERLODE_BRONZE, AnimationID.MINING_MOTHERLODE_IRON, AnimationID.MINING_MOTHERLODE_STEEL,
            AnimationID.MINING_MOTHERLODE_BLACK, AnimationID.MINING_MOTHERLODE_MITHRIL, AnimationID.MINING_MOTHERLODE_ADAMANT,
            AnimationID.MINING_MOTHERLODE_RUNE, AnimationID.MINING_MOTHERLODE_DRAGON, AnimationID.MINING_MOTHERLODE_DRAGON_UPGRADED,
            AnimationID.MINING_MOTHERLODE_DRAGON_OR, AnimationID.MINING_MOTHERLODE_INFERNAL, AnimationID.MINING_MOTHERLODE_3A,
            AnimationID.MINING_MOTHERLODE_CRYSTAL, AnimationID.MINING_MOTHERLODE_TRAILBLAZER
    );

    @Provides
    DistractionReducerConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(DistractionReducerConfig.class);
    }

    @Override
    protected void startUp() {
        log.info("Distraction Reducer plugin started!");
        overlayManager.add(distractionReducerOverlay);
        clientThread.invoke(this::updateOverlayVisibility);
    }

    @Override
    protected void shutDown() {
        log.info("Distraction Reducer plugin stopped!");
        overlayManager.remove(distractionReducerOverlay);
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
            clientThread.invoke(this::updateOverlayVisibility);
        }
    }

    @Subscribe
    public void onAnimationChanged(AnimationChanged event) {
        if (event.getActor() == client.getLocalPlayer()) {
            int animation = event.getActor().getAnimation();
            log.debug("Animation changed: {}", animation);
            updateOverlayVisibility();
        }
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        Player player = client.getLocalPlayer();
        if (player == null) return;

        if (player.getAnimation() == AnimationID.IDLE) {
            idleTicks++;
        } else {
            idleTicks = 0;
        }

        updateOverlayVisibility();
    }

    private void updateOverlayVisibility() {
        boolean shouldRenderOverlay = isSkilling() && (idleTicks < MAX_IDLE_TICKS);
        distractionReducerOverlay.setRenderOverlay(shouldRenderOverlay);
        log.debug("Overlay visibility updated. Rendering: {}", shouldRenderOverlay);
    }

    private boolean isSkilling() {
        Player player = client.getLocalPlayer();
        if (player == null) return false;

        int animation = player.getAnimation();

        return (WOODCUTTING_ANIMATION_IDS.contains(animation) && config.woodcutting()) ||
                (FISHING_ANIMATION_IDS.contains(animation) && config.fishing()) ||
                (MINING_ANIMATION_IDS.contains(animation) && config.mining()) ||
                (COOKING_ANIMATION_IDS.contains(animation) && config.cooking()) ||
                (HERBLORE_ANIMATION_IDS.contains(animation) && config.herblore()) ||
                (CRAFTING_ANIMATION_IDS.contains(animation) && config.crafting()) ||
                (FLETCHING_ANIMATION_IDS.contains(animation) && config.fletching()) ||
                (SMITHING_ANIMATION_IDS.contains(animation) && config.smithing());
    }
}
