import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("qu")
	@ObfuscatedGetter(
		intValue = 756269056
	)
	static int field925;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 2040420297
	)
	@Export("cacheGamebuild")
	public static int cacheGamebuild;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 842281271
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1195330125
	)
	@Export("type")
	int type;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -521000553
	)
	@Export("x")
	int x;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -156944661
	)
	@Export("y")
	int y;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2076612057
	)
	@Export("objectId")
	int objectId;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1798753117
	)
	int field929;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1153270233
	)
	int field924;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 37593595
	)
	@Export("id")
	int id;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -87951589
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 894134175
	)
	int field927;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1990017955
	)
	@Export("delay")
	int delay;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 458330281
	)
	@Export("hitpoints")
	int hitpoints;

	PendingSpawn() {
		this.delay = 0;
		this.hitpoints = -1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(ZZB)Llm;",
		garbageValue = "0"
	)
	static IndexedSprite method1753(boolean var0, boolean var1) {
		return var0 ? (var1 ? StructDefinition.field3315 : Varps.options_buttons_2Sprite) : (var1 ? Login.field1179 : InterfaceParent.options_buttons_0Sprite);
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		signature = "(Lhl;III)V",
		garbageValue = "648761441"
	)
	@Export("alignWidgetPosition")
	static void alignWidgetPosition(Widget var0, int var1, int var2) {
		if (var0.xAlignment == 0) {
			var0.x = var0.rawX;
		} else if (var0.xAlignment == 1) {
			var0.x = var0.rawX + (var1 - var0.width) / 2;
		} else if (var0.xAlignment == 2) {
			var0.x = var1 - var0.width - var0.rawX;
		} else if (var0.xAlignment == 3) {
			var0.x = var0.rawX * var1 >> 14;
		} else if (var0.xAlignment == 4) {
			var0.x = (var1 - var0.width) / 2 + (var0.rawX * var1 >> 14);
		} else {
			var0.x = var1 - var0.width - (var0.rawX * var1 >> 14);
		}

		if (var0.yAlignment == 0) {
			var0.y = var0.rawY;
		} else if (var0.yAlignment == 1) {
			var0.y = (var2 - var0.height) / 2 + var0.rawY;
		} else if (var0.yAlignment == 2) {
			var0.y = var2 - var0.height - var0.rawY;
		} else if (var0.yAlignment == 3) {
			var0.y = var2 * var0.rawY >> 14;
		} else if (var0.yAlignment == 4) {
			var0.y = (var2 * var0.rawY >> 14) + (var2 - var0.height) / 2;
		} else {
			var0.y = var2 - var0.height - (var2 * var0.rawY >> 14);
		}

	}

	@ObfuscatedName("jx")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-547734374"
	)
	static boolean method1751() {
		return Client.tapToDrop || KeyHandler.KeyHandler_pressedKeys[81];
	}
}
