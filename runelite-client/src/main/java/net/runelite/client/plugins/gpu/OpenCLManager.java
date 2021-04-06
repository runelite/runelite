/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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

import com.google.common.base.Charsets;
import com.jogamp.nativewindow.NativeSurface;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLContext;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import javax.inject.Singleton;
import jogamp.opengl.GLContextImpl;
import jogamp.opengl.GLDrawableImpl;
import jogamp.opengl.egl.EGLContext;
import jogamp.opengl.macosx.cgl.CGL;
import jogamp.opengl.windows.wgl.WindowsWGLContext;
import jogamp.opengl.x11.glx.X11GLXContext;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.gpu.template.Template;
import net.runelite.client.util.OSType;
import org.jocl.CL;
import static org.jocl.CL.*;
import org.jocl.CLException;
import org.jocl.Pointer;
import org.jocl.Sizeof;
import org.jocl.cl_command_queue;
import org.jocl.cl_context;
import org.jocl.cl_context_properties;
import org.jocl.cl_device_id;
import org.jocl.cl_event;
import org.jocl.cl_kernel;
import org.jocl.cl_mem;
import org.jocl.cl_platform_id;
import org.jocl.cl_program;

@Singleton
@Slf4j
class OpenCLManager
{
	private static final String GL_SHARING_PLATFORM_EXT = "cl_khr_gl_sharing";

	private static final String KERNEL_NAME_UNORDERED = "computeUnordered";
	private static final String KERNEL_NAME_LARGE = "computeLarge";

	private static final int MIN_WORK_GROUP_SIZE = 256;
	private static final int SMALL_SIZE = GpuPlugin.SMALL_TRIANGLE_COUNT;
	private static final int LARGE_SIZE = GpuPlugin.MAX_TRIANGLE;
	//  struct shared_data {
	//      int totalNum[12];
	//      int totalDistance[12];
	//      int totalMappedNum[18];
	//      int min10;
	//      int dfs[0];
	//  };
	private static final int SHARED_SIZE = 12 + 12 + 18 + 1; // in ints

	// The number of faces each worker processes in the two kernels
	private int largeFaceCount;
	private int smallFaceCount;

	private cl_platform_id platform;
	private cl_device_id device;
	cl_context context;
	private cl_command_queue commandQueue;

	private cl_program programUnordered;
	private cl_program programSmall;
	private cl_program programLarge;

	private cl_kernel kernelUnordered;
	private cl_kernel kernelSmall;
	private cl_kernel kernelLarge;

	void init(GL4 gl)
	{
		CL.setExceptionsEnabled(true);

		switch (OSType.getOSType())
		{
			case Windows:
			case Linux:
				initPlatform();
				initDevice();
				initContext(gl);
				break;
			case MacOS:
				initMacOS(gl);
				break;
			default:
				throw new RuntimeException("Unsupported OS Type " + OSType.getOSType().name());
		}
		ensureMinWorkGroupSize();
		initQueue();
		compilePrograms();
	}

	void cleanup()
	{
		if (programUnordered != null)
		{
			CL.clReleaseProgram(programUnordered);
			programUnordered = null;
		}

		if (programSmall != null)
		{
			CL.clReleaseProgram(programSmall);
			programSmall = null;
		}

		if (programLarge != null)
		{
			CL.clReleaseProgram(programLarge);
			programLarge = null;
		}

		if (kernelUnordered != null)
		{
			CL.clReleaseKernel(kernelUnordered);
			kernelUnordered = null;
		}

		if (kernelSmall != null)
		{
			CL.clReleaseKernel(kernelSmall);
			kernelSmall = null;
		}

		if (kernelLarge != null)
		{
			CL.clReleaseKernel(kernelLarge);
			kernelLarge = null;
		}

		if (commandQueue != null)
		{
			CL.clReleaseCommandQueue(commandQueue);
			commandQueue = null;
		}

		if (context != null)
		{
			CL.clReleaseContext(context);
			context = null;
		}

		if (device != null)
		{
			CL.clReleaseDevice(device);
			device = null;
		}
	}

