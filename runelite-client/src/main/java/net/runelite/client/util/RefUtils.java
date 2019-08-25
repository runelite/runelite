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

package net.runelite.client.util;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

class RefUtils implements Opcodes
{

	private static final String TYPE_PREFIX = "us/runelitepl/mixinprocessor/annotations/";

	private static boolean isReturn(int opcode, boolean checkType)
	{
		return (opcode == RETURN && !checkType) || opcode == IRETURN || opcode == LRETURN || opcode == DRETURN ||
			opcode == ARETURN || opcode == FRETURN;
	}

	public static boolean isReturn(int opcode)
	{
		return isReturn(opcode, false);
	}

	public static boolean checkAnnotation(MethodNode method, String annotation)
	{
		if (method.visibleAnnotations != null)
		{
			for (Object obj : method.visibleAnnotations)
			{
				if (((AnnotationNode) obj).desc.equals(makeAnnotationDesc(annotation)))
				{
					return true;
				}
			}
		}
		return false;
	}

	public static boolean checkAnnotation(FieldNode field, String annotation)
	{
		if (field.visibleAnnotations != null)
		{
			for (Object obj : field.visibleAnnotations)
			{
				if (((AnnotationNode) obj).desc.equals(makeAnnotationDesc(annotation)))
				{
					return true;
				}
			}
		}
		return false;
	}

	private static String makeAnnotationDesc(String annot)
	{
		return "L" + TYPE_PREFIX + annot + ";";
	}

}
