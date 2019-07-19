import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
public class class287 {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;Ljava/lang/String;Ljava/lang/String;I)Lke;",
		garbageValue = "-2097439358"
	)
	public static Font method5258(AbstractArchive var0, AbstractArchive var1, String var2, String var3) {
		int var4 = var0.getGroupId(var2);
		int var5 = var0.getFileId(var4, var3);
		Font var6;
		if (!Friend.SpriteBuffer_loadSprite(var0, var4, var5)) {
			var6 = null;
		} else {
			var6 = WallDecoration.getWorldMapSprite(var1.takeFile(var4, var5));
		}

		return var6;
	}
}
