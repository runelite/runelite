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

import com.google.inject.Provides;
import com.jogamp.nativewindow.awt.AWTGraphicsConfiguration;
import com.jogamp.nativewindow.awt.JAWTWindow;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.GLDrawable;
import com.jogamp.opengl.GLDrawableFactory;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.GLProfile;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.function.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import jogamp.nativewindow.SurfaceScaleUtils;
import jogamp.nativewindow.jawt.x11.X11JAWTWindow;
import jogamp.newt.awt.NewtFactoryAWT;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.BufferProvider;
import net.runelite.api.Client;
import net.runelite.api.Constants;
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
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import static net.runelite.client.plugins.gpu.GLUtil.*;
import net.runelite.client.plugins.gpu.config.AnisotropicFilteringMode;
import net.runelite.client.plugins.gpu.config.AntiAliasingMode;
import net.runelite.client.plugins.gpu.template.Template;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.util.OSType;

@PluginDescriptor(
	name = "GPU",
	description = "Utilizes the GPU",
	enabledByDefault = false,
	tags = {"fog", "draw distance"}
)
@Slf4j
@Singleton
public class GpuPlugin extends Plugin implements DrawCallbacks
{
	// This is the maximum number of triangles the compute shaders support
	private static final int MAX_TRIANGLE = 4096;
	static final int SMALL_TRIANGLE_COUNT = 512;
	private static final int FLAG_SCENE_BUFFER = Integer.MIN_VALUE;
	static final int MAX_DISTANCE = 90;
	static final int MAX_FOG_DEPTH = 100;

	@Inject
	private Client client;

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

	@Inject
	private EventBus eventbus;

	private Canvas canvas;
	private JAWTWindow jawtWindow;
	private GL4 gl;
	private GLContext glContext;
	private GLDrawable glDrawable;

	private int glProgram;
	private int glVertexShader;
	private int glGeomShader;
	private int glFragmentShader;

	private int glComputeProgram;
	private int glComputeShader;

	private int glSmallComputeProgram;
	private int glSmallComputeShader;

	private int glUnorderedComputeProgram;
	private int glUnorderedComputeShader;

	private int vaoHandle;

	private int interfaceTexture;

	private int glUiProgram;
	private int glUiVertexShader;
	private int glUiFragmentShader;

	private int vaoUiHandle;
	private int vboUiHandle;

	private int fboSceneHandle;
	private int texSceneHandle;
	private int rboSceneHandle;

	// scene vertex buffer id
	private int bufferId;
	// scene uv buffer id
	private int uvBufferId;

	private int textureArrayId;

	private int uniformBufferId;
	private final IntBuffer uniformBuffer = GpuIntBuffer.allocateDirect(5 + 3 + 2048 * 4);
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

	private int lastViewportWidth;
	private int lastViewportHeight;
	private int lastCanvasWidth;
	private int lastCanvasHeight;
	private int lastStretchedCanvasWidth;
	private int lastStretchedCanvasHeight;
	private AntiAliasingMode lastAntiAliasingMode;
	private AnisotropicFilteringMode lastAnisotropicFilteringMode;

	private int centerX;
	private int centerY;

	// Uniforms
	private int uniUseFog;
	private int uniFogColor;
	private int uniFogDepth;
	private int uniFogCornerRadius;
	private int uniFogDensity;
	private int uniDrawDistance;
	private int uniProjectionMatrix;
	private int uniBrightness;
	private int uniTex;
	private int uniTextures;
	private int uniTextureOffsets;
	private int uniBlockSmall;
	private int uniBlockLarge;
	private int uniBlockMain;
	private int uniSmoothBanding;

