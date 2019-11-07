import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class60 {
	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("loginType")
	static LoginType loginType;

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)[Lhp;",
		garbageValue = "66"
	)
	public static StudioGame[] method1260() {
		return new StudioGame[]{StudioGame.game5, StudioGame.runescape, StudioGame.game3, StudioGame.game4, StudioGame.oldscape, StudioGame.stellardawn};
	}
}
