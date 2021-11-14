package net.runelite.client.plugins.worldhopper;

import java.util.Map;
import javax.inject.Singleton;
import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;

@Singleton
public class WorldHopperServiceImpl implements WorldHopperService
{
    private final WorldHopperPlugin plugin;

	@Inject
	private Client client;

	@Inject
	private WorldHopperConfig config;

    @Inject
    WorldHopperServiceImpl(WorldHopperPlugin plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public int getCurrentPing()
    {
        if (!config.displayPing() || client.getGameState() != GameState.LOGGED_IN)
        {
            return -1;
        }
        return plugin.getCurrentPing();
    }

    @Override
    public int getCurrentWorld()
    {
        return plugin.getCurrentWorld();
    }

    @Override
    public int getLastWorld()
    {
        return plugin.getLastWorld();
    }

    @Override
    public Map<Integer, Integer> getStoredPings()
    {
        return plugin.getStoredPings();
    }

    @Override
    public int getStoredPing(int world)
    {
        return plugin.getStoredPings().get(world);
    }
}
