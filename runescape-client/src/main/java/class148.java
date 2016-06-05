import java.applet.Applet;
import java.awt.Font;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class148 extends RuntimeException {
   @ObfuscatedName("z")
   String field2256;
   @ObfuscatedName("i")
   static Applet field2257;
   @ObfuscatedName("r")
   Throwable field2261;
   @ObfuscatedName("qa")
   protected static Font field2262;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-31001"
   )
   public static void method3088() {
      class44.field1026.method3717();
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIIIIIB)V",
      garbageValue = "-15"
   )
   static final void method3089(class173 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field457) {
         client.field366 = 32;
      } else {
         client.field366 = 0;
      }

      client.field457 = false;
      int var7;
      if(class140.field2178 == 1 || !class101.field1755 && class140.field2178 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.field2861 -= 4;
            class20.method547(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.field2861 += 4;
            class20.method547(var0);
         } else if(var5 >= var1 - client.field366 && var5 < client.field366 + 16 + var1 && var6 >= 16 + var2 && var6 < var2 + var3 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2861 = (var4 - var3) * var8 / var9;
            class20.method547(var0);
            client.field457 = true;
         }
      }

      if(client.field480 != 0) {
         var7 = var0.field2791;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < 16 + var1 && var6 <= var3 + var2) {
            var0.field2861 += client.field480 * 45;
            class20.method547(var0);
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "581438339"
   )
   static final void method3100(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class116.field1988.field138 = !class116.field1988.field138;
         class25.method590();
         if(class116.field1988.field138) {
            class33.method702(99, "", "Roofs are now all hidden");
         } else {
            class33.method702(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         client.field376 = !client.field376;
      }

      if(client.field449 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            client.field376 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            client.field376 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class141.method2953();
         }

         if(var0.equalsIgnoreCase("errortest") && client.field384 == 2) {
            throw new RuntimeException();
         }
      }

      client.field325.method2733(205);
      client.field325.method2453(var0.length() + 1);
      client.field325.method2586(var0);
   }
}
