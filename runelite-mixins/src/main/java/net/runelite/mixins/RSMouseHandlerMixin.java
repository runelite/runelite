package net.runelite.mixins;

import java.awt.event.MouseEvent;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSMouseHandler;

@Mixin(RSMouseHandler.class)
public abstract class RSMouseHandlerMixin implements RSMouseHandler
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private int isInEvent;

	@Copy("mousePressed")
	abstract void rs$mousePressed(MouseEvent mouseEvent);

	@Copy("mouseReleased")
	abstract void rs$mouseReleased(MouseEvent mouseEvent);

	@Copy("mouseClicked")
	abstract void rs$mouseClicked(MouseEvent mouseEvent);

	@Copy("mouseEntered")
	abstract void rs$mouseEntered(MouseEvent mouseEvent);

	@Copy("mouseExited")
	abstract void rs$mouseExited(MouseEvent mouseEvent);

	@Copy("mouseDragged")
	abstract void rs$mouseDragged(MouseEvent mouseEvent);

	@Copy("mouseMoved")
	abstract void rs$mouseMoved(MouseEvent mouseEvent);

	@Override
	@Replace("mousePressed")
	public synchronized void mousePressed(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mousePressed(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mousePressed(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}

	@Override
	@Replace("mouseReleased")
	public synchronized void mouseReleased(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseReleased(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mouseReleased(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}

	@Override
	@Replace("mouseClicked")
	public void mouseClicked(MouseEvent event)
	{
		event = client.getCallbacks().mouseClicked(event);
		if (!event.isConsumed())
		{
			rs$mouseClicked(event);
		}
	}

	@Override
	@Replace("mouseEntered")
	public synchronized void mouseEntered(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseEntered(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mouseEntered(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}


	@Override
	@Replace("mouseExited")
	public synchronized void mouseExited(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseExited(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mouseExited(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}

	@Override
	@Replace("mouseDragged")
	public synchronized void mouseDragged(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseDragged(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mouseDragged(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}

	@Override
	@Replace("mouseMoved")
	public synchronized void mouseMoved(MouseEvent mouseEvent)
	{
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseMoved(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mouseMoved(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
		}
	}
}
