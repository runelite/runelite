package net.runelite.client.plugins.alfred;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ProfileManager;
import net.runelite.client.game.WorldService;
import net.runelite.client.plugins.alfred.api.rs.BaseAPI;
import net.runelite.client.plugins.alfred.api.task.BaseTasks;
import net.runelite.client.plugins.alfred.device.Keyboard;
import net.runelite.client.plugins.alfred.device.Mouse;
import net.runelite.client.plugins.alfred.event.EventHandler;
import net.runelite.client.plugins.alfred.rpc.http.RPCServer;
import net.runelite.client.plugins.alfred.util.PlayTimer;

import java.util.function.BooleanSupplier;

public class Alfred {

    public static BaseAPI api;
    public static BaseTasks tasks;
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
    @Getter
    private static WorldService worldService;
    @Getter
    private static ProfileManager profileManager;
    @Getter
    private static PlayTimer playTimer;
    @Getter
    private static String taskStatus;
    @Getter
    private static String taskSubStatus;
    @Getter
    private static String status;
    private static RPCServer rpcServer;

    public Alfred(Client client, ClientThread clientThread, WorldService worldService, ProfileManager profileManager) {
        Alfred.api = new BaseAPI();
        Alfred.tasks = new BaseTasks();
        Alfred.client = client;
        Alfred.clientThread = clientThread;
        Alfred.worldService = worldService;
        Alfred.profileManager = profileManager;
        Alfred.playTimer = new PlayTimer();
        Alfred.mouse = new Mouse();
        Alfred.keyboard = new Keyboard();
        Alfred.eventHandler = new EventHandler();
    }

    public void start() throws Exception {
//        AnnotationMapper annotationMapper = new AnnotationMapper();
//        annotationMapper.map();
//        annotationMapper.printMap();
//
//        rpcServer = new RPCServer(annotationMapper.getMethodNameToMethodMap());
//        rpcServer.start();
    }

    public void stop() throws Exception {
//        rpcServer.stop();
    }

    public static void setStatus(String status) {
        System.out.println(status);
        Alfred.status = status;
    }

    public static void setTaskStatus(String status) {
        System.out.println(status);
        Alfred.taskStatus = status;
    }

    public static void setTaskSubStatus(String status) {
        System.out.println(status);
        Alfred.taskSubStatus = status;
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

    public static boolean sleepUntil(BooleanSupplier awaitedCondition, int time, int timeout) {
        if (!client.isClientThread()) {
            long startTime = System.currentTimeMillis();
            do {
                if (awaitedCondition.getAsBoolean()) {
                    return true;
                }
                sleep(time);
            } while (System.currentTimeMillis() - startTime < timeout);
        }
        return false;
    }

    public static boolean sleepUntilExecution(Runnable callback, BooleanSupplier awaitedCondition, int time, int timeout) {
        if (!client.isClientThread()) {
            long startTime = System.currentTimeMillis();
            do {
                if (awaitedCondition.getAsBoolean()) {
                    callback.run();
                    return true;
                }
                sleep(time);
            } while (System.currentTimeMillis() - startTime < timeout);
        }
        return false;
    }
}
