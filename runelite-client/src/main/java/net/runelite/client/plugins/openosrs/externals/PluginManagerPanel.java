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
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ExternalPluginChanged;
import net.runelite.client.events.ExternalPluginsLoaded;
import net.runelite.client.plugins.ExternalPluginManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.util.DeferredDocumentChangedListener;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.SwingUtil;
import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.pf4j.update.PluginInfo;
import org.pf4j.update.UpdateManager;
import org.pf4j.update.UpdateRepository;
import org.pf4j.update.VerifyException;

@Slf4j
public class PluginManagerPanel extends PluginPanel
{
	private static final JaroWinklerDistance DISTANCE = new JaroWinklerDistance();

	private static final ImageIcon SECTION_EXPAND_ICON;
	private static final ImageIcon SECTION_EXPAND_ICON_HOVER;
	private static final ImageIcon SECTION_RETRACT_ICON;
	private static final ImageIcon SECTION_RETRACT_ICON_HOVER;
	private static final ImageIcon ADD_ICON;
	private static final ImageIcon ADD_HOVER_ICON;
	private static final ImageIcon DELETE_ICON;
	private static final ImageIcon DELETE_HOVER_ICON;
	private static final ImageIcon DELETE_ICON_GRAY;
	private static final ImageIcon DELETE_HOVER_ICON_GRAY;

	static
	{
		final BufferedImage backIcon = ImageUtil.getResourceStreamFromClass(PluginManagerPanel.class, "config_back_icon.png");
		final BufferedImage orangeBackIcon = ImageUtil.fillImage(backIcon, ColorScheme.BRAND_BLUE);

		final BufferedImage sectionRetractIcon = ImageUtil.rotateImage(orangeBackIcon, Math.PI * 1.5);
		SECTION_RETRACT_ICON = new ImageIcon(sectionRetractIcon);
		SECTION_RETRACT_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(sectionRetractIcon, -100));

