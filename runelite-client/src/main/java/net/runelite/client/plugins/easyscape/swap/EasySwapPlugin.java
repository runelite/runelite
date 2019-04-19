package net.runelite.client.plugins.easy.swap;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.easy.util.Swapper;
import net.runelite.client.util.Text;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;

import javax.inject.Inject;

import static net.runelite.api.MenuAction.WALK;
import static net.runelite.api.ObjectID.PORTAL_4525;

@PluginDescriptor(
        name = "EasySwap",
        description = "EasySwap.",
        tags = {"EasySwap", "easy"}
)

@Slf4j
public class EasySwapPlugin extends Plugin {

    private static final int PURO_PURO_REGION_ID = 10307;

    private Swapper swapper = new Swapper();
    private boolean inHouse = false;

    @Inject
    private Client client;

    @Inject
    private EasySwapConfig config;

    @Provides
    EasySwapConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(EasySwapConfig.class);
    }

    @Override
    public void startUp() {
        log.debug("EasySwap Started.");
    }

    @Override
    public void shutDown() {
        log.debug("EasySwap Stopped.");
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event) {

        if (client.getGameState() != GameState.LOGGED_IN) {
            return;
        }

        Widget loginScreenOne = client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN);
        Widget loginScreenTwo = client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN_MESSAGE_OF_THE_DAY);

        if (loginScreenOne != null || loginScreenTwo != null) {
            return;
        }

        final String option = Text.removeTags(event.getOption()).toLowerCase();
        final String target = Text.removeTags(event.getTarget()).toLowerCase();

        swapper.setEntries(client.getMenuEntries());

        if (config.getSwapPuro() && isPuroPuro()) {
            if (event.getType() == WALK.getId()) {
                swapper.deprioritizeWalk();
            } else if (option.equalsIgnoreCase("examine")) {
                swapper.markForSwap("push-through", option, target);
            } else if (option.equalsIgnoreCase("use")) {
                swapper.markForSwap("escape", option, target);
            }
        }

        if (config.getEasyConstruction() && !config.getConstructionItems().equals("") && inHouse) {
            if (event.getType() == WALK.getId()) {
                swapper.deprioritizeWalk();
            }

            swapper.markForSwap("Build", option, target);

            for (int i = swapper.getEntries().length - 1; i >= 0; i--) {
                for (String item : config.getConstructionItems().split(",")) {
                    if (item.trim().equalsIgnoreCase(Text.removeTags(swapper.getEntries()[i].getTarget()))) {
                        if (!swapper.getEntries()[i].getOption().equalsIgnoreCase("remove")) {
                            swapper.removeIndex(i);
                            i--;
                        }
                    }
                }
            }
        }

        if (config.getSwapSmithing()) {
            if (option.equalsIgnoreCase("Smith 1")) {
                swapper.markForSwap("Smith All", option, target);
            } else if (option.equalsIgnoreCase("Smith 1 Set")) {
                swapper.markForSwap("Smith All Sets", option, target);
            }
        }

        if (config.getSwapTanning() && option.equalsIgnoreCase("Tan 1")) {
            swapper.markForSwap("Tan All", option, target);
        }

        if (config.getSwapCrafting()) {
            switch (option) {
                case "Make-1":
                    swapper.markForSwap("Make-All", option, target);
                    break;
                case "Craft 1":
                    swapper.markForSwap("Craft All", option, target);
                    break;
                default:
                    break;
            }
        }

        if (config.getSwapSawmill() && target.equalsIgnoreCase("Sawmill operator")) {
            swapper.markForSwap("Buy-plank", option, target);
        }

        if (config.getSwapSawmillPlanks() && option.equalsIgnoreCase("Buy 1")) {
            swapper.markForSwap("Buy All", option, target);
        }

        if (option.equalsIgnoreCase("Clear-All") && target.equalsIgnoreCase("bank Filler")) {
            swapper.markForSwap("Clear", option, target);
        }

        if (target.toLowerCase().contains("ardougne cloak") && config.getSwapArdougneCape()) {
            swapper.markForSwap("Kandarin Monastery", option, target);
            swapper.markForSwap("Monastery Teleport", option, target);
        }

        if (config.getSwapEssencePouch()) {
            if (isEssencePouch(target)) {
                Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
                switch (config.getEssenceMode()) {
                    case RUNECRAFTING:
                        if (widgetBankTitleBar == null || widgetBankTitleBar.isHidden()) {
                            swapper.markForSwap("Empty", option, target);
                        } else {
                            swapper.markForSwap("Fill", option, target);
                        }
                        break;
                    case ESSENCE_MINING:
                        if (widgetBankTitleBar == null || widgetBankTitleBar.isHidden()) {
                            swapper.markForSwap("Fill", option, target);
                        } else {
                            swapper.markForSwap("Empty", option, target);
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        if (config.getGamesNecklace()) {
            if (target.toLowerCase().contains("games necklace")) {
                swapper.markForSwap(config.getGamesNecklaceMode().toString(), option, target);
            }
        }

        if (config.getDuelingRing()) {
            if (target.toLowerCase().contains("ring of dueling")) {
                swapper.markForSwap(config.getDuelingRingMode().toString(), option, target);
            }
        }

        if (config.getGlory()) {
            if (target.toLowerCase().contains("amulet of glory")) {
                swapper.markForSwap(config.getGloryMode().toString(), option, target);
            }
        }

        swapper.startSwap();
        client.setMenuEntries(swapper.getEntries());
    }

    private boolean isEssencePouch(String target) {
        return (target.equalsIgnoreCase("Small Pouch") || target.equalsIgnoreCase("Medium Pouch") || target.equalsIgnoreCase("Large Pouch") || target.equalsIgnoreCase("Giant Pouch"));
    }

    @Subscribe
    public void onGameObjectSpawned(GameObjectSpawned event)
    {
        final GameObject gameObject = event.getGameObject();
        if (PORTAL_4525 == gameObject.getId())
        {
            this.inHouse = true;
        }
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        if (event.getGameState() == GameState.LOADING)
        {
            this.inHouse = false;
        }
    }

    private boolean isHouse() {
        return this.inHouse;
    }

    private boolean isPuroPuro() {
        Player player = client.getLocalPlayer();

        if (player == null) {
            return false;
        } else {
            WorldPoint location = player.getWorldLocation();
            return location.getRegionID() == PURO_PURO_REGION_ID;
        }
    }

}