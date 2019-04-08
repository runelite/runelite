package net.runelite.client.plugins.aaautoswitcherbeta;

import net.runelite.api.Client;
import net.runelite.api.Query;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.flexo.Flexo;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.util.QueryRunner;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

public class MouseUtil {

    private Client client;

    @Inject
    private AutoSwitcherPlugin plugin;

    @Inject
    private QueryRunner queryRunner = new QueryRunner();

    @Inject
    public MouseUtil(@Nullable Client client, AutoSwitcherPlugin plugin) {
        this.client = client;
        this.plugin = plugin;
    }

    public void doClick(int id) {
        Flexo bot = null;
        try {
            bot = new Flexo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        final Query query = new InventoryWidgetItemQuery();

        final WidgetItem[] widgetItems = (WidgetItem[]) query.result(client);

        for (final WidgetItem item : widgetItems) {
            final String group = plugin.getTag(item.getId());
            if (item.getId() == id)
                if (group != null) {
                    switch (group) {
                        case "Group 1":
                        case "Group 2":
                        case "Group 3":
                        case "Group 4":
                            Rectangle clickArea = item.getCanvasBounds();
                            int mask = InputEvent.BUTTON1_DOWN_MASK;
                            int clientX = ClientUI.frame.getX();
                            int clientY = ClientUI.frame.getY();
                            bot.mouseMove(8 + clickArea.x + clientX + (int) clickArea.getWidth() / 2, 8 + clickArea.y + clientY + (int) clickArea.getHeight() / 2 + 20);
                            bot.mousePressAndRelease(1);
                    }

                }
        }
    }
}


