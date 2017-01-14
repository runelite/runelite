/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.injection;

import java.lang.reflect.Method;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Verifies the injected jar is valid
 *
 * @author Adam
 */
public class InjectorValidator
{
	private static final Logger logger = LoggerFactory.getLogger(InjectorValidator.class);

	private static final String API_PACKAGE_BASE = "net/runelite/rs/api/";

	private final ClassGroup group;

	private int missing, okay;

	public InjectorValidator(ClassGroup group)
	{
		this.group = group;
	}

	public void validate()
	{
		for (ClassFile cf : group.getClasses())
		{
			validate(cf);
		}

		logger.info("{} injected methods, {} missing", okay, missing);
	}

	private void validate(ClassFile cf)
	{
		// find methods of the interface not implemented in the class
		for (net.runelite.asm.pool.Class clazz : cf.getInterfaces().getInterfaces())
		{
			if (clazz.getName().startsWith(API_PACKAGE_BASE) == false)
			{
				continue;
			}

			Class<?> c;
			try
			{
				c = Class.forName(clazz.getName().replace('/', '.'));
			}
			catch (ClassNotFoundException ex)
			{
				logger.warn(null, ex);
				continue;
			}

			for (Method method : c.getMethods())
			{
				// could check method signature here too but it is
				// annoying to deal with both runelite api and java
				// reflection api
				if (cf.findMethod(method.getName()) == null)
				{
					logger.warn("Class {} implements interface {} but not does implement method {}",
						cf.getName(), c.getSimpleName(), method);
					++missing;
				}
				else
				{
					++okay;
				}
			}
		}
	}

	public int getMissing()
	{
		return missing;
	}

	public int getOkay()
	{
		return okay;
	}
}
