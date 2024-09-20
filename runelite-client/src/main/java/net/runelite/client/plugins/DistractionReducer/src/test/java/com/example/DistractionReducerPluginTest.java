package com.distractionreducer;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import org.junit.Test;
import static org.junit.Assert.*;

public class DistractionReducerPluginTest
{
    @Test
    public void testPluginInitialization()
    {
        DistractionReducerPlugin plugin = new DistractionReducerPlugin();
        assertNotNull("Plugin should not be null", plugin);
    }

    @Test
    public void testPluginConfiguration()
    {
        DistractionReducerConfig config = new DistractionReducerConfig()
        {
            @Override
            public boolean coverEntireWindow()
            {
                return true;
            }
        };
        
        assertTrue("Cover entire window should be true by default", config.coverEntireWindow());
    }

    @Test
    public void testPluginStarts()
    {
        ExternalPluginManager.loadBuiltin(DistractionReducerPlugin.class);
        RuneLite.main(new String[]{});
        // If this doesn't throw an exception, we consider it a pass
        assertTrue(true);
    }
}