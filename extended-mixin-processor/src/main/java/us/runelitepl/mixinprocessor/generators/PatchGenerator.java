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

package us.runelitepl.mixinprocessor.generators;

import us.runelitepl.mixinprocessor.transformers.AnnotationRemoverTransformer;
import us.runelitepl.mixinprocessor.transformers.AsmMethodGarbageTransformer;
import us.runelitepl.mixinprocessor.transformers.AsmMethodSignatureTransformer;
import us.runelitepl.mixinprocessor.transformers.AsmNameTransformer;
import us.runelitepl.mixinprocessor.transformers.AsmStaticUsageTransformer;
import us.runelitepl.mixinprocessor.transformers.DoNothingTransformer;
import us.runelitepl.mixinprocessor.transformers.GetFieldDecoderTransformer;
import us.runelitepl.mixinprocessor.transformers.ProvidedRemoverTransformer;

public class PatchGenerator
{
	
	private final String className;
	private final byte[] bytecode;
	
	public PatchGenerator(String className, byte[] bytecode)
	{
		this.className = className;
		this.bytecode = bytecode;
	}
	
	public byte[] run()
	{
		byte[] newCode = bytecode;
		
		newCode = new GetFieldDecoderTransformer(className, newCode).transform();
		// https://asm.ow2.io/javadoc/org/objectweb/asm/commons/Remapper.html
		// https://asm.ow2.io/javadoc/org/objectweb/asm/commons/ClassRemapper.html
		newCode = new AsmStaticUsageTransformer(className, newCode).transform();
		newCode = new AsmNameTransformer(className, newCode).transform();
		newCode = new ProvidedRemoverTransformer(className, newCode).transform();
		newCode = new AnnotationRemoverTransformer(className, newCode).transform();
		
		
		newCode = new DoNothingTransformer(className, newCode).transform();
		return newCode;
	}
	
}
