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

import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import com.jogamp.nativewindow.awt.AWTGraphicsConfiguration;
import com.jogamp.nativewindow.awt.JAWTWindow;
import com.jogamp.opengl.GL;
import static com.jogamp.opengl.GL.GL_ARRAY_BUFFER;
import static com.jogamp.opengl.GL.GL_DYNAMIC_DRAW;
import static com.jogamp.opengl.GL2ES2.GL_STREAM_DRAW;
import static com.jogamp.opengl.GL2ES3.GL_STATIC_COPY;
import static com.jogamp.opengl.GL2ES3.GL_UNIFORM_BUFFER;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.GLDrawable;
import com.jogamp.opengl.GLDrawableFactory;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.GLFBODrawable;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.math.Matrix4;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import jogamp.nativewindow.SurfaceScaleUtils;
import jogamp.nativewindow.jawt.x11.X11JAWTWindow;
import jogamp.nativewindow.macosx.OSXUtil;
import jogamp.newt.awt.NewtFactoryAWT;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.BufferProvider;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Model;
import net.runelite.api.NodeCache;
import net.runelite.api.Perspective;
import net.runelite.api.Renderable;
import net.runelite.api.Scene;
import net.runelite.api.SceneTileModel;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Texture;
import net.runelite.api.TextureProvider;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import static net.runelite.client.plugins.gpu.GLUtil.glDeleteBuffer;
import static net.runelite.client.plugins.gpu.GLUtil.glDeleteFrameBuffer;
import static net.runelite.client.plugins.gpu.GLUtil.glDeleteRenderbuffers;
import static net.runelite.client.plugins.gpu.GLUtil.glDeleteTexture;
import static net.runelite.client.plugins.gpu.GLUtil.glDeleteVertexArrays;
import static net.runelite.client.plugins.gpu.GLUtil.glGenBuffers;
import static net.runelite.client.plugins.gpu.GLUtil.glGenFrameBuffer;
import static net.runelite.client.plugins.gpu.GLUtil.glGenRenderbuffer;
import static net.runelite.client.plugins.gpu.GLUtil.glGenTexture;
import static net.runelite.client.plugins.gpu.GLUtil.glGenVertexArrays;
import static net.runelite.client.plugins.gpu.GLUtil.glGetInteger;
import net.runelite.client.plugins.gpu.config.AntiAliasingMode;
import net.runelite.client.plugins.gpu.config.UIScalingMode;
import net.runelite.client.plugins.gpu.template.Template;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.util.OSType;
import org.jocl.CL;
import static org.jocl.CL.CL_MEM_READ_ONLY;
import static org.jocl.CL.CL_MEM_WRITE_ONLY;
import static org.jocl.CL.clCreateFromGLBuffer;

@PluginDescriptor(
	name = "GPU",
	description = "Utilizes the GPU",
	enabledByDefault = false,
	tags = {"fog", "draw distance"},
	loadInSafeMode = false
)
@Slf4j
public class GpuPlugin extends Plugin implements DrawCallbacks
{
	// This is the maximum number of triangles the compute shaders support
	static final int MAX_TRIANGLE = 4096;
	static final int SMALL_TRIANGLE_COUNT = 512;
	private static final int FLAG_SCENE_BUFFER = Integer.MIN_VALUE;
	private static final int DEFAULT_DISTANCE = 25;
	static final int MAX_DISTANCE = 90;
	static final int MAX_FOG_DEPTH = 100;

	@Inject
	private Client client;

	@Inject
	private OpenCLManager openCLManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private GpuPluginConfig config;

	@Inject
	private TextureManager textureManager;

	@Inject
	private SceneUploader sceneUploader;

	@Inject
	private DrawManager drawManager;

	@Inject
	private PluginManager pluginManager;

	enum ComputeMode
	{
		NONE,
		OPENGL,
		OPENCL
	}

	private ComputeMode computeMode = ComputeMode.NONE;

	private Canvas canvas;
	private JAWTWindow jawtWindow;
	private GL4 gl;
	private GLContext glContext;
	private GLDrawable glDrawable;

	static final String LINUX_VERSION_HEADER =
		"#version 420\n" +
			"#extension GL_ARB_compute_shader : require\n" +
			"#extension GL_ARB_shader_storage_buffer_object : require\n" +
			"#extension GL_ARB_explicit_attrib_location : require\n";
	static final String WINDOWS_VERSION_HEADER = "#version 430\n";

	static final Shader PROGRAM = new Shader()
		.add(GL4.GL_VERTEX_SHADER, "vert.glsl")
		.add(GL4.GL_FRAGMENT_SHADER, "frag.glsl");

	static final Shader COMPUTE_PROGRAM = new Shader()
		.add(GL4.GL_COMPUTE_SHADER, "comp.glsl");

	static final Shader SMALL_COMPUTE_PROGRAM = new Shader()
		.add(GL4.GL_COMPUTE_SHADER, "comp_small.glsl");

	static final Shader UNORDERED_COMPUTE_PROGRAM = new Shader()
		.add(GL4.GL_COMPUTE_SHADER, "comp_unordered.glsl");

	static final Shader UI_PROGRAM = new Shader()
		.add(GL4.GL_VERTEX_SHADER, "vertui.glsl")
		.add(GL4.GL_FRAGMENT_SHADER, "fragui.glsl");

	private int glProgram;
	private int glComputeProgram;
	private int glSmallComputeProgram;
	private int glUnorderedComputeProgram;
	private int glUiProgram;

	private int vaoHandle;

	private int interfaceTexture;

	private int vaoUiHandle;
	private int vboUiHandle;

	private int fboSceneHandle;
	private int texSceneHandle;
	private int rboSceneHandle;

	// scene vertex buffer
	private final GLBuffer sceneVertexBuffer = new GLBuffer();
	// scene uv buffer
	private final GLBuffer sceneUvBuffer = new GLBuffer();

	private final GLBuffer tmpVertexBuffer = new GLBuffer(); // temporary scene vertex buffer
	private final GLBuffer tmpUvBuffer = new GLBuffer(); // temporary scene uv buffer
	private final GLBuffer tmpModelBufferLarge = new GLBuffer(); // scene model buffer, large
	private final GLBuffer tmpModelBufferSmall = new GLBuffer(); // scene model buffer, small
	private final GLBuffer tmpModelBufferUnordered = new GLBuffer(); // scene model buffer, unordered
	private final GLBuffer tmpOutBuffer = new GLBuffer(); // target vertex buffer for compute shaders
	private final GLBuffer tmpOutUvBuffer = new GLBuffer(); // target uv buffer for compute shaders

	private int textureArrayId;

	private final GLBuffer uniformBuffer = new GLBuffer();
	private final float[] textureOffsets = new float[128];

	private GpuIntBuffer vertexBuffer;
	private GpuFloatBuffer uvBuffer;

	private GpuIntBuffer modelBufferUnordered;
	private GpuIntBuffer modelBufferSmall;
	private GpuIntBuffer modelBuffer;

	private int unorderedModels;

	/**
	 * number of models in small buffer
	 */
	private int smallModels;

	/**
	 * number of models in large buffer
	 */
	private int largeModels;

	/**
	 * offset in the target buffer for model
	 */
	private int targetBufferOffset;

	/**
	 * offset into the temporary scene vertex buffer
	 */
	private int tempOffset;

	/**
	 * offset into the temporary scene uv buffer
	 */
	private int tempUvOffset;

	private int lastCanvasWidth;
	private int lastCanvasHeight;
	private int lastStretchedCanvasWidth;
	private int lastStretchedCanvasHeight;
	private AntiAliasingMode lastAntiAliasingMode;
	private int lastAnisotropicFilteringLevel = -1;

	private int yaw;
	private int pitch;
	// fields for non-compute draw
	private boolean drawingModel;
	private int modelX, modelY, modelZ;
	private int modelOrientation;

