/*
 * Copyright (c) 2018 Abex
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
package net.runelite.injector.raw;

import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import net.runelite.injector.Inject;

public class DeobfuscatedName
{
	private final Inject inject;

	public DeobfuscatedName(Inject inject)
	{
		this.inject = inject;
	}

	public void inject()
	{
		injectDeobfuscatedName();
	}

	private static final Type DEOBFUSCATED_NAME = new Type("Lnet/runelite/api/DeobfuscatedName;");

	private void injectDeobfuscatedName()
	{
		for (ClassFile deobClass : inject.getDeobfuscated().getClasses())
		{
			ClassFile obClass = inject.toObClass(deobClass);
			if (obClass == null)
			{
				continue;
			}

			for (Method deobMethod : deobClass.getMethods())
			{
				String obfuscatedName = DeobAnnotations.getObfuscatedName(deobMethod.getAnnotations());
				Signature obfuscatedSignature = DeobAnnotations.getObfuscatedSignature(deobMethod);

				Method obMethod = obClass.findMethod(obfuscatedName, (obfuscatedSignature != null) ? obfuscatedSignature : deobMethod.getDescriptor());
				if (obMethod == null)
				{
					continue;
				}

				Annotations annos = obMethod.getAnnotations();
				Annotation deobname = new Annotation(annos);
				annos.addAnnotation(deobname);

				deobname.setType(DEOBFUSCATED_NAME);

				Element className = new Element(deobname);
				deobname.addElement(className);
				className.setName("className");
				className.setValue(deobClass.getName());

				Element methodName = new Element(deobname);
				deobname.addElement(methodName);
				methodName.setName("methodName");
				methodName.setValue(deobMethod.getName());

				Element fileName = new Element(deobname);
				deobname.addElement(fileName);
				fileName.setName("fileName");
				fileName.setValue(deobClass.getName() + ".java");

				if (deobMethod.getCode() != null)
				{
					Label label = deobMethod.getCode().getInstructions().getInstructions().stream()
						.filter(i -> i instanceof Label)
						.map(i -> (Label) i)
						.filter(l -> l.getLineNumber() != null)
						.findFirst().orElse(null);
					if (label != null)
					{
						Element lineNo = new Element(deobname);
						deobname.addElement(lineNo);
						lineNo.setName("lineNo");
						lineNo.setValue(label.getLineNumber());
					}
				}
			}
		}
	}
}
