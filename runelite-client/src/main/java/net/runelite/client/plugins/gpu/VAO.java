/*
 * Copyright (c) 2025, Adam <Adam@sigterm.info>
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Renderable;
import net.runelite.api.Scene;
import static net.runelite.client.plugins.gpu.GpuPlugin.uniBase;
import static net.runelite.client.plugins.gpu.GpuPlugin.uniEntityProj;
import static net.runelite.client.plugins.gpu.GpuPlugin.uniEntityTint;
import static org.lwjgl.opengl.GL33C.*;

class VAO
{
	// Temporary vertex format
	// index 0: vec3(x, y, z)
	// index 1: int abhsl
	// index 2: short vec4(id, u, v, 0)
	static final int VERT_SIZE = 24;

	final VBO vbo;
	int vao;

	VAO(int size)
	{
		vbo = new VBO(size);
	}

	void init()
	{
		vao = glGenVertexArrays();
		glBindVertexArray(vao);

		vbo.init(GL_DYNAMIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, vbo.bufId);

		glEnableVertexAttribArray(0);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, VERT_SIZE, 0);

		glEnableVertexAttribArray(1);
		glVertexAttribIPointer(1, 1, GL_INT, VERT_SIZE, 12);

		glEnableVertexAttribArray(2);
		glVertexAttribIPointer(2, 4, GL_SHORT, VERT_SIZE, 16);

		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}

	void destroy()
	{
		vbo.destroy();
		glDeleteVertexArrays(vao);
		vao = 0;
	}

	static class Range
	{
		int endpos;
		float[] projection;
		byte h, s, l, a;
		byte renderMethod;
	}

	Range[] ranges = new Range[4];
	int off;

	{
		for (int i = 0; i < ranges.length; ++i)
		{
			ranges[i] = new Range();
		}
	}

	void addRange(float[] projection, Scene scene, int renderMode)
	{
		assert vbo.mapped;

		if (off > 0)
		{
			Range r = ranges[off - 1];
			int pos = vbo.vb.position();
			if (r.endpos == pos)
			{
				return;
			}

			if (projection == r.projection && renderMode == r.renderMethod)
			{
				assert pos > r.endpos;
				r.endpos = pos;
				return;
			}
		}

		if (ranges.length == off)
		{
			int l = ranges.length << 1;
			ranges = Arrays.copyOf(ranges, l);
			for (int i = ranges.length >> 1; i < ranges.length; ++i)
			{
				ranges[i] = new Range();
			}
		}

		Range r = ranges[off++];
		r.endpos = vbo.vb.position();
		r.projection = projection;
		r.h = scene.getOverrideHue();
		r.s = scene.getOverrideSaturation();
		r.l = scene.getOverrideLuminance();
		r.a = scene.getOverrideAmount();
		r.renderMethod = (byte) renderMode;
	}

	void draw()
	{
		assert !vbo.mapped;

		glUniform3i(uniBase, 0, 0, 0);

		int start = 0;
		for (int i = 0; i < off; ++i)
		{
			Range range = ranges[i];
			int end = range.endpos;

			int count = end - start;

			glUniformMatrix4fv(uniEntityProj, false, range.projection);
			glUniform4i(uniEntityTint, range.h, range.s, range.l, range.a);

			glBindVertexArray(vao);

			if (range.renderMethod == Renderable.RENDERMODE_SORTED_NO_DEPTH)
			{
				glDepthMask(false);
				glDrawArrays(GL_TRIANGLES, start / (VERT_SIZE / 4), count / (VERT_SIZE / 4));
				glDepthMask(true);

				glColorMask(false, false, false, false);
				glDrawArrays(GL_TRIANGLES, start / (VERT_SIZE / 4), count / (VERT_SIZE / 4));
				glColorMask(true, true, true, true);
			}
			else if (range.renderMethod == Renderable.RENDERMODE_UNSORTED_NO_DEPTH)
			{
				glDepthMask(false);
				glDrawArrays(GL_TRIANGLES, start / (VERT_SIZE / 4), count / (VERT_SIZE / 4));
				glDepthMask(true);
			}
			else
			{
				glDrawArrays(GL_TRIANGLES, start / (VERT_SIZE / 4), count / (VERT_SIZE / 4));
			}

			start = end;
		}
	}

	void reset()
	{
		for (int i = 0; i < off; ++i)
		{
			ranges[i].projection = null;
		}
		off = 0;
	}
}

@Slf4j
class VAOList
{
	// this needs to be larger than the largest single model
	private static final int VAO_SIZE = 4 * 1024 * 1024;

	private int curIdx;
	final List<VAO> vaos = new ArrayList<>();

	VAO get(int size)
	{
		assert size <= VAO_SIZE;

		while (curIdx < vaos.size())
		{
			VAO vao = vaos.get(curIdx);
			if (!vao.vbo.mapped)
			{
				vao.vbo.map();
			}

			int rem = vao.vbo.vb.remaining() * Integer.BYTES;
			if (size <= rem)
			{
				return vao;
			}

			curIdx++;
		}

		VAO vao = new VAO(VAO_SIZE);
		vao.init();
		vao.vbo.map();
		vaos.add(vao);
		log.debug("Allocated VAO {} request {}", vao.vao, size);
		return vao;
	}

	int unmap()
	{
		int sz = 0;
		for (int i = 0; i < vaos.size(); ++i) // NOPMD: ForLoopCanBeForeach
		{
			VAO vao = vaos.get(i);
			if (vao.vbo.mapped)
			{
				++sz;
				vao.vbo.unmap();
			}
		}
		curIdx = 0;
		return sz;
	}

	void free()
	{
		for (VAO vao : vaos)
		{
			vao.destroy();
		}
		vaos.clear();
		curIdx = 0;
	}

	void draw()
	{
		int sz = unmap();
		for (int i = 0; i < sz; ++i)
		{
			VAO vao = vaos.get(i);
			vao.draw();
			vao.reset();
		}
	}

	void debug()
	{
		log.debug("{} vaos allocated", vaos.size());
		for (VAO vao : vaos)
		{
			log.debug("vao {} mapped: {} num ranges: {} length: {}", vao, vao.vbo.mapped, vao.off, vao.vbo.mapped ? vao.vbo.vb.position() : -1);
			for (int i = 0; i < vao.off; ++i)
			{
				VAO.Range r = vao.ranges[i];
				log.debug("  endpos: {} proj: {} hsl: {},{},{},{} renderMethod: {}", r.endpos, r.projection, r.h, r.s, r.l, r.a, r.renderMethod);
			}
		}
	}
}