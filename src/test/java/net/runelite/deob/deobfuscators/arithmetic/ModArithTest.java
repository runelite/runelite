package net.runelite.deob.deobfuscators.arithmetic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instructions.LDC_W;
import org.junit.Assert;
import org.junit.Test;

class TestClass
{
	private static int dummy(Object... args) { return 0; }
	private static final int var = 42;

	private static int field1051 = -1611704481;
	private int field2701;

	public void test()
	{
		if (-1 != this.field1051 * 1928543073)
		{
			dummy(this.field1051 * 1928543073);
			this.field1051 = dummy() * 1611704481;
		}

		if (field2701 * 1550405721 > 30000)
		{
			field2701 += -1868498967 * var;
		}
	}
}

public class ModArithTest
{
	private void checkConstants(ClassFile cf)
	{
		for (Method m : cf.getMethods().getMethods())
		{
			Code code = m.getCode();
			Instructions instructions = code.getInstructions();
			for (Instruction i : instructions.getInstructions())
				if (i instanceof LDC_W)
				{
					LDC_W ldc = (LDC_W) i;
					Assert.assertFalse(DMath.isBig(ldc.getConstantAsInt()));
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
}
