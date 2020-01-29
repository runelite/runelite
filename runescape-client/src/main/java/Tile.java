import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -477020471
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1716517237
	)
	@Export("x")
	int x;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1137721201
	)
	@Export("y")
	int y;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -2077595523
	)
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("paint")
	TilePaint paint;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Ldt;"
	)
	@Export("model")
	TileModel model;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Leu;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ldu;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ldk;"
	)
	@Export("tileItemPile")
	TileItemPile tileItemPile;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1422843585
	)
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "[Lea;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("v")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 848654297
	)
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -2052178019
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("w")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("k")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("q")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 902411349
	)
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -381817665
	)
	int field1650;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1422099387
	)
	int field1640;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1581215505
	)
	int field1652;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Ldz;"
	)
	@Export("linkedBelowTile")
	Tile linkedBelowTile;

	Tile(int var1, int var2, int var3) {
		this.gameObjects = new GameObject[5];
		this.gameObjectEdgeMasks = new int[5];
		this.gameObjectsEdgeMask = 0;
		this.originalPlane = this.plane = var1;
		this.x = var2;
		this.y = var3;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
		garbageValue = "20"
	)
	static void method2927(String var0, boolean var1, String var2, boolean var3) {
		if (var1) {
			if (!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(var0));
					return;
				} catch (Exception var5) {
				}
			}

			if (class51.field431.startsWith("win") && !var3) {
				ClientPacket.method3682(var0, 0);
				return;
			}

			if (class51.field431.startsWith("mac")) {
				class14.method174(var0, 1, var2);
				return;
			}

			ClientPacket.method3682(var0, 2);
		} else {
			ClientPacket.method3682(var0, 3);
		}

	}

	@ObfuscatedName("l")
	public static int method2926(long var0) {
		return (int)(var0 >>> 14 & 3L);
	}
}
