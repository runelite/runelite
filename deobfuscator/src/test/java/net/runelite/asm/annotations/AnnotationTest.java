/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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
