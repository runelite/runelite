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
import com.jogamp.opengl.GL4;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.gpu.template.Template;

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

	public Shader()
	{
	}

	public Shader add(int type, String name)
	{
		units.add(new Unit(type, name));
		return this;
	}

	public int compile(GL4 gl, Template template) throws ShaderException
	{
		int program = gl.glCreateProgram();
		int[] shaders = new int[units.size()];
		int i = 0;
		boolean ok = false;
		try
		{
			while (i < shaders.length)
			{
				Unit unit = units.get(i);
				int shader = gl.glCreateShader(unit.type);
				String source = template.load(unit.filename);
				gl.glShaderSource(shader, 1, new String[]{source}, null);
				gl.glCompileShader(shader);

				if (GLUtil.glGetShader(gl, shader, gl.GL_COMPILE_STATUS) != gl.GL_TRUE)
				{
					String err = GLUtil.glGetShaderInfoLog(gl, shader);
					gl.glDeleteShader(shader);
					throw new ShaderException(err);
				}
				gl.glAttachShader(program, shader);
				shaders[i++] = shader;
			}

			gl.glLinkProgram(program);

			if (GLUtil.glGetProgram(gl, program, gl.GL_LINK_STATUS) == gl.GL_FALSE)
			{
				String err = GLUtil.glGetProgramInfoLog(gl, program);
				throw new ShaderException(err);
			}

			gl.glValidateProgram(program);

			if (GLUtil.glGetProgram(gl, program, gl.GL_VALIDATE_STATUS) == gl.GL_FALSE)
			{
				String err = GLUtil.glGetProgramInfoLog(gl, program);
				throw new ShaderException(err);
			}

			ok = true;
		}
		finally
		{
			while (i > 0)
			{
				int shader = shaders[--i];
				gl.glDetachShader(program, shader);
				gl.glDeleteShader(shader);
			}

			if (!ok)
			{
				gl.glDeleteProgram(program);
			}
		}

		return program;
	}
}
