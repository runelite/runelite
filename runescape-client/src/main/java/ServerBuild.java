import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("ServerBuild")
public class ServerBuild {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("LIVE")
	static final ServerBuild LIVE;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("BUILDLIVE")
	static final ServerBuild BUILDLIVE;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("RC")
	static final ServerBuild RC;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("WIP")
	static final ServerBuild WIP;
	@ObfuscatedName("u")
	@Export("name")
	public final String name;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1354780061
	)
	public final int field3080;

	static {
		LIVE = new ServerBuild("LIVE", 0);
		BUILDLIVE = new ServerBuild("BUILDLIVE", 3);
		RC = new ServerBuild("RC", 1);
		WIP = new ServerBuild("WIP", 2);
	}

	ServerBuild(String var1, int var2) {
		this.name = var1;
		this.field3080 = var2;
	}
}
