package net.runelite.client.plugins.alfred.debug;


import net.runelite.api.ObjectComposition;
import net.runelite.api.Player;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.BankAPI;
import net.runelite.client.plugins.alfred.api.rs.PlayerAPI;
import net.runelite.client.plugins.alfred.api.rs.TabAPI;
import net.runelite.client.plugins.alfred.api.rs.GameObjectAPI;
import net.runelite.client.plugins.alfred.device.Keyboard;
import net.runelite.client.plugins.alfred.device.Mouse;

import java.awt.*;

public class DebugThread extends Thread {

    Mouse mouse = Alfred.getMouse();
    Keyboard keyboard = Alfred.getKeyboard();
    Canvas canvas = Alfred.getClient().getCanvas();

    public DebugThread() {
        this.setDaemon(true);
    }


    @Override
    public void run() {
        while (true) {
            Alfred.sleep(2000);
//            int randomX = (int) (Math.random() * canvas.getWidth());
//            int randomY = (int) (Math.random() * canvas.getHeight());
//            mouse.move(randomX, randomY);

//            Alfred.sleep(1000);
//            Player player = Alfred.getClient().getLocalPlayer();
//            PlayerAPI playerAPI = new PlayerAPI(player);
//            playerAPI.setRunning();
//            keyboard.sendKeys("Hello world! ");

//            TabAPI.test();
//            BankAPI.test();

            BankAPI.getNearestBanks().forEach(bankAPI -> {
                bankAPI.openBank();
            });

        }
    }
}