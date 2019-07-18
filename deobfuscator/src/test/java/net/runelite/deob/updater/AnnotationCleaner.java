package net.runelite.deob.updater;

import com.google.common.base.Strings;
import java.io.File;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.deob.Deob;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.DeobTestProperties;
import net.runelite.deob.util.JarUtil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
		File client = new File(properties.getRsClient());
		ClassGroup group = JarUtil.loadJar(client);

		for (ClassFile c : group.getClasses())
		{
			if (c.getName().contains("runelite"))
			{
				continue;
			}

			log.debug("Checking {}", c.toString());

			String implementingName = DeobAnnotations.getImplements(c);
			if (!Strings.isNullOrEmpty(implementingName))
			{
				assertEquals(c + " implements " + implementingName + " but is called " + c.getClassName(), implementingName, c.getClassName());
			}
			else
			{
				assertTrue(c + " isn't obfuscated but doesn't have @Implements", Deob.isObfuscated(c.getClassName()));
			}

			for (Field f : c.getFields())
			{
				Annotations an = f.getAnnotations();

				String fieldName = f.getName();
				String exportedName = DeobAnnotations.getExportedName(an);

				if (exportedName == null)
				{
					assertTrue("Field " + c.getClassName() + '.' + fieldName + " isn't obfuscated but doesn't have @Export.", Deob.isObfuscated(fieldName) || fieldName.equals(DeobAnnotations.getObfuscatedName(an)) || DeobAnnotations.getObfuscatedName(an) == null);
					continue;
				}

				assertEquals("Field " + c.getClassName() + '.' + fieldName + " has " + exportedName + " in @Export", fieldName, exportedName);
			}

			for (Method m : c.getMethods())
			{
				Annotations an = m.getAnnotations();

				String fieldName = m.getName();
				String exportedName = DeobAnnotations.getExportedName(an);

				if (exportedName == null)
				{
					assertTrue("Method " + c.getClassName() + '.' + fieldName + " isn't obfuscated but doesn't have @Export.", Deob.isObfuscated(fieldName) || fieldName.equals(DeobAnnotations.getObfuscatedName(an)) || DeobAnnotations.getObfuscatedName(an) == null);
					continue;
				}

				assertEquals("Method " + c.getClassName() + '.' + fieldName + " has " + exportedName + " in @Export", fieldName, exportedName);
			}
		}
	}

	@Test
	@Ignore
	public void fixMappings() throws Exception
	{
		File client = new File(properties.getRsClient());
		ClassGroup group = JarUtil.loadJar(client);
		int impl = 0,
			meth = 0,
			field = 0;

		for (ClassFile c : group.getClasses())
		{
			if (c.getName().contains("runelite"))
			{
				continue;
			}

			log.debug("Checking {}", c.toString());

			String implementingName = DeobAnnotations.getImplements(c);
			if (!Strings.isNullOrEmpty(implementingName))
			{
				// Still error here cause I don't wanna call classes dumb shit
				assertEquals(c + " implements " + implementingName + " but is called " + c.getClassName(), implementingName, c.getClassName());
			}
			else
			{
				if (!Deob.isObfuscated(c.getClassName()))
				{
					Annotations an = c.getAnnotations();

					Annotation implAn = new Annotation(an);
					implAn.setType(DeobAnnotations.IMPLEMENTS);

					Element value = new Element(implAn);
					value.setValue(c.getClassName());
					value.setName("value");

					implAn.addElement(value);
					an.addAnnotation(implAn);
					impl++;
				}
			}

			for (Field f : c.getFields())
			{
				Annotations an = f.getAnnotations();

				String fieldName = f.getName();
				String exportedName = DeobAnnotations.getExportedName(an);

				if (exportedName == null && Deob.isObfuscated(fieldName) ||  fieldName.equals(DeobAnnotations.getObfuscatedName(an)) || DeobAnnotations.getObfuscatedName(an) == null)
				{
					//Annotation exp = new Annotation(an);
					//exp.setType(DeobAnnotations.EXPORT);
//
					//Element ele = new Element(exp);
					//ele.setValue(fieldName);
//
					//log.info("Added export on {}", fieldName);
					//field++;
					continue;
				}

				if (!fieldName.equals(exportedName))
				{
					log.info("Changed export from {} to {}", exportedName, fieldName);
					Annotation a = an.find(DeobAnnotations.EXPORT);
					if (a == null)
					{
						a = new Annotation(an);
						a.setType(DeobAnnotations.EXPORT);

						Element value = new Element(a);
						value.setValue(fieldName);
						value.setName("value");
						a.addElement(value);
						an.addAnnotation(a);

					}
					a.getElement().setValue(fieldName);
					field++;
				}
			}

			for (Method m : c.getMethods())
			{
				Annotations an = m.getAnnotations();

				String fieldName = m.getName();
				String exportedName = DeobAnnotations.getExportedName(an);

				if (exportedName == null && Deob.isObfuscated(fieldName) || fieldName.equals(DeobAnnotations.getObfuscatedName(an)) || DeobAnnotations.getObfuscatedName(an) == null)
				{
					continue;
				//	Annotation exp = new Annotation(an);
				//	exp.setType(DeobAnnotations.EXPORT);
//
				//	Element ele = new Element(exp);
				//	ele.setValue(fieldName);
//
				//	log.info("Added export on {}", fieldName);
				//	meth++;
				}

				if (!fieldName.equals(exportedName))
				{
					log.info("Changed export from {} to {}", exportedName, fieldName);
					Annotation a = an.find(DeobAnnotations.EXPORT);
					if (a == null)
					{
						a = new Annotation(an);
						a.setType(DeobAnnotations.EXPORT);

						Element value = new Element(a);
						value.setValue(fieldName);
						value.setName("value");
						a.addElement(value);
						an.addAnnotation(a);

					}
					a.getElement().setValue(fieldName);
					meth++;
				}
			}
		}

		log.info("Changed {} classes, {} methods, {} fields", impl, meth, field);
		JarUtil.saveJar(group, new File("C:/Users/Lucas/Desktop/niec.jar"));
	}
}
