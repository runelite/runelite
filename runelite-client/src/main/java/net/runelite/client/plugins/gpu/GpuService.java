package net.runelite.client.plugins.gpu;

public interface GpuService
{
	void replaceProgram(String vertexShaderSource, String geomShaderSource, String fragShaderSource) throws ShaderException;
}