		final BufferedImage sectionExpandIcon = ImageUtil.rotateImage(orangeBackIcon, Math.PI);
		SECTION_EXPAND_ICON = new ImageIcon(sectionExpandIcon);
		SECTION_EXPAND_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(sectionExpandIcon, -100));

		final BufferedImage addIcon =
			ImageUtil.recolorImage(
				ImageUtil.getResourceStreamFromClass(PluginManagerPanel.class, "add_icon.png"), ColorScheme.BRAND_BLUE
			);
		ADD_ICON = new ImageIcon(addIcon);
		ADD_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addIcon, 0.53f));

		final BufferedImage deleteImg =
			ImageUtil.recolorImage(
				ImageUtil.resizeCanvas(
					ImageUtil.getResourceStreamFromClass(PluginManagerPanel.class, "delete_icon.png"), 14, 14
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
	private final IconTextField searchBar = new IconTextField();
	private final List<PluginInfo> installedPluginsList = new ArrayList<>();
	private final List<PluginInfo> availablePluginsList = new ArrayList<>();
	private final JPanel repositoriesPanel = new JPanel();
	private final JPanel installedPluginsPanel = new JPanel(new GridBagLayout());
	private final JPanel availablePluginsPanel = new JPanel(new GridBagLayout());
	private String filterMode = "Available plugins";
	private int scrollBarPosition;
	private JScrollBar scrollbar;
	private Set<String> deps;

	@Inject
	private PluginManagerPanel(ExternalPluginManager externalPluginManager, EventBus eventBus, ScheduledExecutorService executor)
	{
		super(false);

		this.externalPluginManager = externalPluginManager;
		this.updateManager = externalPluginManager.getUpdateManager();
		this.executor = executor;

		eventBus.subscribe(ExternalPluginsLoaded.class, "loading-externals", (e) -> {
			eventBus.unregister("loading-externals");
			eventBus.subscribe(ExternalPluginChanged.class, this, this::onExternalPluginChanged);
			reloadPlugins();
		});

		DeferredDocumentChangedListener listener = new DeferredDocumentChangedListener();
		listener.addChangeListener(e ->
			onSearchBarChanged());

		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, 30));
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchBar.getDocument().addDocumentListener(listener);

		buildPanel();
	}

	private static boolean mismatchesSearchTerms(String search, PluginInfo pluginInfo)
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

	private JPanel addSection(String name, JPanel sectionContent)
	{
		final JPanel section = new JPanel();
		section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));

		JPanel item = new JPanel();
		item.setLayout(new BorderLayout());

		JLabel headerLabel = new JLabel(name);
		headerLabel.setFont(FontManager.getRunescapeFont());
		headerLabel.setForeground(ColorScheme.BRAND_BLUE);

		final JToggleButton collapse = new JToggleButton(SECTION_EXPAND_ICON);

		SwingUtil.removeButtonDecorations(collapse);
		collapse.setRolloverIcon(SECTION_EXPAND_ICON_HOVER);
		collapse.setSelectedIcon(SECTION_RETRACT_ICON);
		collapse.setRolloverSelectedIcon(SECTION_RETRACT_ICON_HOVER);
		collapse.setToolTipText("Retract");
		collapse.setPreferredSize(new Dimension(20, 20));
		collapse.setFont(collapse.getFont().deriveFont(16.0f));
		collapse.setBorder(null);
		collapse.setMargin(new Insets(0, 0, 0, 0));
		headerLabel.setBorder(new EmptyBorder(0, 6, 0, 0));

		item.add(collapse, BorderLayout.WEST);
		item.add(headerLabel, BorderLayout.CENTER);

		final JPanel sectionContents = new JPanel();
		sectionContents.setLayout(new DynamicGridLayout(0, 1, 0, 5));
		sectionContents.setBorder(new EmptyBorder(6, 5, 0, 0));
		section.add(item, BorderLayout.NORTH);
		section.add(sectionContents, BorderLayout.SOUTH);

		sectionContents.add(sectionContent);

		final MouseAdapter adapter = new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				toggleSection(collapse, sectionContents);
			}
		};
		collapse.addActionListener(e -> toggleSection(collapse, sectionContents));
		headerLabel.addMouseListener(adapter);

		return section;
	}

	private void toggleSection(JToggleButton button, JPanel contents)
	{
		boolean newState = !contents.isVisible();
		button.setSelected(newState);
		contents.setVisible(newState);
		button.setToolTipText(newState ? "Retract" : "Expand");
		SwingUtilities.invokeLater(() ->
		{
			contents.revalidate();
			contents.repaint();
		});
	}

	private JPanel filterPanel()
	{
		JPanel filterPanel = new JPanel();
		filterPanel.setLayout(new BorderLayout(0, 5));
		filterPanel.setBorder(new EmptyBorder(0, 10, 10, 10));

		JRadioButton repositories = new JRadioButton("Repositories");
		repositories.setSelected(filterMode.equals("Repositories"));
		JRadioButton plugins = new JRadioButton("Plugins");
		plugins.setSelected(filterMode.contains("plugins"));

		JRadioButton available = new JRadioButton("Available");
		available.setSelected(filterMode.contains("Available"));
		JRadioButton installed = new JRadioButton("Installed");
		installed.setSelected(filterMode.contains("Installed"));

		repositories.addActionListener(ev -> {
			filterMode = "Repositories";
			buildPanel();
		});

		plugins.addActionListener(ev -> {
			filterMode = "Available plugins";
			onSearchBarChanged();
			buildPanel();
		});

		available.addActionListener(ev -> {
			filterMode = "Available plugins";
			onSearchBarChanged();
			buildPanel();
		});

		installed.addActionListener(ev -> {
			filterMode = "Installed plugins";
			onSearchBarChanged();
			buildPanel();
		});

		RadioButtonPanel mainRadioPanel = new RadioButtonPanel("Show", repositories, plugins);
		RadioButtonPanel pluginRadioPanel = new RadioButtonPanel("Plugins", available, installed);

		filterPanel.add(mainRadioPanel, BorderLayout.NORTH);

		if (!filterMode.equals("Repositories"))
		{
			filterPanel.add(pluginRadioPanel, BorderLayout.CENTER);
		}

		return filterPanel;
	}

	private void buildPanel()
	{
		removeAll();

		setLayout(new BorderLayout(0, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		add(titleBar(), BorderLayout.NORTH);
		add(wrapContainer(getContentPanels()), BorderLayout.CENTER);

		revalidate();
		repaint();
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

	private JPanel titleBar()
	{
		JPanel titlePanel = new JPanel(new BorderLayout());
		titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		JLabel title = new JLabel();
		JLabel addRepo = new JLabel(ADD_ICON);

		title.setText("External Plugin Manager");
		title.setForeground(Color.WHITE);

		addRepo.setToolTipText("Add new repository");
		addRepo.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				JTextField owner = new JTextField();
				JTextField name = new JTextField();
				Object[] message = {
					"Github Repository owner:", owner,
					"Github Repository name:", name
				};

				int option = JOptionPane.showConfirmDialog(null, message, "Add repository", JOptionPane.OK_CANCEL_OPTION);
				if (option != JOptionPane.OK_OPTION || owner.getText().equals("") || name.getText().equals(""))
				{
					return;
				}

				if (ExternalPluginManager.testRepository(owner.getText(), name.getText()))
				{
					JOptionPane.showMessageDialog(null, "This doesn't appear to be a valid repository.", "Error!", JOptionPane.ERROR_MESSAGE);
					return;
				}

				externalPluginManager.addRepository(owner.getText(), name.getText());

				repositories();
				reloadPlugins();
				buildPanel();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				addRepo.setIcon(ADD_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				addRepo.setIcon(ADD_ICON);
			}
		});

		titlePanel.add(title, BorderLayout.WEST);
		titlePanel.add(addRepo, BorderLayout.EAST);

		return titlePanel;
	}

	// Wrap the panel inside a scroll pane
	private JScrollPane wrapContainer(final JPanel container)
	{
		final JPanel wrapped = new JPanel(new BorderLayout());
		wrapped.add(container, BorderLayout.NORTH);

		final JScrollPane scroller = new JScrollPane(wrapped);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));

		this.scrollbar = scroller.getVerticalScrollBar();

		return scroller;
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

	private void reloadPlugins()
	{
		fetchPlugins();

		try
		{
			SwingUtil.syncExec(() -> {
				this.installedPlugins();
				this.availablePlugins();

				resetScrollValue();
			});

		}
		catch (InvocationTargetException | InterruptedException e)
		{
			e.printStackTrace();
		}

		resetScrollValue();
	}

	private void onSearchBarChanged()
	{
		if (filterMode.contains("Installed plugins"))
		{
			installedPlugins();
		}
		else if (filterMode.contains("Available plugins"))
		{
			availablePlugins();
		}
	}

	private JPanel getContentPanels()
	{
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 5, 0);

		contentPanel.add(addSection("Filter", filterPanel()), c);

		if (filterMode.equals("Repositories"))
		{
			c.gridy++;
			contentPanel.add(repositoriesPanel(), c);
		}
		else if (filterMode.contains("Installed plugins"))
		{
			c.gridy++;
			contentPanel.add(installedPluginsPanel(), c);
		}
		else if (filterMode.contains("Available plugins"))
		{
			c.gridy++;
			contentPanel.add(availablePluginsPanel(), c);
		}

		return contentPanel;
	}

	private JPanel repositoriesPanel()
	{
		JPanel installedRepositoriesPanel = new JPanel();
		installedRepositoriesPanel.setLayout(new BorderLayout(0, 5));
		installedRepositoriesPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
		installedRepositoriesPanel.add(titleLabel("Repositories"), BorderLayout.NORTH);
		installedRepositoriesPanel.add(repositoriesPanel, BorderLayout.CENTER);

		repositories();

		return installedRepositoriesPanel;
	}

	private JPanel installedPluginsPanel()
	{
		JPanel installedPluginsContainer = new JPanel();
		installedPluginsContainer.setLayout(new BorderLayout(0, 5));
		installedPluginsContainer.setBorder(new EmptyBorder(0, 10, 10, 10));
		installedPluginsContainer.add(titleLabel(filterMode), BorderLayout.NORTH);
		installedPluginsContainer.add(searchBar, BorderLayout.CENTER);
		installedPluginsContainer.add(installedPluginsPanel, BorderLayout.SOUTH);

		return installedPluginsContainer;
	}

	private JPanel availablePluginsPanel()
	{
		JPanel availablePluginsContainer = new JPanel();
		availablePluginsContainer.setLayout(new BorderLayout(0, 5));
		availablePluginsContainer.setBorder(new EmptyBorder(0, 10, 10, 10));
		availablePluginsContainer.add(titleLabel(filterMode), BorderLayout.NORTH);
		availablePluginsContainer.add(searchBar, BorderLayout.CENTER);
		availablePluginsContainer.add(availablePluginsPanel, BorderLayout.SOUTH);

		return availablePluginsContainer;
	}

	private void repositories()
	{
		repositoriesPanel.removeAll();
		repositoriesPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		for (UpdateRepository repository : externalPluginManager.getRepositories())
		{
			String name = repository.getId().replace(repository.getUrl().toString(), "");
			ExternalBox repositoryBox = new ExternalBox(name, repository.getUrl());

			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.0;
			c.gridy += 1;
			c.insets = new Insets(5, 0, 0, 0);

			repositoriesPanel.add(repositoryBox, c);

			if (name.equals("OpenOSRS"))
			{
				repositoryBox.install.setVisible(false);
				continue;
			}

			repositoryBox.install.setIcon(DELETE_ICON);
			repositoryBox.install.setToolTipText("Remove");
			repositoryBox.install.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mousePressed(MouseEvent e)
				{
					externalPluginManager.removeRepository(repository.getId());

					repositories();
					reloadPlugins();
				}

				@Override
				public void mouseEntered(MouseEvent e)
				{
					repositoryBox.install.setIcon(DELETE_HOVER_ICON);
				}

				@Override
				public void mouseExited(MouseEvent e)
				{
					repositoryBox.install.setIcon(DELETE_ICON);
				}
			});
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

	private void installedPlugins()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		installedPluginsPanel.removeAll();
		String search = searchBar.getText();

		for (PluginInfo pluginInfo : installedPluginsList)
		{

			if (!search.equals("") && mismatchesSearchTerms(search, pluginInfo))
			{
				continue;
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
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		availablePluginsPanel.removeAll();
		String search = searchBar.getText();

		for (PluginInfo pluginInfo : availablePluginsList)
		{
			if (!search.equals("") && mismatchesSearchTerms(search, pluginInfo))
			{
				continue;
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
				saveScrollValue();

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
						executor.submit(() -> externalPluginManager.uninstall(pluginInfo.id));
					}
				}
				else
				{
					install.setIcon(null);
					install.setText("Installing");
					executor.submit(() -> installPlugin(pluginInfo));
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

	private void installPlugin(PluginInfo pluginInfo)
	{
		try
		{
			externalPluginManager.install(pluginInfo.id);
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
	}

	private void saveScrollValue()
	{
		scrollBarPosition = scrollbar.getValue();
	}

	private void resetScrollValue()
	{
		scrollbar.setValue(scrollBarPosition);
	}
}
