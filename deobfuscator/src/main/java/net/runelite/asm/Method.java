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

package net.runelite.asm;

import net.runelite.asm.attributes.AttributeType;
import net.runelite.asm.attributes.Attributes;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.Exceptions;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.pool.NameAndType;
import net.runelite.asm.signature.Signature;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Method
{
	public static final short ACC_PUBLIC = 0x1;
	public static final short ACC_PRIVATE = 0x2;
	public static final short ACC_PROTECTED = 0x4;
	public static final short ACC_STATIC = 0x8;
	public static final short ACC_FINAL = 0x10;
	public static final short ACC_SYNCHRONIZED = 0x20;
	public static final short ACC_ABSTRACT = 0x400;

	public static final short ACCESS_MODIFIERS = ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED;
	
	private Methods methods;

	private short accessFlags;
	private String name;
	public Signature arguments;
	private Attributes attributes;

	Method(Methods methods, DataInputStream is) throws IOException
	{
		this.methods = methods;

		ConstantPool pool = methods.getClassFile().getPool();

		accessFlags = is.readShort();
		name = pool.getUTF8(is.readUnsignedShort());
		arguments = new Signature(pool.getUTF8(is.readUnsignedShort()));
		attributes = new Attributes(this);
		attributes.load(is);
	}
	
	public Method(Methods methods, String name, Signature signature)
	{
		this.methods = methods;
		this.name = name;
		this.arguments = signature;
		attributes = new Attributes(this);
	}
	
	@Override
	public String toString()
	{
		return (this.isStatic() ? "static " : "") + this.getMethods().getClassFile().getName() + "." + this.name + this.arguments;
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		assert methods.getMethods().contains(this);
		
		ConstantPool pool = methods.getClassFile().getPool();
		
		out.writeShort(accessFlags);
		out.writeShort(pool.makeUTF8(name));
		out.writeShort(pool.makeUTF8(arguments.toString()));
		attributes.write(out);
	}

	public Methods getMethods()
	{
		return methods;
	}
	
	public void setMethods(Methods methods)
	{
		this.methods = methods;
	}
	
	public Attributes getAttributes()
	{
		return attributes;
	}
	
	public void setAttributes(Attributes a)
	{
		this.attributes = a;
	}

	public short getAccessFlags()
	{
		return accessFlags;
	}

	public void setAccessFlags(short accessFlags)
	{
		this.accessFlags = accessFlags;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public Signature getDescriptor()
	{
		return arguments;
	}
	
	public NameAndType getNameAndType()
	{
		return new NameAndType(name, arguments);
	}
	
	public boolean isStatic()
	{
		return (accessFlags & ACC_STATIC) != 0;
	}
	
	public void setStatic()
	{
		accessFlags |= ACC_STATIC;
	}
	
	public boolean isSynchronized()
	{
		return (accessFlags & ACC_SYNCHRONIZED) != 0;
	}

	public boolean isFinal()
	{
		return (accessFlags & ACC_FINAL) != 0;
	}

	public void setFinal(boolean f)
	{
		if (f)
			accessFlags |= ACC_FINAL;
		else
			accessFlags &= ~ACC_FINAL;
	}

	public boolean isPrivate()
	{
		return (accessFlags & ACC_PRIVATE) != 0;
	}

	public void setPrivate()
	{
		accessFlags = (short) ((accessFlags & ~ACCESS_MODIFIERS) | ACC_PRIVATE);
	}

	public void setPublic()
	{
		accessFlags = (short) ((accessFlags & ~ACCESS_MODIFIERS) | ACC_PUBLIC);
	}
	
	public Exceptions getExceptions()
	{
		return (Exceptions) attributes.findType(AttributeType.EXCEPTIONS);
	}

	public Code getCode()
	{
		return (Code) attributes.findType(AttributeType.CODE);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Instruction & LVTInstruction> List<T> findLVTInstructionsForVariable(int index)
	{
		List<T> list = new ArrayList<>();
		
		if (getCode() == null)
			return null;
		
		for (Instruction ins : getCode().getInstructions().getInstructions())
			if (ins instanceof LVTInstruction)
			{
				LVTInstruction lv = (LVTInstruction) ins;
				
				if (lv.getVariableIndex() != index)
					continue;
				
				list.add((T) ins);
			}
		
		return list;
	}
	
	public net.runelite.asm.pool.Method getPoolMethod()
	{
		return new net.runelite.asm.pool.Method(
			new net.runelite.asm.pool.Class(this.getMethods().getClassFile().getName()),
			new NameAndType(this.getName(), new Signature(this.getDescriptor()))
		);
	}
	
	public net.runelite.asm.pool.InterfaceMethod getPoolInterfaceMethod()
	{
		return new net.runelite.asm.pool.InterfaceMethod(
			new net.runelite.asm.pool.Class(this.getMethods().getClassFile().getName()),
			new NameAndType(this.getName(), new Signature(this.getDescriptor()))
		);
	}
}
