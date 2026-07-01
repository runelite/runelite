/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import javax.annotation.Nullable;
import net.runelite.api.widgets.Widget;

public interface ScriptEventBuilder
{
	/**
	 * Arguments passed to the script. Index 0 is the script being run and is not an argument.
	 * @return
	 */
	Object[] getArguments();

	/**
	 * Arguments passed to the script. Index 0 is the script being run and is not an argument.
	 * @return
	 */
	ScriptEventBuilder setArguments(Object[] arguments);

	/**
	 * Gets the widget the {@link ScriptEvent#WIDGET_ID} and {@link ScriptEvent#WIDGET_INDEX} args
	 * are substituted with
	 */
	Widget getSource();

	/**
	 * Sets the widget the {@link ScriptEvent#WIDGET_ID} and {@link ScriptEvent#WIDGET_INDEX} args
	 * are substituted with. This is useful for running widget listeners
	 *
	 * @see Widget#getOnLoadListener()
	 */
	ScriptEventBuilder setSource(Widget widget);

	/**
	 * Gets the {@link Widget} target. This is only used for the drag complete listener
	 * @see Widget#setOnDragCompleteListener(Object...)
	 * @return
	 */
	@Nullable
	Widget getTarget();

	/**
	 * Sets the {@link Widget} target. This is only used for the drag complete listener.
	 * @param target
	 * @see Widget#setOnDragCompleteListener(Object...)
	 * @return
	 */
	ScriptEventBuilder setTarget(Widget target);

	/**
	 * Gets the menu op of the event
	 *
	 * @return the menu op
	 */
	int getOp();

	/**
	 * Set the menu op of the event
	 *
	 * @param op
	 */
	ScriptEventBuilder setOp(int op);

	/**
	 * Build the {@link ScriptEvent}
	 */
	ScriptEvent build();
}
