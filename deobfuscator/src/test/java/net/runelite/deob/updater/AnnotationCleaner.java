package net.runelite.deob.updater;

import com.google.common.base.Strings;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.deob.Deob;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.DeobTestProperties;
import net.runelite.deob.util.JarUtil;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationCleaner
{
	private final Logger log = LoggerFactory.getLogger(AnnotationCleaner.class);

	@Rule
	public DeobTestProperties properties = new DeobTestProperties();

	@Test
	public void checkMappings() throws Exception
	{
		final List<String> missing = new ArrayList<>();
		File client = new File(properties.getRsClient());
		ClassGroup group = JarUtil.loadJar(client);

		for (ClassFile c : group.getClasses())
		{
			if (c.getName().contains("runelite"))
			{
				continue;
			}
			final String className = c.getClassName();

			log.debug("Checking {}", c.toString());

			String implementingName = DeobAnnotations.getImplements(c);
			if (!Strings.isNullOrEmpty(implementingName))
			{
				if (!implementingName.equals(className))
				{
					missing.add("Implements: " + className + " != " + implementingName);
				}
			}
			else if (!Deob.isObfuscated(c.getClassName()))
			{
				missing.add("Implements: " + className + " == missing");
			}

			for (Field f : c.getFields())
			{
				Annotations an = f.getAnnotations();

				String fieldName = f.getName();
				String exportedName = DeobAnnotations.getExportedName(an);

				if (exportedName == null)
				{
					if (!Deob.isObfuscated(fieldName) && DeobAnnotations.getObfuscatedName(an) != null)
					{
						missing.add("Export: (field)  " + className + '.' + fieldName + " == missing");
					}
				}
				else if (!fieldName.equals(exportedName))
				{
					missing.add("Export: (field)  " + className + '.' + fieldName + " != " + exportedName);
				}
			}

			for (Method m : c.getMethods())
			{
				Annotations an = m.getAnnotations();

				String methodName = m.getName();
				String exportedName = DeobAnnotations.getExportedName(an);

				if (exportedName == null)
				{
					if (!Deob.isObfuscated(methodName) && DeobAnnotations.getObfuscatedName(an) != null)
					{
						missing.add("Export: (method) " + className + '.' + methodName + " == missing");
					}
				}
				else if (!methodName.equals(exportedName))
				{
					missing.add("Export: (method) " + className + '.' + methodName + " != " + exportedName);
				}
			}
		}

		if (missing.isEmpty())
		{
			return;
		}

		log.error("{} missing annotations!", missing.size());
		for (String s : missing)
		{
			log.error(s);
		}

		throw new OhNoException();
	}

	@Test
	@Ignore
	public void fixMappings() throws Exception
	{
		File client = new File(properties.getRsClient());

		ClassGroup group = JarUtil.loadJar(client);

		new AnnotationAdder(group).run();

		JarUtil.saveJar(group, new File("C:/Users/Lucas/Desktop/niec.jar"));
	}

	private class OhNoException extends Exception
	{
		private OhNoException()
		{
		}
	}
}
