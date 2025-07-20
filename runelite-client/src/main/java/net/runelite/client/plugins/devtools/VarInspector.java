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
import com.google.inject.Inject;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.IndexDataBase;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.VarbitComposition;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;

@Slf4j
class VarInspector extends DevToolsFrame
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
	private static final Map<Integer, String> VARBIT_NAMES = DevToolsPlugin.loadFieldNames(VarbitID.class);
	private static final Map<Integer, String> VARCINT_NAMES = DevToolsPlugin.loadFieldNames(VarClientInt.class);
	private static final Map<Integer, String> VARCSTR_NAMES = DevToolsPlugin.loadFieldNames(VarClientStr.class);
	private static final Map<Integer, String> VARP_NAMES = DevToolsPlugin.loadFieldNames(VarPlayerID.class);

	private final Client client;
	private final ClientThread clientThread;
	private final EventBus eventBus;

	private final JPanel tracker = new JPanel();

	private int lastTick = 0;

	private int[] oldVarps = null;
	private int[] oldVarps2 = null;

	private Multimap<Integer, Integer> varbits;
	private Map<Integer, Object> varcs = null;

	@Inject
	VarInspector(Client client, ClientThread clientThread, EventBus eventBus)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.eventBus = eventBus;

		setTitle("RuneLite Var Inspector");

		setLayout(new BorderLayout());

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
			if (tick != lastTick)
			{
				lastTick = tick;
				JLabel header = new JLabel("Tick " + tick);
				header.setFont(FontManager.getRunescapeSmallFont());
				header.setBorder(new CompoundBorder(
					BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.LIGHT_GRAY_COLOR),
					BorderFactory.createEmptyBorder(3, 6, 0, 0)
				));
				tracker.add(header);
			}
			tracker.add(new JLabel(String.format("%s %s changed: %s -> %s", type.getName(), name, old, neew)));

			// Cull very old stuff
			while (tracker.getComponentCount() > MAX_LOG_ENTRIES)
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

				final String name = VARBIT_NAMES.getOrDefault(i, Integer.toString(i));
				addVarLog(VarType.VARBIT, name, old, neew);
			}
		}

		// Check varps
		int old = oldVarps2[index];
		int neew = varps[index];
		if (old != neew)
		{
			String name = VARP_NAMES.get(index);
			if (name != null)
			{
				name += "(" + index + ")";
			}
			else
			{
				name = Integer.toString(index);
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
			final String name = VARCINT_NAMES.getOrDefault(idx, Integer.toString(idx));
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
			final String name = VARCSTR_NAMES.getOrDefault(idx, Integer.toString(idx));
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

	@Override
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
		super.open();
	}

	@Override
	public void close()
	{
		super.close();
		tracker.removeAll();
		eventBus.unregister(this);
		varcs = null;
		varbits = null;
	}
}
