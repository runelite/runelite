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
package net.runelite.modelviewer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import static org.lwjgl.opengl.GL20.GL_INFO_LOG_LENGTH;
import static org.lwjgl.opengl.GL20.glGetProgrami;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShaderManager
{
	private static final Logger logger = LoggerFactory.getLogger(ShaderManager.class);

	private static final int ERR_LEN = 1024;

	private int program;
	private int vertexShader;
	private int fragmentShader;

	public void load(InputStream vertexShaderStream, InputStream fragShaderStream) throws IOException
	{
		program = GL20.glCreateProgram();
		vertexShader = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
		fragmentShader = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);

		String vertexShaderStr = IOUtils.toString(new InputStreamReader(vertexShaderStream));
		String fragShaderStr = IOUtils.toString(new InputStreamReader(fragShaderStream));

		GL20.glShaderSource(vertexShader, vertexShaderStr);
		GL20.glCompileShader(vertexShader);

		if (GL20.glGetShader(vertexShader, GL20.GL_COMPILE_STATUS) == GL11.GL_TRUE)
		{
			GL20.glAttachShader(program, vertexShader);
		}
		else
		{
			String err = GL20.glGetShaderInfoLog(vertexShader, ERR_LEN);
			logger.warn("Error compiling vertex shader: {}", err);
		}

		GL20.glShaderSource(fragmentShader, fragShaderStr);
		GL20.glCompileShader(fragmentShader);

		if (GL20.glGetShader(fragmentShader, GL20.GL_COMPILE_STATUS) == GL11.GL_TRUE)
		{
			GL20.glAttachShader(program, fragmentShader);
		}
		else
		{
			String err = GL20.glGetShaderInfoLog(fragmentShader, ERR_LEN);
			logger.warn("Error compiling fragment shader: {}", err);
		}

		GL20.glLinkProgram(program);

		if (GL20.glGetProgram(program, GL20.GL_LINK_STATUS) == GL11.GL_FALSE)
		{
			String err = GL20.glGetProgramInfoLog(program, glGetProgrami(program, GL_INFO_LOG_LENGTH));
			logger.warn("Error linking program: {}", err);
		}

		GL20.glValidateProgram(program);
	}

	public void destroy()
	{
		GL20.glDeleteShader(vertexShader);
		GL20.glDeleteShader(fragmentShader);
		GL20.glDeleteProgram(program);
	}

	public void use()
	{
		GL20.glUseProgram(program);
	}

	void unuse()
	{
		GL20.glUseProgram(0);
	}

	public int getProgram()
	{
		return program;
	}

	public int getVertexShader()
	{
		return vertexShader;
	}

	public int getFragmentShader()
	{
		return fragmentShader;
	}
}
