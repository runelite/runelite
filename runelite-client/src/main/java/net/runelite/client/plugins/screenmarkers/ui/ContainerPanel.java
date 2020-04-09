package net.runelite.client.plugins.screenmarkers.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.FlatTextField;
import net.runelite.client.util.ImageUtil;

public abstract class ContainerPanel extends JPanel
{
	private static final Border NAME_BOTTOM_BORDER = new CompoundBorder(
		BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.DARK_GRAY_COLOR),
		BorderFactory.createLineBorder(ColorScheme.DARKER_GRAY_COLOR));

	private static final ImageIcon VISIBLE_ICON;
	private static final ImageIcon VISIBLE_HOVER_ICON;
	private static final ImageIcon INVISIBLE_ICON;
	private static final ImageIcon INVISIBLE_HOVER_ICON;

	private static final ImageIcon DELETE_ICON;
	private static final ImageIcon DELETE_HOVER_ICON;

	protected final ScreenMarkerPlugin plugin;

	protected final FlatTextField nameInput = new FlatTextField();
	private final JLabel save = new JLabel("Save");
	private final JLabel cancel = new JLabel("Cancel");
	private final JLabel rename = new JLabel("Rename");

	protected final JPanel leftActions;
	protected final JPanel rightActions;
	private final JLabel visibilityLabel = new JLabel();
	protected final JLabel deleteLabel = new JLabel();

	protected boolean visible;

	static
	{
		final BufferedImage visibleImg = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "visible_icon.png");
		VISIBLE_ICON = new ImageIcon(visibleImg);
		VISIBLE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(visibleImg, -100));

		final BufferedImage invisibleImg = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "invisible_icon.png");
		INVISIBLE_ICON = new ImageIcon(invisibleImg);
		INVISIBLE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(invisibleImg, -100));

		final BufferedImage deleteImg = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "delete_icon.png");
		DELETE_ICON = new ImageIcon(deleteImg);
		DELETE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(deleteImg, -100));
	}

	ContainerPanel(ScreenMarkerPlugin plugin, String panelName)
	{
		this(plugin, panelName, false);
	}

	ContainerPanel(ScreenMarkerPlugin plugin, String panelName, boolean isGroup)
	{
		this.plugin = plugin;

		String markers = isGroup ? "markers" : "marker";

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JPanel nameWrapper = new JPanel(new BorderLayout());
		nameWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		nameWrapper.setBorder(NAME_BOTTOM_BORDER);

		JPanel nameActions = new JPanel(new BorderLayout(3, 0));
		nameActions.setBorder(new EmptyBorder(0, 0, 0, 8));
		nameActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		save.setVisible(false);
		save.setFont(FontManager.getRunescapeSmallFont());
		save.setForeground(ColorScheme.PROGRESS_COMPLETE_COLOR);
		save.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				save();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				save.setForeground(ColorScheme.PROGRESS_COMPLETE_COLOR.darker());
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				save.setForeground(ColorScheme.PROGRESS_COMPLETE_COLOR);
			}
		});

		cancel.setVisible(false);
		cancel.setFont(FontManager.getRunescapeSmallFont());
		cancel.setForeground(ColorScheme.PROGRESS_ERROR_COLOR);
		cancel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				cancel();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				cancel.setForeground(ColorScheme.PROGRESS_ERROR_COLOR.darker());
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				cancel.setForeground(ColorScheme.PROGRESS_ERROR_COLOR);
			}
		});

		rename.setFont(FontManager.getRunescapeSmallFont());
		rename.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker());
		rename.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				nameInput.setEditable(true);
				updateNameActions(true);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				rename.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker().darker());
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				rename.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker());
			}
		});

		nameActions.add(save, BorderLayout.EAST);
		nameActions.add(cancel, BorderLayout.WEST);
		nameActions.add(rename, BorderLayout.CENTER);

		nameInput.setText(panelName);
		nameInput.setBorder(null);
		nameInput.setEditable(false);
		nameInput.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		nameInput.setPreferredSize(new Dimension(0, 24));
		nameInput.getTextField().setForeground(Color.WHITE);
		nameInput.getTextField().setBorder(new EmptyBorder(0, 8, 0, 0));
		nameInput.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					save();
				}
				else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					cancel();
				}
			}
		});
		nameInput.getTextField().addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				preview(true);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				preview(false);
			}
		});

		nameWrapper.add(nameInput, BorderLayout.CENTER);
		nameWrapper.add(nameActions, BorderLayout.EAST);

		JPanel bottomContainer = new JPanel(new BorderLayout());
		bottomContainer.setBorder(new EmptyBorder(8, 0, 8, 0));
		bottomContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		leftActions = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
		leftActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		rightActions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
		rightActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		visibilityLabel.setToolTipText(visible ? "Hide screen " + markers : "Show screen " + markers);
		visibilityLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				toggle(!visible);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				visibilityLabel.setIcon(visible ? VISIBLE_HOVER_ICON : INVISIBLE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				updateVisibility();
			}
		});

		deleteLabel.setIcon(DELETE_ICON);
		deleteLabel.setToolTipText("Delete screen " + markers);
		deleteLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				int confirm = JOptionPane.showConfirmDialog(ContainerPanel.this,
					"Are you sure you want to permanently delete this " + (isGroup
						? "group and all its screen markers?"
						: "screen marker?"),
					"Warning", JOptionPane.OK_CANCEL_OPTION);

				if (confirm == 0)
				{
					delete();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				deleteLabel.setIcon(DELETE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				deleteLabel.setIcon(DELETE_ICON);
			}
		});

		rightActions.add(visibilityLabel);
		rightActions.add(deleteLabel);

		bottomContainer.add(leftActions, BorderLayout.WEST);
		bottomContainer.add(rightActions, BorderLayout.EAST);

		add(nameWrapper, BorderLayout.NORTH);
		add(bottomContainer, BorderLayout.CENTER);

		updateVisibility();
	}

	protected abstract void preview(boolean on);

	protected abstract void toggle(boolean on);

	protected void updateVisibility()
	{
		visibilityLabel.setIcon(visible ? VISIBLE_ICON : INVISIBLE_ICON);
	}

	protected abstract void save();

	protected abstract void cancel();

	protected abstract void delete();

	protected void updateNameActions(boolean saveAndCancel)
	{
		save.setVisible(saveAndCancel);
		cancel.setVisible(saveAndCancel);
		rename.setVisible(!saveAndCancel);

		if (saveAndCancel)
		{
			nameInput.getTextField().requestFocusInWindow();
			nameInput.getTextField().selectAll();
		}
	}
}
