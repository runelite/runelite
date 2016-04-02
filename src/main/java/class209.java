import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public final class class209 {
   @ObfuscatedName("w")
   public static String field3117;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1367516901
   )
   public static int field3118;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1478736946"
   )
   static void method3920(int var0) {
      if(-1 != var0) {
         if(class113.method2462(var0)) {
            class173[] var1 = class173.field2837[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class173 var3 = var1[var2];
               if(null != var3.field2836) {
                  class0 var4 = new class0();
                  var4.field2 = var3;
                  var4.field11 = var3.field2836;
                  class28.method652(var4, 2000000);
               }
            }

         }
      }
   }
}
