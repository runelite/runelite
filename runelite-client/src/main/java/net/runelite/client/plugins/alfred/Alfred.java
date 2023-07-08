package net.runelite.client.plugins.alfred;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.alfred.api.rs.BaseAPI;
import net.runelite.client.plugins.alfred.device.Keyboard;
import net.runelite.client.plugins.alfred.device.Mouse;
import net.runelite.client.plugins.alfred.event.EventHandler;

public class Alfred {

    @Getter
    private static Client client;

    @Getter
    private static ClientThread clientThread;

    @Getter
    private static Mouse mouse;

    @Getter
    private static Keyboard keyboard;

    @Getter
    private static EventHandler eventHandler;

    public static BaseAPI api;

    public Alfred(Client client, ClientThread clientThread) {
        Alfred.api = new BaseAPI();
        Alfred.client = client;
        Alfred.clientThread = clientThread;
        Alfred.mouse = new Mouse();
        Alfred.keyboard = new Keyboard();
        Alfred.eventHandler = new EventHandler();
    }


    public static int getVarbitValue(int varbit) {
        return clientThread.invokeOnClientThread(() -> getClient().getVarbitValue(varbit));
    }

    public static int getVarbitPlayerValue(int varbit) {
        return clientThread.invokeOnClientThread(() -> getClient().getVarpValue(varbit));
    }

    public static void sleep(int time) {
        if (!client.isClientThread()) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sleep(int start, int end) {
        if (!client.isClientThread()) {
            try {
                int time = start + (int) (Math.random() * (end - start));
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
