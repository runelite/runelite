import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("Usernamed")
public interface Usernamed {
	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "(S)Ljq;",
		garbageValue = "9955"
	)
	@Export("username")
	Username username();
}
