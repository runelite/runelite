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

import com.jogamp.nativewindow.AbstractGraphicsConfiguration;
import com.jogamp.nativewindow.NativeWindowFactory;
import com.jogamp.nativewindow.awt.AWTGraphicsConfiguration;
import com.jogamp.nativewindow.awt.JAWTWindow;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.GLDrawable;
import com.jogamp.opengl.GLDrawableFactory;
import com.jogamp.opengl.GLProfile;
import java.awt.Canvas;
import java.util.function.Function;
import javax.swing.JFrame;
import static net.runelite.client.plugins.gpu.GLUtil.inputStreamToString;
import net.runelite.client.plugins.gpu.template.Template;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ShaderTest
{
	private static final String VERTEX_SHADER = "" +
		"void main() {" +
		"       gl_Position = vec4(1.0, 1.0, 1.0, 1.0);" +
		"}";
	private GL4 gl;

	@Before
	public void before()
	{
		Canvas canvas = new Canvas();
		JFrame frame = new JFrame();
		frame.setSize(100, 100);
		frame.add(canvas);
		frame.setVisible(true);

		GLProfile glProfile = GLProfile.getMaxFixedFunc(true);

		GLCapabilities glCaps = new GLCapabilities(glProfile);
		AbstractGraphicsConfiguration config = AWTGraphicsConfiguration.create(canvas.getGraphicsConfiguration(),
			glCaps, glCaps);

		JAWTWindow jawtWindow = (JAWTWindow) NativeWindowFactory.getNativeWindow(canvas, config);

		GLDrawableFactory glDrawableFactory = GLDrawableFactory.getFactory(glProfile);

		GLDrawable glDrawable = glDrawableFactory.createGLDrawable(jawtWindow);
		glDrawable.setRealized(true);


		GLContext glContext = glDrawable.createContext(null);
		int res = glContext.makeCurrent();
		if (res == GLContext.CONTEXT_NOT_CURRENT)
		{
			fail("error making context current");
		}

		gl = glContext.getGL().getGL4();
	}

	@Test
	@Ignore
	public void testUnordered() throws ShaderException
	{
		int glComputeProgram = gl.glCreateProgram();
		int glComputeShader = gl.glCreateShader(gl.GL_COMPUTE_SHADER);
		try
		{
			Function<String, String> func = (s) -> inputStreamToString(getClass().getResourceAsStream(s));
			Template template = new Template(func);
			String source = template.process(func.apply("comp_unordered.glsl"));

			int line = 0;
			for (String str : source.split("\\n"))
			{
				System.out.println(++line + " " + str);
			}

			GLUtil.loadComputeShader(gl, glComputeProgram, glComputeShader, source);
		}
		finally
		{
			gl.glDeleteShader(glComputeShader);
			gl.glDeleteProgram(glComputeProgram);
		}
	}

	@Test
	@Ignore
	public void testSmall() throws ShaderException
	{
		int glComputeProgram = gl.glCreateProgram();
		int glComputeShader = gl.glCreateShader(gl.GL_COMPUTE_SHADER);
		try
		{
			Function<String, String> func = (s) -> inputStreamToString(getClass().getResourceAsStream(s));
			Template template = new Template(func);
			String source = template.process(func.apply("comp_small.glsl"));

			int line = 0;
			for (String str : source.split("\\n"))
			{
				System.out.println(++line + " " + str);
			}

			GLUtil.loadComputeShader(gl, glComputeProgram, glComputeShader, source);
		}
		finally
		{
			gl.glDeleteShader(glComputeShader);
			gl.glDeleteProgram(glComputeProgram);
		}
	}

	@Test
	@Ignore
	public void testComp() throws ShaderException
	{
		int glComputeProgram = gl.glCreateProgram();
		int glComputeShader = gl.glCreateShader(gl.GL_COMPUTE_SHADER);
		try
		{
			Function<String, String> func = (s) -> inputStreamToString(getClass().getResourceAsStream(s));
			Template template = new Template(func);
			String source = template.process(func.apply("comp.glsl"));

			int line = 0;
			for (String str : source.split("\\n"))
			{
				System.out.println(++line + " " + str);
			}

			GLUtil.loadComputeShader(gl, glComputeProgram, glComputeShader, source);
		}
		finally
		{
			gl.glDeleteShader(glComputeShader);
			gl.glDeleteProgram(glComputeProgram);
		}
	}

	@Test
	@Ignore
	public void testGeom() throws ShaderException
	{
		int glComputeProgram = gl.glCreateProgram();
		int glVertexShader = gl.glCreateShader(gl.GL_VERTEX_SHADER);
		int glGeometryShader = gl.glCreateShader(gl.GL_GEOMETRY_SHADER);
		int glFragmentShader = gl.glCreateShader(gl.GL_FRAGMENT_SHADER);
		try
		{
			Function<String, String> func = (s) -> inputStreamToString(getClass().getResourceAsStream(s));
			Template template = new Template(func);
			String source = template.process(func.apply("geom.glsl"));

			int line = 0;
			for (String str : source.split("\\n"))
			{
				System.out.println(++line + " " + str);
			}

			GLUtil.loadShaders(gl, glComputeProgram, glVertexShader, glGeometryShader, glFragmentShader, VERTEX_SHADER, source, "");
		}
		finally
		{
			gl.glDeleteShader(glVertexShader);
			gl.glDeleteShader(glGeometryShader);
			gl.glDeleteShader(glFragmentShader);
			gl.glDeleteProgram(glComputeProgram);
		}
	}
}
