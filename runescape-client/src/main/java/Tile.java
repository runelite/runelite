import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("da")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive13")
	static Archive archive13;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 16369307
	)
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1518104939
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1003607853
	)
	@Export("x")
	int x;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1362708877
	)
	@Export("y")
	int y;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("paint")
	TilePaint paint;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ldd;"
	)
	@Export("model")
	TileModel model;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Ldj;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ldo;"
	)
	@Export("tileItemPile")
	TileItemPile tileItemPile;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -308551417
	)
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "[Lej;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("o")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 2078500007
	)
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -260677087
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("w")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("t")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("g")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 824924819
	)
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1066984119
	)
	int field1610;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1620350221
	)
	int field1624;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 2139191781
	)
	int field1629;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ldl;"
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Lgn;",
		garbageValue = "283500885"
	)
	public static PacketBufferNode method2849() {
		PacketBufferNode var0;
		if (PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0) {
			var0 = new PacketBufferNode();
		} else {
			var0 = PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
		}

		var0.clientPacket = null;
		var0.clientPacketLength = 0;
		var0.packetBuffer = new PacketBuffer(5000);
		return var0;
	}
}
