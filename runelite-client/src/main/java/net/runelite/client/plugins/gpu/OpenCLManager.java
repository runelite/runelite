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

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.gpu.template.Template;
import net.runelite.client.util.OSType;
import net.runelite.rlawt.AWTContext;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.APPLEGLSharing;
import static org.lwjgl.opencl.APPLEGLSharing.CL_CGL_DEVICE_FOR_CURRENT_VIRTUAL_SCREEN_APPLE;
import static org.lwjgl.opencl.APPLEGLSharing.clGetGLContextInfoAPPLE;
import org.lwjgl.opencl.CL;
import static org.lwjgl.opencl.CL10.CL_CONTEXT_PLATFORM;
import static org.lwjgl.opencl.CL10.CL_DEVICE_EXTENSIONS;
import static org.lwjgl.opencl.CL10.CL_DEVICE_NAME;
import static org.lwjgl.opencl.CL10.CL_DEVICE_PROFILE;
import static org.lwjgl.opencl.CL10.CL_DEVICE_VENDOR;
import static org.lwjgl.opencl.CL10.CL_DEVICE_VERSION;
import static org.lwjgl.opencl.CL10.CL_DRIVER_VERSION;
import static org.lwjgl.opencl.CL10.CL_PROGRAM_BUILD_LOG;
import static org.lwjgl.opencl.CL10.CL_PROGRAM_BUILD_OPTIONS;
import static org.lwjgl.opencl.CL10.CL_PROGRAM_BUILD_STATUS;
import static org.lwjgl.opencl.CL10.CL_SUCCESS;
import static org.lwjgl.opencl.CL10.clGetPlatformInfo;
import static org.lwjgl.opencl.CL10.clGetProgramBuildInfo;
import org.lwjgl.opencl.CL10GL;
import static org.lwjgl.opencl.CL11.CL_DEVICE_ADDRESS_BITS;
import static org.lwjgl.opencl.CL11.CL_DEVICE_AVAILABLE;
import static org.lwjgl.opencl.CL11.CL_DEVICE_COMPILER_AVAILABLE;
import static org.lwjgl.opencl.CL11.CL_DEVICE_MAX_CLOCK_FREQUENCY;
import static org.lwjgl.opencl.CL11.CL_DEVICE_MAX_COMPUTE_UNITS;
import static org.lwjgl.opencl.CL11.CL_DEVICE_MAX_WORK_GROUP_SIZE;
import static org.lwjgl.opencl.CL11.CL_DEVICE_MAX_WORK_ITEM_DIMENSIONS;
import static org.lwjgl.opencl.CL11.CL_DEVICE_QUEUE_PROPERTIES;
import static org.lwjgl.opencl.CL11.CL_DEVICE_TYPE;
import static org.lwjgl.opencl.CL11.CL_DEVICE_TYPE_GPU;
import static org.lwjgl.opencl.CL11.CL_DEVICE_VENDOR_ID;
import static org.lwjgl.opencl.CL11.CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE;
import static org.lwjgl.opencl.CL11.clCreateContext;
import static org.lwjgl.opencl.CL11.clGetDeviceIDs;
import static org.lwjgl.opencl.CL11.clGetDeviceInfo;
import static org.lwjgl.opencl.CL11.clGetPlatformIDs;
import org.lwjgl.opencl.CL12;
import static org.lwjgl.opencl.CL12.CL_PROGRAM_BINARY_TYPE;
import org.lwjgl.opencl.CLCapabilities;
import org.lwjgl.opencl.CLContextCallback;
import static org.lwjgl.opencl.KHRGLSharing.CL_GLX_DISPLAY_KHR;
import static org.lwjgl.opencl.KHRGLSharing.CL_GL_CONTEXT_KHR;
import static org.lwjgl.opencl.KHRGLSharing.CL_WGL_HDC_KHR;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryStack;
import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.system.MemoryUtil.memASCII;
import static org.lwjgl.system.MemoryUtil.memUTF8;

@Singleton
@Slf4j
class OpenCLManager
{
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
	//      int renderPris[0];
	//  };
	private static final int SHARED_SIZE = 12 + 12 + 18 + 1; // in ints

	private boolean initialized;

	// The number of faces each worker processes in the two kernels
	private int largeFaceCount;
	private int smallFaceCount;

	private long device = -1;
	long context;
	private long commandQueue;

	private long programUnordered;
	private long programSmall;
	private long programLarge;

	private long kernelUnordered;
	private long kernelSmall;
	private long kernelLarge;