	// Uniforms
	private int uniColorBlindMode;
	private int uniUiColorBlindMode;
	private int uniUseFog;
	private int uniFogColor;
	private int uniFogDepth;
	private int uniDrawDistance;
	private int uniProjectionMatrix;
	private int uniBrightness;
	private int uniTex;
	private int uniTexSamplingMode;
	private int uniTexSourceDimensions;
	private int uniTexTargetDimensions;
	private int uniUiAlphaOverlay;
	private int uniTextures;
	private int uniTextureOffsets;
	private int uniBlockSmall;
	private int uniBlockLarge;
	private int uniBlockMain;
	private int uniSmoothBanding;
	private int uniTextureLightMode;

	@Override
	protected void startUp()
	{
		clientThread.invoke(() ->
		{
			try
			{
				texSceneHandle = fboSceneHandle = rboSceneHandle = -1; // AA FBO
				unorderedModels = smallModels = largeModels = 0;
				drawingModel = false;

				canvas = client.getCanvas();

				if (!canvas.isDisplayable())
				{
					return false;
				}

				computeMode = config.useComputeShaders()
					? (OSType.getOSType() == OSType.MacOS ? ComputeMode.OPENCL : ComputeMode.OPENGL)
					: ComputeMode.NONE;

				canvas.setIgnoreRepaint(true);

				vertexBuffer = new GpuIntBuffer();
				uvBuffer = new GpuFloatBuffer();

				modelBufferUnordered = new GpuIntBuffer();
				modelBufferSmall = new GpuIntBuffer();
				modelBuffer = new GpuIntBuffer();

				if (log.isDebugEnabled())
				{
					System.setProperty("jogl.debug", "true");
				}

				GLProfile.initSingleton();

				invokeOnMainThread(() ->
				{
					GLProfile glProfile = GLProfile.get(GLProfile.GL4);

					GLCapabilities glCaps = new GLCapabilities(glProfile);
					AWTGraphicsConfiguration config = AWTGraphicsConfiguration.create(canvas.getGraphicsConfiguration(), glCaps, glCaps);

					jawtWindow = NewtFactoryAWT.getNativeWindow(canvas, config);
					canvas.setFocusable(true);

					GLDrawableFactory glDrawableFactory = GLDrawableFactory.getFactory(glProfile);

					jawtWindow.lockSurface();
					try
					{
						glDrawable = glDrawableFactory.createGLDrawable(jawtWindow);
						glDrawable.setRealized(true);

						glContext = glDrawable.createContext(null);
						if (log.isDebugEnabled())
						{
							// Debug config on context needs to be set before .makeCurrent call
							glContext.enableGLDebugMessage(true);
						}
					}
					finally
					{
						jawtWindow.unlockSurface();
					}

					int res = glContext.makeCurrent();
					if (res == GLContext.CONTEXT_NOT_CURRENT)
					{
						throw new GLException("Unable to make context current");
					}

					// Surface needs to be unlocked on X11 window otherwise input is blocked
					if (jawtWindow instanceof X11JAWTWindow && jawtWindow.getLock().isLocked())
					{
						jawtWindow.unlockSurface();
					}

					this.gl = glContext.getGL().getGL4();
					gl.setSwapInterval(0);

					if (log.isDebugEnabled())
					{
						gl.glEnable(gl.GL_DEBUG_OUTPUT);

						// Suppress warning messages which flood the log on NVIDIA systems.
						gl.getContext().glDebugMessageControl(gl.GL_DEBUG_SOURCE_API, gl.GL_DEBUG_TYPE_OTHER,
							gl.GL_DEBUG_SEVERITY_NOTIFICATION, 0, null, 0, false);
					}

					initVao();
					try
					{
						initProgram();
					}
					catch (ShaderException ex)
					{
						throw new RuntimeException(ex);
					}
					initInterfaceTexture();
					initUniformBuffer();
					initBuffers();
				});

				client.setDrawCallbacks(this);
				client.setGpu(true);

				// force rebuild of main buffer provider to enable alpha channel
				client.resizeCanvas();

				lastCanvasWidth = lastCanvasHeight = -1;
				lastStretchedCanvasWidth = lastStretchedCanvasHeight = -1;
				lastAntiAliasingMode = null;

				textureArrayId = -1;

				// increase size of model cache for dynamic objects since we are extending scene size
				NodeCache cachedModels2 = client.getCachedModels2();
				cachedModels2.setCapacity(256);
				cachedModels2.setRemainingCapacity(256);
				cachedModels2.reset();

				if (client.getGameState() == GameState.LOGGED_IN)
				{
					invokeOnMainThread(this::uploadScene);
				}
			}
			catch (Throwable e)
			{
				log.error("Error starting GPU plugin", e);

				SwingUtilities.invokeLater(() ->
				{
					try
					{
						pluginManager.setPluginEnabled(this, false);
						pluginManager.stopPlugin(this);
					}
					catch (PluginInstantiationException ex)
					{
						log.error("error stopping plugin", ex);
					}
				});

				shutDown();
			}
			return true;
		});
	}

	@Override
	protected void shutDown()
	{
		clientThread.invoke(() ->
		{
			client.setGpu(false);
			client.setDrawCallbacks(null);

			invokeOnMainThread(() ->
			{
				openCLManager.cleanup();

				if (gl != null)
				{
					if (textureArrayId != -1)
					{
						textureManager.freeTextureArray(gl, textureArrayId);
						textureArrayId = -1;
					}

					destroyGlBuffer(uniformBuffer);

					shutdownBuffers();
					shutdownInterfaceTexture();
					shutdownProgram();
					shutdownVao();
					shutdownAAFbo();
				}

				if (jawtWindow != null)
				{
					if (!jawtWindow.getLock().isLocked())
					{
						jawtWindow.lockSurface();
					}

					if (glContext != null)
					{
						glContext.destroy();
					}

					// this crashes on osx when the plugin is turned back on, don't know why
					// we'll just leak the window...
					if (OSType.getOSType() != OSType.MacOS)
					{
						NewtFactoryAWT.destroyNativeWindow(jawtWindow);
					}
				}
			});

			GLProfile.shutdown();

			jawtWindow = null;
			gl = null;
			glDrawable = null;
			glContext = null;

			vertexBuffer = null;
			uvBuffer = null;

			modelBufferSmall = null;
			modelBuffer = null;
			modelBufferUnordered = null;

			lastAnisotropicFilteringLevel = -1;

			// force main buffer provider rebuild to turn off alpha channel
			client.resizeCanvas();
		});
	}

