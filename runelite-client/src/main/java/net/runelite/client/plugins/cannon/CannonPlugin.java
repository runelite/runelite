/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.cannon;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.*;

import static com.sun.deploy.util.SessionState.save;
import static net.runelite.api.ChatMessageType.SERVER;
import static net.runelite.api.ObjectID.CANNON_BASE;
import static net.runelite.api.ProjectileID.CANNONBALL;
import static net.runelite.api.ProjectileID.GRANITE_CANNONBALL;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.slayer.SlayerConfig;
import net.runelite.client.plugins.slayer.SlayerPlugin;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;

@PluginDescriptor(
		name = "Cannon",
		description = "Show information about cannon placement and/or amount of cannonballs",
		tags = {"combat", "notifications", "ranged", "overlay"}
)

@PluginDependency(SlayerPlugin.class)

public class CannonPlugin extends Plugin
{
	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");
	private static final int MAX_CBALLS = 30;

	private CannonBallsCounter counter1;
	private CannonCounter counter;
	private boolean skipProjectileCheckThisTick;

	private static final Pattern NPC_ASSIGN_MESSAGE = Pattern.compile(".*Your new task is to kill\\s*(\\d*) (.*)\\.");
	private static final Pattern NPC_CURRENT_MESSAGE = Pattern.compile("You're still hunting (.*); you have (\\d*) to go\\..*");
	private static final String CHAT_CANCEL_MESSAGE = "Your task has been cancelled.";
	private static final String CHAT_CANCEL_MESSAGE_JAD = "You no longer have a slayer task as you left the fight cave.";
	private static final String CHAT_GEM_COMPLETE_MESSAGE = "You need something new to hunt.";
	private static final Pattern CHAT_GEM_PROGRESS_MESSAGE = Pattern.compile("You're assigned to kill (.*); only (\\d*) more to go\\.");

	@Getter
	private int TotalCannonballs;

	@Getter
	private int cballsLeft;

	@Getter
	private boolean cannonPlaced;

	@Getter
	private WorldPoint cannonPosition;

	@Getter
	private GameObject cannon;

	@Getter
	private List<WorldPoint> spotPoints = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private String taskName;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int TotalCannonballamount;

	private boolean loginFlag;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private Notifier notifier;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private CannonOverlay cannonOverlay;

	@Inject
	private CannonSpotOverlay cannonSpotOverlay;

	@Inject
	private CannonConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private SlayerConfig Slayerconfig;

	@Provides
	CannonConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CannonConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(cannonOverlay);
		overlayManager.add(cannonSpotOverlay);

