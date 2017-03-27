/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.modelviewer;

import com.google.gson.Gson;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.definitions.NpcDefinition;
import net.runelite.cache.definitions.ObjectDefinition;
import net.runelite.cache.definitions.OverlayDefinition;
import net.runelite.cache.definitions.TextureDefinition;
import net.runelite.cache.definitions.UnderlayDefinition;
import net.runelite.cache.definitions.loaders.ModelLoader;
import net.runelite.cache.models.Vector3f;
import net.runelite.cache.models.VertexNormal;
import net.runelite.cache.region.Location;
import net.runelite.cache.region.Position;
import net.runelite.cache.region.Region;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.compress.utils.IOUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_S;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_T;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL12.GL_CLAMP_TO_EDGE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelViewer
{
	private static final Logger logger = LoggerFactory.getLogger(ModelViewer.class);

	private static final int NUM_UNDERLAYS = 150;
	private static final int NUM_OVERLAYS = 174;
	private static final int NUM_TEXTURES = 61;
	private static final int NUM_OBJECTS = 28598;
	private static final int NUM_MODELS = 31247;

	/**
	 * size of a tile in model coordinates
	 */
	private static final int TILE_SCALE = 128;
	private static final int HEIGHT_MOD = 4;

	private static UnderlayDefinition[] underlays = new UnderlayDefinition[NUM_UNDERLAYS];
	private static OverlayDefinition[] overlays = new OverlayDefinition[NUM_OVERLAYS];

	private static Map<Integer, Texture> textures = new HashMap<>();
	private static ObjectDefinition[] objects = new ObjectDefinition[NUM_OBJECTS];
	private static ModelDefinition[] models = new ModelDefinition[NUM_MODELS];

	public static void main(String[] args) throws Exception
	{
		Options options = new Options();

		options.addOption(null, "npcdir", true, "npc directory");
		options.addOption(null, "mapdir", true, "maps directory");
		options.addOption(null, "objectdir", true, "objects directory");

		options.addOption(null, "npc", true, "npc to render");
		options.addOption(null, "object", true, "object to render");
		options.addOption(null, "model", true, "model to render");
		options.addOption(null, "map", true, "map region to render");

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);

		String npcdir = cmd.getOptionValue("npcdir");
		String mapdir = cmd.getOptionValue("mapdir");
		String objectdir = cmd.getOptionValue("objectdir");

		NpcDefinition npcdef = null;
		ObjectDefinition objdef = null;

		List<ModelDefinition> models = new ArrayList<>();
		Region region = null;

		if (cmd.hasOption("model"))
		{
			// render model
			String model = cmd.getOptionValue("model");

			ModelDefinition md = getModel(Integer.parseInt(model));
			models.add(md);
		}
		if (cmd.hasOption("npc"))
		{
			String npc = cmd.getOptionValue("npc");

			try (FileInputStream fin = new FileInputStream(npcdir + "/" + npc + ".json"))
			{
				npcdef = new Gson().fromJson(new InputStreamReader(fin), NpcDefinition.class);
			}

			for (int model : npcdef.models)
			{
				ModelDefinition md = getModel(model);
				models.add(md);
			}
		}
		if (cmd.hasOption("object"))
		{
			String obj = cmd.getOptionValue("object");

			try (FileInputStream fin = new FileInputStream(objectdir + "/" + obj + ".json"))
			{
				objdef = new Gson().fromJson(new InputStreamReader(fin), ObjectDefinition.class);
			}

			for (int model : objdef.getObjectModels())
			{
				ModelDefinition md = getModel(model);
				models.add(md);
			}
		}
		if (cmd.hasOption("map"))
		{
			String map = cmd.getOptionValue("map");
			String[] s = map.split(",");

			int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);

			region = new Region(x, y);

			try (FileInputStream fin = new FileInputStream(mapdir + "/m" + x + "_" + y + ".dat"))
			{
				byte[] b = IOUtils.toByteArray(fin);
				region.loadTerrain(b);
			}

			try (FileInputStream fin = new FileInputStream(mapdir + "/l" + x + "_" + y + ".dat"))
			{
				byte[] b = IOUtils.toByteArray(fin);
				region.loadLocations(b);
			}
			catch (FileNotFoundException ex)
			{
				logger.info("No landscape file for {},{}", x, y);
			}

			loadUnderlays();
			loadOverlays();
		}

		Display.setDisplayMode(new DisplayMode(800, 600));
		Display.setTitle("Model Viewer");
		Display.setInitialBackground((float) Color.gray.getRed() / 255f, (float) Color.gray.getGreen() / 255f, (float) Color.gray.getBlue() / 255f);
		Display.create();

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		double aspect = 1;
		double near = 1; // near should be chosen as far into the scene as possible
		double far = 10000;
		double fov = 1; // 1 gives you a 90° field of view. It's tan(fov_angle)/2.
		GL11.glFrustum(-aspect * near * fov, aspect * near * fov, -fov, fov, near, far);
		GL11.glPopMatrix();

		GL11.glEnable(GL11.GL_DEPTH_TEST);

		GL11.glCullFace(GL11.GL_BACK);
		GL11.glEnable(GL11.GL_CULL_FACE);
		long last = 0;

		Camera camera = new Camera();

		while (!Display.isCloseRequested())
		{
			// Clear the screen and depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			for (ModelDefinition def : models)
			{
				short[] recolourToFind = null, recolourToReplace = null;
				if (npcdef != null)
				{
					recolourToFind = npcdef.recolorToFind;
					recolourToReplace = npcdef.recolorToReplace;
				}
				if (objdef != null)
				{
					recolourToFind = objdef.getRecolorToFind();
					recolourToReplace = objdef.getRecolorToReplace();
				}

				drawModel(def, recolourToFind, recolourToReplace);
			}

			drawRegion(region);

			Display.update();
			Display.sync(50); // fps

			long delta = System.currentTimeMillis() - last;
			last = System.currentTimeMillis();

			camera.acceptInput(delta);
			camera.apply();
		}

		Display.destroy();
	}

	private static void drawModel(ModelDefinition md, short[] recolourToFind, short[] recolourToReplace)
	{
		for (int i = 0; i < md.faceCount; ++i)
		{
			int vertexA = md.faceVertexIndices1[i];
			int vertexB = md.faceVertexIndices2[i];
			int vertexC = md.faceVertexIndices3[i];

			VertexNormal normalVertexA = md.vertexNormals[vertexA];
			VertexNormal normalVertexB = md.vertexNormals[vertexB];
			VertexNormal normalVertexC = md.vertexNormals[vertexC];

			Vector3f nA = normalVertexA.normalize();
			Vector3f nB = normalVertexB.normalize();
			Vector3f nC = normalVertexC.normalize();

			// Invert y
			nA.y = -nA.y;
			nB.y = -nB.y;
			nC.y = -nC.y;

			int vertexAx = md.vertexPositionsX[vertexA];
			int vertexAy = md.vertexPositionsY[vertexA];
			int vertexAz = md.vertexPositionsZ[vertexA];

			int vertexBx = md.vertexPositionsX[vertexB];
			int vertexBy = md.vertexPositionsY[vertexB];
			int vertexBz = md.vertexPositionsZ[vertexB];

			int vertexCx = md.vertexPositionsX[vertexC];
			int vertexCy = md.vertexPositionsY[vertexC];
			int vertexCz = md.vertexPositionsZ[vertexC];

			short textureId = md.faceTextures[i];
			Color color;

			float[] u = null;
			float[] v = null;

			if (textureId != -1)
			{
				color = Color.WHITE;

				Texture texture = getTexture(textureId);
				assert texture != null;

				u = md.faceTextureUCoordinates[i];
				v = md.faceTextureVCoordinates[i];

				int glTexture = texture.getOpenglId();

				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, glTexture);
			}
			else
			{
				short hsb = md.faceColors[i];

				// Check recolor
				if (recolourToFind != null)
				{
					for (int j = 0; j < recolourToFind.length; ++j)
					{
						if (recolourToFind[j] == hsb)
						{
							hsb = recolourToReplace[j];
						}
					}
				}

				int rgb = RS2HSB_to_RGB(hsb);
				color = new Color(rgb);
			}

			// convert to range of 0-1
			float rf = (float) color.getRed() / 255f;
			float gf = (float) color.getGreen() / 255f;
			float bf = (float) color.getBlue() / 255f;

			GL11.glBegin(GL11.GL_TRIANGLES);

			GL11.glColor3f(rf, gf, bf);

			// With GL11.GL_CCW we have to draw A -> C -> B when
			// inverting y instead of A -> B -> C, or else with cull
			// face will cull the wrong side
			GL11.glNormal3f(nA.x, nA.y, nA.z);
			if (textureId != -1)
			{
				GL11.glTexCoord2f(u[0], v[0]);
			}
			GL11.glVertex3i(vertexAx, -vertexAy, vertexAz);

			GL11.glNormal3f(nC.x, nC.y, nC.z);
			if (textureId != -1)
			{
				GL11.glTexCoord2f(u[2], v[2]);
			}
			GL11.glVertex3i(vertexCx, -vertexCy, vertexCz);

			GL11.glNormal3f(nB.x, nB.y, nB.z);
			if (textureId != -1)
			{
				GL11.glTexCoord2f(u[1], v[1]);
			}
			GL11.glVertex3i(vertexBx, -vertexBy, vertexBz);

			GL11.glEnd();

			if (textureId != -1)
			{
				GL11.glDisable(GL11.GL_TEXTURE_2D);
			}
		}
	}

	private static void drawRegion(Region region)
	{
		if (region == null)
		{
			return;
		}

		for (int regionX = 0; regionX < Region.X; ++regionX)
		{
			for (int regionY = 0; regionY < Region.Y; ++regionY)
			{
				int x = regionX;
				int y = regionY;

				x *= TILE_SCALE;
				y *= TILE_SCALE;

				/*
				 Split into two triangles with verticies
				 x,y,z1   x+1,y,z2 x,y+1,z3
				 x,y+1,z3 x+1,y,z2 x+1,y+1,z4
				
				 z1 = height
				 z2 = height of tile x+1
				 z3 = height of tile y-1
				
				 in rs 0,0 (x,y) is the bottom left with
				 y increasing going further from you
				
				 in opengl, 0,0 (x,z) is the bottom left
				 with z decreasing going further from you
				
				 in rs, height is also negative
				
				 so we do rs(x,y,z) -> opengl(x,-z,-y)
				 */
				int z1 = -region.getTileHeight(0, regionX, regionY);
				int z2 = regionX + 1 < Region.X ? -region.getTileHeight(0, regionX + 1, regionY) : z1;
				int z3 = regionY + 1 < Region.Y ? -region.getTileHeight(0, regionX, regionY + 1) : z1;
				int z4 = regionX + 1 < Region.X && regionY + 1 < Region.Y ? -region.getTileHeight(0, regionX + 1, regionY + 1) : z1;

				// scale down height
				z1 /= HEIGHT_MOD;
				z2 /= HEIGHT_MOD;
				z3 /= HEIGHT_MOD;
				z4 /= HEIGHT_MOD;

				int underlayId = region.getUnderlayId(0, regionX, regionY);
				int overlayId = region.getOverlayId(0, regionX, regionY);

				Color color = null;
				int glTexture = -1;

				if (underlayId > 0)
				{
					UnderlayDefinition ud = underlays[underlayId - 1];
					color = new Color(ud.getColor());
				}
				if (overlayId > 0)
				{
					OverlayDefinition od = overlays[overlayId - 1];
					color = new Color(od.getRgbColor());

					if (od.getSecondaryRgbColor() > -1)
					{
						color = new Color(od.getSecondaryRgbColor());
					}

					if (od.getTexture() > -1)
					{
						color = Color.WHITE;

						Texture texture = getTexture(od.getTexture());
						glTexture = texture.getOpenglId();
						assert glTexture > -1;

						GL11.glEnable(GL11.GL_TEXTURE_2D);
						GL11.glBindTexture(GL11.GL_TEXTURE_2D, glTexture);
					}
				}

				GL11.glBegin(GL11.GL_TRIANGLES);

				if (color != null)
				{
					GL11.glColor3f((float) color.getRed() / 255f, (float) color.getGreen() / 255f, (float) color.getBlue() / 255f);
				}

				// triangle 1
				if (glTexture > -1)
				{
					GL11.glTexCoord2f(0, 0);
				}
				GL11.glVertex3i(x, z1, -y);
				if (glTexture > -1)
				{
					GL11.glTexCoord2f(1, 0);
				}
				GL11.glVertex3i(x + TILE_SCALE, z2, -y);
				if (glTexture > -1)
				{
					GL11.glTexCoord2f(0, 1);
				}
				GL11.glVertex3i(x, z3, -(y + TILE_SCALE));

				// triangle 2
				if (glTexture > -1)
				{
					GL11.glTexCoord2f(0, 1);
				}
				GL11.glVertex3i(x, z3, -(y + TILE_SCALE));
				if (glTexture > -1)
				{
					GL11.glTexCoord2f(1, 0);
				}
				GL11.glVertex3i(x + TILE_SCALE, z2, -y);
				if (glTexture > -1)
				{
					GL11.glTexCoord2f(1, 1);
				}
				GL11.glVertex3i(x + TILE_SCALE, z4, -(y + TILE_SCALE));

				GL11.glEnd();

				if (glTexture > -1)
				{
					GL11.glDisable(GL11.GL_TEXTURE_2D);
				}

			}
		}

		drawLocations(region);
	}

	private static void drawLocations(Region region)
	{
		for (Location location : region.getLocations())
		{
			int id = location.getId();
			ObjectDefinition object = getObject(id);

			if (object == null || object.getObjectModels() == null)
			{
				continue;
			}

			Position objectPos = location.getPosition();

			if (location.getPosition().getZ() != 0)
			{
				continue;
			}

			int regionX = objectPos.getX() - region.getBaseX();
			int regionY = objectPos.getY() - region.getBaseY();
			int height = -region.getTileHeight(objectPos.getZ(), regionX, regionY) / HEIGHT_MOD;

			//byte overlayRotation = region.getOverlayRotation(objectPos.getZ(), regionX, regionY);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);

			// TILE_SCALE/2 to draw the object from the center of the tile it is on
			GL11.glTranslatef(regionX * TILE_SCALE + (TILE_SCALE / 2), height, -regionY * TILE_SCALE - (TILE_SCALE / 2));

			for (int i = 0; i < object.getObjectModels().length; ++i)
			{
				ModelDefinition md = getModel(object.getObjectModels()[i]);

				if (object.getObjectTypes() != null)
				{
					if (object.getObjectTypes()[i] != location.getType())
					{
						continue;
					}
				}

				drawModel(md, object.getRecolorToFind(), object.getRecolorToReplace());
			}

			GL11.glTranslatef(-regionX * TILE_SCALE - (TILE_SCALE / 2), -height, regionY * TILE_SCALE + (TILE_SCALE / 2));
			GL11.glPopMatrix();
		}
	}

	private static void loadUnderlays() throws IOException
	{
		for (int i = 0; i < NUM_UNDERLAYS; ++i)
		{
			try (FileInputStream fin = new FileInputStream("underlays/" + i + ".json"))
			{
				UnderlayDefinition underlay = new Gson().fromJson(new InputStreamReader(fin), UnderlayDefinition.class);
				underlays[i] = underlay;
			}
			catch (FileNotFoundException ex)
			{
			}
		}
	}

	private static void loadOverlays() throws IOException
	{
		for (int i = 0; i < NUM_OVERLAYS; ++i)
		{
			try (FileInputStream fin = new FileInputStream("overlays/" + i + ".json"))
			{
				OverlayDefinition overlay = new Gson().fromJson(new InputStreamReader(fin), OverlayDefinition.class);
				overlays[i] = overlay;
			}
			catch (FileNotFoundException ex)
			{
			}
		}
	}

	private static ObjectDefinition getObject(int id)
	{
		ObjectDefinition object = objects[id];
		if (object != null)
		{
			return object;
		}

		try (FileInputStream fin = new FileInputStream("objects/" + id + ".json"))
		{
			object = new Gson().fromJson(new InputStreamReader(fin), ObjectDefinition.class);
			objects[id] = object;
			return object;
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
			return null;
		}
	}

	private static ModelDefinition getModel(int id)
	{
		ModelDefinition md = models[id];
		if (md != null)
		{
			return md;
		}

		try
		{
			byte[] b = Files.readAllBytes(new File("models/" + id + ".model").toPath());

			ModelLoader loader = new ModelLoader();
			md = loader.load(id, b);

			md.computeNormals();
			md.computeTextureUVCoordinates();

			models[id] = md;
			return md;
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
			return null;
		}
	}

	private static Texture getTexture(int id)
	{
		Texture texture = textures.get(id);
		if (texture != null)
		{
			return texture;
		}

		TextureDefinition td;
		try (FileInputStream fin = new FileInputStream("textures/" + id + ".json"))
		{
			td = new Gson().fromJson(new InputStreamReader(fin), TextureDefinition.class);
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
			return null;
		}

		try (FileInputStream fin = new FileInputStream("sprite/" + td.getFileIds()[0] + "-0.png"))
		{
			BufferedImage image = ImageIO.read(fin);

			int width = image.getWidth();
			int height = image.getHeight();
			int[] rgb = new int[width * height];

			int[] out = image.getRGB(0, 0, width, height, rgb, 0, width);
			assert rgb == out;

			ByteBuffer buffer = ByteBuffer.allocateDirect(rgb.length * 4);
			for (int i = 0; i < rgb.length; ++i)
			{
				int pixel = rgb[i];

				// argb -> rgba
				int a = pixel >>> 24;
				int r = (pixel >> 16) & 0xff;
				int g = (pixel >> 8) & 0xff;
				int b = pixel & 0xff;

				buffer.put((byte) r);
				buffer.put((byte) g);
				buffer.put((byte) b);
				buffer.put((byte) a);
			}
			buffer.position(0);

			int glTexture = GL11.glGenTextures();
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, glTexture);

			//Setup filtering, i.e. how OpenGL will interpolate the pixels when scaling up or down
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

			//Setup wrap mode, i.e. how OpenGL will handle pixels outside of the expected range
			//Note: GL_CLAMP_TO_EDGE is part of GL12
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);

			GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, width, height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer);

			GL11.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR); // Linear Filtering
			GL11.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR); // Linear Filtering

			texture = new Texture(rgb, width, height, glTexture);
			textures.put(id, texture);

			return texture;
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
			return null;
		}
	}

	// found these two functions here https://www.rune-server.org/runescape-development/rs2-client/tools/589900-rs2-hsb-color-picker.html
	public static int RGB_to_RS2HSB(int red, int green, int blue)
	{
		float[] HSB = Color.RGBtoHSB(red, green, blue, null);
		float hue = (HSB[0]);
		float saturation = (HSB[1]);
		float brightness = (HSB[2]);
		int encode_hue = (int) (hue * 63);			//to 6-bits
		int encode_saturation = (int) (saturation * 7);		//to 3-bits
		int encode_brightness = (int) (brightness * 127); 	//to 7-bits
		return (encode_hue << 10) + (encode_saturation << 7) + (encode_brightness);
	}

	public static int RS2HSB_to_RGB(int RS2HSB)
	{
		int decode_hue = (RS2HSB >> 10) & 0x3f;
		int decode_saturation = (RS2HSB >> 7) & 0x07;
		int decode_brightness = (RS2HSB & 0x7f);
		return Color.HSBtoRGB((float) decode_hue / 63, (float) decode_saturation / 7, (float) decode_brightness / 127);
	}
}
