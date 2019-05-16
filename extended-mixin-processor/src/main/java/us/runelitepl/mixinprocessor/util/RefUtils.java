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

package us.runelitepl.mixinprocessor.util;

import us.runelitepl.mixinprocessor.MixinProcessorMojo;

import java.util.Map;

public class RefUtils
{
	
	public static final String TYPE_PREFIX = "us/runelitepl/mixins/";
	public static final String STATICS_STRING = "_Statics_";
	public static final String[] POSSIBLE_GARBAGE_TYPES = {"I", "B", "S"};
	
	public static String deobClassName(String obbed)
	{
		for (Map.Entry<String, String> entry : MixinProcessorMojo.classNames.entrySet())
		{
			if (entry.getValue().equals(obbed))
			{
				return entry.getKey();
			}
		}
		return obbed;
	}
	
	public static String getObbedClassName(String deob)
	{
		return MixinProcessorMojo.classNames.getOrDefault(deob, deob);
	}
	
	public static String reobClassName(String deobbed)
	{
		String old = deobbed;
		if (deobbed.contains("/"))
		{
			deobbed = deobbed.replaceAll(TYPE_PREFIX, "");
			deobbed = getObbedClassName(deobbed);
			if (deobbed == null)
			{
				return old;
			}
		}
		return deobbed;
	}
	
	@Deprecated
	public static String reobFieldNameDangerous(String deob, String desc)
	{
		int i = 0;
		Map.Entry<String, String> e1 = null;
		for (Map.Entry<String, String> entry : MixinProcessorMojo.fieldNames.entrySet())
		{
			if (entry.getKey().endsWith(deob + " " + desc))
			{
				i++;
				e1 = entry;
			}
		}
		if (i == 1)
		{
			return e1.getValue();
		}
		return null;
	}
	
	@Deprecated
	public static String reobMethodNameDangerous(String deob, String signature)
	{
		int i = 0;
		Map.Entry<String, String> e1 = null;
		for (Map.Entry<String, String> entry : MixinProcessorMojo.methodNames.entrySet())
		{
			if (entry.getKey().endsWith(" " + deob + " " + signature))
			{
				i++;
				e1 = entry;
			}
		}
		if (i == 1)
		{
			return e1.getValue();
		}
		return null;
	}
	
	public static String reobFieldName(String owner, String deob, String desc)
	{
		if (owner.equals(RefUtils.STATICS_STRING))
		{
			return reobFieldNameDangerous(deob, desc);
		}
		String asd = MixinProcessorMojo.fieldNames.getOrDefault(owner + " " + deob + " " + desc, null);
		if (asd == null)
		{
			return null;
		}
		return asd.split(" ")[1];
	}
	
	public static String reobMethodName(String owner, String deob, String signature)
	{
		String prefix = "";
		if(owner.startsWith(RefUtils.TYPE_PREFIX))
		{
			owner = owner.substring(RefUtils.TYPE_PREFIX.length());
		}
		if (deob.startsWith("prepend$"))
		{
			prefix = "prepend$";
			deob = deob.substring("prepend$".length());
		}
		else if (deob.startsWith("append$"))
		{
			prefix = "append$";
			deob = deob.substring("append$".length());
		}
		if (owner.equals(RefUtils.STATICS_STRING))
		{
			String retVal = reobMethodNameDangerous(deob, signature);
			if (retVal == null)
			{
				return null;
			}
			String[] split = retVal.split(" ");
			split[1] = prefix + split[1];
			return String.join(" ", split);
		}
		String asd = MixinProcessorMojo.methodNames.getOrDefault(owner + " " + deob + " " + signature, null);
		if (asd == null)
		{
			return null;
		}
		return prefix + asd.split(" ")[1];
	}
	
	@Deprecated
	public static boolean shouldReobFieldDangerous(String deob, String desc)
	{
		int i = 0;
		for (Map.Entry<String, Boolean> entry : MixinProcessorMojo.isFieldTagged.entrySet())
		{
			if (entry.getKey().endsWith(deob + " " + desc))
			{
				i++;
			}
		}
		if (i == 1)
		{
			return true;
		}
		return false;
	}
	
	@Deprecated
	public static boolean shouldReobMethodDangerous(String deob, String desc)
	{
		int i = 0;
		for (Map.Entry<String, Boolean> entry : MixinProcessorMojo.isMethodTagged.entrySet())
		{
			if (entry.getKey().endsWith(" " + deob + " " + desc))
			{
				i++;
			}
		}
		if (i == 1)
		{
			return true;
		}
		return false;
	}
	
