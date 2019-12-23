package net.runelite.client.plugins.gpu;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GpuServiceImpl implements GpuService
{
	private final GpuPlugin gpuPlugin;

	@Inject
	public GpuServiceImpl(GpuPlugin gpuPlugin)
	{
		this.gpuPlugin = gpuPlugin;
	}

	@Override
	public void replaceProgram(String vertexShaderSource, String geomShaderSource, String fragShaderSource) throws ShaderException
	{
		gpuPlugin.replaceProgram(vertexShaderSource, geomShaderSource, fragShaderSource);
	}
}
