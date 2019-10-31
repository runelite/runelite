import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("Usernamed")
public interface Usernamed {
	@ObfuscatedName("lz")
	@ObfuscatedSignature(
		signature = "(S)Lju;",
		garbageValue = "1353"
	)
	@Export("username")
	Username username();
}
