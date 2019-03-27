package net.runelite.client.plugins.spellbookiconresize;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.util.HashMap;


@PluginDescriptor(
        name = "! Spellbook Icon Resizing",
        description = "Resize and filter spellbook for PKing",
        tags = {"resize", "spellbook", "magic", "spell", "pk", "book", "filter", "bogla"},
        enabledByDefault = false
)
@Slf4j
public class spellbookiconresizePlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    spellbookiconresizeConfig config;

    private boolean initiated = false;

    public HashMap<Integer, Integer> ORIGINAL_POSITION_X = new HashMap<Integer, Integer>();
    public HashMap<Integer, Integer> ORIGINAL_POSITION_Y = new HashMap<Integer, Integer>();

    @Provides
    spellbookiconresizeConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(spellbookiconresizeConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        initIcon(WidgetInfo.SPELL_ICE_BARRAGE);
        initIcon(WidgetInfo.SPELL_ICE_BLITZ);
        initIcon(WidgetInfo.SPELL_VENGEANCE);
        initIcon(WidgetInfo.SPELL_TELE_BLOCK);
        initIcon(WidgetInfo.SPELL_ENTANGLE);
        initIcon(WidgetInfo.SPELL_FIRE_SURGE);
        initiated = true;
        adjustSpellbook();
    }

    @Subscribe
    protected void onConfigChanged(ConfigChanged event) {
        adjustSpellbook();
        if (config.shouldModifyIceBarrage()) {
            modifySpell(WidgetInfo.SPELL_ICE_BARRAGE, config.getEntanglePositionX(), config.getEntanglePositionY(), config.getEntangleSize());
        } else if (!config.shouldModifyEntangle()) {
            modifySpell(WidgetInfo.SPELL_ICE_BARRAGE, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_ICE_BARRAGE.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_ICE_BARRAGE.getId()), 24);
        }
        if (config.shouldModifyIceBlitz()) {
            modifySpell(WidgetInfo.SPELL_ICE_BLITZ, config.getBlitzPositionX(), config.getBlitzPositionY(), config.getBlitzSize());
        } else if (!config.shouldModifyEntangle()) {
            modifySpell(WidgetInfo.SPELL_ICE_BLITZ, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_ICE_BLITZ.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_ICE_BLITZ.getId()), 24);
        }
        if (config.shouldModifyVengeance()) {
            modifySpell(WidgetInfo.SPELL_VENGEANCE, config.getVengeancePositionX(), config.getVengeancePositionY(), config.getVengeanceSize());
        } else if (!config.shouldModifyEntangle()) {
            modifySpell(WidgetInfo.SPELL_VENGEANCE, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_VENGEANCE.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_VENGEANCE.getId()), 24);
        }
        if (config.shouldModifyTeleBlock()) {
            modifySpell(WidgetInfo.SPELL_TELE_BLOCK, config.getTeleBlockPositionX(), config.getTeleBlockPositionY(), config.getTeleBlockSize());
        } else if (!config.shouldModifyEntangle()) {
            modifySpell(WidgetInfo.SPELL_TELE_BLOCK, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_TELE_BLOCK.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_TELE_BLOCK.getId()), 24);
        }
        if (config.shouldModifyEntangle()) {
            modifySpell(WidgetInfo.SPELL_ENTANGLE, config.getEntanglePositionX(), config.getEntanglePositionY(), config.getEntangleSize());
        } else if (!config.shouldModifyEntangle()) {
            modifySpell(WidgetInfo.SPELL_ENTANGLE, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_ENTANGLE.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_ENTANGLE.getId()), 24);
        }
        if (config.shouldModifyFireSurge()) {
            modifySpell(WidgetInfo.SPELL_FIRE_SURGE, config.getFireSurgePositionX(), config.getFireSurgePositionY(), config.getFireSurgeSize());
        } else if (!config.shouldModifyEntangle()) {
            modifySpell(WidgetInfo.SPELL_FIRE_SURGE, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_FIRE_SURGE.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_FIRE_SURGE.getId()), 24);
        }
    }


    @Override
    protected void shutDown() throws Exception {
        resetSpellbook();
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event) {
        if (event.getGameState() == GameState.LOGGED_IN)
            adjustSpellbook();
    }

    @Subscribe
    public void onWidgetLoaded(WidgetLoaded event) {
        if (event.getGroupId() == WidgetID.SPELLBOOK_GROUP_ID)
            adjustSpellbook();
    }

    private void adjustSpellbook() {
        if (client.getGameState() != GameState.LOGGED_IN)
            return;

        try {
            setSpellHidden(WidgetInfo.SPELL_ICE_BURST, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_ICE_RUSH, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_BLOOD_RUSH, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_BLOOD_BLITZ, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_BLOOD_BURST, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_BLOOD_BARRAGE, config.shouldHideOthers());

            setSpellHidden(WidgetInfo.SPELL_SMOKE_RUSH, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_SMOKE_BLITZ, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_SMOKE_BURST, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_SMOKE_BARRAGE, config.shouldHideOthers());

            setSpellHidden(WidgetInfo.SPELL_SHADOW_RUSH, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_SHADOW_BLITZ, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_SHADOW_BURST, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_SHADOW_BARRAGE, config.shouldHideOthers());


            setSpellHidden(WidgetInfo.SPELL_BOUNTY_TARGET_TELEPORT, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_PADDEWWA_TELEPORT, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_SENNTISTEN_TELEPORT, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_KHARYRLL_TELEPORT, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_LASSAR_TELEPORT, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_DAREEYAK_TELEPORT, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_CARRALLANGER_TELEPORT, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_ANNAKARL_TELEPORT, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_GHORROCK_TELEPORT, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_EDGEVILLE_HOME_TELEPORT, config.shouldHideOthers());

            setSpellHidden(WidgetInfo.SPELL_VENGEANCE_OTHER, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_BIND, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_SNARE, config.shouldHideOthers());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void resetSpellbook() {
        if (client.getGameState() != GameState.LOGGED_IN)
            return;

        try {
            modifySpell(WidgetInfo.SPELL_ICE_BARRAGE, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_ICE_BARRAGE.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_ICE_BARRAGE.getId()), 24);
            modifySpell(WidgetInfo.SPELL_ICE_BLITZ, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_ICE_BLITZ.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_ICE_BLITZ.getId()), 24);
            modifySpell(WidgetInfo.SPELL_VENGEANCE, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_VENGEANCE.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_VENGEANCE.getId()), 24);
            modifySpell(WidgetInfo.SPELL_TELE_BLOCK, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_TELE_BLOCK.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_TELE_BLOCK.getId()), 24);
            modifySpell(WidgetInfo.SPELL_ENTANGLE, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_ENTANGLE.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_ENTANGLE.getId()), 24);
            modifySpell(WidgetInfo.SPELL_FIRE_SURGE, ORIGINAL_POSITION_X.get(WidgetInfo.SPELL_FIRE_SURGE.getId()), ORIGINAL_POSITION_Y.get(WidgetInfo.SPELL_FIRE_SURGE.getId()), 24);

            setSpellHidden(WidgetInfo.SPELL_BOUNTY_TARGET_TELEPORT, false);
            setSpellHidden(WidgetInfo.SPELL_ICE_RUSH, false);
            setSpellHidden(WidgetInfo.SPELL_ICE_BURST, false);
            setSpellHidden(WidgetInfo.SPELL_BLOOD_RUSH, false);
            setSpellHidden(WidgetInfo.SPELL_BLOOD_BLITZ, false);
            setSpellHidden(WidgetInfo.SPELL_BLOOD_BURST, false);
            setSpellHidden(WidgetInfo.SPELL_BLOOD_BARRAGE, false);
            setSpellHidden(WidgetInfo.SPELL_SMOKE_RUSH, false);
            setSpellHidden(WidgetInfo.SPELL_SMOKE_BLITZ, false);
            setSpellHidden(WidgetInfo.SPELL_SMOKE_BURST, false);
            setSpellHidden(WidgetInfo.SPELL_SMOKE_BARRAGE, false);
            setSpellHidden(WidgetInfo.SPELL_SHADOW_RUSH, false);
            setSpellHidden(WidgetInfo.SPELL_SHADOW_BLITZ, false);
            setSpellHidden(WidgetInfo.SPELL_SHADOW_BURST, false);
            setSpellHidden(WidgetInfo.SPELL_SHADOW_BARRAGE, false);
            setSpellHidden(WidgetInfo.SPELL_VENGEANCE_OTHER, false);
            setSpellHidden(WidgetInfo.SPELL_BIND, false);
            setSpellHidden(WidgetInfo.SPELL_SNARE, false);
            setSpellHidden(WidgetInfo.SPELL_PADDEWWA_TELEPORT, false);
            setSpellHidden(WidgetInfo.SPELL_SENNTISTEN_TELEPORT, false);
            setSpellHidden(WidgetInfo.SPELL_KHARYRLL_TELEPORT, false);
            setSpellHidden(WidgetInfo.SPELL_LASSAR_TELEPORT, false);
            setSpellHidden(WidgetInfo.SPELL_DAREEYAK_TELEPORT, false);
            setSpellHidden(WidgetInfo.SPELL_CARRALLANGER_TELEPORT, false);
            setSpellHidden(WidgetInfo.SPELL_ANNAKARL_TELEPORT, false);
            setSpellHidden(WidgetInfo.SPELL_GHORROCK_TELEPORT, false);
            setSpellHidden(WidgetInfo.SPELL_EDGEVILLE_HOME_TELEPORT, false);
        } catch (Exception e) {
            e.printStackTrace();//swallow
        }
    }

    private void initIcon(WidgetInfo widgetInfo) {
        Widget widget = client.getWidget(widgetInfo);
        if (ORIGINAL_POSITION_X.get(widget.getId())==null) {
            ORIGINAL_POSITION_X.put(widget.getId(), widget.getOriginalX());
            ORIGINAL_POSITION_Y.put(widget.getId(), widget.getOriginalY());
        }
    }

    private int getOriginalX(int widgetId) {
        return ORIGINAL_POSITION_X.get(widgetId);
    }

    private int getOriginalY(int widgetId) {
        return ORIGINAL_POSITION_Y.get(widgetId);
    }

    private void modifySpell(WidgetInfo widgetInfo, int posX, int posY, int size) {
        Widget widget = client.getWidget(widgetInfo);

        if (widget == null)
            return;

        try {
            widget.setOriginalX(posX);
            widget.setOriginalY(posY);
            widget.setOriginalWidth(size);
            widget.setOriginalHeight(size);
            widget.revalidate();
        } catch (Exception e) {
            e.printStackTrace(); //swallow
        }

    }

    private void setSpellHidden(WidgetInfo widgetInfo, boolean hidden) {
        Widget widget = client.getWidget(widgetInfo);

        if (widget == null)
            return;

        widget.setHidden(hidden);
    }

}
