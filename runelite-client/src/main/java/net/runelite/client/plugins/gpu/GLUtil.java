/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import com.jogamp.opengl.GL4;
import java.io.InputStream;
import java.util.Scanner;

class GLUtil
{
	private static final int ERR_LEN = 1024;

	private static final int[] buf = new int[1];
	private static final float[] fbuf = new float[1];

	static int glGetInteger(GL4 gl)
	{
		gl.glGetIntegerv(com.jogamp.opengl.GL.GL_MAX_SAMPLES, buf, 0);
		return buf[0];
	}

	static float glGetFloat(GL4 gl)
	{
		gl.glGetFloatv(com.jogamp.opengl.GL.GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT, fbuf, 0);
		return fbuf[0];
	}

	private static int glGetShader(GL4 gl, int shader)
	{
		gl.glGetShaderiv(shader, com.jogamp.opengl.GL2ES2.GL_COMPILE_STATUS, buf, 0);
		assert buf[0] > -1;
		return buf[0];
	}

	private static int glGetProgram(GL4 gl, int program, int pname)
	{
		gl.glGetProgramiv(program, pname, buf, 0);
		assert buf[0] > -1;
		return buf[0];
	}

	private static String glGetShaderInfoLog(GL4 gl, int shader)
	{
		byte[] err = new byte[ERR_LEN];
		gl.glGetShaderInfoLog(shader, ERR_LEN, buf, 0, err, 0);
		return new String(err);
	}

	static String glGetProgramInfoLog(GL4 gl, int program)
	{
		byte[] err = new byte[ERR_LEN];
		gl.glGetProgramInfoLog(program, ERR_LEN, buf, 0, err, 0);
		return new String(err);
	}

	static int glGenVertexArrays(GL4 gl)
	{
		gl.glGenVertexArrays(1, buf, 0);
		return buf[0];
	}

	static void glDeleteVertexArrays(GL4 gl, int vertexArray)
	{
		buf[0] = vertexArray;
		gl.glDeleteVertexArrays(1, buf, 0);
	}

	static int glGenBuffers(GL4 gl)
	{
		gl.glGenBuffers(1, buf, 0);
		return buf[0];
	}

	static void glDeleteBuffer(GL4 gl, int buffer)
	{
		buf[0] = buffer;
		gl.glDeleteBuffers(1, buf, 0);
	}

	static int glGenTexture(GL4 gl)
	{
		gl.glGenTextures(1, buf, 0);
		return buf[0];
	}

	static void glDeleteTexture(GL4 gl, int texture)
	{
		buf[0] = texture;
		gl.glDeleteTextures(1, buf, 0);
	}

	static int glGenFrameBuffer(GL4 gl)
	{
		gl.glGenFramebuffers(1, buf, 0);
		return buf[0];
	}

	static void glDeleteFrameBuffer(GL4 gl, int frameBuffer)
	{
		buf[0] = frameBuffer;
		gl.glDeleteFramebuffers(1, buf, 0);
	}

	static int glGenRenderbuffer(GL4 gl)
	{
		gl.glGenRenderbuffers(1, buf, 0);
		return buf[0];
	}

	static void glDeleteRenderbuffers(GL4 gl, int renderBuffer)
	{
		buf[0] = renderBuffer;
		gl.glDeleteRenderbuffers(1, buf, 0);
	}

	static void loadShaders(GL4 gl, int glProgram, int glVertexShader, int glGeometryShader, int glFragmentShader,
							String vertexShaderStr, String geomShaderStr, String fragShaderStr) throws ShaderException
	{
		compileAndAttach(gl, glProgram, glVertexShader, vertexShaderStr);

		if (glGeometryShader != -1)
		{
			compileAndAttach(gl, glProgram, glGeometryShader, geomShaderStr);
		}

		compileAndAttach(gl, glProgram, glFragmentShader, fragShaderStr);

		gl.glLinkProgram(glProgram);

		if (glGetProgram(gl, glProgram, gl.GL_LINK_STATUS) == gl.GL_FALSE)
		{
			String err = glGetProgramInfoLog(gl, glProgram);
			throw new ShaderException(err);
		}

		gl.glValidateProgram(glProgram);

		if (glGetProgram(gl, glProgram, gl.GL_VALIDATE_STATUS) == gl.GL_FALSE)
		{
			String err = glGetProgramInfoLog(gl, glProgram);
			throw new ShaderException(err);
		}
	}

	static void loadComputeShader(GL4 gl, int glProgram, int glComputeShader, String str) throws ShaderException
	{
		compileAndAttach(gl, glProgram, glComputeShader, str);

		gl.glLinkProgram(glProgram);

		if (glGetProgram(gl, glProgram, gl.GL_LINK_STATUS) == gl.GL_FALSE)
		{
			String err = glGetProgramInfoLog(gl, glProgram);
			throw new ShaderException(err);
		}

		gl.glValidateProgram(glProgram);

		if (glGetProgram(gl, glProgram, gl.GL_VALIDATE_STATUS) == gl.GL_FALSE)
		{
			String err = glGetProgramInfoLog(gl, glProgram);
			throw new ShaderException(err);
		}
	}

	private static void compileAndAttach(GL4 gl, int program, int shader, String source) throws ShaderException
	{
		gl.glShaderSource(shader, 1, new String[]{source}, null);
		gl.glCompileShader(shader);

		if (glGetShader(gl, shader) == gl.GL_TRUE)
		{
			gl.glAttachShader(program, shader);
		}
		else
		{
			String err = glGetShaderInfoLog(gl, shader);
			throw new ShaderException(err);
		}
	}

	static String inputStreamToString(InputStream in)
	{
		Scanner scanner = new Scanner(in).useDelimiter("\\A");
		return scanner.next();
	}
}