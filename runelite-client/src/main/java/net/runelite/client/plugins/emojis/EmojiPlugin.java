/*
 * Copyright (c) 2019, Lotto <https://github.com/devLotto>
 * Copyright (c) 2025, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.emojis;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.common.util.concurrent.Runnables;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ChatIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.VisibleForTesting;

@PluginDescriptor(
	name = "Emojis",
	description = "Replaces common emoticons such as :) with their corresponding emoji in the chat",
	enabledByDefault = false
)
@Slf4j
public class EmojiPlugin extends Plugin
{
	private static final File EMOJI_DIR = new File(RuneLite.CACHE_DIR, "emojis");

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatIconManager chatIconManager;

	@Inject
	private OkHttpClient okHttpClient;

	@Inject
	private Gson gson;

	@Inject
	private ScheduledExecutorService scheduledExecutorService;

	@Inject
	@Named("runelite.static.base")
	private HttpUrl staticBase;

	@VisibleForTesting
	Index index;
	private final Map<String, Integer> imageCache = new HashMap<>();

	@Override
	protected void startUp()
	{
		scheduledExecutorService.execute(this::initEmojiCache);
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		switch (chatMessage.getType())
		{
			case PUBLICCHAT:
			case MODCHAT:
			case FRIENDSCHAT:
			case CLAN_CHAT:
			case CLAN_GUEST_CHAT:
			case CLAN_GIM_CHAT:
			case PRIVATECHAT:
			case PRIVATECHATOUT:
			case MODPRIVATECHAT:
				break;
			default:
				return;
		}

		final MessageNode messageNode = chatMessage.getMessageNode();
		final String message = messageNode.getValue();
		final String updatedMessage = updateMessage(message);

		if (updatedMessage == null)
		{
			return;
		}

		messageNode.setValue(updatedMessage);
	}

	@Subscribe
	public void onOverheadTextChanged(final OverheadTextChanged event)
	{
		if (!(event.getActor() instanceof Player))
		{
			return;
		}

		final String message = event.getOverheadText();
		final String updatedMessage = updateMessage(message);

		if (updatedMessage == null)
		{
			return;
		}

		event.getActor().setOverheadText(updatedMessage);
	}

	@Nullable
	String updateMessage(final String message)
	{
		if (index == null)
		{
			return null;
		}

		String editedMessage = message;
		int idxStart = -1;
		int idxStartWs = -1;
		for (int i = 0; i < message.length(); ++i)
		{
			char c = message.charAt(i);

			if (Character.isWhitespace(c) || c == '\u00A0' || i + 1 == message.length())
			{
				int idxEndWs = i + 1 == message.length() ? message.length() : i;
				String shortname = Text.removeFormattingTags(message.substring(idxStartWs + 1, idxEndWs));
				idxStartWs = i;

				final Emoji emoji = Emoji.getEmoji(shortname);
				if (emoji != null)
				{
					String id = Integer.toHexString(emoji.codepoint);
					int emojiId = getEmojiChatIconIndex(emoji.name(), id);
					editedMessage = editedMessage.replace(shortname, "<img=" + chatIconManager.chatIconIndex(emojiId) + ">");
				}
			}

			if (c == ':')
			{
				if (idxStart == -1)
				{
					idxStart = i;
				}
				else
				{
					String emojiName = message.substring(idxStart + 1, i);
					idxStart = -1;

					String id = index.names.get(emojiName);
					if (id != null)
					{
						int emojiId = getEmojiChatIconIndex(emojiName, id);
						editedMessage = editedMessage.replace(":" + emojiName + ":", "<img=" + chatIconManager.chatIconIndex(emojiId) + ">");
					}
				}
			}
		}

		return message == editedMessage ? null : editedMessage;
	}

	private int getEmojiChatIconIndex(String name, String codepoint)
	{
		Integer emojiId = imageCache.get(codepoint);
		if (emojiId != null)
		{
			return emojiId;
		}

		int iconId = chatIconManager.reserveChatIcon();
		imageCache.put(codepoint, iconId);

		// Kick off load task
		scheduledExecutorService.submit(() ->
		{
			try
			{
				BufferedImage image = loadEmojiFromDisk(name, codepoint);
				chatIconManager.updateChatIcon(iconId, image);
			}
			catch (IOException ex)
			{
				log.error("Unable to load emoji {}", name, ex);
			}
		});

		return iconId;
	}

	private void initEmojiCache()
	{
		EMOJI_DIR.mkdirs();

		File indexFile = new File(EMOJI_DIR, "index.json");
		download("emoji/index.json", indexFile, () ->
		{
			try (var in = new InputStreamReader(Files.asByteSource(indexFile).openStream()))
			{
				index = gson.fromJson(in, Index.class);
			}
			catch (IOException ex)
			{
				log.error("Unable to load emoji index", ex);
			}

			try
			{
				File assetFile = new File(EMOJI_DIR, "assets.zip");
				String hash = Files.asByteSource(assetFile).hash(Hashing.sha256()).toString();
				if (index != null && hash.equals(index.assetsHash))
				{
					log.debug("Emoji assets are up to date");
					return;
				}
			}
			catch (IOException ex)
			{
				log.debug(null, ex);
			}

			log.info("Downloading emoji assets");
			download("emoji/assets.zip", new File(EMOJI_DIR, "assets.zip"), Runnables.doNothing());
		});
	}

	private void download(String srnPath, File to, Runnable cb)
	{
		HttpUrl url = staticBase.newBuilder()
			.addPathSegments(srnPath)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		okHttpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				try (response; var in = response.body().byteStream())
				{
					Files.asByteSink(to).writeFrom(in);
				}
				cb.run();
			}

			@Override
			public void onFailure(Call call, IOException e)
			{
				log.error("Unable to download {}", url, e);
				cb.run();
			}
		});
	}

	private BufferedImage loadEmojiFromDisk(String name, String id) throws IOException
	{
		try (ZipFile zipFile = new ZipFile(new File(EMOJI_DIR, "assets.zip")))
		{
			ZipEntry entry = zipFile.getEntry(id + ".png");
			if (entry != null)
			{
				try (var in = zipFile.getInputStream(entry))
				{
					BufferedImage image;
					synchronized (ImageIO.class)
					{
						image = ImageIO.read(in);
					}

					log.debug("Loaded emoji {}: {}", name, id);
					return image;
				}
			}
			throw new IOException("file " + id + ".png doesn't exist");
		}
	}

	@Data
	static class Index
	{
		Map<String, String> names = Collections.emptyMap();
		@SerializedName("assets_hash")
		String assetsHash;
	}
}
