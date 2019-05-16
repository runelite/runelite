/*
 *  Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package us.runelitepl.mixinprocessor.transformers;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.Remapper;
import us.runelitepl.mixinprocessor.MixinProcessorMojo;
import us.runelitepl.mixinprocessor.util.RefUtils;

public class AsmNameTransformer extends AsmBaseTransformer
{
	
	private String className;
	private byte[] bytecode;
	
	public AsmNameTransformer(String className, byte[] bytecode)
	{
		this.className = className;
		this.bytecode = bytecode;
	}
	
	@Override
	public byte[] transform()
	{
		ClassReader cr = new ClassReader(bytecode);
		ClassWriter cw = new ClassWriter(cr, 0);
		ClassRemapper remapper = new ClassRemapper(cw, new Remapper()
		{
			
			final String TYPE_PREFIX = "us/runelitepl/mixins/";
			
			@Override
			public String map(String internalName)
			{
				return super.map(internalName);
			}
			
			@Override
			public String mapDesc(String descriptor)
			{
				return RefUtils.reobDescriptor(descriptor);
			}
			
			@Override
			public String mapFieldName(String owner, String name, String descriptor)
			{
				String oldName = name;
				String noPackage = owner.replace(TYPE_PREFIX, "");
				
				descriptor = mapDesc(descriptor);
				
				owner = RefUtils.reobClassName(owner);
				if (RefUtils.shouldReobField(noPackage, name, descriptor))
				{
					name = RefUtils.reobFieldName(noPackage, name, descriptor);
					if (name == null)
					{
						MixinProcessorMojo.log("Failed to reobfuscate field name %s.%s", noPackage, oldName);
						throw new RuntimeException();
					}
				}
				return super.mapFieldName(owner, name, descriptor);
			}
			
			@Override
			public String mapInvokeDynamicMethodName(String name, String descriptor)
			{
				throw new UnsupportedOperationException("mapInvokeDynamicMethodName: Not implemented yet," +
						"\nAsmNameTransformer#mapInvokeDynamicMethodName(" + name + ", " + descriptor + ")");
			}
			
			@Override
			public String mapMethodDesc(String descriptor)
			{
				return RefUtils.reobMethodDescriptor(descriptor);
			}
			
			@Override
			public String mapMethodName(String owner, String name, String descriptor)
			{
				String originalClass = owner;
				if (originalClass.startsWith(TYPE_PREFIX))
				{
					originalClass = originalClass.substring(TYPE_PREFIX.length());
				}
				owner = RefUtils.reobClassName(owner);
				if (name.startsWith("protect$"))
				{
					name = "1" + name;
				}
				// descriptor for reob checking is obfuscated
				descriptor = mapMethodDesc(descriptor);
				boolean reob = RefUtils.shouldReobMethod(originalClass, name, descriptor);
				
				if (reob)
				{
					String originalName = name;
					name = RefUtils.reobMethodName(originalClass, name, descriptor);
					if (name == null)
					{
						MixinProcessorMojo.log("Failed to reobfuscate method: %s.%s%s", originalClass, originalName,
							descriptor);
						throw new RuntimeException();
					}
				}
				
				
				//stderr("mapMethodName %s %s %s", owner, name, descriptor);
				return super.mapMethodName(owner, name, descriptor);
			}
			
			@Override
			public String mapPackageName(String name)
			{
				throw new UnsupportedOperationException("mapPackageName: Not implemented yet," +
						"\nAsmNameTransformer#mapPackageName(" + name + ")");
			}
			
			@Override
			public String mapSignature(String signature, boolean isTypeSig)
			{
				return super.mapSignature(signature, isTypeSig);
			}
			
			@Override
			public String mapType(String internalName)
			{
				internalName = RefUtils.reobClassName(internalName);
				return super.mapType(internalName);
			}
			
			@Override
			public String[] mapTypes(String[] internalNames)
			{
				return super.mapTypes(internalNames);
			}
			
			@Override
			public Object mapValue(Object value)
			{
				return super.mapValue(value);
			}
			
		});
		
		cr.accept(remapper, 0);
		
		return cw.toByteArray();
	}
}
