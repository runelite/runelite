/*
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * Copyright (c) 2018, Magic fTail
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
package net.runelite.client.plugins.virtuallevels;

import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.FontID;
import net.runelite.api.GameState;
import net.runelite.api.ScriptID;
import net.runelite.api.Skill;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetSizeMode;
import net.runelite.api.widgets.WidgetTextAlignment;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;

@PluginDescriptor(
	name = "Virtual Levels",
	description = "Shows virtual levels (beyond 99) and virtual skill total on the skills tab.",
	tags = {"skill", "total", "max"},
	enabledByDefault = false,
	type = PluginType.UTILITY
)
@Singleton
public class VirtualLevelsPlugin extends Plugin implements KeyListener
{
	private static final String TOTAL_LEVEL_TEXT_PREFIX = "Total level:<br>";
	private static final int X_OFFSET = 13;
	private static final int Y_OFFSET = 16;

	private final Map<Skill, Integer> previousXpMap = new EnumMap<>(Skill.class);
	private final List<Skill> skillsLeveledUp = new ArrayList<>();

	@Inject
	private VirtualLevelsConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private EventBus eventBus;

	@Inject
	private KeyManager keyManager;

	private boolean loginTick = false;
	private boolean closeMessage;
	private boolean messageOpen;

	@Provides
	VirtualLevelsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(VirtualLevelsConfig.class);
	}


	@Override
	protected void shutDown()
	{
		clientThread.invoke(this::simulateSkillChange);
		keyManager.unregisterKeyListener(this);
	}

	@Subscribe
	private void onPluginChanged(PluginChanged pluginChanged)
	{
		// this is guaranteed to be called after the plugin has been registered by the eventbus. startUp is not.
		if (pluginChanged.getPlugin() == this)
		{
			keyManager.registerKeyListener(this);
			clientThread.invoke(this::simulateSkillChange);
		}
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged configChanged)
	{
		if (!configChanged.getGroup().equals("virtuallevels"))
		{
			return;
		}

		clientThread.invoke(this::simulateSkillChange);
	}

	@Subscribe
	private void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		final String eventName = e.getEventName();

		final int[] intStack = client.getIntStack();
		final int intStackSize = client.getIntStackSize();
		final String[] stringStack = client.getStringStack();
		final int stringStackSize = client.getStringStackSize();

		switch (eventName)
		{
			case "skillTabBaseLevel":
				final int skillId = intStack[intStackSize - 2];
				final Skill skill = Skill.values()[skillId];
				final int exp = client.getSkillExperience(skill);

				// alter the local variable containing the level to show
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp);
				break;
			case "skillTabMaxLevel":
				// alter max level constant
				intStack[intStackSize - 1] = Experience.MAX_VIRT_LEVEL;
				break;
			case "skillTabTotalLevel":
				if (!config.virtualTotalLevel())
				{
					break;
				}
				int level = 0;

				for (Skill s : Skill.values())
				{
					if (s == Skill.OVERALL)
					{
						continue;
					}

					level += Experience.getLevelForXp(client.getSkillExperience(s));
				}

				stringStack[stringStackSize - 1] = TOTAL_LEVEL_TEXT_PREFIX + level;
				break;
		}
	}

	private void simulateSkillChange()
	{
		// this fires widgets listening for all skill changes
		for (Skill skill : Skill.values())
		{
			if (skill != Skill.OVERALL)
			{
				client.queueChangedSkill(skill);
			}
		}
	}

	private void buildVirtualLevelUp(Skill skill)
	{
		Widget chatboxContainer = client.getWidget(WidgetInfo.CHATBOX_CONTAINER);

		if (chatboxContainer == null)
		{
			return;
		}

		String skillName = skill.getName();
		int skillLevel = Experience.getLevelForXp(client.getSkillExperience(skill));
		List<SkillModel> skillModels = SkillModel.getSkillModels(skill);
		String prefix = (skill == Skill.AGILITY || skill == Skill.ATTACK) ? "an " : "a ";

		Widget levelUpLevel = chatboxContainer.createChild(-1, WidgetType.TEXT);
		Widget levelUpText = chatboxContainer.createChild(-1, WidgetType.TEXT);
		Widget levelUpContinue = chatboxContainer.createChild(-1, WidgetType.TEXT);

		levelUpLevel.setText("Congratulations, you just advanced " + prefix + skillName + " level.");
		levelUpLevel.setTextColor(0x000080);
		levelUpLevel.setFontId(FontID.QUILL_8);
		levelUpLevel.setXPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		levelUpLevel.setOriginalX(73 + X_OFFSET);
		levelUpLevel.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		levelUpLevel.setOriginalY(15 + Y_OFFSET);
		levelUpLevel.setOriginalWidth(390);
		levelUpLevel.setOriginalHeight(30);
		levelUpLevel.setXTextAlignment(WidgetTextAlignment.CENTER);
		levelUpLevel.setYTextAlignment(WidgetTextAlignment.LEFT);
		levelUpLevel.setWidthMode(WidgetSizeMode.ABSOLUTE);
		levelUpLevel.revalidate();

		levelUpText.setText((skill == Skill.HITPOINTS ? "Your Hitpoints are now " + skillLevel :
			"Your " + skillName + " level is now " + skillLevel) + ".");
		levelUpText.setFontId(FontID.QUILL_8);
		levelUpText.setXPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		levelUpText.setOriginalX(73 + X_OFFSET);
		levelUpText.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		levelUpText.setOriginalY(44 + Y_OFFSET);
		levelUpText.setOriginalWidth(390);
		levelUpText.setOriginalHeight(30);
		levelUpText.setXTextAlignment(WidgetTextAlignment.CENTER);
		levelUpText.setYTextAlignment(WidgetTextAlignment.LEFT);
		levelUpText.setWidthMode(WidgetSizeMode.ABSOLUTE);
		levelUpText.revalidate();

		levelUpContinue.setText("Click here to continue");
		levelUpContinue.setTextColor(0x0000ff);
		levelUpContinue.setFontId(FontID.QUILL_8);
		levelUpContinue.setXPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		levelUpContinue.setOriginalX(73 + X_OFFSET);
		levelUpContinue.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		levelUpContinue.setOriginalY(74 + Y_OFFSET);
		levelUpContinue.setOriginalWidth(390);
		levelUpContinue.setOriginalHeight(17);
		levelUpContinue.setXTextAlignment(WidgetTextAlignment.CENTER);
		levelUpContinue.setYTextAlignment(WidgetTextAlignment.LEFT);
		levelUpContinue.setWidthMode(WidgetSizeMode.ABSOLUTE);
		levelUpContinue.setAction(0, "Continue");
		levelUpContinue.setOnOpListener((JavaScriptCallback) ev -> closeNextTick());
		levelUpContinue.setOnMouseOverListener((JavaScriptCallback) ev -> levelUpContinue.setTextColor(0xFFFFFF));
		levelUpContinue.setOnMouseLeaveListener((JavaScriptCallback) ev -> levelUpContinue.setTextColor(0x0000ff));
		levelUpContinue.setHasListener(true);
		levelUpContinue.revalidate();

		for (SkillModel skillModel : skillModels)
		{
			buildWidgetModel(chatboxContainer, skillModel);
		}

		messageOpen = true;
	}

	private void buildWidgetModel(Widget chatboxContainer, SkillModel model)
	{
		int iconWidth = 32;
		int iconHeight = 32;

		if (model.getSkill() == Skill.CONSTRUCTION)
		{
			iconWidth = 49;
			iconHeight = 61;
		}

		Widget levelUpModel = chatboxContainer.createChild(-1, WidgetType.MODEL);

		levelUpModel.setModelId(model.getModelID());
		levelUpModel.setXPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		levelUpModel.setOriginalX(model.getOriginalX() + X_OFFSET);
		levelUpModel.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		levelUpModel.setOriginalY(model.getOriginalY() + Y_OFFSET);
		levelUpModel.setOriginalWidth(iconWidth);
		levelUpModel.setOriginalHeight(iconHeight);
		levelUpModel.setRotationX(model.getRotationX());
		levelUpModel.setRotationY(model.getRotationY());
		levelUpModel.setRotationZ(model.getRotationZ());
		levelUpModel.setModelZoom(model.getModelZoom());
		levelUpModel.revalidate();
	}

	private void closeNextTick()
	{
		if (!messageOpen)
		{
			return;
		}

		Widget levelUpContinue = client.getWidget(WidgetInfo.CHATBOX_CONTAINER).getChild(2);

		levelUpContinue.setText("Please wait...");

		messageOpen = false;
		closeMessage = true;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			loginTick = true;
			return;
		}

		if (event.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		for (Skill skill : Skill.values())
		{
			previousXpMap.put(skill, client.getSkillExperience(skill));
		}
	}

	@Subscribe
	public void onStatChanged(StatChanged event)
	{
		Skill skill = event.getSkill();

		int xpAfter = client.getSkillExperience(skill);
		int levelAfter = Experience.getLevelForXp(xpAfter);

		int xpBefore = previousXpMap.get(skill);
		int levelBefore = Experience.getLevelForXp(xpBefore);

		previousXpMap.put(skill, xpAfter);

		if (!config.virtualMessage() || levelAfter < 100 || levelBefore >= levelAfter)
		{
			return;
		}

		if (!loginTick)
		{
			skillsLeveledUp.add(skill);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		loginTick = false;

		if (closeMessage)
		{
			clientThread.invoke(() -> client.runScript(
				ScriptID.MESSAGE_LAYER_CLOSE,
				1,
				1
			));

			closeMessage = false;
		}

		if (skillsLeveledUp.isEmpty())
		{
			return;
		}

		Widget chatboxContainer = client.getWidget(WidgetInfo.CHATBOX_CONTAINER);

		if (chatboxContainer != null && !chatboxContainer.isHidden())
		{
			return;
		}

		Skill skill = skillsLeveledUp.get(0);

		skillsLeveledUp.remove(skill);

		clientThread.invoke(() -> client.runScript(ScriptID.MESSAGE_LAYER_OPEN));
		clientThread.invoke(() -> buildVirtualLevelUp(skill));
		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(WidgetID.CHATBOX_GROUP_ID);
		eventBus.post(WidgetLoaded.class, widgetLoaded);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		if (e.getKeyChar() != ' ')
		{
			return;
		}

		if (messageOpen)
		{
			closeNextTick();
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}
}
