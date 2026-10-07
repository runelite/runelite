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
package net.runelite.client.plugins.config;

import com.google.common.base.Strings;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.html.HtmlEscapers;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.Config;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ExternalPluginsChanged;
import net.runelite.client.externalplugins.ExternalPluginClient;
import net.runelite.client.externalplugins.ExternalPluginManager;
import net.runelite.client.externalplugins.PluginHubManifest;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.VirtualList;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.SwingUtil;
import net.runelite.client.util.VerificationException;

@Slf4j
@Singleton
class PluginHubPanel extends PluginPanel
{
	private static final int LIST_BORDER = 7;
	private static final ImageIcon MISSING_ICON;
	private static final ImageIcon HELP_ICON;
	private static final ImageIcon CONFIGURE_ICON;
	private static final ImageIcon PLUGIN_UNAVAILABLE_ICON;
	private static final Pattern SPACES = Pattern.compile(" +");

	static
	{
		BufferedImage missingIcon = ImageUtil.loadImageResource(PluginHubPanel.class, "pluginhub_missingicon.png");
		MISSING_ICON = new ImageIcon(missingIcon);

		BufferedImage helpIcon = ImageUtil.loadImageResource(PluginHubPanel.class, "pluginhub_help.png");
		HELP_ICON = new ImageIcon(helpIcon);

		BufferedImage configureIcon = ImageUtil.loadImageResource(PluginHubPanel.class, "pluginhub_configure.png");
		CONFIGURE_ICON = new ImageIcon(configureIcon);

		PLUGIN_UNAVAILABLE_ICON = new ImageIcon(ImageUtil.loadImageResource(PluginHubPanel.class, "mdi_alert.png"));
	}

	private class PluginIcon extends JLabel
	{
		@Nullable
		private volatile PluginHubManifest.DisplayData manifest;
		private boolean queued;

		PluginIcon()
		{
			setIcon(MISSING_ICON);
		}

		void setManifest(PluginHubManifest.DisplayData manifest)
		{
			this.manifest = manifest.hasIcon() ? manifest : null;
			setIcon(MISSING_ICON);
			enqueue();
		}

		private void enqueue()
		{
			if (this.manifest != null)
			{
				synchronized (iconLoadQueue)
				{
					if (!this.queued)
					{
						this.queued = true;
						iconLoadQueue.add(this);
						if (iconLoadQueue.size() == 1)
						{
							executor.submit(PluginHubPanel.this::pumpIconQueue);
						}
					}
				}
			}
		}

		private boolean load()
		{
			var m = manifest;
			if (m == null)
			{
				return true;
			}

			try
			{
				BufferedImage img = externalPluginClient.downloadIcon(m);

				SwingUtilities.invokeLater(() ->
				{
					if (manifest == m)
					{
						setIcon(new ImageIcon(img));
					}
					else
					{
						enqueue();
					}
				});
			}
			catch (IOException e)
			{
				log.info("Cannot download icon for plugin \"{}\"", m.getInternalName(), e);
			}
			return false;
		}
	}

	private void pumpIconQueue()
	{
		PluginIcon pi;
		do
		{
			synchronized (iconLoadQueue)
			{
				pi = iconLoadQueue.poll();
				if (pi == null)
				{
					return;
				}

				pi.queued = false;
			}
		}
		while (pi.load());

		synchronized (iconLoadQueue)
		{
			if (iconLoadQueue.isEmpty())
			{
				return;
			}
		}

		// re add ourselves to the executor queue so we don't block the executor for a long time
		executor.submit(this::pumpIconQueue);
	}

	private class PluginItem implements SearchablePlugin
	{
		private final PluginHubManifest.DisplayData manifest;

		@Getter
		@Nullable
		private final PluginHubManifest.JarData jarData;

		private final Collection<Plugin> loadedPlugins;

		@Getter
		private final List<String> keywords = new ArrayList<>();

		@Getter
		private final int userCount;

		@Getter
		private final boolean installed;

