/*
 *  Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package us.runelitepl.mixins;

import net.runelite.api.MenuEntry;
import net.runelite.api.Node;
import net.runelite.api.hooks.Callbacks;
import net.runelite.rs.api.RSCollisionData;
import net.runelite.rs.api.RSDeque;
import net.runelite.rs.api.RSNode;
import us.runelitepl.mixinprocessor.annotations.Inject;
import us.runelitepl.mixinprocessor.annotations.Overwrite;
import us.runelitepl.mixinprocessor.annotations.Prepend;
import us.runelitepl.mixinprocessor.annotations.Provided;
import us.runelitepl.mixinprocessor.annotations.Reobfuscate;

import java.util.List;

public class Client
{
	
	@Provided
	public static boolean isHidingEntities;
	
	@Provided
	public static boolean hideLocalPlayer2D;
	
	@Provided
	public static boolean hideLocalPlayer;
	
	@Provided
	public static boolean hidePlayers2D;
	
	@Provided
	public static boolean hidePlayers;
	
	@Provided
	public static boolean hideAttackers;
	
	@Provided
	public static boolean hideProjectiles;
	
	@Provided
	public static boolean hideNPCs2D;
	
	@Provided
	public static boolean hideNPCs;
	
	@Provided
	public static boolean hideFriends;
	
	@Provided
	public static boolean hideClanMates;
	
	@Inject
	public static Client INSTANCE;
	
	@Inject
	public static boolean printMenuActions;
	
	@Provided
	public static int oldMenuEntryCount;
	
	@Reobfuscate
	@Provided
	static boolean renderSelf;
	
	@Provided
	public static final int[] rl$modelViewportXs = new int[0];
	
	@Provided
	public static final int[] rl$modelViewportYs = new int[0];
	
	@Prepend
	private void prepend$rl$$init()
	{
		INSTANCE = this;
		printMenuActions = false;
	}
	
	@Inject
	public void toggleRenderSelf()
	{
		renderSelf = !renderSelf;
	}
	
	@Provided
	public int getMenuOptionCount()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public String[] getMenuOptions()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public String[] getMenuTargets()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int[] getMenuIdentifiers()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int[] getMenuTypes()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int[] getMenuActionParams0()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int[] getMenuActionParams1()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public boolean[] getMenuForceLeftClick()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public void setMenuOptionCount(int i)
	{
		throw new RuntimeException();
	}
	
	@Provided
	public Callbacks getCallbacks()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public RSCollisionData[] getRsCollisionMaps()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public RSDeque getProjectilesDeque()
	{
		throw new RuntimeException();
	}
	
	@Overwrite
	public List getProjectiles()
	{
		List list = new java.util.ArrayList();
		RSNode head = getProjectilesDeque().getHead();
		for (Node node = ((Node) head).getNext();
				node != head;
				node = node.getNext())
		{
			list.add(node);
		}
		return list;
	}
	
	@Inject
	public void setPrintMenuActions(boolean b)
	{
		printMenuActions = b;
	}
	
	@Overwrite
	public RSCollisionData[] getCollisionMaps()
	{
		return getRsCollisionMaps();
	}
	
	@Overwrite
	public void setMenuEntries(MenuEntry[] arrmenuEntry)
	{
		int n2 = 0;
		String[] arrstring = this.getMenuOptions();
		String[] arrstring2 = this.getMenuTargets();
		int[] arrn = this.getMenuIdentifiers();
		int[] arrn2 = this.getMenuTypes();
		int[] arrn3 = this.getMenuActionParams0();
		int[] arrn4 = this.getMenuActionParams1();
		boolean[] arrbl = getMenuForceLeftClick();
		net.runelite.api.MenuEntry[] arrmenuEntry2 = arrmenuEntry;
		int n3 = arrmenuEntry2.length;
		int n4 = 0;
		do
		{
			String string;
			if (n4 >= n3)
			{
				this.setMenuOptionCount(n2);
				oldMenuEntryCount = n2;
				return;
			}
			net.runelite.api.MenuEntry menuEntry = arrmenuEntry2[n4];
			int n5 = menuEntry.getType();
			arrstring[n2] = menuEntry.getOption();
			arrstring2[n2] = menuEntry.getTarget();
			arrn[n2] = menuEntry.getIdentifier();
			arrn2[n2] = n5;
			arrn3[n2] = menuEntry.getParam0();
			arrn4[n2] = menuEntry.getParam1();
			arrbl[n2] = menuEntry.isForceLeftClick();
			++n2;
			++n4;
		}
		while (true);
	}
	
	@Overwrite
	public static void onMenuOptionsChanged(int n2)
	{
		int n3;
		int n4 = oldMenuEntryCount;
		oldMenuEntryCount = n3 = INSTANCE.getMenuOptionCount();
		if (n3 != n4 + 1)
		{
			return;
		}
		net.runelite.api.events.MenuEntryAdded menuEntryAdded =
				new net.runelite.api.events.MenuEntryAdded(INSTANCE.getMenuOptions()[n3 - 1],
						INSTANCE.getMenuTargets()[n3 - 1],
						INSTANCE.getMenuTypes()[n3 - 1],
						INSTANCE.getMenuIdentifiers()[n3 - 1],
						INSTANCE.getMenuActionParams0()[n3 - 1],
						INSTANCE.getMenuActionParams1()[n3 - 1]);
		INSTANCE.getCallbacks().post(menuEntryAdded);
	}
	
	@Overwrite
	public static void copy$processClientError(String s, Throwable e, byte b)
	{
		System.err.println("[RL+] Error thrown: " + s);
		e.printStackTrace();
	}
	
	@Inject
	public net.runelite.api.MouseRecorder getMouseRecorder()
	{
		return _Statics_.mouseRecorder;
	}
	
	@Inject
	public boolean boundingboxCheck2(net.runelite.api.Model model, int n2, int n3, int n4)
	{
		int n5 = INSTANCE.getCameraPitch();
		int n6 = INSTANCE.getCameraYaw();
		int n7 = net.runelite.api.Perspective.SINE[n5];
		int n8 = net.runelite.api.Perspective.COSINE[n5];
		int n9 = net.runelite.api.Perspective.SINE[n6];
		int n10 = net.runelite.api.Perspective.COSINE[n6];
		int n11 = INSTANCE.getCenterX();
		int n12 = INSTANCE.getCenterY();
		int n13 = INSTANCE.getViewportMouseX();
		int n14 = INSTANCE.getViewportMouseY();
		int n15 = INSTANCE.get3dZoom();
		int n16 = (n13 - n11) * 50 / n15;
		int n17 = (n14 - n12) * 50 / n15;
		int n18 = (n13 - n11) * 10000 / n15;
		int n19 = (n14 - n12) * 10000 / n15;
		int n20 = Client.rl$rot1(n17, 50, n8, n7);
		int n21 = Client.rl$rot2(n17, 50, n8, n7);
		n17 = n20;
		n20 = Client.rl$rot1(n19, 10000, n8, n7);
		int n22 = Client.rl$rot2(n19, 10000, n8, n7);
		n19 = n20;
		n20 = Client.rl$rot3(n16, n21, n10, n9);
		n21 = Client.rl$rot4(n16, n21, n10, n9);
		n16 = n20;
		n20 = Client.rl$rot3(n18, n22, n10, n9);
		n22 = Client.rl$rot4(n18, n22, n10, n9);
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
		if (Math.abs(n39 * n23 - n38 * n24) <= n33 * n26 + n32 * n27)
		{
			return true;
		}
		return false;
	}
	
	@Overwrite
	public void checkClickbox(net.runelite.api.Model model, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, long l2)
	{
		int n10;
		int n11;
		int n12;
		int n13;
		int n14;
		net.runelite.rs.api.RSModel rSModel = (net.runelite.rs.api.RSModel) model;
		boolean bl2 = l2 != 0L && (int) (l2 >>> 16 & 1L) != 1;
		boolean bl3 = INSTANCE.getViewportContainsMouse();
		if (!bl2)
		{
			return;
		}
		if (!bl3)
		{
			return;
		}
		boolean bl4 = this.boundingboxCheck2(rSModel, n7, n8, n9);
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
		int n17 = INSTANCE.get3dZoom();
		int n18 = INSTANCE.getCenterX();
		int n19 = INSTANCE.getCenterY();
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
				Client.rl$modelViewportYs[n14] = n11 * n17 / n12 + n18;
				Client.rl$modelViewportXs[n14] = n10 * n17 / n12 + n19;
				continue;
			}
			Client.rl$modelViewportYs[n14] = -5000;
		}
		n14 = INSTANCE.getViewportMouseX();
		n11 = INSTANCE.getViewportMouseY();
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
				if (n25 != -5000 && n26 != -5000 && n27 != -5000 && (bl5 = (n23 = (n22 = rSModel.isClickable() ? 20
						: 5) + n11) < n28 && n23 < n29 && n23 < n30 ? false
						: ((n23 = n11 - n22) > n28 && n23 > n29 && n23 > n30 ? false
								   : ((n23 = n22 + n14) < n25 && n23 < n26 && n23 < n27 ? false
										      : (n23 = n14 - n22) <= n25 || n23 <= n26 || n23 <= n27))))
				{
					this.addHashAtMouse(l2);
					return;
				}
			}
			++n13;
		}
	}
	
	@Provided
	public boolean getViewportContainsMouse()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public void addHashAtMouse(long l)
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int getCameraPitch()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int getCameraYaw()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int getCenterX()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int getCenterY()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int getViewportMouseX()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int getViewportMouseY()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public int get3dZoom()
	{
		throw new RuntimeException();
	}
	
	@Provided
	public static int rl$rot1(int a, int b, int c, int d)
	{
		throw new RuntimeException();
	}
	
	@Provided
	public static int rl$rot2(int a, int b, int c, int d)
	{
		throw new RuntimeException();
	}
	
	@Provided
	public static int rl$rot3(int a, int b, int c, int d)
	{
		throw new RuntimeException();
	}
	
	@Provided
	public static int rl$rot4(int a, int b, int c, int d)
	{
		throw new RuntimeException();
	}
	
	@Inject
	public void invokeMenuAction(int actionParam, int widgetId, int opcode, int targetId, String menuOption,
			String menuTarget, int mouseX, int mouseY)
	{
		_Statics_.menuAction(actionParam, widgetId, opcode, targetId, menuOption,
			menuTarget, mouseX, mouseY);
	}
	
}