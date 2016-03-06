package net.runelite.rs.client;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("i")
@Implements("WidgetNode")
public class class3 extends class207 {
   @ObfuscatedName("aj")
   static class80[] field60;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1848246689
   )
   int field61;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -656968593
   )
   public static int field62;
   @ObfuscatedName("kd")
   static class19 field63;
   @ObfuscatedName("r")
   static class80 field64;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 615686255
   )
   @Export("id")
   int field66;
   @ObfuscatedName("a")
   boolean field67 = false;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 2116445485
   )
   public static int field70;

   @ObfuscatedName("o")
   static void method32(String var0, String var1, String var2) {
      class31.field728 = var0;
      class31.field729 = var1;
      class31.field720 = var2;
   }

   @ObfuscatedName("l")
   static final void method33(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class5.field97[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class5.field93[0][var5][var4] = class5.field93[0][var5 - 1][var4];
               }

               if(var2 + var0 == var5 && var5 < 103) {
                  class5.field93[0][var5][var4] = class5.field93[0][1 + var5][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class5.field93[0][var5][var4] = class5.field93[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class5.field93[0][var5][var4] = class5.field93[0][var5][1 + var4];
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   static void method34(class223 var0, class223 var1) {
      if(null == class29.field688) {
         class29.field688 = class129.method2761(class157.field2595, "sl_back", "");
      }

      if(null == field60) {
         field60 = class160.method3138(class157.field2595, "sl_flags", "");
      }

      if(class22.field598 == null) {
         class22.field598 = class160.method3138(class157.field2595, "sl_arrows", "");
      }

      if(null == class1.field29) {
         class1.field29 = class160.method3138(class157.field2595, "sl_stars", "");
      }

      class79.method1776(class31.field732, 23, 765, 480, 0);
      class79.method1777(class31.field732, 0, 125, 23, 12425273, 9135624);
      class79.method1777(125 + class31.field732, 0, 640, 23, 5197647, 2697513);
      var0.method4039("Select a world", 62 + class31.field732, 15, 0, -1);
      if(class1.field29 != null) {
         class1.field29[1].method1838(class31.field732 + 140, 1);
         var1.method3967("Members only world", class31.field732 + 152, 10, 16777215, -1);
         class1.field29[0].method1838(class31.field732 + 140, 12);
         var1.method3967("Free world", class31.field732 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class22.field598 != null) {
         int var2 = 280 + class31.field732;
         if(class25.field636[0] == 0 && class25.field645[0] == 0) {
            class22.field598[2].method1838(var2, 4);
         } else {
            class22.field598[0].method1838(var2, 4);
         }

         if(class25.field636[0] == 0 && 1 == class25.field645[0]) {
            class22.field598[3].method1838(var2 + 15, 4);
         } else {
            class22.field598[1].method1838(15 + var2, 4);
         }

         var0.method3967("World", 32 + var2, 17, 16777215, -1);
         int var3 = class31.field732 + 390;
         if(1 == class25.field636[0] && 0 == class25.field645[0]) {
            class22.field598[2].method1838(var3, 4);
         } else {
            class22.field598[0].method1838(var3, 4);
         }

         if(class25.field636[0] == 1 && 1 == class25.field645[0]) {
            class22.field598[3].method1838(15 + var3, 4);
         } else {
            class22.field598[1].method1838(15 + var3, 4);
         }

         var0.method3967("Players", 32 + var3, 17, 16777215, -1);
         var4 = 500 + class31.field732;
         if(class25.field636[0] == 2 && class25.field645[0] == 0) {
            class22.field598[2].method1838(var4, 4);
         } else {
            class22.field598[0].method1838(var4, 4);
         }

         if(class25.field636[0] == 2 && 1 == class25.field645[0]) {
            class22.field598[3].method1838(var4 + 15, 4);
         } else {
            class22.field598[1].method1838(15 + var4, 4);
         }

         var0.method3967("Location", 32 + var4, 17, 16777215, -1);
         var5 = class31.field732 + 610;
         if(3 == class25.field636[0] && class25.field645[0] == 0) {
            class22.field598[2].method1838(var5, 4);
         } else {
            class22.field598[0].method1838(var5, 4);
         }

         if(3 == class25.field636[0] && class25.field645[0] == 1) {
            class22.field598[3].method1838(var5 + 15, 4);
         } else {
            class22.field598[1].method1838(var5 + 15, 4);
         }

         var0.method3967("Type", var5 + 32, 17, 16777215, -1);
      }

      class79.method1776(708 + class31.field732, 4, 50, 16, 0);
      var1.method4039("Cancel", class31.field732 + 708 + 25, 16, 16777215, -1);
      class31.field739 = -1;
      if(null != class29.field688) {
         byte var21 = 88;
         byte var23 = 19;
         var4 = 765 / (1 + var21);
         var5 = 480 / (var23 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= class25.field633) {
               --var4;
            }

            if(var4 * (var5 - 1) >= class25.field633) {
               --var5;
            }

            if((var5 - 1) * var4 >= class25.field633) {
               --var5;
            }
         } while(var6 != var5 || var7 != var4);

         var6 = (765 - var21 * var4) / (1 + var4);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var23 * var5) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var4 * var21 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var23 - (var5 - 1) * var7) / 2;
         int var10 = 23 + var9;
         int var11 = var8 + class31.field732;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < class25.field633; ++var14) {
            class25 var15 = class25.field632[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.field639);
            if(-1 == var15.field639) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.field639 > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method597()) {
               if(var15.method612()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method601()) {
               var19 = 16711680;
               if(var15.method612()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method602()) {
               if(var15.method612()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method612()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class139.field2162 >= var11 && class139.field2171 >= var10 && class139.field2162 < var11 + var21 && class139.field2171 < var10 + var23 && var16) {
               class31.field739 = var14;
               class29.field688[var18].method1696(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class29.field688[var18].method1744(var11, var10);
            }

            if(null != field60) {
               field60[(var15.method612()?8:0) + var15.field635].method1838(var11 + 29, var10);
            }

            var0.method4039(Integer.toString(var15.field637), 15 + var11, var10 + var23 / 2 + 5, var19, -1);
            var1.method4039(var17, 60 + var11, 5 + var23 / 2 + var10, 268435455, -1);
            var10 += var7 + var23;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 += var21 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method3962(class25.field632[class31.field739].field641) + 6;
            int var24 = 8 + var1.field3182;
            class79.method1776(class139.field2162 - var14 / 2, class139.field2171 + 20 + 5, var14, var24, 16777120);
            class79.method1813(class139.field2162 - var14 / 2, 20 + class139.field2171 + 5, var14, var24, 0);
            var1.method4039(class25.field632[class31.field739].field641, class139.field2162, var1.field3182 + 5 + class139.field2171 + 20 + 4, 0, -1);
         }
      }

      try {
         Graphics var22 = class125.field2039.getGraphics();
         class75.field1385.vmethod1842(var22, 0, 0);
      } catch (Exception var20) {
         class125.field2039.repaint();
      }

   }

   @ObfuscatedName("a")
   static void method35() {
      class226 var0 = null;

      try {
         var0 = class0.method1("", client.field350.field2295, true);
         class118 var1 = class10.field169.method99();
         var0.method4061(var1.field1995, 0, var1.field1998);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4069();
         }
      } catch (Exception var2) {
         ;
      }

   }
}
