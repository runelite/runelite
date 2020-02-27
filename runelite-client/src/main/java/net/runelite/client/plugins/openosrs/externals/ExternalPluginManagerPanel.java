package net.runelite.client.plugins.openosrs.externals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.ExternalPluginManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;

public class ExternalPluginManagerPanel extends PluginPanel
{
	private static final ImageIcon ADD_ICON;
	private static final ImageIcon ADD_HOVER_ICON;

	static
	{
		final BufferedImage addIcon =
			ImageUtil.recolorImage(
				ImageUtil.getResourceStreamFromClass(ExternalPluginManagerPanel.class, "add_icon.png"), ColorScheme.BRAND_BLUE
			);
		ADD_ICON = new ImageIcon(addIcon);
		ADD_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addIcon, 0.53f));
	}

	private final ExternalPluginManager externalPluginManager;
	private final ScheduledExecutorService executor;
	private final EventBus eventBus;

	@Inject
	private ExternalPluginManagerPanel(ExternalPluginManager externalPluginManager, ScheduledExecutorService executor, EventBus eventBus)
	{
		super(false);

		this.externalPluginManager = externalPluginManager;
		this.executor = executor;
		this.eventBus = eventBus;

		buildPanel();
	}

	private void buildPanel()
	{
		removeAll();

		setLayout(new BorderLayout(0, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		add(titleBar(), BorderLayout.NORTH);
		add(tabbedPane(), BorderLayout.CENTER);

		revalidate();
		repaint();
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

	private JTabbedPane tabbedPane()
	{
		JTabbedPane mainTabPane = new JTabbedPane();

		PluginsPanel pluginPanel = new PluginsPanel(this.externalPluginManager, this.executor, this.eventBus);
		JScrollPane repositoryPanel = wrapContainer(new RepositoryPanel(this.externalPluginManager, this.eventBus));

		mainTabPane.add("Plugins", pluginPanel);
		mainTabPane.add("Repositories", repositoryPanel);

		return mainTabPane;
	}

	static JScrollPane wrapContainer(final JPanel container)
	{
		final JPanel wrapped = new JPanel(new BorderLayout());
		wrapped.add(container, BorderLayout.NORTH);

		final JScrollPane scroller = new JScrollPane(wrapped);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));

		return scroller;
	}
}
