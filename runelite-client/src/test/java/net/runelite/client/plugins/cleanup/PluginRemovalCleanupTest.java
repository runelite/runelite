package net.runelite.client.plugins.cleanup;

import java.lang.reflect.Field;
import java.time.temporal.ChronoUnit;
import javax.swing.SwingUtilities;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.EventBus.Subscriber;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.task.Schedule;
import net.runelite.client.task.Scheduler;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import net.runelite.client.config.ConfigManager;
import com.google.common.collect.ImmutableMultimap;

public class PluginRemovalCleanupTest
{
    private EventBus eventBus;
    private Scheduler scheduler;
    private PluginManager pluginManager;

    @Before
    public void setup()
    {
        eventBus = new EventBus();
        scheduler = new Scheduler();
        ConfigManager configManager = Mockito.mock(ConfigManager.class);
        pluginManager = new PluginManager(false, false, eventBus, scheduler, configManager, () -> null);
    }

    @PluginDescriptor(name = "Test")
    private static class TestPlugin extends Plugin
    {
        @Subscribe
        public void onProfileChanged(ProfileChanged evt)
        {
        }

        @Schedule(period = 1, unit = ChronoUnit.SECONDS)
        public void tick()
        {
        }
    }

    @Test
    public void testRemovalCleansSubscriptionsAndSchedules() throws Exception
    {
        TestPlugin plugin = new TestPlugin();
        pluginManager.add(plugin);
        SwingUtilities.invokeAndWait(() ->
        {
            try
            {
                pluginManager.startPlugin(plugin);
            }
            catch (PluginInstantiationException e)
            {
                throw new RuntimeException(e);
            }
        });
        SwingUtilities.invokeAndWait(() ->
        {
            try
            {
                pluginManager.stopPlugin(plugin);
            }
            catch (PluginInstantiationException e)
            {
                throw new RuntimeException(e);
            }
        });
        pluginManager.remove(plugin);

        // Scheduler should have no tasks for plugin
        assertTrue(scheduler.getScheduledMethods().stream().noneMatch(m -> m.getObject() == plugin));

        // EventBus should have no subscribers for plugin
        Field f = EventBus.class.getDeclaredField("subscribers");
        f.setAccessible(true);
        ImmutableMultimap<?, Subscriber> subs = (ImmutableMultimap<?, Subscriber>) f.get(eventBus);
        assertTrue(subs.values().stream().noneMatch(s -> s.getObject() == plugin));
    }
}
