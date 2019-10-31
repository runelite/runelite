import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
@Implements("ServerBuild")
public class ServerBuild {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	@Export("LIVE")
	public static final ServerBuild LIVE;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	@Export("BUILDLIVE")
	public static final ServerBuild BUILDLIVE;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	@Export("RC")
	public static final ServerBuild RC;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	@Export("WIP")
	public static final ServerBuild WIP;
	@ObfuscatedName("v")
	@Export("name")
	public final String name;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -96016129
	)
	public final int field3088;

	static {
		LIVE = new ServerBuild("LIVE", 0);
		BUILDLIVE = new ServerBuild("BUILDLIVE", 3);
		RC = new ServerBuild("RC", 1);
		WIP = new ServerBuild("WIP", 2);
	}

	ServerBuild(String var1, int var2) {
		this.name = var1;
		this.field3088 = var2;
	}

	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "(IIIIIIII)V",
		garbageValue = "1070520785"
	)
	@Export("updateRootInterface")
	static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (TextureProvider.loadInterface(var0)) {
			ArchiveLoader.updateInterface(Widget.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
		}
	}
}
