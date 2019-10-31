import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("MenuAction")
public class MenuAction {
	@ObfuscatedName("qj")
	@ObfuscatedSignature(
		signature = "Ldq;"
	)
	@Export("pcmPlayer1")
	static PcmPlayer pcmPlayer1;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1613868885
	)
	@Export("argument1")
	int argument1;
	@ObfuscatedName("t")
	@Export("action")
	String action;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -872703787
	)
	@Export("argument2")
	int argument2;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 553279575
	)
	@Export("opcode")
	int opcode;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1804422619
	)
	@Export("argument0")
	int argument0;

	MenuAction() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lim;",
		garbageValue = "-2086805733"
	)
	@Export("SpotAnimationDefinition_get")
	public static SpotAnimationDefinition SpotAnimationDefinition_get(int var0) {
		SpotAnimationDefinition var1 = (SpotAnimationDefinition)SpotAnimationDefinition.SpotAnimationDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SpotAnimationDefinition.SpotAnimationDefinition_archive.takeFile(13, var0);
			var1 = new SpotAnimationDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			SpotAnimationDefinition.SpotAnimationDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lhq;III)Llx;",
		garbageValue = "1380862020"
	)
	@Export("SpriteBuffer_getSprite")
	public static Sprite SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		return !class32.method618(var0, var1, var2) ? null : Username.method5338();
	}
}
