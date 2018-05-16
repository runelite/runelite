import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public abstract class class166 {
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = 968568857
   )
   static int field2068;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1151514897
   )
   public int field2066;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 533912751
   )
   public int field2067;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -102294039
   )
   public int field2070;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -558364639
   )
   public int field2069;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILfm;I)Z",
      garbageValue = "1081805803"
   )
   public abstract boolean vmethod3457(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1519454732"
   )
   public static synchronized long method3456() {
      long var0 = System.currentTimeMillis();
      if(var0 < class173.field2288) {
         class184.field2380 += class173.field2288 - var0;
      }

      class173.field2288 = var0;
      return class184.field2380 + var0;
   }
}
