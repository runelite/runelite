import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class133 {
   @ObfuscatedName("x")
   static final class133 field2106 = new class133(0);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -201805017
   )
   public final int field2107;
   @ObfuscatedName("j")
   static final class133 field2108 = new class133(2);
   @ObfuscatedName("r")
   public static final class133 field2110 = new class133(1);

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class133(int var1) {
      this.field2107 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "-451580898"
   )
   static void method2883(GameEngine var0) {
      if(class143.field2198 == 1 || !class134.field2117 && class143.field2198 == 4) {
         int var1 = class33.field745 + 280;
         if(class143.field2211 >= var1 && class143.field2211 <= 14 + var1 && class143.field2213 >= 4 && class143.field2213 <= 18) {
            class34.method711(0, 0);
            return;
         }

         if(class143.field2211 >= var1 + 15 && class143.field2211 <= 80 + var1 && class143.field2213 >= 4 && class143.field2213 <= 18) {
            class34.method711(0, 1);
            return;
         }

         int var2 = class33.field745 + 390;
         if(class143.field2211 >= var2 && class143.field2211 <= 14 + var2 && class143.field2213 >= 4 && class143.field2213 <= 18) {
            class34.method711(1, 0);
            return;
         }

         if(class143.field2211 >= var2 + 15 && class143.field2211 <= var2 + 80 && class143.field2213 >= 4 && class143.field2213 <= 18) {
            class34.method711(1, 1);
            return;
         }

         int var3 = 500 + class33.field745;
         if(class143.field2211 >= var3 && class143.field2211 <= 14 + var3 && class143.field2213 >= 4 && class143.field2213 <= 18) {
            class34.method711(2, 0);
            return;
         }

         if(class143.field2211 >= 15 + var3 && class143.field2211 <= var3 + 80 && class143.field2213 >= 4 && class143.field2213 <= 18) {
            class34.method711(2, 1);
            return;
         }

         int var4 = 610 + class33.field745;
         if(class143.field2211 >= var4 && class143.field2211 <= var4 + 14 && class143.field2213 >= 4 && class143.field2213 <= 18) {
            class34.method711(3, 0);
            return;
         }

         if(class143.field2211 >= var4 + 15 && class143.field2211 <= var4 + 80 && class143.field2213 >= 4 && class143.field2213 <= 18) {
            class34.method711(3, 1);
            return;
         }

         if(class143.field2211 >= 708 + class33.field745 && class143.field2213 >= 4 && class143.field2211 <= 50 + class33.field745 + 708 && class143.field2213 <= 20) {
            class33.worldSelectShown = false;
            class40.field883.method1738(class33.field745, 0);
            class13.field195.method1738(class33.field745 + 382, 0);
            class162.field2660.method1896(382 + class33.field745 - class162.field2660.originalWidth / 2, 18);
            return;
         }

         if(class33.field752 != -1) {
            World var5 = class35.worldList[class33.field752];
            class85.selectWorld(var5);
            class33.worldSelectShown = false;
            class40.field883.method1738(class33.field745, 0);
            class13.field195.method1738(382 + class33.field745, 0);
            class162.field2660.method1896(class33.field745 + 382 - class162.field2660.originalWidth / 2, 18);
            return;
         }
      }

   }
}
