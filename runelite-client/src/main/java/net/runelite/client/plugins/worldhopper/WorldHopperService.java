package net.runelite.client.plugins.worldhopper;

import java.util.Map;

public interface WorldHopperService
{
    /**
     * Get the ping for the current world
     */
    int getCurrentPing();

    /**
     * Get the current world
     */
    int getCurrentWorld();

    /**
     * Get the previous world
     */
    int getLastWorld();

    /**
     * Get the list of stored world pings
     */
    Map<Integer, Integer> getStoredPings();

    /**
     * Get the stored ping for the world
     */
    int getStoredPing(int world);
}
