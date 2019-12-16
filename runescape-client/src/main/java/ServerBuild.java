import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("ServerBuild")
public class ServerBuild {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("LIVE")
	public static final ServerBuild LIVE;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("BUILDLIVE")
	public static final ServerBuild BUILDLIVE;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("RC")
	public static final ServerBuild RC;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("WIP")
	public static final ServerBuild WIP;
	@ObfuscatedName("dv")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive10")
	static Archive archive10;
	@ObfuscatedName("p")
	@Export("name")
	public final String name;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 135493903
	)
	public final int field3081;

	static {
		LIVE = new ServerBuild("LIVE", 0);
		BUILDLIVE = new ServerBuild("BUILDLIVE", 3);
		RC = new ServerBuild("RC", 1);
		WIP = new ServerBuild("WIP", 2);
	}

	ServerBuild(String var1, int var2) {
		this.name = var1;
		this.field3081 = var2;
	}

	@ObfuscatedName("f")
	public static final void method4111(long var0) {
		if (var0 > 0L) {
			if (var0 % 10L == 0L) {
				class188.method3604(var0 - 1L);
				class188.method3604(1L);
			} else {
				class188.method3604(var0);
			}

		}
	}
}
