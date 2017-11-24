import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
final class class17 implements Comparator {
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;I)I",
      garbageValue = "-1585672291"
   )
   int method137(class14 var1, class14 var2) {
      return var1.field274.price < var2.field274.price?-1:(var2.field274.price == var1.field274.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method137((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2126981037"
   )
   public static int method145(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1785800458"
   )
   public static int method146(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgv;I)I",
      garbageValue = "-2012918057"
   )
   static int method144(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }
}
