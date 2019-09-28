import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
@Implements("MouseWheel")
public interface MouseWheel {
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-125"
	)
	@Export("useRotation")
	int useRotation();
}
