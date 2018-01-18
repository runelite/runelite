import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
@Implements("MouseWheel")
public interface MouseWheel {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "27885"
   )
   int useRotation();
}