	private int drawDistance;
	private boolean smoothBanding;
	private AntiAliasingMode antiAliasingMode;
	private AnisotropicFilteringMode anisotropicFilteringMode;
	private int fogDepth;
	private int fogCircularity;
	private int fogDensity;

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("gpu"))
		{
			updateConfig();
		}
	}

	private void updateConfig()
	{
		this.drawDistance = config.drawDistance();
		this.smoothBanding = config.smoothBanding();
		this.antiAliasingMode = config.antiAliasingMode();
		this.anisotropicFilteringMode = config.anisotropicFilteringMode();
		this.fogDepth = config.fogDepth();
		this.fogCircularity = config.fogCircularity();
		this.fogDensity = config.fogDensity();
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		clientThread.invoke(() ->
		{
			try
			{
				bufferId = uvBufferId = uniformBufferId = -1;
				unorderedModels = smallModels = largeModels = 0;

				vertexBuffer = new GpuIntBuffer();
				uvBuffer = new GpuFloatBuffer();

				modelBufferUnordered = new GpuIntBuffer();
				modelBufferSmall = new GpuIntBuffer();
				modelBuffer = new GpuIntBuffer();

				canvas = client.getCanvas();
				canvas.setIgnoreRepaint(true);

				GLProfile.initSingleton();

				GLProfile glProfile = GLProfile.get(GLProfile.GL4);

				GLCapabilities glCaps = new GLCapabilities(glProfile);
				AWTGraphicsConfiguration config = AWTGraphicsConfiguration.create(canvas.getGraphicsConfiguration(), glCaps, glCaps);

				jawtWindow = NewtFactoryAWT.getNativeWindow(canvas, config);
				canvas.setFocusable(true);

				GLDrawableFactory glDrawableFactory = GLDrawableFactory.getFactory(glProfile);

				glDrawable = glDrawableFactory.createGLDrawable(jawtWindow);
				glDrawable.setRealized(true);

				glContext = glDrawable.createContext(null);

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

				initVao();
				initProgram();
				initInterfaceTexture();
				initUniformBuffer();

				client.setDrawCallbacks(this);
				client.setGpu(true);

				// force rebuild of main buffer provider to enable alpha channel
				client.resizeCanvas();

				lastViewportWidth = lastViewportHeight = lastCanvasWidth = lastCanvasHeight = -1;
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
					uploadScene();
				}
			}
			catch (Throwable e)
			{
				log.error("Error starting GPU plugin", e);

				try
				{
					pluginManager.setPluginEnabled(this, false);
					pluginManager.stopPlugin(this);
				}
				catch (PluginInstantiationException ex)
				{
					log.error("error stopping plugin", ex);
				}

				shutDown();
			}

		});
	}

	@Override
	protected void shutDown()
	{
		eventbus.unregister(this);

		clientThread.invoke(() ->
		{
			client.setGpu(false);
			client.setDrawCallbacks(null);

			if (gl != null)
			{
				if (textureArrayId != -1)
				{
					textureManager.freeTextureArray(gl, textureArrayId);
					textureArrayId = -1;
				}

				if (bufferId != -1)
				{
					GLUtil.glDeleteBuffer(gl, bufferId);
					bufferId = -1;
				}

				if (uvBufferId != -1)
				{
					GLUtil.glDeleteBuffer(gl, uvBufferId);
					uvBufferId = -1;
				}

				if (uniformBufferId != -1)
				{
					GLUtil.glDeleteBuffer(gl, uniformBufferId);
					uniformBufferId = -1;
				}

				shutdownInterfaceTexture();
				shutdownProgram();
				shutdownVao();
				shutdownSceneFbo();
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

				NewtFactoryAWT.destroyNativeWindow(jawtWindow);
			}

			jawtWindow = null;
			gl = null;
			glDrawable = null;
			glContext = null;

			vertexBuffer = null;
			uvBuffer = null;

			modelBufferSmall = null;
			modelBuffer = null;
			modelBufferUnordered = null;

			// force main buffer provider rebuild to turn off alpha channel
			client.resizeCanvas();
		});
	}

	private void addSubscriptions()
	{
		eventbus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventbus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
	}

	@Provides
	GpuPluginConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GpuPluginConfig.class);
	}

	private void initProgram() throws ShaderException
	{
		glProgram = gl.glCreateProgram();
		glVertexShader = gl.glCreateShader(gl.GL_VERTEX_SHADER);
		glGeomShader = gl.glCreateShader(gl.GL_GEOMETRY_SHADER);
		glFragmentShader = gl.glCreateShader(gl.GL_FRAGMENT_SHADER);

		final String glVersionHeader;

		if (OSType.getOSType() == OSType.Linux)
		{
			glVersionHeader =
				"#version 420\n" +
					"#extension GL_ARB_compute_shader : require\n" +
					"#extension GL_ARB_shader_storage_buffer_object : require\n";
		}
		else
		{
			glVersionHeader = "#version 430\n";
		}

		Function<String, String> resourceLoader = (s) ->
		{
			if (s.endsWith(".glsl"))
			{
				return inputStreamToString(getClass().getResourceAsStream(s));
			}

			if (s.equals("version_header"))
			{
				return glVersionHeader;
			}

			return "";
		};

		Template template = new Template(resourceLoader);
		String source = template.process(resourceLoader.apply("geom.glsl"));

		template = new Template(resourceLoader);
		String vertSource = template.process(resourceLoader.apply("vert.glsl"));

		template = new Template(resourceLoader);
		String fragSource = template.process(resourceLoader.apply("frag.glsl"));

		GLUtil.loadShaders(gl, glProgram, glVertexShader, glGeomShader, glFragmentShader,
			vertSource,
			source,
			fragSource);

		glComputeProgram = gl.glCreateProgram();
		glComputeShader = gl.glCreateShader(gl.GL_COMPUTE_SHADER);
		template = new Template(resourceLoader);
		source = template.process(resourceLoader.apply("comp.glsl"));
		GLUtil.loadComputeShader(gl, glComputeProgram, glComputeShader, source);

		glSmallComputeProgram = gl.glCreateProgram();
		glSmallComputeShader = gl.glCreateShader(gl.GL_COMPUTE_SHADER);
		template = new Template(resourceLoader);
		source = template.process(resourceLoader.apply("comp_small.glsl"));
		GLUtil.loadComputeShader(gl, glSmallComputeProgram, glSmallComputeShader, source);

		glUnorderedComputeProgram = gl.glCreateProgram();
		glUnorderedComputeShader = gl.glCreateShader(gl.GL_COMPUTE_SHADER);
		template = new Template(resourceLoader);
		source = template.process(resourceLoader.apply("comp_unordered.glsl"));
		GLUtil.loadComputeShader(gl, glUnorderedComputeProgram, glUnorderedComputeShader, source);

		glUiProgram = gl.glCreateProgram();
		glUiVertexShader = gl.glCreateShader(gl.GL_VERTEX_SHADER);
		glUiFragmentShader = gl.glCreateShader(gl.GL_FRAGMENT_SHADER);
		GLUtil.loadShaders(gl, glUiProgram, glUiVertexShader, -1, glUiFragmentShader,
			inputStreamToString(getClass().getResourceAsStream("vertui.glsl")),
			null,
			inputStreamToString(getClass().getResourceAsStream("fragui.glsl")));

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
		uniFogCornerRadius = gl.glGetUniformLocation(glProgram, "fogCornerRadius");
		uniFogDensity = gl.glGetUniformLocation(glProgram, "fogDensity");
		uniDrawDistance = gl.glGetUniformLocation(glProgram, "drawDistance");

		uniTex = gl.glGetUniformLocation(glUiProgram, "tex");
		uniTextures = gl.glGetUniformLocation(glProgram, "textures");
		uniTextureOffsets = gl.glGetUniformLocation(glProgram, "textureOffsets");

		uniBlockSmall = gl.glGetUniformBlockIndex(glSmallComputeProgram, "uniforms");
		uniBlockLarge = gl.glGetUniformBlockIndex(glComputeProgram, "uniforms");
		uniBlockMain = gl.glGetUniformBlockIndex(glProgram, "uniforms");
	}

	private void shutdownProgram()
	{
		gl.glDeleteShader(glVertexShader);
		glVertexShader = -1;

		gl.glDeleteShader(glGeomShader);
		glGeomShader = -1;

		gl.glDeleteShader(glFragmentShader);
		glFragmentShader = -1;

		gl.glDeleteProgram(glProgram);
		glProgram = -1;

		gl.glDeleteShader(glComputeShader);
		glComputeShader = -1;

		gl.glDeleteProgram(glComputeProgram);
		glComputeProgram = -1;

		gl.glDeleteShader(glSmallComputeShader);
		glSmallComputeShader = -1;

		gl.glDeleteProgram(glSmallComputeProgram);
		glSmallComputeProgram = -1;

		gl.glDeleteShader(glUnorderedComputeShader);
		glUnorderedComputeShader = -1;

		gl.glDeleteProgram(glUnorderedComputeProgram);
		glUnorderedComputeProgram = -1;

		gl.glDeleteShader(glUiVertexShader);
		glUiVertexShader = -1;

		gl.glDeleteShader(glUiFragmentShader);
		glUiFragmentShader = -1;

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
		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, vboUiHandle);
		gl.glBufferData(gl.GL_ARRAY_BUFFER, vboUiBuf.capacity() * Float.BYTES, vboUiBuf, gl.GL_STATIC_DRAW);

		// position attribute
		gl.glVertexAttribPointer(0, 3, gl.GL_FLOAT, false, 5 * Float.BYTES, 0);
		gl.glEnableVertexAttribArray(0);

		// texture coord attribute
		gl.glVertexAttribPointer(1, 2, gl.GL_FLOAT, false, 5 * Float.BYTES, 3 * Float.BYTES);
		gl.glEnableVertexAttribArray(1);

		// unbind VBO
		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, 0);
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

	private void initInterfaceTexture()
	{
		interfaceTexture = glGenTexture(gl);
		gl.glBindTexture(gl.GL_TEXTURE_2D, interfaceTexture);
		gl.glTexParameteri(gl.GL_TEXTURE_2D, gl.GL_TEXTURE_WRAP_S, gl.GL_REPEAT);
		gl.glTexParameteri(gl.GL_TEXTURE_2D, gl.GL_TEXTURE_WRAP_T, gl.GL_REPEAT);
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
		uniformBufferId = glGenBuffers(gl);
		gl.glBindBuffer(gl.GL_UNIFORM_BUFFER, uniformBufferId);
		uniformBuffer.clear();
		uniformBuffer.put(new int[8]);
		final int[] pad = new int[2];
		for (int i = 0; i < 2048; i++)
		{
			uniformBuffer.put(Perspective.SINE[i]);
			uniformBuffer.put(Perspective.COSINE[i]);
			uniformBuffer.put(pad);
		}
		uniformBuffer.flip();

		gl.glBufferData(gl.GL_UNIFORM_BUFFER, uniformBuffer.limit() * Integer.BYTES, uniformBuffer, gl.GL_DYNAMIC_DRAW);
		gl.glBindBuffer(gl.GL_UNIFORM_BUFFER, 0);
	}

	private void initSceneFbo(int width, int height, int aaSamples)
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

	private void shutdownSceneFbo()
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

	private void createProjectionMatrix(float left, float right, float bottom, float top, float near, float far)
	{
		// create a standard orthographic projection
		float tx = -((right + left) / (right - left));
		float ty = -((top + bottom) / (top - bottom));
		float tz = -((far + near) / (far - near));

		gl.glUseProgram(glProgram);

		float[] matrix = new float[]{
			2 / (right - left), 0, 0, 0,
			0, 2 / (top - bottom), 0, 0,
			0, 0, -2 / (far - near), 0,
			tx, ty, tz, 1
		};
		gl.glUniformMatrix4fv(uniProjectionMatrix, 1, false, matrix, 0);

		gl.glUseProgram(0);
	}

	@Override
	public void drawScene(int cameraX, int cameraY, int cameraZ, int cameraPitch, int cameraYaw, int plane)
	{
		centerX = client.getCenterX();
		centerY = client.getCenterY();

		final Scene scene = client.getScene();
		final int drawDistance = Math.max(0, Math.min(MAX_DISTANCE, this.drawDistance));
		scene.setDrawDistance(drawDistance);
	}

	public void drawScenePaint(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z,
							SceneTilePaint paint, int tileZ, int tileX, int tileY,
							int zoom, int centerX, int centerY)
	{
		if (paint.getBufferLen() > 0)
		{
			x = tileX * Perspective.LOCAL_TILE_SIZE;
			y = 0;
			z = tileY * Perspective.LOCAL_TILE_SIZE;

			GpuIntBuffer b = modelBufferUnordered;
			++unorderedModels;

			b.ensureCapacity(8);
			IntBuffer buffer = b.getBuffer();
			buffer.put(paint.getBufferOffset());
			buffer.put(paint.getUvBufferOffset());
			buffer.put(2);
			buffer.put(targetBufferOffset);
			buffer.put(FLAG_SCENE_BUFFER);
			buffer.put(x).put(y).put(z);

			targetBufferOffset += 2 * 3;
		}
	}

	public void drawSceneModel(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z,
							SceneTileModel model, int tileZ, int tileX, int tileY,
							int zoom, int centerX, int centerY)
	{
		if (model.getBufferLen() > 0)
		{
			x = tileX * Perspective.LOCAL_TILE_SIZE;
			y = 0;
			z = tileY * Perspective.LOCAL_TILE_SIZE;

			GpuIntBuffer b = modelBufferUnordered;
			++unorderedModels;

			b.ensureCapacity(8);
			IntBuffer buffer = b.getBuffer();
			buffer.put(model.getBufferOffset());
			buffer.put(model.getUvBufferOffset());
			buffer.put(model.getBufferLen() / 3);
			buffer.put(targetBufferOffset);
			buffer.put(FLAG_SCENE_BUFFER);
			buffer.put(x).put(y).put(z);

			targetBufferOffset += model.getBufferLen();
		}
	}

	@Override
	public void draw()
	{
		if (jawtWindow.getAWTComponent() != client.getCanvas())
		{
			// We inject code in the game engine mixin to prevent the client from doing canvas replacement,
			// so this should not ever be hit
			log.warn("Canvas invalidated!");
			try
			{
				shutDown();
				startUp();
			}
			catch (Exception e)
			{
			}
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

		// If the viewport has changed, update the projection matrix
		if (viewportWidth > 0 && viewportHeight > 0 && (viewportWidth != lastViewportWidth || viewportHeight != lastViewportHeight))
		{
			createProjectionMatrix(0, viewportWidth, viewportHeight, 0, 0, Constants.SCENE_SIZE * Perspective.LOCAL_TILE_SIZE);
			lastViewportWidth = viewportWidth;
			lastViewportHeight = viewportHeight;
		}

		// Setup anti-aliasing
		final AntiAliasingMode antiAliasingMode = this.antiAliasingMode;
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
				|| (lastAntiAliasingMode != null
				&& !lastAntiAliasingMode.equals(antiAliasingMode)))
			{
				shutdownSceneFbo();

				final int maxSamples = glGetInteger(gl);
				final int samples = Math.min(antiAliasingMode.getSamples(), maxSamples);

				initSceneFbo(stretchedCanvasWidth, stretchedCanvasHeight, samples);

				lastStretchedCanvasWidth = stretchedCanvasWidth;
				lastStretchedCanvasHeight = stretchedCanvasHeight;
			}

			gl.glBindFramebuffer(gl.GL_DRAW_FRAMEBUFFER, fboSceneHandle);
		}
		else
		{
			gl.glDisable(gl.GL_MULTISAMPLE);
			shutdownSceneFbo();
		}

		lastAntiAliasingMode = antiAliasingMode;

		// Clear scene
		int sky = client.getSkyboxColor();
		gl.glClearColor((sky >> 16 & 0xFF) / 255f, (sky >> 8 & 0xFF) / 255f, (sky & 0xFF) / 255f, 1f);
		gl.glClear(gl.GL_COLOR_BUFFER_BIT);

		// Upload buffers
		vertexBuffer.flip();
		uvBuffer.flip();
		modelBuffer.flip();
		modelBufferSmall.flip();
		modelBufferUnordered.flip();

		int bufferId = glGenBuffers(gl); // temporary scene vertex buffer
		int uvBufferId = glGenBuffers(gl); // temporary scene uv buffer
		int modelBufferId = glGenBuffers(gl); // scene model buffer, large
		int modelBufferSmallId = glGenBuffers(gl); // scene model buffer, small
		int modelBufferUnorderedId = glGenBuffers(gl);

		IntBuffer vertexBuffer = this.vertexBuffer.getBuffer();
		FloatBuffer uvBuffer = this.uvBuffer.getBuffer();
		IntBuffer modelBuffer = this.modelBuffer.getBuffer();
		IntBuffer modelBufferSmall = this.modelBufferSmall.getBuffer();
		IntBuffer modelBufferUnordered = this.modelBufferUnordered.getBuffer();

		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, bufferId);
		gl.glBufferData(gl.GL_ARRAY_BUFFER, vertexBuffer.limit() * Integer.BYTES, vertexBuffer, gl.GL_STREAM_DRAW);

		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, uvBufferId);
		gl.glBufferData(gl.GL_ARRAY_BUFFER, uvBuffer.limit() * Float.BYTES, uvBuffer, gl.GL_STREAM_DRAW);

		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, modelBufferId);
		gl.glBufferData(gl.GL_ARRAY_BUFFER, modelBuffer.limit() * Integer.BYTES, modelBuffer, gl.GL_STREAM_DRAW);

		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, modelBufferSmallId);
		gl.glBufferData(gl.GL_ARRAY_BUFFER, modelBufferSmall.limit() * Integer.BYTES, modelBufferSmall, gl.GL_STREAM_DRAW);

		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, modelBufferUnorderedId);
		gl.glBufferData(gl.GL_ARRAY_BUFFER, modelBufferUnordered.limit() * Integer.BYTES, modelBufferUnordered, gl.GL_STREAM_DRAW);

		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, 0);

		// allocate target vertex buffer for compute shaders
		int outBufferId = glGenBuffers(gl);
		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, outBufferId);

		gl.glBufferData(gl.GL_ARRAY_BUFFER,
			targetBufferOffset * 16, // each vertex is an ivec4, which is 16 bytes
			null,
			gl.GL_STREAM_DRAW);

		// allocate target uv buffer for compute shaders
		int outUvBufferId = glGenBuffers(gl);
		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, outUvBufferId);
		gl.glBufferData(gl.GL_ARRAY_BUFFER,
			targetBufferOffset * 16,
			null,
			gl.GL_STREAM_DRAW);

		// UBO
		gl.glBindBuffer(gl.GL_UNIFORM_BUFFER, uniformBufferId);
		uniformBuffer.clear();
		uniformBuffer
			.put(client.getCameraYaw())
			.put(client.getCameraPitch())
			.put(centerX)
			.put(centerY)
			.put(client.getScale())
			.put(client.getCameraX2())
			.put(client.getCameraY2())
			.put(client.getCameraZ2());
		uniformBuffer.flip();

		gl.glBufferSubData(gl.GL_UNIFORM_BUFFER, 0, uniformBuffer.limit() * Integer.BYTES, uniformBuffer);
		gl.glBindBuffer(gl.GL_UNIFORM_BUFFER, 0);

		// Draw 3d scene
		final TextureProvider textureProvider = client.getTextureProvider();
		if (textureProvider != null && this.bufferId != -1)
		{
			gl.glUniformBlockBinding(glSmallComputeProgram, uniBlockSmall, 0);
			gl.glUniformBlockBinding(glComputeProgram, uniBlockLarge, 0);

			gl.glBindBufferBase(gl.GL_UNIFORM_BUFFER, 0, uniformBufferId);

			/*
			 * Compute is split into two separate programs 'small' and 'large' to
			 * save on GPU resources. Small will sort <= 512 faces, large will do <= 4096.
			 */

			// unordered
			gl.glUseProgram(glUnorderedComputeProgram);

			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 0, modelBufferUnorderedId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 1, this.bufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 2, bufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 3, outBufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 4, outUvBufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 5, this.uvBufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 6, uvBufferId);

			gl.glDispatchCompute(unorderedModels, 1, 1);

			// small
			gl.glUseProgram(glSmallComputeProgram);

			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 0, modelBufferSmallId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 1, this.bufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 2, bufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 3, outBufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 4, outUvBufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 5, this.uvBufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 6, uvBufferId);

			gl.glDispatchCompute(smallModels, 1, 1);

			// large
			gl.glUseProgram(glComputeProgram);

			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 0, modelBufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 1, this.bufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 2, bufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 3, outBufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 4, outUvBufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 5, this.uvBufferId);
			gl.glBindBufferBase(gl.GL_SHADER_STORAGE_BUFFER, 6, uvBufferId);

			gl.glDispatchCompute(largeModels, 1, 1);

			gl.glMemoryBarrier(gl.GL_SHADER_STORAGE_BARRIER_BIT);

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
			final AnisotropicFilteringMode anisotropicFilteringMode = this.anisotropicFilteringMode;
			final boolean afEnabled = anisotropicFilteringMode != AnisotropicFilteringMode.DISABLED;

			if (lastAnisotropicFilteringMode != null && !lastAnisotropicFilteringMode.equals(anisotropicFilteringMode))
			{
				if (afEnabled)
				{
					switch (anisotropicFilteringMode)
					{
						case BILINEAR:
							gl.glTexParameteri(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_MIN_FILTER, gl.GL_LINEAR_MIPMAP_NEAREST);
							break;
						case TRILINEAR:
							gl.glTexParameteri(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_MIN_FILTER, gl.GL_LINEAR_MIPMAP_LINEAR);
							break;
						default:
							final float maxSamples = glGetFloat(gl);
							final float samples = Math.min(anisotropicFilteringMode.getSamples(), maxSamples);
							gl.glTexParameteri(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_MIN_FILTER, gl.GL_LINEAR_MIPMAP_LINEAR);
							gl.glTexParameterf(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_MAX_ANISOTROPY_EXT, samples);
							break;
					}

					gl.glGenerateMipmap(gl.GL_TEXTURE_2D_ARRAY);
				}
				else
				{
					gl.glTexParameteri(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_MIN_FILTER, gl.GL_NEAREST);
				}
			}

			lastAnisotropicFilteringMode = anisotropicFilteringMode;

			if (client.isStretchedEnabled())
			{
				Dimension dim = client.getStretchedDimensions();
				renderCanvasHeight = dim.height;

				double scaleFactorY = dim.getHeight() / canvasHeight;
				double scaleFactorX = dim.getWidth() / canvasWidth;

				// Pad the viewport a little because having ints for our viewport dimensions can introduce off-by-one errors.
				final int padding = 1;

				// Ceil the sizes because even if the size is 599.1 we want to treat it as size 600 (i.e. render to the x=599 pixel).
				renderViewportHeight = (int) Math.ceil(scaleFactorY * (renderViewportHeight)) + padding * 2;
				renderViewportWidth = (int) Math.ceil(scaleFactorX * (renderViewportWidth)) + padding * 2;

				// Floor the offsets because even if the offset is 4.9, we want to render to the x=4 pixel anyway.
				renderHeightOff = (int) Math.floor(scaleFactorY * (renderHeightOff)) - padding;
				renderWidthOff = (int) Math.floor(scaleFactorX * (renderWidthOff)) - padding;
			}

			glDpiAwareViewport(renderWidthOff, renderCanvasHeight - renderViewportHeight - renderHeightOff, renderViewportWidth, renderViewportHeight);

			gl.glUseProgram(glProgram);

			final int drawDistance = Math.max(0, Math.min(MAX_DISTANCE, this.drawDistance));
			final int fogDepth = this.fogDepth;
			float effectiveDrawDistance = Perspective.LOCAL_TILE_SIZE * Math.min(Constants.SCENE_SIZE / 2, drawDistance);
			gl.glUniform1i(uniUseFog, fogDepth > 0 ? 1 : 0);
			gl.glUniform4f(uniFogColor, (sky >> 16 & 0xFF) / 255f, (sky >> 8 & 0xFF) / 255f, (sky & 0xFF) / 255f, 1f);
			gl.glUniform1f(uniFogDepth, this.fogDepth * 0.01f * effectiveDrawDistance);
			gl.glUniform1f(uniFogCornerRadius, this.fogCircularity * 0.01f * effectiveDrawDistance);
			gl.glUniform1f(uniFogDensity, this.fogDensity * 0.1f);
			gl.glUniform1i(uniDrawDistance, drawDistance * Perspective.LOCAL_TILE_SIZE);

			// Brightness happens to also be stored in the texture provider, so we use that
			gl.glUniform1f(uniBrightness, (float) textureProvider.getBrightness());
			gl.glUniform1f(uniSmoothBanding, this.smoothBanding ? 0f : 1f);

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

			// Draw output of compute shaders
			gl.glBindVertexArray(vaoHandle);

			gl.glEnableVertexAttribArray(0);
			gl.glBindBuffer(gl.GL_ARRAY_BUFFER, outBufferId);
			gl.glVertexAttribIPointer(0, 4, gl.GL_INT, 0, 0);

			gl.glEnableVertexAttribArray(1);
			gl.glBindBuffer(gl.GL_ARRAY_BUFFER, outUvBufferId);
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

		glDeleteBuffer(gl, bufferId);
		glDeleteBuffer(gl, uvBufferId);
		glDeleteBuffer(gl, modelBufferId);
		glDeleteBuffer(gl, modelBufferSmallId);
		glDeleteBuffer(gl, modelBufferUnorderedId);
		glDeleteBuffer(gl, outBufferId);
		glDeleteBuffer(gl, outUvBufferId);

		// Texture on UI
		drawUi(canvasHeight, canvasWidth);

		glDrawable.swapBuffers();

		drawManager.processDrawComplete(this::screenshot);
	}

	private void drawUi(final int canvasHeight, final int canvasWidth)
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

		if (canvasWidth != lastCanvasWidth || canvasHeight != lastCanvasHeight)
		{
			gl.glTexImage2D(gl.GL_TEXTURE_2D, 0, gl.GL_RGBA, width, height, 0, gl.GL_BGRA, gl.GL_UNSIGNED_INT_8_8_8_8_REV, interfaceBuffer);
			lastCanvasWidth = canvasWidth;
			lastCanvasHeight = canvasHeight;
		}
		else
		{
			gl.glTexSubImage2D(gl.GL_TEXTURE_2D, 0, 0, 0, width, height, gl.GL_BGRA, gl.GL_UNSIGNED_INT_8_8_8_8_REV, interfaceBuffer);
		}

		if (client.isStretchedEnabled())
		{
			Dimension dim = client.getStretchedDimensions();
			glDpiAwareViewport(0, 0, dim.width, dim.height);
		}
		else
		{
			glDpiAwareViewport(0, 0, canvasWidth, canvasHeight);
		}

		// Use the texture bound in the first pass
		gl.glUseProgram(glUiProgram);
		gl.glUniform1i(uniTex, 0);

		// Set the sampling function used when stretching the UI.
		// This is probably better done with sampler objects instead of texture parameters, but this is easier and likely more portable.
		// See https://www.khronos.org/opengl/wiki/Sampler_Object for details.
		if (client.isStretchedEnabled())
		{
			final int function = client.isStretchedFast() ? gl.GL_NEAREST : gl.GL_LINEAR;
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
		int width = client.getCanvasWidth();
		int height = client.getCanvasHeight();

		if (client.isStretchedEnabled())
		{
			Dimension dim = client.getStretchedDimensions();
			width = dim.width;
			height = dim.height;
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

	private void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		uploadScene();
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

		if (bufferId != -1)
		{
			GLUtil.glDeleteBuffer(gl, bufferId);
			bufferId = -1;
		}

		if (uvBufferId != -1)
		{
			GLUtil.glDeleteBuffer(gl, uvBufferId);
			uvBufferId = -1;
		}

		bufferId = glGenBuffers(gl);
		uvBufferId = glGenBuffers(gl);

		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, bufferId);
		gl.glBufferData(gl.GL_ARRAY_BUFFER, vertexBuffer.limit() * Integer.BYTES, vertexBuffer, gl.GL_STATIC_COPY);

		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, uvBufferId);
		gl.glBufferData(gl.GL_ARRAY_BUFFER, uvBuffer.limit() * Float.BYTES, uvBuffer, gl.GL_STATIC_COPY);

		gl.glBindBuffer(gl.GL_ARRAY_BUFFER, 0);

		vertexBuffer.clear();
		uvBuffer.clear();
	}

	/**
	 * Check is a model is visible and should be drawn.
	 */
	private boolean isNotVisible(Model model, int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int _x, int _y, int _z, long hash)
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
						return var22 / var14 >= Rasterizer3D_clipMidY2;
					}
				}
			}
		}
		return true;
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
		// Model may be in the scene buffer
		if (renderable instanceof Model && ((Model) renderable).getSceneId() == sceneUploader.sceneId)
		{
			Model model = (Model) renderable;

			model.calculateBoundsCylinder();
			model.calculateExtreme(orientation);

			if (isNotVisible(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash))
			{
				return;
			}

			client.checkClickbox(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash);

			int tc = Math.min(MAX_TRIANGLE, model.getTrianglesCount());
			int uvOffset = model.getUvBufferOffset();
			boolean hasUv = model.getFaceTextures() != null;

			// Speed hack: the scene uploader splits up large models with no priorities
			// based on face height, and then we sort each smaller set of faces
			if (tc > SMALL_TRIANGLE_COUNT && model.getFaceRenderPriorities() == null)
			{
				int left = tc;
				int off = 0;
				while (left > 0)
				{
					tc = Math.min(SMALL_TRIANGLE_COUNT, left);

					GpuIntBuffer b = bufferForTriangles(tc);
					b.ensureCapacity(8);
					IntBuffer buffer = b.getBuffer();
					buffer.put(model.getBufferOffset() + off);
					buffer.put(hasUv ? uvOffset + off : -1);
					buffer.put(tc);
					buffer.put(targetBufferOffset);
					buffer.put(FLAG_SCENE_BUFFER | (model.getRadius() << 12) | orientation);
					buffer.put(x + client.getCameraX2()).put(y + client.getCameraY2()).put(z + client.getCameraZ2());

					targetBufferOffset += tc * 3;

					off += tc * 3;
					left -= tc;
				}
				return;
			}

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
				model.setModelHeight(model.getModelHeight());

				model.calculateBoundsCylinder();
				model.calculateExtreme(orientation);

				if (isNotVisible(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash))
				{
					return;
				}

				client.checkClickbox(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash);

				boolean hasUv = model.getFaceTextures() != null;

				int faces = Math.min(MAX_TRIANGLE, model.getTrianglesCount());
				vertexBuffer.ensureCapacity(12 * faces);
				uvBuffer.ensureCapacity(12 * faces);
				int len = 0;
				for (int i = 0; i < faces; ++i)
				{
					len += sceneUploader.pushFace(model, i, vertexBuffer, uvBuffer);
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
		final AffineTransform t = ((Graphics2D) canvas.getGraphics()).getTransform();
		gl.glViewport(
			getScaledValue(t.getScaleX(), x),
			getScaledValue(t.getScaleY(), y),
			getScaledValue(t.getScaleX(), width),
			getScaledValue(t.getScaleY(), height));
	}
}
