import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1543507565
   )
   @Export("y")
   int y;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = -119925087
   )
   static int field2120;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 109902883
   )
   @Export("z")
   int z;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1026323817
   )
   @Export("x")
   int x;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1964359242"
   )
   public static void method2912() {
      class50 var0 = class50.keyboard;
      synchronized(class50.keyboard) {
         ++class50.keyboardIdleTicks;
         class50.field621 = class50.field635;
         class50.field641 = 0;
         int var1;
         if(class50.field628 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class50.field624[var1] = false;
            }

            class50.field628 = class50.field631;
         } else {
            while(class50.field628 != class50.field631) {
               var1 = class50.field617[class50.field631];
               class50.field631 = class50.field631 + 1 & 127;
               if(var1 < 0) {
                  class50.field624[~var1] = false;
               } else {
                  if(!class50.field624[var1] && class50.field641 < class50.field629.length - 1) {
                     class50.field629[++class50.field641 - 1] = var1;
                  }

                  class50.field624[var1] = true;
               }
            }
         }

         if(class50.field641 > 0) {
            class50.keyboardIdleTicks = 0;
         }

         class50.field635 = class50.field634;
      }
   }
}
