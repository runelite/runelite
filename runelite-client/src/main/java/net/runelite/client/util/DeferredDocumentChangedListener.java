package net.runelite.client.util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DeferredDocumentChangedListener implements DocumentListener
{
	private final Timer timer;
	private final List<ChangeListener> listeners;

	public DeferredDocumentChangedListener()
	{
		listeners = new ArrayList<>(25);
		timer = new Timer(200, e -> fireStateChanged());
		timer.setRepeats(false);
	}

	public void addChangeListener(ChangeListener listener)
	{
		listeners.add(listener);
	}

	private void fireStateChanged()
	{
		if (!listeners.isEmpty())
		{
			ChangeEvent evt = new ChangeEvent(this);
			for (ChangeListener listener : listeners)
			{
				listener.stateChanged(evt);
			}
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
		timer.restart();
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		timer.restart();
	}

	@Override
	public void changedUpdate(DocumentEvent e)
	{
		timer.restart();
	}

}
