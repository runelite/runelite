/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
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

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.runelite.cache.ConfigType;
import net.runelite.cache.IndexType;
import net.runelite.cache.NpcManager;
import net.runelite.cache.ObjectManager;
import net.runelite.cache.OverlayManager;
import net.runelite.cache.SpriteManager;
import net.runelite.cache.TextureManager;
import net.runelite.cache.UnderlayManager;
import net.runelite.cache.definitions.FrameDefinition;
import net.runelite.cache.definitions.FramemapDefinition;
import net.runelite.cache.definitions.KitDefinition;
import net.runelite.cache.definitions.LocationsDefinition;
import net.runelite.cache.definitions.MapDefinition;
import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.definitions.NpcDefinition;
import net.runelite.cache.definitions.ObjectDefinition;
import net.runelite.cache.definitions.SequenceDefinition;
import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.definitions.TextureDefinition;
import net.runelite.cache.definitions.loaders.FrameLoader;
import net.runelite.cache.definitions.loaders.FramemapLoader;
import net.runelite.cache.definitions.loaders.LocationsLoader;
import net.runelite.cache.definitions.loaders.MapLoader;
import net.runelite.cache.definitions.loaders.SequenceLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.ArchiveFiles;
import net.runelite.cache.fs.FSFile;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.models.Vector3f;
import net.runelite.cache.models.VertexNormal;
import net.runelite.cache.region.Location;
import net.runelite.cache.region.Position;
import net.runelite.cache.region.Region;
import net.runelite.cache.util.XteaKeyManager;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
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

	/**
	 * size of a tile in local coordinates
	 */
	private static final int TILE_SCALE = 128;

	private static ObjectManager objectManager;
	private static TextureManager textureManager;
	private static SpriteManager spriteManager;
	private static ModelManager modelManager;

	private static Map<Integer, Texture> textures = new HashMap<>();
	private static Map<Integer, SequenceDefinition> seqs = new HashMap<>();
	private static Multimap<Integer, FrameDefinition> frames = HashMultimap.create();

	public static void main(String[] args) throws Exception
	{
		Options options = new Options();

		options.addOption(null, "store", true, "store directory");

		options.addOption(null, "objectdir", true, "objects directory");

		options.addOption(null, "npc", true, "npc to render");
		options.addOption(null, "object", true, "object to render");
		options.addOption(null, "model", true, "model to render");
		options.addOption(null, "map", true, "map region to render");
		options.addOption(null, "kits", true, "kits to render");
		options.addOption(null, "seq", true, "sequence id");

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);

		NpcDefinition npcdef = null;
		ObjectDefinition objdef = null;
		Store store = null;
		UnderlayManager underlayManager = null;
		OverlayManager overlayManager = null;
		NpcManager npcManager = null;
		Integer seq = null;

		List<ModelDefinition> models = new ArrayList<>();
		Region region = null;

		if (cmd.hasOption("store"))
		{
			store = new Store(new File(cmd.getOptionValue("store")));
			store.load();

			underlayManager = new UnderlayManager(store);
			underlayManager.load();

			overlayManager = new OverlayManager(store);
			overlayManager.load();

			objectManager = new ObjectManager(store);
			objectManager.load();

			textureManager = new TextureManager(store);
			textureManager.load();

			spriteManager = new SpriteManager(store);
			spriteManager.load();

			npcManager = new NpcManager(store);
			npcManager.load();

			modelManager = new ModelManager(store);

			if (cmd.hasOption("seq"))
			{
				loadSeqs(store);
				loadFrames(store);
			}
		}
		if (cmd.hasOption("model"))
		{
			// render model
			String model = cmd.getOptionValue("model");

			ModelDefinition md = modelManager.getModel(Integer.parseInt(model), null, null);
			models.add(md);
		}
		if (cmd.hasOption("npc"))
		{
			String npc = cmd.getOptionValue("npc");

			npcdef = npcManager.get(Integer.parseInt(npc));

			for (int model : npcdef.models)
			{
				ModelDefinition md = modelManager.getModel(model, null, null);
				models.add(md);
			}
		}
		if (cmd.hasOption("object"))
		{
			String obj = cmd.getOptionValue("object");

			objdef = objectManager.getObject(Integer.parseInt(obj));

			for (int model : objdef.getObjectModels())
			{
				ModelDefinition md = modelManager.getModel(model, null, null);
				models.add(md);
			}
		}
		if (cmd.hasOption("map"))
		{
			String map = cmd.getOptionValue("map");
			String[] s = map.split(",");

			int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);

			XteaKeyManager keyManager = new XteaKeyManager();
			keyManager.loadKeys();

			int[] keys = keyManager.getKeys(x << 8 | y);

			Storage storage = store.getStorage();
			Index index = store.getIndex(IndexType.MAPS);

			Archive mapArchive = index.findArchiveByName("m" + x + "_" + y);
			Archive locationsArchive = index.findArchiveByName("l" + x + "_" + y);

			region = new Region(x, y);

			byte[] mapData = mapArchive.decompress(storage.loadArchive(mapArchive));
			MapLoader mapLoader = new MapLoader();
			MapDefinition mapDef = mapLoader.load(x, y, mapData);
			region.loadTerrain(mapDef);

			if (keys != null)
			{
				byte[] locationData = locationsArchive.decompress(storage.loadArchive(locationsArchive), keys);
				LocationsLoader locationsLoader = new LocationsLoader();
				LocationsDefinition locDef = locationsLoader.load(x, y, locationData);
				region.loadLocations(locDef);
			}
		}
		if (cmd.hasOption("kits"))
		{
			String kits = cmd.getOptionValue("kits");
			Integer[] kitIds = Arrays.stream(kits.split(",")).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);

			for (int kitId : kitIds)
			{
				KitDefinition kit = KitManager.getKit(kitId);
				for (int model : kit.modelIds)
				{
					ModelDefinition md = modelManager.getModel(model, null, null);
					models.add(md);
				}
			}
		}
		if (cmd.hasOption("seq"))
		{
			seq = Integer.parseInt(cmd.getOptionValue("seq"));
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

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		long last = 0;

		Camera camera = new Camera();
		Scene scene = null;
		if (region != null)
		{
			scene = new Scene(underlayManager, overlayManager);
			scene.loadRegion(region);
		}

		SequenceDefinition sequenceDefinition = null;
		int frameCount = 0;
		int frameLength = 0;
		if (seq != null)
		{
			sequenceDefinition = seqs.get(seq);
			frameCount = 0;
			frameLength = sequenceDefinition.frameLenghts[0];
		}

		while (!Display.isCloseRequested())
		{
			// Clear the screen and depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			if (seq != null)
			{
				if (frameLength-- <= 0)
				{
					frameCount++;
					frameLength = sequenceDefinition.frameLenghts[frameCount % sequenceDefinition.frameIDs.length];
				}

				int seqFrameId = sequenceDefinition.frameIDs[frameCount % sequenceDefinition.frameIDs.length];
				Collection<FrameDefinition> frames = ModelViewer.frames.get(seqFrameId >>> 16);
				int frameFileId = seqFrameId & 65535;

				Optional<FrameDefinition> first = frames.stream().filter(frame -> frame.id == frameFileId).findFirst();
				FrameDefinition frame = first.get();
				FramemapDefinition framemap = frame.framemap;

				ModelDefinition.animOffsetX = ModelDefinition.animOffsetY = ModelDefinition.animOffsetZ = 0;

				for (ModelDefinition def : models)
				{
					def.resetAnim();
				}
				for (int i = 0; i < frame.translatorCount; ++i)
				{
					int type = frame.indexFrameIds[i];
					int fmType = framemap.types[type];
					int[] fm = framemap.frameMaps[type];
					int dx = frame.translator_x[i];
					int dy = frame.translator_y[i];
					int dz = frame.translator_z[i];

					for (ModelDefinition def : models)
					{
						def.animate(fmType, fm, dx, dy, dz);
					}
				}
			}

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

			if (region != null)
			{
				drawScene(region, scene);
			}

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
			if (md.faceRenderTypes != null)
			{
				byte faceRenderType = md.faceRenderTypes[i];

				if ((faceRenderType & 2) != 0)
				{
					continue; // what is this?
				}
			}

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

			// and z
			nA.z = -nA.z;
			nB.z = -nB.z;
			nC.z = -nC.z;

			int vertexAx = md.vertexPositionsX[vertexA];
			int vertexAy = md.vertexPositionsY[vertexA];
			int vertexAz = md.vertexPositionsZ[vertexA];

			int vertexBx = md.vertexPositionsX[vertexB];
			int vertexBy = md.vertexPositionsY[vertexB];
			int vertexBz = md.vertexPositionsZ[vertexB];

			int vertexCx = md.vertexPositionsX[vertexC];
			int vertexCy = md.vertexPositionsY[vertexC];
			int vertexCz = md.vertexPositionsZ[vertexC];

			short textureId = md.faceTextures != null ? md.faceTextures[i] : -1;
			int alpha = md.faceAlphas != null ? (md.faceAlphas[i] & 0xFF) : 255;
			if (alpha == 0)
			{
				alpha = 255;
			}

			Color color;

			float[] u = null;
			float[] v = null;

			if (textureId != -1)
			{
				color = Color.WHITE;

				Texture texture = getTexture(textureId);
				assert texture != null;

				if (md.faceTextureUCoordinates == null || md.faceTextureVCoordinates == null)
				{
					md.computeTextureUVCoordinates();
				}

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
			float af = (float) alpha / 255f;

			GL11.glBegin(GL11.GL_TRIANGLES);

			GL11.glColor4f(rf, gf, bf, af);

			GL11.glNormal3f(nA.x, nA.y, nA.z);
			if (textureId != -1)
			{
				GL11.glTexCoord2f(u[0], v[0]);
			}
			GL11.glVertex3i(vertexAx, -vertexAy, -vertexAz);

			GL11.glNormal3f(nB.x, nB.y, nB.z);
			if (textureId != -1)
			{
				GL11.glTexCoord2f(u[1], v[1]);
			}
			GL11.glVertex3i(vertexBx, -vertexBy, -vertexBz);

			GL11.glNormal3f(nC.x, nC.y, nC.z);
			if (textureId != -1)
			{
				GL11.glTexCoord2f(u[2], v[2]);
			}
			GL11.glVertex3i(vertexCx, -vertexCy, -vertexCz);

			GL11.glEnd();

			if (textureId != -1)
			{
				GL11.glDisable(GL11.GL_TEXTURE_2D);
			}
		}
	}

	private static void drawScene(Region region, Scene scene)
	{
		for (int z = 0; z < Region.Z; ++z)
		{
			SceneTileModel[][] sceneTileModels = scene.getSceneTiles()[z];
			SceneTilePaint[][] sceneTilePaint = scene.getSceneTilePaint()[z];

			for (int x = 0; x < Region.X; ++x)
			{
				for (int y = 0; y < Region.Y; ++y)
				{
					drawSceneTileModel(region, x, y, z, sceneTileModels[x][y]);
					drawSceneTilePaint(region, x, y, z, sceneTilePaint[x][y]);
				}
			}
		}
		drawLocations(region);

	}

	private static void drawSceneTilePaint(Region region, int regionX, int regionY, int z, SceneTilePaint sceneTilePaint)
	{
		if (sceneTilePaint == null)
		{
			return;
		}

		int glTexture = -1;

		Color color;

		if (sceneTilePaint.texture > -1)
		{
			color = Color.WHITE;

			Texture texture = getTexture(sceneTilePaint.texture);
			glTexture = texture.getOpenglId();
			assert glTexture > -1;

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, glTexture);
		}
		else
		{
			color = new Color(RS2HSB_to_RGB(sceneTilePaint.color));
		}


		GL11.glBegin(GL11.GL_TRIANGLES);

		int x = regionX * TILE_SCALE;
		int y = regionY * TILE_SCALE;

		GL11.glColor3f((float) color.getRed() / 255f, (float) color.getGreen() / 255f, (float) color.getBlue() / 255f);
		int z1 = -region.getTileHeight(z, regionX, regionY);
		int z2 = regionX + 1 < Region.X ? -region.getTileHeight(z, regionX + 1, regionY) : z1;
		int z3 = regionY + 1 < Region.Y ? -region.getTileHeight(z, regionX, regionY + 1) : z1;
		int z4 = regionX + 1 < Region.X && regionY + 1 < Region.Y ? -region.getTileHeight(z, regionX + 1, regionY + 1) : z1;

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

	private static void drawSceneTileModel(Region region, int regionX, int regionY, int z, SceneTileModel sceneTileModel)
	{
		if (sceneTileModel == null)
		{
			return;
		}

		for (int i = 0; i < sceneTileModel.faceX.length; ++i)
		{
			int vertexA = sceneTileModel.faceX[i];
			int vertexB = sceneTileModel.faceY[i];
			int vertexC = sceneTileModel.faceZ[i];

			int vertexAx = sceneTileModel.vertexX[vertexA];
			int vertexAy = sceneTileModel.vertexY[vertexA];
			int vertexAz = sceneTileModel.vertexZ[vertexA];

			int vertexBx = sceneTileModel.vertexX[vertexB];
			int vertexBy = sceneTileModel.vertexY[vertexB];
			int vertexBz = sceneTileModel.vertexZ[vertexB];

			int vertexCx = sceneTileModel.vertexX[vertexC];
			int vertexCy = sceneTileModel.vertexY[vertexC];
			int vertexCz = sceneTileModel.vertexZ[vertexC];

			int colorA = sceneTileModel.triangleColorA[i];
			int colorB = sceneTileModel.triangleColorB[i];
			int colorC = sceneTileModel.triangleColorC[i];

			Color color = null;
			int glTexture = -1;

			color = new Color(RS2HSB_to_RGB(colorA));

			GL11.glBegin(GL11.GL_TRIANGLES);

			if (color != null)
			{
				GL11.glColor3f((float) color.getRed() / 255f, (float) color.getGreen() / 255f, (float) color.getBlue() / 255f);
			}

			GL11.glVertex3i(vertexAx, -vertexAy, -vertexAz);
			GL11.glVertex3i(vertexBx, -vertexBy, -vertexBz);
			GL11.glVertex3i(vertexCx, -vertexCy, -vertexCz);

			GL11.glEnd();

			if (glTexture > -1)
			{
				GL11.glDisable(GL11.GL_TEXTURE_2D);
			}
		}
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

			int regionX = objectPos.getX() - region.getBaseX();
			int regionY = objectPos.getY() - region.getBaseY();
			int height = -region.getTileHeight(objectPos.getZ(), regionX, regionY);

			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			// TILE_SCALE/2 to draw the object from the center of the tile it is on
			GL11.glTranslatef(regionX * TILE_SCALE + (TILE_SCALE / 2), height + (location.getPosition().getZ() * 0), -regionY * TILE_SCALE - (TILE_SCALE / 2));

			for (int i = 0; i < object.getObjectModels().length; ++i)
			{
				if (object.getObjectTypes() != null && object.getObjectTypes()[i] != location.getType())
				{
					continue;
				}

				ModelDefinition md = modelManager.getModel(object.getObjectModels()[i], object, location);

				if (md == null)
				{
					continue;
				}

				drawModel(md, object.getRecolorToFind(), object.getRecolorToReplace());
			}

			GL11.glTranslatef(-regionX * TILE_SCALE - (TILE_SCALE / 2), -(height + (location.getPosition().getZ() * 0)), regionY * TILE_SCALE + (TILE_SCALE / 2));
			GL11.glPopMatrix();
		}
	}

	private static ObjectDefinition getObject(int id)
	{
		return objectManager.getObject(id);
	}

	private static Texture getTexture(int id)
	{
		Texture texture = textures.get(id);
		if (texture != null)
		{
			return texture;
		}

		TextureDefinition textureDefinition = textureManager.findTexture(id);

		SpriteDefinition spriteDefinition = spriteManager.findSprite(textureDefinition.getFileIds()[0], 0);

		int width = spriteDefinition.getWidth();
		int height = spriteDefinition.getHeight();

		int[] rgb = spriteDefinition.getPixels();

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

	private static void loadSeqs(Store store) throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.CONFIGS);
		Archive archive = index.getArchive(ConfigType.SEQUENCE.getId());

		byte[] archiveData = storage.loadArchive(archive);
		ArchiveFiles files = archive.getFiles(archiveData);

		for (FSFile file : files.getFiles())
		{
			SequenceLoader loader = new SequenceLoader();
			SequenceDefinition seq = loader.load(file.getFileId(), file.getContents());

			seqs.put(file.getFileId(), seq);
		}
	}

	private static void loadFrames(Store store) throws IOException
	{
		Storage storage = store.getStorage();
		Index frameIndex = store.getIndex(IndexType.FRAMES);
		Index framemapIndex = store.getIndex(IndexType.FRAMEMAPS);

		for (Archive archive : frameIndex.getArchives())
		{
			byte[] archiveData = storage.loadArchive(archive);
			ArchiveFiles archiveFiles = archive.getFiles(archiveData);
			for (FSFile archiveFile : archiveFiles.getFiles())
			{
				byte[] contents = archiveFile.getContents();

				int framemapArchiveId = (contents[0] & 0xff) << 8 | contents[1] & 0xff;

				Archive framemapArchive = framemapIndex.getArchives().get(framemapArchiveId);
				archiveData = storage.loadArchive(framemapArchive);
				byte[] framemapContents = framemapArchive.decompress(archiveData);

				FramemapLoader fmloader = new FramemapLoader();
				FramemapDefinition framemap = fmloader.load(framemapArchive.getArchiveId(), framemapContents);

				FrameLoader frameLoader = new FrameLoader();
				FrameDefinition frame = frameLoader.load(framemap, archiveFile.getFileId(), contents);

				frames.put(archive.getArchiveId(), frame);
			}
		}
	}

	// found these two functions here https://www.rune-server.org/runescape-development/rs2-client/tools/589900-rs2-hsb-color-picker.html
	public static int RGB_to_RS2HSB(int red, int green, int blue)
	{
		float[] HSB = Color.RGBtoHSB(red, green, blue, null);
		float hue = (HSB[0]);
		float saturation = (HSB[1]);
		float brightness = (HSB[2]);
		int encode_hue = (int) (hue * 63);            //to 6-bits
		int encode_saturation = (int) (saturation * 7);        //to 3-bits
		int encode_brightness = (int) (brightness * 127);    //to 7-bits
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
