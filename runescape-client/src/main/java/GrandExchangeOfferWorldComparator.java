import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("GrandExchangeOfferWorldComparator")
final class GrandExchangeOfferWorldComparator implements Comparator {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	@Export("leftTitleSprite")
	static Sprite leftTitleSprite;
	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("scene")
	static Scene scene;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Li;Li;I)I",
		garbageValue = "1850890964"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.world < var2.world ? -1 : (var2.world == var1.world ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;B)V",
		garbageValue = "0"
	)
	@Export("setVarcIntArchive")
	public static void setVarcIntArchive(AbstractArchive var0) {
		VarcInt.VarcInt_archive = var0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
		garbageValue = "-2102370448"
	)
	public static String method63(CharSequence var0) {
		int var1 = var0.length();
		StringBuilder var2 = new StringBuilder(var1);

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
				if (var4 == ' ') {
					var2.append('+');
				} else {
					byte var5 = ItemDefinition.charToByteCp1252(var4);
					var2.append('%');
					int var6 = var5 >> 4 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}

					var6 = var5 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}
				}
			} else {
				var2.append(var4);
			}
		}

		return var2.toString();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lla;ILjava/lang/String;B)Ljava/lang/String;",
		garbageValue = "-9"
	)
	static String method54(IterableNodeHashTable var0, int var1, String var2) {
		if (var0 == null) {
			return var2;
		} else {
			ObjectNode var3 = (ObjectNode)var0.get((long)var1);
			return var3 == null ? var2 : (String)var3.obj;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Lik;",
		garbageValue = "-1961052460"
	)
	public static VarpDefinition method61(int var0) {
		VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarpDefinition.VarpDefinition_archive.takeFile(16, var0);
			var1 = new VarpDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarpDefinition.VarpDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZZI)V",
		garbageValue = "-1344972354"
	)
	@Export("openURL")
	public static void openURL(String var0, boolean var1, boolean var2) {
		class326.method6243(var0, var1, "openjs", var2);
	}

	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-51"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[class42.plane][var0][var1];
		if (var2 == null) {
			scene.removeGroundItemPile(class42.plane, var0, var1);
		} else {
			long var3 = -99999999L;
			GroundItem var5 = null;

			GroundItem var6;
			for (var6 = (GroundItem)var2.last(); var6 != null; var6 = (GroundItem)var2.previous()) {
				ItemDefinition var7 = WorldMapArea.getItemDefinition(var6.id);
				long var8 = (long)var7.price;
				if (var7.isStackable == 1) {
					var8 *= (long)(var6.quantity + 1);
				}

				if (var8 > var3) {
					var3 = var8;
					var5 = var6;
				}
			}

			if (var5 == null) {
				scene.removeGroundItemPile(class42.plane, var0, var1);
			} else {
				var2.addLast(var5);
				GroundItem var12 = null;
				GroundItem var11 = null;

				for (var6 = (GroundItem)var2.last(); var6 != null; var6 = (GroundItem)var2.previous()) {
					if (var5.id != var6.id) {
						if (var12 == null) {
							var12 = var6;
						}

						if (var6.id != var12.id && var11 == null) {
							var11 = var6;
						}
					}
				}

				long var9 = Tile.calculateTag(var0, var1, 3, false, 0);
				scene.newGroundItemPile(class42.plane, var0, var1, ScriptEvent.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class42.plane), var5, var9, var12, var11);
			}
		}
	}
}
