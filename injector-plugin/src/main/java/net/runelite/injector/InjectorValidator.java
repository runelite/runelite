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
package net.runelite.injector;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.signature.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Verifies the injected jar is valid
 *
 * @author Adam
 */
class InjectorValidator
{
	private static final Logger logger = LoggerFactory.getLogger(InjectorValidator.class);

	private static final String API_PACKAGE_BASE = "net/runelite/rs/api/";

	private final ClassGroup group;

	private int error, missing, okay;

	InjectorValidator(ClassGroup group)
	{
		this.group = group;
	}

	void validate()
	{
		for (ClassFile cf : group.getClasses())
		{
			validate(cf);
		}

		logger.info("{} overridden methods, {} missing", okay, missing);
	}

	private void validate(ClassFile cf)
	{
		// find methods of the interface not implemented in the class
		for (net.runelite.asm.pool.Class clazz : cf.getInterfaces().getInterfaces())
		{
			if (!clazz.getName().startsWith(API_PACKAGE_BASE))
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

			if (cf.isAbstract())
			{
				// Abstract classes don't have to implement anything
				continue;
			}

			for (Method method : c.getMethods())
			{
				if (method.isSynthetic() || method.isDefault())
				{
					continue;
				}

				// could check method signature here too but it is
				// annoying to deal with both runelite api and java
				// reflection api
				if (cf.findMethodDeep(method.getName()) == null)
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

		Set<NameAndSignature> signatures = new HashSet<>();

		for (net.runelite.asm.Method method : cf.getMethods())
		{
			NameAndSignature nas = new NameAndSignature(method.getName(), method.getDescriptor());

			if (signatures.contains(nas))
			{
				logger.error("Class {} has duplicate method with same name and signature {} {}",
					cf.getName(), method.getName(), method.getDescriptor());
				++error;
			}

			signatures.add(nas);
		}
	}

	int getError()
	{
		return error;
	}

	int getMissing()
	{
		return missing;
	}

	int getOkay()
	{
		return okay;
	}

	static final class NameAndSignature
	{
		String name;
		Signature signature;

		NameAndSignature(String name, Signature signature)
		{
			this.name = name;
			this.signature = signature;
		}

		@Override
		public int hashCode()
		{
			int hash = 3;
			hash = 67 * hash + Objects.hashCode(this.name);
			hash = 67 * hash + Objects.hashCode(this.signature);
			return hash;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			if (obj == null)
			{
				return false;
			}
			if (getClass() != obj.getClass())
			{
				return false;
			}
			final NameAndSignature other = (NameAndSignature) obj;
			if (!Objects.equals(this.name, other.name))
			{
				return false;
			}
			if (!Objects.equals(this.signature, other.signature))
			{
				return false;
			}
			return true;
		}
	}
}
