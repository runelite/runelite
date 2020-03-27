package net.runelite.client.util;

import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.config.OpenOSRSConfig;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.ui.RuneLiteSplashScreen;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

@Slf4j
@Singleton
public class Groups extends ReceiverAdapter
{
	private final OpenOSRSConfig openOSRSConfig;
	private final JChannel channel;

	@Getter(AccessLevel.PUBLIC)
	private int instanceCount;
	@Getter(AccessLevel.PUBLIC)
	private Map<String, List<Address>> messageMap = new HashMap<>();
	@Getter(AccessLevel.PUBLIC)
	private final PublishSubject<Message> messageStringSubject = PublishSubject.create();
	@Getter(AccessLevel.PUBLIC)
	private final PublishSubject<Message> messageObjectSubject = PublishSubject.create();

	@Inject
	public Groups(OpenOSRSConfig openOSRSConfig) throws Exception
	{
		this.openOSRSConfig = openOSRSConfig;

		this.channel = new JChannel(RuneLite.class.getResourceAsStream("/udp.xml"))
			.setName(RuneLite.uuid)
			.setReceiver(this)
			.setDiscardOwnMessages(true)
			.connect("openosrs");
	}

	public void broadcastSring(String command)
	{
		send(null, command);
	}

	public void sendConfig(Address destination, ConfigChanged configChanged)
	{
		if (!openOSRSConfig.localSync() || RuneLiteSplashScreen.showing() || instanceCount < 2)
		{
			return;
		}

		try
		{
			byte[] buffer = Util.objectToByteBuffer(configChanged);
			Message message = new Message()
				.setDest(destination)
				.setBuffer(buffer);

			channel.send(message);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void sendString(String command)
	{
		String[] messageObject = command.split(";");
		String pluginId = messageObject[1];

		messageMap.put(pluginId, new ArrayList<>());

		for (Address member : channel.getView().getMembers())
		{
			if (member.toString().equals(RuneLite.uuid))
			{
				continue;
			}

			messageMap.get(pluginId).add(member);
			send(member, command);
		}
	}

	public void send(Address destination, String command)
	{
		if (!openOSRSConfig.localSync() || RuneLiteSplashScreen.showing() || instanceCount < 2)
		{
			return;
		}

		try
		{
			channel.send(new Message(destination, command));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void viewAccepted(View view)
	{
		instanceCount = view.getMembers().size();
	}

	@Override
	public void receive(Message message)
	{
		if (RuneLiteSplashScreen.showing())
		{
			return;
		}

		if (message.getObject() instanceof String)
		{
			messageStringSubject.onNext(message);
		}
		else
		{
			messageObjectSubject.onNext(message);
		}
	}

	public void close()
	{
		channel.close();
	}
}
