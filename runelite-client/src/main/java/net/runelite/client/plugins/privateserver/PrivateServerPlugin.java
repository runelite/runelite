/*
 * Copyright (c) 2019, xperiaclash <https://github.com/xperiaclash>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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
package net.runelite.client.plugins.privateserver;

import com.google.inject.Provides;
import java.math.BigInteger;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.StringFileUtils;

@PluginDescriptor(
	name = "Private Server",
	description = "Settings for connecting to non official servers",
	tags = {"RSPS", "Server", "Private"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
@Slf4j
public class PrivateServerPlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private PrivateServerConfig config;
	@Inject
	private EventBus eventBus;

	@Provides
	PrivateServerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PrivateServerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		if (RuneLite.allowPrivateServer)
		{
			updateConfig();
			addSubscriptions();
		}
		else
		{
			client.setModulus(new BigInteger("83ff79a3e258b99ead1a70e1049883e78e513c4cdec538d8da9483879a9f81689c0c7d146d7b82b52d05cf26132b1cda5930eeef894e4ccf3d41eebc3aabe54598c4ca48eb5a31d736bfeea17875a35558b9e3fcd4aebe2a9cc970312a477771b36e173dc2ece6001ab895c553e2770de40073ea278026f36961c94428d8d7db", 16));
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		if (RuneLite.allowPrivateServer)
		{
			eventBus.unregister(this);
		}
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("privateserver") && event.getKey().equals("modulus"))
		{
			client.setModulus(new BigInteger(config.modulus(), 16));
		}

		if (event.getGroup().equals("privateserver") && event.getKey().equals("codebase"))
		{
			StringFileUtils.writeStringToFile("./codebase", config.codebase());
			String message = "Client restart required after codebase change\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Restart required",
				JOptionPane.WARNING_MESSAGE);
		}
	}

	private void updateConfig()
	{
		if (!config.modulus().equals(""))
		{
			client.setModulus(new BigInteger(config.modulus(), 16));
		}
	}
}
