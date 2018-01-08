package net.runelite.client.plugins.stopwatch;

import net.runelite.client.ui.PluginPanel;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.concurrent.ScheduledExecutorService;

public class StopwatchPluginPanel extends PluginPanel
{
	private final StopwatchPlugin stopwatch;
	private JPanel stopwatchPanel;

	@Inject
	ScheduledExecutorService executor;

	@Inject
	public StopwatchPluginPanel(StopwatchPlugin stopwatch)
	{
		this.stopwatch = stopwatch;

		setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setVisible(true);
		stopwatchPanel = new JPanel();
		stopwatchPanel.setLayout(new GridLayout(24, 1));

		JButton startButton = new JButton("Start");
		startButton.setPreferredSize(new Dimension(PANEL_WIDTH, 32));
		startButton.addActionListener((e) -> executor.execute(this::startStopwatch));

		JButton stopButton = new JButton("Stop");
		stopButton.setPreferredSize(new Dimension(PANEL_WIDTH, 32));
		stopButton.addActionListener((e) -> executor.execute(this::stopStopwatch));

		JButton resetButton = new JButton("Reset");
		resetButton.setPreferredSize(new Dimension(PANEL_WIDTH, 32));
		resetButton.addActionListener((e) -> executor.execute(this::resetStopwatch));

		stopwatchPanel.add(startButton);
		stopwatchPanel.add(stopButton);
		stopwatchPanel.add(resetButton);
		JScrollPane scroll = new JScrollPane(stopwatchPanel);
		scroll.add(stopwatchPanel);

		add(stopwatchPanel);
	}

	public void startStopwatch()
	{
		this.stopwatch.startStopwatch();
	}

	public void stopStopwatch()
	{
		this.stopwatch.stopStopwatch();
	}

	public void resetStopwatch()
	{
		this.stopwatch.resetStopwatch();
	}
}
