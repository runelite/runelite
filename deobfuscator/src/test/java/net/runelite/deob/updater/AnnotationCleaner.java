package net.runelite.deob.updater;

import java.io.File;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.deob.Deob;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.DeobTestProperties;
import net.runelite.deob.util.JarUtil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
		File client = new File(properties.getRsClient());
		ClassGroup group = JarUtil.loadJar(client);

		for (ClassFile c : group.getClasses())
		{
			if (c.getName().contains("runelite"))
			{
				continue;
			}

			log.debug("Checking {}", c.toString());

			for (Field f : c.getFields())
			{
				Annotations an = f.getAnnotations();

				String fieldName = f.getName();
				String exportedName = DeobAnnotations.getExportedName(an);

				if (exportedName == null)
				{
					assertTrue("Field " + fieldName + " isn't obfuscated but doesn't have @Export.", Deob.isObfuscated(fieldName) || fieldName.contains("$"));
					continue;
				}

				assertEquals("Field " + fieldName + " has " + exportedName + " in @Export", fieldName, exportedName);
			}

			for (Method m : c.getMethods())
			{
				Annotations an = m.getAnnotations();

				String fieldName = m.getName();
				String exportedName = DeobAnnotations.getExportedName(an);

				if (exportedName == null)
				{
					assertTrue("Method " + fieldName + " isn't obfuscated but doesn't have @Export.", Deob.isObfuscated(fieldName) || fieldName.endsWith("init>") || fieldName.equals("values") || fieldName.equals("valueOf") || fieldName.startsWith("compareTo") || fieldName.equals("equals") || fieldName.equals("hashCode") || fieldName.equals("compare"));
					continue;
				}

				assertEquals("Method " + fieldName + " has " + exportedName + " in @Export", fieldName, exportedName);
			}
		}
	}
}
