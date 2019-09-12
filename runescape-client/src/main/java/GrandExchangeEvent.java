import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("fontPlain11")
	static Font fontPlain11;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -158786095
	)
	@Export("world")
	public final int world;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		longValue = 3834067055658986045L
	)
	@Export("age")
	public final long age;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lz;"
	)
	@Export("grandExchangeOffer")
	public final GrandExchangeOffer grandExchangeOffer;
	@ObfuscatedName("g")
	@Export("offerName")
	String offerName;
	@ObfuscatedName("l")
	@Export("previousOfferName")
	String previousOfferName;

	@ObfuscatedSignature(
		signature = "(Lkz;BI)V"
	)
	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.offerName = var1.readStringCp1252NullTerminated();
		this.previousOfferName = var1.readStringCp1252NullTerminated();
		this.world = var1.readUnsignedShort();
		this.age = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.grandExchangeOffer = new GrandExchangeOffer();
		this.grandExchangeOffer.method98(2);
		this.grandExchangeOffer.method92(var2);
		this.grandExchangeOffer.unitPrice = var4;
		this.grandExchangeOffer.totalQuantity = var5;
		this.grandExchangeOffer.currentQuantity = 0;
		this.grandExchangeOffer.currentPrice = 0;
		this.grandExchangeOffer.id = var3;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "1"
	)
	@Export("getOfferName")
	public String getOfferName() {
		return this.offerName;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "3"
	)
	@Export("getPreviousOfferName")
	public String getPreviousOfferName() {
		return this.previousOfferName;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;II)I",
		garbageValue = "1731864296"
	)
	public static int method74(CharSequence var0, int var1) {
		return class51.parseIntCustomRadix(var0, var1, true);
	}

	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-57"
	)
	static final void method73() {
		PacketBufferNode var0 = MenuAction.getPacketBufferNode(ClientPacket.field2262, Client.packetWriter.isaacCipher);
		Client.packetWriter.addNode(var0);

		for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
			if (var1.type == 0 || var1.type == 3) {
				StructDefinition.closeInterface(var1, true);
			}
		}

		if (Client.meslayerContinueWidget != null) {
			WorldMapID.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

	}
}