		PluginItem(PluginHubManifest.DisplayData newManifest, PluginHubManifest.JarData jarData, Collection<Plugin> loadedPlugins, int userCount, boolean installed)
		{
			if (newManifest != null)
			{
				manifest = newManifest;
			}
			else
			{
				manifest = ExternalPluginManager.getDisplayData(loadedPlugins.iterator().next().getClass());
			}

			this.jarData = jarData;
			this.userCount = userCount;
			this.installed = installed;
			this.loadedPlugins = loadedPlugins;

			Collections.addAll(keywords, SPACES.split(manifest.getDisplayName().toLowerCase()));

			if (manifest.getDescription() != null)
			{
				Collections.addAll(keywords, SPACES.split(manifest.getDescription().toLowerCase()));
			}

			Collections.addAll(keywords, manifest.getAuthor().toLowerCase());

			if (manifest.getTags() != null)
			{
				Collections.addAll(keywords, manifest.getTags());
			}
		}

		@Override
		public String getSearchableName()
		{
			return manifest.getDisplayName();
		}

		@Override
		public int installs()
		{
			return userCount;
		}
	}

	private class PluginView extends JPanel
	{
		private static final int SEPARATOR = 5;
		private static final int HEIGHT = 86;
		private static final int ICON_WIDTH = 48;
		private static final int BOTTOM_LINE_HEIGHT = 16;

		private PluginItem item;

		private final JLabel pluginName = new JLabel();
		private final JLabel author = new JLabel();
		private final JLabel version = new JLabel();
		private final JLabel description = new JLabel();
		private final PluginIcon icon = new PluginIcon();
		private final JLabel badge = new JLabel();
		private final JButton configure = new JButton(CONFIGURE_ICON);
		private final JButton addrm = new JButton();

		ActionListener addrmListener;

		PluginView()
		{
			setBackground(ColorScheme.DARKER_GRAY_COLOR);
			setOpaque(true);

			GroupLayout layout = new GroupLayout(this);
			setLayout(layout);

			pluginName.setFont(FontManager.getRunescapeBoldFont());
			author.setFont(FontManager.getRunescapeSmallFont());
			version.setFont(FontManager.getRunescapeSmallFont());

			description.setVerticalAlignment(JLabel.TOP);

			icon.setHorizontalAlignment(JLabel.CENTER);

			JButton help = new JButton(HELP_ICON);
			SwingUtil.removeButtonDecorations(help);
			help.setBorder(null);
			help.setToolTipText("Open help");
			help.addActionListener(ev -> LinkBrowser.browse("https://runelite.net/plugin-hub/show/" + item.manifest.getInternalName()));

			SwingUtil.removeButtonDecorations(configure);
			configure.setToolTipText("Configure");
			configure.setBorder(null);
			configure.addActionListener(e ->
			{
				if (item.loadedPlugins.size() == 1)
				{
					Plugin plugin = item.loadedPlugins.iterator().next();
					Config cfg = pluginManager.getPluginConfigProxy(plugin);
					if (cfg != null)
					{
						topLevelConfigPanel.openConfigurationPanel(plugin);
						return;
					}
				}

				topLevelConfigPanel.openWithFilter(item.manifest.getInternalName());
			});

			addrm.setFocusPainted(false);
			addrm.addActionListener(ev -> addrmListener.actionPerformed(ev));

			layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
					.addComponent(badge, GroupLayout.Alignment.TRAILING)
					.addComponent(icon, ICON_WIDTH, ICON_WIDTH, ICON_WIDTH))
				.addGap(5)
				.addGroup(layout.createParallelGroup()
					.addGroup(layout.createSequentialGroup()
						.addComponent(pluginName, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
						.addComponent(author, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
					.addComponent(description, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
					.addGroup(layout.createSequentialGroup()
						.addComponent(version, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, 100)
						.addComponent(help, 0, 24, 24)
						.addComponent(configure, 0, 24, 24)
						.addComponent(addrm, 0, 57, GroupLayout.PREFERRED_SIZE)
						.addGap(5))));

			int lineHeight = description.getFontMetrics(description.getFont()).getHeight();
			layout.setVerticalGroup(layout.createParallelGroup()
				.addComponent(badge, GroupLayout.Alignment.TRAILING)
				.addComponent(icon, HEIGHT, GroupLayout.DEFAULT_SIZE, HEIGHT)
				.addGroup(layout.createSequentialGroup()
					.addGap(5)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(pluginName)
						.addComponent(author))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
					.addComponent(description, lineHeight, GroupLayout.PREFERRED_SIZE, lineHeight * 2)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(version, BOTTOM_LINE_HEIGHT, BOTTOM_LINE_HEIGHT, BOTTOM_LINE_HEIGHT)
						.addComponent(help, BOTTOM_LINE_HEIGHT, BOTTOM_LINE_HEIGHT, BOTTOM_LINE_HEIGHT)
						.addComponent(configure, BOTTOM_LINE_HEIGHT, BOTTOM_LINE_HEIGHT, BOTTOM_LINE_HEIGHT)
						.addComponent(addrm, BOTTOM_LINE_HEIGHT, BOTTOM_LINE_HEIGHT, BOTTOM_LINE_HEIGHT))
					.addGap(5)));
		}

