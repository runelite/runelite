import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("Usernamed")
public interface Usernamed {
	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		signature = "(B)Ljb;",
		garbageValue = "70"
	)
	@Export("username")
	Username username();
}
