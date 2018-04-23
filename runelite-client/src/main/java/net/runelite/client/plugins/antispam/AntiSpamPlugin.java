package net.runelite.client.plugins.antispam;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.ChatLineBuffer;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.SetMessage;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

@PluginDescriptor(name = "Anti-spam")
public class AntiSpamPlugin extends Plugin {

	public Set<String> blacklist = new HashSet<>();

	@Inject
	private Client client;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Override
	protected void startUp() throws Exception
	{
		blacklist("G'O-<gt>Rsma||s  S e||  a'(( & G o'Ld  every0ne can enj0y 1o% D is'c0unt.");
		blacklist("Doubling");
	}

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		System.out.println(setMessage);
		MessageNode messageNode = setMessage.getMessageNode();
		if (isSpam(messageNode.getValue())) {
			messageNode.setName("spammer");
			setMessage.setMessageNode(messageNode);
			messageNode.setRuneLiteFormatMessage("Hey, everyone, I just tried to do something very silly!");
			chatMessageManager.update(messageNode);
			client.refreshChat();
		}
		System.out.println(setMessage);
	}

	private boolean isSpam(String message) {
//		return true;
		for (String blacklisted: blacklist) {
			if (message.contains(blacklisted)) {
				return true;
			}
		}
		return false;
	}

	private void blacklist(String message) {
		blacklist.add(message);
	}
}
