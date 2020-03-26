import java.io.File;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class92 {
	@ObfuscatedName("x")
	static final BigInteger field1181;
	@ObfuscatedName("m")
	static final BigInteger field1178;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("SequenceDefinition_skeletonsArchive")
	public static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("w")
	@Export("cacheDir")
	public static File cacheDir;
	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("worldSelectLeftSprite")
	static IndexedSprite worldSelectLeftSprite;

	static {
		field1181 = new BigInteger("10001", 16);
		field1178 = new BigInteger("b9c1060ac8499f373d9882f40e43f340f6412f30973ccc7b9bb633c15d4a925f92027c296efdc543c468986c6193597fb0e999c8f73ded9d5349a8e2e3a2ddea56262dae24e1c26ef213c9dd7b5bd35ecbc26d1286a99e20295e9ab9ec46c5609f15dc2f12d412f3fc027b4677ece3d578af01cebe5e1dbba80c81bcb118f8dd", 16);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Liy;Liy;I)I",
		garbageValue = "-1982305886"
	)
	static int method2156(AbstractArchive var0, AbstractArchive var1) {
		int var2 = 0;
		if (var0.tryLoadFileByNames("title.jpg", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("logo", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("logo_deadman_mode", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("logo_seasonal_mode", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("titlebox", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("titlebutton", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("runes", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("title_mute", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,0", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,2", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,4", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,6", "")) {
			++var2;
		}

		var1.tryLoadFileByNames("sl_back", "");
		var1.tryLoadFileByNames("sl_flags", "");
		var1.tryLoadFileByNames("sl_arrows", "");
		var1.tryLoadFileByNames("sl_stars", "");
		var1.tryLoadFileByNames("sl_button", "");
		return var2;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-78"
	)
	public static void method2155() {
		SequenceDefinition.SequenceDefinition_cached.clear();
		SequenceDefinition.SequenceDefinition_cachedFrames.clear();
	}
}
