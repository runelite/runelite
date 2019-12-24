/*
 * Copyright (c) 2019 Abex
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

import java.awt.CardLayout;

public class MultiplexingPluginPanel extends PluginPanel
{
	private final CardLayout layout;
	private boolean active = false;
	private PluginPanel current;

	public MultiplexingPluginPanel(PluginPanel root)
	{
		super(false);

		layout = new CardLayout();
		setLayout(layout);
		pushState(root);
	}

	public void destroy()
	{
		for (int i = getComponentCount() - 1; i > 0; i--)
		{
			onRemove((PluginPanel) getComponent(i));
			remove(i);
		}
	}

	public void pushState(PluginPanel subpanel)
	{
		int index = -1;
		for (int i = getComponentCount() - 1; i >= 0; i--)
		{
			if (getComponent(i) == subpanel)
			{
				index = i;
				break;
			}
		}

		if (active)
		{
			current.onDeactivate();
			subpanel.onActivate();
		}
		current = subpanel;

		String name = System.identityHashCode(subpanel) + "";

		if (index != -1)
		{
			for (int i = getComponentCount() - 1; i > index; i--)
			{
				popState();
			}
		}
		else
		{
			add(subpanel, name);
			onAdd(subpanel);
		}

		layout.show(this, name);
		revalidate();
	}

	public void popState()
	{
		int count = getComponentCount();
		if (count <= 1)
		{
			assert false : "Cannot pop last component";
			return;
		}

		PluginPanel subpanel = (PluginPanel) getComponent(count - 2);
		if (active)
		{
			current.onDeactivate();
			subpanel.onActivate();
			current = subpanel;
		}
		layout.show(this, System.identityHashCode(subpanel) + "");
		onRemove((PluginPanel) getComponent(count - 1));
		remove(count - 1);
		revalidate();
	}

	protected void onAdd(PluginPanel p)
	{
	}

	protected void onRemove(PluginPanel p)
	{
	}

	@Override
	public void onActivate()
	{
		active = true;
		current.onActivate();
	}

	@Override
	public void onDeactivate()
	{
		active = false;
		current.onDeactivate();
	}
}
