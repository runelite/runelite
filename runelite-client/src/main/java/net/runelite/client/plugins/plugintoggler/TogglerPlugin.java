/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Abexlry <abexlry@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.plugintoggler;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.Text;
import net.runelite.client.util.WildcardMatcher;

import javax.inject.Inject;
import java.util.List;

@PluginDescriptor(
        name = "Toggle plugins",
        description = "Bind stopping/starting plugins to a keybind",
        tags = {"plugin", "keybind", "shortcut", "activate", "stop", "toggle"},
        enabledByDefault = true
)
public class TogglerPlugin extends Plugin {
    @Inject
    private KeyManager keyManager;

    @Inject
    private PluginManager pluginManager;

    @Inject
    private TogglerConfig config;

    private HotkeyListener hotkeyListener;
    private List<String> pluginFilters;

    @Provides
    TogglerConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(TogglerConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        pluginFilters = Text.fromCSV(config.getPluginsToToggle());
        hotkeyListener = new HotkeyListener(() -> config.hotkey()) {


            @Override
            public void hotkeyPressed() {
                togglePlugins();
            }

        };
        keyManager.registerKeyListener(hotkeyListener);
    }

    @Override
    protected void shutDown() throws Exception {
        keyManager.unregisterKeyListener(hotkeyListener);
    }


    @Subscribe
    public void onConfigChanged(ConfigChanged configChanged) {
        if (configChanged.getGroup().equals("toggler")) {
            try {
                shutDown();
                startUp();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void togglePlugins() {
        pluginManager.getPlugins().stream()
                .filter(
                        (Plugin plugin) -> {
                            String pluginName = plugin.getClass().getSimpleName().toLowerCase();
                            return shouldToggle(pluginName);
                        })
                .forEach(plugin -> {
                    try {
                        if (pluginManager.isPluginEnabled(plugin)) {
                            pluginManager.setPluginEnabled(plugin, false);
                            pluginManager.stopPlugin(plugin);
                        } else {
                            pluginManager.setPluginEnabled(plugin, true);
                            pluginManager.startPlugin(plugin);
                        }
                    } catch (PluginInstantiationException e) {
                        e.printStackTrace();
                    }
                });
    }

    private boolean shouldToggle(String pluginName) {
        return pluginFilters
                .stream()
                .anyMatch(filter -> WildcardMatcher.matches(filter, pluginName));
    }

}
