package net.runelite.client.plugins.alfred;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.alfred.api.rs.BaseAPI;
import net.runelite.client.plugins.alfred.api.task.BaseTasks;
import net.runelite.client.plugins.alfred.device.Keyboard;
import net.runelite.client.plugins.alfred.device.Mouse;
import net.runelite.client.plugins.alfred.event.EventHandler;
import net.runelite.client.plugins.alfred.rpc.http.RPCServer;

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
    private static String status;
    private static RPCServer rpcServer;

    public Alfred(Client client, ClientThread clientThread) {
        Alfred.api = new BaseAPI();
        Alfred.tasks = new BaseTasks();
        Alfred.client = client;
        Alfred.clientThread = clientThread;
//        Alfred.config = config;
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

    public static String getStatus() {
        return Alfred.status;
    }

    public static void setStatus(String status) {
        System.out.println(status);
        Alfred.status = status;
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
