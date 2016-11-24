import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class202 {
   @ObfuscatedName("e")
   static int[] field3064;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-68"
   )
   public static synchronized long method3838() {
      long var0 = System.currentTimeMillis();
      if(var0 < class162.field2309) {
         class162.field2306 += class162.field2309 - var0;
      }

      class162.field2309 = var0;
      return var0 + class162.field2306;
   }
}