	@Provides
	GpuPluginConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GpuPluginConfig.class);
	}

	private void initProgram() throws ShaderException
	{
		String versionHeader = OSType.getOSType() == OSType.Linux ? LINUX_VERSION_HEADER : WINDOWS_VERSION_HEADER;
		Template template = new Template();
		template.add(key ->
		{
			if ("version_header".equals(key))
			{
				return versionHeader;
			}
			return null;
		});
		template.addInclude(GpuPlugin.class);

		glProgram = PROGRAM.compile(gl, template);
		glUiProgram = UI_PROGRAM.compile(gl, template);

		if (computeMode == ComputeMode.OPENGL)
		{
			glComputeProgram = COMPUTE_PROGRAM.compile(gl, template);
			glSmallComputeProgram = SMALL_COMPUTE_PROGRAM.compile(gl, template);
			glUnorderedComputeProgram = UNORDERED_COMPUTE_PROGRAM.compile(gl, template);
		}
		else if (computeMode == ComputeMode.OPENCL)
		{
			openCLManager.init(gl);
		}

		initUniforms();
	}

	private void initUniforms()
	{
		uniProjectionMatrix = gl.glGetUniformLocation(glProgram, "projectionMatrix");
		uniBrightness = gl.glGetUniformLocation(glProgram, "brightness");
		uniSmoothBanding = gl.glGetUniformLocation(glProgram, "smoothBanding");
		uniUseFog = gl.glGetUniformLocation(glProgram, "useFog");
		uniFogColor = gl.glGetUniformLocation(glProgram, "fogColor");
		uniFogDepth = gl.glGetUniformLocation(glProgram, "fogDepth");
		uniDrawDistance = gl.glGetUniformLocation(glProgram, "drawDistance");
		uniColorBlindMode = gl.glGetUniformLocation(glProgram, "colorBlindMode");
		uniTextureLightMode = gl.glGetUniformLocation(glProgram, "textureLightMode");

		uniTex = gl.glGetUniformLocation(glUiProgram, "tex");
		uniTexSamplingMode = gl.glGetUniformLocation(glUiProgram, "samplingMode");
		uniTexTargetDimensions = gl.glGetUniformLocation(glUiProgram, "targetDimensions");
		uniTexSourceDimensions = gl.glGetUniformLocation(glUiProgram, "sourceDimensions");
		uniUiColorBlindMode = gl.glGetUniformLocation(glUiProgram, "colorBlindMode");
		uniUiAlphaOverlay = gl.glGetUniformLocation(glUiProgram, "alphaOverlay");
		uniTextures = gl.glGetUniformLocation(glProgram, "textures");
		uniTextureOffsets = gl.glGetUniformLocation(glProgram, "textureOffsets");

		uniBlockSmall = gl.glGetUniformBlockIndex(glSmallComputeProgram, "uniforms");
		uniBlockLarge = gl.glGetUniformBlockIndex(glComputeProgram, "uniforms");
		uniBlockMain = gl.glGetUniformBlockIndex(glProgram, "uniforms");
	}

	private void shutdownProgram()
	{
		gl.glDeleteProgram(glProgram);
		glProgram = -1;

		gl.glDeleteProgram(glComputeProgram);
		glComputeProgram = -1;

		gl.glDeleteProgram(glSmallComputeProgram);
		glSmallComputeProgram = -1;

		gl.glDeleteProgram(glUnorderedComputeProgram);
		glUnorderedComputeProgram = -1;

		gl.glDeleteProgram(glUiProgram);
		glUiProgram = -1;
	}

	private void initVao()
	{
		// Create VAO
		vaoHandle = glGenVertexArrays(gl);

		// Create UI VAO
		vaoUiHandle = glGenVertexArrays(gl);
		// Create UI buffer
		vboUiHandle = glGenBuffers(gl);
		gl.glBindVertexArray(vaoUiHandle);

		FloatBuffer vboUiBuf = GpuFloatBuffer.allocateDirect(5 * 4);
		vboUiBuf.put(new float[]{
			// positions     // texture coords
			1f, 1f, 0.0f, 1.0f, 0f, // top right
			1f, -1f, 0.0f, 1.0f, 1f, // bottom right
			-1f, -1f, 0.0f, 0.0f, 1f, // bottom left
			-1f, 1f, 0.0f, 0.0f, 0f  // top left
		});
		vboUiBuf.rewind();
		gl.glBindBuffer(GL_ARRAY_BUFFER, vboUiHandle);
		gl.glBufferData(GL_ARRAY_BUFFER, vboUiBuf.capacity() * Float.BYTES, vboUiBuf, gl.GL_STATIC_DRAW);

		// position attribute
		gl.glVertexAttribPointer(0, 3, gl.GL_FLOAT, false, 5 * Float.BYTES, 0);
		gl.glEnableVertexAttribArray(0);

		// texture coord attribute
		gl.glVertexAttribPointer(1, 2, gl.GL_FLOAT, false, 5 * Float.BYTES, 3 * Float.BYTES);
		gl.glEnableVertexAttribArray(1);

		// unbind VBO
		gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
	}

	private void shutdownVao()
	{
		glDeleteVertexArrays(gl, vaoHandle);
		vaoHandle = -1;

		glDeleteBuffer(gl, vboUiHandle);
		vboUiHandle = -1;

		glDeleteVertexArrays(gl, vaoUiHandle);
		vaoUiHandle = -1;
	}

	private void initBuffers()
	{
		initGlBuffer(sceneVertexBuffer);
		initGlBuffer(sceneUvBuffer);
		initGlBuffer(tmpVertexBuffer);
		initGlBuffer(tmpUvBuffer);
		initGlBuffer(tmpModelBufferLarge);
		initGlBuffer(tmpModelBufferSmall);
		initGlBuffer(tmpModelBufferUnordered);
		initGlBuffer(tmpOutBuffer);
		initGlBuffer(tmpOutUvBuffer);
	}

	private void initGlBuffer(GLBuffer glBuffer)
	{
		glBuffer.glBufferId = glGenBuffers(gl);
	}

	private void shutdownBuffers()
	{
		destroyGlBuffer(sceneVertexBuffer);
		destroyGlBuffer(sceneUvBuffer);

		destroyGlBuffer(tmpVertexBuffer);
		destroyGlBuffer(tmpUvBuffer);
		destroyGlBuffer(tmpModelBufferLarge);
		destroyGlBuffer(tmpModelBufferSmall);
		destroyGlBuffer(tmpModelBufferUnordered);
		destroyGlBuffer(tmpOutBuffer);
		destroyGlBuffer(tmpOutUvBuffer);
	}

	private void destroyGlBuffer(GLBuffer glBuffer)
	{
		if (glBuffer.glBufferId != -1)
		{
			glDeleteBuffer(gl, glBuffer.glBufferId);
			glBuffer.glBufferId = -1;
		}
		glBuffer.size = -1;

		if (glBuffer.cl_mem != null)
		{
			CL.clReleaseMemObject(glBuffer.cl_mem);
			glBuffer.cl_mem = null;
		}
	}

	private void initInterfaceTexture()
	{
		interfaceTexture = glGenTexture(gl);
		gl.glBindTexture(gl.GL_TEXTURE_2D, interfaceTexture);
		gl.glTexParameteri(gl.GL_TEXTURE_2D, gl.GL_TEXTURE_WRAP_S, gl.GL_CLAMP_TO_EDGE);
		gl.glTexParameteri(gl.GL_TEXTURE_2D, gl.GL_TEXTURE_WRAP_T, gl.GL_CLAMP_TO_EDGE);
		gl.glTexParameteri(gl.GL_TEXTURE_2D, gl.GL_TEXTURE_MIN_FILTER, gl.GL_LINEAR);
		gl.glTexParameteri(gl.GL_TEXTURE_2D, gl.GL_TEXTURE_MAG_FILTER, gl.GL_LINEAR);
		gl.glBindTexture(gl.GL_TEXTURE_2D, 0);
	}

	private void shutdownInterfaceTexture()
	{
		glDeleteTexture(gl, interfaceTexture);
		interfaceTexture = -1;
	}

	private void initUniformBuffer()
	{
		initGlBuffer(uniformBuffer);

		IntBuffer uniformBuf = GpuIntBuffer.allocateDirect(8 + 2048 * 4);
		uniformBuf.put(new int[8]); // uniform block
		final int[] pad = new int[2];
		for (int i = 0; i < 2048; i++)
		{
			uniformBuf.put(Perspective.SINE[i]);
			uniformBuf.put(Perspective.COSINE[i]);
			uniformBuf.put(pad); // ivec2 alignment in std140 is 16 bytes
		}
		uniformBuf.flip();

		updateBuffer(uniformBuffer, GL_UNIFORM_BUFFER, uniformBuf.limit() * Integer.BYTES, uniformBuf, GL_DYNAMIC_DRAW, CL_MEM_READ_ONLY);
		gl.glBindBuffer(GL_UNIFORM_BUFFER, 0);
	}

	private void initAAFbo(int width, int height, int aaSamples)
	{
		// Create and bind the FBO
		fboSceneHandle = glGenFrameBuffer(gl);
		gl.glBindFramebuffer(gl.GL_FRAMEBUFFER, fboSceneHandle);

		// Create color render buffer
		rboSceneHandle = glGenRenderbuffer(gl);
		gl.glBindRenderbuffer(gl.GL_RENDERBUFFER, rboSceneHandle);
		gl.glRenderbufferStorageMultisample(gl.GL_RENDERBUFFER, aaSamples, gl.GL_RGBA, width, height);
		gl.glFramebufferRenderbuffer(gl.GL_FRAMEBUFFER, gl.GL_COLOR_ATTACHMENT0, gl.GL_RENDERBUFFER, rboSceneHandle);

		// Create texture
		texSceneHandle = glGenTexture(gl);
		gl.glBindTexture(gl.GL_TEXTURE_2D_MULTISAMPLE, texSceneHandle);
		gl.glTexImage2DMultisample(gl.GL_TEXTURE_2D_MULTISAMPLE, aaSamples, gl.GL_RGBA, width, height, true);

		// Bind texture
		gl.glFramebufferTexture2D(gl.GL_FRAMEBUFFER, gl.GL_COLOR_ATTACHMENT0, gl.GL_TEXTURE_2D_MULTISAMPLE, texSceneHandle, 0);

		// Reset
		gl.glBindTexture(gl.GL_TEXTURE_2D_MULTISAMPLE, 0);
		gl.glBindFramebuffer(gl.GL_FRAMEBUFFER, 0);
		gl.glBindRenderbuffer(gl.GL_RENDERBUFFER, 0);
	}

	private void shutdownAAFbo()
	{
		if (texSceneHandle != -1)
		{
			glDeleteTexture(gl, texSceneHandle);
			texSceneHandle = -1;
		}

		if (fboSceneHandle != -1)
		{
			glDeleteFrameBuffer(gl, fboSceneHandle);
			fboSceneHandle = -1;
		}

		if (rboSceneHandle != -1)
		{
			glDeleteRenderbuffers(gl, rboSceneHandle);
			rboSceneHandle = -1;
		}
	}

	@Override
	public void drawScene(int cameraX, int cameraY, int cameraZ, int cameraPitch, int cameraYaw, int plane)
	{
		yaw = client.getCameraYaw();
		pitch = client.getCameraPitch();

		final Scene scene = client.getScene();
		scene.setDrawDistance(getDrawDistance());

		invokeOnMainThread(() ->
		{
			// UBO. Only the first 32 bytes get modified here, the rest is the constant sin/cos table.
			// We can reuse the vertex buffer since it isn't used yet.
			vertexBuffer.clear();
			vertexBuffer.ensureCapacity(32);
			IntBuffer uniformBuf = vertexBuffer.getBuffer();
			uniformBuf
				.put(yaw)
				.put(pitch)
				.put(client.getCenterX())
				.put(client.getCenterY())
				.put(client.getScale())
				.put(cameraX)
				.put(cameraY)
				.put(cameraZ);
			uniformBuf.flip();

			gl.glBindBuffer(GL_UNIFORM_BUFFER, uniformBuffer.glBufferId);
			gl.glBufferSubData(GL_UNIFORM_BUFFER, 0, uniformBuf.limit() * Integer.BYTES, uniformBuf);
			gl.glBindBuffer(GL_UNIFORM_BUFFER, 0);

			gl.glBindBufferBase(GL_UNIFORM_BUFFER, 0, uniformBuffer.glBufferId);
			uniformBuf.clear();
		});
	}

	@Override
	public void postDrawScene()
	{
		invokeOnMainThread(this::postDraw);
	}

	private void postDraw()
	{
		if (computeMode == ComputeMode.NONE)
		{
			// Upload buffers
			vertexBuffer.flip();
			uvBuffer.flip();

			IntBuffer vertexBuffer = this.vertexBuffer.getBuffer();
			FloatBuffer uvBuffer = this.uvBuffer.getBuffer();

			updateBuffer(tmpVertexBuffer, GL_ARRAY_BUFFER, vertexBuffer.limit() * Integer.BYTES, vertexBuffer, GL_DYNAMIC_DRAW, 0L);
			updateBuffer(tmpUvBuffer, GL_ARRAY_BUFFER, uvBuffer.limit() * Float.BYTES, uvBuffer, GL_DYNAMIC_DRAW, 0L);
			return;
		}

		// Upload buffers
		vertexBuffer.flip();
		uvBuffer.flip();
		modelBuffer.flip();
		modelBufferSmall.flip();
		modelBufferUnordered.flip();

		IntBuffer vertexBuffer = this.vertexBuffer.getBuffer();
		FloatBuffer uvBuffer = this.uvBuffer.getBuffer();
		IntBuffer modelBuffer = this.modelBuffer.getBuffer();
		IntBuffer modelBufferSmall = this.modelBufferSmall.getBuffer();
		IntBuffer modelBufferUnordered = this.modelBufferUnordered.getBuffer();

		// temp buffers
		updateBuffer(tmpVertexBuffer, GL_ARRAY_BUFFER, vertexBuffer.limit() * Integer.BYTES, vertexBuffer, GL_DYNAMIC_DRAW, CL_MEM_READ_ONLY);
		updateBuffer(tmpUvBuffer, GL_ARRAY_BUFFER, uvBuffer.limit() * Float.BYTES, uvBuffer, GL_DYNAMIC_DRAW, CL_MEM_READ_ONLY);

		// model buffers
		updateBuffer(tmpModelBufferLarge, GL_ARRAY_BUFFER, modelBuffer.limit() * Integer.BYTES, modelBuffer, GL_DYNAMIC_DRAW, CL_MEM_READ_ONLY);
		updateBuffer(tmpModelBufferSmall, GL_ARRAY_BUFFER, modelBufferSmall.limit() * Integer.BYTES, modelBufferSmall, GL_DYNAMIC_DRAW, CL_MEM_READ_ONLY);
		updateBuffer(tmpModelBufferUnordered, GL_ARRAY_BUFFER, modelBufferUnordered.limit() * Integer.BYTES, modelBufferUnordered, GL_DYNAMIC_DRAW, CL_MEM_READ_ONLY);

		// Output buffers
		updateBuffer(tmpOutBuffer,
			GL_ARRAY_BUFFER,
			targetBufferOffset * 16, // each vertex is an ivec4, which is 16 bytes
			null,
			GL_STREAM_DRAW,
			CL_MEM_WRITE_ONLY);
		updateBuffer(tmpOutUvBuffer,
			GL_ARRAY_BUFFER,
			targetBufferOffset * 16, // each vertex is an ivec4, which is 16 bytes
			null,
			GL_STREAM_DRAW,
			CL_MEM_WRITE_ONLY);

		if (computeMode == ComputeMode.OPENCL)
		{
			// The docs for clEnqueueAcquireGLObjects say all pending GL operations must be completed before calling
			// clEnqueueAcquireGLObjects, and recommends calling glFinish() as the only portable way to do that.
			// However no issues have been observed from not calling it, and so will leave disabled for now.
			// gl.glFinish();

			openCLManager.compute(
				unorderedModels, smallModels, largeModels,
				sceneVertexBuffer, sceneUvBuffer,
				tmpVertexBuffer, tmpUvBuffer,
				tmpModelBufferUnordered, tmpModelBufferSmall, tmpModelBufferLarge,
				tmpOutBuffer, tmpOutUvBuffer,
				uniformBuffer);
			return;
		}

		/*
		 * Compute is split into three separate programs: 'unordered', 'small', and 'large'
		 * to save on GPU resources. Small will sort <= 512 faces, large will do <= 4096.
		 */

		// Bind UBO to compute programs
		gl.glUniformBlockBinding(glSmallComputeProgram, uniBlockSmall, 0);
		gl.glUniformBlockBinding(glComputeProgram, uniBlockLarge, 0);

		// unordered
		gl.glUseProgram(glUnorderedComputeProgram);

		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 0, tmpModelBufferUnordered.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 1, sceneVertexBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 2, tmpVertexBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 3, tmpOutBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 4, tmpOutUvBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 5, sceneUvBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 6, tmpUvBuffer.glBufferId);

		gl.glDispatchCompute(unorderedModels, 1, 1);

		// small
		gl.glUseProgram(glSmallComputeProgram);

		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 0, tmpModelBufferSmall.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 1, sceneVertexBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 2, tmpVertexBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 3, tmpOutBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 4, tmpOutUvBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 5, sceneUvBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 6, tmpUvBuffer.glBufferId);

		gl.glDispatchCompute(smallModels, 1, 1);

		// large
		gl.glUseProgram(glComputeProgram);

		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 0, tmpModelBufferLarge.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 1, sceneVertexBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 2, tmpVertexBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 3, tmpOutBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 4, tmpOutUvBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 5, sceneUvBuffer.glBufferId);
		gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 6, tmpUvBuffer.glBufferId);

		gl.glDispatchCompute(largeModels, 1, 1);
	}

	@Override
	public void drawScenePaint(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z,
							SceneTilePaint paint, int tileZ, int tileX, int tileY,
							int zoom, int centerX, int centerY)
	{
		if (computeMode == ComputeMode.NONE)
		{
			targetBufferOffset += sceneUploader.upload(paint,
				tileZ, tileX, tileY,
				vertexBuffer, uvBuffer,
				Perspective.LOCAL_TILE_SIZE * tileX,
				Perspective.LOCAL_TILE_SIZE * tileY,
				true
			);
		}
		else if (paint.getBufferLen() > 0)
		{
			final int localX = tileX * Perspective.LOCAL_TILE_SIZE;
			final int localY = 0;
			final int localZ = tileY * Perspective.LOCAL_TILE_SIZE;

			GpuIntBuffer b = modelBufferUnordered;
			++unorderedModels;

			b.ensureCapacity(8);
			IntBuffer buffer = b.getBuffer();
			buffer.put(paint.getBufferOffset());
			buffer.put(paint.getUvBufferOffset());
			buffer.put(2);
			buffer.put(targetBufferOffset);
			buffer.put(FLAG_SCENE_BUFFER);
			buffer.put(localX).put(localY).put(localZ);

			targetBufferOffset += 2 * 3;
		}
	}

	@Override
	public void drawSceneModel(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z,
							SceneTileModel model, int tileZ, int tileX, int tileY,
							int zoom, int centerX, int centerY)
	{
		if (computeMode == ComputeMode.NONE)
		{
			targetBufferOffset += sceneUploader.upload(model,
				tileX, tileY,
				vertexBuffer, uvBuffer,
				tileX << Perspective.LOCAL_COORD_BITS, tileY << Perspective.LOCAL_COORD_BITS, true);
		}
		else if (model.getBufferLen() > 0)
		{
			final int localX = tileX * Perspective.LOCAL_TILE_SIZE;
			final int localY = 0;
			final int localZ = tileY * Perspective.LOCAL_TILE_SIZE;

			GpuIntBuffer b = modelBufferUnordered;
			++unorderedModels;

			b.ensureCapacity(8);
			IntBuffer buffer = b.getBuffer();
			buffer.put(model.getBufferOffset());
			buffer.put(model.getUvBufferOffset());
			buffer.put(model.getBufferLen() / 3);
			buffer.put(targetBufferOffset);
			buffer.put(FLAG_SCENE_BUFFER);
			buffer.put(localX).put(localY).put(localZ);

			targetBufferOffset += model.getBufferLen();
		}
	}

	@Override
	public void draw(int overlayColor)
	{
		invokeOnMainThread(() -> drawFrame(overlayColor));
	}

	private void resize(int canvasWidth, int canvasHeight, int viewportWidth, int viewportHeight)
	{
		if (canvasWidth != lastCanvasWidth || canvasHeight != lastCanvasHeight)
		{
			lastCanvasWidth = canvasWidth;
			lastCanvasHeight = canvasHeight;

			gl.glBindTexture(gl.GL_TEXTURE_2D, interfaceTexture);
			gl.glTexImage2D(gl.GL_TEXTURE_2D, 0, gl.GL_RGBA, canvasWidth, canvasHeight, 0, gl.GL_BGRA, gl.GL_UNSIGNED_INT_8_8_8_8_REV, null);
			gl.glBindTexture(gl.GL_TEXTURE_2D, 0);

			if (OSType.getOSType() == OSType.MacOS && glDrawable instanceof GLFBODrawable)
			{
				// GLDrawables created with createGLDrawable() do not have a resize listener
				// I don't know why this works with Windows/Linux, but on OSX
				// it prevents JOGL from resizing its FBOs and underlying GL textures. So,
				// we manually trigger a resize here.
				GLFBODrawable glfboDrawable = (GLFBODrawable) glDrawable;
				glfboDrawable.resetSize(gl);
			}
		}
	}

	private void drawFrame(int overlayColor)
	{
		if (jawtWindow.getAWTComponent() != client.getCanvas())
		{
			// We inject code in the game engine mixin to prevent the client from doing canvas replacement,
			// so this should not ever be hit
			log.warn("Canvas invalidated!");
			shutDown();
			startUp();
			return;
		}

		if (client.getGameState() == GameState.LOADING || client.getGameState() == GameState.HOPPING)
		{
			// While the client is loading it doesn't draw
			return;
		}

		final int canvasHeight = client.getCanvasHeight();
		final int canvasWidth = client.getCanvasWidth();

		final int viewportHeight = client.getViewportHeight();
		final int viewportWidth = client.getViewportWidth();

		resize(canvasWidth, canvasHeight, viewportWidth, viewportHeight);

		// Setup anti-aliasing
		final AntiAliasingMode antiAliasingMode = config.antiAliasingMode();
		final boolean aaEnabled = antiAliasingMode != AntiAliasingMode.DISABLED;

		if (aaEnabled)
		{
			gl.glEnable(gl.GL_MULTISAMPLE);

			final Dimension stretchedDimensions = client.getStretchedDimensions();

			final int stretchedCanvasWidth = client.isStretchedEnabled() ? stretchedDimensions.width : canvasWidth;
			final int stretchedCanvasHeight = client.isStretchedEnabled() ? stretchedDimensions.height : canvasHeight;

			// Re-create fbo
			if (lastStretchedCanvasWidth != stretchedCanvasWidth
				|| lastStretchedCanvasHeight != stretchedCanvasHeight
				|| lastAntiAliasingMode != antiAliasingMode)
			{
				shutdownAAFbo();

				// Bind default FBO to check whether anti-aliasing is forced
				gl.glBindFramebuffer(gl.GL_FRAMEBUFFER, 0);
				final int forcedAASamples = glGetInteger(gl, gl.GL_SAMPLES);
				final int maxSamples = glGetInteger(gl, gl.GL_MAX_SAMPLES);
				final int samples = forcedAASamples != 0 ? forcedAASamples :
					Math.min(antiAliasingMode.getSamples(), maxSamples);

				log.debug("AA samples: {}, max samples: {}, forced samples: {}", samples, maxSamples, forcedAASamples);

				initAAFbo(stretchedCanvasWidth, stretchedCanvasHeight, samples);

				lastStretchedCanvasWidth = stretchedCanvasWidth;
				lastStretchedCanvasHeight = stretchedCanvasHeight;
			}

			gl.glBindFramebuffer(gl.GL_DRAW_FRAMEBUFFER, fboSceneHandle);
		}
		else
		{
			gl.glDisable(gl.GL_MULTISAMPLE);
			shutdownAAFbo();
		}

		lastAntiAliasingMode = antiAliasingMode;

		// Clear scene
		int sky = client.getSkyboxColor();
		gl.glClearColor((sky >> 16 & 0xFF) / 255f, (sky >> 8 & 0xFF) / 255f, (sky & 0xFF) / 255f, 1f);
		gl.glClear(gl.GL_COLOR_BUFFER_BIT);

		// Draw 3d scene
		final TextureProvider textureProvider = client.getTextureProvider();
		if (textureProvider != null)
		{
			if (textureArrayId == -1)
			{
				// lazy init textures as they may not be loaded at plugin start.
				// this will return -1 and retry if not all textures are loaded yet, too.
				textureArrayId = textureManager.initTextureArray(textureProvider, gl);
			}

			final Texture[] textures = textureProvider.getTextures();
			int renderHeightOff = client.getViewportYOffset();
			int renderWidthOff = client.getViewportXOffset();
			int renderCanvasHeight = canvasHeight;
			int renderViewportHeight = viewportHeight;
			int renderViewportWidth = viewportWidth;

			// Setup anisotropic filtering
			final int anisotropicFilteringLevel = config.anisotropicFilteringLevel();

			if (textureArrayId != -1 && lastAnisotropicFilteringLevel != anisotropicFilteringLevel)
			{
				textureManager.setAnisotropicFilteringLevel(textureArrayId, anisotropicFilteringLevel, gl);
				lastAnisotropicFilteringLevel = anisotropicFilteringLevel;
			}

			if (client.isStretchedEnabled())
			{
				Dimension dim = client.getStretchedDimensions();
				renderCanvasHeight = dim.height;

				double scaleFactorY = dim.getHeight() / canvasHeight;
				double scaleFactorX = dim.getWidth()  / canvasWidth;

				// Pad the viewport a little because having ints for our viewport dimensions can introduce off-by-one errors.
				final int padding = 1;

				// Ceil the sizes because even if the size is 599.1 we want to treat it as size 600 (i.e. render to the x=599 pixel).
				renderViewportHeight = (int) Math.ceil(scaleFactorY * (renderViewportHeight)) + padding * 2;
				renderViewportWidth  = (int) Math.ceil(scaleFactorX * (renderViewportWidth ))  + padding * 2;

				// Floor the offsets because even if the offset is 4.9, we want to render to the x=4 pixel anyway.
				renderHeightOff      = (int) Math.floor(scaleFactorY * (renderHeightOff)) - padding;
				renderWidthOff       = (int) Math.floor(scaleFactorX * (renderWidthOff )) - padding;
			}

			glDpiAwareViewport(renderWidthOff, renderCanvasHeight - renderViewportHeight - renderHeightOff, renderViewportWidth, renderViewportHeight);

			gl.glUseProgram(glProgram);

			final int drawDistance = getDrawDistance();
			final int fogDepth = config.fogDepth();
			gl.glUniform1i(uniUseFog, fogDepth > 0 ? 1 : 0);
			gl.glUniform4f(uniFogColor, (sky >> 16 & 0xFF) / 255f, (sky >> 8 & 0xFF) / 255f, (sky & 0xFF) / 255f, 1f);
			gl.glUniform1i(uniFogDepth, fogDepth);
			gl.glUniform1i(uniDrawDistance, drawDistance * Perspective.LOCAL_TILE_SIZE);

			// Brightness happens to also be stored in the texture provider, so we use that
			gl.glUniform1f(uniBrightness, (float) textureProvider.getBrightness());
			gl.glUniform1f(uniSmoothBanding, config.smoothBanding() ? 0f : 1f);
			gl.glUniform1i(uniColorBlindMode, config.colorBlindMode().ordinal());
			gl.glUniform1f(uniTextureLightMode, config.brightTextures() ? 1f : 0f);

			// Calculate projection matrix
			Matrix4 projectionMatrix = new Matrix4();
			projectionMatrix.scale(client.getScale(), client.getScale(), 1);
			projectionMatrix.multMatrix(makeProjectionMatrix(viewportWidth, viewportHeight, 50));
			projectionMatrix.rotate((float) (Math.PI - pitch * Perspective.UNIT), -1, 0, 0);
			projectionMatrix.rotate((float) (yaw * Perspective.UNIT), 0, 1, 0);
			projectionMatrix.translate(-client.getCameraX2(), -client.getCameraY2(), -client.getCameraZ2());
			gl.glUniformMatrix4fv(uniProjectionMatrix, 1, false, projectionMatrix.getMatrix(), 0);

			for (int id = 0; id < textures.length; ++id)
			{
				Texture texture = textures[id];
				if (texture == null)
				{
					continue;
				}

				textureProvider.load(id); // trips the texture load flag which lets textures animate

				textureOffsets[id * 2] = texture.getU();
				textureOffsets[id * 2 + 1] = texture.getV();
			}

			// Bind uniforms
			gl.glUniformBlockBinding(glProgram, uniBlockMain, 0);
			gl.glUniform1i(uniTextures, 1); // texture sampler array is bound to texture1
			gl.glUniform2fv(uniTextureOffsets, 128, textureOffsets, 0);

			// We just allow the GL to do face culling. Note this requires the priority renderer
			// to have logic to disregard culled faces in the priority depth testing.
			gl.glEnable(gl.GL_CULL_FACE);

			// Enable blending for alpha
			gl.glEnable(gl.GL_BLEND);
			gl.glBlendFunc(gl.GL_SRC_ALPHA, gl.GL_ONE_MINUS_SRC_ALPHA);

			// Draw buffers
			gl.glBindVertexArray(vaoHandle);

			int vertexBuffer, uvBuffer;
			if (computeMode != ComputeMode.NONE)
			{
				if (computeMode == ComputeMode.OPENGL)
				{
					// Before reading the SSBOs written to from postDrawScene() we must insert a barrier
					gl.glMemoryBarrier(gl.GL_SHADER_STORAGE_BARRIER_BIT);
				}
				else
				{
					// Wait for the command queue to finish, so that we know the compute is done
					openCLManager.finish();
				}

				// Draw using the output buffer of the compute
				vertexBuffer = tmpOutBuffer.glBufferId;
				uvBuffer = tmpOutUvBuffer.glBufferId;
			}
			else
			{
				// Only use the temporary buffers, which will contain the full scene
				vertexBuffer = tmpVertexBuffer.glBufferId;
				uvBuffer = tmpUvBuffer.glBufferId;
			}

			gl.glEnableVertexAttribArray(0);
			gl.glBindBuffer(GL_ARRAY_BUFFER, vertexBuffer);
			gl.glVertexAttribIPointer(0, 4, gl.GL_INT, 0, 0);

			gl.glEnableVertexAttribArray(1);
			gl.glBindBuffer(GL_ARRAY_BUFFER, uvBuffer);
			gl.glVertexAttribPointer(1, 4, gl.GL_FLOAT, false, 0, 0);

			gl.glDrawArrays(gl.GL_TRIANGLES, 0, targetBufferOffset);

			gl.glDisable(gl.GL_BLEND);
			gl.glDisable(gl.GL_CULL_FACE);

			gl.glUseProgram(0);
		}

		if (aaEnabled)
		{
			gl.glBindFramebuffer(gl.GL_READ_FRAMEBUFFER, fboSceneHandle);
			gl.glBindFramebuffer(gl.GL_DRAW_FRAMEBUFFER, 0);
			gl.glBlitFramebuffer(0, 0, lastStretchedCanvasWidth, lastStretchedCanvasHeight,
				0, 0, lastStretchedCanvasWidth, lastStretchedCanvasHeight,
				gl.GL_COLOR_BUFFER_BIT, gl.GL_NEAREST);

			// Reset
			gl.glBindFramebuffer(gl.GL_READ_FRAMEBUFFER, 0);
		}

		vertexBuffer.clear();
		uvBuffer.clear();
		modelBuffer.clear();
		modelBufferSmall.clear();
		modelBufferUnordered.clear();

		targetBufferOffset = 0;
		smallModels = largeModels = unorderedModels = 0;
		tempOffset = 0;
		tempUvOffset = 0;

		// Texture on UI
		drawUi(overlayColor, canvasHeight, canvasWidth);

		glDrawable.swapBuffers();

		drawManager.processDrawComplete(this::screenshot);
	}

	private float[] makeProjectionMatrix(float w, float h, float n)
	{
		return new float[]
		{
			2 / w, 0, 0, 0,
			0, 2 / h, 0, 0,
			0, 0, -1, -1,
			0, 0, -2 * n, 0
		};
	}

	private void drawUi(final int overlayColor, final int canvasHeight, final int canvasWidth)
	{
		final BufferProvider bufferProvider = client.getBufferProvider();
		final int[] pixels = bufferProvider.getPixels();
		final int width = bufferProvider.getWidth();
		final int height = bufferProvider.getHeight();

		gl.glEnable(gl.GL_BLEND);

		vertexBuffer.clear(); // reuse vertex buffer for interface
		vertexBuffer.ensureCapacity(pixels.length);

		IntBuffer interfaceBuffer = vertexBuffer.getBuffer();
		interfaceBuffer.put(pixels);
		vertexBuffer.flip();

		gl.glBlendFunc(gl.GL_ONE, gl.GL_ONE_MINUS_SRC_ALPHA);
		gl.glBindTexture(gl.GL_TEXTURE_2D, interfaceTexture);

		gl.glTexSubImage2D(gl.GL_TEXTURE_2D, 0, 0, 0, width, height, gl.GL_BGRA, gl.GL_UNSIGNED_INT_8_8_8_8_REV, interfaceBuffer);

		// Use the texture bound in the first pass
		final UIScalingMode uiScalingMode = config.uiScalingMode();
		gl.glUseProgram(glUiProgram);
		gl.glUniform1i(uniTex, 0);
		gl.glUniform1i(uniTexSamplingMode, uiScalingMode.getMode());
		gl.glUniform2i(uniTexSourceDimensions, canvasWidth, canvasHeight);
		gl.glUniform1i(uniUiColorBlindMode, config.colorBlindMode().ordinal());
		gl.glUniform4f(uniUiAlphaOverlay,
			(overlayColor >> 16 & 0xFF) / 255f,
			(overlayColor >> 8 & 0xFF) / 255f,
			(overlayColor & 0xFF) / 255f,
			(overlayColor >>> 24) / 255f
		);

		if (client.isStretchedEnabled())
		{
			Dimension dim = client.getStretchedDimensions();
			glDpiAwareViewport(0, 0, dim.width, dim.height);
			gl.glUniform2i(uniTexTargetDimensions, dim.width, dim.height);
		}
		else
		{
			glDpiAwareViewport(0, 0, canvasWidth, canvasHeight);
			gl.glUniform2i(uniTexTargetDimensions, canvasWidth, canvasHeight);
		}

		// Set the sampling function used when stretching the UI.
		// This is probably better done with sampler objects instead of texture parameters, but this is easier and likely more portable.
		// See https://www.khronos.org/opengl/wiki/Sampler_Object for details.
		if (client.isStretchedEnabled())
		{
			// GL_NEAREST makes sampling for bicubic/xBR simpler, so it should be used whenever linear isn't
			final int function = uiScalingMode == UIScalingMode.LINEAR ? gl.GL_LINEAR : gl.GL_NEAREST;
			gl.glTexParameteri(gl.GL_TEXTURE_2D, gl.GL_TEXTURE_MIN_FILTER, function);
			gl.glTexParameteri(gl.GL_TEXTURE_2D, gl.GL_TEXTURE_MAG_FILTER, function);
		}

		// Texture on UI
		gl.glBindVertexArray(vaoUiHandle);
		gl.glDrawArrays(gl.GL_TRIANGLE_FAN, 0, 4);

		// Reset
		gl.glBindTexture(gl.GL_TEXTURE_2D, 0);
		gl.glBindVertexArray(0);
		gl.glUseProgram(0);
		gl.glBlendFunc(gl.GL_SRC_ALPHA, gl.GL_ONE_MINUS_SRC_ALPHA);
		gl.glDisable(gl.GL_BLEND);

		vertexBuffer.clear();
	}

	/**
	 * Convert the front framebuffer to an Image
	 *
	 * @return
	 */
	private Image screenshot()
	{
		int width  = client.getCanvasWidth();
		int height = client.getCanvasHeight();

		if (client.isStretchedEnabled())
		{
			Dimension dim = client.getStretchedDimensions();
			width  = dim.width;
			height = dim.height;
		}

		if (OSType.getOSType() != OSType.MacOS)
		{
			final Graphics2D graphics = (Graphics2D) canvas.getGraphics();
			final AffineTransform t = graphics.getTransform();
			width = getScaledValue(t.getScaleX(), width);
			height = getScaledValue(t.getScaleY(), height);
			graphics.dispose();
		}

		ByteBuffer buffer = ByteBuffer.allocateDirect(width * height * 4)
			.order(ByteOrder.nativeOrder());

		gl.glReadBuffer(gl.GL_FRONT);
		gl.glReadPixels(0, 0, width, height, GL.GL_RGBA, gl.GL_UNSIGNED_BYTE, buffer);

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		for (int y = 0; y < height; ++y)
		{
			for (int x = 0; x < width; ++x)
			{
				int r = buffer.get() & 0xff;
				int g = buffer.get() & 0xff;
				int b = buffer.get() & 0xff;
				buffer.get(); // alpha

				pixels[(height - y - 1) * width + x] = (r << 16) | (g << 8) | b;
			}
		}

		return image;
	}

	@Override
	public void animate(Texture texture, int diff)
	{
		textureManager.animate(texture, diff);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (computeMode == ComputeMode.NONE || gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		invokeOnMainThread(this::uploadScene);
	}

	private void uploadScene()
	{
		vertexBuffer.clear();
		uvBuffer.clear();

		sceneUploader.upload(client.getScene(), vertexBuffer, uvBuffer);

		vertexBuffer.flip();
		uvBuffer.flip();

		IntBuffer vertexBuffer = this.vertexBuffer.getBuffer();
		FloatBuffer uvBuffer = this.uvBuffer.getBuffer();

		updateBuffer(sceneVertexBuffer, GL_ARRAY_BUFFER, vertexBuffer.limit() * Integer.BYTES, vertexBuffer, GL_STATIC_COPY, CL_MEM_READ_ONLY);
		updateBuffer(sceneUvBuffer, GL_ARRAY_BUFFER, uvBuffer.limit() * Float.BYTES, uvBuffer, GL_STATIC_COPY, CL_MEM_READ_ONLY);

		gl.glBindBuffer(GL_ARRAY_BUFFER, 0);

		vertexBuffer.clear();
		uvBuffer.clear();
	}

	/**
	 * Check is a model is visible and should be drawn.
	 */
	private boolean isVisible(Model model, int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int _x, int _y, int _z, long hash)
	{
		final int XYZMag = model.getXYZMag();
		final int zoom = client.get3dZoom();
		final int modelHeight = model.getModelHeight();

		int Rasterizer3D_clipMidX2 = client.getRasterizer3D_clipMidX2();
		int Rasterizer3D_clipNegativeMidX = client.getRasterizer3D_clipNegativeMidX();
		int Rasterizer3D_clipNegativeMidY = client.getRasterizer3D_clipNegativeMidY();
		int Rasterizer3D_clipMidY2 = client.getRasterizer3D_clipMidY2();

		int var11 = yawCos * _z - yawSin * _x >> 16;
		int var12 = pitchSin * _y + pitchCos * var11 >> 16;
		int var13 = pitchCos * XYZMag >> 16;
		int var14 = var12 + var13;
		if (var14 > 50)
		{
			int var15 = _z * yawSin + yawCos * _x >> 16;
			int var16 = (var15 - XYZMag) * zoom;
			if (var16 / var14 < Rasterizer3D_clipMidX2)
			{
				int var17 = (var15 + XYZMag) * zoom;
				if (var17 / var14 > Rasterizer3D_clipNegativeMidX)
				{
					int var18 = pitchCos * _y - var11 * pitchSin >> 16;
					int var19 = pitchSin * XYZMag >> 16;
					int var20 = (var18 + var19) * zoom;
					if (var20 / var14 > Rasterizer3D_clipNegativeMidY)
					{
						int var21 = (pitchCos * modelHeight >> 16) + var19;
						int var22 = (var18 - var21) * zoom;
						return var22 / var14 < Rasterizer3D_clipMidY2;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Draw a renderable in the scene
	 *
	 * @param renderable
	 * @param orientation
	 * @param pitchSin
	 * @param pitchCos
	 * @param yawSin
	 * @param yawCos
	 * @param x
	 * @param y
	 * @param z
	 * @param hash
	 */
	@Override
	public void draw(Renderable renderable, int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z, long hash)
	{
		if (computeMode == ComputeMode.NONE)
		{
			Model model = renderable instanceof Model ? (Model) renderable : renderable.getModel();
			if (model != null)
			{
				// Apply height to renderable from the model
				if (model != renderable)
				{
					renderable.setModelHeight(model.getModelHeight());
				}

				model.calculateBoundsCylinder();

				if (!isVisible(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash))
				{
					return;
				}

				model.calculateExtreme(orientation);
				client.checkClickbox(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash);

				modelX = x + client.getCameraX2();
				modelY = y + client.getCameraY2();
				modelZ = z + client.getCameraZ2();
				modelOrientation = orientation;
				int triangleCount = model.getTrianglesCount();
				vertexBuffer.ensureCapacity(12 * triangleCount);
				uvBuffer.ensureCapacity(12 * triangleCount);

				drawingModel = true;

				renderable.draw(orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash);

				drawingModel = false;
			}
		}
		// Model may be in the scene buffer
		else if (renderable instanceof Model && ((Model) renderable).getSceneId() == sceneUploader.sceneId)
		{
			Model model = (Model) renderable;

			model.calculateBoundsCylinder();

			if (!isVisible(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash))
			{
				return;
			}

			model.calculateExtreme(orientation);
			client.checkClickbox(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash);

			int tc = Math.min(MAX_TRIANGLE, model.getTrianglesCount());
			int uvOffset = model.getUvBufferOffset();

			GpuIntBuffer b = bufferForTriangles(tc);

			b.ensureCapacity(8);
			IntBuffer buffer = b.getBuffer();
			buffer.put(model.getBufferOffset());
			buffer.put(uvOffset);
			buffer.put(tc);
			buffer.put(targetBufferOffset);
			buffer.put(FLAG_SCENE_BUFFER | (model.getRadius() << 12) | orientation);
			buffer.put(x + client.getCameraX2()).put(y + client.getCameraY2()).put(z + client.getCameraZ2());

			targetBufferOffset += tc * 3;
		}
		else
		{
			// Temporary model (animated or otherwise not a static Model on the scene)
			Model model = renderable instanceof Model ? (Model) renderable : renderable.getModel();
			if (model != null)
			{
				// Apply height to renderable from the model
				if (model != renderable)
				{
					renderable.setModelHeight(model.getModelHeight());
				}

				model.calculateBoundsCylinder();

				if (!isVisible(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash))
				{
					return;
				}

				model.calculateExtreme(orientation);
				client.checkClickbox(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash);

				boolean hasUv = model.getFaceTextures() != null;

				int faces = Math.min(MAX_TRIANGLE, model.getTrianglesCount());
				vertexBuffer.ensureCapacity(12 * faces);
				uvBuffer.ensureCapacity(12 * faces);
				int len = 0;
				for (int i = 0; i < faces; ++i)
				{
					len += sceneUploader.pushFace(model, i, false, vertexBuffer, uvBuffer, 0, 0, 0, 0);
				}

				GpuIntBuffer b = bufferForTriangles(faces);

				b.ensureCapacity(8);
				IntBuffer buffer = b.getBuffer();
				buffer.put(tempOffset);
				buffer.put(hasUv ? tempUvOffset : -1);
				buffer.put(len / 3);
				buffer.put(targetBufferOffset);
				buffer.put((model.getRadius() << 12) | orientation);
				buffer.put(x + client.getCameraX2()).put(y + client.getCameraY2()).put(z + client.getCameraZ2());

				tempOffset += len;
				if (hasUv)
				{
					tempUvOffset += len;
				}

				targetBufferOffset += len;
			}
		}
	}

	@Override
	public boolean drawFace(Model model, int face)
	{
		if (!drawingModel)
		{
			return false;
		}

		targetBufferOffset += sceneUploader.pushFace(model, face, true, vertexBuffer, uvBuffer, modelX, modelY, modelZ, modelOrientation);
		return true;
	}

	/**
	 * returns the correct buffer based on triangle count and updates model count
	 *
	 * @param triangles
	 * @return
	 */
	private GpuIntBuffer bufferForTriangles(int triangles)
	{
		if (triangles <= SMALL_TRIANGLE_COUNT)
		{
			++smallModels;
			return modelBufferSmall;
		}
		else
		{
			++largeModels;
			return modelBuffer;
		}
	}

	private int getScaledValue(final double scale, final int value)
	{
		return SurfaceScaleUtils.scale(value, (float) scale);
	}

	private void glDpiAwareViewport(final int x, final int y, final int width, final int height)
	{
		if (OSType.getOSType() == OSType.MacOS)
		{
			// JOGL seems to handle DPI scaling for us already
			gl.glViewport(x, y, width, height);
		}
		else
		{
			final Graphics2D graphics = (Graphics2D) canvas.getGraphics();
			final AffineTransform t = graphics.getTransform();
			gl.glViewport(
				getScaledValue(t.getScaleX(), x),
				getScaledValue(t.getScaleY(), y),
				getScaledValue(t.getScaleX(), width),
				getScaledValue(t.getScaleY(), height));
			graphics.dispose();
		}
	}

	private int getDrawDistance()
	{
		final int limit = computeMode != ComputeMode.NONE ? MAX_DISTANCE : DEFAULT_DISTANCE;
		return Ints.constrainToRange(config.drawDistance(), 0, limit);
	}

	private static void invokeOnMainThread(Runnable runnable)
	{
		if (OSType.getOSType() == OSType.MacOS)
		{
			OSXUtil.RunOnMainThread(true, false, runnable);
		}
		else
		{
			runnable.run();
		}
	}

	private void updateBuffer(GLBuffer glBuffer, int target, int size, Buffer data, int usage, long clFlags)
	{
		gl.glBindBuffer(target, glBuffer.glBufferId);
		if (size > glBuffer.size)
		{
			log.trace("Buffer resize: {} {} -> {}", glBuffer, glBuffer.size, size);

			glBuffer.size = size;
			gl.glBufferData(target, size, data, usage);

			if (computeMode == ComputeMode.OPENCL)
			{
				if (glBuffer.cl_mem != null)
				{
					CL.clReleaseMemObject(glBuffer.cl_mem);
				}
				if (size == 0)
				{
					glBuffer.cl_mem = null;
				}
				else
				{
					glBuffer.cl_mem = clCreateFromGLBuffer(openCLManager.context, clFlags, glBuffer.glBufferId, null);
				}
			}
		}
		else if (data != null)
		{
			gl.glBufferSubData(target, 0, size, data);
		}
	}
}
