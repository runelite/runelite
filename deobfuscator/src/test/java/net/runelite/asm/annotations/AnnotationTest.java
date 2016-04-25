package net.runelite.asm.annotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.AttributeType;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.pool.UTF8;
import net.runelite.asm.signature.Type;
import org.junit.Assert;
import org.junit.Test;

public class AnnotationTest
{
	@Test
	public void testAnnotation() throws Exception
	{
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("net/runelite/asm/annotations/TestClass.class");
		Assert.assertNotNull(in);
		
		ClassGroup group = new ClassGroup();
		
		ClassFile cf = new ClassFile(group, new DataInputStream(in));
		group.addClass(cf);
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bout);
		cf.write(out); // write it out
		
		// parse it again
		cf = new ClassFile(group, new DataInputStream(new ByteArrayInputStream(bout.toByteArray())));
		
		Method method = cf.getMethods().getMethods().get(1);
		Assert.assertEquals("method1", method.getName());
		
		Annotations annotations = (Annotations) method.getAttributes().findType(AttributeType.RUNTIMEVISIBLEANNOTATIONS);
		Assert.assertNotNull(annotations);
		
		Optional<Annotation> annotation = annotations.getAnnotations().stream().filter(a -> a.getType().equals(new Type("Lnet/runelite/asm/annotations/MyAnnotation;"))).findFirst();
		Assert.assertTrue(annotation.isPresent());
		
		Annotation an = annotation.get();
		List<Element> elements = an.getElements();
		
		Assert.assertEquals(1, elements.size());
		
		Element element = elements.get(0);
		
		Assert.assertEquals("value", element.getType().toString());
		Assert.assertEquals("method1", ((UTF8) element.getValue()).getValue());
	}
}
