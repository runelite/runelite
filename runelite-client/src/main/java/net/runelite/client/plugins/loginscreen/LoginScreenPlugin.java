/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.loginscreen;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.inject.Provides;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.SpritePixels;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.OSType;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@PluginDescriptor(
	name = "Login Screen",
	description = "Provides various enhancements for login screen"
)
@Slf4j
public class LoginScreenPlugin extends Plugin implements KeyListener
{
	private static final int MAX_USERNAME_LENGTH = 254;
	private static final int MAX_PIN_LENGTH = 6;
	private static final File CUSTOM_LOGIN_SCREEN_FILE = new File(RuneLite.RUNELITE_DIR, "login.png");
	private static final File LOGINSCREENS = new File(RuneLite.CACHE_DIR, "loginscreens");

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private LoginScreenConfig config;

	@Inject
	private KeyManager keyManager;

	@Inject
	private OkHttpClient okHttpClient;

	@Inject
	@Named("runelite.static.base")
	private HttpUrl staticBase;

	private String usernameCache;

	@Override
	protected void startUp() throws Exception
	{
		applyUsername();
		keyManager.registerKeyListener(this);
		clientThread.invoke(this::overrideLoginScreen);
	}

	@Override
	protected void shutDown() throws Exception
	{
		if (config.syncUsername())
		{
			client.getPreferences().setRememberedUsername(usernameCache);
		}

		keyManager.unregisterKeyListener(this);
		clientThread.invoke(() ->
		{
			restoreLoginScreen();
			client.setShouldRenderLoginScreenFire(true);
		});
	}

	@Provides
	LoginScreenConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LoginScreenConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("loginscreen"))
		{
			clientThread.invoke(this::overrideLoginScreen);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (!config.syncUsername())
		{
			return;
		}

		if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			applyUsername();
		}
		else if (event.getGameState() == GameState.LOGGED_IN)
		{
			String username = "";

			if (client.getPreferences().getRememberedUsername() != null)
			{
				username = client.getUsername();
			}

			if (config.username().equals(username))
			{
				return;
			}

			log.debug("Saving username: {}", username);
			config.username(username);
		}
	}

	@Subscribe
	public void onProfileChanged(ProfileChanged profileChanged)
	{
		// configuation for the account is available now, so update the username
		applyUsername();
	}

	private void applyUsername()
	{
		if (!config.syncUsername())
		{
			return;
		}

		GameState gameState = client.getGameState();
		if (gameState == GameState.LOGIN_SCREEN)
		{
			String username = config.username();

			if (Strings.isNullOrEmpty(username))
			{
				return;
			}

			// Save it only once
			if (usernameCache == null)
			{
				usernameCache = client.getPreferences().getRememberedUsername();
			}

			client.getPreferences().setRememberedUsername(username);
		}
	}

	@Override
	public boolean isEnabledOnLoginScreen()
	{
		return true;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (!config.pasteEnabled() ||
			(client.getGameState() != GameState.LOGIN_SCREEN && client.getGameState() != GameState.LOGIN_SCREEN_AUTHENTICATOR))
		{
			return;
		}

		// enable pasting on macOS with the Command (meta) key
		boolean isModifierDown = OSType.getOSType() == OSType.MacOS ? e.isMetaDown() : e.isControlDown();

		if (e.getKeyCode() == KeyEvent.VK_V && isModifierDown)
		{
			try
			{
				String data = Toolkit
					.getDefaultToolkit()
					.getSystemClipboard()
					.getData(DataFlavor.stringFlavor)
					.toString()
					.trim();

				switch (client.getLoginIndex())
				{
					// Username/password form
					case 2:
						if (client.getCurrentLoginField() == 0)
						{
							// Truncate data to maximum username length if necessary
							client.setUsername(data.substring(0, Math.min(data.length(), MAX_USERNAME_LENGTH)));
						}

						break;
					// Authenticator form
					case 4:
						// Truncate data to maximum OTP code length if necessary
						data = CharMatcher.inRange('0', '9').retainFrom(data);
						client.setOtp(data.substring(0, Math.min(data.length(), MAX_PIN_LENGTH)));
						break;
				}
			}
			catch (UnsupportedFlavorException | IOException ex)
			{
				log.warn("failed to fetch clipboard data", ex);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}

	private void overrideLoginScreen()
	{
		client.setShouldRenderLoginScreenFire(config.showLoginFire());

		LoginScreenOverride loginScreen = config.loginScreen();
		if (loginScreen == LoginScreenOverride.OFF)
		{
			restoreLoginScreen();
			return;
		}

		if (loginScreen == LoginScreenOverride.CUSTOM)
		{
			if (CUSTOM_LOGIN_SCREEN_FILE.exists())
			{
				try
				{
					BufferedImage image;
					synchronized (ImageIO.class)
					{
						image = ImageIO.read(CUSTOM_LOGIN_SCREEN_FILE);
					}

					if (image.getHeight() > Constants.GAME_FIXED_HEIGHT)
					{
						final double scalar = Constants.GAME_FIXED_HEIGHT / (double) image.getHeight();
						image = ImageUtil.resizeImage(image, (int) (image.getWidth() * scalar), Constants.GAME_FIXED_HEIGHT);
					}
					SpritePixels pixels = ImageUtil.getImageSpritePixels(image, client);
					client.setLoginScreen(pixels);
				}
				catch (IOException e)
				{
					log.error("error loading custom login screen", e);
					restoreLoginScreen();
				}
			}
		}
		else
		{
			if (loginScreen == LoginScreenOverride.RANDOM)
			{
				LoginScreenOverride[] filtered = Arrays.stream(LoginScreenOverride.values())
					.filter(screen -> screen.getFileName() != null)
					.toArray(LoginScreenOverride[]::new);
				loginScreen = filtered[new Random().nextInt(filtered.length)];
			}

			fetchLoginScreenImage(loginScreen, image -> clientThread.invoke(() ->
			{
				SpritePixels pixels = ImageUtil.getImageSpritePixels(image, client);
				client.setLoginScreen(pixels);
			}));
		}
	}

	private void restoreLoginScreen()
	{
		client.setLoginScreen(null);
	}

	private void fetchLoginScreenImage(LoginScreenOverride ls, Consumer<BufferedImage> imageConsumer)
	{
		File imagePath = new File(LOGINSCREENS, ls.getFileName());

		try
		{
			if (imagePath.exists())
			{
				String hash = Files.asByteSource(imagePath).hash(Hashing.sha256()).toString();
				if (hash.equals(ls.getHash()))
				{
					BufferedImage image;
					try (var in = Files.asByteSource(imagePath).openStream())
					{
						synchronized (ImageIO.class)
						{
							image = ImageIO.read(in);
						}
					}

					log.debug("Using cached login screen {}", ls.getFileName());

					imageConsumer.accept(image);
					return;
				}
			}
		}
		catch (IOException ex)
		{
			log.debug(null, ex);
		}

		log.info("Downloading login screen {}", ls.getFileName());

		HttpUrl url = staticBase.newBuilder()
			.addPathSegments("loginscreens/" + ls.getFileName())
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		okHttpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				LOGINSCREENS.mkdirs();

				try (response; var in = response.body().byteStream())
				{
					Files.asByteSink(imagePath).writeFrom(in);
				}

				BufferedImage image;
				try (var in = Files.asByteSource(imagePath).openStream())
				{
					synchronized (ImageIO.class)
					{
						image = ImageIO.read(in);
					}
				}
				imageConsumer.accept(image);
			}

			@Override
			public void onFailure(Call call, IOException e)
			{
				log.error("unable to download login screen {}", ls, e);
			}
		});
	}
}