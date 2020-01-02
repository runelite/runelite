package net.runelite.client.plugins.gpu;

import com.jogamp.opengl.GL4;

import java.util.function.Function;

public interface GpuService
{
	Function<String, String> getResourceLoader();

	void initUniforms(GL4 gl, int glProgram);

	void setUniforms(GL4 gl);
}
