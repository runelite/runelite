package net.runelite.api;

import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

public interface Locatable
{
    /**
     * Gets the server-side location of the actor.
     * <p>
     * This value is typically ahead of where the client renders and is not
     * affected by things such as animations.
     *
     * @return the server location
     */
    WorldPoint getWorldLocation();

    /**
     * Gets the client-side location of the actor.
     *
     * @return the client location
     */
    LocalPoint getLocalLocation();
}