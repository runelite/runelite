import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("MouseWheel")
public interface MouseWheel {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-19384"
   )
   int useRotation();
}
