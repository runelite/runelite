import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
final class class4 implements class0 {
	@ObfuscatedName("rv")
	@ObfuscatedGetter(
		intValue = 213671429
	)
	static int field20;
	@ObfuscatedName("t")
	@Export("SpriteBuffer_pixels")
	static byte[][] SpriteBuffer_pixels;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;
	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		signature = "[Lla;"
	)
	@Export("headIconHintSprites")
	static Sprite[] headIconHintSprites;

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkb;B)V",
		garbageValue = "3"
	)
	public void vmethod64(Object var1, Buffer var2) {
		this.method61((String)var1, var2);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;I)Ljava/lang/Object;",
		garbageValue = "-1146837249"
	)
	public Object vmethod74(Buffer var1) {
		return var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lkb;I)V",
		garbageValue = "-1770492713"
	)
	void method61(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkj;II)V",
		garbageValue = "-1157404679"
	)
	@Export("updatePlayers")
	static final void updatePlayers(PacketBuffer var0, int var1) {
		int var2 = var0.offset;
		Players.Players_pendingUpdateCount = 0;
		WorldMapID.method648(var0);

		for (int var3 = 0; var3 < Players.Players_pendingUpdateCount; ++var3) {
			int var4 = Players.Players_pendingUpdateIndices[var3];
			Player var5 = Client.players[var4];
			int var6 = var0.readUnsignedByte();
			if ((var6 & 64) != 0) {
				var6 += var0.readUnsignedByte() << 8;
			}

			GrandExchangeOfferNameComparator.method239(var0, var4, var5, var6);
		}

		if (var0.offset - var2 != var1) {
			throw new RuntimeException(var0.offset - var2 + " " + var1);
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-102"
	)
	static final int method63(int var0, int var1) {
		int var2 = var1 * 57 + var0;
		var2 ^= var2 << 13;
		int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
		return var3 >> 19 & 255;
	}

	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "989659851"
	)
	@Export("Widget_resetModelFrames")
	static final void Widget_resetModelFrames(int var0) {
		if (LoginScreenAnimation.loadInterface(var0)) {
			Widget[] var1 = Widget.Widget_interfaceComponents[var0];

			for (int var2 = 0; var2 < var1.length; ++var2) {
				Widget var3 = var1[var2];
				if (var3 != null) {
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
				}
			}

		}
	}
}
