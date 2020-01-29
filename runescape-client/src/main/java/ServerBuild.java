import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("ServerBuild")
public class ServerBuild {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("LIVE")
	static final ServerBuild LIVE;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("BUILDLIVE")
	static final ServerBuild BUILDLIVE;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("RC")
	static final ServerBuild RC;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("WIP")
	static final ServerBuild WIP;
	@ObfuscatedName("dc")
	@ObfuscatedGetter(
		longValue = 1863736648599346965L
	)
	static long field3111;
	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("scene")
	static Scene scene;
	@ObfuscatedName("i")
	@Export("name")
	public final String name;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1460040921
	)
	final int field3108;

	static {
		LIVE = new ServerBuild("LIVE", 0);
		BUILDLIVE = new ServerBuild("BUILDLIVE", 3);
		RC = new ServerBuild("RC", 1);
		WIP = new ServerBuild("WIP", 2);
	}

	ServerBuild(String var1, int var2) {
		this.name = var1;
		this.field3108 = var2;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(BI)C",
		garbageValue = "798764142"
	)
	public static char method4209(byte var0) {
		int var1 = var0 & 255;
		if (var1 == 0) {
			throw new IllegalArgumentException("" + Integer.toString(var1, 16));
		} else {
			if (var1 >= 128 && var1 < 160) {
				char var2 = class288.cp1252AsciiExtension[var1 - 128];
				if (var2 == 0) {
					var2 = '?';
				}

				var1 = var2;
			}

			return (char)var1;
		}
	}
}
