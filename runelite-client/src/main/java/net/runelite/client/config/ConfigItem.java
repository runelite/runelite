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
package net.runelite.client.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ConfigItem
{
	int position() default -1;

	String keyName();

	String name();

	String description();

	boolean hidden() default false;

	String warning() default "";

	boolean secret() default false;

	String section() default "";

	/**
	 * Position of this item within a sub-panel opened by {@link #opensSubmenu()}.
	 * Use this instead of {@link #position()} for items inside a submenu so the two
	 * orderings are visually distinct in source — readers won't see {@code position}
	 * appear to "reset" partway down the file. Falls back to {@link #position()} when
	 * unset (default -1).
	 */
	int submenuPosition() default -1;

	/**
	 * If non-empty, marks this boolean item as the "opener" for a sibling {@link ConfigSection}.
	 * The item renders as a regular checkbox, with a gear button next to it that opens a sub-panel
	 * containing the section's items. While the checkbox is unchecked, the proxy reports the
	 * type's zero value for every item in that section (transparent feature flagging).
	 * <p>
	 * Value is the section's key (the value of the {@code String} field annotated with
	 * {@link ConfigSection}). Only meaningful for {@code boolean} items.
	 */
	String opensSubmenu() default "";
}
