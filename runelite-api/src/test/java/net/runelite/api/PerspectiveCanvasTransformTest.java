/*
 * Copyright (c) 2026, RuneLite scene mirror prototype contributors
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
package net.runelite.api;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.api.widgets.Widget;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PerspectiveCanvasTransformTest
{
	private CanvasTransform transform;

	private void setCanvasTransform(CanvasTransform value)
	{
		transform = value;
	}

	@Before
	@After
	public void clearTransform()
	{
		setCanvasTransform(null);
	}

	@Test
	public void absentTransformPreservesOriginalProjection()
	{
		assertEquals(new Point(160, 70), Perspective.localToCanvas(client(true), 128, 256, 0));
		assertFalse(Perspective.isCanvasMirrored(client(true)));
	}

	@Test
	public void rootGpuProjectionTransformsOnce()
	{
		setCanvasTransform(translation());
		assertEquals(new Point(167, 70), Perspective.localToCanvas(client(true), WorldView.TOPLEVEL, 128, 256, 0));
	}

	@Test
	public void rootCpuProjectionTransformsOnce()
	{
		setCanvasTransform(translation());
		assertEquals(new Point(167, 70), Perspective.localToCanvas(client(false), 128, 256, 0));
	}

	@Test
	public void subworldPointOverloadsTransformOnce()
	{
		setCanvasTransform(translation());
		Client client = subworldClient();
		assertEquals(new Point(167, 70), Perspective.localToCanvas(client, 1, 128, 256, 0));
		assertEquals(new Point(167, 70), Perspective.localToCanvas(client, new LocalPoint(128, 256, 1), 0, 0));
	}

	@Test
	public void readableTextCentersAfterItsWorldAnchorIsReflected()
	{
		setCanvasTransform(reflection());
		Graphics2D graphics = new BufferedImage(240, 120, BufferedImage.TYPE_INT_ARGB).createGraphics();
		try
		{
			String text = "RuneLite";
			int halfWidth = (int) (graphics.getFontMetrics().getStringBounds(text, graphics).getWidth() / 2);
			Point p = Perspective.getCanvasTextLocation(client(true), graphics, new LocalPoint(128, 256), text, 0);
			assertEquals(new Point(60 - halfWidth, 70), p);
			assertEquals(new AffineTransform(), graphics.getTransform());
		}
		finally
		{
			graphics.dispose();
		}
	}

	@Test
	public void imageCentersAfterItsWorldAnchorIsReflected()
	{
		setCanvasTransform(reflection());
		BufferedImage image = new BufferedImage(20, 10, BufferedImage.TYPE_INT_ARGB);
		assertEquals(new Point(50, 65), Perspective.getCanvasImageLocation(client(true), new LocalPoint(128, 256), image, 0));
	}

	@Test
	public void modelVerticesTransformOnceIncludingOffscreenCoordinates()
	{
		setCanvasTransform(translation());
		for (boolean gpu : new boolean[]{false, true})
		{
			int[] x = new int[]{0, 0, 0, 0, 999};
			int[] y = new int[]{0, 0, 0, 0, 888};
			Perspective.modelToCanvas(client(gpu), 4, 128, 256, 0, 0,
				new float[]{0, 128, -128, 0}, new float[]{0, 0, 0, -256}, new float[4], x, y);
			assertArrayEquals(new int[]{167, 217, 117, Integer.MIN_VALUE, 999}, x);
			assertArrayEquals(new int[]{70, 70, 70, Integer.MIN_VALUE, 888}, y);
		}
	}

	@Test
	public void subworldModelVerticesTransformOnce()
	{
		setCanvasTransform(translation());
		WorldView subworld = world(1, values("getCanvasProjection", identityProjection()));
		int[] x = new int[1];
		int[] y = new int[1];
		Perspective.modelToCanvas(client(true), subworld, 1, 128, 256, 0, 0,
			new float[1], new float[1], new float[1], x, y);
		assertArrayEquals(new int[]{167}, x);
		assertArrayEquals(new int[]{70}, y);
	}

	@Test
	public void nearPlaneNullDoesNotReachTransform()
	{
		setCanvasTransform(new CanvasTransform()
		{
			public int mapX(Client client, int x, int y)
			{
				throw new AssertionError("An invisible point must not be mapped");
			}

			public boolean isMirrored(Client client)
			{
				return true;
			}
		});
		assertNull(Perspective.localToCanvas(client(true), 128, 1, 0));
	}

	@Test
	public void minimapDoesNotUseTheWorldTransform()
	{
		setCanvasTransform(new CanvasTransform()
		{
			public int mapX(Client client, int x, int y)
			{
				throw new AssertionError("Minimap must not use the world transform");
			}

			public boolean isMirrored(Client client)
			{
				return true;
			}
		});
		Widget minimap = fake(Widget.class, values("isHidden", false, "getCanvasLocation", new Point(300, 20), "getWidth", 100, "getHeight", 80));
		CameraFocusableEntity focus = fake(CameraFocusableEntity.class, values("getCameraFocus", new LocalPoint(128, 256)));
		Map<String, Object> v = clientValues(true);
		v.putAll(values("getCameraFocusEntity", focus, "isResized", false, "getWidget", minimap,
			"getMinimapZoom", 4d, "getCameraYawTarget", 0));
		assertEquals(new Point(354, 60), Perspective.localToMinimap(fake(Client.class, v), new LocalPoint(256, 256), 1000));
	}

	@Test
	public void minimapProjectionRemainsIndependent()
	{
		setCanvasTransform(reflection());
		Widget minimap = fake(Widget.class, values("isHidden", false, "getCanvasLocation", new Point(300, 20), "getWidth", 100, "getHeight", 80));
		CameraFocusableEntity focus = fake(CameraFocusableEntity.class, values("getCameraFocus", new LocalPoint(128, 256)));
		Map<String, Object> v = clientValues(true);
		v.putAll(values("getCameraFocusEntity", focus, "isResized", false, "getWidget", minimap,
			"getMinimapZoom", 4d, "getCameraYawTarget", 0));
		assertEquals(new Point(354, 60), Perspective.localToMinimap(fake(Client.class, v), new LocalPoint(256, 256), 1000));
	}

	@Test
	public void clearingTransformRestoresOriginalProjection()
	{
		setCanvasTransform(reflection());
		assertTrue(Perspective.isCanvasMirrored(client(true)));
		setCanvasTransform(null);
		assertEquals(new Point(160, 70), Perspective.localToCanvas(client(true), 128, 256, 0));
		assertFalse(Perspective.isCanvasMirrored(client(true)));
	}

	private static CanvasTransform translation()
	{
		return new CanvasTransform()
		{
			public int mapX(Client client, int x, int y)
			{
				return x + 7;
			}

			public boolean isMirrored(Client client)
			{
				return false;
			}
		};
	}

	private static CanvasTransform reflection()
	{
		return new CanvasTransform()
		{
			public int mapX(Client client, int x, int y)
			{
				return 220 - x;
			}

			public boolean isMirrored(Client client)
			{
				return true;
			}
		};
	}

	private Client client(boolean gpu)
	{
		return fake(Client.class, clientValues(gpu));
	}

	private Map<String, Object> clientValues(boolean gpu)
	{
		WorldView root = world(WorldView.TOPLEVEL, Collections.emptyMap());
		return values("getDrawCallbacks", fake(DrawCallbacks.class, values("getCanvasTransform", transform)), "isGpu", gpu, "getScale", 100, "getViewportWidth", 200, "getViewportHeight", 100,
			"getViewportXOffset", 10, "getViewportYOffset", 20, "getCameraX", 0, "getCameraY", 0, "getCameraZ", 0,
			"getCameraPitch", 0, "getCameraYaw", 0, "getCameraFpX", 0f, "getCameraFpY", 0f, "getCameraFpZ", 0f,
			"getCameraFpPitch", 0f, "getCameraFpYaw", 0f, "getWorldView", root, "getTopLevelWorldView", root);
	}

	private Client subworldClient()
	{
		WorldView subworld = world(1, values("getCanvasProjection", identityProjection()));
		WorldEntity entity = fake(WorldEntity.class, values("getWorldView", subworld, "getLocalLocation", new LocalPoint(0, 0)));
		IndexedObjectSet<WorldEntity> entities = new IndexedObjectSet<WorldEntity>()
		{
			public WorldEntity byIndex(int index)
			{
				return index == 1 ? entity : null;
			}

			public Iterator<WorldEntity> iterator()
			{
				return Collections.singletonList(entity).iterator();
			}
		};
		Map<String, Object> v = clientValues(true);
		v.put("getTopLevelWorldView", world(WorldView.TOPLEVEL, values("worldEntities", entities)));
		return fake(Client.class, v);
	}

	private static WorldView world(int id, Map<String, Object> extra)
	{
		Map<String, Object> v = values("getId", id, "isTopLevel", id == WorldView.TOPLEVEL,
			"getPlane", 0, "getTileHeight", 0, "getSizeX", 0, "getSizeY", 0);
		v.putAll(extra);
		return fake(WorldView.class, v);
	}

	private static Projection identityProjection()
	{
		return new Projection()
		{
			public float[] project(float x, float y, float z)
			{
				return new float[]{x, y, z};
			}

			public float[] project(float x, float y, float z, float[] out)
			{
				out[0] = x;
				out[1] = y;
				out[2] = z;
				return out;
			}
		};
	}

	private static Map<String, Object> values(Object... entries)
	{
		Map<String, Object> v = new HashMap<>();
		for (int i = 0; i < entries.length; i += 2)
		{
			v.put((String) entries[i], entries[i + 1]);
		}
		return v;
	}

	private static <T> T fake(Class<T> type, Map<String, Object> values)
	{
		return type.cast(Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[]{type}, (proxy, method, args) ->
		{
			if (!values.containsKey(method.getName()))
			{
				throw new AssertionError("Unexpected fixture call: " + method);
			}
			return values.get(method.getName());
		}));
	}
}
