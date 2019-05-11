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
package net.runelite.client.ui;

<<<<<<< HEAD:runelite-client/src/main/java/net/runelite/client/ui/PluginToolbar.java
<<<<<<< HEAD
import com.google.common.eventbus.EventBus;
import java.util.Comparator;
=======
import com.google.common.collect.ComparisonChain;
import com.google.common.eventbus.EventBus;
>>>>>>> upstream/master
import java.util.TreeSet;
=======
import java.util.HashSet;
import java.util.Set;
>>>>>>> upstream/master:runelite-client/src/main/java/net/runelite/client/ui/ClientToolbar.java
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.NavigationButtonAdded;
import net.runelite.client.events.NavigationButtonRemoved;

/**
 * Plugin toolbar buttons holder.
 */
@Singleton
public class ClientToolbar
{
	private final EventBus eventBus;
<<<<<<< HEAD:runelite-client/src/main/java/net/runelite/client/ui/PluginToolbar.java
<<<<<<< HEAD
	private final TreeSet<NavigationButton> buttons = new TreeSet<>(Comparator.comparing(NavigationButton::getName));
=======
	private final TreeSet<NavigationButton> buttons = new TreeSet<>((a, b) ->
		ComparisonChain.start()
			.compare(a.getPriority(), b.getPriority())
			.compare(a.getTooltip(), b.getTooltip())
			.result());
>>>>>>> upstream/master
=======
	private final Set<NavigationButton> buttons = new HashSet<>();
>>>>>>> upstream/master:runelite-client/src/main/java/net/runelite/client/ui/ClientToolbar.java

	@Inject
	private ClientToolbar(final EventBus eventBus)
	{
		this.eventBus = eventBus;
	}

	/**
	 * Add navigation.
	 *
	 * @param button the button
	 */
	public void addNavigation(final NavigationButton button)
	{
		if (buttons.contains(button))
		{
			return;
		}

		if (buttons.add(button))
		{
			eventBus.post(new NavigationButtonAdded(button));
		}
	}

	/**
	 * Remove navigation.
	 *
	 * @param button the button
	 */
	public void removeNavigation(final NavigationButton button)
	{
		if (buttons.remove(button))
		{
			eventBus.post(new NavigationButtonRemoved(button));
		}
	}
}
