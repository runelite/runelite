import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("dv")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive14")
	static Archive archive14;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1749719213
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1393298715
	)
	@Export("x")
	int x;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1385365023
	)
	@Export("y")
	int y;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 529885461
	)
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("paint")
	TilePaint paint;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Ldk;"
	)
	@Export("model")
	TileModel model;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lei;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ldq;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Ldc;"
	)
	@Export("tileItemPile")
	TileItemPile tileItemPile;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 52989903
	)
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "[Les;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("x")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1372984003
	)
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1827111931
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("y")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("g")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("a")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -342353329
	)
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1148018233
	)
	int field1651;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -474591227
	)
	int field1665;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -357197323
	)
	int field1666;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ldv;"
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

	@ObfuscatedName("q")
	public static String method2855(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (0L == var0 % 37L) {
				return null;
			}
			int var2 = 0;

			for (long var3 = var0; var3 != 0L; var3 /= 37L) {
				++var2;
			}

			StringBuilder var5 = new StringBuilder(var2);

			while (var0 != 0L) {
				long var6 = var0;
				var0 /= 37L;
				var5.append(class289.base37Table[(int)(var6 - var0 * 37L)]);
			}

			return var5.reverse().toString();
		}
		return null;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIIZII)J",
		garbageValue = "-1948443569"
	)
	@Export("calculateTag")
	public static long calculateTag(int x, int y, int type, boolean notInteractable, int id) {
		long var5 = (long)((x & 127) << 0 | (y & 127) << 7 | (type & 3) << 14) | ((long)id & 4294967295L) << 17;
		if (notInteractable) {
			var5 |= 65536L;
		}

		return var5;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IZII)V",
		garbageValue = "-1363278802"
	)
	@Export("PcmPlayer_configure")
	public static final void PcmPlayer_configure(int var0, boolean var1, int var2) {
		if (var0 < 8000 || var0 > 48000) {
			throw new IllegalArgumentException();
		}
		CollisionMap.PcmPlayer_sampleRate = var0;
		FileSystem.PcmPlayer_stereo = var1;
		PcmPlayer.PcmPlayer_count = var2;
	}

	@ObfuscatedName("jc")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1430853825"
	)
	@Export("clanKickUser")
	static final void clanKickUser(String var0) {
		if (DevicePcmPlayerProvider.clanChat != null) {
			PacketBufferNode var1 = Archive.getPacketBufferNode(ClientPacket.field2216, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(Huffman.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
