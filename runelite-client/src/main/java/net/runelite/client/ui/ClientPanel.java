/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JPanel;
import net.runelite.api.Client;
import net.runelite.client.ClientLoader;
import net.runelite.client.RuneLite;
import net.runelite.http.api.updatecheck.UpdateCheckClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ClientPanel extends JPanel
{
	private static final Logger logger = LoggerFactory.getLogger(ClientPanel.class);

	public static final int PANEL_WIDTH = 765, PANEL_HEIGHT = 503;

	private Applet rs;

	public ClientPanel()
	{
		setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setLayout(new BorderLayout());
		setBackground(Color.black);
	}

	public void loadRs() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		ClientLoader loader = new ClientLoader();

		UpdateCheckClient updateCheck = new UpdateCheckClient();
		boolean isOutdated = updateCheck.isOutdated();
		if (isOutdated)
		{
			logger.info("Runelite is outdated - fetching vanilla client");
			rs = loader.loadVanilla();
		}
		else
		{
			logger.debug("Runelite is up to date");
			rs = loader.loadRunelite();
		}

		rs.setLayout(null);
		rs.setSize(PANEL_WIDTH, PANEL_HEIGHT);

		rs.init();
		rs.start();

		add(rs, BorderLayout.CENTER);

		if (isOutdated)
		{
			return;
		}

		if (!(rs instanceof Client))
		{
			logger.error("Injected client does not implement Client!");
			System.exit(-1);
		}

		Client client = (Client) rs;

		RuneLite.setClient(client);

		// This causes the whole game frame to be redrawn each frame instead
		// of only the viewport, so we can hook to MainBufferProvider#draw
		// and draw anywhere without it leaving artifacts
		client.setGameDrawingMode(2);
	}

}
