import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class154 {
   @ObfuscatedName("bi")
   static class184 field2094;
   @ObfuscatedName("y")
   static byte[][] field2095 = new byte[250][];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1605015221
   )
   static int field2096 = 0;
   @ObfuscatedName("v")
   static byte[][] field2097 = new byte[1000][];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1932468775
   )
   static int field2098 = 0;
   @ObfuscatedName("p")
   static byte[][] field2099 = new byte[50][];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1962467035
   )
   static int field2100 = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;B)V",
      garbageValue = "41"
   )
   static void method3104(Font var0, Font var1) {
      if(class157.field2114 == null) {
         class157.field2114 = class149.method2849(class39.field808, "sl_back", "");
      }

      if(Script.field960 == null) {
         Script.field960 = XItemContainer.method169(class39.field808, "sl_flags", "");
      }

      if(class39.field806 == null) {
         class39.field806 = XItemContainer.method169(class39.field808, "sl_arrows", "");
      }

      if(class139.field1955 == null) {
         class139.field1955 = XItemContainer.method169(class39.field808, "sl_stars", "");
      }

      Rasterizer2D.method4056(class41.field822, 23, 765, 480, 0);
      Rasterizer2D.method4043(class41.field822, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method4043(125 + class41.field822, 0, 640, 23, 5197647, 2697513);
      var0.method3912("Select a world", 62 + class41.field822, 15, 0, -1);
      if(null != class139.field1955) {
         class139.field1955[1].method4115(140 + class41.field822, 1);
         var1.method3973("Members only world", 152 + class41.field822, 10, 16777215, -1);
         class139.field1955[0].method4115(class41.field822 + 140, 12);
         var1.method3973("Free world", class41.field822 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class39.field806 != null) {
         int var2 = 280 + class41.field822;
         if(World.field678[0] == 0 && World.field684[0] == 0) {
            class39.field806[2].method4115(var2, 4);
         } else {
            class39.field806[0].method4115(var2, 4);
         }

         if(World.field678[0] == 0 && World.field684[0] == 1) {
            class39.field806[3].method4115(var2 + 15, 4);
         } else {
            class39.field806[1].method4115(var2 + 15, 4);
         }

         var0.method3973("World", var2 + 32, 17, 16777215, -1);
         int var3 = class41.field822 + 390;
         if(World.field678[0] == 1 && World.field684[0] == 0) {
            class39.field806[2].method4115(var3, 4);
         } else {
            class39.field806[0].method4115(var3, 4);
         }

         if(World.field678[0] == 1 && World.field684[0] == 1) {
            class39.field806[3].method4115(var3 + 15, 4);
         } else {
            class39.field806[1].method4115(15 + var3, 4);
         }

         var0.method3973("Players", 32 + var3, 17, 16777215, -1);
         var4 = 500 + class41.field822;
         if(World.field678[0] == 2 && World.field684[0] == 0) {
            class39.field806[2].method4115(var4, 4);
         } else {
            class39.field806[0].method4115(var4, 4);
         }

         if(World.field678[0] == 2 && World.field684[0] == 1) {
            class39.field806[3].method4115(15 + var4, 4);
         } else {
            class39.field806[1].method4115(15 + var4, 4);
         }

         var0.method3973("Location", var4 + 32, 17, 16777215, -1);
         var5 = class41.field822 + 610;
         if(World.field678[0] == 3 && World.field684[0] == 0) {
            class39.field806[2].method4115(var5, 4);
         } else {
            class39.field806[0].method4115(var5, 4);
         }

         if(World.field678[0] == 3 && World.field684[0] == 1) {
            class39.field806[3].method4115(var5 + 15, 4);
         } else {
            class39.field806[1].method4115(15 + var5, 4);
         }

         var0.method3973("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method4056(708 + class41.field822, 4, 50, 16, 0);
      var1.method3912("Cancel", 25 + class41.field822 + 708, 16, 16777215, -1);
      class41.field823 = -1;
      if(class157.field2114 != null) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (1 + var23);
         var5 = 480 / (1 + var24);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= World.field675) {
               --var4;
            }

            if((var5 - 1) * var4 >= World.field675) {
               --var5;
            }

            if((var5 - 1) * var4 >= World.field675) {
               --var5;
            }
         } while(var5 != var6 || var7 != var4);

         var6 = (765 - var23 * var4) / (1 + var4);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var24 * var5) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var5 * var24 - var7 * (var5 - 1)) / 2;
         int var10 = 23 + var9;
         int var11 = var8 + class41.field822;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field675; ++var14) {
            World var15 = CombatInfoListHolder.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method653()) {
               if(var15.method658()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method652()) {
               var19 = 16711680;
               if(var15.method658()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method650()) {
               if(var15.method658()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method658()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class115.field1805 >= var11 && class115.field1806 >= var10 && class115.field1805 < var23 + var11 && class115.field1806 < var10 + var24 && var16) {
               class41.field823 = var14;
               class157.field2114[var18].method4178(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class157.field2114[var18].method4172(var11, var10);
            }

            if(null != Script.field960) {
               Script.field960[(var15.method658()?8:0) + var15.location].method4115(var11 + 29, var10);
            }

            var0.method3912(Integer.toString(var15.id), 15 + var11, 5 + var24 / 2 + var10, var19, -1);
            var1.method3912(var17, var11 + 60, 5 + var10 + var24 / 2, 268435455, -1);
            var10 += var24 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var6 + var23;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method3904(CombatInfoListHolder.worldList[class41.field823].activity) + 6;
            int var20 = var1.field3112 + 8;
            Rasterizer2D.method4056(class115.field1805 - var14 / 2, 5 + 20 + class115.field1806, var14, var20, 16777120);
            Rasterizer2D.method4012(class115.field1805 - var14 / 2, 20 + class115.field1806 + 5, var14, var20, 0);
            var1.method3912(CombatInfoListHolder.worldList[class41.field823].activity, class115.field1805, 20 + class115.field1806 + 5 + var1.field3112 + 4, 0, -1);
         }
      }

      try {
         Graphics var21 = class110.canvas.getGraphics();
         class57.bufferProvider.draw(var21, 0, 0);
      } catch (Exception var22) {
         class110.canvas.repaint();
      }

   }

   class154() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1033370004"
   )
   static synchronized byte[] method3107(int var0) {
      byte[] var1;
      if(var0 == 100 && field2096 > 0) {
         var1 = field2097[--field2096];
         field2097[field2096] = null;
         return var1;
      } else if(var0 == 5000 && field2098 > 0) {
         var1 = field2095[--field2098];
         field2095[field2098] = null;
         return var1;
      } else if(var0 == 30000 && field2100 > 0) {
         var1 = field2099[--field2100];
         field2099[field2100] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
