package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;

/**
 * Class to check clickboxes of models. Mostly refactored code from the client.
 */
@Mixin(RSClient.class)
public abstract class ClickboxMixin implements RSClient
{
	private static final int MAX_ENTITES_AT_MOUSE = 1000;
	private static final int CLICKBOX_CLOSE = 50;
	private static final int CLICKBOX_FAR = 10000;
	private static final int OBJECT_INTERACTION_FAR = 100; // Max distance, in tiles, from camera
	@Inject
	private static final int[] rl$modelViewportXs = new int[4700];
	@Inject
	private static final int[] rl$modelViewportYs = new int[4700];
	@Shadow("client")
	private static RSClient client;

	@Inject
	private static int rl$rot1(int var0, int var1, int var2, int var3)
	{
		return var0 * var2 + var3 * var1 >> 16;
	}

	@Inject
	private static int rl$rot2(int var0, int var1, int var2, int var3)
	{
		return var2 * var1 - var3 * var0 >> 16;
	}

	@Inject
	private static int rl$rot3(int var0, int var1, int var2, int var3)
	{
		return var0 * var2 - var3 * var1 >> 16;
	}

	@Inject
	private static int rl$rot4(int var0, int var1, int var2, int var3)
	{
		return var3 * var0 + var2 * var1 >> 16;
	}

	@Inject
	public void checkClickbox(net.runelite.api.Model model, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, long l2)
	{
		int n10;
		int n11;
		int n12;
		int n13;
		int n14;
		net.runelite.rs.api.RSModel rSModel = (net.runelite.rs.api.RSModel) model;
		boolean bl2 = l2 != 0L && (int) (l2 >>> 16 & 1L) != 1;
		boolean bl3 = client.getViewportContainsMouse();
		if (!bl2)
		{
			return;
		}
		if (!bl3)
		{
			return;
		}
		boolean bl4 = this.boundingboxCheck(rSModel, n7, n8, n9);
		if (!bl4)
		{
			return;
		}
		if (rSModel.isClickable())
		{
			this.addHashAtMouse(l2);
			return;
		}
		int n15 = rSModel.getVerticesCount();
		int n16 = rSModel.getTrianglesCount();
		int[] arrn = rSModel.getVerticesX();
		int[] arrn2 = rSModel.getVerticesY();
		int[] arrn3 = rSModel.getVerticesZ();
		int[] arrn4 = rSModel.getTrianglesX();
		int[] arrn5 = rSModel.getTrianglesY();
		int[] arrn6 = rSModel.getTrianglesZ();
		int[] arrn7 = rSModel.getFaceColors3();
		int n17 = client.get3dZoom();
		int n18 = client.getCenterX();
		int n19 = client.getCenterY();
		int n20 = 0;
		int n21 = 0;
		if (n2 != 0)
		{
			n20 = net.runelite.api.Perspective.SINE[n2];
			n21 = net.runelite.api.Perspective.COSINE[n2];
		}
		for (n14 = 0; n14 < n15; ++n14)
		{
			n11 = arrn[n14];
			n13 = arrn2[n14];
			n12 = arrn3[n14];
			if (n2 != 0)
			{
				n10 = n12 * n20 + n11 * n21 >> 16;
				n12 = n12 * n21 - n11 * n20 >> 16;
				n11 = n10;
			}
			n10 = (n12 += n9) * n5 + n6 * (n11 += n7) >> 16;
			n12 = n6 * n12 - n11 * n5 >> 16;
			n11 = n10;
			n10 = n4 * (n13 += n8) - n12 * n3 >> 16;
			if ((n12 = n13 * n3 + n4 * n12 >> 16) >= 50)
			{
				rl$modelViewportYs[n14] = n11 * n17 / n12 + n18;
				rl$modelViewportXs[n14] = n10 * n17 / n12 + n19;
				continue;
			}
			rl$modelViewportYs[n14] = -5000;
		}
		n14 = client.getViewportMouseX();
		n11 = client.getViewportMouseY();
		n13 = 0;
		while (n13 < n16)
		{
			if (arrn7[n13] != -2)
			{
				int n22;
				boolean bl5;
				int n23;
				n12 = arrn4[n13];
				n10 = arrn5[n13];
				int n24 = arrn6[n13];
				int n25 = rl$modelViewportYs[n12];
				int n26 = rl$modelViewportYs[n10];
				int n27 = rl$modelViewportYs[n24];
				int n28 = rl$modelViewportXs[n12];
				int n29 = rl$modelViewportXs[n10];
				int n30 = rl$modelViewportXs[n24];
				if (n25 != -5000 && n26 != -5000 && n27 != -5000 && (bl5 = ((n23 = (n22 = rSModel.isClickable() ? 20
					: 5) + n11) >= n28 || n23 >= n29 || n23 >= n30) && (((n23 = n11 - n22) <= n28 || n23 <= n29 || n23 <= n30) && (((n23 = n22 + n14) >= n25 || n23 >= n26 || n23 >= n27) && ((n23 = n14 - n22) <= n25 || n23 <= n26 || n23 <= n27)))))
				{
					this.addHashAtMouse(l2);
					return;
				}
			}
			++n13;
		}
	}

