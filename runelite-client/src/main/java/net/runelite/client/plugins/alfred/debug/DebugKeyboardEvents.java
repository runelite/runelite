package net.runelite.client.plugins.alfred.debug;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DebugKeyboardEvents implements KeyListener {
//     public KeyEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) { super(source, id, when, modifiers);

    private void printEvent(KeyEvent e) {
        String eventIDVerbose = "None";
        switch (e.getID()) {
            case 400:
                eventIDVerbose = "KEY_TYPED";
                break;
            case 401:
                eventIDVerbose = "KEY_PRESSED";
                break;
            case 402:
                eventIDVerbose = "KEY_RELEASED";
                break;
            default:
                eventIDVerbose = Integer.toString(e.getID());
        }

        String eventLocationVerbose = "None";
        switch (e.getKeyLocation()) {
            case 0:
                eventLocationVerbose = "KEY_LOCATION_UNKNOWN";
                break;
            case 1:
                eventLocationVerbose = "KEY_LOCATION_STANDARD";
                break;
            case 2:
                eventLocationVerbose = "KEY_LOCATION_LEFT";
                break;
            case 3:
                eventLocationVerbose = "KEY_LOCATION_RIGHT";
                break;
            default:
                eventLocationVerbose = Integer.toString(e.getKeyLocation());
        }

        System.out.printf("Event Type: %s%n", e.getID());
        System.out.printf("Event Type Verbose: %s%n", eventIDVerbose);
        System.out.printf("When: %d%n", e.getWhen());
        System.out.printf("Modifiers: %d%n", e.getModifiersEx());
        System.out.printf("KeyCode: %d%n", e.getKeyCode());
        System.out.printf("Char: %s%n", e.getKeyChar());
        System.out.printf("Location: %d%n", e.getKeyLocation());
        System.out.printf("Location Verbose: %s%n", eventLocationVerbose);
        System.out.println();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        printEvent(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        printEvent(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        printEvent(e);
    }
}
