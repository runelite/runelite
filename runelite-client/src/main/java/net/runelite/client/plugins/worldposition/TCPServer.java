package net.runelite.client.plugins.worldposition;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

import lombok.Setter;
import net.runelite.api.coords.WorldPoint;

public class TCPServer implements Runnable {

    private final ServerSocket serverSocket;
    private boolean running = false;

    private WorldPoint position;

    public TCPServer() throws IOException {
        this.serverSocket = new ServerSocket(43594);
        this.running = true;
        System.out.println("Starting server on port " + 43594 + "...");
    }

    @Override
    public void run() {

            while (true) {
                try {
                System.out.println("Listening for new TCP client connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Received TCP client connection...");
                while (socket.isConnected()) {
                    if (position != null) {
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        //WorldPoint cPos = positionQueue.take();
                        System.out.println("Writing data to socket output stream -> " + String.format("%d,%d", position.getX(), position.getY()));
                        byte[] data = new String(String.format("%d,%d", position.getX(), position.getY())).getBytes();
                        //out.writeInt(data.length);
                        out.write(data);
                    }
                    Thread.sleep(100);
                }

            } catch(IOException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }

    public void setPosition(WorldPoint position){
        this.position = position;
    }

    /*
    public void addPosition(WorldPoint p) {
        positionQueue.add(p);
    }
*/
}