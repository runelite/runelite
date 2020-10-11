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
import java.nio.charset.StandardCharsets;

class GLUtil
{
	private static final int ERR_LEN = 1024;

	private static final int[] buf = new int[1];
	private static final float[] fbuf = new float[1];

	static int glGetInteger(GL4 gl, int pname)
	{
		gl.glGetIntegerv(pname, buf, 0);
		return buf[0];
	}

	static float glGetFloat(GL4 gl, int pname)
	{
		gl.glGetFloatv(pname, fbuf, 0);
		return fbuf[0];
	}

	static int glGetShader(GL4 gl, int shader, int pname)
	{
		gl.glGetShaderiv(shader, pname, buf, 0);
		assert buf[0] > -1;
		return buf[0];
	}

	static int glGetProgram(GL4 gl, int program, int pname)
	{
		gl.glGetProgramiv(program, pname, buf, 0);
		assert buf[0] > -1;
		return buf[0];
	}

	static String glGetShaderInfoLog(GL4 gl, int shader)
	{
		byte[] err = new byte[ERR_LEN];
		gl.glGetShaderInfoLog(shader, ERR_LEN, buf, 0, err, 0);
		return new String(err, 0, buf[0], StandardCharsets.UTF_8);
	}

	static String glGetProgramInfoLog(GL4 gl, int program)
	{
		byte[] err = new byte[ERR_LEN];
		gl.glGetProgramInfoLog(program, ERR_LEN, buf, 0, err, 0);
		return new String(err, 0, buf[0], StandardCharsets.UTF_8);
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
}
