package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.config.ConfigManager;
import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.time.Instant;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class AlderRiseOverlay extends OverlayPanel {

    private Point _point;
    private int _last_delay = 0;
    private Instant _last_update_time;
    private AlderRisePlugin plugin;
    private ExecutorService executorService;

    private JFrame _frame = new JFrame("AlderRiseOverlay");

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    AlderRiseOverlay(AlderRisePlugin plugin) {
        super(plugin);
        setPosition(OverlayPosition.DYNAMIC);
        this.plugin = plugin;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Provides
    AlderRiseConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(AlderRiseConfig.class);
    }

    @Override
    public Dimension render(Graphics2D graphics) {

        if (_point == null)
        {
            return null;  // No mouse location to render
        }
        // Draw a red circle where the virtual mouse is located
        graphics.setColor(Color.RED);
        graphics.fillOval(_point.x - 5, _point.y - 5, 10, 10); // Adjust size

        // Optional: Render the coordinates as text next to the mouse
        String mousePositionText = String.format("Mouse: (%d, %d)", _point.x, _point.y);
        graphics.setColor(Color.WHITE);
        graphics.drawString(mousePositionText, _point.x + 10, _point.y); // Draw text near mouse
        return null;
    }

    public void setup(){
        CompletableFuture.runAsync(this::initMouseListenerAsync);
    }

    // Initialize the MouseListener asynchronously
    private void initMouseListenerAsync() {

        try {
            var canvas = client.getCanvas();
            canvas.setFocusable(true);

            executorService.submit(() -> {
                var _mouse_motion_adapter = new MouseMotionAdapter(){
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        // Update mouse position whenever it moves over the canvas
                        _point = e.getPoint();
                        System.out.println("Mouse Position: " + _point);
                    }
                };

                canvas.addMouseMotionListener(_mouse_motion_adapter);

                // This will run asynchronously on a separate thread
                canvas.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        // Update mouse position whenever it moves over the canvas
                        _point = e.getPoint();
                        log.info("Mouse Position: " + _point);
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        log.info("Mouse Clicked at: " + e.getPoint());
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        log.info("Mouse Entered Canvas at: " + e.getPoint());
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        log.info("Mouse Exited Canvas at: " + e.getPoint());
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        log.info("Mouse Pressed at: " + e.getPoint());
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        log.info("Mouse Released at: " + e.getPoint());
                    }
                });
            });

            // Set the layout manager of the frame to null for absolute positioning
            _frame.setLayout(null);

            // Get the Canvas dimensions and position
            Point canvasLocation = canvas.getLocationOnScreen();  // Get the top-left corner location
            Dimension canvasSize = canvas.getSize();

            // Optionally print the current canvas details for debugging
            System.out.println("Canvas Location: " + canvasLocation);
            System.out.println("Canvas Size: " + canvasSize);

            // Set the frame size to be at least as big as the canvas size
            _frame.setSize(canvasSize.width, canvasSize.height);

            // Optionally set the frame to be positioned at the same place as the Canvas
            _frame.setLocation(canvasLocation);

            _frame.add(canvas);

            // Ensure the frame is big enough and make it visible
            _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            _frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}