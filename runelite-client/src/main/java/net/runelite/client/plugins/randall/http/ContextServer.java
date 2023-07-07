package net.runelite.client.plugins.randall.http;

import net.runelite.api.Client;
import net.runelite.client.plugins.randall.RandallPlugin;
import net.runelite.client.plugins.randall.http.handlers.game.GameHandler;
import net.runelite.client.plugins.randall.http.handlers.input.InputHandler;
import net.runelite.client.plugins.randall.http.handlers.message.MessageHandler;
import net.runelite.client.plugins.randall.http.handlers.npc.NPCHandler;
import net.runelite.client.plugins.randall.http.handlers.object.ObjectHandler;
import net.runelite.client.plugins.randall.http.handlers.paint.PaintHandler;
import net.runelite.client.plugins.randall.http.handlers.player.PlayerHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;


public class ContextServer {

    private final Client client;
    public com.sun.net.httpserver.HttpServer server;
    private final RandallPlugin plugin;


    public ContextServer(Client client, RandallPlugin plugin) {
        this.client = client;
        this.plugin = plugin;
    }

    public void startUp() throws Exception {
        server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8888), 0);
        server.createContext("/game/", new GameHandler(client, plugin.worldService));
        server.createContext("/player/", new PlayerHandler(plugin, client));
        server.createContext("/npc/", new NPCHandler(client));
        server.createContext("/object/", new ObjectHandler(client));
        server.createContext("/message/", new MessageHandler(client));
        server.createContext("/paint/", new PaintHandler(plugin));
        server.createContext("/input/", new InputHandler(plugin));
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.start();
    }

    public void shutDown() throws Exception {
        server.stop(1);
    }
}
