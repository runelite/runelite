import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1803176159
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -2007130967
	)
	@Export("x")
	int x;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1326950391
	)
	@Export("y")
	int y;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -215553835
	)
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("paint")
	TilePaint paint;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ldv;"
	)
	@Export("model")
	TileModel model;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Ldu;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Ldc;"
	)
	@Export("tileItemPile")
	TileItemPile tileItemPile;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1462066179
	)
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "[Lel;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("v")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 2119940373
	)
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -322964403
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("l")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("t")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("j")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1942439905
	)
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 413999433
	)
	int field1630;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1503891955
	)
	int field1640;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1195282039
	)
	int field1641;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ldy;"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)Lha;",
		garbageValue = "0"
	)
	@Export("getWidget")
	public static Widget getWidget(int var0) {
		int var1 = var0 >> 16;
		int var2 = var0 & 65535;
		if (UserComparator7.Widget_interfaceComponents[var1] == null || UserComparator7.Widget_interfaceComponents[var1][var2] == null) {
			boolean var3 = MusicPatch.loadInterface(var1);
			if (!var3) {
				return null;
			}
		}

		return UserComparator7.Widget_interfaceComponents[var1][var2];
	}
}
