/*
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
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
package net.runelite.client.plugins.questhelper;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.inject.Binder;
import com.google.inject.CreationException;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Quest;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.RuneLite;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Quest Helper",
	description = "Helps you with your quests"
)
@Slf4j
public class QuestHelperPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private QuestHelperOverlay questHelperOverlay;

	@Inject
	private QuestHelperWorldOverlay questHelperWorldOverlay;

	private static final String QUEST_PACKAGE = "net.runelite.client.plugins.questhelper.quests";
	private Map<String, QuestHelper> quests;

	@Getter
	private QuestHelper selectedQuest = null;

	@Override
	protected void startUp() throws IOException
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			if (quests == null)
			{
				quests = scanAndInstantiate(getClass().getClassLoader(), QUEST_PACKAGE);
			}
		}
		overlayManager.add(questHelperOverlay);
		overlayManager.add(questHelperWorldOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(questHelperOverlay);
		overlayManager.remove(questHelperWorldOverlay);
		quests = null;
		shutDownQuest();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event) throws Exception
	{
		int groupId = event.getGroupId();
		if (groupId == WidgetID.DIARY_QUEST_GROUP_ID)
		{
			Widget widget = client.getWidget(WidgetInfo.DIARY_QUEST_WIDGET_TITLE);
			String questname = Text.removeTags(widget.getText());
			if (quests.containsKey(questname))
			{
				QuestHelper widgetQuest = quests.get(questname);
				if (selectedQuest == null || !selectedQuest.equals(widgetQuest))
				{
					shutDownQuest();
					startUpQuest(widgetQuest);
				}
			}
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event) throws IOException
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			if (quests == null)
			{
				quests = scanAndInstantiate(getClass().getClassLoader(), QUEST_PACKAGE);
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event) throws Exception
	{
		if (selectedQuest != null && selectedQuest.var != selectedQuest.getVar())
		{
			selectedQuest.var = selectedQuest.getVar();
			selectedQuest.updateQuest();
			if (selectedQuest.getCurrentStep() == null)
			{
				shutDownQuest();
			}
		}
	}

	private void startUpQuest(QuestHelper questHelper) throws Exception
	{
		if (!questHelper.isCompleted())
		{
			selectedQuest = questHelper;
			eventBus.register(selectedQuest);
			selectedQuest.startUp();
		}
		else
		{
			selectedQuest = null;
		}
	}

	private void shutDownQuest() throws Exception
	{
		if (selectedQuest != null)
		{
			selectedQuest.shutDown();
			eventBus.unregister(selectedQuest);
			selectedQuest = null;
		}
	}

	Map<String, QuestHelper> scanAndInstantiate(ClassLoader classLoader, String packageName) throws IOException
	{
		Map<Quest, Class<? extends QuestHelper>> quests = new HashMap<>();

		Map<String, QuestHelper> scannedQuests = new HashMap<>();
		ClassPath classPath = ClassPath.from(classLoader);

		ImmutableSet<ClassPath.ClassInfo> classes = packageName == null ? classPath.getAllClasses()
			: classPath.getTopLevelClassesRecursive(packageName);
		for (ClassPath.ClassInfo classInfo : classes)
		{
			Class<?> clazz = classInfo.load();
			QuestDescriptor questDescriptor = clazz.getAnnotation(QuestDescriptor.class);

			if (questDescriptor == null)
			{
				if (clazz.getSuperclass() == QuestHelper.class)
				{
					log.warn("Class {} is a quest helper, but has no quest descriptor",
						clazz);
				}
				continue;
			}

			if (clazz.getSuperclass() != QuestHelper.class)
			{
				log.warn("Class {} has quest descriptor, but is not a quest helper",
					clazz);
				continue;
			}

			Class<QuestHelper> questClass = (Class<QuestHelper>) clazz;
			quests.put(questDescriptor.quest(), questClass);
		}

		for (Map.Entry<Quest, Class<? extends QuestHelper>> questClazz : quests.entrySet())
		{
			QuestHelper questHelper;
			try
			{
				questHelper = instantiate((Class<QuestHelper>) questClazz.getValue(), questClazz.getKey());
			}
			catch (QuestInstantiationException ex)
			{
				log.warn("Error instantiating quest helper!", ex);
				continue;
			}

			scannedQuests.put(questClazz.getKey().getName(), questHelper);
		}

		return scannedQuests;
	}

	private QuestHelper instantiate(Class<QuestHelper> clazz, Quest quest) throws QuestInstantiationException
	{
		QuestHelper questHelper;
		try
		{
			questHelper = clazz.newInstance();
			questHelper.setQuest(quest);
		}
		catch (InstantiationException | IllegalAccessException ex)
		{
			throw new QuestInstantiationException(ex);
		}

		try
		{
			Module questModule = (Binder binder) ->
			{
				binder.bind(clazz).toInstance(questHelper);
				binder.install(questHelper);
			};
			Injector questInjector = RuneLite.getInjector().createChildInjector(questModule);
			questInjector.injectMembers(questHelper);
			questHelper.injector = questInjector;
		}
		catch (CreationException ex)
		{
			throw new QuestInstantiationException(ex);
		}

		log.debug("Loaded quest helper {}", clazz.getSimpleName());
		return questHelper;
	}
}
