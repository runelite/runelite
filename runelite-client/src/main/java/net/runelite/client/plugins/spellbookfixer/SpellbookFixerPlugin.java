package net.runelite.client.plugins.spellbookfixer;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
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


@PluginDescriptor(
        name = "Spellbook Fixer",
        description = "Resize and filter spellbook for PKing",
        tags = {"resize", "spellbook", "magic", "spell", "pk", "book", "filter", "bogla"}
)
@Slf4j
public class SpellbookFixerPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    SpellbookFixerConfig config;

    @Provides
    SpellbookFixerConfig provideConfig(ConfigManager configManager) { return configManager.getConfig(SpellbookFixerConfig.class); }

    @Override
    protected void startUp() throws Exception
    {
        adjustSpellbook();
    }

    @Override
    protected void shutDown() throws Exception
    {
        resetSpellbook();
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        if (event.getGameState() == GameState.LOGGED_IN)
            adjustSpellbook();
    }

    @Subscribe
    public void onWidgetLoaded(WidgetLoaded event)
    {
        if (event.getGroupId() == WidgetID.SPELLBOOK_GROUP_ID)
            adjustSpellbook();
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        adjustSpellbook();
    }

    private void adjustSpellbook()
    {
        if (client.getGameState() != GameState.LOGGED_IN)
            return;

        try
        {
            if (config.shouldModifyIceBarrage())
                modifySpell(WidgetInfo.SPELL_ICE_BARRAGE, config.getBarragePositionX(), config.getBarragePositionY(), config.getBarrageSize());

            if (config.shouldModifyIceBlitz())
                modifySpell(WidgetInfo.SPELL_ICE_BLITZ, config.getBlitzPositionX(), config.getBlitzPositionY(), config.getBlitzSize());

            if (config.shouldModifyVengeance())
                modifySpell(WidgetInfo.SPELL_VENGEANCE, config.getVengeancePositionX(), config.getVengeancePositionY(), config.getVengeanceSize());

            if (config.shouldModifyTeleBlock())
                modifySpell(WidgetInfo.SPELL_TELE_BLOCK, config.getTeleBlockPositionX(), config.getTeleBlockPositionY(), config.getTeleBlockSize());

            if (config.shouldModifyEntangle())
                modifySpell(WidgetInfo.SPELL_ENTANGLE, config.getEntanglePositionX(), config.getEntanglePositionY(), config.getEntangleSize());

            setSpellHidden(WidgetInfo.SPELL_BLOOD_BLITZ, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_VENGEANCE_OTHER, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_BIND, config.shouldHideOthers());
            setSpellHidden(WidgetInfo.SPELL_SNARE, config.shouldHideOthers());
        }
        catch (Exception e)
        {
            //swallow
        }


    }

    private void resetSpellbook()
    {
        if (client.getGameState() != GameState.LOGGED_IN)
            return;

        try
        {
            if (config.shouldModifyIceBarrage())
                modifySpell(WidgetInfo.SPELL_ICE_BARRAGE, config.getBarragePositionX(), config.getBarragePositionY(), 24);

            if (config.shouldModifyIceBlitz())
                modifySpell(WidgetInfo.SPELL_ICE_BLITZ, config.getBlitzPositionX(), config.getBlitzPositionY(), 24);

            if (config.shouldModifyVengeance())
                modifySpell(WidgetInfo.SPELL_VENGEANCE, config.getVengeancePositionX(), config.getVengeancePositionY(), 24);

            if (config.shouldModifyTeleBlock())
                modifySpell(WidgetInfo.SPELL_TELE_BLOCK, config.getTeleBlockPositionX(), config.getTeleBlockPositionY(), 24);

            if (config.shouldModifyEntangle())
                modifySpell(WidgetInfo.SPELL_ENTANGLE, config.getEntanglePositionX(), config.getEntanglePositionY(), 24);

            setSpellHidden(WidgetInfo.SPELL_BLOOD_BLITZ, false);
            setSpellHidden(WidgetInfo.SPELL_VENGEANCE_OTHER, false);
            setSpellHidden(WidgetInfo.SPELL_BIND, false);
            setSpellHidden(WidgetInfo.SPELL_SNARE, false);
        }
        catch (Exception e)
        {
            //swallow
        }
    }

    private void modifySpell(WidgetInfo widgetInfo, int posX, int posY, int size)
    {
        Widget widget = client.getWidget(widgetInfo);

        if (widget == null)
            return;

        try
        {
            widget.setOriginalX(posX);
            widget.setOriginalY(posY);
            widget.setOriginalWidth(size);
            widget.setOriginalHeight(size);
            widget.revalidate();
        }
        catch (Exception e)
        {
            //swallow
        }

    }

    private void setSpellHidden(WidgetInfo widgetInfo, boolean hidden)
    {
        Widget widget = client.getWidget(widgetInfo);

        if (widget == null)
            return;

        widget.setHidden(hidden);
    }

}
