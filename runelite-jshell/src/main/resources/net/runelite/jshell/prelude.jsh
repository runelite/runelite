/*
 * Copyright (c) 2021 Abex
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

import java.util.function.Consumer;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import org.slf4j.Logger;

import java.util.*;
import java.util.stream.*;
import net.runelite.api.*;
import net.runelite.api.coords.*;
import net.runelite.api.events.*;
import net.runelite.api.widgets.*;
import net.runelite.client.events.*;
import net.runelite.client.game.*;

var $PANEL = net.runelite.jshell.ShellPanel.INSTANCE;
Logger log = $PANEL.getShellLogger();

static <T> T inject(Class<T> clazz)
{
	return $PANEL.inject(clazz);
}

static void cleanup(Runnable r)
{
	$PANEL.cleanup(r);
}

var $EVENT_BUS = inject(net.runelite.client.eventbus.EventBus.class);
static <T> void subscribe(Class<T> eventType, Consumer<T> subscriber, float priority)
{
	var sub = $EVENT_BUS.register(eventType, subscriber, priority);
	cleanup(() -> $EVENT_BUS.unregister(sub));
}
static <T> void subscribe(Class<T> eventType, Consumer<T> subscriber)
{
	var sub = $EVENT_BUS.register(eventType, subscriber, 0.f);
	cleanup(() -> $EVENT_BUS.unregister(sub));
}

var client = inject(Client.class);
var clientThread = inject(ClientThread.class);
var configManager = inject(ConfigManager.class);

