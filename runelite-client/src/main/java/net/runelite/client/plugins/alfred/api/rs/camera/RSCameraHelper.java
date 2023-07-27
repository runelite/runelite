package net.runelite.client.plugins.alfred.api.rs.camera;

import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.event.KeyEvent;


public class RSCameraHelper {

    public RSCameraHelper() {
    }

    private int getDumbCameraAngle() {
        int cameraAngle = (int) Math.abs(Alfred.getClient().getCameraYaw() / 45.51 * 8);
        return (360 + cameraAngle) % 360;
    }

    private int getAngleBetweenPoints(WorldPoint point1, WorldPoint point2) {
        return (int) Math.toDegrees(Math.atan2(point1.getY() - point2.getY(), point1.getX() - point2.getX()));
    }

    private int getAngleDistance(int angle1, int angle2) {
        int distance = (angle1 - angle2);
        return (90 - distance) % 360;
    }

    private boolean isCameraAngleInRange(WorldPoint worldPoint, int range) {
        int cameraAngle = getDumbCameraAngle();
        int angleToLocation = getAngleBetweenPoints(Alfred.getClient().getLocalPlayer().getWorldLocation(), worldPoint);
        int distance = getAngleDistance(cameraAngle, angleToLocation);
        return Math.abs(distance) <= range;
    }

    private void internalLookAt(WorldPoint worldPoint) {
        int cameraAngle = getDumbCameraAngle();
        int angleToLocation = getAngleBetweenPoints(Alfred.getClient().getLocalPlayer().getWorldLocation(), worldPoint);
        int distance = getAngleDistance(cameraAngle, angleToLocation);

        boolean turnLeft = distance > 0 && distance < 180;

        if (turnLeft) {
            Alfred.getKeyboard().holdArrowKey(KeyEvent.VK_RIGHT);
            Alfred.sleepUntilExecution(() -> Alfred.getKeyboard().releaseArrowKey(KeyEvent.VK_RIGHT), () -> isCameraAngleInRange(worldPoint, 15), 10, 1000 * 30);
        } else {
            Alfred.getKeyboard().holdArrowKey(KeyEvent.VK_LEFT);
            Alfred.sleepUntilExecution(() -> Alfred.getKeyboard().releaseArrowKey(KeyEvent.VK_LEFT), () -> isCameraAngleInRange(worldPoint, 15), 10, 1000 * 30);
        }
    }

    public void lookAt(WorldPoint worldPoint) {
        internalLookAt(worldPoint);
    }
}