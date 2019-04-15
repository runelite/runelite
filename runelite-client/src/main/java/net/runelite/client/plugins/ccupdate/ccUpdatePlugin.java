package net.runelite.client.plugins.ccupdate;

import com.google.common.collect.Sets;
import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.socket.client.IO;
import io.socket.client.Socket;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ClanMember;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@PluginDescriptor(
		name = " Queue Helper",
		description = "Ba Services' Queue Helper created by Ryan"
)
public class ccUpdatePlugin extends Plugin
{
	public static final MediaType JSON  = MediaType.parse("application/json; charset=utf-8");
	private static final String CLAN_CHAT = "Ba Services";

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;
	private HashSet<ClanMember> previousMembersInClan;
	private String clanChannelName;
	private Socket socket;

	@Inject
	private ccUpdateConfig config;

	@Provides
	ccUpdateConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ccUpdateConfig.class);
	}
	@Override
	protected void startUp() throws Exception
	{
		previousMembersInClan = null;
		socket = IO.socket("https://baservicesserver.now.sh");
		socket.on("new", objects -> {
			JSONArray newRows = (JSONArray) objects[0];
			for (int i = 0; i < newRows.length(); i++) {
				try {
					JSONObject obj = newRows.getJSONObject(i);
					String value = obj.getString("premium");
					if (config.premNotifier()) {
						postChatMessage(value);
					}
				} catch (JSONException exception) {

				}
			}
		});
		socket.connect();
	}

	@Override
	protected void shutDown() throws Exception {
		socket.disconnect();
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		boolean isInClan = client.getLocalPlayer().isClanMember();

		updateClanChatName(isInClan);

		if (isInClan && clanChannelName.equals(CLAN_CHAT))
		{
			HashSet<ClanMember> currentMembers = new HashSet<>(Arrays.asList(client.getClanMembers()));
			if (previousMembersInClan != null)
			{
				Sets.SetView<ClanMember> clanMembersThatJoined = Sets.difference(currentMembers, previousMembersInClan);
				Sets.SetView<ClanMember> clanMembersThatLeft = Sets.difference(previousMembersInClan, currentMembers);

				if (clanMembersThatJoined.size() > 0 || clanMembersThatLeft.size() > 0)
				{
					request(currentMembers);
				}
			}
			else
			{
				request(currentMembers);
			}
			previousMembersInClan = currentMembers;
			return;
		}
		previousMembersInClan = null;
	}

	private void request(Set<ClanMember> currentMembers)
	{
		JsonObject json = createJsonBody(currentMembers);

		RequestBody body = RequestBody.create(JSON, json.toString());
		Request request = new Request.Builder()
				.url("https://baservicesserver.now.sh")
				.post(body)
				.build();

		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException ex)
			{
				//log.warn("error posting clan member update", ex);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				response.body().close();
				//log.debug("request update for clan chat members");
			}
		});
	}

	private void updateClanChatName(boolean isInClan)
	{
		if (isInClan)
		{
			Widget ccOwnerWidget = client.getWidget(WidgetInfo.CLAN_CHAT_OWNER);
			String ownerName = ccOwnerWidget.getText();
			clanChannelName = ownerName.replaceAll("<col=ffffff>|</col>", "");
		}
		else
		{
			clanChannelName = null;
		}
	}

	private JsonObject createJsonBody(Set<ClanMember> currentMembers)
	{
		JsonArray members = new JsonArray();
		for (ClanMember clanMember : currentMembers)
		{
			if (clanMember != null)
			{
				JsonObject member = new JsonObject();
				member.addProperty("name", clanMember.getUsername());
				member.addProperty("rank", clanMember.getRank().getValue());
				members.add(member);
			}
		}

		JsonObject json = new JsonObject();
		json.add("members", members);

		return json;
	}

	private void postChatMessage(String value) {
		String message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append(value)
				.append(" has been added to the premium queue P+?")
				.build();

		chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.GAMEMESSAGE)
				.runeLiteFormattedMessage(message)
				.build());
	}
}
