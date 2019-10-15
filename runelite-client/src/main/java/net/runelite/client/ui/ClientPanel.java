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
import java.awt.BorderLayout;
import java.awt.Color;
import javax.annotation.Nullable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.client.RuneLite;
import net.runelite.client.util.StringFileUtils;

final class ClientPanel extends JPanel
{
	ClientPanel(@Nullable Applet client)
	{
		setSize(Constants.GAME_FIXED_SIZE);
		setMinimumSize(Constants.GAME_FIXED_SIZE);
		setPreferredSize(Constants.GAME_FIXED_SIZE);
		setLayout(new BorderLayout());
		setBackground(Color.black);

		if (client == null)
		{
			return;
		}

		client.setLayout(null);
		client.setSize(Constants.GAME_FIXED_SIZE);

		try
		{
			client.init();
		}
		catch (Exception e)
		{
			String message = "Detected a bad codebase. Resetting...\n"
				+ "Please restart client.\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Bad Codebase",
				JOptionPane.ERROR_MESSAGE);
			StringFileUtils.writeStringToFile(RuneLite.RUNELITE_DIR + "/codebase", "http://127.0.0.1/");
			System.exit(0);
		}
		client.start();

		add(client, BorderLayout.CENTER);

		// This causes the whole game frame to be redrawn each frame instead
		// of only the viewport, so we can hook to MainBufferProvider#draw
		// and draw anywhere without it leaving artifacts
		if (client instanceof Client)
		{
			((Client) client).setGameDrawingMode(2);
		}
	}
}