import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("WorldMapSectionType")
public enum WorldMapSectionType implements Enumerated {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lt;"
	)
	@Export("WORLDMAPSECTIONTYPE0")
	WORLDMAPSECTIONTYPE0(0, (byte)0),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lt;"
	)
	@Export("WORLDMAPSECTIONTYPE1")
	WORLDMAPSECTIONTYPE1(2, (byte)1),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lt;"
	)
	@Export("WORLDMAPSECTIONTYPE2")
	WORLDMAPSECTIONTYPE2(1, (byte)2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lt;"
	)
	@Export("WORLDMAPSECTIONTYPE3")
	WORLDMAPSECTIONTYPE3(3, (byte)3);

	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -740472387
	)
	@Export("type")
	final int type;
	@ObfuscatedName("p")
	@Export("id")
	final byte id;

	WorldMapSectionType(int var3, byte var4) {
		this.type = var3;
		this.id = var4;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "7"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Lt;",
		garbageValue = "-1446334113"
	)
	static WorldMapSectionType[] method262() {
		return new WorldMapSectionType[]{WORLDMAPSECTIONTYPE3, WORLDMAPSECTIONTYPE0, WORLDMAPSECTIONTYPE1, WORLDMAPSECTIONTYPE2};
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "748001828"
	)
	static void method265() {
		Skeleton.field1788 = new int[2000];
		int var0 = 0;
		int var1 = 240;

		int var3;
		for (byte var2 = 12; var0 < 16; var1 -= var2) {
			var3 = Huffman.method4020((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)(0.075F + 0.425F * (float)var0 / 16.0F));
			Skeleton.field1788[var0] = var3;
			++var0;
		}

		var1 = 48;

		for (int var5 = var1 / 6; var0 < Skeleton.field1788.length; var1 -= var5) {
			var3 = var0 * 2;

			for (int var4 = Huffman.method4020((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < Skeleton.field1788.length; ++var0) {
				Skeleton.field1788[var0] = var4;
			}
		}

	}

	@ObfuscatedName("p")
	public static int method271(long var0) {
		return (int)(var0 >>> 7 & 127L);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lhl;I[B[BB)V",
		garbageValue = "98"
	)
	@Export("Widget_setKey")
	static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2592 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2592 = new byte[11][];
			var0.field2653 = new byte[11][];
			var0.field2654 = new int[11];
			var0.field2655 = new int[11];
		}

		var0.field2592[var1] = var2;
		if (var2 != null) {
			var0.field2651 = true;
		} else {
			var0.field2651 = false;

			for (int var4 = 0; var4 < var0.field2592.length; ++var4) {
				if (var0.field2592[var4] != null) {
					var0.field2651 = true;
					break;
				}
			}
		}

		var0.field2653[var1] = var3;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-2113411095"
	)
	static final void method269(String var0) {
		WorldMapSection2.method347("Please remove " + var0 + " from your friend list first");
	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "-1551677344"
	)
	static final void method272(int var0, int var1, int var2, boolean var3) {
		if (UserComparator3.loadInterface(var0)) {
			class225.resizeInterface(FloorDecoration.Widget_interfaceComponents[var0], -1, var1, var2, var3);
		}
	}
}
