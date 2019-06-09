/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.deobfuscators.arithmetic;

import java.io.IOException;
import java.io.InputStream;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.ClassUtil;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.deob.Deobfuscator;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

class TestClass
{
	private static int dummy(Object... args)
	{
		return 0;
	}

	private int field1051 = -1611704481;
	private int field2701;
	private int field2138, field2130;

	public void test()
	{
		TestClass tc = new TestClass(); // to trick executor to call the constructor
		int var = 42;

		if (-1 != this.field1051 * 1928543073)
		{
			dummy(this.field1051 * 1928543073);
			this.field1051 = dummy() * 1611704481;
		}

		if (field2701 * 1550405721 > 30000)
		{
			field2701 += -1868498967 * var;
		}

		field2138 = tc.dummy() * 1510226873;
		field2130 = 572701809 * tc.field2138;
		if (-1722291303 * field2130 >= var)
		{
			var = field2130 * -1722291303;
		}
	}
}

class TestClass2
{
	int field2863;
	int array[];

	public void test()
	{
		TestClass2 tc = new TestClass2();

		field2863 = -1446933277;

		array[378529589 * tc.field2863] = 1;

		int var = 32;

		tc.field2863 = var * 1446933277;

		array[378529589 * tc.field2863] = 1;
	}
}

public class SimpleModArithTest
{
	static boolean isBig(int val)
	{
		if ((val & 0x80000000) != 0)
		{
			val = ~val + 1;
		}
		return (val & 0x7ff00000) != 0;
	}

	private void checkConstants(ClassFile cf)
	{
		for (Method m : cf.getMethods())
		{
			Code code = m.getCode();
			Instructions instructions = code.getInstructions();
			for (Instruction i : instructions.getInstructions())
			{
				if (i instanceof LDC)
				{
					LDC ldc = (LDC) i;
					Integer value = (Integer) ldc.getConstantAsInt();
					assertFalse(isBig(value));
				}
			}
		}
	}

	@Test
	public void test() throws IOException
	{
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("net/runelite/deob/deobfuscators/arithmetic/TestClass.class");
		Assert.assertNotNull(in);

		ClassGroup group = new ClassGroup();

		ClassFile cf = ClassUtil.loadClass(in);
		group.addClass(cf);

		ModArith d1 = new ModArith();
		d1.run(group);
		d1.runOnce();

		Deobfuscator d2 = new MultiplicationDeobfuscator();
		d2.run(group);

		this.checkConstants(cf);
	}

	@Test
	public void test2() throws IOException
	{
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("net/runelite/deob/deobfuscators/arithmetic/TestClass2.class");
		Assert.assertNotNull(in);

		ClassGroup group = new ClassGroup();

		ClassFile cf = ClassUtil.loadClass(in);
		group.addClass(cf);

		ModArith d1 = new ModArith();
		d1.run(group);
		d1.runOnce();

		Deobfuscator d2 = new MultiplicationDeobfuscator();
		d2.run(group);

		Encryption e = d1.getEncryption();

		Pair pair = e.getField(cf.findField("field2863").getPoolField());

		Assert.assertEquals(378529589, (int) pair.getter);
	}
}