	static
	{
		Configuration.OPENCL_EXPLICIT_INIT.set(true);
	}

	void init(AWTContext awtContext)
	{
		CL.create();
		initialized = true;

		try (var stack = MemoryStack.stackPush())
		{
			if (OSType.getOSType() == OSType.MacOS)
			{
				initContextMacOS(awtContext, stack);
			}
			else
			{
				initContext(awtContext, stack);
			}

			ensureMinWorkGroupSize();
			initQueue();
			compilePrograms(stack);
		}
	}

	void cleanup()
	{
		if (!initialized)
		{
			return;
		}

		try
		{
			CL12.clReleaseKernel(kernelUnordered);
			CL12.clReleaseKernel(kernelSmall);
			CL12.clReleaseKernel(kernelLarge);

			CL12.clReleaseProgram(programUnordered);
			CL12.clReleaseProgram(programSmall);
			CL12.clReleaseProgram(programLarge);

			CL12.clReleaseCommandQueue(commandQueue);

			CL12.clReleaseContext(context);

			CL12.clReleaseDevice(device);
		}
		finally
		{
			CL.destroy();
			initialized = false;
		}
	}

	private void initContext(AWTContext awtContext, MemoryStack stack)
	{
		IntBuffer pi = stack.mallocInt(1);
		checkCLError(clGetPlatformIDs(null, pi));
		if (pi.get(0) == 0)
		{
			throw new RuntimeException("No OpenCL platforms found.");
		}

		PointerBuffer platforms = stack.mallocPointer(pi.get(0));
		checkCLError(clGetPlatformIDs(platforms, (IntBuffer) null));

		PointerBuffer ctxProps = stack.mallocPointer(7);
		if (OSType.getOSType() == OSType.Windows)
		{
			ctxProps
				.put(CL_CONTEXT_PLATFORM)
				.put(0)
				.put(CL_GL_CONTEXT_KHR)
				.put(awtContext.getGLContext())
				.put(CL_WGL_HDC_KHR)
				.put(awtContext.getWGLHDC())
				.put(0)
				.flip();
		}
		else if (OSType.getOSType() == OSType.Linux)
		{
			ctxProps
				.put(CL_CONTEXT_PLATFORM)
				.put(0)
				.put(CL_GL_CONTEXT_KHR)
				.put(awtContext.getGLContext())
				.put(CL_GLX_DISPLAY_KHR)
				.put(awtContext.getGLXDisplay())
				.put(0)
				.flip();
		}
		else
		{
			throw new RuntimeException("unsupported platform");
		}

		for (int p = 0; p < platforms.capacity(); p++)
		{
			long platform = platforms.get(p);
			ctxProps.put(1, platform);

			try
			{
				CLCapabilities platformCaps = CL.createPlatformCapabilities(platform);

				log.debug("Platform profile: {}", getPlatformInfoStringUTF8(platform, CL12.CL_PLATFORM_PROFILE));
				log.debug("Platform version: {}", getPlatformInfoStringUTF8(platform, CL12.CL_PLATFORM_VERSION));
				log.debug("Platform name: {}", getPlatformInfoStringUTF8(platform, CL12.CL_PLATFORM_NAME));
				log.debug("Platform vendor: {}", getPlatformInfoStringUTF8(platform, CL12.CL_PLATFORM_VENDOR));
				log.debug("Platform extensions: {}", getPlatformInfoStringUTF8(platform, CL12.CL_PLATFORM_EXTENSIONS));

				checkCLError(clGetDeviceIDs(platform, CL_DEVICE_TYPE_GPU, null, pi));

				PointerBuffer devices = stack.mallocPointer(pi.get(0));
				checkCLError(clGetDeviceIDs(platform, CL_DEVICE_TYPE_GPU, devices, (IntBuffer) null));

				for (int d = 0; d < devices.capacity(); d++)
				{
					long device = devices.get(d);

					try
					{
						CLCapabilities deviceCaps = CL.createDeviceCapabilities(device, platformCaps);

						log.debug("Device id {}", device);
						log.debug("\tCL_DEVICE_NAME: {}", getDeviceInfoStringUTF8(device, CL_DEVICE_NAME));
						log.debug("\tCL_DEVICE_VENDOR: {}", getDeviceInfoStringUTF8(device, CL_DEVICE_VENDOR));
						log.debug("\tCL_DRIVER_VERSION: {}", getDeviceInfoStringUTF8(device, CL_DRIVER_VERSION));
						log.debug("\tCL_DEVICE_PROFILE: {}", getDeviceInfoStringUTF8(device, CL_DEVICE_PROFILE));
						log.debug("\tCL_DEVICE_VERSION: {}", getDeviceInfoStringUTF8(device, CL_DEVICE_VERSION));
						log.debug("\tCL_DEVICE_EXTENSIONS: {}", getDeviceInfoStringUTF8(device, CL_DEVICE_EXTENSIONS));
						log.debug("\tCL_DEVICE_TYPE: {}", getDeviceInfoLong(device, CL_DEVICE_TYPE));
						log.debug("\tCL_DEVICE_VENDOR_ID: {}", getDeviceInfoInt(device, CL_DEVICE_VENDOR_ID));
						log.debug("\tCL_DEVICE_MAX_COMPUTE_UNITS: {}", getDeviceInfoInt(device, CL_DEVICE_MAX_COMPUTE_UNITS));
						log.debug("\tCL_DEVICE_MAX_WORK_ITEM_DIMENSIONS: {}", getDeviceInfoInt(device, CL_DEVICE_MAX_WORK_ITEM_DIMENSIONS));
						log.debug("\tCL_DEVICE_MAX_WORK_GROUP_SIZE: {}", getDeviceInfoPointer(device, CL_DEVICE_MAX_WORK_GROUP_SIZE));
						log.debug("\tCL_DEVICE_MAX_CLOCK_FREQUENCY: {}", getDeviceInfoInt(device, CL_DEVICE_MAX_CLOCK_FREQUENCY));
						log.debug("\tCL_DEVICE_ADDRESS_BITS: {}", getDeviceInfoInt(device, CL_DEVICE_ADDRESS_BITS));
						log.debug("\tCL_DEVICE_AVAILABLE: {}", getDeviceInfoInt(device, CL_DEVICE_AVAILABLE) != 0);
						log.debug("\tCL_DEVICE_COMPILER_AVAILABLE: {}", getDeviceInfoInt(device, CL_DEVICE_COMPILER_AVAILABLE) != 0);

						if (!deviceCaps.cl_khr_gl_sharing && !deviceCaps.cl_APPLE_gl_sharing)
						{
							continue;
						}

						IntBuffer errcode_ret = stack.callocInt(1);
						long context = clCreateContext(ctxProps, device, CLContextCallback.create((errinfo, private_info, cb, user_data) ->
							log.error("[LWJGL] cl_context_callback: {}", memUTF8(errinfo))), NULL, errcode_ret);
						checkCLError(errcode_ret);

						this.device = device;
						this.context = context;
						return;
					}
					catch (Exception ex)
					{
						log.error("error checking device", ex);
					}
				}
			}
			catch (Exception ex)
			{
				log.error("error checking platform", ex);
			}
		}

		throw new RuntimeException("Unable to find compute platform");
	}

