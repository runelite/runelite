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

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.slidinglayout.*;
import net.runelite.client.ui.tweenengine.*;
import net.runelite.client.ui.tweenengine.equations.Cubic;
import org.pushingpixels.substance.internal.ui.SubstanceRootPaneUI;

@Slf4j
public class ClientUI extends JFrame
{
	private static final int PANEL_WIDTH = 809;
	private static final int PANEL_HEIGHT = 536;
	private static final int EXPANDED_WIDTH = PANEL_WIDTH + PluginPanel.PANEL_WIDTH;
	private static final float FILL_SPACE = 1f;

	private int prevBtnIndex = -1;

	private final RuneLite runelite;
	private SLPanel container;
	private SLConfig containerCfg;
	private ClientPanel clientPanel;
	private PluginToolbar pluginToolbar;
	private PluginPanel pluginPanel;

	private TweenManager tweenManager;

	public ClientUI(RuneLite runelite)
	{
		this.runelite = runelite;
		init();
		pack();
		TitleBarPane titleBarPane = new TitleBarPane(this.getRootPane(), (SubstanceRootPaneUI) this.getRootPane().getUI());
		titleBarPane.editTitleBar(this);
		setTitle("RuneLite");
		setIconImage(RuneLite.ICON);
		setLocationRelativeTo(getOwner());
		setResizable(true);
		setVisible(true);
	}

	private void init()
	{
		assert SwingUtilities.isEventDispatchThread();

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				checkExit();
			}
		});

		container = new SLPanel();
		add(container);

		clientPanel = new ClientPanel(this);
		if (!RuneLite.getOptions().has("no-rs"))
		{
			try
			{
				clientPanel.loadRs();
			}
			catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException ex)
			{
				log.error("Error loading RS!", ex);
				System.exit(-1);
			}
		}

		pluginToolbar = new PluginToolbar(this);

		containerCfg = new SLConfig(container)
			.row(FILL_SPACE).col(FILL_SPACE).col(PluginToolbar.TOOLBAR_WIDTH)
			.place(0, 0, clientPanel)
			.place(0, 1, pluginToolbar);

		tweenManager = SLAnimator.createTweenManager();
		container.setTweenManager(tweenManager);
		container.initialize(containerCfg);
	}

	void expand(PluginPanel panel, int btnIndex)
	{
		SLConfig pluginCfg = new SLConfig(container)
			.row(FILL_SPACE).col(FILL_SPACE).col(PluginPanel.PANEL_WIDTH).col(PluginToolbar.TOOLBAR_WIDTH)
			.place(0, 0, clientPanel)
			.place(0, 1, panel)
			.place(0, 2, pluginToolbar);

		pluginToolbar.setActionsEnabled(false);

		if (pluginPanel != null)
		{
			if (prevBtnIndex > btnIndex)
			{
				container.createTransition()
					.push(new SLKeyframe(pluginCfg, 0.6f)
						.setStartSide(SLSide.TOP, panel)
						.setEndSide(SLSide.BOTTOM, pluginPanel)
						.setCallback(() -> pluginToolbar.setActionsEnabled(true)))
					.play();
			}
			else
			{
				container.createTransition()
					.push(new SLKeyframe(pluginCfg, 0.6f)
						.setStartSide(SLSide.BOTTOM, panel)
						.setEndSide(SLSide.TOP, pluginPanel)
						.setCallback(() -> pluginToolbar.setActionsEnabled(true)))
					.play();
			}
		}
		else if (getWidth() < EXPANDED_WIDTH)
		{
			Tween.to(this, SLAnimator.ComponentAccessor.W, 0.6f)
				.target(EXPANDED_WIDTH)
				.ease(Cubic.INOUT)
				.setCallback((type, source) ->
				{
					if (type == TweenCallback.COMPLETE)
					{
						container.createTransition()
							.push(new SLKeyframe(pluginCfg, 0.6f)
								.setStartSide(SLSide.RIGHT, panel)
								.setCallback(() -> pluginToolbar.setActionsEnabled(true)))
							.play();
					}
				}).start(tweenManager);
		}
		else
		{
			container.createTransition()
				.push(new SLKeyframe(pluginCfg, 0.6f)
					.setStartSide(SLSide.RIGHT, panel)
					.setCallback(() -> pluginToolbar.setActionsEnabled(true)))
				.play();
		}

		pluginPanel = panel;
		prevBtnIndex = btnIndex;
	}

	void contract()
	{
		pluginToolbar.setActionsEnabled(false);

		container.createTransition()
			.push(new SLKeyframe(containerCfg, 0.6f)
				.setEndSide(SLSide.RIGHT, pluginPanel)
				.setCallback(() ->
				{
					if (getWidth() == EXPANDED_WIDTH)
					{
						Tween.to(this, SLAnimator.ComponentAccessor.W, 0.6f)
							.target(PANEL_WIDTH)
							.ease(Cubic.INOUT)
							.setCallback((type, source) ->
							{
								if (type == TweenCallback.COMPLETE) pluginToolbar.setActionsEnabled(true);
							}).start(tweenManager);
					}
					else
					{
						pluginToolbar.setActionsEnabled(true);
					}
				}))
			.play();

		pluginPanel = null;
	}

	private void checkExit()
	{
		Client client = runelite.getClient();
		int result = JOptionPane.OK_OPTION;

		// only ask if not logged out
		if (client != null && client.getGameState() != GameState.LOGIN_SCREEN)
		{
			result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		}

		if (result == JOptionPane.OK_OPTION)
		{
			System.exit(0);
		}
	}

	public PluginToolbar getPluginToolbar()
	{
		return pluginToolbar;
	}

	public PluginPanel getPluginPanel()
	{
		return pluginPanel;
	}

	RuneLite getRunelite()
	{
		return runelite;
	}
}
