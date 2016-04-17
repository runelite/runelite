package net.runelite.client.ui;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class ClientUI extends JFrame implements ComponentListener
{	
	private static final Logger log = Logger.getLogger(ClientUI.class.getName());

	private ClientPanel panel;

	public ClientUI() throws Exception
	{
		init();
		pack();
		setTitle("RuneLite");
		setLocationRelativeTo(getOwner());
		setMinimumSize(getSize());
		setResizable(true);
		this.addComponentListener(this);
	}
	
	private void init() throws Exception
	{
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				checkExit();
			}
		});
		
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored)
		{
		}

		panel = new ClientPanel();
		add(panel);
	}

	private void checkExit()
	{
		int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION)
		{
			System.exit(0);
		}
	}

	@Override
	public void componentResized(ComponentEvent e)
	{
		SwingUtilities.invokeLater(() -> pack()); // is this right?
	}

	@Override
	public void componentMoved(ComponentEvent e)
	{
	}

	@Override
	public void componentShown(ComponentEvent e)
	{
	}

	@Override
	public void componentHidden(ComponentEvent e)
	{
	}
}