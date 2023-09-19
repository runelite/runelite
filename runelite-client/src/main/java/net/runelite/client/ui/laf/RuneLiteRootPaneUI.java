/*
 * Copyright (c) 2023 Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.laf;

import com.formdev.flatlaf.ui.FlatRootPaneUI;
import java.beans.PropertyChangeEvent;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class RuneLiteRootPaneUI extends FlatRootPaneUI
{
	public static final String PROP_RUNELITE_TITLEBAR = "runelite.titleBar";

	public static ComponentUI createUI(JComponent c)
	{
		return new RuneLiteRootPaneUI();
	}

	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		super.propertyChange(e);

		if (e.getPropertyName().equals(PROP_RUNELITE_TITLEBAR))
		{
			boolean titleBar = rootPane.getClientProperty(PROP_RUNELITE_TITLEBAR) == Boolean.TRUE;
			if (!titleBar)
			{
				throw new IllegalStateException();
			}

			setTitlePane(createTitlePane());

			rootPane.setLayout(createRootLayout());
		}
	}
}