	@Inject
	private void addHashAtMouse(long hash)
	{
		long[] entitiesAtMouse = client.getEntitiesAtMouse();
		int count = client.getEntitiesAtMouseCount();
		if (count < MAX_ENTITES_AT_MOUSE)
		{
			entitiesAtMouse[count] = hash;
			client.setEntitiesAtMouseCount(count + 1);
		}
	}

	@Inject
	public boolean boundingboxCheck(net.runelite.api.Model model, int n2, int n3, int n4)
	{
		int n5 = client.getCameraPitch();
		int n6 = client.getCameraYaw();
		int n7 = net.runelite.api.Perspective.SINE[n5];
		int n8 = net.runelite.api.Perspective.COSINE[n5];
		int n9 = net.runelite.api.Perspective.SINE[n6];
		int n10 = net.runelite.api.Perspective.COSINE[n6];
		int n11 = client.getCenterX();
		int n12 = client.getCenterY();
		int n13 = client.getViewportMouseX();
		int n14 = client.getViewportMouseY();
		int n15 = client.get3dZoom();
		int n16 = (n13 - n11) * 50 / n15;
		int n17 = (n14 - n12) * 50 / n15;
		int n18 = (n13 - n11) * 10000 / n15;
		int n19 = (n14 - n12) * 10000 / n15;
		int n20 = rl$rot1(n17, 50, n8, n7);
		int n21 = rl$rot2(n17, 50, n8, n7);
		n17 = n20;
		n20 = rl$rot1(n19, 10000, n8, n7);
		int n22 = rl$rot2(n19, 10000, n8, n7);
		n19 = n20;
		n20 = rl$rot3(n16, n21, n10, n9);
		n21 = rl$rot4(n16, n21, n10, n9);
		n16 = n20;
		n20 = rl$rot3(n18, n22, n10, n9);
		n22 = rl$rot4(n18, n22, n10, n9);
		int n23 = (n20 - n16) / 2;
		int n24 = (n19 - n17) / 2;
		int n25 = (n22 - n21) / 2;
		int n26 = Math.abs(n23);
		int n27 = Math.abs(n24);
		int n28 = Math.abs(n25);
		int n29 = n2 + model.getCenterX();
		int n30 = n3 + model.getCenterY();
		int n31 = n4 + model.getCenterZ();
		int n32 = model.getExtremeX();
		int n33 = model.getExtremeY();
		int n34 = model.getExtremeZ();
		int n35 = (n16 + n20) / 2;
		int n36 = (n17 + n19) / 2;
		int n37 = (n22 + n21) / 2;
		int n38 = n35 - n29;
		int n39 = n36 - n30;
		int n40 = n37 - n31;
		if (Math.abs(n38) > n32 + n26)
		{
			return false;
		}
		if (Math.abs(n39) > n33 + n27)
		{
			return false;
		}
		if (Math.abs(n40) > n34 + n28)
		{
			return false;
		}
		if (Math.abs(n40 * n24 - n39 * n25) > n33 * n28 + n34 * n27)
		{
			return false;
		}
		if (Math.abs(n38 * n25 - n40 * n23) > n34 * n26 + n32 * n28)
		{
			return false;
		}
		return Math.abs(n39 * n23 - n38 * n24) <= n33 * n26 + n32 * n27;
	}
}
