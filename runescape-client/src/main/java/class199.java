import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class199 {
   @ObfuscatedName("ai")
   static int[] field2604;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "61"
   )
   public static boolean method3845(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
