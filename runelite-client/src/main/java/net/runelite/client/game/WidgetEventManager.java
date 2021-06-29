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

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import javax.inject.Singleton;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ScriptEvent;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;

@Singleton
@Slf4j
@SuppressWarnings("unused")
public class WidgetEventManager
{

	private static class MultiCallbackDelegator implements JavaScriptCallback
	{
		private final Set<JavaScriptCallback> delegates = new LinkedHashSet<>();

		public void add(JavaScriptCallback callback)
		{
			delegates.add(callback);
		}

		public void remove(JavaScriptCallback callback)
		{
			delegates.remove(callback);
		}

		@Override
		public void run(ScriptEvent event)
		{
			delegates.forEach(callback ->
			{
				try
				{
					callback.run(event);
				}
				catch (Exception e)
				{
					log.error("Unhandled error during widget callback", e);
				}
			});
		}
	}

	private final Map<Integer, MultiCallbackDelegator> clickListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> dialogAbortListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> dragCompleteListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> dragListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> holdListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> keyListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> mouseLeaveListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> mouseOverListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> mouseRepeatListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> opListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> releaseListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> targetEnterListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> targetLeaveListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> timerListeners = new HashMap<>();
	private final Map<Integer, MultiCallbackDelegator> varTransmitListeners = new HashMap<>();

	private MultiCallbackDelegator createDelegator(Consumer<Object[]> eventSetter)
	{
		MultiCallbackDelegator[] newDelegator = {new MultiCallbackDelegator()};
		eventSetter.accept(newDelegator);
		return newDelegator[0];
	}

	public void addOnClickListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		clickListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnClickListener))
				.add(callback);
	}

	public void addOnDialogAbortListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		dialogAbortListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnDialogAbortListener))
				.add(callback);
	}

	public void addOnDragCompleteListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		dragCompleteListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnDragCompleteListener))
				.add(callback);
	}

	public void addOnDragListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		dragListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnDragListener))
				.add(callback);
	}

	public void addOnHoldListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		holdListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnHoldListener))
				.add(callback);
	}

	public void addOnKeyListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		keyListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnKeyListener))
				.add(callback);
	}

	public void addOnMouseLeaveListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		mouseLeaveListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnMouseLeaveListener))
				.add(callback);
	}

	public void addOnMouseOverListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		mouseOverListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnMouseOverListener))
				.add(callback);
	}

	public void addOnMouseRepeatListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		mouseRepeatListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnMouseRepeatListener))
				.add(callback);
	}

	public void addOnOpListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		opListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnOpListener))
				.add(callback);
	}

	public void addOnReleaseListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		releaseListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnReleaseListener))
				.add(callback);
	}

	public void addOnTargetEnterListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		targetEnterListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnTargetEnterListener))
				.add(callback);
	}

	public void addOnTargetLeaveListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		targetLeaveListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnTargetLeaveListener))
				.add(callback);
	}

	public void addOnTimerListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		timerListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnTimerListener))
				.add(callback);
	}

	public void addOnVarTransmitListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		varTransmitListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnVarTransmitListener))
				.add(callback);
	}

	public void removeOnClickListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		clickListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnClickListener))
				.remove(callback);
	}

	public void removeOnDialogAbortListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		dialogAbortListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnDialogAbortListener))
				.remove(callback);
	}

	public void removeOnDragCompleteListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		dragCompleteListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnDragCompleteListener))
				.remove(callback);
	}

	public void removeOnDragListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		dragListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnDragListener))
				.remove(callback);
	}

	public void removeOnHoldListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		holdListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnHoldListener))
				.remove(callback);
	}

	public void removeOnKeyListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		keyListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnKeyListener))
				.remove(callback);
	}

	public void removeOnMouseLeaveListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		mouseLeaveListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnMouseLeaveListener))
				.remove(callback);
	}

	public void removeOnMouseOverListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		mouseOverListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnMouseOverListener))
				.remove(callback);
	}

	public void removeOnMouseRepeatListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		mouseRepeatListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnMouseRepeatListener))
				.remove(callback);
	}

	public void removeOnOpListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		opListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnOpListener))
				.remove(callback);
	}

	public void removeOnReleaseListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		releaseListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnReleaseListener))
				.remove(callback);
	}

	public void removeOnTargetEnterListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		targetEnterListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnTargetEnterListener))
				.remove(callback);
	}

	public void removeOnTargetLeaveListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		targetLeaveListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnTargetLeaveListener))
				.remove(callback);
	}

	public void removeOnTimerListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		timerListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnTimerListener))
				.remove(callback);
	}

	public void removeOnVarTransmitListener(@NonNull Widget w, @NonNull JavaScriptCallback callback)
	{
		varTransmitListeners.computeIfAbsent(w.getId(), id -> createDelegator(w::setOnVarTransmitListener))
				.remove(callback);
	}

}
