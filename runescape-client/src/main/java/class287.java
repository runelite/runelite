import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
public class class287 {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;Ljava/lang/String;Ljava/lang/String;I)Lke;",
		garbageValue = "-2097439358"
	)
	@Export("SpriteBuffer_getFontByName")
	public static Font SpriteBuffer_getFontByName(AbstractArchive spriteArchive, AbstractArchive fontArchive, String groupName, String fileName) {
		int var4 = spriteArchive.getGroupId(groupName);
		int var5 = spriteArchive.getFileId(var4, fileName);
		Font var6;
		if (!Friend.SpriteBuffer_bufferFile(spriteArchive, var4, var5)) {
			var6 = null;
		} else {
			var6 = WallDecoration.SpriteBuffer_createFont(fontArchive.takeFile(var4, var5));
		}

		return var6;
	}
}
