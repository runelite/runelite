import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class88 {
   @ObfuscatedName("x")
   static class182 field1550;

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-785181784"
   )
   static final void method1936(Actor var0) {
      int var1 = var0.field671 - Client.gameCycle;
      int var2 = var0.field672 * 64 + var0.field650 * 128;
      int var3 = var0.field669 * 128 + var0.field672 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field683 = 0;
      var0.field676 = var0.field673;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "128"
   )
   public static int method1937(int var0) {
      Varbit var1 = class167.method3195(var0);
      int var2 = var1.leastSignificantBit;
      int var3 = var1.configId;
      int var4 = var1.mostSignificantBit;
      int var5 = class165.field2156[var4 - var3];
      return class165.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1478375417"
   )
   public static void method1938() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         ++class105.keyboardIdleTicks;
         class105.field1724 = class105.field1728;
         class105.field1716 = 0;
         int var1;
         if(class105.field1721 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class105.field1725[var1] = false;
            }

            class105.field1721 = class105.field1720;
         } else {
            while(class105.field1721 != class105.field1720) {
               var1 = class105.field1726[class105.field1720];
               class105.field1720 = 1 + class105.field1720 & 127;
               if(var1 < 0) {
                  class105.field1725[~var1] = false;
               } else {
                  if(!class105.field1725[var1] && class105.field1716 < class105.field1735.length - 1) {
                     class105.field1735[++class105.field1716 - 1] = var1;
                  }

                  class105.field1725[var1] = true;
               }
            }
         }

         if(class105.field1716 > 0) {
            class105.keyboardIdleTicks = 0;
         }

         class105.field1728 = class105.field1727;
      }
   }
}
