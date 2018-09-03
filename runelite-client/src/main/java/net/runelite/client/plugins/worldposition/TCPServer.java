package net.runelite.client.plugins.worldposition;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import net.runelite.api.coords.WorldPoint;

public class TCPServer implements Runnable {

    private final ServerSocket serverSocket;
    private final WorldPositionPlugin plugin;
    private boolean running = false;

    private LinkedBlockingQueue<WorldPoint> positionQueue = new LinkedBlockingQueue<>();

    public TCPServer(WorldPositionPlugin plugin) throws IOException {
        this.serverSocket = new ServerSocket(43594);
        this.plugin = plugin;
        this.running = true;
        System.out.println("Starting server on port " + 43594 + "...");
    }

    @Override
    public void run() {
        try {
            System.out.println("Listening for new TCP client connection...");
            final Socket socket = serverSocket.accept();
            System.out.println("Received TCP client connection...");
            while (running) {
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                WorldPoint cPos = positionQueue.take();
                System.out.println("Writing data to socket output stream -> " + String.format("%d,%d", cPos.getX(), cPos.getY()));
                byte[] data = new String(String.format("%d,%d", cPos.getX(), cPos.getY())).getBytes();
                out.writeInt(data.length);
                out.write(data);
                Thread.sleep(600);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        running = false;
    }

    public void addPosition(WorldPoint p) {
        positionQueue.add(p);
    }

}