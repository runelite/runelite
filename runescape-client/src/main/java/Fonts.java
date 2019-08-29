import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
@Implements("Fonts")
public class Fonts {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("spritesArchive")
	AbstractArchive spritesArchive;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("fontsArchive")
	AbstractArchive fontsArchive;
	@ObfuscatedName("i")
	@Export("map")
	HashMap map;

	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;)V"
	)
	public Fonts(AbstractArchive var1, AbstractArchive var2) {
		this.spritesArchive = var1;
		this.fontsArchive = var2;
		this.map = new HashMap();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "([Lkz;I)Ljava/util/HashMap;",
		garbageValue = "2107388628"
	)
	@Export("createMap")
	public HashMap createMap(FontName[] var1) {
		HashMap var2 = new HashMap();
		FontName[] var3 = var1;

		for (int var4 = 0; var4 < var3.length; ++var4) {
			FontName var5 = var3[var4];
			if (this.map.containsKey(var5)) {
				var2.put(var5, this.map.get(var5));
			} else {
				Font var6 = PcmPlayer.SpriteBuffer_getFontByName(this.spritesArchive, this.fontsArchive, var5.name, "");
				if (var6 != null) {
					this.map.put(var5, var6);
					var2.put(var5, var6);
				}
			}
		}

		return var2;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)[Lha;",
		garbageValue = "1384146854"
	)
	public static ServerBuild[] method5240() {
		return new ServerBuild[]{ServerBuild.WIP, ServerBuild.LIVE, ServerBuild.BUILDLIVE, ServerBuild.RC};
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;Lhz;I)V",
		garbageValue = "-1215139257"
	)
	public static void method5234(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
		SequenceDefinition.SequenceDefinition_archive = var0;
		SequenceDefinition.SequenceDefinition_animationsArchive = var1;
		SequenceDefinition.SequenceDefinition_skeletonsArchive = var2;
	}
}
