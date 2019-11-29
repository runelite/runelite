import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 193606079
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1934572627
	)
	@Export("x")
	int x;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1222614809
	)
	@Export("y")
	int y;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1168297541
	)
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ley;"
	)
	@Export("paint")
	TilePaint paint;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ldo;"
	)
	@Export("model")
	TileModel model;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Leu;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Ldu;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lda;"
	)
	@Export("tileItemPile")
	TileItemPile tileItemPile;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 595796379
	)
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[Leh;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("o")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1728330701
	)
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -882274027
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("r")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("c")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("a")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1788905093
	)
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 177937909
	)
	int field1655;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 672389787
	)
	int field1656;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1739431401
	)
	int field1650;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ldm;"
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
}
