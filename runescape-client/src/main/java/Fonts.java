import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("Fonts")
public class Fonts {
	@ObfuscatedName("r")
	static int[] field3689;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("spritesArchive")
	AbstractArchive spritesArchive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("fontsArchive")
	AbstractArchive fontsArchive;
	@ObfuscatedName("e")
	@Export("map")
	HashMap map;

	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;)V"
	)
	public Fonts(AbstractArchive var1, AbstractArchive var2) {
		this.spritesArchive = var1;
		this.fontsArchive = var2;
		this.map = new HashMap();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([Lkd;I)Ljava/util/HashMap;",
		garbageValue = "-354104614"
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
				Font var6 = class287.method5258(this.spritesArchive, this.fontsArchive, var5.name, "");
				if (var6 != null) {
					this.map.put(var5, var6);
					var2.put(var5, var6);
				}
			}
		}

		return var2;
	}
}
