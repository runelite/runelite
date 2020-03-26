import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("ServerBuild")
public class ServerBuild {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("LIVE")
	static final ServerBuild LIVE;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("BUILDLIVE")
	static final ServerBuild BUILDLIVE;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("RC")
	static final ServerBuild RC;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("WIP")
	static final ServerBuild WIP;
	@ObfuscatedName("w")
	@Export("name")
	public final String name;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1808149537
	)
	final int field3101;

	static {
		LIVE = new ServerBuild("LIVE", 0);
		BUILDLIVE = new ServerBuild("BUILDLIVE", 3);
		RC = new ServerBuild("RC", 1);
		WIP = new ServerBuild("WIP", 2);
	}

	ServerBuild(String var1, int var2) {
		this.name = var1;
		this.field3101 = var2;
	}
}
