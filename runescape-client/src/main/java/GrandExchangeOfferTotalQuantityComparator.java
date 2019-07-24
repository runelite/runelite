import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("GrandExchangeOfferTotalQuantityComparator")
final class GrandExchangeOfferTotalQuantityComparator implements Comparator {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Li;Li;I)I",
		garbageValue = "-918016039"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity ? -1 : (var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("ft")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1523306949"
	)
	static void method93(int var0) {
		if (var0 == -1 && !Client.field699) {
			NetSocket.method3553();
		} else if (var0 != -1 && var0 != Client.field889 && Client.field911 != 0 && !Client.field699) {
			Archive var1 = WorldMapRegion.archive6;
			int var2 = Client.field911;
			class197.field2402 = 1;
			GrandExchangeOfferNameComparator.musicTrackArchive = var1;
			class197.musicTrackGroupId = var0;
			class197.musicTrackFileId = 0;
			ScriptFrame.field529 = var2;
			BuddyRankComparator.musicTrackBoolean = false;
			class197.field2404 = 2;
		}

		Client.field889 = var0;
	}

	@ObfuscatedName("if")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lhj;I)Ljava/lang/String;",
		garbageValue = "16777215"
	)
	static String method92(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					String var4 = var0.substring(0, var3);
					int var6 = Varps.method3969(var1, var2 - 1);
					String var5;
					if (var6 < 999999999) {
						var5 = Integer.toString(var6);
					} else {
						var5 = "*";
					}

					var0 = var4 + var5 + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}

	@ObfuscatedName("jm")
	@ObfuscatedSignature(
		signature = "(Lhj;I)V",
		garbageValue = "-1619270893"
	)
	static final void method85(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 324) {
			if (Client.field919 == -1) {
				Client.field919 = var0.spriteId2;
				Client.field920 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field919;
			} else {
				var0.spriteId2 = Client.field920;
			}

		} else if (var1 == 325) {
			if (Client.field919 == -1) {
				Client.field919 = var0.spriteId2;
				Client.field920 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field920;
			} else {
				var0.spriteId2 = Client.field919;
			}

		} else if (var1 == 327) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 0;
		} else if (var1 == 328) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 1;
		}
	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-282995090"
	)
	@Export("removeImageTag")
	static String removeImageTag(String var0) {
		PlayerType[] var1 = UserComparator5.PlayerType_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon != -1 && var0.startsWith(WorldMapSection1.getModIconString(var3.modIcon))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon).length());
				break;
			}
		}

		return var0;
	}
}
