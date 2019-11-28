import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1903174229
	)
	@Export("world")
	public final int world;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		longValue = -3619466799124397109L
	)
	@Export("age")
	public final long age;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Li;"
	)
	@Export("grandExchangeOffer")
	public final GrandExchangeOffer grandExchangeOffer;
	@ObfuscatedName("g")
	@Export("offerName")
	String offerName;
	@ObfuscatedName("z")
	@Export("previousOfferName")
	String previousOfferName;

	@ObfuscatedSignature(
		signature = "(Lkg;BI)V"
	)
	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.offerName = var1.readStringCp1252NullTerminated();
		this.previousOfferName = var1.readStringCp1252NullTerminated();
		this.world = var1.readUnsignedShort();
		this.age = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.grandExchangeOffer = new GrandExchangeOffer();
		this.grandExchangeOffer.method109(2);
		this.grandExchangeOffer.method110(var2);
		this.grandExchangeOffer.unitPrice = var4;
		this.grandExchangeOffer.totalQuantity = var5;
		this.grandExchangeOffer.currentQuantity = 0;
		this.grandExchangeOffer.currentPrice = 0;
		this.grandExchangeOffer.id = var3;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "16"
	)
	@Export("getOfferName")
	public String getOfferName() {
		return this.offerName;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1776036206"
	)
	@Export("getPreviousOfferName")
	public String getPreviousOfferName() {
		return this.previousOfferName;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "-894744142"
	)
	public static void method86(Buffer var0, int var1) {
		if (JagexCache.JagexCache_randomDat != null) {
			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
			} catch (Exception var3) {
			}
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkg;II)Ljava/lang/String;",
		garbageValue = "808138004"
	)
	static String method92(Buffer var0, int var1) {
		try {
			int var2 = var0.readUShortSmart();
			if (var2 > var1) {
				var2 = var1;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class210.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
			String var4 = NetCache.decodeStringCp1252(var3, 0, var2);
			return var4;
		} catch (Exception var6) {
			return "Cabbage";
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-357486416"
	)
	static void method91(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}
}