	private String logPlatformInfo(cl_platform_id platform, int param)
	{
		long[] size = new long[1];
		clGetPlatformInfo(platform, param, 0, null, size);

		byte[] buffer = new byte[(int) size[0]];
		clGetPlatformInfo(platform, param, buffer.length, Pointer.to(buffer), null);
		String platformInfo = new String(buffer, Charsets.UTF_8);
		log.debug("Platform: {}, {}", stringFor_cl_platform_info(param), platformInfo);
		return platformInfo;
	}

	private void logBuildInfo(cl_program program, int param)
	{
		long[] size = new long[1];
		clGetProgramBuildInfo(program, device, param, 0, null, size);

		ByteBuffer buffer = ByteBuffer.allocateDirect((int) size[0]);
		clGetProgramBuildInfo(program, device, param, buffer.limit(), Pointer.toBuffer(buffer), null);

		switch (param)
		{
			case CL_PROGRAM_BUILD_STATUS:
				log.debug("Build status: {}, {}", stringFor_cl_program_build_info(param), stringFor_cl_build_status(buffer.getInt()));
				break;
			case CL_PROGRAM_BINARY_TYPE:
				log.debug("Binary type: {}, {}", stringFor_cl_program_build_info(param), stringFor_cl_program_binary_type(buffer.getInt()));
				break;
			case CL_PROGRAM_BUILD_LOG:
				String buildLog = StandardCharsets.US_ASCII.decode(buffer).toString();
				log.trace("Build log: {}, {}", stringFor_cl_program_build_info(param), buildLog);
				break;
			case CL_PROGRAM_BUILD_OPTIONS:
				String message = StandardCharsets.US_ASCII.decode(buffer).toString();
				log.debug("Build options: {}, {}", stringFor_cl_program_build_info(param), message);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	private void initPlatform()
	{
		int[] platformCount = new int[1];
		clGetPlatformIDs(0, null, platformCount);
		if (platformCount[0] == 0)
		{
			throw new RuntimeException("No compute platforms found");
		}

		cl_platform_id[] platforms = new cl_platform_id[platformCount[0]];
		clGetPlatformIDs(platforms.length, platforms, null);

		for (cl_platform_id platform : platforms)
		{
			log.debug("Found cl_platform_id {}", platform);
			logPlatformInfo(platform, CL_PLATFORM_PROFILE);
			logPlatformInfo(platform, CL_PLATFORM_VERSION);
			logPlatformInfo(platform, CL_PLATFORM_NAME);
			logPlatformInfo(platform, CL_PLATFORM_VENDOR);
			String[] extensions = logPlatformInfo(platform, CL_PLATFORM_EXTENSIONS).split(" ");
			if (Arrays.stream(extensions).noneMatch(s -> s.equals(GL_SHARING_PLATFORM_EXT)))
			{
				throw new RuntimeException("Platform does not support OpenGL buffer sharing");
			}
		}

		platform = platforms[0];
		log.debug("Selected cl_platform_id {}", platform);
	}

	private void initDevice()
	{
		int[] deviceCount = new int[1];
		clGetDeviceIDs(platform, CL_DEVICE_TYPE_GPU, 0, null, deviceCount);
		if (deviceCount[0] == 0)
		{
			throw new RuntimeException("No compute devices found");
		}

		cl_device_id[] devices = new cl_device_id[(int) deviceCount[0]];
		clGetDeviceIDs(platform, CL_DEVICE_TYPE_GPU, devices.length, devices, null);

		for (cl_device_id device : devices)
		{
			long[] size = new long[1];
			clGetDeviceInfo(device, CL_DEVICE_EXTENSIONS, 0, null, size);

			byte[] devInfoBuf = new byte[(int) size[0]];
			clGetDeviceInfo(device, CL_DEVICE_EXTENSIONS, devInfoBuf.length, Pointer.to(devInfoBuf), null);

			log.debug("Found cl_device_id: {}", device);
			log.debug("Device extensions: {}", new String(devInfoBuf, Charsets.UTF_8));
		}

		device = devices[0];
		log.debug("Selected cl_device_id {}", device);
	}

	private void initContext(GL4 gl)
	{
		// set computation platform
		cl_context_properties contextProps = new cl_context_properties();
		contextProps.addProperty(CL_CONTEXT_PLATFORM, platform);

		// pull gl context
		GLContext glContext = gl.getContext();
		log.debug("Got GLContext of type {}", glContext.getClass().getSimpleName());
		if (!glContext.isCurrent())
		{
			throw new RuntimeException("Can't create OpenCL context from inactive GL Context");
		}

		// get correct props based on os
		long glContextHandle = glContext.getHandle();
		GLContextImpl glContextImpl = (GLContextImpl) glContext;
		GLDrawableImpl glDrawableImpl = glContextImpl.getDrawableImpl();
		NativeSurface nativeSurface = glDrawableImpl.getNativeSurface();

		if (glContext instanceof X11GLXContext)
		{
			long displayHandle = nativeSurface.getDisplayHandle();
			contextProps.addProperty(CL_GL_CONTEXT_KHR, glContextHandle);
			contextProps.addProperty(CL_GLX_DISPLAY_KHR, displayHandle);
		}
		else if (glContext instanceof WindowsWGLContext)
		{
			long surfaceHandle = nativeSurface.getSurfaceHandle();
			contextProps.addProperty(CL_GL_CONTEXT_KHR, glContextHandle);
			contextProps.addProperty(CL_WGL_HDC_KHR, surfaceHandle);
		}
		else if (glContext instanceof EGLContext)
		{
			long displayHandle = nativeSurface.getDisplayHandle();
			contextProps.addProperty(CL_GL_CONTEXT_KHR, glContextHandle);
			contextProps.addProperty(CL_EGL_DISPLAY_KHR, displayHandle);
		}

		log.debug("Creating context with props: {}", contextProps);
		context = clCreateContext(contextProps, 1, new cl_device_id[]{device}, null, null, null);
		log.debug("Created compute context {}", context);
	}

	private void initMacOS(GL4 gl)
	{
		// get sharegroup from gl context
		GLContext glContext = gl.getContext();
		if (!glContext.isCurrent())
		{
			throw new RuntimeException("Can't create context from inactive GL");
		}
		long cglContext = CGL.CGLGetCurrentContext();
		long cglShareGroup = CGL.CGLGetShareGroup(cglContext);

		// build context props
		cl_context_properties contextProps = new cl_context_properties();
		contextProps.addProperty(CL_CONTEXT_PROPERTY_USE_CGL_SHAREGROUP_APPLE, cglShareGroup);

		// ask macos to make the context for us
		log.debug("Creating context with props: {}", contextProps);
		context = clCreateContext(contextProps, 0, null, null, null, null);

		// pull the compute device out of the provided context
		device = new cl_device_id();
		clGetGLContextInfoAPPLE(context, cglContext, CL_CGL_DEVICE_FOR_CURRENT_VIRTUAL_SCREEN_APPLE, Sizeof.cl_device_id, Pointer.to(device), null);

		log.debug("Got macOS CLGL compute device {}", device);
	}

	private void ensureMinWorkGroupSize()
	{
		long[] maxWorkGroupSize = new long[1];
		clGetDeviceInfo(device, CL_DEVICE_MAX_WORK_GROUP_SIZE, Sizeof.size_t, Pointer.to(maxWorkGroupSize), null);
		log.debug("Device CL_DEVICE_MAX_WORK_GROUP_SIZE: {}", maxWorkGroupSize[0]);

		if (maxWorkGroupSize[0] < MIN_WORK_GROUP_SIZE)
		{
			throw new RuntimeException("Compute device does not support min work group size " + MIN_WORK_GROUP_SIZE);
		}

		// Largest power of 2 less than or equal to maxWorkGroupSize
		int groupSize = 0x80000000 >>> Integer.numberOfLeadingZeros((int) maxWorkGroupSize[0]);
		largeFaceCount = LARGE_SIZE / (Math.min(groupSize, LARGE_SIZE));
		smallFaceCount = SMALL_SIZE / (Math.min(groupSize, SMALL_SIZE));

		log.debug("Face counts: small: {}, large: {}", smallFaceCount, largeFaceCount);
	}

	private void initQueue()
	{
		long[] l = new long[1];
		clGetDeviceInfo(device, CL_DEVICE_QUEUE_PROPERTIES, Sizeof.cl_long, Pointer.to(l), null);

		commandQueue = clCreateCommandQueue(context, device, l[0] & CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE, null);
		log.debug("Created command_queue {}, properties {}", commandQueue, l[0] & CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE);
	}

	private cl_program compileProgram(String programSource)
	{
		log.trace("Compiling program:\n {}", programSource);
		cl_program program = clCreateProgramWithSource(context, 1, new String[]{programSource}, null, null);

		try
		{
			clBuildProgram(program, 0, null, null, null, null);
		}
		catch (CLException e)
		{
			logBuildInfo(program, CL_PROGRAM_BUILD_LOG);
			throw e;
		}

		logBuildInfo(program, CL_PROGRAM_BUILD_STATUS);
		logBuildInfo(program, CL_PROGRAM_BINARY_TYPE);
		logBuildInfo(program, CL_PROGRAM_BUILD_OPTIONS);
		logBuildInfo(program, CL_PROGRAM_BUILD_LOG);
		return program;
	}

	private cl_kernel getKernel(cl_program program, String kernelName)
	{
		cl_kernel kernel = clCreateKernel(program, kernelName, null);
		log.debug("Loaded kernel {} for program {}", kernelName, program);
		return kernel;
	}

	private void compilePrograms()
	{
		Template templateSmall = new Template()
			.addInclude(OpenCLManager.class)
			.add(key -> key.equals("FACE_COUNT") ? ("#define FACE_COUNT " + smallFaceCount) : null);
		Template templateLarge = new Template()
			.addInclude(OpenCLManager.class)
			.add(key -> key.equals("FACE_COUNT") ? ("#define FACE_COUNT " + largeFaceCount) : null);

		String unordered = new Template()
			.addInclude(OpenCLManager.class)
			.load("comp_unordered.cl");
		String small = templateSmall.load("comp.cl");
		String large = templateLarge.load("comp.cl");

		programUnordered = compileProgram(unordered);
		programSmall = compileProgram(small);
		programLarge = compileProgram(large);

		kernelUnordered = getKernel(programUnordered, KERNEL_NAME_UNORDERED);
		kernelSmall = getKernel(programSmall, KERNEL_NAME_LARGE);
		kernelLarge = getKernel(programLarge, KERNEL_NAME_LARGE);
	}

	void compute(int unorderedModels, int smallModels, int largeModels,
		GLBuffer sceneVertexBuffer,
		GLBuffer sceneUvBuffer,
		GLBuffer vertexBuffer,
		GLBuffer uvBuffer,
		GLBuffer unorderedBuffer,
		GLBuffer smallBuffer,
		GLBuffer largeBuffer,
		GLBuffer outVertexBuffer,
		GLBuffer outUvBuffer,
		GLBuffer uniformBuffer
	)
	{
		cl_mem[] glBuffersAll = {
			sceneVertexBuffer.cl_mem,
			sceneUvBuffer.cl_mem,
			unorderedBuffer.cl_mem,
			smallBuffer.cl_mem,
			largeBuffer.cl_mem,
			vertexBuffer.cl_mem,
			uvBuffer.cl_mem,
			outVertexBuffer.cl_mem,
			outUvBuffer.cl_mem,
			uniformBuffer.cl_mem,
		};
		cl_mem[] glBuffers = Arrays.stream(glBuffersAll)
			.filter(Objects::nonNull)
			.toArray(cl_mem[]::new);

		cl_event acquireGLBuffers = new cl_event();
		clEnqueueAcquireGLObjects(commandQueue, glBuffers.length, glBuffers, 0, null, acquireGLBuffers);

		cl_event[] computeEvents = {
			new cl_event(),
			new cl_event(),
			new cl_event()
		};
		int numComputeEvents = 0;

		if (unorderedModels > 0)
		{
			clSetKernelArg(kernelUnordered, 0, Sizeof.cl_mem, unorderedBuffer.ptr());
			clSetKernelArg(kernelUnordered, 1, Sizeof.cl_mem, sceneVertexBuffer.ptr());
			clSetKernelArg(kernelUnordered, 2, Sizeof.cl_mem, vertexBuffer.ptr());
			clSetKernelArg(kernelUnordered, 3, Sizeof.cl_mem, sceneUvBuffer.ptr());
			clSetKernelArg(kernelUnordered, 4, Sizeof.cl_mem, uvBuffer.ptr());
			clSetKernelArg(kernelUnordered, 5, Sizeof.cl_mem, outVertexBuffer.ptr());
			clSetKernelArg(kernelUnordered, 6, Sizeof.cl_mem, outUvBuffer.ptr());

			// queue compute call after acquireGLBuffers
			clEnqueueNDRangeKernel(commandQueue, kernelUnordered, 1, null,
				new long[]{unorderedModels * 6L}, new long[]{6}, 1, new cl_event[]{acquireGLBuffers}, computeEvents[numComputeEvents++]);
		}

		if (smallModels > 0)
		{
			clSetKernelArg(kernelSmall, 0, (SHARED_SIZE + SMALL_SIZE) * Integer.BYTES, null);
			clSetKernelArg(kernelSmall, 1, Sizeof.cl_mem, smallBuffer.ptr());
			clSetKernelArg(kernelSmall, 2, Sizeof.cl_mem, sceneVertexBuffer.ptr());
			clSetKernelArg(kernelSmall, 3, Sizeof.cl_mem, vertexBuffer.ptr());
			clSetKernelArg(kernelSmall, 4, Sizeof.cl_mem, sceneUvBuffer.ptr());
			clSetKernelArg(kernelSmall, 5, Sizeof.cl_mem, uvBuffer.ptr());
			clSetKernelArg(kernelSmall, 6, Sizeof.cl_mem, outVertexBuffer.ptr());
			clSetKernelArg(kernelSmall, 7, Sizeof.cl_mem, outUvBuffer.ptr());
			clSetKernelArg(kernelSmall, 8, Sizeof.cl_mem, uniformBuffer.ptr());

			clEnqueueNDRangeKernel(commandQueue, kernelSmall, 1, null,
				new long[]{smallModels * (SMALL_SIZE / smallFaceCount)}, new long[]{SMALL_SIZE / smallFaceCount}, 1, new cl_event[]{acquireGLBuffers}, computeEvents[numComputeEvents++]);
		}

		if (largeModels > 0)
		{
			clSetKernelArg(kernelLarge, 0, (SHARED_SIZE + LARGE_SIZE) * Integer.BYTES, null);
			clSetKernelArg(kernelLarge, 1, Sizeof.cl_mem, largeBuffer.ptr());
			clSetKernelArg(kernelLarge, 2, Sizeof.cl_mem, sceneVertexBuffer.ptr());
			clSetKernelArg(kernelLarge, 3, Sizeof.cl_mem, vertexBuffer.ptr());
			clSetKernelArg(kernelLarge, 4, Sizeof.cl_mem, sceneUvBuffer.ptr());
			clSetKernelArg(kernelLarge, 5, Sizeof.cl_mem, uvBuffer.ptr());
			clSetKernelArg(kernelLarge, 6, Sizeof.cl_mem, outVertexBuffer.ptr());
			clSetKernelArg(kernelLarge, 7, Sizeof.cl_mem, outUvBuffer.ptr());
			clSetKernelArg(kernelLarge, 8, Sizeof.cl_mem, uniformBuffer.ptr());

			clEnqueueNDRangeKernel(commandQueue, kernelLarge, 1, null,
				new long[]{(long) largeModels * (LARGE_SIZE / largeFaceCount)}, new long[]{LARGE_SIZE / largeFaceCount}, 1, new cl_event[]{acquireGLBuffers}, computeEvents[numComputeEvents++]);
		}

		if (numComputeEvents == 0)
		{
			clEnqueueReleaseGLObjects(commandQueue, glBuffers.length, glBuffers, 0, null, null);
		}
		else
		{
			clEnqueueReleaseGLObjects(commandQueue, glBuffers.length, glBuffers, numComputeEvents, computeEvents, null);
		}
	}

	void finish()
	{
		clFinish(commandQueue);
	}
}