import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
	@ObfuscatedName("nl")
	@ObfuscatedGetter(
		intValue = -1005036451
	)
	static int field46;
	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("worldSelectBackSprites")
	static Sprite[] worldSelectBackSprites;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1055414531
	)
	@Export("world")
	public final int world;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = -1970915304396216385L
	)
	@Export("age")
	public final long age;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ld;"
	)
	@Export("grandExchangeOffer")
	public final GrandExchangeOffer grandExchangeOffer;
	@ObfuscatedName("q")
	@Export("offerName")
	String offerName;
	@ObfuscatedName("v")
	@Export("previousOfferName")
	String previousOfferName;

	@ObfuscatedSignature(
		signature = "(Lkc;BI)V"
	)
	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.offerName = var1.readStringCp1252NullTerminated();
		this.previousOfferName = var1.readStringCp1252NullTerminated();
		this.world = var1.readUnsignedShort();
		this.age = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.grandExchangeOffer = new GrandExchangeOffer();
		this.grandExchangeOffer.method139(2);
		this.grandExchangeOffer.method152(var2);
		this.grandExchangeOffer.unitPrice = var4;
		this.grandExchangeOffer.totalQuantity = var5;
		this.grandExchangeOffer.currentQuantity = 0;
		this.grandExchangeOffer.currentPrice = 0;
		this.grandExchangeOffer.id = var3;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "65536"
	)
	@Export("getOfferName")
	public String getOfferName() {
		return this.offerName;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(S)Ljava/lang/String;",
		garbageValue = "3632"
	)
	@Export("getPreviousOfferName")
	public String getPreviousOfferName() {
		return this.previousOfferName;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1325412403"
	)
	static String method122(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(DDII)[D",
		garbageValue = "-2110450939"
	)
	public static double[] method123(double var0, double var2, int var4) {
		int var5 = var4 * 2 + 1;
		double[] var6 = new double[var5];
		int var7 = -var4;

		for (int var8 = 0; var7 <= var4; ++var8) {
			var6[var8] = WorldMapSection1.method636((double)var7, var0, var2);
			++var7;
		}

		return var6;
	}
}
