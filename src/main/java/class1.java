import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class1 {
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 1116190307
   )
   static int field20;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      longValue = -6534558298251221311L
   )
   static long field26;

   @ObfuscatedName("p")
   public static class82[] method3() {
      return new class82[]{class82.field1436, class82.field1431, class82.field1433, class82.field1430, class82.field1434};
   }

   @ObfuscatedName("w")
   static int method7(class167 var0, class167 var1) {
      int var2 = 0;
      if(var0.method3312("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3312("logo", "")) {
         ++var2;
      }

      if(var1.method3312("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3312("titlebox", "")) {
         ++var2;
      }

      if(var1.method3312("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3312("runes", "")) {
         ++var2;
      }

      if(var1.method3312("title_mute", "")) {
         ++var2;
      }

      if(var1.method3331("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3331("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3312("sl_back", "");
      var1.method3312("sl_flags", "");
      var1.method3312("sl_arrows", "");
      var1.method3312("sl_stars", "");
      var1.method3312("sl_button", "");
      return var2;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "10568"
   )
   static final void method9(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class43.method938(var0, var1, class82.field1437) - var2;
         var0 -= class148.field2249;
         var3 -= class156.field2333;
         var1 -= class173.field2868;
         int var4 = class91.field1573[class29.field698];
         int var5 = class91.field1595[class29.field698];
         int var6 = class91.field1573[class16.field237];
         int var7 = class91.field1595[class16.field237];
         int var8 = var0 * var7 + var6 * var1 >> 16;
         var1 = var7 * var1 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            client.field400 = client.field306 / 2 + client.field560 * var0 / var1;
            client.field401 = client.field559 / 2 + client.field560 * var8 / var1;
         } else {
            client.field400 = -1;
            client.field401 = -1;
         }

      } else {
         client.field400 = -1;
         client.field401 = -1;
      }
   }
}
