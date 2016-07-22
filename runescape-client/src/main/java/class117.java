import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class117 {
   @ObfuscatedName("s")
   public static class122 field2020;
   @ObfuscatedName("j")
   static int[] field2021;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-28"
   )
   static final int method2507(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2070900772"
   )
   static final void method2508(int var0) {
      if(class122.method2739(var0)) {
         class176[] var1 = class176.field2814[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class176 var3 = var1[var2];
            if(null != var3) {
               var3.field2917 = 0;
               var3.field2864 = 0;
            }
         }

      }
   }
}
