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

package us.runelitepl.mixinprocessor.parsers;

import javassist.CtClass;
import javassist.CtField;
import us.runelitepl.mixinprocessor.annotations.Append;
import us.runelitepl.mixinprocessor.annotations.Inject;
import us.runelitepl.mixinprocessor.annotations.Overwrite;
import us.runelitepl.mixinprocessor.annotations.Prepend;
import us.runelitepl.mixinprocessor.annotations.Provided;
import us.runelitepl.mixinprocessor.annotations.Reobfuscate;
import us.runelitepl.mixinprocessor.enums.InjectionType;
import us.runelitepl.mixinprocessor.util.RefUtils;

import static us.runelitepl.mixinprocessor.MixinProcessorMojo.isFieldTagged;

public class FieldAnnotationParser
{
	
	private CtClass clazz;
	
	public FieldAnnotationParser(CtClass clazz)
	{
		this.clazz = clazz;
	}
	
	public void run() throws ClassNotFoundException
	{
		for (CtField field : clazz.getDeclaredFields())
		{
			Object[] annotations = field.getAnnotations();
			
			InjectionType type = null;
			boolean reobfuscate = false;
			
			for (Object obj : annotations)
			{
				reobfuscate = obj instanceof Reobfuscate || reobfuscate;
				if (obj instanceof Inject)
				{
					type = InjectionType.INJECT;
				}
				else if (obj instanceof Append)
				{
					type = InjectionType.APPEND;
				}
				else if (obj instanceof Overwrite)
				{
					type = InjectionType.OVERWRITE;
				}
				else if (obj instanceof Prepend)
				{
					type = InjectionType.PREPEND;
				}
				else if (obj instanceof Provided)
				{
					type = InjectionType.PROVIDED;
				}
			}
			
			String fieldOwner = field.getDeclaringClass().getSimpleName();
			String fieldName = field.getName();
			String fieldDescriptor = RefUtils.reobDescriptor(field.getSignature());
			
			if (type == null)
			{
				throw new RuntimeException(
						field.getDeclaringClass().getSimpleName() + "." + field.getName() + " is unannotated" +
								"!");
			}
			
			if (type != InjectionType.PROVIDED && type != InjectionType.INJECT)
			{
				throw new RuntimeException(
						field.getDeclaringClass().getSimpleName() + "." + field.getName() + " has an invalid " +
								"annotation! @" + type);
			}
			
			if (reobfuscate)
			{
				isFieldTagged.put(fieldOwner + " " + fieldName + " " + fieldDescriptor, true);
			}
		}
	}
	
}
