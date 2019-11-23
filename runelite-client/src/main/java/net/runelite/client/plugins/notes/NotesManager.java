/*
 * Copyright (c) 2019, whs <https://github.com/whs>
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
package net.runelite.client.plugins.notes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import joptsimple.internal.Strings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.notes.events.PageAdded;
import net.runelite.client.plugins.notes.events.PageDeleted;

@Singleton
@Slf4j
class NotesManager
{
	@Inject
	private ConfigManager configManager;

	@Inject
	private NotesConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private List<String> notes = new ArrayList<>();

	void loadNotes()
	{
		final String configJson = configManager.getConfiguration(NotesConfig.CONFIG_GROUP, NotesConfig.NOTES);

		notes = null;
		if (!Strings.isNullOrEmpty(configJson))
		{
			final Gson gson = new Gson();
			notes = gson.fromJson(configJson, new TypeToken<ArrayList<String>>() {}.getType());
		}

		if (notes == null)
		{
			notes = new ArrayList<>();
			notes.add("");
		}

		// migrate from legacy single tab notes
		if (!config.notesData().isEmpty())
		{
			log.info("Adding tab for legacy note data");
			notes.add(0, config.notesData());

			if (notes.size() == 2 && notes.get(1).equals(""))
			{
				// remove the default empty note page
				notes.remove(1);
			}
		}
	}

	void updateNote(int index, String data)
	{
		notes.set(index, data);
		save();
	}

	private void save()
	{
		final Gson gson = new Gson();
		final String json = gson.toJson(notes);
		configManager.setConfiguration(NotesConfig.CONFIG_GROUP, NotesConfig.NOTES, json);

		// Remove legacy notes
		if (!config.notesData().isEmpty())
		{
			log.info("Removing legacy note data");
			config.notesData("");
		}
	}

	void addPage()
	{
		notes.add("");
		eventBus.post(PageAdded.class, new PageAdded(notes.size() - 1));
		save();
	}

	void deletePage(int index)
	{
		if (notes.size() <= 1)
		{
			throw new DeleteOnlyPageException();
		}

		notes.remove(index);
		eventBus.post(PageDeleted.class, new PageDeleted(index));
		save();
	}
}
