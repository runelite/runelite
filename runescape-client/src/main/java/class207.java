import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public final class class207 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "-1833617239"
   )
   static final void method3764(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class2.field21.length; ++var2) {
         class2.field21[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class2.field21[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class47.field943[var5] = (class2.field21[var5 - 1] + class2.field21[var5 + 1] + class2.field21[var5 - 128] + class2.field21[128 + var5]) / 4;
            }
         }

         int[] var8 = class2.field21;
         class2.field21 = class47.field943;
         class47.field943 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = 16 + var4 + var0.offsetX;
                  int var6 = var0.offsetY + var3 + 16;
                  int var7 = var5 + (var6 << 7);
                  class2.field21[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "77"
   )
   static int method3767(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2299((long)var0);
      if(null == var2) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)[Lclass214;",
      garbageValue = "19938"
   )
   public static class214[] method3768() {
      return new class214[]{class214.field3156, class214.field3155, class214.field3151, class214.field3154, class214.field3153, class214.field3149, class214.field3147, class214.field3143, class214.field3158, class214.field3145, class214.field3152, class214.field3150, class214.field3148, class214.field3144, class214.field3146};
   }
}
