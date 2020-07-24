/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.devtools;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Ints;
import com.google.inject.Inject;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.IndexDataBase;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.VarPlayer;
import net.runelite.api.VarbitComposition;
import net.runelite.api.Varbits;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.util.SwingUtil;

@Slf4j
class VarInspector extends JFrame
{
	@Getter
	private enum VarType
	{
		VARBIT("Varbit"),
		VARP("VarPlayer"),
		VARCINT("VarClientInt"),
		VARCSTR("VarClientStr");

		private final String name;
		private final JCheckBox checkBox;

		VarType(String name)
		{
			this.name = name;
			checkBox = new JCheckBox(name, true);
		}
	}

	private final static int MAX_LOG_ENTRIES = 10_000;
	private static final int VARBITS_ARCHIVE_ID = 14;

	private final Client client;
	private final ClientThread clientThread;
	private final EventBus eventBus;

	private final JPanel tracker = new JPanel();
	private Pattern searchPattern = Pattern.compile("");

	private int lastTick = 0;
	private JLabel tickHeader;

	private int[] oldVarps = null;
	private int[] oldVarps2 = null;

	private Multimap<Integer, Integer> varbits;
	private Map<Integer, Object> varcs = null;

	@Inject
	VarInspector(Client client, ClientThread clientThread, EventBus eventBus, DevToolsPlugin plugin)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.eventBus = eventBus;

		setTitle("RuneLite Var Inspector");
		setIconImage(ClientUI.ICON);

		setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				close();
				plugin.getVarInspector().setActive(false);
			}
		});

		tracker.setLayout(new DynamicGridLayout(0, 1, 0, 3));

		final JPanel trackerWrapper = new JPanel();
		trackerWrapper.setLayout(new BorderLayout());
		trackerWrapper.add(tracker, BorderLayout.NORTH);

		final JScrollPane trackerScroller = new JScrollPane(trackerWrapper);
		trackerScroller.setPreferredSize(new Dimension(400, 400));

		final JScrollBar vertical = trackerScroller.getVerticalScrollBar();
		vertical.addAdjustmentListener(new AdjustmentListener()
		{
			int lastMaximum = actualMax();

			private int actualMax()
			{
				return vertical.getMaximum() - vertical.getModel().getExtent();
			}

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e)
			{
				if (vertical.getValue() >= lastMaximum)
				{
					vertical.setValue(actualMax());
				}
				lastMaximum = actualMax();
			}
		});

		add(trackerScroller, BorderLayout.CENTER);

		final JPanel trackerOpts = new JPanel();
		trackerOpts.setLayout(new FlowLayout());
		for (VarType cb : VarType.values())
		{
			trackerOpts.add(cb.getCheckBox());
		}

		final JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(e ->
		{
			tracker.removeAll();
			tracker.revalidate();
		});
		trackerOpts.add(clearBtn);

		add(trackerOpts, BorderLayout.SOUTH);

		pack();
		initSearchField(); // Init searchfield after pack because we base our location on trackbar
	}

	private void initSearchField()
	{
		IconTextField searchField = new IconTextField();
		searchField.setIcon(IconTextField.Icon.SEARCH);
		searchField.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchField.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchField.setBorder(new MatteBorder(0, 1, 1, 0, ColorScheme.MEDIUM_GRAY_COLOR));

		searchField.setText("."); // accommodate for the clear button in the base size
		Dimension baseSize = searchField.getPreferredSize();
		searchField.setText("");

		Runnable layoutSearchField = () ->
		{
			int textSize = searchField.getFontMetrics(searchField.getFont()).stringWidth(searchField.getText());
			int width = Ints.constrainToRange(baseSize.width + textSize, 75, tracker.getWidth());
			int x = SwingUtilities.convertPoint(tracker, new Point(tracker.getWidth(), 0), getLayeredPane()).x - width;
			searchField.setBounds(x, searchField.getY(), width, baseSize.height);
			searchField.revalidate();
		};
		getLayeredPane().addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent e)
			{
				layoutSearchField.run();
			}
		});
		getLayeredPane().add(searchField, JLayeredPane.POPUP_LAYER);
		layoutSearchField.run();

		searchField.getDocument().addDocumentListener(SwingUtil.documentListener(() -> {
			layoutSearchField.run();
			updateTrackWithSearchFilter(searchField.getText());
		}));
	}

	private void updateTrackWithSearchFilter(String searchText)
	{
		searchPattern = Pattern.compile(searchText);
		SwingUtilities.invokeLater(() ->
		{
			int lastComponentIdx = tracker.getComponentCount() - 1;
			for (int i = lastComponentIdx; i > 1; i--)
			{
				JLabel label = (JLabel) tracker.getComponent(i);
				String text = label.getText();
				if (text.startsWith("Tick"))
				{
					JLabel next = (JLabel) tracker.getComponent(i + 1); // Safe because tickHeader never comes alone
					label.setVisible(next.isVisible() && !next.getText().startsWith("Tick"));
				}
				else
				{
					label.setVisible(searchPattern.matcher(text).find());
				}
			}
		});
	}

	private void addVarLog(VarType type, String name, int old, int neew)
	{
		addVarLog(type, name, Integer.toString(old), Integer.toString(neew));
	}

	private void addVarLog(VarType type, String name, String old, String neew)
	{
		if (!type.getCheckBox().isSelected())
		{
			return;
		}

		int tick = client.getTickCount();
		SwingUtilities.invokeLater(() ->
		{
			String varChangeText = String.format("%s %s changed: %s -> %s", type.getName(), name, old, neew);
			boolean matchesSearchTerm = searchPattern.matcher(varChangeText).find();
			if (tick != lastTick)
			{
				lastTick = tick;
				tickHeader = new JLabel("Tick " + tick);
				tickHeader.setFont(FontManager.getRunescapeSmallFont());
				tickHeader.setBorder(new CompoundBorder(
						BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.LIGHT_GRAY_COLOR),
						BorderFactory.createEmptyBorder(3, 6, 0, 0)
				));
				tracker.add(tickHeader);
				tickHeader.setVisible(matchesSearchTerm);
			}
			else if (matchesSearchTerm && tickHeader != null)
			{
				tickHeader.setVisible(true);
			}
			JLabel varChangeLbl = new JLabel(varChangeText);
			varChangeLbl.setVisible(matchesSearchTerm);
			tracker.add(varChangeLbl);

			// Cull very old stuff
			for (; tracker.getComponentCount() > MAX_LOG_ENTRIES; )
			{
				tracker.remove(0);
			}

			tracker.revalidate();
		});
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		int index = varbitChanged.getIndex();
		int[] varps = client.getVarps();

		// Check varbits
		for (int i : varbits.get(index))
		{
			int old = client.getVarbitValue(oldVarps, i);
			int neew = client.getVarbitValue(varps, i);
			if (old != neew)
			{
				// Set the varbit so it doesn't show in the varp changes
				// However, some varbits share common bits, so we only do it in oldVarps2
				// Example: 4101 collides with 4104-4129
				client.setVarbitValue(oldVarps2, i, neew);

				String name = Integer.toString(i);
				for (Varbits varbit : Varbits.values())
				{
					if (varbit.getId() == i)
					{
						name = String.format("%s(%d)", varbit.name(), i);
						break;
					}
				}
				addVarLog(VarType.VARBIT, name, old, neew);
			}
		}

		// Check varps
		int old = oldVarps2[index];
		int neew = varps[index];
		if (old != neew)
		{
			String name = Integer.toString(index);
			for (VarPlayer varp : VarPlayer.values())
			{
				if (varp.getId() == index)
				{
					name = String.format("%s(%d)", varp.name(), index);
					break;
				}
			}
			addVarLog(VarType.VARP, name, old, neew);
		}

		System.arraycopy(client.getVarps(), 0, oldVarps, 0, oldVarps.length);
		System.arraycopy(client.getVarps(), 0, oldVarps2, 0, oldVarps2.length);
	}

	@Subscribe
	public void onVarClientIntChanged(VarClientIntChanged e)
	{
		int idx = e.getIndex();
		int neew = (Integer) client.getVarcMap().getOrDefault(idx, 0);
		int old = (Integer) varcs.getOrDefault(idx, 0);
		varcs.put(idx, neew);

		if (old != neew)
		{
			String name = String.format("%d", idx);
			for (VarClientInt varc : VarClientInt.values())
			{
				if (varc.getIndex() == idx)
				{
					name = String.format("%s(%d)", varc.name(), idx);
					break;
				}
			}
			addVarLog(VarType.VARCINT, name, old, neew);
		}
	}

	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged e)
	{
		int idx = e.getIndex();
		String neew = (String) client.getVarcMap().getOrDefault(idx, "");
		String old = (String) varcs.getOrDefault(idx, "");
		varcs.put(idx, neew);

		if (!Objects.equals(old, neew))
		{
			String name = String.format("%d", idx);
			for (VarClientStr varc : VarClientStr.values())
			{
				if (varc.getIndex() == idx)
				{
					name = String.format("%s(%d)", varc.name(), idx);
					break;
				}
			}
			if (old != null)
			{
				old = "\"" + old + "\"";
			}
			else
			{
				old = "null";
			}
			if (neew != null)
			{
				neew = "\"" + neew + "\"";
			}
			else
			{
				neew = "null";
			}
			addVarLog(VarType.VARCSTR, name, old, neew);
		}
	}

	public void open()
	{
		if (oldVarps == null)
		{
			oldVarps = new int[client.getVarps().length];
			oldVarps2 = new int[client.getVarps().length];
		}

		System.arraycopy(client.getVarps(), 0, oldVarps, 0, oldVarps.length);
		System.arraycopy(client.getVarps(), 0, oldVarps2, 0, oldVarps2.length);
		varcs = new HashMap<>(client.getVarcMap());
		varbits = HashMultimap.create();

		clientThread.invoke(() ->
		{
			// Build varp index -> varbit id map
			IndexDataBase indexVarbits = client.getIndexConfig();
			final int[] varbitIds = indexVarbits.getFileIds(VARBITS_ARCHIVE_ID);
			for (int id : varbitIds)
			{
				VarbitComposition varbit = client.getVarbit(id);
				if (varbit != null)
				{
					varbits.put(varbit.getIndex(), id);
				}
			}
		});

		eventBus.register(this);
		setVisible(true);
		toFront();
		repaint();
	}

	public void close()
	{
		tracker.removeAll();
		eventBus.unregister(this);
		setVisible(false);
		varcs = null;
		varbits = null;
	}
}