	private void initContextMacOS(AWTContext awtContext, MemoryStack stack)
	{
		PointerBuffer ctxProps = stack.mallocPointer(3);
		ctxProps
			.put(APPLEGLSharing.CL_CONTEXT_PROPERTY_USE_CGL_SHAREGROUP_APPLE)
			.put(awtContext.getCGLShareGroup())
			.put(0)
			.flip();

		IntBuffer errcode_ret = stack.callocInt(1);
		var devices = stack.mallocPointer(0);
		long context = clCreateContext(ctxProps, devices, CLContextCallback.create((errinfo, private_info, cb, user_data) ->
			log.error("[LWJGL] cl_context_callback: {}", memUTF8(errinfo))), NULL, errcode_ret);
		checkCLError(errcode_ret);

		var deviceBuf = stack.mallocPointer(1);
		checkCLError(clGetGLContextInfoAPPLE(context, awtContext.getGLContext(), CL_CGL_DEVICE_FOR_CURRENT_VIRTUAL_SCREEN_APPLE, deviceBuf, null));
		long device = deviceBuf.get(0);

		log.debug("Got macOS CLGL compute device {}", device);
		this.context = context;
		this.device = device;
	}

	private void ensureMinWorkGroupSize()
	{
		long[] maxWorkGroupSize = new long[1];
		CL12.clGetDeviceInfo(device, CL_DEVICE_MAX_WORK_GROUP_SIZE, maxWorkGroupSize, null);
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
		CL12.clGetDeviceInfo(device, CL_DEVICE_QUEUE_PROPERTIES, l, null);

		commandQueue = CL12.clCreateCommandQueue(context, device, l[0] & CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE, (int[]) null);
		log.debug("Created command_queue {}, properties {}", commandQueue, l[0] & CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE);
	}

