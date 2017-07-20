import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class271 {
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;

   @ObfuscatedName("c")
   static final int method4793(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(var2 != 0.0D) {
         double var12;
         if(var4 < 0.5D) {
            var12 = var4 * (1.0D + var2);
         } else {
            var12 = var4 + var2 - var2 * var4;
         }

         double var14 = 2.0D * var4 - var12;
         double var16 = var0 + 0.3333333333333333D;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var14 + var16 * (var12 - var14) * 6.0D;
         } else if(2.0D * var16 < 1.0D) {
            var6 = var12;
         } else if(3.0D * var16 < 2.0D) {
            var6 = var14 + (var12 - var14) * (0.6666666666666666D - var16) * 6.0D;
         } else {
            var6 = var14;
         }

         if(6.0D * var0 < 1.0D) {
            var8 = var0 * 6.0D * (var12 - var14) + var14;
         } else if(var0 * 2.0D < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = 6.0D * (0.6666666666666666D - var0) * (var12 - var14) + var14;
         } else {
            var8 = var14;
         }

         if(var20 * 6.0D < 1.0D) {
            var10 = var14 + 6.0D * (var12 - var14) * var20;
         } else if(var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(var20 * 3.0D < 2.0D) {
            var10 = var14 + (var12 - var14) * (0.6666666666666666D - var20) * 6.0D;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(256.0D * var6);
      int var13 = (int)(256.0D * var8);
      int var23 = (int)(256.0D * var10);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }
}
