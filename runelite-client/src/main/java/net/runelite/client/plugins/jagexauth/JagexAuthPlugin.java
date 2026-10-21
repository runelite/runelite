/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
 * Copyright (c) 2026, LlemonDuck <napkinorton@gmail.com>
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
package net.runelite.client.plugins.jagexauth;

import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.rs.auth.JagexAuthService;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Jagex Auth",
	description = "Jagex Account integration",
	developerPlugin = true,
	hidden = true
)
@Slf4j
public class JagexAuthPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private JagexAuthService jagexAuthService;

	private NavigationButton navButton;

	@Override
	protected void startUp()
	{
		JagexAuthPanel panel = injector.getInstance(JagexAuthPanel.class);

		navButton = NavigationButton.builder()
			.tooltip("Jagex Accounts")
			.icon(ImageUtil.loadImageResource(getClass(), "icon.png"))
			.priority(2)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		jagexAuthService.loadFromStore()
			.thenRun(() -> SwingUtilities.invokeLater(panel::rebuild));
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
	}
}
