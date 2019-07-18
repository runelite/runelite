import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class51 {
	@ObfuscatedName("q")
	@Export("applet")
	static Applet applet;
	@ObfuscatedName("w")
	static String field434;

	static {
		applet = null;
		field434 = "";
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Lip;",
		garbageValue = "1884870915"
	)
	public static HealthBarDefinition method854(int var0) {
		HealthBarDefinition var1 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var0);
			var1 = new HealthBarDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HealthBarDefinition.HealthBarDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
