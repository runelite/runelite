/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JPanel;
import net.runelite.api.Client;
import net.runelite.client.ClientLoader;
import net.runelite.client.RuneLite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ClientPanel extends JPanel implements ComponentListener
{
	private static final Logger logger = LoggerFactory.getLogger(ClientPanel.class);
	
	public static final int PANEL_WIDTH = 765, PANEL_HEIGHT = 503;
	
	private Applet rs;

	public ClientPanel() throws Exception
	{
		setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setBackground(Color.black);
		this.addComponentListener(this);

		ClientLoader loader = new ClientLoader();

		rs = loader.load();
		rs.setSize(this.getSize());
		rs.init();
		rs.start();
		this.add(rs);

		Client client = null;
		try
		{
			client = new Client((net.runelite.rs.api.Client) rs);
		}
		catch (Exception ex)
		{
			logger.warn("Unable to create client", ex);
			System.exit(-1);
		}

		RuneLite.setClient(client);
	}

	@Override
	public void componentResized(ComponentEvent e)
	{
		rs.setSize(this.getSize());
		this.setPreferredSize(this.getSize());
		rs.setPreferredSize(this.getPreferredSize());
	}

	@Override
	public void componentMoved(ComponentEvent e)
	{
	}

	@Override
	public void componentShown(ComponentEvent e)
	{
	}

	@Override
	public void componentHidden(ComponentEvent e)
	{
	}
}