import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("Usernamed")
public interface Usernamed {
	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "(I)Lku;",
		garbageValue = "-1860083598"
	)
	@Export("username")
	Username username();
}
