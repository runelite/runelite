import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class106 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1971304089
   )
   public static int field1875;
   @ObfuscatedName("p")
   public static int[][] field1876 = new int[128][128];
   @ObfuscatedName("b")
   public static int[] field1880 = new int[4096];
   @ObfuscatedName("hl")
   @Export("localPlayer")
   static class2 field1881;
   @ObfuscatedName("k")
   public static int[] field1886 = new int[4096];
   @ObfuscatedName("x")
   public static int[][] field1888 = new int[128][128];

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIIIIII)V",
      garbageValue = "964677959"
   )
   static final void method2367(class173 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field361) {
         client.field362 = 32;
      } else {
         client.field362 = 0;
      }

      client.field361 = false;
      int var7;
      if(1 == class140.field2161 || !class89.field1563 && 4 == class140.field2161) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < 16 + var2) {
            var0.field2787 -= 4;
            class34.method701(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.field2787 += 4;
            class34.method701(var0);
         } else if(var5 >= var1 - client.field362 && var5 < client.field362 + 16 + var1 && var6 >= var2 + 16 && var6 < var2 + var3 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2787 = var8 * (var4 - var3) / var9;
            class34.method701(var0);
            client.field361 = true;
         }
      }

      if(client.field475 != 0) {
         var7 = var0.field2886;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < 16 + var1 && var6 <= var3 + var2) {
            var0.field2787 += client.field475 * 45;
            class34.method701(var0);
         }
      }

   }
}