		if (client.getGameState() == GameState.LOGGED_IN
				&& config.TotalCannonballamount() != -1
				&& !Slayerconfig.taskName().isEmpty())
		{
			clientThread.invoke(() -> setTask(config.TotalCannonballamount()));
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(cannonOverlay);
		overlayManager.remove(cannonSpotOverlay);
		cannonPlaced = false;
		cannonPosition = null;
		cballsLeft = 0;
		removeCounter();
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGING_IN:
				taskName = "";
				loginFlag = true;
				break;
			case LOGGED_IN:
				if (config.TotalCannonballamount() != -1
						&& !Slayerconfig.taskName().isEmpty()
						&& loginFlag)
				{
					setTask(config.TotalCannonballamount());
					loginFlag = false;
				}
				break;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("cannon"))
		{
			if (!config.showInfobox())
			{
				removeCounter();
			}
			else
			{
				if (cannonPlaced)
				{
					clientThread.invoke(this::addCounter);
				}
			}
		}

	}

	@Schedule(
			period = 1,
			unit = ChronoUnit.SECONDS
	)
	public void checkSpots()
	{
		if (!config.showCannonSpots())
		{
			return;
		}

		spotPoints.clear();
		for (WorldPoint spot : CannonSpots.getCannonSpots())
		{
			if (spot.getPlane() != client.getPlane() || !spot.isInScene(client))
			{
				continue;
			}

			spotPoints.add(spot);
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();

		Player localPlayer = client.getLocalPlayer();
		if (gameObject.getId() == CANNON_BASE && !cannonPlaced)
		{
			if (localPlayer.getWorldLocation().distanceTo(gameObject.getWorldLocation()) <= 2
					&& localPlayer.getAnimation() == AnimationID.BURYING_BONES)
			{
				cannonPosition = gameObject.getWorldLocation();
				cannon = gameObject;
			}
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();

		if ((projectile.getId() == CANNONBALL || projectile.getId() == GRANITE_CANNONBALL) && cannonPosition != null)
		{
			WorldPoint projectileLoc = WorldPoint.fromLocal(client, projectile.getX1(), projectile.getY1(), client.getPlane());

			//Check to see if projectile x,y is 0 else it will continuously decrease while ball is flying.
			if (projectileLoc.equals(cannonPosition) && projectile.getX() == 0 && projectile.getY() == 0)
			{
				if (!skipProjectileCheckThisTick)
				{
					cannonAmmoWarning();
					cballsLeft--;
				}
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.FILTERED && event.getType() != ChatMessageType.SERVER)
		{
			return;
		}
		String chatMsg = Text.removeTags(event.getMessage()); //remove color and linebreaks

		if (chatMsg.endsWith("; return to a Slayer master.")) {
			System.out.println("Cannonballs used in task: " + config.TotalCannonballamount());
			TotalCannonballs = 0;
			setTask(TotalCannonballs);
			save();
		}

		if (chatMsg.equals(CHAT_GEM_COMPLETE_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE_JAD))
		{
			TotalCannonballs = 0;
			setTask(TotalCannonballs);
			save();
			System.out.println("Task is gecanceld");
		}

		if (chatMsg.contains("You're assigned to kill (.*);")) {
			TotalCannonballs = 0;
			setTask(TotalCannonballs);
			save();
			System.out.println("Task monster: " + Slayerconfig.taskName());
			System.out.println("Cannonballs used: " + config.TotalCannonballamount());
		}

		if (event.getMessage().equals("You add the furnace."))
		{
			cannonPlaced = true;
			addCounter();
			cballsLeft = 0;
		}

		if (event.getMessage().contains("You pick up the cannon"))
		{
			cannonPlaced = false;
			TotalCannonballs = TotalCannonballs - cballsLeft;
			System.out.println("Cannonballs tot nu toe gebruikt tijdens task:" + TotalCannonballs);
			cballsLeft = 0;
			save();
			removeCounter();
		}

		if (event.getMessage().startsWith("You load the cannon with"))
		{
			Matcher m = NUMBER_PATTERN.matcher(event.getMessage());
			if (m.find())
			{
				int amt = Integer.valueOf(m.group());
				if (cballsLeft + amt >= MAX_CBALLS)
				{
					skipProjectileCheckThisTick = true;
					cballsLeft = MAX_CBALLS;
					TotalCannonballs += amt;
					save();
				}
				else
				{
					cballsLeft += amt;
					TotalCannonballs += amt;
					save();
				}
			}
			else if (event.getMessage().equals("You load the cannon with one cannonball."))
			{
				if (cballsLeft + 1 >= MAX_CBALLS)
				{
					skipProjectileCheckThisTick = true;
					cballsLeft = MAX_CBALLS;
					TotalCannonballs++;
					save();
				}
				else
				{
					cballsLeft++;
					TotalCannonballs++;
					save();
				}
			}
		}

		if (event.getMessage().contains("Your cannon is out of ammo!"))
		{
			skipProjectileCheckThisTick = true;

			// If the player was out of range of the cannon, some cannonballs
			// may have been used without the client knowing, so having this
			// extra check is a good idea.
			cballsLeft = 0;

			if (config.showEmptyCannonNotification())
			{
				notifier.notify("Your cannon is out of ammo!");
			}
		}

		if (event.getMessage().startsWith("You unload your cannon and receive Cannonball")
				|| event.getMessage().startsWith("You unload your cannon and receive Granite cannonball"))
		{
			Matcher m = NUMBER_PATTERN.matcher(event.getMessage());

			if (m.find())
			{
				int amt = Integer.valueOf(m.group());
				TotalCannonballs -= amt;

			}
			skipProjectileCheckThisTick = true;

			cballsLeft = 0;
		}
	}

	private void save()
	{
		config.TotalCannonballamount(TotalCannonballs);
	}

	private void setTask(int amt)
	{
		TotalCannonballs = amt;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		skipProjectileCheckThisTick = false;

		Widget NPCDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		if (NPCDialog != null)
		{
			String NPCText = Text.removeTags(NPCDialog.getText()); //remove color and linebreaks
			Matcher mAssign = NPC_ASSIGN_MESSAGE.matcher(NPCText); //number, name
			Matcher mCurrent = NPC_CURRENT_MESSAGE.matcher(NPCText); //name, number
			boolean found1 = mAssign.find();
			boolean found2 = mCurrent.find();
			if (!found1 && !found2)
			{
				return;
			} else {
				TotalCannonballs = 0;
				setTask(TotalCannonballs);
			}
		}
	}

	Color getStateColor()
	{
		if (cballsLeft > 15)
		{
			return Color.green;
		}
		else if (cballsLeft > 5)
		{
			return Color.orange;
		}

		return Color.red;
	}

	private void addCounter()
	{
		if (!config.showInfobox() || counter != null|| counter1 != null)
		{
			return;
		}

		counter = new CannonCounter(itemManager.getImage(ItemID.CANNONBALL), this);
		counter.setTooltip("Cannonballs");

		infoBoxManager.addInfoBox(counter);

		counter1 = new CannonBallsCounter(itemManager.getImage(ItemID.STEEL_BAR), this);
		counter1.setTooltip("Total used cannonballs");

		infoBoxManager.addInfoBox(counter1);
	}

	private void removeCounter()
	{
		if (counter == null)
		{
			return;
		}
		if (counter1 == null)
		{
			return;
		}
		infoBoxManager.removeInfoBox(counter);
		counter = null;

		infoBoxManager.removeInfoBox(counter1);
		counter1 = null;
	}
	private void cannonAmmoWarning() {
		if (cballsLeft == 5) {
			notifier.notify("Your cannon is nearly out of ammo!");
		}
	}
}