import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("Enumerated")
public interface Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   @Export("rsOrdinal")
   int rsOrdinal();
}
