/*
 *
 *   Copyright (c) 2019, Zeruth <TheRealNull@gmail.com>
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, this
 *      list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *   ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.runelite.client.plugins.openosrs;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import static net.runelite.api.ObjectID.CANNON_BASE;
import net.runelite.api.Player;
import net.runelite.api.Projectile;
import static net.runelite.api.ProjectileID.CANNONBALL;
import static net.runelite.api.ProjectileID.GRANITE_CANNONBALL;
import static net.runelite.api.ScriptID.BANK_PIN_OP;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CannonChanged;
import net.runelite.api.events.CannonPlaced;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.WidgetID;
import static net.runelite.api.widgets.WidgetInfo.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.OpenOSRSConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.HotkeyListener;

@PluginDescriptor(
	loadWhenOutdated = true, // prevent users from disabling
	hidden = true, // prevent users from disabling
	name = "OpenOSRS"
)
@Singleton
@Slf4j
public class OpenOSRSPlugin extends Plugin
{
	private final openosrsKeyListener keyListener = new openosrsKeyListener();

	@Inject
	private OpenOSRSConfig config;

	@Inject
	private KeyManager keyManager;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private EventBus eventBus;

	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");
	private static final int MAX_CBALLS = 30;
	private int cballsLeft;
	private WorldPoint cannonPosition;
	private GameObject cannon;
	private boolean cannonPlaced;
	private boolean skipProjectileCheckThisTick;

	private int entered = -1;
	private int enterIdx;
	private boolean expectInput;
	private boolean detach;
	private Keybind keybind;
	private final HotkeyListener hotkeyListener = new HotkeyListener(() -> this.keybind)
	{
		@Override
		public void hotkeyPressed()
		{
			detach = !detach;
			client.setOculusOrbState(detach ? 1 : 0);
			client.setOculusOrbNormalSpeed(detach ? 36 : 12);
		}
	};

	@Override
	protected void startUp()
	{
		entered = -1;
		enterIdx = 0;
		expectInput = false;
		this.keybind = config.detachHotkey();
		keyManager.registerKeyListener(hotkeyListener);
	}

	@Override
	protected void shutDown()
	{
		entered = 0;
		enterIdx = 0;
		expectInput = false;
		keyManager.unregisterKeyListener(keyListener);
		keyManager.unregisterKeyListener(hotkeyListener);
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("openosrs"))
		{
			return;
		}

		this.keybind = config.detachHotkey();

		if (!config.keyboardPin())
		{
			entered = 0;
			enterIdx = 0;
			expectInput = false;
			keyManager.unregisterKeyListener(keyListener);
		}
	}

	@Subscribe
	private void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		if (!config.keyboardPin())
		{
			return;
		}

		if (e.getEventName().equals("bankpin"))
		{
			int[] intStack = client.getIntStack();
			int intStackSize = client.getIntStackSize();

			// This'll be anywhere from -1 to 3
			// 0 = first number, 1 second, etc
			// Anything other than 0123 means the bankpin interface closes
			int enterIdx = intStack[intStackSize - 1];

			if (enterIdx < 0 || enterIdx > 3)
			{
				keyManager.unregisterKeyListener(keyListener);
				this.enterIdx = 0;
				this.entered = 0;
				expectInput = false;
				return;
			}
			else if (enterIdx == 0)
			{
				keyManager.registerKeyListener(keyListener);
			}

			this.enterIdx = enterIdx;
			expectInput = true;
		}
	}

	@Subscribe
	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM && event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (event.getMessage().equals("You add the furnace."))
		{
			cballsLeft = 0;
			eventBus.post(CannonPlaced.class, new CannonPlaced(true, cannonPosition, cannon));
			eventBus.post(CannonChanged.class, new CannonChanged(null, cballsLeft));
			cannonPlaced = true;
		}

		if (event.getMessage().contains("You pick up the cannon")
			|| event.getMessage().contains("Your cannon has decayed. Speak to Nulodion to get a new one!"))
		{
			cballsLeft = 0;
			eventBus.post(CannonPlaced.class, new CannonPlaced(false, null, null));
			eventBus.post(CannonChanged.class, new CannonChanged(null, cballsLeft));
			cannonPlaced = false;
		}

		if (event.getMessage().startsWith("You load the cannon with"))
		{
			Matcher m = NUMBER_PATTERN.matcher(event.getMessage());
			if (m.find())
			{
				// The cannon will usually refill to MAX_CBALLS, but if the
				// player didn't have enough cannonballs in their inventory,
				// it could fill up less than that. Filling the cannon to
				// cballsLeft + amt is not always accurate though because our
				// counter doesn't decrease if the player has been too far away
				// from the cannon due to the projectiels not being in memory,
				// so our counter can be higher than it is supposed to be.
				int amt = Integer.parseInt(m.group());
				if (cballsLeft + amt >= MAX_CBALLS)
				{
					skipProjectileCheckThisTick = true;
					cballsLeft = MAX_CBALLS;
				}
				else
				{
					cballsLeft += amt;
				}
			}
			else if (event.getMessage().equals("You load the cannon with one cannonball."))
			{
				if (cballsLeft + 1 >= MAX_CBALLS)
				{
					skipProjectileCheckThisTick = true;
					cballsLeft = MAX_CBALLS;
				}
				else
				{
					cballsLeft++;
				}
			}

			eventBus.post(CannonChanged.class, new CannonChanged(null, cballsLeft));
		}

		if (event.getMessage().contains("Your cannon is out of ammo!"))
		{
			skipProjectileCheckThisTick = true;

			// If the player was out of range of the cannon, some cannonballs
			// may have been used without the client knowing, so having this
			// extra check is a good idea.
			cballsLeft = 0;

			eventBus.post(CannonChanged.class, new CannonChanged(null, cballsLeft));
		}

		if (event.getMessage().startsWith("You unload your cannon and receive Cannonball")
			|| event.getMessage().startsWith("You unload your cannon and receive Granite cannonball"))
		{
			skipProjectileCheckThisTick = true;

			cballsLeft = 0;

			eventBus.post(CannonChanged.class, new CannonChanged(null, cballsLeft));
		}
	}

	@Subscribe
	private void onGameTick(GameTick event)
	{
		skipProjectileCheckThisTick = false;
	}

	@Subscribe
	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		final GameObject gameObject = event.getGameObject();

		final Player localPlayer = client.getLocalPlayer();
		if (gameObject.getId() == CANNON_BASE && !cannonPlaced &&
			localPlayer != null && localPlayer.getWorldLocation().distanceTo(gameObject.getWorldLocation()) <= 2 &&
			localPlayer.getAnimation() == AnimationID.BURYING_BONES)
		{
			cannonPosition = gameObject.getWorldLocation();
			cannon = gameObject;
		}
	}

	@Subscribe
	private void onProjectileSpawned(ProjectileSpawned event)
	{
		if (!cannonPlaced)
		{
			return;
		}

		final Projectile projectile = event.getProjectile();

		if ((projectile.getId() == CANNONBALL || projectile.getId() == GRANITE_CANNONBALL) && cannonPosition != null)
		{
			final WorldPoint projectileLoc = WorldPoint.fromLocal(client, projectile.getX1(), projectile.getY1(), client.getPlane());

			if (projectileLoc.equals(cannonPosition) && !skipProjectileCheckThisTick)
			{
				cballsLeft--;
				eventBus.post(CannonChanged.class, new CannonChanged(projectile.getId(), cballsLeft));
			}
		}
	}

	private void handleKey(char c)
	{
		if (client.getWidget(WidgetID.BANK_PIN_GROUP_ID, BANK_PIN_INSTRUCTION_TEXT.getChildId()) == null
			|| !client.getWidget(BANK_PIN_INSTRUCTION_TEXT).getText().equals("First click the FIRST digit.")
			&& !client.getWidget(BANK_PIN_INSTRUCTION_TEXT).getText().equals("Now click the SECOND digit.")
			&& !client.getWidget(BANK_PIN_INSTRUCTION_TEXT).getText().equals("Time for the THIRD digit.")
			&& !client.getWidget(BANK_PIN_INSTRUCTION_TEXT).getText().equals("Finally, the FOURTH digit."))

		{
			entered = 0;
			enterIdx = 0;
			expectInput = false;
			keyManager.unregisterKeyListener(keyListener);
			return;
		}

		if (!expectInput)
		{
			return;
		}

		int num = Character.getNumericValue(c);

		// We gotta copy this cause enteridx changes while the script is executing
		int oldEnterIdx = enterIdx;

		// Script 685 will call 653, which in turn will set expectInput to true
		expectInput = false;
		client.runScript(BANK_PIN_OP, num, enterIdx, entered, BANK_PIN_EXIT_BUTTON.getId(), BANK_PIN_FORGOT_BUTTON.getId(), BANK_PIN_1.getId(), BANK_PIN_2.getId(), BANK_PIN_3.getId(), BANK_PIN_4.getId(), BANK_PIN_5.getId(), BANK_PIN_6.getId(), BANK_PIN_7.getId(), BANK_PIN_8.getId(), BANK_PIN_9.getId(), BANK_PIN_10.getId(), BANK_PIN_FIRST_ENTERED.getId(), BANK_PIN_SECOND_ENTERED.getId(), BANK_PIN_THIRD_ENTERED.getId(), BANK_PIN_FOURTH_ENTERED.getId(), BANK_PIN_INSTRUCTION_TEXT.getId());

		if (oldEnterIdx == 0)
		{
			entered = num * 1000;
		}
		else if (oldEnterIdx == 1)
		{
			entered += num * 100;
		}
		else if (oldEnterIdx == 2)
		{
			entered += num * 10;
		}
	}

	private class openosrsKeyListener implements KeyListener
	{
		private int lastKeyCycle;

		@Override
		public void keyTyped(KeyEvent keyEvent)
		{
			if (!Character.isDigit(keyEvent.getKeyChar()))
			{
				return;
			}

			if (client.getGameCycle() - lastKeyCycle <= 5)
			{
				keyEvent.consume();
				return;
			}

			lastKeyCycle = client.getGameCycle();

			clientThread.invoke(() -> handleKey(keyEvent.getKeyChar()));
			keyEvent.consume();
		}

		@Override
		public void keyPressed(KeyEvent keyEvent)
		{
		}

		@Override
		public void keyReleased(KeyEvent keyEvent)
		{
		}
	}
}
