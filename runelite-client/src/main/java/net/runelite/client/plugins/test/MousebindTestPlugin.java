package net.runelite.client.plugins.test;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.*;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.keyremapping.KeyRemappingConfig;

@Slf4j
@PluginDescriptor(
        name = "Mousebind Test",
        description = "A test plugin to verify mousebind config support",
        tags = {"test", "mouse"}
)
public class MousebindTestPlugin extends Plugin
{
    @Provides
    MousebindTestConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(MousebindTestConfig.class);
    }

    @Override
    protected void startUp()
    {
        log.info("MousebindTestPlugin started");
    }

    @Override
    protected void shutDown()
    {
        log.info("MousebindTestPlugin stopped");
    }
}
