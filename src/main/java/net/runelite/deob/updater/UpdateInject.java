package net.runelite.deob.updater;

import java.io.File;
import java.io.IOException;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.injection.Inject;
import net.runelite.deob.util.JarUtil;

public class UpdateInject
{
	private final ClassGroup deobfuscated, vanilla;

	public UpdateInject(ClassGroup deobfuscated, ClassGroup vanilla)
	{
		this.deobfuscated = deobfuscated;
		this.vanilla = vanilla;
	}

	public void inject()
	{
		Inject instance = new Inject(deobfuscated, vanilla);
		instance.run();
	}

	public void save(File out) throws IOException
	{
		JarUtil.saveJar(vanilla, out);
	}

	public static void main(String[] args) throws IOException
	{
		if (args.length < 3)
			System.exit(-1);
		
		UpdateInject u = new UpdateInject(
			JarUtil.loadJar(new File(args[0])),
			JarUtil.loadJar(new File(args[1]))
		);
		u.inject();
		u.save(new File(args[2]));
	}
}
