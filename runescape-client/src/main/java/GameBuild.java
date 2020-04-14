import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("GameBuild")
public class GameBuild {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("LIVE")
	static final GameBuild LIVE;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("BUILDLIVE")
	static final GameBuild BUILDLIVE;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("RC")
	static final GameBuild RC;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("WIP")
	static final GameBuild WIP;
	@ObfuscatedName("w")
	@Export("name")
	public final String name;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1808149537
	)
	@Export("buildId")
	final int buildId;

	static {
		LIVE = new GameBuild("LIVE", 0);
		BUILDLIVE = new GameBuild("BUILDLIVE", 3);
		RC = new GameBuild("RC", 1);
		WIP = new GameBuild("WIP", 2);
	}

	GameBuild(String var1, int var2) {
		this.name = var1;
		this.buildId = var2;
	}
}
