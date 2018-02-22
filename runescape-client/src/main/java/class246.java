import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class246 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Llv;B)V",
      garbageValue = "-84"
   )
   static final void method4510(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class36.field471.length; ++var2) {
         class36.field471[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class36.field471[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class36.field467[var5] = (class36.field471[var5 + 128] + class36.field471[var5 - 128] + class36.field471[var5 + 1] + class36.field471[var5 - 1]) / 4;
            }
         }

         int[] var8 = class36.field471;
         class36.field471 = class36.field467;
         class36.field467 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  class36.field471[var7] = 0;
               }
            }
         }
      }

   }
}
