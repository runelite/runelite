package net.runelite.client.plugins.openosrs.externals;

import com.google.gson.JsonSyntaxException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.api.util.Text.DISTANCE;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ExternalPluginChanged;
import net.runelite.client.events.ExternalRepositoryChanged;
import net.runelite.client.plugins.ExternalPluginManager;
import static net.runelite.client.plugins.openosrs.externals.ExternalPluginManagerPanel.wrapContainer;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.util.DeferredDocumentChangedListener;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.SwingUtil;
import org.pf4j.update.PluginInfo;
import org.pf4j.update.UpdateManager;
import org.pf4j.update.UpdateRepository;
import org.pf4j.update.VerifyException;

@Slf4j
public class PluginsPanel extends JPanel
{
	private static final ImageIcon ADD_ICON;
	private static final ImageIcon ADD_HOVER_ICON;
	private static final ImageIcon DELETE_ICON;
	private static final ImageIcon DELETE_HOVER_ICON;
	private static final ImageIcon DELETE_ICON_GRAY;
	private static final ImageIcon DELETE_HOVER_ICON_GRAY;

	static
	{
		final BufferedImage addIcon =
			ImageUtil.recolorImage(
				ImageUtil.getResourceStreamFromClass(PluginsPanel.class, "add_icon.png"), ColorScheme.BRAND_BLUE
			);
		ADD_ICON = new ImageIcon(addIcon);
		ADD_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addIcon, 0.53f));

		final BufferedImage deleteImg =
			ImageUtil.recolorImage(
				ImageUtil.resizeCanvas(
					ImageUtil.getResourceStreamFromClass(PluginsPanel.class, "delete_icon.png"), 14, 14
				), ColorScheme.BRAND_BLUE
			);
		DELETE_ICON = new ImageIcon(deleteImg);
		DELETE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(deleteImg, 0.53f));

		DELETE_ICON_GRAY = new ImageIcon(ImageUtil.grayscaleImage(deleteImg));
		DELETE_HOVER_ICON_GRAY = new ImageIcon(ImageUtil.alphaOffset(ImageUtil.grayscaleImage(deleteImg), 0.53f));
	}

	private final ExternalPluginManager externalPluginManager;
	private final UpdateManager updateManager;
	private final ScheduledExecutorService executor;
	private final EventBus eventBus;

	private final IconTextField searchBar = new IconTextField();
	private final JPanel filterwrapper = new JPanel(new BorderLayout(0, 10));
	private final List<PluginInfo> installedPluginsList = new ArrayList<>();
	private final List<PluginInfo> availablePluginsList = new ArrayList<>();
	private final JPanel installedPluginsPanel = new JPanel(new GridBagLayout());
	private final JPanel availablePluginsPanel = new JPanel(new GridBagLayout());

	private JComboBox<String> filterComboBox;
	private Set<String> deps;

	PluginsPanel(ExternalPluginManager externalPluginManager, ScheduledExecutorService executor, EventBus eventBus)
	{
		this.externalPluginManager = externalPluginManager;
		this.updateManager = externalPluginManager.getUpdateManager();
		this.executor = executor;
		this.eventBus = eventBus;

		setLayout(new BorderLayout(0, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		buildFilter();

		JTabbedPane mainTabPane = new JTabbedPane();

		mainTabPane.add("Installed", wrapContainer(installedPluginsPanel()));
		mainTabPane.add("Available", wrapContainer(availablePluginsPanel()));

		add(filterwrapper, BorderLayout.NORTH);
		add(mainTabPane, BorderLayout.CENTER);

		eventBus.subscribe(ExternalPluginChanged.class, this, this::onExternalPluginChanged);
		eventBus.subscribe(ExternalRepositoryChanged.class, this, (e) -> {
			buildFilter();
			reloadPlugins();
			repaint();
		});

		reloadPlugins();
	}

	private void buildFilter()
	{
		filterwrapper.removeAll();

		DeferredDocumentChangedListener listener = new DeferredDocumentChangedListener();
		listener.addChangeListener(e ->
		{
			installedPlugins();
			availablePlugins();
		});

		filterwrapper.setBorder(new EmptyBorder(10, 10, 0, 10));

		List<String> repositories = getRepositories();
		filterComboBox = new JComboBox<>(repositories.toArray(new String[0]));
		filterComboBox.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, 30));
		filterComboBox.addActionListener(e -> {
			installedPlugins();
			availablePlugins();
		});

		if (repositories.size() > 2)
		{
			filterwrapper.add(filterComboBox, BorderLayout.NORTH);
		}

		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, 30));
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchBar.getDocument().addDocumentListener(listener);

		filterwrapper.add(searchBar, BorderLayout.CENTER);
	}

	private List<String> getRepositories()
	{
		List<String> repositories = new ArrayList<>();
		repositories.add("All");
		for (UpdateRepository updateRepository : this.updateManager.getRepositories())
		{
			repositories.add(updateRepository.getUrl().toString().replace("https://raw.githubusercontent.com/", "").replace("/master/", ""));
		}

		return repositories;
	}

	private JLabel titleLabel(String text)
	{
		JLabel title = new JShadowedLabel();

		title.setFont(FontManager.getRunescapeSmallFont());
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setText("<html><body style = 'text-align:center'>" + text + "</body></html>");

		return title;
	}

	private JPanel installedPluginsPanel()
	{
		JPanel installedPluginsContainer = new JPanel();
		installedPluginsContainer.setLayout(new BorderLayout(0, 5));
		installedPluginsContainer.setBorder(new EmptyBorder(0, 10, 10, 10));
		installedPluginsContainer.add(installedPluginsPanel, BorderLayout.CENTER);

		return installedPluginsContainer;
	}

	private JPanel availablePluginsPanel()
	{
		JPanel availablePluginsContainer = new JPanel();
		availablePluginsContainer.setLayout(new BorderLayout(0, 5));
		availablePluginsContainer.setBorder(new EmptyBorder(0, 10, 10, 10));
		availablePluginsContainer.add(availablePluginsPanel, BorderLayout.CENTER);

		return availablePluginsContainer;
	}

	static boolean mismatchesSearchTerms(String search, PluginInfo pluginInfo)
	{
		final String[] searchTerms = search.toLowerCase().split(" ");
		final String[] pluginTerms = (pluginInfo.name + " " + pluginInfo.description).toLowerCase().split("[/\\s]");
		for (String term : searchTerms)
		{
			if (Arrays.stream(pluginTerms).noneMatch((t) -> t.contains(term) ||
				DISTANCE.apply(t, term) > 0.9))
			{
				return true;
			}
		}
		return false;
	}

	private void reloadPlugins()
	{
		fetchPlugins();

		try
		{
			SwingUtil.syncExec(() -> {
				this.installedPlugins();
				this.availablePlugins();
			});

		}
		catch (InvocationTargetException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private void fetchPlugins()
	{
		List<PluginInfo> availablePlugins = null;
		List<PluginInfo> plugins = null;
		List<String> disabledPlugins = externalPluginManager.getDisabledPlugins();

		try
		{
			availablePlugins = updateManager.getAvailablePlugins();
			plugins = updateManager.getPlugins();
		}
		catch (JsonSyntaxException ex)
		{
			log.error(String.valueOf(ex));
		}

		if (availablePlugins == null || plugins == null)
		{
			JOptionPane.showMessageDialog(null, "The external plugin list could not be loaded.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		availablePluginsList.clear();
		installedPluginsList.clear();

		deps = externalPluginManager.getDependencies();

		for (PluginInfo pluginInfo : plugins)
		{
			if (availablePlugins.contains(pluginInfo) || disabledPlugins.contains(pluginInfo.id))
			{
				availablePluginsList.add(pluginInfo);
			}
			else
			{
				installedPluginsList.add(pluginInfo);
			}
		}
	}

	private void onExternalPluginChanged(ExternalPluginChanged externalPluginChanged)
	{
		String pluginId = externalPluginChanged.getPluginId();
		Optional<Component> externalBox;

		if (externalPluginChanged.isAdded())
		{
			externalBox = Arrays.stream(
				availablePluginsPanel.getComponents()
			).filter(extBox ->
				extBox instanceof ExternalBox && ((ExternalBox) extBox).pluginInfo.id.equals(pluginId)
			).findFirst();
		}
		else
		{
			externalBox = Arrays.stream(
				installedPluginsPanel.getComponents()
			).filter(extBox ->
				extBox instanceof ExternalBox && ((ExternalBox) extBox).pluginInfo.id.equals(pluginId)
			).findFirst();
		}

		if (externalBox.isEmpty())
		{
			log.info("EXTERNALBOX IS EMPTY: {}", pluginId);
			return;
		}

		ExternalBox extBox = (ExternalBox) externalBox.get();
		deps = externalPluginManager.getDependencies();

		try
		{
			SwingUtil.syncExec(() ->
			{
				if (externalPluginChanged.isAdded())
				{
					availablePluginsPanel.remove(externalBox.get());
					availablePluginsList.remove(extBox.pluginInfo);

					installedPluginsList.add(extBox.pluginInfo);
					installedPluginsList.sort(Comparator.naturalOrder());

					installedPlugins();

					pluginInstallButton(extBox.install, extBox.pluginInfo, true, deps.contains(extBox.pluginInfo.id));
				}
				else
				{
					installedPluginsPanel.remove(externalBox.get());
					installedPluginsList.remove(extBox.pluginInfo);

					availablePluginsList.add(extBox.pluginInfo);
					availablePluginsList.sort(Comparator.naturalOrder());

					availablePlugins();

					pluginInstallButton(extBox.install, extBox.pluginInfo, false, false);
				}
			});
		}
		catch (InvocationTargetException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private void installedPlugins()
	{
		GridBagConstraints c = new GridBagConstraints();

		installedPluginsPanel.removeAll();
		String search = searchBar.getText();

		for (PluginInfo pluginInfo : installedPluginsList)
		{
			if (!search.equals("") && mismatchesSearchTerms(search, pluginInfo))
			{
				continue;
			}

			if (filterComboBox.getSelectedIndex() != 0)
			{
				boolean filtered = true;
				String filter = String.valueOf(filterComboBox.getSelectedItem());
				for (UpdateRepository updateRepository : updateManager.getRepositories())
				{
					if (filter.equals(updateRepository.getUrl().toString().replace("https://raw.githubusercontent.com/", "").replace("/master/", "")) &&
						pluginInfo.getRepositoryId().equals(updateRepository.getId()))
					{
						filtered = false;
					}
				}

				if (filtered)
				{
					continue;
				}
			}

			ExternalBox pluginBox = new ExternalBox(pluginInfo);
			pluginBox.pluginInfo = pluginInfo;

			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.0;
			c.gridy += 1;
			c.insets = new Insets(5, 0, 0, 0);

			pluginInstallButton(pluginBox.install, pluginInfo, true, deps.contains(pluginInfo.id));
			installedPluginsPanel.add(pluginBox, c);
		}

		if (installedPluginsPanel.getComponents().length < 1)
		{
			installedPluginsPanel.add(titleLabel("No plugins found"));
		}
	}

	private void availablePlugins()
	{
		GridBagConstraints c = new GridBagConstraints();

		availablePluginsPanel.removeAll();
		String search = searchBar.getText();

		for (PluginInfo pluginInfo : availablePluginsList)
		{
			if (!search.equals("") && mismatchesSearchTerms(search, pluginInfo))
			{
				continue;
			}

			if (filterComboBox.getSelectedIndex() != 0)
			{
				boolean filtered = true;
				String filter = String.valueOf(filterComboBox.getSelectedItem());
				for (UpdateRepository updateRepository : updateManager.getRepositories())
				{
					if (filter.equals(updateRepository.getUrl().toString().replace("https://raw.githubusercontent.com/", "").replace("/master/", "")) &&
						pluginInfo.getRepositoryId().equals(updateRepository.getId()))
					{
						filtered = false;
					}
				}

				if (filtered)
				{
					continue;
				}
			}

			ExternalBox pluginBox = new ExternalBox(pluginInfo);
			pluginBox.pluginInfo = pluginInfo;

			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.0;
			c.gridy += 1;
			c.insets = new Insets(5, 0, 0, 0);

			pluginInstallButton(pluginBox.install, pluginInfo, false, false);
			availablePluginsPanel.add(pluginBox, c);
		}

		if (availablePluginsPanel.getComponents().length < 1)
		{
			availablePluginsPanel.add(titleLabel("No plugins found"));
		}
	}


	private void pluginInstallButton(JLabel install, PluginInfo pluginInfo, boolean installed, boolean hideAction)
	{
		install.setIcon(installed ? hideAction ? DELETE_ICON_GRAY : DELETE_ICON : ADD_ICON);
		if (!hideAction)
		{
			install.setToolTipText(installed ? "Uninstall" : "Install");
		}
		install.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (installed)
				{
					if (hideAction)
					{
						JOptionPane.showMessageDialog(null, "This plugin can't be uninstalled because one or more other plugins have a dependency on it.", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						install.setIcon(null);
						install.setText("Uninstalling");

						SwingWorker<Boolean, Void> worker = new SwingWorker<>()
						{
							@Override
							protected Boolean doInBackground()
							{
								return externalPluginManager.uninstall(pluginInfo.id);
							}

							@Override
							protected void done()
							{

								boolean status = false;
								try
								{
									status = get();
								}
								catch (InterruptedException | ExecutionException e)
								{
								}

								if (!status)
								{
									pluginInstallButton(install, pluginInfo, installed, hideAction);
								}
							}
						};
						worker.execute();
					}
				}
				else
				{
					install.setIcon(null);
					install.setText("Installing");

					SwingWorker<Boolean, Void> worker = new SwingWorker<>()
					{
						@Override
						protected Boolean doInBackground()
						{
							return installPlugin(pluginInfo);
						}

						@Override
						protected void done()
						{

							boolean status = false;
							try
							{
								status = get();
							}
							catch (InterruptedException | ExecutionException e)
							{
							}

							if (!status)
							{
								pluginInstallButton(install, pluginInfo, installed, hideAction);
							}
						}
					};
					worker.execute();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				if (install.getText().toLowerCase().contains("installing"))
				{
					return;
				}

				install.setIcon(installed ? hideAction ? DELETE_HOVER_ICON_GRAY : DELETE_HOVER_ICON : ADD_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				if (install.getText().toLowerCase().contains("installing"))
				{
					return;
				}

				install.setIcon(installed ? hideAction ? DELETE_ICON_GRAY : DELETE_ICON : ADD_ICON);
			}
		});
	}

	private boolean installPlugin(PluginInfo pluginInfo)
	{
		try
		{
			return externalPluginManager.install(pluginInfo.id);
		}
		catch (VerifyException ex)
		{
			try
			{
				SwingUtil.syncExec(() ->
					JOptionPane.showMessageDialog(null, pluginInfo.name + " could not be installed, the hash could not be verified.", "Error!", JOptionPane.ERROR_MESSAGE));
			}
			catch (InvocationTargetException | InterruptedException ignored)
			{
			}
		}

		return false;
	}
}
