/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay.infobox;

import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.PluginDescriptor;

@Singleton
@Slf4j
public class InfoBoxManager
{
	private final List<InfoBox> infoBoxes = new ArrayList<>();

	public void addInfoBox(InfoBox infoBox)
	{
		Preconditions.checkNotNull(infoBox);
		log.debug("Adding InfoBox {}", infoBox);
		infoBoxes.add(infoBox);

		refreshInfoBoxes();
	}

	public void removeInfoBox(InfoBox infoBox)
	{
		log.debug("Removing InfoBox {}", infoBox);
		infoBoxes.remove(infoBox);

		refreshInfoBoxes();
	}

	public void removeIf(Predicate<InfoBox> filter)
	{
		log.debug("Removing InfoBoxes for filter {}", filter);
		infoBoxes.removeIf(filter);

		refreshInfoBoxes();
	}

	public List<InfoBox> getInfoBoxes()
	{
		return Collections.unmodifiableList(infoBoxes);
	}

	public void cull()
	{
		boolean culled = false;
		for (Iterator<InfoBox> it = infoBoxes.iterator(); it.hasNext();)
		{
			InfoBox box = it.next();

			if (box.cull())
			{
				log.debug("Culling InfoBox {}", box);
				it.remove();
				culled = true;
			}
		}

		if (culled)
		{
			refreshInfoBoxes();
		}
	}

	private void refreshInfoBoxes()
	{
		Collections.sort(infoBoxes, (b1, b2) -> ComparisonChain
			.start()
			.compare(b1.getPriority(), b2.getPriority())
			.compare(b1.getPlugin().getClass().getAnnotation(PluginDescriptor.class).name(), b2.getPlugin().getClass().getAnnotation(PluginDescriptor.class).name())
			.result());
	}
}
