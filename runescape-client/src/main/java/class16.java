import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class16 {
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("runesSprite")
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		signature = "Lbt;"
	)
	@Export("mouseRecorder")
	static MouseRecorder mouseRecorder;

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lii;Ljava/lang/String;Ljava/lang/String;I)Lli;",
		garbageValue = "1833648793"
	)
	@Export("SpriteBuffer_getIndexedSpriteByName")
	public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		IndexedSprite var5;
		if (!class228.method4199(var0, var3, var4)) {
			var5 = null;
		} else {
			var5 = class313.method5962();
		}

		return var5;
	}
}
