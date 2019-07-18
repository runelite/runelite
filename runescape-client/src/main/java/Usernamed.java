import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
@Implements("Usernamed")
public interface Usernamed {
	@ObfuscatedName("ku")
	@ObfuscatedSignature(
		signature = "(B)Ljv;",
		garbageValue = "-19"
	)
	@Export("username")
	Username username();
}
