import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("Usernamed")
public interface Usernamed {
	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		signature = "(I)Ljz;",
		garbageValue = "2135870107"
	)
	@Export("username")
	Username username();
}
