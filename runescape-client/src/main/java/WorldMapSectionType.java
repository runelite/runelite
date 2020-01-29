import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("f")
@Implements("WorldMapSectionType")
public enum WorldMapSectionType implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lf;"
	)
	@Export("WORLDMAPSECTIONTYPE0")
	WORLDMAPSECTIONTYPE0(0, (byte)0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lf;"
	)
	@Export("WORLDMAPSECTIONTYPE1")
	WORLDMAPSECTIONTYPE1(2, (byte)1),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lf;"
	)
	@Export("WORLDMAPSECTIONTYPE2")
	WORLDMAPSECTIONTYPE2(3, (byte)2),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lf;"
	)
	@Export("WORLDMAPSECTIONTYPE3")
	WORLDMAPSECTIONTYPE3(1, (byte)3);

	@ObfuscatedName("pv")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("privateChatMode")
	static PrivateChatMode privateChatMode;
	@ObfuscatedName("hq")
	@ObfuscatedGetter(
		intValue = 1689470585
	)
	static int field166;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 262125779
	)
	@Export("type")
	final int type;
	@ObfuscatedName("g")
	@Export("id")
	final byte id;

	WorldMapSectionType(int var3, byte var4) {
		this.type = var3;
		this.id = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(S)[Lf;",
		garbageValue = "-3096"
	)
	static WorldMapSectionType[] method249() {
		return new WorldMapSectionType[]{WORLDMAPSECTIONTYPE3, WORLDMAPSECTIONTYPE0, WORLDMAPSECTIONTYPE2, WORLDMAPSECTIONTYPE1};
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([BI)[B",
		garbageValue = "84077862"
	)
	public static byte[] method250(byte[] var0) {
		int var1 = var0.length;
		byte[] var2 = new byte[var1];
		System.arraycopy(var0, 0, var2, 0, var1);
		return var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "637615278"
	)
	static int method245(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.LOGOUT) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "1"
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
			int var8 = Tiles.Tiles_heights[var5][var3 + 1][var4] * var6 + (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] >> 7;
			int var9 = Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] * var6 + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
			return var9 * var7 + var8 * (128 - var7) >> 7;
		} else {
			return 0;
		}
	}
}
