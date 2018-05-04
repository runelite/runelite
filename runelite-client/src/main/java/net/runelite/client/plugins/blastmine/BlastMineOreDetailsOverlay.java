package net.runelite.client.plugins.blastmine;

import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.item.ItemPrice;

import javax.inject.Inject;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

class BlastMineOreDetailsOverlay extends Overlay {
    private final static int COAL = ItemID.COAL;
    private final static int GOLD_ORE = ItemID.GOLD_ORE;
    private final static int MITHRIL_ORE = ItemID.MITHRIL_ORE;
    private final static int ADAMANTITE_ORE = ItemID.ADAMANTITE_ORE;
    private final static int RUNITE_ORE = ItemID.RUNITE_ORE;

    private final Client client;
    private final BlastMinePluginConfig config;
    private final PanelComponent panelComponent = new PanelComponent();
    private final ItemManager itemManager;

    private final HashMap<Integer, Integer> orePrices = new HashMap<Integer, Integer>();

    @Inject
    BlastMineOreDetailsOverlay(Client client, BlastMinePluginConfig config, ItemManager itemManager)
    {
        setPosition(OverlayPosition.TOP_LEFT);
        this.client = client;
        this.config = config;
        this.itemManager = itemManager;
    }

    @Override
    public Dimension render(Graphics2D graphics) {

        Widget blastMineWidget = client.getWidget(WidgetInfo.BLAST_MINE);
        panelComponent.getLines().clear();

        if (orePrices.size() == 0)
        {
            this.getOrePrices();
        }

        if (blastMineWidget != null)
        {
            blastMineWidget.setHidden(true);
            if (config.showSackDetails())
            {
                panelComponent.getLines().add(new PanelComponent.Line("XP: ", StackFormatter.formatNumber(CalculateXP()) + " xp"));
                panelComponent.getLines().add(new PanelComponent.Line("GP: ", StackFormatter.formatNumber(CalculatePrice()) + " gp"));
            }
        }

        if (panelComponent.getLines().size() > 0)
        {
            return panelComponent.render(graphics);
        }

        return null;
    }

    private int CalculateXP()
    {
        return  client.getVar(Varbits.BLAST_MINE_COAL) * 30 +
                client.getVar(Varbits.BLAST_MINE_GOLD) * 60 +
                client.getVar(Varbits.BLAST_MINE_MITHRIL) * 110 +
                client.getVar(Varbits.BLAST_MINE_ADAMANTITE) * 170 +
                client.getVar(Varbits.BLAST_MINE_RUNITE) * 240;
    }

    private int CalculatePrice()
    {
        return  client.getVar(Varbits.BLAST_MINE_COAL) * orePrices.get(COAL) +
                client.getVar(Varbits.BLAST_MINE_GOLD) * orePrices.get(GOLD_ORE) +
                client.getVar(Varbits.BLAST_MINE_MITHRIL) * orePrices.get(MITHRIL_ORE) +
                client.getVar(Varbits.BLAST_MINE_ADAMANTITE) * orePrices.get(ADAMANTITE_ORE) +
                client.getVar(Varbits.BLAST_MINE_RUNITE) * orePrices.get(RUNITE_ORE);
    }

    private void getOrePrices()
    {
        orePrices.put(COAL, this.getItemPrice(COAL));
        orePrices.put(GOLD_ORE, this.getItemPrice(GOLD_ORE));
        orePrices.put(MITHRIL_ORE, this.getItemPrice(MITHRIL_ORE));
        orePrices.put(ADAMANTITE_ORE, this.getItemPrice(ADAMANTITE_ORE));
        orePrices.put(RUNITE_ORE, this.getItemPrice(RUNITE_ORE));
    }

    private int getItemPrice(int itemId)
    {
        // convert to unnoted id
        ItemComposition composition = this.itemManager.getItemComposition(itemId);
        final boolean note = composition.getNote() != -1;
        final int id = note ? composition.getLinkedNoteId() : composition.getId();

        ItemPrice itemPrice;
        try
        {
            itemPrice = this.itemManager.getItemPrice(id);
        }
        catch (IOException e)
        {
            return 0;
        }

        final int gePrice = itemPrice == null ? 0 : itemPrice.getPrice();
        return gePrice;
    }
}