package net.runelite.deob.deobfuscators.arithmetic;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.Method;
import net.runelite.deob.Methods;
import net.runelite.deob.attributes.Attributes;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instructions.Dup_X1;
import net.runelite.deob.attributes.code.instructions.IConst_0;
import net.runelite.deob.attributes.code.instructions.IConst_3;
import net.runelite.deob.attributes.code.instructions.ILoad;
import net.runelite.deob.attributes.code.instructions.IMul;
import net.runelite.deob.attributes.code.instructions.IStore_0;
import net.runelite.deob.attributes.code.instructions.LDC_W;
import net.runelite.deob.attributes.code.instructions.Pop;
import net.runelite.deob.attributes.code.instructions.VReturn;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.signature.Signature;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultiplicationDeobfuscatorTest
{
	private ClassGroup group;
	private Code code;
	private Instructions ins;
	
	@Before
	public void init()
	{
		group = new ClassGroup();
		
		ClassFile cf = new ClassFile(group);
		cf.setName("test");
		cf.setSuperName("java/lang/Object");
		group.addClass(cf);
		
		Methods methods = cf.getMethods();
		Method method = new Method(methods, "func", new Signature("()V"));
		method.setStatic();
		methods.addMethod(method);
		
		Attributes methodAttributes = method.getAttributes();
		
		code = new Code(methodAttributes);
		methodAttributes.addAttribute(code);
		
		ins = code.getInstructions();
	}
	
	//   aload                 2
	//   ldc_w                 1587543155
	//   iload                 4
	//   imul
	//   dup_x1
	//   ldc_w                 -2130376517
	//   imul
	//   putfield              class2/field279 I
	//   ldc_w                 -67313687
	//   imul
	//   putstatic             class29/field949 I
	@Test
	public void testDupX1()
	{
		code.setMaxStack(5);

		// vars[0] = 3
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		LDC_W constant1 = new LDC_W(ins,  1587543155),
		      constant2 = new LDC_W(ins, -2130376517),
		      constant3 = new LDC_W(ins,   -67313687);

		Instruction body[] = {
			new IConst_0(ins), // for dup_x1 to place before this
			constant1,
			new ILoad(ins, 0),
			new IMul(ins),
			new Dup_X1(ins),
			constant2,
			new IMul(ins),
			new Pop(ins),
			new Pop(ins),
			constant3,
			new IMul(ins),
			new Pop(ins),
			new VReturn(ins)
		};
		
		for (Instruction i : body)
			ins.addInstruction(i);
		
		// check execution runs ok
		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();
		
		assert constant1.getConstantAsInt() * constant2.getConstantAsInt() == 1;
		assert constant1.getConstantAsInt() * constant3.getConstantAsInt() == -1_095_175_765;
		
		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);
		
		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
		Assert.assertEquals(-1_095_175_765, constant3.getConstantAsInt());
	}
}
