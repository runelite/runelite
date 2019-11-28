import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("GrandExchangeOfferAgeComparator")
final class GrandExchangeOfferAgeComparator implements Comparator {
	@ObfuscatedName("sn")
	@ObfuscatedGetter(
		intValue = 1973722011
	)
	@Export("foundItemIndex")
	static int foundItemIndex;
	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive0")
	static Archive archive0;
	@ObfuscatedName("gs")
	@Export("regionLandArchiveIds")
	static int[] regionLandArchiveIds;
	@ObfuscatedName("he")
	@ObfuscatedGetter(
		intValue = -1622356541
	)
	static int field78;

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ly;Ly;I)I",
		garbageValue = "1968951579"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.age < var2.age ? -1 : (var1.age == var2.age ? 0 : 1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Liy;",
		garbageValue = "-1360050328"
	)
	@Export("SequenceDefinition_get")
	public static SequenceDefinition SequenceDefinition_get(int var0) {
		SequenceDefinition var1 = (SequenceDefinition)SequenceDefinition.SequenceDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SequenceDefinition.SequenceDefinition_archive.takeFile(12, var0);
			var1 = new SequenceDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			SequenceDefinition.SequenceDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "1757015417"
	)
	@Export("addGameMessage")
	static void addGameMessage(int var0, String var1, String var2) {
		SecureRandomCallable.addChatMessage(var0, var1, var2, (String)null);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-41"
	)
	@Export("WorldMapRegion_clearCachedSprites")
	static void WorldMapRegion_clearCachedSprites() {
		WorldMapRegion.WorldMapRegion_cachedSprites.clear();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Llm;",
		garbageValue = "1974052885"
	)
	static IndexedSprite method172() {
		IndexedSprite var0 = new IndexedSprite();
		var0.width = class325.SpriteBuffer_spriteWidth;
		var0.height = UserComparator9.SpriteBuffer_spriteHeight;
		var0.xOffset = UrlRequester.SpriteBuffer_xOffsets[0];
		var0.yOffset = class216.SpriteBuffer_yOffsets[0];
		var0.subWidth = class325.SpriteBuffer_spriteWidths[0];
		var0.subHeight = VarcInt.SpriteBuffer_spriteHeights[0];
		var0.palette = class325.SpriteBuffer_spritePalette;
		var0.pixels = FillMode.SpriteBuffer_pixels[0];
		PcmPlayer.method2510();
		return var0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lbp;B)V",
		garbageValue = "14"
	)
	@Export("changeWorld")
	static void changeWorld(World var0) {
		if (var0.isMembersOnly() != Client.isMembersWorld) {
			Client.isMembersWorld = var0.isMembersOnly();
			WorldMapCacheName.method637(var0.isMembersOnly());
		}

		Canvas.worldHost = var0.host;
		Client.worldId = var0.id;
		Client.worldProperties = var0.properties;
		SecureRandomCallable.port1 = Client.gameBuild == 0 ? 43594 : var0.id + 40000;
		class49.port2 = Client.gameBuild == 0 ? 443 : var0.id + 50000;
		WorldMapIcon_0.port3 = SecureRandomCallable.port1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IZII)V",
		garbageValue = "-1741540406"
	)
	public static final void method170(int var0, boolean var1, int var2) {
		if (var0 >= 8000 && var0 <= 48000) {
			Messages.PcmPlayer_sampleRate = var0;
			PcmPlayer.PcmPlayer_stereo = var1;
			RouteStrategy.field2114 = var2;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