		void setItem(PluginItem item)
		{
			this.item = item;
			var manifest = item.manifest;

			pluginName.setText(manifest.getDisplayName());
			pluginName.setToolTipText(manifest.getDisplayName());

			author.setText(manifest.getAuthor());
			author.setToolTipText(manifest.getAuthor());

			version.setText(manifest.getVersion());
			version.setToolTipText(manifest.getVersion());

			String descriptionText = manifest.getDescription();
			if (item.jarData == null)
			{
				if (!Strings.isNullOrEmpty(manifest.getUnavailableReason()))
				{
					descriptionText = manifest.getUnavailableReason();
				}
				else
				{
					descriptionText = "Plugin is incompatible, requires update by its author";
				}
			}
			if (descriptionText == null)
			{
				descriptionText = "";
			}
			if (!descriptionText.startsWith("<html>"))
			{
				descriptionText = "<html>" + HtmlEscapers.htmlEscaper().escape(descriptionText) + "</html>";
			}

			description.setText(descriptionText);
			description.setToolTipText(descriptionText);

			icon.setManifest(manifest);

			if (item.jarData == null)
			{
				badge.setIcon(PLUGIN_UNAVAILABLE_ICON);
				badge.setToolTipText(descriptionText);
			}
			else
			{
				badge.setIcon(null);
				badge.setToolTipText(null);
			}

			configure.setVisible(!item.loadedPlugins.isEmpty());

			boolean install = !item.installed && item.jarData != null;
			boolean update = item.jarData != null
				&& !item.loadedPlugins.isEmpty()
				&& !item.jarData.equals(ExternalPluginManager.getJarData(item.loadedPlugins.iterator().next().getClass()));
			boolean remove = item.installed && !update;
			if (install)
			{
				addrm.setText("Install");
				addrm.setBackground(new Color(0x28BE28));
				addrmListener = l ->
				{
					if (manifest.getWarning() != null)
					{
						int result = JOptionPane.showConfirmDialog(
							this,
							"<html><p>" + manifest.getWarning() + "</p><strong>Are you sure you want to install this plugin?</strong></html>",
							"Installing " + manifest.getDisplayName(),
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE);
						if (result != JOptionPane.OK_OPTION)
						{
							return;
						}
					}
					addrm.setText("Installing");
					addrm.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);
					externalPluginManager.install(manifest.getInternalName());
				};
			}
			else if (remove)
			{
				addrm.setText("Remove");
				addrm.setBackground(new Color(0xBE2828));
				addrmListener = l ->
				{
					addrm.setText("Removing");
					addrm.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);
					externalPluginManager.remove(manifest.getInternalName());
				};
			}
			else if (update)
			{
				addrm.setText("Update");
				addrm.setBackground(new Color(0x1F621F));
				addrmListener = l ->
				{
					addrm.setText("Updating");
					addrm.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);
					externalPluginManager.update();
				};
			}
			else
			{
				addrm.setText("Unavailable");
				addrm.setBackground(Color.GRAY);
				addrmListener = l ->
				{
				};
			}
			addrm.setBorder(new LineBorder(addrm.getBackground().darker()));
		}
	}

	private final TopLevelConfigPanel topLevelConfigPanel;
	private final ExternalPluginManager externalPluginManager;
	private final PluginManager pluginManager;
	private final ExternalPluginClient externalPluginClient;
	private final ScheduledExecutorService executor;

	private final Deque<PluginIcon> iconLoadQueue = new ArrayDeque<>();

	private final IconTextField searchBar;
	private final JPanel error = new JPanel();
	private final JLabel refreshing;
	private final VirtualList<PluginView, PluginItem> list = new VirtualList<>()
	{
		@Override
		protected int getIndexNearPosition(int y)
		{
			return y / (PluginView.HEIGHT + PluginView.SEPARATOR);
		}

		@Override
		protected Rectangle getItemPosition(int index)
		{
			return new Rectangle(LIST_BORDER, index * (PluginView.HEIGHT + PluginView.SEPARATOR), getWidth() - LIST_BORDER * 2, PluginView.HEIGHT);
		}

		@Override
		public PluginView createView(PluginView recycle, PluginItem item)
		{
			if (recycle == null)
			{
				recycle = new PluginView();
			}

			recycle.setItem(item);
			return recycle;
		}
	};
	private List<PluginItem> plugins = null;
	private PluginHubManifest.ManifestFull lastManifest;

	@Inject
	PluginHubPanel(
		TopLevelConfigPanel topLevelConfigPanel,
		ExternalPluginManager externalPluginManager,
		PluginManager pluginManager,
		ExternalPluginClient externalPluginClient,
		ScheduledExecutorService executor)
	{
		super(false);
		this.topLevelConfigPanel = topLevelConfigPanel;
		this.externalPluginManager = externalPluginManager;
		this.pluginManager = pluginManager;
		this.externalPluginClient = externalPluginClient;
		this.executor = executor;

		{
			Object refresh = "this could just be a lambda, but no, it has to be abstracted";
			getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), refresh);
			getActionMap().put(refresh, new AbstractAction()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					reloadPluginList();
				}
			});
		}

		setBackground(ColorScheme.DARK_GRAY_COLOR);

		searchBar = new IconTextField();
		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchBar.getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				executor.execute(PluginHubPanel.this::filter);
			}

			@Override
			public void removeUpdate(DocumentEvent e)
			{
				executor.execute(PluginHubPanel.this::filter);
			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				executor.execute(PluginHubPanel.this::filter);
			}
		});

		JLabel externalPluginWarning = new JLabel("<html>Plugin Hub plugins are provided by third parties not affiliated with RuneLite. " +
			"<u>Click here to learn more.</u></html>");
		externalPluginWarning.setBorder(new EmptyBorder(5, 5, 5, 5));
		externalPluginWarning.setOpaque(true);
		externalPluginWarning.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				LinkBrowser.browse("https://github.com/runelite/runelite/wiki/Plugin-Hub-Review");
			}
		});

		refreshing = new JLabel("Loading...");
		refreshing.setHorizontalAlignment(JLabel.CENTER);

		JPanel mainPanelWrapper = new FixedWidthPanel();
		mainPanelWrapper.setLayout(new BorderLayout());
		var northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		northPanel.add(refreshing);
		northPanel.add(error);
		mainPanelWrapper.add(northPanel, BorderLayout.NORTH);
		mainPanelWrapper.add(list, BorderLayout.CENTER);

		error.setVisible(false);
		error.setLayout(new DynamicGridLayout(0, 1));
		error.add(new JLabel("Downloading the plugin manifest failed"));
		JButton retry = new JButton("Retry");
		retry.addActionListener(l -> reloadPluginList());
		error.add(retry);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// Can't use Short.MAX_VALUE like the docs say because of JDK-8079640
		scrollPane.setPreferredSize(new Dimension(0x7000, 0x7000));
		scrollPane.setViewportView(mainPanelWrapper);

		{
			GroupLayout layout = new GroupLayout(this);
			setLayout(layout);

			layout.setVerticalGroup(layout.createSequentialGroup()
				.addGap(10)
				.addComponent(externalPluginWarning)
				.addGap(7)
				.addComponent(searchBar, 30, 30, 30)
				.addGap(10)
				.addComponent(scrollPane));

			layout.setHorizontalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(10)
					.addComponent(externalPluginWarning)
					.addGap(10))
				.addGroup(layout.createSequentialGroup()
					.addGap(10)
					.addComponent(searchBar)
					.addGap(10))
				.addComponent(scrollPane));
		}

		revalidate();

		refreshing.setVisible(false);
		reloadPluginList();
	}

	private void reloadPluginList()
	{
		if (refreshing.isVisible())
		{
			return;
		}

		refreshing.setVisible(true);
		error.setVisible(false);
		list.setModel(null);

		executor.submit(() ->
		{
			PluginHubManifest.ManifestFull manifest;
			try
			{
				manifest = externalPluginClient.downloadManifestFull();
			}
			catch (IOException | VerificationException e)
			{
				log.error("", e);
				SwingUtilities.invokeLater(() ->
				{
					refreshing.setVisible(false);
					error.setVisible(true);
				});
				return;
			}

			Map<String, Integer> pluginCounts = Collections.emptyMap();
			try
			{
				pluginCounts = externalPluginClient.getPluginCounts();
			}
			catch (IOException e)
			{
				log.warn("unable to download plugin counts", e);
			}

			reloadPluginList(manifest, pluginCounts);
		});
	}

	private void reloadPluginList(PluginHubManifest.ManifestFull manifest, Map<String, Integer> pluginCounts)
	{
		lastManifest = manifest;
		Map<String, PluginHubManifest.DisplayData> display = manifest.getDisplay().stream()
			.collect(ImmutableMap.toImmutableMap(PluginHubManifest.DisplayData::getInternalName, Function.identity()));
		Map<String, PluginHubManifest.JarData> jars = manifest.getJars().stream()
			.collect(ImmutableMap.toImmutableMap(PluginHubManifest.JarData::getInternalName, Function.identity()));

		Multimap<String, Plugin> loadedPlugins = HashMultimap.create();
		for (Plugin p : pluginManager.getPlugins())
		{
			Class<? extends Plugin> clazz = p.getClass();
			String iname = ExternalPluginManager.getInternalName(clazz);
			if (iname != null)
			{
				loadedPlugins.put(iname, p);
			}
		}

		Set<String> installed = new HashSet<>(externalPluginManager.getInstalledExternalPlugins());

		plugins = Sets.union(display.keySet(), loadedPlugins.keySet())
			.stream()
			.map(id -> new PluginItem(display.get(id), jars.get(id), loadedPlugins.get(id),
				pluginCounts.getOrDefault(id, -1), installed.contains(id)))
			.collect(Collectors.toList());

		SwingUtilities.invokeLater(() ->
		{
			if (!refreshing.isVisible())
			{
				return;
			}

			refreshing.setVisible(false);
			refreshing.getParent().revalidate();
			executor.execute(PluginHubPanel.this::filter);
		});
	}

	void filter()
	{
		if (refreshing.isVisible() || plugins == null)
		{
			return;
		}

		String query = searchBar.getText();
		boolean isSearching = query != null && !query.trim().isEmpty();
		List<PluginItem> pluginItems;
		if (isSearching)
		{
			pluginItems = PluginSearch.search(plugins, query);
		}
		else
		{
			pluginItems = plugins.stream().filter(p -> p.isInstalled() || p.getJarData() != null)
				.sorted(Comparator.comparing((PluginItem p) -> p.getJarData() == null)
					.thenComparing(PluginItem::isInstalled)
					.thenComparingInt(PluginItem::getUserCount)
					.reversed()
					.thenComparing(p -> p.manifest.getDisplayName())
				)
				.collect(Collectors.toList());
		}

		SwingUtilities.invokeLater(() ->
		{
			list.setModel(pluginItems);
		});
	}

	@Override
	public void onActivate()
	{
		revalidate();
		reloadPluginList();
		searchBar.setText("");
		searchBar.requestFocusInWindow();
	}

	@Override
	public void onDeactivate()
	{
		list.setModel(null);
		refreshing.setVisible(false);
		plugins = null;
		lastManifest = null;

		synchronized (iconLoadQueue)
		{
			for (PluginIcon pi; (pi = iconLoadQueue.poll()) != null; )
			{
				pi.queued = false;
			}
		}
	}

	@Subscribe
	private void onExternalPluginsChanged(ExternalPluginsChanged ev)
	{
		if (!refreshing.isVisible() && lastManifest != null)
		{
			refreshing.setVisible(true);

			Map<String, Integer> pluginCounts = plugins == null ? Collections.emptyMap()
				: plugins.stream().collect(Collectors.toMap(pi -> pi.manifest.getInternalName(), PluginItem::getUserCount));
			executor.submit(() -> reloadPluginList(lastManifest, pluginCounts));
		}
	}
}
