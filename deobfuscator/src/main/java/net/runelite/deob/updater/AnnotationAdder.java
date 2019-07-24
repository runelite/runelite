package net.runelite.deob.updater;

import com.google.common.base.Strings;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.deob.Deob;
import net.runelite.deob.DeobAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationAdder
{
	AnnotationAdder(ClassGroup group)
	{
		this.group = group;
	}

	private final ClassGroup group;
	private final Logger log = LoggerFactory.getLogger(AnnotationAdder.class);

	public void run()
	{
		int impl = 0;
		int meth = 0;
		int field = 0;

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
				assert implementingName.equals(c.getClassName()) : c + " implements " + implementingName + " but is called " + c.getClassName();
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

				if (exportedName == null && Deob.isObfuscated(fieldName) || fieldName.equals(DeobAnnotations.getObfuscatedName(an)) || DeobAnnotations.getObfuscatedName(an) == null)
				{
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

				String methodName = m.getName();
				String exportedName = DeobAnnotations.getExportedName(an);

				if (exportedName == null && Deob.isObfuscated(methodName) || methodName.equals(DeobAnnotations.getObfuscatedName(an)) || DeobAnnotations.getObfuscatedName(an) == null)
				{
					continue;
				}

				if (!methodName.equals(exportedName))
				{
					log.info("Changed export from {} to {}", exportedName, methodName);
					Annotation a = an.find(DeobAnnotations.EXPORT);
					if (a == null)
					{
						a = new Annotation(an);
						a.setType(DeobAnnotations.EXPORT);

						Element value = new Element(a);
						value.setValue(methodName);
						value.setName("value");
						a.addElement(value);
						an.addAnnotation(a);

					}
					a.getElement().setValue(methodName);
					meth++;
				}
			}
		}

		log.info("Changed {} classes, {} methods, {} fields", impl, meth, field);
	}
}
