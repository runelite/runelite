import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("ServerBuild")
public class ServerBuild {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("LIVE")
	static final ServerBuild LIVE;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("BUILDLIVE")
	static final ServerBuild BUILDLIVE;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("RC")
	static final ServerBuild RC;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("WIP")
	static final ServerBuild WIP;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1377702413
	)
	static int field3079;
	@ObfuscatedName("l")
	@Export("name")
	public final String name;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2004053653
	)
	public final int field3077;

	static {
		LIVE = new ServerBuild("LIVE", 0);
		BUILDLIVE = new ServerBuild("BUILDLIVE", 3);
		RC = new ServerBuild("RC", 1);
		WIP = new ServerBuild("WIP", 2);
	}

	ServerBuild(String var1, int var2) {
		this.name = var1;
		this.field3077 = var2;
	}
}
