import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class49 {
	@ObfuscatedName("rq")
	@ObfuscatedGetter(
		intValue = 1686126592
	)
	static int field417;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 1254436043
	)
	public static int field418;
	@ObfuscatedName("et")
	@ObfuscatedGetter(
		intValue = -311350761
	)
	@Export("port2")
	static int port2;

	static {
		ImageIO.setUseCache(false);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIB)Lci;",
		garbageValue = "-31"
	)
	static Script method880(int var0, int var1) {
		Script var2 = (Script)Script.Script_cached.get((long)(var0 << 16));
		if (var2 != null) {
			return var2;
		} else {
			String var3 = String.valueOf(var0);
			int var4 = class267.archive12.getGroupId(var3);
			if (var4 == -1) {
				return null;
			} else {
				byte[] var5 = class267.archive12.takeFileFlat(var4);
				if (var5 != null) {
					if (var5.length <= 1) {
						return null;
					}

					var2 = WorldMapArea.newScript(var5);
					if (var2 != null) {
						Script.Script_cached.put(var2, (long)(var0 << 16));
						return var2;
					}
				}

				return null;
			}
		}
	}
}
