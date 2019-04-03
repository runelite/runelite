package net.runelite.client.plugins.aaautoswitcherbeta;

import net.runelite.api.Client;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.util.QueryRunner;

import javax.inject.Inject;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

public class MouseUtil {

    @Inject
    private Client client;

    @Inject
    private QueryRunner queryRunner = new QueryRunner();

    public void doClick(int id) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (Exception failed) {
            System.err.println("Failed instantiating Robot: " + failed);
        }
        for (Object o : AutoSwitcherOverlay.inventoryItems) {
            WidgetItem item = (WidgetItem) o;
        if (id == item.getId()) {
            final Rectangle bounds = item.getCanvasBounds();
            int mask = InputEvent.BUTTON1_DOWN_MASK;
            int clientX = ClientUI.frame.getX();
            int clientY = ClientUI.frame.getY();
            bot.mouseMove(bounds.x+clientX+(int)bounds.getWidth()/2, bounds.y+clientY+(int)bounds.getHeight()/2+20);

            Random random = new Random();
            int random1 = random.nextInt(45);
            if (random1 < 20)
                random1 = random.nextInt(20)+20;
            int random2 = random.nextInt(45);
            if (random2 < 20)
                random2 = random.nextInt(20)+20;
            int random3 = random.nextInt(45);
            if (random3 < 20)
                random3 = random.nextInt(20)+20;
            bot.delay(random1);
            bot.mousePress(mask);
            bot.delay(random2);
            bot.mouseRelease(mask);
            bot.delay(random3);
            bot.mouseMove((int)p.getX(), (int)p.getY());
            return;
        }
    }
    }
}
