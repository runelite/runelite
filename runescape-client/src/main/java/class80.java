import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class80 {
	@ObfuscatedName("rm")
	@ObfuscatedGetter(
		intValue = 638664704
	)
	static int field1111;
	@ObfuscatedName("p")
	static final BigInteger field1109;
	@ObfuscatedName("b")
	static final BigInteger field1112;
	@ObfuscatedName("bj")
	@Export("otp")
	static String otp;

	static {
		field1109 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
		field1112 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-52"
	)
	static int method2053(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 0) {
				var1 = 0;
			} else if (var1 > 127) {
				var1 = 127;
			}

			var1 = 127 - var1;
			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lhz;Ljava/lang/String;Ljava/lang/String;B)[Lls;",
		garbageValue = "-8"
	)
	public static Sprite[] method2058(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		return GrandExchangeOfferNameComparator.SpriteBuffer_getSpriteArray(var0, var3, var4);
	}
}
