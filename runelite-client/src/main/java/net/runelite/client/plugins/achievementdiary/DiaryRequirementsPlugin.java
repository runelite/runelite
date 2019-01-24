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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.FontTypeFace;
import net.runelite.api.QuestState;
import net.runelite.api.ScriptID;
import net.runelite.api.VarPlayer;
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
import net.runelite.client.plugins.achievementdiary.diaries.KourendDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.LumbridgeDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.MorytaniaDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.VarrockDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.WesternDiaryRequirement;
import net.runelite.client.plugins.achievementdiary.diaries.WildernessDiaryRequirement;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Diary Requirements",
	description = "Display level requirements in Achievement Diary interface",
	tags = {"achievements", "tasks"}
)
public class DiaryRequirementsPlugin extends Plugin
{
	private static final String AND_JOINER = ", ";
	private static final Pattern AND_JOINER_PATTERN = Pattern.compile("(?<=, )");

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

		FontTypeFace font = titleWidget.getFont();
		int maxWidth = titleWidget.getWidth();

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

				int taskWidth = font.getTextWidth(task);
				int ourWidth = font.getTextWidth(levelRequirement);
				String strike = task.startsWith("<str>") ? "<str>" : "";

				if (ourWidth + taskWidth < maxWidth)
				{
					// Merge onto 1 line
					newRequirements.set(i + offset, task + levelRequirement);
				}
				else if (ourWidth < maxWidth)
				{
					// 2 line split
					newRequirements.add(i + (++offset), strike + levelRequirement);
				}
				else
				{
					// Full text layout
					StringBuilder b = new StringBuilder();
					b.append(task);
					int runningWidth = font.getTextWidth(b.toString());
					for (String word : AND_JOINER_PATTERN.split(levelRequirement))
					{
						int wordWidth = font.getTextWidth(word);
						if (runningWidth == 0 || wordWidth + runningWidth < maxWidth)
						{
							runningWidth += wordWidth;
							b.append(word);
						}
						else
						{
							newRequirements.add(i + (offset++), b.toString());
							b.delete(0, b.length());
							runningWidth = wordWidth;
							b.append(strike);
							b.append(word);
						}
					}
					newRequirements.set(i + offset, b.toString());
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
			case "KOUREND_&_KEBOS_TASKS":
				diaryRequirementContainer = new KourendDiaryRequirement();
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
		Map<String, String> reqs = new HashMap<>();
		for (DiaryRequirement req : requirements)
		{
			StringBuilder b = new StringBuilder();
			b.append("<col=ffffff>(");

			assert req.getRequirements().size() > 0;
			for (Requirement ireq : req.getRequirements())
			{
				boolean satifisfied = satisfiesRequirement(ireq);
				b.append(satifisfied ? "<col=000080><str>" : "<col=800000>");
				b.append(ireq.toString());
				b.append(satifisfied ? "</str>" : "<col=000080>");
				b.append(AND_JOINER);
			}

			b.delete(b.length() - AND_JOINER.length(), b.length());

			b.append("<col=ffffff>)");

			reqs.put(req.getTask(), b.toString());
		}
		return reqs;
	}

	private boolean satisfiesRequirement(Requirement r)
	{
		if (r instanceof OrRequirement)
		{
			return ((OrRequirement) r).getRequirements()
				.stream()
				.anyMatch(this::satisfiesRequirement);
		}
		if (r instanceof SkillRequirement)
		{
			SkillRequirement s = (SkillRequirement) r;
			return client.getRealSkillLevel(s.getSkill()) >= s.getLevel();
		}
		if (r instanceof CombatLevelRequirement)
		{
			return client.getLocalPlayer().getCombatLevel() >= ((CombatLevelRequirement) r).getLevel();
		}
		if (r instanceof QuestRequirement)
		{
			QuestRequirement q = (QuestRequirement) r;
			QuestState state = q.getQuest().getState(client);
			if (q.isStarted())
			{
				return state != QuestState.NOT_STARTED;
			}
			return state == QuestState.FINISHED;
		}
		if (r instanceof QuestPointRequirement)
		{
			return client.getVar(VarPlayer.QUEST_POINTS) >= ((QuestPointRequirement) r).getQp();
		}
		if (r instanceof FavourRequirement)
		{
			FavourRequirement f = (FavourRequirement) r;
			int realFavour = client.getVar(f.getHouse().getVarbit());
			return (realFavour / 10) >= f.getPercent();
		}
		log.warn("Unknown requirement {}", r);
		return false;
	}
}