/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import net.runelite.cache.IndexType;
import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.definitions.ObjectDefinition;
import net.runelite.cache.definitions.loaders.ModelLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.region.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelManager
{
	private static final Logger logger = LoggerFactory.getLogger(ModelManager.class);

	private final Store store;
	private final Map<ModelKey, ModelDefinition> models = new HashMap<>();
	private final ModelLoader loader = new ModelLoader();

	public ModelManager(Store store)
	{
		this.store = store;
	}

	public ModelDefinition getModel(int id)
	{
		return this.getModel(new ModelKey(id, -1, -1, -1), null);
	}

	public ModelDefinition getModel(int id, ObjectDefinition object, Location location)
	{
		final int type, rot;
		if (location != null)
		{
			type = location.getType();
			rot = location.getOrientation();
		}
		else
		{
			type = rot = 0;
		}
		return this.getModel(new ModelKey(id, object.getId(), type, rot), md ->
		{
			// this logic is from method3697 in 140
			if (object.getObjectTypes() == null)
			{
				boolean isRotate = object.isRotated();

				if (type == 2 && rot > 3)
				{
					isRotate = !isRotate;
				}

				if (isRotate)
				{
					md.method1493();
				}
			}
			else
			{
				boolean isRotate = object.isRotated() ^ rot > 3;

				if (isRotate)
				{
					md.method1493();
				}
			}

			if (type == 4 && rot > 3)
			{
				md.rotate(256);
				md.move(45, 0, -45);
			}
			switch (rot & 3)
			{
				case 1:
					md.rotate1();
					break;
				case 2:
					md.rotate2();
					break;
				case 3:
					md.rotate3();
					break;
			}
			short[] recolorToFind = object.getRecolorToFind();
			if (recolorToFind != null)
			{
				short[] recolorToReplace = object.getRecolorToReplace();
				for (int i = 0; i < recolorToFind.length; ++i)
				{
					md.recolor(recolorToFind[i], recolorToReplace[i]);
				}
			}
			short[] retextureToFind = object.getRetextureToFind();
			if (retextureToFind != null)
			{
				short[] textureToReplace = object.getTextureToReplace();
				for (int i = 0; i < retextureToFind.length; ++i)
				{
					md.retexture(retextureToFind[i], textureToReplace[i]);
				}
			}

			if (object.getModelSizeX() != 128 || object.getModelSizeHeight() != 128 || object.getModelSizeY() != 128)
			{
				md.resize(object.getModelSizeX(), object.getModelSizeHeight(), object.getModelSizeY());
			}

			if (object.getOffsetX() != 0 || object.getOffsetHeight() != 0 || object.getOffsetY() != 0)
			{
				md.move((short) object.getOffsetX(), (short) object.getOffsetHeight(), (short) object.getOffsetY());
			}
		});
	}

	private ModelDefinition getModel(ModelKey key, Consumer<ModelDefinition> loadConsumer)
	{
		ModelDefinition md = models.get(key);
		if (md != null)
		{
			return md;
		}

		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.MODELS);

		Archive modelArchive = index.getArchive(key.getModelId());
		byte[] contents;
		try
		{
			contents = modelArchive.decompress(storage.loadArchive(modelArchive));
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		md = loader.load(modelArchive.getArchiveId(), contents);

		if (loadConsumer != null)
		{
			loadConsumer.accept(md);
		}
		md.computeNormals();
		md.computeMaxPriority();
		models.put(key, md);
		return md;
	}
}
