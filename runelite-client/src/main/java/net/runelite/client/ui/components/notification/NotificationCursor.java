package net.runelite.client.ui.components.notification;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.ui.ColorScheme;
import javax.swing.*;
import java.awt.*;

public class NotificationCursor
{
	// Display Variables
	public JFrame notificationWindow = new JFrame();
	public JPanel notificationPanel = new JPanel();
	public JLabel notificationMessage = new JLabel();

	// Other Variables
	public Timer updater = new Timer(10, e -> updateLocation(notificationWindow));
	public String Message;
	public Client rsclient;
	public int idleStart;

	// Label Stuff
	public Color backgroundColor = ColorScheme.DARK_GRAY_COLOR;
	public Color textColor = ColorScheme.LIGHT_GRAY_COLOR;
	public int padding = 10;
	public int yOffset = 24;

	// Single function to call.
	public void sendNotification(String message, Client client)
	{
		Message = message; // Adds message to variables.
		rsclient = client; // Adds client to variables.
		idleStart = getIdleTicks(client); // Adds the idle start to variables.

		setVisible(false); // Disposes of previous use incase of notification stacking.
		updateText(message); // Adds message to label
		createWindow(); // Create window and add label + panel
	}

	// Creates Window
	public void createWindow()
	{
		// Setup Window Properties
		notificationWindow.setMinimumSize(new Dimension(notificationMessage.getPreferredSize().width + padding, notificationMessage.getPreferredSize().height / 2));
		notificationWindow.setUndecorated(true);
		notificationWindow.setAlwaysOnTop(true);
		notificationWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		//Colors
		notificationPanel.setBackground(backgroundColor);
		notificationMessage.setForeground(textColor);

		// Setup Components
		notificationPanel.add(notificationMessage, BorderLayout.CENTER);
		notificationWindow.add(notificationPanel);

		// Packs and prevent size issue
		notificationWindow.pack();
		notificationWindow.setResizable(false);

		// Setup Updater (Follows Cursor)
		updater.start();

		// Sets Visible
		setVisible(true);
	}

	// Updates Text of Label
	public void updateText(String str)
	{
		notificationMessage.setText(str);
	}

	// Updates Location of Frame to follow cursor
	public void updateLocation(JFrame window)
	{
		Point cursorLocation = MouseInfo.getPointerInfo().getLocation();
		window.setLocation(cursorLocation.x, cursorLocation.y + yOffset);
		if (getIdleTicks(rsclient) == 0 || rsclient.getGameState() != GameState.LOGGED_IN)
		{
			setVisible(false);
		}
	}

	// Get Idle Ticks
	public int getIdleTicks(Client client)
	{
		int idleVal = client.getKeyboardIdleTicks(); // Gets last keyboard input
		if (idleVal > client.getMouseIdleTicks()) // Compares to last mouse input
		{
			idleVal = client.getMouseIdleTicks(); // Updates to lowest
		}
		return idleVal; // Returns Idle Ticks
	}

	// Set Visibility or Dispose if false.
	public void setVisible(boolean option)
	{
		notificationWindow.setVisible(option);
		if (option == false)
		{
			updater.stop();
			notificationWindow.dispose();
		}
	}
}
