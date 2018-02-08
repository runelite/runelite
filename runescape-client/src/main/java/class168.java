import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public abstract class class168 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ldh;"
   )
   public static class111 field2232;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1190901335
   )
   static int field2235;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 152209809
   )
   public int field2229;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -204526229
   )
   public int field2228;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -662880617
   )
   public int field2233;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 392644993
   )
   public int field2231;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILfb;I)Z",
      garbageValue = "1240062680"
   )
   protected abstract boolean vmethod3396(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([I[II)V",
      garbageValue = "-1010129331"
   )
   public static void method3399(int[] var0, int[] var1) {
      if(var0 != null && var1 != null) {
         FileOnDisk.field1475 = var0;
         TotalQuantityComparator.field287 = new int[var0.length];
         class225.field2731 = new byte[var0.length][][];

         for(int var2 = 0; var2 < FileOnDisk.field1475.length; ++var2) {
            class225.field2731[var2] = new byte[var1[var2]][];
         }

      } else {
         FileOnDisk.field1475 = null;
         TotalQuantityComparator.field287 = null;
         class225.field2731 = null;
      }
   }
}
