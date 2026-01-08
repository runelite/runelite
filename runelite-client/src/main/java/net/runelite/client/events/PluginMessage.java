/*
 * Copyright (c) 2023, jocopa3
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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
package net.runelite.client.events;

import java.util.Collections;
import java.util.Map;
import lombok.NonNull;
import lombok.Value;

/**
 * An event pluginhub plugins can use to send data to each other.
 */
@Value
public class PluginMessage
{
	/**
	 * Event namespace. This should usually be a unique string representing your plugin name eg. "tombs-of-amascut"
	 */
	String namespace;
	/**
	 * Event name. This should represent what the event is for, eg "points".
	 */
	String name;
	/**
	 * Event data.
	 */
	Map<String, Object> data;

	public PluginMessage(@NonNull String namespace, @NonNull String name)
	{
		this(namespace, name, Collections.emptyMap());
	}

	public PluginMessage(@NonNull String namespace, @NonNull String name, @NonNull Map<String, Object> data)
	{
		this.namespace = namespace;
		this.name = name;
		this.data = data;
	}
}
