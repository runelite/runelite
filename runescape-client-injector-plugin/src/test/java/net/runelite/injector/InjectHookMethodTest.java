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
package net.runelite.injector;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.ClassUtil;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.signature.Signature;
import static net.runelite.injector.Inject.RL_API_PACKAGE_BASE;
import static net.runelite.injector.InjectHookMethod.HOOKS;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

abstract class Obfuscated
{
	public int foo(Obfuscated o, int i)
	{
		if (i > 0)
		{
			return i;
		}
		else
		{
			return -i;
		}
	}
}

@ObfuscatedName("Obfuscated")
class Actor
{
	@ObfuscatedName("foo")
	@ObfuscatedSignature(
		signature = "(LObfuscated;I)I"
	)
	@Hook(value = "test", end = true)
	public int bar(Actor actor, int i)
	{
		throw new IllegalStateException();
	}
}

public class InjectHookMethodTest
{

	@Test
	public void testProcess() throws IOException, InjectionException
	{
		InputStream in = getClass().getResourceAsStream("Actor.class");
		ClassFile cf = ClassUtil.loadClass(in);
		cf.setName("Actor");
		cf.findMethod("bar").setDescriptor(new Signature("(LActor;I)I"));

		ClassGroup deobfuscated = new ClassGroup();
		deobfuscated.addClass(cf);

		in = getClass().getResourceAsStream("Obfuscated.class");
		ClassFile obcf = ClassUtil.loadClass(in);
		obcf.setName("Obfuscated");
		obcf.findMethod("foo").setDescriptor(new Signature("(LObfuscated;I)I"));

		ClassGroup obfuscated = new ClassGroup();
		obfuscated.addClass(obcf);

		Method method = cf.findMethod("bar");
		assert method != null;

		Inject inject = new Inject(deobfuscated, obfuscated);
		InjectHookMethod injectHookMethod = new InjectHookMethod(inject);
		injectHookMethod.process(method);

		method = obcf.findMethod("foo");
		assert method != null;
		Code code = method.getCode();
		List<InvokeStatic> invokeIns = code.getInstructions().getInstructions().stream()
			.filter(i -> i instanceof InvokeStatic)
			.map(i -> (InvokeStatic) i)
			.filter(i -> i.getMethod().getClazz().getName().equals(HOOKS))
			.collect(Collectors.toList());
		assertTrue(!invokeIns.isEmpty());
		assertEquals(2, invokeIns.size());

		InvokeStatic invokeStatic = invokeIns.get(0);
		Signature signature = invokeStatic.getMethod().getType();
		assertEquals(3, signature.size()); // this + patamers

		Type arg = signature.getTypeOfArg(1);
		assertEquals(RL_API_PACKAGE_BASE.replace('.', '/') + "Actor", arg.getInternalName());
	}

}