	public static boolean shouldReobField(String owner, String deob, String desc)
	{
		if (owner.equals(RefUtils.STATICS_STRING))
		{
			return shouldReobFieldDangerous(deob, desc);
		}
		return MixinProcessorMojo.isFieldTagged.getOrDefault(owner + " " + deob + " " + desc, false);
	}
	
	public static boolean shouldReobMethod(String owner, String deob, String desc)
	{
		if(owner.startsWith(RefUtils.TYPE_PREFIX))
		{
			owner = owner.substring(RefUtils.TYPE_PREFIX.length());
		}
		if (owner.equals(RefUtils.STATICS_STRING))
		{
			return shouldReobMethodDangerous(deob, desc);
		}
		return MixinProcessorMojo.isMethodTagged.getOrDefault(owner + " " + deob + " " + desc, false);
	}
	
	public static String reobDescriptor(String descriptor)
	{
		if (!descriptor.startsWith("L"))
		{
			return descriptor;
		}
		if (!descriptor.contains("us/runelitepl/mixins/"))
		{
			return descriptor;
		}
		String orig = descriptor;
		descriptor = descriptor.replace("us/runelitepl/mixins/", "");
		descriptor = descriptor.substring(1, descriptor.length() - 1);
		descriptor = getObbedClassName(descriptor);
		if (descriptor == null)
		{
			return orig;
		}
		return "L" + descriptor + ";";
	}
	
	public static String reobMethodDescriptor(String descriptor)
	{
		int strIndex = 0;
		if (descriptor.charAt(0) != '(')
		{
			throw new IllegalArgumentException("sig is not a method signature: " + descriptor);
		}
		StringBuilder deobbed = new StringBuilder(1024 * 1024);
		while (strIndex < descriptor.length())
		{
			switch (descriptor.charAt(strIndex))
			{
				case '(':
				case ')':
				case 'I':
				case 'B':
				case 'J':
				case 'S':
				case 'D':
				case 'F':
				case 'C':
				case 'Z':
				case 'V':
				case '[':
					deobbed.append(descriptor.charAt(strIndex));
					strIndex++;
					break;
				case 'L':
					try
					{
						String sigPart = descriptor.substring(strIndex, descriptor.indexOf(";", strIndex) + 1);
						String className = sigPart.substring(1, sigPart.length() - 1);
						className = className.replace(TYPE_PREFIX, "");
						String obbedName = MixinProcessorMojo.classNames.getOrDefault(className, null);
						if (obbedName == null)
						{
							obbedName = className;
						}
						deobbed.append("L" + obbedName + ";");
						strIndex += sigPart.length();
					}
					catch (StringIndexOutOfBoundsException ex)
					{
						System.err.println(
								"Method signature %s is probably missing a semi-colon".replace("%s", descriptor));
						throw ex;
					}
					break;
				default:
					throw new IllegalArgumentException("signature is invalid: " + descriptor);
			}
		}
		return deobbed.toString();
	}
	
	public static String appendArgument(String desc, String append)
	{
		int strIndex = 0;
		if (desc.charAt(0) != '(')
		{
			throw new IllegalArgumentException("sig is not a method signature: " + desc);
		}
		StringBuilder deobbed = new StringBuilder(1024 * 1024);
		while (strIndex < desc.length())
		{
			switch (desc.charAt(strIndex))
			{
				case ')':
					deobbed.append(append);
					deobbed.append(")");
					strIndex++;
					break;
				case '(':
				case 'I':
				case 'B':
				case 'J':
				case 'S':
				case 'D':
				case 'F':
				case 'C':
				case 'Z':
				case 'V':
				case '[':
					deobbed.append(desc.charAt(strIndex));
					strIndex++;
					break;
				case 'L':
					try
					{
						String sigPart = desc.substring(strIndex, desc.indexOf(";", strIndex) + 1);
						deobbed.append(sigPart);
						strIndex += sigPart.length();
					}
					catch (StringIndexOutOfBoundsException ex)
					{
						System.err.println(
								"Method signature %s is probably missing a semi-colon".replace("%s", desc));
						throw ex;
					}
					break;
				default:
					throw new IllegalArgumentException("signature is invalid: " + desc);
			}
		}
		return deobbed.toString();
	}
	
}
