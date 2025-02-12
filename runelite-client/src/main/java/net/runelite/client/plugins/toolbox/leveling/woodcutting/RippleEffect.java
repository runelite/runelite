package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RippleEffect {
    private final List<Ripple> ripples = new ArrayList<>();

    // Add a new ripple at the click position
    public void addRipple(Point clickPoint) {
        ripples.add(new Ripple(clickPoint));
    }

    // Update the ripples (expand them and fade them over time)
    public void update(Graphics2D g) {
        long currentTime = System.currentTimeMillis();
        for (Ripple ripple : ripples) {
            ripple.update(currentTime);
            drawRipple(g, ripple);
        }

        // Remove ripples that have fully faded
        ripples.removeIf(ripple -> ripple.getAlpha() <= 0);
    }

    // Render the ripple effect
    private void drawRipple(Graphics2D g, Ripple ripple) {
        float alpha = ripple.getAlpha();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        g.setColor(new Color(255, 255, 255, (int) (alpha * 255))); // White color with alpha transparency
        int radius = ripple.getRadius();
        g.fillOval(ripple.getX() - radius, ripple.getY() - radius, radius * 2, radius * 2);
    }

    // Inner class representing a single ripple
    private class Ripple {
        private final Point point;
        private long startTime;
        private int radius = 0;
        private float alpha = 1.0f;

        public Ripple(Point point) {
            this.point = point;
            this.startTime = System.currentTimeMillis();
        }

        public void update(long currentTime) {
            long elapsedTime = currentTime - startTime;
            radius = (int) (elapsedTime / 10); // Control speed of expansion (radius grows over time)
            alpha = 1.0f - (elapsedTime / 500f); // Fade effect (alpha reduces over time)

            if (alpha < 0) {
                alpha = 0;
            }
        }

        public int getX() {
            return point.x;
        }

        public int getY() {
            return point.y;
        }

        public int getRadius() {
            return radius;
        }

        public float getAlpha() {
            return alpha;
        }
    }
}

