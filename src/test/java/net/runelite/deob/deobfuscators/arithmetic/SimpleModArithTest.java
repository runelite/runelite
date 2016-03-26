package net.runelite.deob.deobfuscators.arithmetic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import org.junit.Assert;
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
	private void checkConstants(ClassFile cf)
	{
		for (Method m : cf.getMethods().getMethods())
		{
			Code code = m.getCode();
			Instructions instructions = code.getInstructions();
			for (Instruction i : instructions.getInstructions())
			{
				if (i instanceof LDC_W)
				{
					LDC_W ldc = (LDC_W) i;
					Assert.assertFalse(DMath.isBig(ldc.getConstantAsInt()));
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

		ClassFile cf = new ClassFile(group, new DataInputStream(in));
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

		ClassFile cf = new ClassFile(group, new DataInputStream(in));
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
