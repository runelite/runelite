import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
	@ObfuscatedName("pp")
	static boolean field49;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 2059259505
	)
	static int field48;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1493732941
	)
	@Export("canvasWidth")
	public static int canvasWidth;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 839136523
	)
	@Export("world")
	public final int world;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		longValue = -2993174266726390291L
	)
	@Export("age")
	public final long age;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lf;"
	)
	@Export("grandExchangeOffer")
	public final GrandExchangeOffer grandExchangeOffer;
	@ObfuscatedName("p")
	@Export("offerName")
	String offerName;
	@ObfuscatedName("k")
	@Export("previousOfferName")
	String previousOfferName;

	@ObfuscatedSignature(
		signature = "(Lkf;BI)V"
	)
	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.offerName = var1.readStringCp1252NullTerminated();
		this.previousOfferName = var1.readStringCp1252NullTerminated();
		this.world = var1.readUnsignedShort();
		this.age = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.grandExchangeOffer = new GrandExchangeOffer();
		this.grandExchangeOffer.method115(2);
		this.grandExchangeOffer.method100(var2);
		this.grandExchangeOffer.unitPrice = var4;
		this.grandExchangeOffer.totalQuantity = var5;
		this.grandExchangeOffer.currentQuantity = 0;
		this.grandExchangeOffer.currentPrice = 0;
		this.grandExchangeOffer.id = var3;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "-114"
	)
	@Export("getOfferName")
	public String getOfferName() {
		return this.offerName;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(S)Ljava/lang/String;",
		garbageValue = "27688"
	)
	@Export("getPreviousOfferName")
	public String getPreviousOfferName() {
		return this.previousOfferName;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IB)Lis;",
		garbageValue = "1"
	)
	@Export("getSequenceDefinition")
	public static SequenceDefinition getSequenceDefinition(int var0) {
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

	@ObfuscatedName("jj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-583790135"
	)
	static final void method73() {
		PacketBufferNode var0 = Archive.method4265(ClientPacket.field2223, Client.packetWriter.isaacCipher);
		Client.packetWriter.method2219(var0);

		for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
			if (var1.type == 0 || var1.type == 3) {
				class197.closeInterface(var1, true);
			}
		}

		if (Client.field850 != null) {
			Strings.method4120(Client.field850);
			Client.field850 = null;
		}

	}
}
