package net.runelite.deob.updater;

import java.io.File;
import java.io.IOException;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.deobfuscators.mapping.AnnotationMapper;
import net.runelite.deob.deobfuscators.mapping.Mapper;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import net.runelite.deob.util.JarUtil;

public class UpdateMappings
{
	private final ClassGroup group1, group2;

	public UpdateMappings(ClassGroup group1, ClassGroup group2)
	{
		this.group1 = group1;
		this.group2 = group2;
	}

	public void update()
	{
		Mapper mapper = new Mapper(group1, group2);
		mapper.run();
		ParallelExecutorMapping mapping = mapper.getMapping();

		AnnotationMapper amapper = new AnnotationMapper(group1, group2, mapping);
		amapper.run();
	}

	public void save(File out) throws IOException
	{
		JarUtil.saveJar(group2, out);
	}

	public static void main(String[] args) throws IOException
	{
		if (args.length < 3)
			System.exit(-1);

		UpdateMappings u = new UpdateMappings(
			JarUtil.loadJar(new File(args[0])),
			JarUtil.loadJar(new File(args[1]))
		);
		u.update();
		u.save(new File(args[2]));
	}
}
