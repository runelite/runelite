/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.injector;

import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import static net.runelite.asm.attributes.code.InstructionType.CHECKCAST;
import net.runelite.asm.attributes.code.Instructions;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InjectSetterTest
{
	@Test
	public void testInjectSetterInt() throws NoSuchMethodException
	{
		Inject inject = mock(Inject.class);

		when(inject.findImportMethodOnApi(any(Class.class), anyString(), any(Boolean.class)))
			.thenReturn(APIClass.class.getDeclaredMethod("setTest", int.class));

		when(inject.createLoadForTypeIndex(any(Instructions.class), any(Type.class), anyInt()))
			.thenReturn(mock(Instruction.class));

		InjectSetter instance = new InjectSetter(inject);
		ClassFile targetClass = new ClassFile();
		targetClass.setName("test");

		Field field = new Field(targetClass, "test", Type.INT);
		targetClass.addField(field);

		instance.injectSetter(targetClass, APIClass.class, field, "test", null);

		Method injectedMethod = targetClass.findMethod("setTest");
		assertNotNull(injectedMethod);

		Code code = injectedMethod.getCode();
		Instructions instructions = code.getInstructions();
		assertFalse(instructions.getInstructions().stream()
			.filter(i -> i.getType() == CHECKCAST)
			.findAny()
			.isPresent());
	}

	@Test
	public void testInjectSetterObject() throws NoSuchMethodException
	{
		Inject inject = mock(Inject.class);

		when(inject.findImportMethodOnApi(any(Class.class), anyString(), any(Boolean.class)))
			.thenReturn(APIClass.class.getDeclaredMethod("setTestObject", Object.class));

		when(inject.createLoadForTypeIndex(any(Instructions.class), any(Type.class), anyInt()))
			.thenReturn(mock(Instruction.class));

		InjectSetter instance = new InjectSetter(inject);
		ClassFile targetClass = new ClassFile();
		targetClass.setName("test");

		Field field = new Field(targetClass, "testObject", Type.STRING);
		targetClass.addField(field);

		instance.injectSetter(targetClass, APIClass.class, field, "testObject", null);

		Method injectedMethod = targetClass.findMethod("setTestObject");
		assertNotNull(injectedMethod);

		Code code = injectedMethod.getCode();
		Instructions instructions = code.getInstructions();
		assertTrue(instructions.getInstructions().stream()
			.filter(i -> i.getType() == CHECKCAST)
			.findAny()
			.isPresent());
	}

	interface APIClass
	{
		void setTest(int i);

		void setTestObject(Object str);
	}

}
