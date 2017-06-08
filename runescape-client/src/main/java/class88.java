import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class88 {
   @ObfuscatedName("ct")
   static class153 field1387;

   @ObfuscatedName("n")
   static final int method1693(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(0.0D != var2) {
         double var12;
         if(var4 < 0.5D) {
            var12 = var4 * (var2 + 1.0D);
         } else {
            var12 = var4 + var2 - var4 * var2;
         }

         double var14 = 2.0D * var4 - var12;
         double var16 = 0.3333333333333333D + var0;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = (var12 - var14) * 6.0D * var16 + var14;
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(3.0D * var16 < 2.0D) {
            var6 = var14 + 6.0D * (var12 - var14) * (0.6666666666666666D - var16);
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = 6.0D * (var12 - var14) * var0 + var14;
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = 6.0D * (var12 - var14) * (0.6666666666666666D - var0) + var14;
         } else {
            var8 = var14;
         }

         if(6.0D * var20 < 1.0D) {
            var10 = 6.0D * (var12 - var14) * var20 + var14;
         } else if(var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = (var12 - var14) * (0.6666666666666666D - var20) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(256.0D * var8);
      int var23 = (int)(256.0D * var10);
      int var15 = (var22 << 16) + (var13 << 8) + var23;
      return var15;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-119"
   )
   public static void method1694() {
      KitDefinition.field3356.reset();
   }
}
