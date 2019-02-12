package net.runelite.client.plugins.slayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.StackFormatter;

public class SlayerTaskPanel extends PluginPanel
{
	private static final long MILLIS_PER_SECOND = 1000;
	private static final long SECONDS_PER_MINUTE = 60;
	private static final long MINUTES_PER_HOUR = 60;

	// Templates
	private static final String HTML_LABEL_TEMPLATE =
			"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";
	private static final String HTML_TIME_LABEL_TEMPLATE =
			"<html><body style='color:%s'>%s<span style='color:white'>%02d:%02d:%02d</span></body></html>";


	// TODO: set some kind of maximum for the amount of tasks to be tracked in a session
	private static final int MAX_TASK_BOXES = 50;

	// When there are no tasks, display this
	private final PluginErrorPanel errorPanel = new PluginErrorPanel();

	// Handle task boxes
	private final JPanel tasksContainer = new JPanel();

	// Handle overall slayer session data
	private final JPanel overallPanel = new JPanel();
	private final JLabel overallKillsLabel = new JLabel();
	private final JLabel overallTimeLabel = new JLabel();
	private final JLabel overallIcon = new JLabel();

	// Actions
	private final JPanel actionsContainer = new JPanel();
	private final JLabel playBtn = new JLabel();
	private final JLabel pauseBtn = new JLabel();

	// Log tasks
	private final List<TaskBox> tasks = new ArrayList<>();

	private SlayerPlugin slayerPlugin;

	public SlayerTaskPanel(SlayerPlugin slayerPlugin)
	{
		this.slayerPlugin = slayerPlugin;

		setBorder(new EmptyBorder(6, 6, 6, 6));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		// Create layout panel for wrapping
		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BoxLayout(layoutPanel, BoxLayout.Y_AXIS));
		add(layoutPanel, BorderLayout.NORTH);

		actionsContainer.setLayout(new GridLayout(1, 2, 10, 0));
		actionsContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		actionsContainer.setPreferredSize(new Dimension(0, 30));
		actionsContainer.setBorder(new EmptyBorder(5, 5, 5, 10));
		actionsContainer.setVisible(false);