	private long compileProgram(MemoryStack stack, String programSource)
	{
		log.trace("Compiling program:\n {}", programSource);
		IntBuffer errcode_ret = stack.callocInt(1);
		long program = CL12.clCreateProgramWithSource(context, programSource, errcode_ret);
		checkCLError(errcode_ret);

		int err = CL12.clBuildProgram(program, device, "", null, 0);
		if (err != CL_SUCCESS)
		{
			String errstr = getProgramBuildInfoStringASCII(program, device, CL_PROGRAM_BUILD_LOG);
			throw new RuntimeException(errstr);
		}

		log.debug("Build status: {}", getProgramBuildInfoInt(program, device, CL_PROGRAM_BUILD_STATUS));
		log.debug("Binary type: {}", getProgramBuildInfoInt(program, device, CL_PROGRAM_BINARY_TYPE));
		log.debug("Build options: {}", getProgramBuildInfoStringASCII(program, device, CL_PROGRAM_BUILD_OPTIONS));
		log.debug("Build log: {}", getProgramBuildInfoStringASCII(program, device, CL_PROGRAM_BUILD_LOG));
		return program;
	}

	private long getKernel(MemoryStack stack, long program, String kernelName)
	{
		IntBuffer errcode_ret = stack.callocInt(1);
		long kernel = CL12.clCreateKernel(program, kernelName, errcode_ret);
		checkCLError(errcode_ret);
		log.debug("Loaded kernel {} for program {}", kernelName, program);
		return kernel;
	}

	private void compilePrograms(MemoryStack stack)
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

		programUnordered = compileProgram(stack, unordered);
		programSmall = compileProgram(stack, small);
		programLarge = compileProgram(stack, large);

		kernelUnordered = getKernel(stack, programUnordered, KERNEL_NAME_UNORDERED);
		kernelSmall = getKernel(stack, programSmall, KERNEL_NAME_LARGE);
		kernelLarge = getKernel(stack, programLarge, KERNEL_NAME_LARGE);
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
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			PointerBuffer glBuffers = stack.mallocPointer(10);
			glBuffers.put(sceneVertexBuffer.clBuffer);
			glBuffers.put(sceneUvBuffer.clBuffer);
			glBuffers.put(unorderedBuffer.clBuffer);
			glBuffers.put(smallBuffer.clBuffer);
			glBuffers.put(largeBuffer.clBuffer);
			glBuffers.put(vertexBuffer.clBuffer);
			glBuffers.put(uvBuffer.clBuffer);
			glBuffers.put(outVertexBuffer.clBuffer);
			glBuffers.put(outUvBuffer.clBuffer);
			glBuffers.put(uniformBuffer.clBuffer);
			glBuffers.flip();

			PointerBuffer acquireEvent = stack.mallocPointer(1);
			CL10GL.clEnqueueAcquireGLObjects(commandQueue, glBuffers, null, acquireEvent);

			var computeEvents = stack.mallocPointer(3);
			if (unorderedModels > 0)
			{
				CL12.clSetKernelArg1p(kernelUnordered, 0, unorderedBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelUnordered, 1, sceneVertexBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelUnordered, 2, vertexBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelUnordered, 3, sceneUvBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelUnordered, 4, uvBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelUnordered, 5, outVertexBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelUnordered, 6, outUvBuffer.clBuffer);

				// queue compute call after acquireGLBuffers
				CL12.clEnqueueNDRangeKernel(commandQueue, kernelUnordered, 1, null,
					stack.pointers(unorderedModels * 6L), stack.pointers(6),
					acquireEvent, computeEvents);
				computeEvents.position(computeEvents.position() + 1);
			}

			if (smallModels > 0)
			{
				CL12.clSetKernelArg(kernelSmall, 0, (SHARED_SIZE + SMALL_SIZE) * Integer.BYTES);
				CL12.clSetKernelArg1p(kernelSmall, 1, smallBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelSmall, 2, sceneVertexBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelSmall, 3, vertexBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelSmall, 4, sceneUvBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelSmall, 5, uvBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelSmall, 6, outVertexBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelSmall, 7, outUvBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelSmall, 8, uniformBuffer.clBuffer);

				CL12.clEnqueueNDRangeKernel(commandQueue, kernelSmall, 1, null,
					stack.pointers(smallModels * (SMALL_SIZE / smallFaceCount)), stack.pointers(SMALL_SIZE / smallFaceCount),
					acquireEvent, computeEvents);
				computeEvents.position(computeEvents.position() + 1);
			}

