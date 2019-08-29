import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("VertexNormal")
public class VertexNormal {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1795200651
	)
	@Export("x")
	int x;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1592235953
	)
	@Export("y")
	int y;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 221616325
	)
	@Export("z")
	int z;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1908751547
	)
	@Export("magnitude")
	int magnitude;

	VertexNormal() {
	}

	@ObfuscatedSignature(
		signature = "(Ldl;)V"
	)
	VertexNormal(VertexNormal var1) {
		this.x = var1.x;
		this.y = var1.y;
		this.z = var1.z;
		this.magnitude = var1.magnitude;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhz;Ljava/lang/String;Ljava/lang/String;S)Llq;",
		garbageValue = "3108"
	)
	@Export("SpriteBuffer_getIndexedSpriteByName")
	public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		return Clock.SpriteBuffer_getIndexedSprite(var0, var3, var4);
	}
}
