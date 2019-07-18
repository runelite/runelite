import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("ServerBuild")
public class ServerBuild {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("LIVE")
	static final ServerBuild LIVE;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("BUILDLIVE")
	static final ServerBuild BUILDLIVE;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("RC")
	static final ServerBuild RC;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("WIP")
	static final ServerBuild WIP;
	@ObfuscatedName("f")
	static int[] field3103;
	@ObfuscatedName("k")
	@Export("name")
	public final String name;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1706897489
	)
	final int field3097;

	static {
		LIVE = new ServerBuild("LIVE", 0);
		BUILDLIVE = new ServerBuild("BUILDLIVE", 3);
		RC = new ServerBuild("RC", 1);
		WIP = new ServerBuild("WIP", 2);
	}

	ServerBuild(String var1, int var2) {
		this.name = var1;
		this.field3097 = var2;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Lht;",
		garbageValue = "-1180809125"
	)
	@Export("valueOf")
	public static ServerBuild valueOf(int var0) {
		ServerBuild[] var1 = IsaacCipher.values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			ServerBuild var3 = var1[var2];
			if (var0 == var3.field3097) {
				return var3;
			}
		}

		return null;
	}
}
