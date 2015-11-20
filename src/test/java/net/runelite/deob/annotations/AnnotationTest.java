package net.runelite.deob.annotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import org.junit.Assert;
import org.junit.Test;

public class AnnotationTest
{
	@Test
	public void testAnnotation() throws Exception
	{
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("net/runelite/deob/annotations/TestClass.class");
		Assert.assertNotNull(in);
		
		ClassGroup group = new ClassGroup();
		
		ClassFile cf = new ClassFile(group, new DataInputStream(in));
		group.addClass(cf);
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bout);
		cf.write(out); // write it out
		
		// parse it again
		cf = new ClassFile(group, new DataInputStream(new ByteArrayInputStream(bout.toByteArray())));
		
		System.out.println(cf);
	}
}
