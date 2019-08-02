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
package net.runelite.asm;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.pool.Class;
import net.runelite.asm.signature.Signature;
import static net.runelite.deob.DeobAnnotations.*;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClassFile
{
	private ClassGroup group;

	private ClassFile parent; // super class
	private final List<ClassFile> children = new ArrayList<>(); // classes which inherit from this

	private int version;
	private int access;
	private Class name;
	private Class super_class;
	private String source;
	private final Interfaces interfaces;
	private final List<Field> fields = new ArrayList<>();
	private final List<Method> methods = new ArrayList<>();
	private final Annotations annotations;

	public ClassFile(ClassGroup group)
	{
		this.group = group;

		interfaces = new Interfaces(this);
		annotations = new Annotations();
	}

	public ClassFile()
	{
		this(null);
	}

	@Override
	public String toString()
	{
		return "ClassFile{" + "name=" + name + '}';
	}

	public int getVersion()
	{
		return version;
	}

	public void setVersion(int version)
	{
		this.version = version;
	}

	public int getAccess()
	{
		return access;
	}

	public void setAccess(int access)
	{
		this.access = access;
	}

	public void accept(ClassVisitor visitor)
	{
		String[] ints = interfaces.getInterfaces().stream().map(Class::getName).toArray(String[]::new);

		visitor.visit(version, access, name.getName(), null, super_class.getName(), ints);
		visitor.visitSource(source, null);

		for (Annotation annotation : annotations.getAnnotations())
		{
			AnnotationVisitor av = visitor.visitAnnotation(annotation.getType().toString(), true);
			annotation.accept(av);
		}

		for (Field field : fields)
		{
			FieldVisitor fv = visitor.visitField(field.getAccessFlags(), field.getName(), field.getType().toString(), null, field.getValue());
			field.accept(fv);
		}

		for (Method method : methods)
		{
			String[] exceptions = method.getExceptions().getExceptions().stream().map(Class::getName).toArray(String[]::new);
			if (exceptions.length == 0)
			{
				exceptions = null;
			}

			MethodVisitor mv = visitor.visitMethod(method.getAccessFlags(), method.getName(), method.getDescriptor().toString(), null, exceptions);
			method.accept(mv);
		}

		visitor.visitEnd();
	}

	public ClassGroup getGroup()
	{
		return group;
	}

	public void setGroup(ClassGroup group)
	{
		this.group = group;
	}

	public Interfaces getInterfaces()
	{
		return interfaces;
	}

	public List<Field> getFields()
	{
		return fields;
	}

	public void addField(Field field)
	{
		fields.add(field);
	}

	public void removeField(Field field)
	{
		fields.remove(field);
	}

	public List<Method> getMethods()
	{
		return methods;
	}

	public void addMethod(Method method)
	{
		methods.add(method);
	}

	public void removeMethod(Method method)
	{
		methods.remove(method);
	}

	public Annotations getAnnotations()
	{
		return annotations;
	}

	public String getName()
	{
		return name.getName();
	}

	public void setName(String name)
	{
		// Must be removed from the class group map first
		assert group == null || this.name == null || group.findClass(this.name.getName()) == null;

		this.name = new Class(name);
	}

	public String getClassName()
	{
		String n = getName();
		int i = n.lastIndexOf('/');
		return n.substring(i + 1);
	}

	public String getSuperName()
	{
		return super_class.getName();
	}

	public void setSuperName(String name)
	{
		super_class = new Class(name);
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public Class getParentClass()
	{
		return this.super_class;
	}

	public void setParentClass(Class c)
	{
		super_class = c;
	}

	public ClassFile getParent()
	{
		return parent;
	}

	public List<ClassFile> getChildren()
	{
		return children;
	}

	public Field findField(String name, Type type)
	{
		for (Field f : fields)
		{
			if (f.getName().equals(name) && f.getType().equals(type))
			{
				return f;
			}
		}
		return null;
	}

	public Field findField(String name)
	{
		for (Field f : fields)
		{
			if (f.getName().equals(name))
			{
				return f;
			}
		}
		return null;
	}

	public Class getPoolClass()
	{
		return name;
	}

	public Field findFieldDeep(String name, Type type)
	{
		Field f = findField(name, type);
		if (f != null)
		{
			return f;
		}

		ClassFile parent = getParent();
		if (parent != null)
		{
			return parent.findFieldDeep(name, type);
		}

		return null;
	}

	public Method findMethod(String name, Signature type)
	{
		for (Method m : methods)
		{
			if (m.getName().equals(name) && m.getDescriptor().equals(type))
			{
				return m;
			}
		}
		return null;
	}

	public Method findStaticMethod(String name, Signature type)
	{
		for (Method m : methods)
		{
			if (m.isStatic() &&
				m.getName().equals(name) &&
				m.getDescriptor().equals(type))
			{
				return m;
			}
		}
		return null;
	}

	public Method findObfStaticMethod(String name, Signature type)
	{
		for (Method m : methods)
		{
			if (m.isStatic() &&
				name.equals(getObfuscatedName(m.getAnnotations())) &&
				type.equals(getObfuscatedSignature(m)))
			{
				return m;
			}
		}
		return findMethodDeepStatic(name, type);
	}

	public Method findMethod(String name)
	{
		for (Method m : methods)
		{
			if (m.getName().equals(name))
			{
				return m;
			}
		}
		return null;
	}

	public Method findStaticMethod(String name)
	{
		for (Method m : methods)
		{
			if (m.isStatic() && m.getName().equals(name))
			{
				return m;
			}
		}
		return null;
	}

	public Method findMethodDeep(String name, Signature type)
	{
		Method m = findMethod(name, type);
		if (m != null)
		{
			return m;
		}

		ClassFile parent = getParent();
		if (parent != null)
		{
			return parent.findMethodDeep(name, type);
		}

		return null;
	}

	public Method findMethodDeepStatic(String name, Signature type)
	{
		Method m = findStaticMethod(name, type);
		if (m != null)
		{
			return m;
		}

		ClassFile parent = getParent();
		if (parent != null)
		{
			return parent.findMethodDeepStatic(name, type);
		}

		return null;
	}

	public Method findMethodDeep(String name)
	{
		Method m = findMethod(name);
		if (m != null)
		{
			return m;
		}

		ClassFile parent = getParent();
		if (parent != null)
		{
			return parent.findMethodDeep(name);
		}

		return null;
	}

	public void clearClassGraph()
	{
		parent = null;
		children.clear();
	}

	public void buildClassGraph()
	{
		ClassFile other = group.findClass(super_class.getName());
		if (other != null)
		{
			this.parent = other;
			parent.children.add(this);
		}

		for (ClassFile i : interfaces.getMyInterfaces())
		{
			i.children.add(this);
		}
	}

	public boolean instanceOf(ClassFile other)
	{
		return this == other || interfaces.instanceOf(other) || (getParent() != null && getParent().instanceOf(other));
	}

	public boolean isAbstract()
	{
		return (this.access & Opcodes.ACC_ABSTRACT) != 0;
	}

	public boolean isFinal()
	{
		return (this.access & Opcodes.ACC_FINAL) != 0;
	}

	public boolean isInterface()
	{
		return (this.access & Opcodes.ACC_INTERFACE) != 0;
	}

	public boolean isEnum()
	{
		return (this.access & Opcodes.ACC_ENUM) != 0;
	}

	public void setEnum()
	{
		this.access |= Opcodes.ACC_ENUM;
	}

	public void clearFinal()
	{
		this.access &= ~Opcodes.ACC_FINAL;
	}

	public void clearAbstract()
	{
		this.access &= ~Opcodes.ACC_ABSTRACT;
	}
}
