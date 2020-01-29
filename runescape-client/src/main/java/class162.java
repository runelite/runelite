import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class162 implements class161 {
	@ObfuscatedName("sy")
	@ObfuscatedGetter(
		intValue = -1885571545
	)
	@Export("foundItemIdCount")
	static int foundItemIdCount;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("Widget_fontsArchive")
	static AbstractArchive Widget_fontsArchive;

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lii;Ljava/lang/String;Ljava/lang/String;IZI)V",
		garbageValue = "-1967656766"
	)
	public static void method3523(AbstractArchive var0, String var1, String var2, int var3, boolean var4) {
		int var5 = var0.getGroupId(var1);
		int var6 = var0.getFileId(var5, var2);
		class197.field2414 = 1;
		UserComparator5.musicTrackArchive = var0;
		class197.musicTrackGroupId = var5;
		class83.musicTrackFileId = var6;
		AttackOption.musicTrackVolume = var3;
		KeyHandler.musicTrackBoolean = var4;
		class197.field2412 = 10000;
	}
}
