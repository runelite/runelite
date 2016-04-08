package net.runelite.deob;

import net.runelite.asm.ClassGroup;
import java.io.File;
import java.io.IOException;
import net.runelite.deob.deobfuscators.ConstantParameter;
import net.runelite.deob.deobfuscators.FieldInliner;
import net.runelite.deob.deobfuscators.IllegalStateExceptions;
import net.runelite.deob.deobfuscators.RenameUnique;
import net.runelite.deob.deobfuscators.RuntimeExceptions;
import net.runelite.deob.deobfuscators.UnreachedCode;
import net.runelite.deob.deobfuscators.UnusedClass;
import net.runelite.deob.deobfuscators.UnusedFields;
import net.runelite.deob.deobfuscators.UnusedMethods;
import net.runelite.deob.deobfuscators.UnusedParameters;
import net.runelite.deob.deobfuscators.arithmetic.ModArith;
import net.runelite.deob.deobfuscators.arithmetic.MultiplicationDeobfuscator;
import net.runelite.deob.deobfuscators.arithmetic.MultiplyOneDeobfuscator;
import net.runelite.deob.deobfuscators.arithmetic.MultiplyZeroDeobfuscator;
import net.runelite.asm.execution.Execution;
import net.runelite.deob.util.JarUtil;

public class Deob
{
	public static void main(String[] args) throws IOException
	{	
		long start = System.currentTimeMillis();
		
		ClassGroup group = JarUtil.loadJar(new File(args[0]));
		
		run(group, new RenameUnique());

		// remove except RuntimeException
		run(group, new RuntimeExceptions());

		// remove unused methods
		run(group, new UnreachedCode());
		run(group, new UnusedMethods());

		// remove illegal state exceptions, frees up some parameters
		run(group, new IllegalStateExceptions());

		// remove constant logically dead parameters
		run(group, new ConstantParameter());

		// remove unhit blocks
		run(group, new UnreachedCode());
		run(group, new UnusedMethods());

		// remove unused parameters
		run(group, new UnusedParameters());

		// remove unused fields
		run(group, new UnusedFields());

		// remove unused methods, again?
		run(group, new UnusedMethods());

		run(group, new FieldInliner());

		run(group, new UnusedClass());

		ModArith mod = new ModArith();
		mod.run(group);

		int last = -1, cur;
		while ((cur = mod.runOnce()) > 0)
		{
			new MultiplicationDeobfuscator().run(group);

			new MultiplyOneDeobfuscator().run(group);

			new MultiplyZeroDeobfuscator().run(group);

			if (last == cur)
				break;

			last = cur;
		}

		mod.annotateEncryption();

		JarUtil.saveJar(group, new File(args[1]));
		
		long end = System.currentTimeMillis();
		System.out.println("Done in " + ((end - start) / 1000L) + "s");
	}
	
	public static boolean isObfuscated(String name)
	{
		return name.length() <= 2 || name.startsWith("method") || name.startsWith("vmethod") || name.startsWith("field") || name.startsWith("class");
	}
	
	private static void run(ClassGroup group, Deobfuscator deob)
	{
		long bstart, bdur;
		
		bstart = System.currentTimeMillis();
		deob.run(group);
		bdur = System.currentTimeMillis() - bstart;
		
		System.out.println(deob.getClass().getName() + " took " + (bdur / 1000L) + " seconds");
		
		// check code is still correct
		Execution execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
	}
}