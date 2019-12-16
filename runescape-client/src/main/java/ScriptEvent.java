import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("fw")
	@ObfuscatedGetter(
		intValue = -2041683927
	)
	@Export("baseY")
	static int baseY;
	@ObfuscatedName("f")
	@Export("args")
	Object[] args;
	@ObfuscatedName("i")
	@Export("isMouseInputEvent")
	boolean isMouseInputEvent;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 884179391
	)
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 990811435
	)
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1259454631
	)
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 49600395
	)
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -601686953
	)
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("d")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1957089865
	)
	int field557;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1339404961
	)
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/Object;I)V",
		garbageValue = "-2080962304"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "33"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-9"
	)
	public static void method1183() {
		if (class297.NetCache_socket != null) {
			class297.NetCache_socket.close();
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-135239713"
	)
	static final int method1184(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "(Lbv;I)V",
		garbageValue = "-2035180318"
	)
	static final void method1180(Actor var0) {
		int var1 = var0.field950 - Client.cycle;
		int var2 = var0.field921 * 128 + var0.field925 * 64;
		int var3 = var0.field966 * 128 + var0.field925 * 64;
		var0.x += (var2 - var0.x) / var1;
		var0.y += (var3 - var0.y) / var1;
		var0.field980 = 0;
		var0.orientation = var0.field970;
	}

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "1464658365"
	)
	@Export("getTileHeight")
	static final int getTileHeight(int var0, int var1, int var2) {
		int var3 = var0 >> 7;
		int var4 = var1 >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
			int var5 = var2;
			if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
				var5 = var2 + 1;
			}

			int var6 = var0 & 127;
			int var7 = var1 & 127;
			int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + var6 * Tiles.Tiles_heights[var5][var3 + 1][var4] >> 7;
			int var9 = var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
			return var9 * var7 + var8 * (128 - var7) >> 7;
		} else {
			return 0;
		}
	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "103"
	)
	static boolean method1185(int var0) {
		for (int var1 = 0; var1 < Client.field849; ++var1) {
			if (Client.field851[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}
