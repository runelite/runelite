import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class30 {
   @ObfuscatedName("er")
   static class78[] field695;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2019357385
   )
   int field696;
   @ObfuscatedName("f")
   String field697;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 701202811
   )
   int field698;
   @ObfuscatedName("qs")
   static class132 field703;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 765536297
   )
   int field704;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -145419437
   )
   int field705;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1683965574"
   )
   public static void method664() {
      class136 var0 = class136.field2113;
      synchronized(class136.field2113) {
         ++class136.field2132;
         class136.field2129 = class136.field2131;
         class136.field2128 = 0;
         int var1;
         if(class136.field2124 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class136.field2121[var1] = false;
            }

            class136.field2124 = class136.field2123;
         } else {
            while(class136.field2124 != class136.field2123) {
               var1 = class136.field2134[class136.field2123];
               class136.field2123 = class136.field2123 + 1 & 127;
               if(var1 < 0) {
                  class136.field2121[~var1] = false;
               } else {
                  if(!class136.field2121[var1] && class136.field2128 < class136.field2127.length - 1) {
                     class136.field2127[++class136.field2128 - 1] = var1;
                  }

                  class136.field2121[var1] = true;
               }
            }
         }

         class136.field2131 = class136.field2130;
      }
   }
}