		playBtn.setText("->");
		playBtn.setToolTipText("Resume the current slayer task");
		playBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				slayerPlugin.setPaused(false);
			}
		});

		pauseBtn.setText("||");
		pauseBtn.setToolTipText("Pause the current slayer task");
		pauseBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				slayerPlugin.setPaused(true);
			}
		});

		actionsContainer.add(playBtn);
		actionsContainer.add(pauseBtn);

		// Create panel that will contain overall data
		overallPanel.setBorder(new EmptyBorder(8, 10, 8, 10));
		overallPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallPanel.setLayout(new BorderLayout());
		overallPanel.setVisible(false);

		// Add contents
		final JPanel overallInfo = new JPanel();
		overallInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallInfo.setLayout(new GridLayout(2, 1));
		overallInfo.setBorder(new EmptyBorder(2, 10, 2, 0));
		overallKillsLabel.setFont(FontManager.getRunescapeSmallFont());
		overallTimeLabel.setFont(FontManager.getRunescapeSmallFont());
		overallInfo.add(overallKillsLabel);
		overallInfo.add(overallTimeLabel);
		overallPanel.add(overallIcon, BorderLayout.WEST);
		overallPanel.add(overallInfo, BorderLayout.CENTER);

		tasksContainer.setLayout(new BoxLayout(tasksContainer, BoxLayout.Y_AXIS));
		layoutPanel.add(actionsContainer);
		layoutPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		layoutPanel.add(overallPanel);
		layoutPanel.add(tasksContainer);

		// Add error pane
		errorPanel.setContent("Task trackers", "You have not received any slayer tasks yet.");
		add(errorPanel);
	}

	void loadHeaderIcon(BufferedImage img)
	{
		overallIcon.setIcon(new ImageIcon(img));
	}

	private void updateOverall()
	{
		int overallKills = 0;
		long overallTime = 0;
		for (TaskBox box : tasks)
		{
			overallKills += box.getTaskData().getElapsedKills();
			overallTime += box.getTaskData().getElapsedTime();
		}

		overallKillsLabel.setText(htmlLabel("Total kills: ", overallKills));
		overallTimeLabel.setText(htmlLabel("Total time: ", overallTime));
	}

	private static boolean isEmptyTask(TaskData taskData)
	{
		return taskData.getTaskName().equals("") && taskData.getAmount() == 0 && taskData.getInitialAmount() == 0;
	}

	private void showMainView()
	{
		remove(errorPanel);
		actionsContainer.setVisible(true);
		overallPanel.setVisible(true);
	}

	private TaskBox buildBox(SlayerPlugin plugin, JPanel container, TaskData data)
	{
		TaskBox newBox = new TaskBox(plugin, container, data.toBuilder().build());
		tasks.add(0, newBox);
		showMainView();
		return newBox;
	}

	void updateCurrentTask(boolean updated, boolean paused, TaskData newData, boolean isNewAssignment)
	{
		// important case for if the current task is completed so the update will show the empty task
		if (isEmptyTask(newData))
		{
			if (tasks.isEmpty()) // if there is no current task an empty task doesn't do anything
			{
				return;
			}
			System.out.println("empty task sent so ending current task");
			TaskBox current = tasks.get(0);
			// current task has ended so it should be paused
			current.update(true, true, current.getTaskData());
			return;
		}

		if (tasks.isEmpty() || isNewAssignment)
		{
			System.out.println("new task is set");

			// new task so append it to the front of the list
			SwingUtilities.invokeLater(() -> {
				TaskBox newBox = buildBox(slayerPlugin, tasksContainer, newData);
				newBox.update(true, newData.isPaused(), newData);
			});
			return;
		}
		else
		{
			// if here there is a current task so check if the current task matches
			// the update being sent
			TaskBox current = tasks.get(0);
			System.out.println("current task: " + current.getTaskData().getTaskName() + " " +
				current.getTaskData().getTaskLocation() + " " + current.getTaskData().getInitialAmount());
			System.out.println("new task: " + newData.getTaskName() + " " + newData.getTaskLocation() +
				" " + newData.getInitialAmount());
			if (!current.getTaskData().getTaskName().equals(newData.getTaskName()) ||
					!current.getTaskData().getTaskLocation().equals(newData.getTaskLocation()) ||
					current.getTaskData().getInitialAmount() != newData.getInitialAmount())
			{
				// current task does not match the update being sent so the current task
				// must have been outdated - this is necessarily true because if a true
				// new task was sent it would have set the isNewAssignment flag
				System.out.println("task does not match must create new match");

				// so this previous task is invalid so delete it then add in the new actually
				// correct task
				SwingUtilities.invokeLater(() -> {
					tasksContainer.remove(tasks.get(0));
					tasks.remove(0);
					TaskBox newBox = buildBox(slayerPlugin, tasksContainer, newData);
					newBox.update(true, newData.isPaused(), newData);
				});
				return;
			}
		}

		System.out.println("simply updating task");
		System.out.println("task panel size = " + tasks.size());
		System.out.println("task elapsed time " + tasks.get(0).getTaskData().getElapsedTime());
		System.out.println("task elapsed kills " + tasks.get(0).getTaskData().getElapsedKills());
		// not an empty assignment or a new assignment so just update the current assignment
		TaskBox current = tasks.get(0);
		current.update(updated, paused, newData);

		// update the overall stats once this task stats are updated
		updateOverall();
	}

	static String htmlLabel(String key, long timeMillis)
	{
		if (timeMillis == Long.MAX_VALUE)
		{
			String valueStr = "N/A";
			return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR),
					key, valueStr);
		}
		else
		{
			long seconds = timeMillis / MILLIS_PER_SECOND;
			long minutes = seconds / SECONDS_PER_MINUTE;
			seconds %= 60;
			long hours = minutes / MINUTES_PER_HOUR;
			minutes %= 60;
			return String.format(HTML_TIME_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR),
					key, (int) hours, (int) minutes, (int) seconds);
		}
	}

	static String htmlLabel(String key, int value)
	{
		String valueStr = StackFormatter.quantityToRSDecimalStack(value);
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR),
				key, valueStr);
	}

}
