import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class170 {
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      longValue = 410873934902022853L
   )
   static long field2329;
   @ObfuscatedName("l")
   public static boolean field2328;
   @ObfuscatedName("qm")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   static class13 field2327;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "272160973"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class176.field2395) {
         class278.field3720 += class176.field2395 - var0;
      }

      class176.field2395 = var0;
      return class278.field3720 + var0;
   }
}
