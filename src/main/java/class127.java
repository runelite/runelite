import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class127 {
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -408729561
   )
   static int field2020;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -4871019305373839173L
   )
   public static long field2024;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "432000310"
   )
   public static void method2791() {
      class137 var0 = class137.field2089;
      synchronized(class137.field2089) {
         ++class137.field2104;
         class137.field2092 = class137.field2106;
         class137.field2088 = 0;
         int var1;
         if(class137.field2099 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class137.field2095[var1] = false;
            }

            class137.field2099 = class137.field2098;
         } else {
            while(class137.field2099 != class137.field2098) {
               var1 = class137.field2097[class137.field2098];
               class137.field2098 = class137.field2098 + 1 & 127;
               if(var1 < 0) {
                  class137.field2095[~var1] = false;
               } else {
                  if(!class137.field2095[var1] && class137.field2088 < class137.field2102.length - 1) {
                     class137.field2102[++class137.field2088 - 1] = var1;
                  }

                  class137.field2095[var1] = true;
               }
            }
         }

         class137.field2106 = class137.field2105;
      }
   }
}
