/*
 * Copyright (c) 2021 LlemonDuck
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

package net.runelite.client.game;

import net.runelite.api.ScriptEvent;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class WidgetEventManagerTest
{

	@Mock
	Widget widget;

	@Captor
	ArgumentCaptor<JavaScriptCallback> widgetListenerCaptor;

	@Mock
	JavaScriptCallback callback1;

	@Mock
	JavaScriptCallback callback2;

	@Mock
	ScriptEvent event;

	private WidgetEventManager widgetEventManager;

	@Before
	public void init()
	{
		widgetEventManager = new WidgetEventManager();
		initMocks(this);
	}

	@Test
	public void shouldInvokeAllListenersOnAnEvent()
	{
		// given two listeners
		widgetEventManager.addOnClickListener(widget, callback1);
		widgetEventManager.addOnClickListener(widget, callback2);

		// when event is fired
		verify(widget).setOnClickListener(widgetListenerCaptor.capture());
		JavaScriptCallback widgetListener = widgetListenerCaptor.getValue();
		widgetListener.run(event);

		// then both listeners should be invoked
		verify(callback1, times(1)).run(event);
		verify(callback2, times(1)).run(event);
	}

	@Test
	public void shouldNotThrowWhenListenersThrow()
	{
		// given two listeners that throw
		widgetEventManager.addOnClickListener(widget, callback1);
		widgetEventManager.addOnClickListener(widget, callback2);
		doThrow(RuntimeException.class).when(callback1).run(event);
		doThrow(RuntimeException.class).when(callback2).run(event);

		// when event is fired
		verify(widget).setOnClickListener(widgetListenerCaptor.capture());
		JavaScriptCallback widgetListener = widgetListenerCaptor.getValue();
		widgetListener.run(event);

		// then both listeners should be invoked
		verify(callback1, times(1)).run(event);
		verify(callback2, times(1)).run(event);
	}

	@Test
	public void shouldNotCallRemovedListeners()
	{
		// given a listener that is removed
		widgetEventManager.addOnClickListener(widget, callback1);
		widgetEventManager.removeOnClickListener(widget, callback1);

		// when event is fired
		verify(widget).setOnClickListener(widgetListenerCaptor.capture());
		JavaScriptCallback widgetListener = widgetListenerCaptor.getValue();
		widgetListener.run(event);

		// then the listener should not be invoked
		verify(callback1, never()).run(event);
	}

	@Test
	public void shouldNotInvokeListenersOnOtherEvents()
	{
		// given listeners on different events
		widgetEventManager.addOnClickListener(widget, callback1);
		widgetEventManager.addOnDialogAbortListener(widget, callback2);

		// when event is fired
		verify(widget).setOnClickListener(widgetListenerCaptor.capture());
		JavaScriptCallback widgetListener = widgetListenerCaptor.getValue();
		widgetListener.run(event);

		// then only the listener on the click event should be invoked
		verify(callback1, times(1)).run(event);
		verify(callback2, never()).run(event);
	}

}