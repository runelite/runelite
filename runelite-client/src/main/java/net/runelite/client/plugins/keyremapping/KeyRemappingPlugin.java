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
package net.runelite.client.plugins.keyremapping;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.ChatboxInputManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Key Remapping",
	description = "Allows use of WASD keys for camera movement with press-to-chat, and remapping number keys to F-keys",
	tags = {"enter", "chat", "wasd", "camera"},
	enabledByDefault = false
)
public class KeyRemappingPlugin extends Plugin
{
	@Inject
	private KeyManager keyManager;

	@Inject
	private KeyRemappingListener inputListener;

	@Inject
	private ChatboxInputManager chatboxInputManager;

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(inputListener);
		chatboxInputManager.setKeyRemappingPluginEnabled(true);
	}

	@Override
	protected void shutDown() throws Exception
	{
		chatboxInputManager.setKeyRemappingPluginEnabled(false);
		keyManager.unregisterKeyListener(inputListener);
	}

	@Provides
	KeyRemappingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KeyRemappingConfig.class);
	}
}
