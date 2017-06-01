import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class54 {
   @ObfuscatedName("q")
   static class234 field677;

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1811056827"
   )
   static boolean method775(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass289;B)I",
      garbageValue = "72"
   )
   static final int method776(class289 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3843) {
         case 8:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("i")
   static final int method778(double var0, double var2, double var4) {
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

         double var14 = var4 * 2.0D - var12;
         double var16 = 0.3333333333333333D + var0;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var16 * (var12 - var14) * 6.0D + var14;
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(var16 * 3.0D < 2.0D) {
            var6 = var14 + 6.0D * (0.6666666666666666D - var16) * (var12 - var14);
         } else {
            var6 = var14;
         }

         if(6.0D * var0 < 1.0D) {
            var8 = var14 + var0 * (var12 - var14) * 6.0D;
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = (0.6666666666666666D - var0) * (var12 - var14) * 6.0D + var14;
         } else {
            var8 = var14;
         }

         if(6.0D * var20 < 1.0D) {
            var10 = var14 + var20 * 6.0D * (var12 - var14);
         } else if(var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(var20 * 3.0D < 2.0D) {
            var10 = (var12 - var14) * (0.6666666666666666D - var20) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(256.0D * var6);
      int var13 = (int)(256.0D * var8);
      int var23 = (int)(var10 * 256.0D);
      int var15 = var23 + (var22 << 16) + (var13 << 8);
      return var15;
   }
}
