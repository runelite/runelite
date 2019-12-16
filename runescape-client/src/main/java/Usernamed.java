import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("Usernamed")
public interface Usernamed {
	@ObfuscatedName("lv")
	@ObfuscatedSignature(
		signature = "(I)Ljc;",
		garbageValue = "83008429"
	)
	@Export("username")
	Username username();
}
