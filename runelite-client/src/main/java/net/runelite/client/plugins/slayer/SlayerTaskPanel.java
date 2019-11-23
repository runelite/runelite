package net.runelite.client.plugins.slayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.QuantityFormatter;

@Singleton
class SlayerTaskPanel extends PluginPanel
{
	private static final long MILLIS_PER_SECOND = 1000;
	private static final long SECONDS_PER_MINUTE = 60;
	private static final long MINUTES_PER_HOUR = 60;

	// Templates
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";
	private static final String HTML_TIME_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%02d:%02d:%02d</span></body></html>";


	private static final ImageIcon PAUSE, PAUSE_FADED, PAUSE_HOVER;
	private static final ImageIcon PLAY, PLAY_FADED, PLAY_HOVER;

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

	static
	{
		final BufferedImage pauseImg = ImageUtil.getResourceStreamFromClass(SlayerPlugin.class, "pause_icon.png");
		final BufferedImage playImg = ImageUtil.getResourceStreamFromClass(SlayerPlugin.class, "play_icon.png");

		PAUSE = new ImageIcon(pauseImg);
		PAUSE_FADED = new ImageIcon(ImageUtil.alphaOffset(pauseImg, -180));
		PAUSE_HOVER = new ImageIcon(ImageUtil.alphaOffset(pauseImg, -220));

		PLAY = new ImageIcon(playImg);
		PLAY_FADED = new ImageIcon(ImageUtil.alphaOffset(playImg, -180));
		PLAY_HOVER = new ImageIcon(ImageUtil.alphaOffset(playImg, -220));
	}

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

		actionsContainer.setLayout(new BorderLayout());
		actionsContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		actionsContainer.setPreferredSize(new Dimension(0, 30));
		actionsContainer.setBorder(new EmptyBorder(5, 5, 5, 10));
		actionsContainer.setVisible(false);

		final JPanel controlsPanel = new JPanel(new GridLayout(1, 2, 10, 0));
		controlsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		playBtn.setIcon(PLAY);
		playBtn.setToolTipText("Resume the current slayer task");
		playBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				slayerPlugin.setPaused(false);
				changePauseState(false);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				boolean paused = true;
				TaskData currentTask = slayerPlugin.getCurrentTask();
				if (currentTask != null)
				{
					paused = currentTask.isPaused();
				}
				playBtn.setIcon(paused ? PLAY_FADED : PLAY);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				boolean paused = true;
				TaskData currentTask = slayerPlugin.getCurrentTask();
				if (currentTask != null)
				{
					paused = currentTask.isPaused();
				}
				playBtn.setIcon(paused ? PLAY_HOVER : PLAY);
			}
		});

		pauseBtn.setIcon(PAUSE);
		pauseBtn.setToolTipText("Pause the current slayer task");
		pauseBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				slayerPlugin.setPaused(true);
				changePauseState(true);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				boolean paused = true;
				TaskData currentTask = slayerPlugin.getCurrentTask();
				if (currentTask != null)
				{
					paused = currentTask.isPaused();
				}
				pauseBtn.setIcon(paused ? PAUSE : PAUSE_FADED);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				boolean paused = true;
				TaskData currentTask = slayerPlugin.getCurrentTask();
				if (currentTask != null)
				{
					paused = currentTask.isPaused();
				}
				pauseBtn.setIcon(paused ? PAUSE : PAUSE_HOVER);
			}
		});

		controlsPanel.add(playBtn);
		controlsPanel.add(pauseBtn);

		actionsContainer.add(controlsPanel, BorderLayout.EAST);
		changePauseState(true);
		if (slayerPlugin.getCurrentTask() != null)
		{
			changePauseState(slayerPlugin.getCurrentTask().isPaused());
		}

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

	private void changePauseState(boolean paused)
	{
		playBtn.setIcon(paused ? PLAY_FADED : PLAY);
		pauseBtn.setIcon(paused ? PAUSE : PAUSE_FADED);
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
		return (taskData.getTaskName() == null || taskData.getTaskName().equals("")) && taskData.getAmount() == 0 && taskData.getInitialAmount() == 0;
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

	private boolean stringsEqualIncludeNull(String str0, String str1)
	{
		if (str0 == null && str1 == null)
		{
			return true; // both are null
		}
		else if (str0 == null || str1 == null)
		{
			return false; // only 1 is null
		}
		else
		{
			// none are null so equals check is safe
			return str0.equals(str1);
		}
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
			TaskBox current = tasks.get(0);
			// current task has ended even though it should still have 1 amount remaining b/c the ending chat message
			// pops before the slayer xp drop so we need to force the remaining kc to zero and add the last kc to
			// the elapsed kc
			if (current.getTaskData().getAmount() != 0) // must check not equal zero b/c otherwise this would constantly tick
			{
				int amountDelta = current.getTaskData().getAmount();
				current.getTaskData().setAmount(0);
				current.getTaskData().setElapsedKills(current.getTaskData().getElapsedKills() + amountDelta);
				// current task has ended so it should be paused
				current.update(true, true, current.getTaskData());
				updateOverall();
			}
			return;
		}

		if (tasks.isEmpty() || isNewAssignment)
		{
			// new task so append it to the front of the list
			SwingUtilities.invokeLater(() ->
			{
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
			if (!stringsEqualIncludeNull(current.getTaskData().getTaskName(), newData.getTaskName()) ||
				!stringsEqualIncludeNull(current.getTaskData().getTaskLocation(), newData.getTaskLocation()) ||
				current.getTaskData().getInitialAmount() != newData.getInitialAmount())
			{
				// current task does not match the update being sent so the current task
				// must have been outdated - this is necessarily true because if a true
				// new task was sent it would have set the isNewAssignment flag

				// so this previous task is invalid so delete it then add in the new actually
				// correct task
				SwingUtilities.invokeLater(() ->
				{
					tasksContainer.remove(tasks.get(0));
					tasks.remove(0);
					TaskBox newBox = buildBox(slayerPlugin, tasksContainer, newData);
					newBox.update(true, newData.isPaused(), newData);
				});
				return;
			}
		}

		// not an empty assignment or a new assignment so just update the current assignment
		TaskBox current = tasks.get(0);
		current.update(updated, paused, newData);

		// update the overall stats once this task stats are updated
		updateOverall();
		changePauseState(paused);
	}

	private static String htmlLabel(String key, long timeMillis)
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

	private static String htmlLabel(String key, int value)
	{
		String valueStr = QuantityFormatter.quantityToRSDecimalStack(value);
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR),
			key, valueStr);
	}

}