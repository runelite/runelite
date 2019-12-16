import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
@Implements("MouseWheel")
public interface MouseWheel {
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "582157405"
	)
	@Export("useRotation")
	int useRotation();
}
