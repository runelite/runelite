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

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.ClassUtil;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import static net.runelite.asm.Type.INT;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.signature.Signature;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

@ObfuscatedName("net/runelite/injector/VanillaTarget")
class DeobTarget
{
	@ObfuscatedName("ob_foo4")
	private static int foo4;

	@ObfuscatedName("ob_foo3")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "123"
	)
	private void foo3()
	{
		// De-obfuscated foo3
		System.out.println("foo3");
	}
}

class VanillaTarget
{
	private static int ob_foo4;

	private void ob_foo3(int garbageValue)
	{
		// Obfuscated foo3
		if (garbageValue != 123)
		{
			return;
		}
		System.out.println("foo3");
	}
}

abstract class Source
{
	@net.runelite.api.mixins.Inject
	private static int foo;
	@Shadow("foo4")
	private static int foo4;

	@net.runelite.api.mixins.Inject
	private void foo2()
	{
	}

	@Copy("foo3")
	abstract void foo3();

	@Replace("foo3")
	private void rl$foo3()
	{
		System.out.println("replaced");
		System.out.println(foo4);
		foo3();
	}
}

// Test shadowing the "foo" field injected by Source
abstract class Source2
{
	@Shadow("foo")
	private static int foo;

	@net.runelite.api.mixins.Inject
	private void foo5()
	{
		System.out.println(foo);
	}
}

public class MixinInjectorTest
{
	@Test
	public void testInject() throws Exception
	{
		InputStream deobIn = getClass().getResourceAsStream("DeobTarget.class");
		ClassFile deobTarget = ClassUtil.loadClass(deobIn);

		ClassGroup deob = new ClassGroup();
		deob.addClass(deobTarget);

		InputStream vanillaIn = getClass().getResourceAsStream("VanillaTarget.class");
		ClassFile vanillaTarget = ClassUtil.loadClass(vanillaIn);

		ClassGroup vanilla = new ClassGroup();
		vanilla.addClass(vanillaTarget);

		Map<Class<?>, List<ClassFile>> mixinClasses = new HashMap<>();
		mixinClasses.put(Source.class, Collections.singletonList(vanillaTarget));
		mixinClasses.put(Source2.class, Collections.singletonList(vanillaTarget));

		Inject inject = new Inject(deob, vanilla);
		new MixinInjector(inject).inject(mixinClasses);

		// Check if "foo" has been injected
		Field foo = vanillaTarget.findField("foo");
		assertNotNull(foo);
		assertEquals(INT, foo.getType());
		assertEquals(ACC_PUBLIC | ACC_STATIC, foo.getAccessFlags());

		// Check if "foo2()V" has been injected
		Method foo2 = vanillaTarget.findMethod("foo2");
		assertNotNull(foo2);
		assertEquals(new Signature("()V"), foo2.getDescriptor());
		assertEquals(ACC_PUBLIC, foo2.getAccessFlags());

		// Check if "ob_foo3(I)V" was copied
		Method foo3 = vanillaTarget.findMethod("copy$foo3");
		assertNotNull(foo3);
		assertEquals(new Signature("(I)V"), foo3.getDescriptor());
		assertEquals(ACC_PUBLIC, foo3.getAccessFlags());

		// Check if "ob_foo3(I)V" was replaced
		Method ob_foo3 = vanillaTarget.findMethod("ob_foo3");
		assertNotNull(ob_foo3);
		assertEquals(new Signature("(I)V"), ob_foo3.getDescriptor());
		assertEquals(ob_foo3
			.getCode()
			.getInstructions()
			.getInstructions()
			.stream()
			.filter(i -> i instanceof LDC && ((LDC) i).getConstant().equals("replaced"))
			.count(), 1);
		// Check that the "foo4" field access in the new code body was mapped correctly
		assertEquals(ob_foo3
			.getCode()
			.getInstructions()
			.getInstructions()
			.stream()
			.filter(i ->
			{
				if (!(i instanceof GetStatic))
				{
					return false;
				}

				net.runelite.asm.pool.Field field = ((GetStatic) i).getField();

				if (!field.getClazz().getName().equals("net/runelite/injector/VanillaTarget"))
				{
					return false;
				}

				if (!field.getName().equals("ob_foo4"))
				{
					return false;
				}

				return true;
			})
			.count(), 1);
		// Check that the "foo3()" call in the new code body was mapped to the copy
		assertEquals(ob_foo3
			.getCode()
			.getInstructions()
			.getInstructions()
			.stream()
			.filter(i ->
			{
				if (!(i instanceof InvokeVirtual))
				{
					return false;
				}

				net.runelite.asm.pool.Method method = ((InvokeVirtual) i).getMethod();

				if (!method.getClazz().getName().equals("net/runelite/injector/VanillaTarget"))
				{
					return false;
				}

				if (!method.getName().equals("copy$foo3"))
				{
					return false;
				}

				return true;
			})
			.count(), 1);

		// Check if "foo5()V" was injected
		Method foo5 = vanillaTarget.findMethod("foo5");
		assertNotNull(foo5);
		assertEquals(new Signature("()V"), foo5.getDescriptor());
		assertEquals(ACC_PUBLIC, foo5.getAccessFlags());
		// Check that the shadow "foo" field access was mapped correctly
		assertEquals(foo5
			.getCode()
			.getInstructions()
			.getInstructions()
			.stream()
			.filter(i ->
			{
				if (!(i instanceof GetStatic))
				{
					return false;
				}

				net.runelite.asm.pool.Field field = ((GetStatic) i).getField();

				if (!field.getClazz().getName().equals("net/runelite/injector/VanillaTarget"))
				{
					return false;
				}

				if (!field.getName().equals("foo"))
				{
					return false;
				}

				return true;
			})
			.count(), 1);
	}
}
