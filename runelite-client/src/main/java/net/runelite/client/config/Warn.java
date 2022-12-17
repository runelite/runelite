/*
 * Copyright (c) 2022, Macweese <https://github.com/Macweese>
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

import java.awt.event.KeyEvent;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used with ConfigItem, defines warning prompt behaviour
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Warn
{
	/**
	 * Warning message to display
	 * @return String
	 */
	String message() default "";

	/**
	 * Maximum threshold, values above are allowed
	 * but not recommended
	 * @return int
	 */
	int warnMax() default 0;

	/**
	 * Minimum threshold, values below are allowed
	 * but not recommended
	 * @return int
	 */
	int warnMin() default -1;

	/**
	 * RegEx pattern for warned terms
	 *
	 * @return String
	 * @see java.util.regex.Pattern
	 */
	String badInput() default "";

	/**
	 * String representation for enums,
	 * of which are not recommended
	 * <p>
	 * May be used in conjunction with {@link Warn#unsafeOrdinals()}
	 * @return String[]
	 */
	String[] unsafeOptions() default {};

	/**
	 * Ordinal representation for enums,
	 * of which are not recommended
	 * <p>
	 * May be used in conjunction with {@link Warn#unsafeOptions()}
	 * @return int[]
	 */
	int[] unsafeOrdinals() default {};

	/**
	 * int values for KeyEvents
	 * of which are not recommended
	 *
	 * @return int[]
	 * @see KeyEvent
	 */
	int[] keys() default {KeyEvent.BUTTON1_DOWN_MASK, KeyEvent.BUTTON2_DOWN_MASK};

	/**
	 * Warning prompt behaviour for boolean settings
	 * <br>
	 * Leave as default for non-boolean type values
	 *
	 * @return WarningPrompt
	 */
	WarningPrompt WARNING_PROMPT() default WarningPrompt.ALWAYS;
}