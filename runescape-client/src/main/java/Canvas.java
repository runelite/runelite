import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1323988023
	)
	static int field422;
	@ObfuscatedName("fd")
	@ObfuscatedGetter(
		intValue = 983351575
	)
	static int field418;
	@ObfuscatedName("q")
	@Export("component")
	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Lbw;",
		garbageValue = "-1579773205"
	)
	@Export("getNextWorldListWorld")
	static World getNextWorldListWorld() {
		return World.worldListWorldCount < World.worldsCount ? World.worlds[++World.worldListWorldCount - 1] : null;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1705541685"
	)
	@Export("runWidgetOnLoadListener")
	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) {
			if (class162.loadInterface(var0)) {
				Widget[] var1 = Widget.Widget_interfaceComponents[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.onLoad != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.args = var3.onLoad;
						class96.runScript(var4, 5000000);
					}
				}

			}
		}
	}

	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "(IIIILly;Lhg;I)V",
		garbageValue = "-1460314936"
	)
	@Export("worldToMinimap")
	static final void worldToMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		int var6 = var3 * var3 + var2 * var2;
		if (var6 > 4225 && var6 < 90000) {
			int var7 = Client.camAngleY & 2047;
			int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
			int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
			int var10 = var9 * var2 + var3 * var8 >> 16;
			int var11 = var3 * var9 - var8 * var2 >> 16;
			double var12 = Math.atan2((double)var10, (double)var11);
			int var14 = var5.width / 2 - 25;
			int var15 = (int)(Math.sin(var12) * (double)var14);
			int var16 = (int)(Math.cos(var12) * (double)var14);
			byte var17 = 20;
			UserComparator4.redHintArrowSprite.method6193(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
		} else {
			Interpreter.drawSpriteOnMinimap(var0, var1, var2, var3, var4, var5);
		}

	}
}
