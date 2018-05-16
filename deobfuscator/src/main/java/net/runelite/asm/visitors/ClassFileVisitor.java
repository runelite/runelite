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

package net.runelite.asm.visitors;

import net.runelite.asm.ClassFile;
import net.runelite.asm.Type;
import net.runelite.asm.signature.Signature;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClassFileVisitor extends ClassVisitor
{
	private final ClassFile classFile = new ClassFile();

	public ClassFileVisitor()
	{
		super(Opcodes.ASM5);
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
	{
		classFile.setName(name);
		classFile.setSuperName(superName);
		classFile.setVersion(version);
		classFile.setAccess(access);
		
		for (String inter : interfaces)
			classFile.getInterfaces().addInterface(new net.runelite.asm.pool.Class(inter));
	}

	@Override
	public void visitSource(String source, String debug)
	{
		classFile.setSource(source);
	}

	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible)
	{
		Type type = new Type(desc);
		return new ClassAnnotationVisitor(classFile, type);
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc, String signature, Object value)
	{
		return new ClassFieldVisitor(classFile, access, name, new Type(desc), value);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
	{
		return new CodeVisitor(classFile, access, name, new Signature(desc), exceptions);
	}
}
