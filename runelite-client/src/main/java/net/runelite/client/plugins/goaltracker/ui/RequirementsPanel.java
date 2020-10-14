package net.runelite.client.plugins.goaltracker.ui;

import net.runelite.client.plugins.goaltracker.Goal;
import net.runelite.client.plugins.goaltracker.GoalTrackerPlugin;
import net.runelite.client.plugins.goaltracker.Requirement;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class RequirementsPanel extends JPanel
{
	private static final ImageIcon EXPAND_MORE_ICON;
	private static final ImageIcon EXPAND_MORE_HOVER_ICON;
	private static final ImageIcon EXPAND_LESS_ICON;
	private static final ImageIcon EXPAND_LESS_HOVER_ICON;
	private static final ImageIcon ADD_ICON;
	private static final ImageIcon ADD_HOVER_ICON;

	private static final ImageIcon DELETE_ICON;
	private static final ImageIcon DELETE_HOVER_ICON;

	private JLabel expandButton;
	private JPanel bottomContainer;
	private JPanel addButtonWrapper;
	private JPanel nameWrapper;

	private final GoalTrackerPlugin plugin;
	private final Goal goal;

	private boolean expanded = true;
	private boolean hovering = false;

	private GridBagConstraints gbc;

	static
	{
		final BufferedImage addIcon = ImageUtil.getResourceStreamFromClass(GoalTrackerPlugin.class, "add_icon.png");
		ADD_ICON = new ImageIcon(addIcon);
		ADD_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addIcon, 0.53f));

		final BufferedImage expandMoreImg = ImageUtil.getResourceStreamFromClass(GoalTrackerPlugin.class, "expand_more_icon.png");
		EXPAND_MORE_ICON = new ImageIcon(expandMoreImg);
		EXPAND_MORE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(expandMoreImg, -100));

		final BufferedImage expandLessImg = ImageUtil.getResourceStreamFromClass(GoalTrackerPlugin.class, "expand_less_icon.png");
		EXPAND_LESS_ICON = new ImageIcon(expandLessImg);
		EXPAND_LESS_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(expandLessImg, -100));

		final BufferedImage deleteImg = ImageUtil.getResourceStreamFromClass(GoalTrackerPlugin.class, "delete_icon.png");
		DELETE_ICON = new ImageIcon(deleteImg);
		DELETE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(deleteImg, -100));
	}

	RequirementsPanel(GoalTrackerPlugin plugin, Goal goal)
	{
		this.plugin = plugin;
		this.goal = goal;

		init();
	}

	public void init()
	{
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARKER_GRAY_COLOR);
		setBorder(new EmptyBorder(0, 8, 0, 8));

		nameWrapper = new JPanel(new BorderLayout());
		nameWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		bottomContainer = new JPanel(new GridBagLayout());
		bottomContainer.setBorder(new EmptyBorder(5, 0, 0, 0));
		bottomContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JLabel requirementsLabel = new JLabel("Requirements");

		JLabel addRequirement = new JLabel(ADD_ICON);
		addRequirement.setToolTipText("Add new requirement");
		addRequirement.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				String name = JOptionPane.showInputDialog("Requirement name:");
				if (name == null || name.isEmpty()) return;
				goal.getRequirements().add(new Requirement(name, false));
				plugin.updateConfig();
				updateRequirements();
				repaint();
				revalidate();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				addRequirement.setIcon(ADD_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				addRequirement.setIcon(ADD_ICON);
			}
		});

		expandButton = new JLabel(EXPAND_LESS_ICON);
		nameWrapper.setToolTipText("View less...");
		nameWrapper.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				toggleExpand();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				hovering = true;
				updateHeader();
				requirementsLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				hovering = false;
				updateHeader();
				requirementsLabel.setForeground(Color.WHITE);
			}
		});
		updateHeader();

		nameWrapper.add(requirementsLabel, BorderLayout.CENTER);
		nameWrapper.add(expandButton, BorderLayout.EAST);

		addButtonWrapper = new JPanel(new BorderLayout(3, 0));
		addButtonWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		addButtonWrapper.add(addRequirement, BorderLayout.CENTER);

		updateRequirements();

		add(nameWrapper, BorderLayout.NORTH);
		add(bottomContainer, BorderLayout.CENTER);
	}

	public JLabel createDeleteLabel(Requirement requirement)
	{
		JLabel deleteLabel = new JLabel(DELETE_ICON);
		deleteLabel.setToolTipText("Delete requirement");
		deleteLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				goal.getRequirements().remove(requirement);
				plugin.updateConfig();
				updateRequirements();
				repaint();
				revalidate();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				deleteLabel.setIcon(DELETE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				deleteLabel.setIcon(DELETE_ICON);
			}
		});
		return deleteLabel;
	}

	public JLabel createRequirementLabel(Requirement requirement)
	{
		JLabel requirementLabel = new JLabel(requirement.getName());
		requirementLabel.setForeground(requirement.isCompleted() ? ColorScheme.PROGRESS_COMPLETE_COLOR : ColorScheme.PROGRESS_ERROR_COLOR);
		requirementLabel.setToolTipText("Toggle complete");
		requirementLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				requirement.setCompleted(!requirement.isCompleted());
				plugin.updateConfig();
				updateRequirements();
				repaint();
				revalidate();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				requirementLabel.setForeground(requirement.isCompleted() ? ColorScheme.PROGRESS_COMPLETE_COLOR.darker() : ColorScheme.PROGRESS_ERROR_COLOR.darker());
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				requirementLabel.setForeground(requirement.isCompleted() ? ColorScheme.PROGRESS_COMPLETE_COLOR : ColorScheme.PROGRESS_ERROR_COLOR);
			}
		});
		return requirementLabel;
	}

	public void updateHeader()
	{
		nameWrapper.setToolTipText(expanded ? "View less..." : "View more...");
		if (hovering)
			expandButton.setIcon(expanded ? EXPAND_LESS_HOVER_ICON : EXPAND_MORE_HOVER_ICON);
		else
			expandButton.setIcon(expanded ? EXPAND_LESS_ICON : EXPAND_MORE_ICON);
	}

	public void updateRequirements()
	{
		bottomContainer.removeAll();

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;

		for (Requirement requirement : goal.getRequirements())
		{
			JPanel requirementWrapper = new JPanel(new BorderLayout());
			requirementWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
			JLabel requirementLabel = createRequirementLabel(requirement);
			JLabel deleteLabel = createDeleteLabel(requirement);
			requirementWrapper.add(requirementLabel, BorderLayout.WEST);
			requirementWrapper.add(deleteLabel, BorderLayout.EAST);
			bottomContainer.add(requirementWrapper, gbc);
			gbc.gridy++;
			bottomContainer.add(Box.createRigidArea(new Dimension(0, 5)), gbc);
			gbc.gridy++;
		}

		bottomContainer.add(addButtonWrapper, gbc);
		gbc.gridy++;
	}

	public void expand()
	{
		if (!expanded) toggleExpand();
	}

	public void retract()
	{
		if (expanded) toggleExpand();
	}

	public void toggleExpand()
	{
		expanded = !expanded;
		bottomContainer.setVisible(expanded);
		updateHeader();
	}

}
