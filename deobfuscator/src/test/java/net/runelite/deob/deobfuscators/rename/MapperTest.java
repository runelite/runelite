package net.runelite.deob.deobfuscators.rename;

import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import net.runelite.deob.deobfuscators.mapping.Mapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.signature.Type;
import net.runelite.deob.util.JarUtil;
import org.junit.Ignore;
import org.junit.Test;

// Compares two deobfuscated versions of the client
public class MapperTest
{
	private static final String JAR1 = "C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\1.0-SNAPSHOT\\rs-client-1.0-SNAPSHOT.jar",
		JAR2 = "d:/rs/07/gamepack_v21_deobfuscated.jar";

	private static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");

	@Test
	@Ignore
	public void testRun() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));

		Mapper mapper = new Mapper(group1, group2);
		mapper.run();
		ParallelExecutorMapping mapping = mapper.getMapping();

		checkMappings(group1, group2, mapping);
		
		summary(mapping, group1);

		String sg1 = print(group1),
			sg2 = print(group2);

		System.out.println("GROUP 1 " + sg1);
		System.out.println("GROUP 2 " + sg2);
	}

	private void checkMappings(ClassGroup group1, ClassGroup group2, ParallelExecutorMapping mapping)
	{
		for (ClassFile cf : group1.getClasses())
		{
			for (Field f : cf.getFields().getFields())
			{
				String export = getExport(f.getAttributes().getAnnotations());
				if (export == null)
					continue;

				Field other = (Field) mapping.get(f);
				if (other != null)
				{
				//	System.out.println("Mapped field " + f + " -> " + other);
					continue;
				}

				System.out.println("UNMAPPED FIELD " + export + ": " + f + " -> null");
			}

			for (Method m : cf.getMethods().getMethods())
			{
				String export = getExport(m.getAttributes().getAnnotations());
				if (export == null)
					continue;

				Method other = (Method) mapping.get(m);
				if (other != null)
				{
				//	System.out.println("Mapped method " + m + " -> " + other);
					continue;
				}

				System.out.println("UNMAPPED METHOD " + export + ": " + m + " -> null");
			}
		}
	}

	private String getExport(Annotations an)
	{
		if (an == null)
			return null;

		Annotation a = an.find(EXPORT);
		if (a == null)
			return null;

		return a.getElement().getString();
	}

	public static String print(ClassGroup cg)
	{
		int methods = 0, fields = 0, classes = 0;
		for (ClassFile cf : cg.getClasses())
		{
			++classes;
			methods += cf.getMethods().getMethods().size();
			fields += cf.getFields().getFields().size();
		}
		int total = methods + fields + classes;
		return "total: " + total + ", " + methods + " methods, " + fields + " fields, " + classes + " classes";
	}

	public static void summary(ParallelExecutorMapping finalm, ClassGroup in)
	{
		int fields = 0, staticMethod = 0, method = 0, total = 0, classes = 0;
		for (Map.Entry<Object, Object> e : finalm.getMap().entrySet())
		{
			Object o = e.getKey();
			if (o instanceof Field)
			{
				++fields;

				Field f = (Field) o;
				assert f.getFields().getClassFile().getGroup() == in;
			}
			else if (o instanceof Method)
			{
				Method m = (Method) o;
				assert m.getMethods().getClassFile().getGroup() == in;

				if (m.isStatic())
					++staticMethod;
				else
					++method;
			}
			else if (o instanceof ClassFile)
				++classes;

			++total;
		}
		System.out.println("Total " + total + ". " + fields + " fields, " + staticMethod + " static methods, " + method + " non-static methods, " + classes + " classes");
	}
}
