import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public final class class150 {
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIZB)V",
      garbageValue = "59"
   )
   static void method3116(class173[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class173 var6 = var0[var5];
         if(var6 != null && var6.field2763 == var1) {
            class98.method2194(var6, var2, var3, var4);
            class102.method2272(var6, var2, var3);
            if(var6.field2765 > var6.field2837 - var6.field2840) {
               var6.field2765 = var6.field2837 - var6.field2840;
            }

            if(var6.field2765 < 0) {
               var6.field2765 = 0;
            }

            if(var6.field2766 > var6.field2784 - var6.field2746) {
               var6.field2766 = var6.field2784 - var6.field2746;
            }

            if(var6.field2766 < 0) {
               var6.field2766 = 0;
            }

            if(var6.field2820 == 0) {
               class116.method2448(var0, var6, var4);
            }
         }
      }

   }
}
