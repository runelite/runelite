/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2020 Abex
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
package net.runelite.client.plugins.gpu;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.gpu.template.Template;
import org.lwjgl.opengl.GL43C;

public class Shader
{
	@VisibleForTesting
	final List<Unit> units = new ArrayList<>();

	@RequiredArgsConstructor
	@VisibleForTesting
	static class Unit
	{
		@Getter
		private final int type;

		@Getter
		private final String filename;
	}

	public Shader add(int type, String name)
	{
		units.add(new Unit(type, name));
		return this;
	}

	public int compile(Template template) throws ShaderException
	{
		int program = GL43C.glCreateProgram();
		int[] shaders = new int[units.size()];
		int i = 0;
		boolean ok = false;
		try
		{
			while (i < shaders.length)
			{
				Unit unit = units.get(i);
				int shader = GL43C.glCreateShader(unit.type);
				if (shader == 0)
				{
					throw new ShaderException("Unable to create shader of type " + unit.type);
				}

				String source = template.load(unit.filename);
				GL43C.glShaderSource(shader, source);
				GL43C.glCompileShader(shader);

				if (GL43C.glGetShaderi(shader, GL43C.GL_COMPILE_STATUS) != GL43C.GL_TRUE)
				{
					String err = GL43C.glGetShaderInfoLog(shader);
					GL43C.glDeleteShader(shader);
					throw new ShaderException(err);
				}
				GL43C.glAttachShader(program, shader);
				shaders[i++] = shader;
			}

			GL43C.glLinkProgram(program);

			if (GL43C.glGetProgrami(program, GL43C.GL_LINK_STATUS) == GL43C.GL_FALSE)
			{
				String err = GL43C.glGetProgramInfoLog(program);
				throw new ShaderException(err);
			}

			GL43C.glValidateProgram(program);

			if (GL43C.glGetProgrami(program, GL43C.GL_VALIDATE_STATUS) == GL43C.GL_FALSE)
			{
				String err = GL43C.glGetProgramInfoLog(program);
				throw new ShaderException(err);
			}

			ok = true;
		}
		finally
		{
			while (i > 0)
			{
				int shader = shaders[--i];
				GL43C.glDetachShader(program, shader);
				GL43C.glDeleteShader(shader);
			}

			if (!ok)
			{
				GL43C.glDeleteProgram(program);
			}
		}

		return program;
	}
}
