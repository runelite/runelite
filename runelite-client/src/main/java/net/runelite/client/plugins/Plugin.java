/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins;

import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Module;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.eventbus.AccessorGenerator;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscription;

public abstract class Plugin implements Module
{
	private Set<Subscription> annotatedSubscriptions = null;

	@Getter(AccessLevel.PROTECTED)
	protected Injector injector;

	@Override
	public void configure(Binder binder)
	{
	}

	protected void startUp() throws Exception
	{
	}

	protected void shutDown() throws Exception
	{
	}

	final void addAnnotatedSubscriptions(EventBus eventBus)
	{
		if (annotatedSubscriptions == null)
		{
			Observable.fromCallable(this::findSubscriptions)
				.subscribeOn(Schedulers.computation())
				.observeOn(Schedulers.single())
				.subscribe(subs -> addSubs(eventBus, (annotatedSubscriptions = subs)));
		}
		else
		{
			addSubs(eventBus, annotatedSubscriptions);
		}
	}

	final void removeAnnotatedSubscriptions(EventBus eventBus)
	{
		eventBus.unregister(this);
	}

	private Set<Subscription> findSubscriptions()
	{
		return AccessorGenerator.scanSubscribes(MethodHandles.lookup(), this);
	}

	private void addSubs(EventBus eventBus, Collection<Subscription> subs)
	{
		subs.forEach(s -> s.subscribe(eventBus, this));
	}

	public void resetConfiguration()
	{
	}
}
