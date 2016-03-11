import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class10 extends class106 {
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -21592299
   )
   static int field163;
   @ObfuscatedName("e")
   static int[] field165;
   @ObfuscatedName("av")
   static class167 field168;
   @ObfuscatedName("ph")
   static class8 field169;

   @ObfuscatedName("j")
   protected boolean vmethod2336(int var1, int var2) {
      return super.field1889 == var1 && super.field1885 == var2;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(Lclass172;III)V",
      garbageValue = "2058475429"
   )
   static void method126(class172 var0, int var1, int var2) {
      if(var0.field2764 == 0) {
         var0.field2772 = var0.field2768;
      } else if(1 == var0.field2764) {
         var0.field2772 = var0.field2768 + (var1 - var0.field2774) / 2;
      } else if(2 == var0.field2764) {
         var0.field2772 = var1 - var0.field2774 - var0.field2768;
      } else if(var0.field2764 == 3) {
         var0.field2772 = var1 * var0.field2768 >> 14;
      } else if(4 == var0.field2764) {
         var0.field2772 = (var1 - var0.field2774) / 2 + (var1 * var0.field2768 >> 14);
      } else {
         var0.field2772 = var1 - var0.field2774 - (var0.field2768 * var1 >> 14);
      }

      if(0 == var0.field2866) {
         var0.field2773 = var0.field2769;
      } else if(var0.field2866 == 1) {
         var0.field2773 = (var2 - var0.field2890) / 2 + var0.field2769;
      } else if(2 == var0.field2866) {
         var0.field2773 = var2 - var0.field2890 - var0.field2769;
      } else if(var0.field2866 == 3) {
         var0.field2773 = var0.field2769 * var2 >> 14;
      } else if(4 == var0.field2866) {
         var0.field2773 = (var2 - var0.field2890) / 2 + (var2 * var0.field2769 >> 14);
      } else {
         var0.field2773 = var2 - var0.field2890 - (var0.field2769 * var2 >> 14);
      }

      if(client.field458 && 0 == var0.field2849) {
         if(var0.field2772 < 0) {
            var0.field2772 = 0;
         } else if(var0.field2774 + var0.field2772 > var1) {
            var0.field2772 = var1 - var0.field2774;
         }

         if(var0.field2773 < 0) {
            var0.field2773 = 0;
         } else if(var0.field2890 + var0.field2773 > var2) {
            var0.field2773 = var2 - var0.field2890;
         }
      }

   }

   @ObfuscatedName("af")
   static final void method128(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class29.field692.method3964(var0, 250);
      int var6 = class29.field692.method3965(var0, 250) * 13;
      class79.method1776(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      class79.method1813(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      class29.field692.method3970(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class159.method3134(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class125.field2039.getGraphics();
            class75.field1385.vmethod1842(var7, 0, 0);
         } catch (Exception var12) {
            class125.field2039.repaint();
         }
      } else {
         int var13 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < client.field491; ++var11) {
            if(client.field496[var11] + client.field498[var11] > var13 && client.field496[var11] < var9 + var13 && client.field499[var11] + client.field456[var11] > var8 && client.field456[var11] < var8 + var10) {
               client.field497[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-247729537"
   )
   static final void method129() {
      for(class6 var0 = (class6)client.field422.method3773(); var0 != null; var0 = (class6)client.field422.method3772()) {
         if(var0.field106 == class75.field1386 && client.field394 <= var0.field112) {
            if(client.field394 >= var0.field105) {
               if(var0.field115 > 0) {
                  class34 var1 = client.field324[var0.field115 - 1];
                  if(var1 != null && var1.field839 >= 0 && var1.field839 < 13312 && var1.field848 >= 0 && var1.field848 < 13312) {
                     var0.method85(var1.field839, var1.field848, class105.method2335(var1.field839, var1.field848, var0.field106) - var0.field122, client.field394);
                  }
               }

               if(var0.field115 < 0) {
                  int var2 = -var0.field115 - 1;
                  class2 var3;
                  if(var2 == client.field477) {
                     var3 = class148.field2249;
                  } else {
                     var3 = client.field410[var2];
                  }

                  if(var3 != null && var3.field839 >= 0 && var3.field839 < 13312 && var3.field848 >= 0 && var3.field848 < 13312) {
                     var0.method85(var3.field839, var3.field848, class105.method2335(var3.field839, var3.field848, var0.field106) - var0.field122, client.field394);
                  }
               }

               var0.method92(client.field362);
               class107.field1906.method1886(class75.field1386, (int)var0.field113, (int)var0.field117, (int)var0.field123, 60, var0, var0.field125, -1, false);
            }
         } else {
            var0.method3853();
         }
      }

   }
}
