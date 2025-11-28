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
import net.runelite.api.Projection;
import net.runelite.api.Scene;
import static net.runelite.client.plugins.gpu.GpuPlugin.uniEntityTint;
import static net.runelite.client.plugins.gpu.GpuPlugin.updateEntityProjection;
import static org.lwjgl.opengl.GL33C.*;

class VAO
{
	// Temporary vertex format
	// index 0: vec3(x, y, z)
	// index 1: int abhsl
	// index 2: short vec4(id, x, y, z)
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

	int[] lengths = new int[4];
	Projection[] projs = new Projection[4];
	Scene[] scenes = new Scene[4];
	int off = 0;

	void addRange(Projection projection, Scene scene)
	{
		assert vbo.mapped;

		if (off > 0 && lengths[off - 1] == vbo.vb.position())
		{
			return;
		}

		if (lengths.length == off)
		{
			int l = lengths.length << 1;
			lengths = Arrays.copyOf(lengths, l);
			projs = Arrays.copyOf(projs, l);
			scenes = Arrays.copyOf(scenes, l);
		}

		lengths[off] = vbo.vb.position();
		projs[off] = projection;
		scenes[off] = scene;
		off++;
	}

	void draw()
	{
		assert !vbo.mapped;

		int start = 0;
		for (int i = 0; i < off; ++i)
		{
			int end = lengths[i];
			Projection p = projs[i];
			Scene scene = scenes[i];

			int count = end - start;

			updateEntityProjection(p);
			glUniform4i(uniEntityTint, scene.getOverrideHue(), scene.getOverrideSaturation(), scene.getOverrideLuminance(), scene.getOverrideAmount());
			glBindVertexArray(vao);
			glDrawArrays(GL_TRIANGLES, start / (VERT_SIZE / 4), count / (VAO.VERT_SIZE / 4));

			start = end;
		}
	}

	void reset()
	{
		Arrays.fill(projs, 0, off, null);
		Arrays.fill(scenes, 0, off, null);
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

	void addRange(Projection projection, Scene scene)
	{
		for (int i = 0; i <= curIdx && i < vaos.size(); ++i)
		{
			VAO vao = vaos.get(i);
			if (vao.vbo.mapped)
			{
				vao.addRange(projection, scene);
			}
		}
	}

	void debug()
	{
		log.debug("{} vaos allocated", vaos.size());
		for (VAO vao : vaos)
		{
			log.debug("vao {} mapped: {} num ranges: {} length: {}", vao, vao.vbo.mapped, vao.off, vao.vbo.mapped ? vao.vbo.vb.position() : -1);
			if (vao.off > 1)
			{
				for (int i = 0; i < vao.off; ++i)
				{
					log.debug("  {} {} {}", vao.lengths[i], vao.projs[i], vao.scenes[i]);
				}
			}
		}
	}
}