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
package net.runelite.cache.script.interpreter;

import net.runelite.cache.definitions.ScriptDefinition;

public class Frame
{
	private final Interpreter interpreter;
	private final ScriptDefinition script;
	private final Stack intStack;
	private final Stack stringStack;
	private final Variables intVariables;
	private final Variables stringVariables;

	private boolean running = true;
	int pc;

	public Frame(Interpreter interpreter, ScriptDefinition script)
	{
		this.interpreter = interpreter;
		this.script = script;
		this.intStack = new Stack();
		this.stringStack = new Stack();
		this.intVariables = new Variables(script.getLocalIntCount());
		this.stringVariables = new Variables(script.getLocalStringCount());
	}

	public Frame(Interpreter interpreter, Frame other)
	{
		this.interpreter = interpreter;
		this.script = other.script;
		this.intStack = new Stack(other.intStack);
		this.stringStack = new Stack(other.stringStack);
		this.intVariables = new Variables(other.intVariables);
		this.stringVariables = new Variables(other.stringVariables);
		this.pc = other.pc;
	}

	public Stack getIntStack()
	{
		return intStack;
	}

	public Stack getStringStack()
	{
		return stringStack;
	}

	public ScriptDefinition getScript()
	{
		return script;
	}

	public Frame dup()
	{
		Frame frame = new Frame(interpreter, this);
		interpreter.addFrame(this);
		return frame;
	}

	public boolean isRunning()
	{
		return running;
	}

	public void stop()
	{
		running = false;
	}

	public void jump(int offset)
	{
		pc += offset + 1;
	}
}
