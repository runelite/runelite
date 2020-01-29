import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1568217923
	)
	static int field45;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("NetCache_currentResponse")
	public static NetFileRequest NetCache_currentResponse;
	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("worldSelectLeftSprite")
	static IndexedSprite worldSelectLeftSprite;
	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive0")
	static Archive archive0;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1956147033
	)
	@Export("world")
	public final int world;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = 7213176078958271683L
	)
	@Export("age")
	public final long age;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lm;"
	)
	@Export("grandExchangeOffer")
	public final GrandExchangeOffer grandExchangeOffer;
	@ObfuscatedName("e")
	@Export("offerName")
	String offerName;
	@ObfuscatedName("i")
	@Export("previousOfferName")
	String previousOfferName;

	@ObfuscatedSignature(
		signature = "(Lkp;BI)V"
	)
	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.offerName = var1.readStringCp1252NullTerminated();
		this.previousOfferName = var1.readStringCp1252NullTerminated();
		this.world = var1.readUnsignedShort();
		this.age = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.grandExchangeOffer = new GrandExchangeOffer();
		this.grandExchangeOffer.method120(2);
		this.grandExchangeOffer.method112(var2);
		this.grandExchangeOffer.unitPrice = var4;
		this.grandExchangeOffer.totalQuantity = var5;
		this.grandExchangeOffer.currentQuantity = 0;
		this.grandExchangeOffer.currentPrice = 0;
		this.grandExchangeOffer.id = var3;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1646612919"
	)
	@Export("getOfferName")
	public String getOfferName() {
		return this.offerName;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-81405509"
	)
	@Export("getPreviousOfferName")
	public String getPreviousOfferName() {
		return this.previousOfferName;
	}

	@ObfuscatedName("i")
	public static int method96(long var0) {
		return (int)(var0 >>> 0 & 127L);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "193251724"
	)
	static int method97(int var0) {
		return (int)Math.pow(2.0D, (double)((float)var0 / 256.0F + 7.0F));
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "550527389"
	)
	@Export("getGcDuration")
	protected static int getGcDuration() {
		int var0 = 0;
		if (SecureRandomFuture.garbageCollector == null || !SecureRandomFuture.garbageCollector.isValid()) {
			try {
				Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

				while (var1.hasNext()) {
					GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
					if (var2.isValid()) {
						SecureRandomFuture.garbageCollector = var2;
						GameShell.garbageCollectorLastCheckTimeMs = -1L;
						GameShell.garbageCollectorLastCollectionTime = -1L;
					}
				}
			} catch (Throwable var11) {
			}
		}

		if (SecureRandomFuture.garbageCollector != null) {
			long var9 = WorldMapIcon_0.currentTimeMillis();
			long var3 = SecureRandomFuture.garbageCollector.getCollectionTime();
			if (-1L != GameShell.garbageCollectorLastCollectionTime) {
				long var5 = var3 - GameShell.garbageCollectorLastCollectionTime;
				long var7 = var9 - GameShell.garbageCollectorLastCheckTimeMs;
				if (var7 != 0L) {
					var0 = (int)(var5 * 100L / var7);
				}
			}

			GameShell.garbageCollectorLastCollectionTime = var3;
			GameShell.garbageCollectorLastCheckTimeMs = var9;
		}

		return var0;
	}

	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		signature = "(Lbx;I)V",
		garbageValue = "2089906351"
	)
	static final void method88(Actor var0) {
		if (var0.field986 == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0 || var0.sequenceFrameCycle + 1 > GraphicsDefaults.SequenceDefinition_get(var0.sequence).frameLengths[var0.sequenceFrame]) {
			int var1 = var0.field986 - var0.field985;
			int var2 = Client.cycle - var0.field985;
			int var3 = var0.field981 * 128 + var0.field942 * 2013925376;
			int var4 = var0.field957 * 128 + var0.field942 * 2013925376;
			int var5 = var0.field961 * 128 + var0.field942 * 2013925376;
			int var6 = var0.field991 * 128 + var0.field942 * 2013925376;
			var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
			var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
		}

		var0.field997 = 0;
		var0.orientation = var0.field987;
		var0.rotation = var0.orientation;
	}

	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "(Lhn;I)V",
		garbageValue = "948929027"
	)
	static final void method93(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 324) {
			if (Client.field910 == -1) {
				Client.field910 = var0.spriteId2;
				Client.field911 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field910;
			} else {
				var0.spriteId2 = Client.field911;
			}

		} else if (var1 == 325) {
			if (Client.field910 == -1) {
				Client.field910 = var0.spriteId2;
				Client.field911 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field911;
			} else {
				var0.spriteId2 = Client.field910;
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
}
