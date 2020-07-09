package net.runelite.api;

import net.runelite.api.hooks.DrawCallbacks;
import java.awt.Canvas;
import net.runelite.api.hooks.DrawCallbacks;

/**
 * Represents the client game engine.
 */
public interface GameShell
{
    /**
     * Gets the canvas that contains everything.
     *
     * @return the game canvas
     */
    Canvas getCanvas();

    /**
     * Gets the client main thread.
     *
     * @return the main thread
     */
    Thread getClientThread();

    /**
     * Checks whether this code is executing on the client main thread.
     *
     * @return true if on the main thread, false otherwise
     */
    boolean isClientThread();

    DrawCallbacks getDrawCallbacks();

    void resizeCanvas();

    void setReplaceCanvasNextFrame(boolean replace);
}