import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class83 {
	@ObfuscatedName("c")
	static final BigInteger field1151;
	@ObfuscatedName("t")
	static final BigInteger field1150;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1334117913
	)
	@Export("musicTrackFileId")
	public static int musicTrackFileId;

	static {
		field1151 = new BigInteger("10001", 16);
		field1150 = new BigInteger("c20a7ab5337092e3e04d646de102abda0a14c2669233a3df9db8a57acccc6e54d9e9a5eaa408b39b17d7cc429c38a98aa62a7fb616e714a301546ff47456dcc74c2003b3fc6683bb22ac4170ee6bc1ecad99bb26b684c3264c94a8b411e363a7b55bb16c0fef207993b812f36888b07a465243bd4640d3bd4828356795dcb74d", 16);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;I)V",
		garbageValue = "590815960"
	)
	public static void method2109(AbstractArchive var0) {
		FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)[Lgy;",
		garbageValue = "1"
	)
	public static class185[] method2107() {
		return new class185[]{class185.field2327, class185.field2315, class185.field2322, class185.field2317, class185.field2318, class185.field2320, class185.field2319, class185.field2314, class185.field2316, class185.field2323};
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "17386837"
	)
	public static int method2108(int var0) {
		return var0 >> 11 & 63;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lia;II)V",
		garbageValue = "319200175"
	)
	static void method2110(Archive var0, int var1) {
		if (class4.NetCache_reference != null) {
			class4.NetCache_reference.offset = var1 * 8 + 5;
			int var2 = class4.NetCache_reference.readInt();
			int var3 = class4.NetCache_reference.readInt();
			var0.loadIndex(var2, var3);
		} else {
			BuddyRankComparator.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
			NetCache.NetCache_archives[var1] = var0;
		}
	}
}
