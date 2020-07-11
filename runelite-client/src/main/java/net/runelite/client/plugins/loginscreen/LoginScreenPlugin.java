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

import com.google.common.base.Strings;
import com.google.inject.Provides;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.SpritePixels;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.OSType;

@PluginDescriptor(
	name = "Login Screen",
	description = "Provides various enhancements for login screen"
)
@Slf4j
public class LoginScreenPlugin extends Plugin implements KeyListener
{
	private static final int MAX_USERNAME_LENGTH = 254;
	private static final int MAX_PIN_LENGTH = 6;
	private static final File LOGIN_SCREEN_FOLDER = new File(RuneLite.RUNELITE_DIR, "backgrounds");
	private static final File CUSTOM_LOGIN_SCREEN_FILE = new File(RuneLite.RUNELITE_DIR, "login.png");
	private static List<SpritePixels> customBackgrounds = new ArrayList<SpritePixels>();
	private Timer timer = new Timer();


	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private LoginScreenConfig config;

	@Inject
	private KeyManager keyManager;

	private String usernameCache;

	@Override
	protected void startUp() throws Exception
	{
		applyUsername();
		keyManager.registerKeyListener(this);
		loadImages();
		clientThread.invoke(this::overrideLoginScreen);
		startRandom();
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
		if (event.getKey().equals("includeCustom"))
		{
			loadImages();
			return;
		}
		if (event.getKey().equals("delay"))
		{
			timer.cancel();
			startRandom();
			return;
		}

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
	public void onSessionOpen(SessionOpen event)
	{
		// configuation for the account is available now, so update the username
		applyUsername();
	}


	public void startRandom()
	{
		if (config.delay() == 0)
		{
			return;
		}
		TimerTask doAsynchronousTask = new TimerTask()
		{
			@Override
			public void run()
			{
				pixels = getRandom();
				client.setLoginScreen(pixels);
			}
		};
		timer = new Timer();
		timer.schedule(doAsynchronousTask, 0, 1000 * config.delay());
	}

	public void loadImages()
	{
		if (config.loginScreen() == LoginScreenOverride.RANDOM)
		{
			for (LoginScreenOverride background : LoginScreenOverride.values())
			{
				if (background.getFileName() != null)
				{
					customBackgrounds.add(getClassPathFileSpritePixels(background.getFileName()));
				}
			}
			loadCustomImages();
		}
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
		if (!config.pasteEnabled() || (
			client.getGameState() != GameState.LOGIN_SCREEN &&
				client.getGameState() != GameState.LOGIN_SCREEN_AUTHENTICATOR))
		{
			return;
		}

		// enable pasting on macOS with the Command (meta) key
		boolean isModifierDown = OSType.getOSType() == OSType.MacOS ? e.isMetaDown() : e.isControlDown();

		if (e.getKeyCode() == KeyEvent.VK_V && isModifierDown)
		{
			try
			{
				final String data = Toolkit
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

	private SpritePixels pixels = null;

	private void overrideLoginScreen()
	{
		client.setShouldRenderLoginScreenFire(config.showLoginFire());
		switch (config.loginScreen())
		{
			case OFF:
				restoreLoginScreen();
				return;
			case CUSTOM:
				if (CUSTOM_LOGIN_SCREEN_FILE.exists())
				{
					pixels = getFileSpritePixels(CUSTOM_LOGIN_SCREEN_FILE);
				}
				break;
			case RANDOM:
				if (config.delay() == 0)
				{
					pixels = getRandom();
					client.setLoginScreen(pixels);
				}
				break;
			default:
				pixels = getClassPathFileSpritePixels(config.loginScreen().getFileName());
		}

		if (pixels != null)
		{
			client.setLoginScreen(pixels);
		}
	}

	private void loadCustomImages()
	{

		if (!config.showCustom())
		{
			return;
		}

		if (!LOGIN_SCREEN_FOLDER.exists())
		{
			return;
		}

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(LOGIN_SCREEN_FOLDER.toPath(), "*.{png,jpg,jpeg}"))
		{
			for (Path entry: stream)
			{
				customBackgrounds.add(getFileSpritePixels(entry.toFile()));
			}
		}
		catch (DirectoryIteratorException | IOException ex)
		{
			log.error("error loading custom images", ex);
			restoreLoginScreen();
			return;
		}

		if (customBackgrounds.size() > 0)
		{
			log.info("Loaded: " + customBackgrounds.size() + " Custom Images");
		}

	}

	private SpritePixels getRandom()
	{
		Random random = new Random();
		return customBackgrounds.get(random.nextInt(customBackgrounds.size()));
	}

	private void restoreLoginScreen()
	{
		client.setLoginScreen(null);
	}

	/**
	 * Takes the name of an image file and returns a SpritePixels object of the image data
	 *
	 * @param file The name of the file
	 * @return A SpritePixels object containing the image data
	 */
	private SpritePixels getClassPathFileSpritePixels(String file)
	{
		try
		{
			log.debug("Loading: {}", file);
			BufferedImage image = ImageUtil.getResourceStreamFromClass(this.getClass(), file);
			return ImageUtil.getImageSpritePixels(image, client);
		}
		catch (RuntimeException ex)
		{
			log.debug("Unable to load image: ", ex);
		}

		return null;
	}

	/**
	 * Takes an image file and returns a SpritePixels object of the image data
	 *
	 * @param file A File object for the image
	 * @return A SpritePixels object containing the image data
	 */
	private SpritePixels getFileSpritePixels(File file)
	{
		try
		{
			BufferedImage image;
			synchronized (ImageIO.class)
			{
				image = ImageIO.read(file);
			}

			if (image.getHeight() > Constants.GAME_FIXED_HEIGHT)
			{
				final double scalar = Constants.GAME_FIXED_HEIGHT / (double) image.getHeight();
				image = ImageUtil.resizeImage(image, (int) (image.getWidth() * scalar), Constants.GAME_FIXED_HEIGHT);
			}

			return ImageUtil.getImageSpritePixels(image, client);
		}
		catch (IOException | NullPointerException e)
		{
			log.error("error loading custom login screen: " + file, e);
			restoreLoginScreen();
			return null;
		}
	}

}