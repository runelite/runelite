/*
 * Copyright (c) 2018, Marshall <https://github.com/marshdevs>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.achievementdiary;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.Skill;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.achievementdiary.diaries.ArdougneDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.DesertDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.FaladorDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.FremennikDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.KandarinDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.KaramjaDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.LumbridgeDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.MorytaniaDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.VarrockDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.WesternDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.WildernessDiaryRequirement;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Diary Requirements",
	description = "Display level requirements in Achievement Diary interface",
	tags = {"achievements", "tasks"}
)
public class DiaryRequirementsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Subscribe
	public void onWidgetLoaded(final WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.DIARY_QUEST_GROUP_ID)
		{
			String widgetTitle = Text.removeTags(
				client.getWidget(
					WidgetInfo.DIARY_QUEST_WIDGET_TITLE)
					.getText())
				.replace(' ', '_')
				.toUpperCase();
			if (widgetTitle.startsWith("ACHIEVEMENT_DIARY"))
			{
				showDiaryRequirements();
			}
		}
	}

	private void showDiaryRequirements()
	{
		Widget widget = client.getWidget(WidgetInfo.DIARY_QUEST_WIDGET_TEXT);
		Widget[] children = widget.getStaticChildren();

		Widget titleWidget = children[0];
		if (titleWidget == null)
		{
			return;
		}

		List<String> originalAchievements = getOriginalAchievements(children);

		// new requirements starts out as a copy of the original
		List<String> newRequirements = new ArrayList<>(originalAchievements);

		GenericDiaryRequirement requirements = getRequirementsForTitle(titleWidget.getText());
		if (requirements == null)
		{
			log.debug("Unknown achievement diary {}", titleWidget.getText());
			return;
		}

		Map<String, String> skillRequirements = buildRequirements(requirements.getRequirements());
		if (skillRequirements == null)
		{
			return;
		}

		int offset = 0;
		String taskBuffer = "";
		for (int i = 0; i < originalAchievements.size(); i++)
		{
			String rowText = Text.removeTags(originalAchievements.get(i));
			if (skillRequirements.get(taskBuffer + " " + rowText) != null)
			{
				taskBuffer = taskBuffer + " " + rowText;
			}
			else
			{
				taskBuffer = rowText;
			}

			if (skillRequirements.get(taskBuffer) != null)
			{
				String levelRequirement = skillRequirements.get(taskBuffer);
				String task = originalAchievements.get(i);
				if (Text.removeTags(task).length() + Text.removeTags(levelRequirement).length() <= 50)
				{
					newRequirements.set(i + offset, task + levelRequirement);
				}
				else
				{
					offset++;
					if (task.startsWith("<str>"))
					{
						newRequirements.add(i + offset, "<str>" + levelRequirement);
					}
					else
					{
						newRequirements.add(i + offset, levelRequirement);
					}
				}
			}
		}

		int lastLine = 0;
		for (int i = 0; i < newRequirements.size() && i < children.length; i++)
		{
			Widget achievementWidget = children[i];
			String text = newRequirements.get(i);
			achievementWidget.setText(text);
			if (text != null && !text.isEmpty())
			{
				lastLine = i;
			}
		}

		int numLines = lastLine;
		clientThread.invokeLater(() -> client.runScript(ScriptID.DIARY_QUEST_UPDATE_LINECOUNT, 1, numLines));
	}

	private List<String> getOriginalAchievements(Widget[] children)
	{
		List<String> preloadedRequirements = new ArrayList<>(children.length);
		for (Widget requirementWidget : children)
		{
			preloadedRequirements.add(requirementWidget.getText());
		}
		return preloadedRequirements;
	}

	private GenericDiaryRequirement getRequirementsForTitle(String title)
	{
		String diaryName = Text.removeTags(title
			.replaceAll(" ", "_")
			.toUpperCase());

		GenericDiaryRequirement diaryRequirementContainer;
		switch (diaryName)
		{
			case "ARDOUGNE_AREA_TASKS":
				diaryRequirementContainer = new ArdougneDiaryRequirement();
				break;
			case "DESERT_TASKS":
				diaryRequirementContainer = new DesertDiaryRequirement();
				break;
			case "FALADOR_AREA_TASKS":
				diaryRequirementContainer = new FaladorDiaryRequirement();
				break;
			case "FREMENNIK_TASKS":
				diaryRequirementContainer = new FremennikDiaryRequirement();
				break;
			case "KANDARIN_TASKS":
				diaryRequirementContainer = new KandarinDiaryRequirement();
				break;
			case "KARAMJA_AREA_TASKS":
				diaryRequirementContainer = new KaramjaDiaryRequirement();
				break;
			case "LUMBRIDGE_&_DRAYNOR_TASKS":
				diaryRequirementContainer = new LumbridgeDiaryRequirement();
				break;
			case "MORYTANIA_TASKS":
				diaryRequirementContainer = new MorytaniaDiaryRequirement();
				break;
			case "VARROCK_TASKS":
				diaryRequirementContainer = new VarrockDiaryRequirement();
				break;
			case "WESTERN_AREA_TASKS":
				diaryRequirementContainer = new WesternDiaryRequirement();
				break;
			case "WILDERNESS_AREA_TASKS":
				diaryRequirementContainer = new WildernessDiaryRequirement();
				break;
			default:
				return null;
		}
		return diaryRequirementContainer;
	}

	// returns a map of task -> level requirements
	private Map<String, String> buildRequirements(Collection<DiaryRequirement> requirements)
	{
		Map<String, String> lineIndexRequirementMap = new HashMap<>();
		for (DiaryRequirement req : requirements)
		{
			String reqTask = req.getTask();
			List<RequirementStringBuilder> requirementBuilders = new ArrayList<>();

			for (Requirement i : req.getSkillRequirements())
			{
				RequirementStringBuilder requirementStringBuilder = new RequirementStringBuilder(i);

				Skill skill = i.getSkill();
				int realSkillLevel;
				if (skill == null && i.getCustomRequirement().equals("Combat"))
				{
					realSkillLevel = client.getLocalPlayer().getCombatLevel();
				}
				else
				{
					realSkillLevel = client.getRealSkillLevel(skill);
				}
				List<Integer> altRealSkillLevels = null;
				if (i.getAltRequirements() != null)
				{
					altRealSkillLevels = new ArrayList<>();
					for (Requirement j : i.getAltRequirements())
					{
						altRealSkillLevels.add(client.getRealSkillLevel(j.getSkill()));
					}
				}

				if (requirementStringBuilder.hasLevelRequirement(realSkillLevel, altRealSkillLevels))
				{
					requirementStringBuilder.strikeThroughRequirement();
				}
				else
				{
					requirementStringBuilder.colorRedRequirement();
				}
				requirementBuilders .add(requirementStringBuilder);
			}

			lineIndexRequirementMap.put(reqTask, combine(requirementBuilders ));
		}
		return lineIndexRequirementMap;
	}

	private String combine(List<RequirementStringBuilder> list)
	{
		StringBuilder requirementsString = new StringBuilder();
		requirementsString.append(ColorUtil.prependColorTag(" (", Color.WHITE));
		for (RequirementStringBuilder req : list)
		{
			requirementsString.append(ColorUtil.colorTag(new Color(0x80)))
				.append(req.getRequirementString())
				.append(", ");
		}
		requirementsString.deleteCharAt(requirementsString.length() - 1);
		requirementsString.deleteCharAt(requirementsString.length() - 2);
		requirementsString.append(ColorUtil.prependColorTag(")", Color.WHITE));

		return requirementsString.toString();
	}
}
