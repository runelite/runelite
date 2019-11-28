import java.applet.Applet;
import java.awt.FontMetrics;
import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class51 {
	@ObfuscatedName("u")
	@Export("applet")
	public static Applet applet;
	@ObfuscatedName("f")
	public static String field424;
	@ObfuscatedName("y")
	static byte[][][] field423;
	@ObfuscatedName("ag")
	@Export("loginScreenFontMetrics")
	static FontMetrics loginScreenFontMetrics;
	@ObfuscatedName("ev")
	@Export("secureRandom")
	static SecureRandom secureRandom;
	@ObfuscatedName("fn")
	@ObfuscatedGetter(
		intValue = -838256623
	)
	@Export("baseX")
	static int baseX;
	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	static Widget field432;

	static {
		applet = null;
		field424 = "";
	}
}
