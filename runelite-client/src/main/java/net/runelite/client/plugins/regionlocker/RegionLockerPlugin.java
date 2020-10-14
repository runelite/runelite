/*
 * Copyright (c) 2019, Slay to Stay <https://github.com/slaytostay>
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
package net.runelite.client.plugins.regionlocker;

import com.google.inject.Provides;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.Point;
import net.runelite.api.RenderOverview;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatInput;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.Text;
import static net.runelite.client.util.Text.sanitize;
import net.runelite.http.api.chat.ChatClient;

@PluginDescriptor(
		name = RegionLockerPlugin.PLUGIN_NAME,
		description = "Settings for the ChunkLite client.",
		tags = {"region", "locker", "chunk", "map", "square"}
)
public class RegionLockerPlugin extends Plugin
{
	static final String PLUGIN_NAME = "ChunkLite";
	static final String CONFIG_KEY = "regionlocker";
	private static final String CHUNK_COMMAND = "!chunks";
	//private final ChatClient chatClient = new ChatClient();

	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RegionLockerConfig config;

	@Inject
	private RegionLockerOverlay regionLockerOverlay;

	@Inject
	private RegionBorderOverlay regionBorderOverlay;

	@Inject
	private RegionLockerInput inputListener;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ChatCommandManager chatCommandManager;

	@Inject
	private ScheduledExecutorService executor;

	@Setter(AccessLevel.PACKAGE)
	private boolean unlockKeyPressed = false;

	@Setter(AccessLevel.PACKAGE)
	private boolean blockKeyPressed = false;

	private RegionLocker regionLocker;
	private NavigationButton titleBarButton;

	@Provides
	RegionLockerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RegionLockerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		chatCommandManager.registerCommandAsync(CHUNK_COMMAND, this::chunkAmountLookup, this::chunkAmountSubmit);
		regionLocker = new RegionLocker(client, config, configManager);
		overlayManager.add(regionLockerOverlay);
		overlayManager.add(regionBorderOverlay);
		keyManager.registerKeyListener(inputListener);
		setKeys();
		setButton(config.chunkPickerButton());
	}

	@Override
	protected void shutDown() throws Exception
	{
		chatCommandManager.unregisterCommand(CHUNK_COMMAND);
		overlayManager.remove(regionLockerOverlay);
		overlayManager.remove(regionBorderOverlay);
		keyManager.unregisterKeyListener(inputListener);
		RegionLocker.renderLockedRegions = false;
		setButton(false);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(RegionLockerPlugin.CONFIG_KEY))
		{
			return;
		}

		setKeys();
		setButton(config.chunkPickerButton());
		regionLocker.readConfig();
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			unlockKeyPressed = false;
			blockKeyPressed = false;
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
		if (!(unlockKeyPressed || blockKeyPressed) || map == null) return;

		RenderOverview ro = client.getRenderOverview();
		Float pixelsPerTile = ro.getWorldMapZoom();

		Rectangle worldMapRect = map.getBounds();
		int widthInTiles = (int) Math.ceil(worldMapRect.getWidth() / pixelsPerTile);
		int heightInTiles = (int) Math.ceil(worldMapRect.getHeight() / pixelsPerTile);

		Point worldMapPosition = ro.getWorldMapPosition();

		int yTileMin = worldMapPosition.getY() - heightInTiles / 2;

		Point mousePos = client.getMouseCanvasPosition();

		int tx = (int) ((mousePos.getX() - worldMapRect.getX()) / pixelsPerTile);
		int ty = (int) ((mousePos.getY() - worldMapRect.getX() - worldMapRect.height) / pixelsPerTile);

		int x = tx - widthInTiles / 2 + worldMapPosition.getX();
		int y = -ty + yTileMin;

		int regionId = ((x >> 6) << 8) | (y >> 6);

		if (unlockKeyPressed) regionLocker.addRegion(regionId);
		if (blockKeyPressed) regionLocker.blockRegion(regionId);
	}

	private void setKeys()
	{
		RegionLockerInput.UNLOCK_KEY = config.unlockKey();
		RegionLockerInput.BLOCK_KEY = config.blacklistKey();
	}

	private void setButton(boolean enabled)
	{
		if (enabled)
		{
			final BufferedImage iconImage = ImageUtil.getResourceStreamFromClass(getClass(), "chunk.png");

			titleBarButton = NavigationButton.builder()
					.tab(false)
					.tooltip("Go to Chunk Picker")
					.icon(iconImage)
					.onClick(() -> LinkBrowser.browse(ChunkPickerLink.getUrl()))
					.build();

			clientToolbar.addNavigation(titleBarButton);
		}
		else
		{
			clientToolbar.removeNavigation(titleBarButton);
		}
	}

	private boolean chunkAmountSubmit(ChatInput chatInput, String value)
	{
		final int kc = Text.fromCSV(config.unlockedRegions()).size();
		if (kc <= 0)
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();
		/*
		executor.execute(() ->
		{
			try
			{
				chatClient.submitKc(playerName, "chunks", kc);
			}
			catch (Exception ex)
			{

			}
			finally
			{
				chatInput.resume();
			}
		});

		 */

		return true;
	}

	private void chunkAmountLookup(ChatMessage chatMessage, String message)
	{
		if (!config.chunkCommand()) return;

		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type.equals(ChatMessageType.PRIVATECHATOUT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = sanitize(chatMessage.getName());
		}
		int kc = 0;
		/*
		try
		{
			//kc = chatClient.getKc(player, "chunks");
		}
		catch (IOException ex)
		{
			return;
		}
		*/
		String response = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Total chunks")
				.append(ChatColorType.NORMAL)
				.append(" unlocked: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(kc))
				.build();

		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}
}
