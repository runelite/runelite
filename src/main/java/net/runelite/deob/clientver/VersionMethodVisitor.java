package net.runelite.deob.clientver;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class VersionMethodVisitor extends MethodVisitor
{
	private int state = 0;
	private int version = -1;

	VersionMethodVisitor()
	{
		super(Opcodes.ASM5);
	}

	@Override
	public void visitIntInsn(int opcode, int operand)
	{
		if (state == 2)
		{
			version = operand;
			++state;
		}

		if (operand == 765 || operand == 503)
		{
			++state;
			return;
		}
	}

	public int getVersion()
	{
		return version;
	}
}
