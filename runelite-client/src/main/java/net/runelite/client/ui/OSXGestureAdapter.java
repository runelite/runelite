/*
 * Copyright (c) 2026, MoonBoi9001 <https://github.com/MoonBoi9001>
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

import com.apple.eawt.event.GestureUtilities;
import com.apple.eawt.event.MagnificationEvent;
import com.apple.eawt.event.MagnificationListener;
import java.awt.Component;
import javax.swing.JComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.MagnificationGesture;

/**
 * Forwards macOS trackpad pinches to the event bus on the client thread. The gesture API needs
 * {@code --add-exports=java.desktop/com.apple.eawt.event=ALL-UNNAMED}; without it, install only logs.
 * The listener is a nested class so this class still loads, and runs that check, when the package is not exported.
 */
@Slf4j
class OSXGestureAdapter
{
	private static final String GESTURE_PACKAGE = "com.apple.eawt.event";

	static void install(JComponent component, EventBus eventBus, ClientThread clientThread)
	{
		if (!Component.class.getModule().isExported(GESTURE_PACKAGE, OSXGestureAdapter.class.getModule()))
		{
			log.debug("Trackpad gestures are unavailable because java.desktop does not export {} to the client; " +
				"add --add-exports=java.desktop/{}=ALL-UNNAMED to the JVM arguments to enable them", GESTURE_PACKAGE, GESTURE_PACKAGE);
			return;
		}

		try
		{
			GestureUtilities.addGestureListenerTo(component, new MagnificationForwarder(eventBus, clientThread));
		}
		catch (LinkageError e)
		{
			log.warn("Unable to install the trackpad gesture listener", e);
		}
	}

	@RequiredArgsConstructor
	private static class MagnificationForwarder implements MagnificationListener
	{
		private final EventBus eventBus;
		private final ClientThread clientThread;

		@Override
		public void magnify(MagnificationEvent e)
		{
			final MagnificationGesture gesture = new MagnificationGesture(e.getMagnification());
			clientThread.invokeLater(() -> eventBus.post(gesture));
		}
	}
}
