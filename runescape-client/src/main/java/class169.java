import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class169 {
   @ObfuscatedName("k")
   public static class170 field2712;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2142734263"
   )
   public static synchronized long method3276() {
      long var0 = System.currentTimeMillis();
      if(var0 < class118.field2032) {
         class166.field2694 += class118.field2032 - var0;
      }

      class118.field2032 = var0;
      return class166.field2694 + var0;
   }
}
