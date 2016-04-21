package net.runelite.deob.clientver;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class VersionClassVisitor extends ClassVisitor
{
	private VersionMethodVisitor vmv = new VersionMethodVisitor();

	public VersionClassVisitor()
	{
		super(Opcodes.ASM5);
	}

	@Override
	public MethodVisitor visitMethod(int access,
		String name,
		String desc,
		String signature,
		String[] exceptions)
	{
		if (!name.equals("init"))
			return null;

		return vmv;
	}

	public int getVersion()
	{
		return vmv.getVersion();
	}
}
