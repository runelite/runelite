import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lq")
@Implements("FillMode")
public enum FillMode implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	field3855(1, 1),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	field3852(2, 2);

	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -494470033
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1639084691
	)
	@Export("id")
	final int id;

	FillMode(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1410702910"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhz;IIS)Lli;",
		garbageValue = "-25317"
	)
	@Export("SpriteBuffer_getSprite")
	public static Sprite SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		byte[] var4 = var0.takeFile(var1, var2);
		boolean var3;
		if (var4 == null) {
			var3 = false;
		} else {
			GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var4);
			var3 = true;
		}

		return !var3 ? null : ChatChannel.method2218();
	}
}