			if (largeModels > 0)
			{
				CL12.clSetKernelArg(kernelLarge, 0, (SHARED_SIZE + LARGE_SIZE) * Integer.BYTES);
				CL12.clSetKernelArg1p(kernelLarge, 1, largeBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelLarge, 2, sceneVertexBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelLarge, 3, vertexBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelLarge, 4, sceneUvBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelLarge, 5, uvBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelLarge, 6, outVertexBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelLarge, 7, outUvBuffer.clBuffer);
				CL12.clSetKernelArg1p(kernelLarge, 8, uniformBuffer.clBuffer);

				CL12.clEnqueueNDRangeKernel(commandQueue, kernelLarge, 1, null,
					stack.pointers(largeModels * (LARGE_SIZE / largeFaceCount)), stack.pointers(LARGE_SIZE / largeFaceCount),
					acquireEvent, computeEvents);
				computeEvents.position(computeEvents.position() + 1);
			}

			if (computeEvents.position() == 0)
			{
				CL10GL.clEnqueueReleaseGLObjects(commandQueue, glBuffers, null, null);
			}
			else
			{
				computeEvents.flip();
				CL10GL.clEnqueueReleaseGLObjects(commandQueue, glBuffers, computeEvents, null);
			}
		}
	}

	void finish()
	{
		CL12.clFinish(commandQueue);
	}

	private static String getPlatformInfoStringUTF8(long cl_platform_id, int param_name)
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			PointerBuffer pp = stack.mallocPointer(1);
			checkCLError(clGetPlatformInfo(cl_platform_id, param_name, (ByteBuffer) null, pp));
			int bytes = (int) pp.get(0);

			ByteBuffer buffer = stack.malloc(bytes);
			checkCLError(clGetPlatformInfo(cl_platform_id, param_name, buffer, null));

			return memUTF8(buffer, bytes - 1);
		}
	}

	private static long getDeviceInfoLong(long cl_device_id, int param_name)
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			LongBuffer pl = stack.mallocLong(1);
			checkCLError(clGetDeviceInfo(cl_device_id, param_name, pl, null));
			return pl.get(0);
		}
	}

	private static int getDeviceInfoInt(long cl_device_id, int param_name)
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			IntBuffer pl = stack.mallocInt(1);
			checkCLError(clGetDeviceInfo(cl_device_id, param_name, pl, null));
			return pl.get(0);
		}
	}

	private static long getDeviceInfoPointer(long cl_device_id, int param_name)
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			PointerBuffer pp = stack.mallocPointer(1);
			checkCLError(clGetDeviceInfo(cl_device_id, param_name, pp, null));
			return pp.get(0);
		}
	}

	private static String getDeviceInfoStringUTF8(long cl_device_id, int param_name)
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			PointerBuffer pp = stack.mallocPointer(1);
			checkCLError(clGetDeviceInfo(cl_device_id, param_name, (ByteBuffer) null, pp));
			int bytes = (int) pp.get(0);

			ByteBuffer buffer = stack.malloc(bytes);
			checkCLError(clGetDeviceInfo(cl_device_id, param_name, buffer, null));

			return memUTF8(buffer, bytes - 1);
		}
	}

	private static int getProgramBuildInfoInt(long cl_program_id, long cl_device_id, int param_name)
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			IntBuffer pl = stack.mallocInt(1);
			checkCLError(clGetProgramBuildInfo(cl_program_id, cl_device_id, param_name, pl, null));
			return pl.get(0);
		}
	}

	private static String getProgramBuildInfoStringASCII(long cl_program_id, long cl_device_id, int param_name)
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			PointerBuffer pp = stack.mallocPointer(1);
			checkCLError(clGetProgramBuildInfo(cl_program_id, cl_device_id, param_name, (ByteBuffer) null, pp));
			int bytes = (int) pp.get(0);

			ByteBuffer buffer = stack.malloc(bytes);
			checkCLError(clGetProgramBuildInfo(cl_program_id, cl_device_id, param_name, buffer, null));

			return memASCII(buffer, bytes - 1);
		}
	}

	private static void checkCLError(IntBuffer errcode)
	{
		checkCLError(errcode.get(errcode.position()));
	}

	private static void checkCLError(int errcode)
	{
		if (errcode != CL_SUCCESS)
		{
			throw new RuntimeException(String.format("OpenCL error [%d]", errcode));
		}
	}
}