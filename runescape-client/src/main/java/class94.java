import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public final class class94 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 975986679
   )
   int field1571;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -239567555
   )
   int field1572;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -744668407
   )
   int field1573;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 581663087
   )
   int field1574;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 392805209
   )
   int field1575;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 537427863
   )
   int field1576;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1924008737
   )
   int field1577;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -788378201
   )
   int field1578;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1909424079
   )
   int field1579;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -961415597
   )
   int field1580;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1872193669
   )
   int field1581;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 664871605
   )
   int field1582;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -925610357
   )
   int field1584;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -815771237
   )
   int field1585;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 369840609
   )
   int field1586;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1983722265
   )
   int field1587;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1658367627
   )
   int field1588;
   @ObfuscatedName("qk")
   static class109 field1589;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 703881645
   )
   int field1590;
   @ObfuscatedName("ej")
   static SpritePixels[] field1591;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-904800501"
   )
   static void method1900(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2331((long)var0);
      if(null != var1) {
         var1.unlink();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-59"
   )
   public static int method1901(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1303442867"
   )
   public static void method1902() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         ++class105.keyboardIdleTicks;
         class105.field1718 = class105.field1717;
         class105.field1716 = 0;
         int var1;
         if(class105.field1719 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class105.field1712[var1] = false;
            }

            class105.field1719 = class105.field1711;
         } else {
            while(class105.field1711 != class105.field1719) {
               var1 = class105.field1710[class105.field1711];
               class105.field1711 = 1 + class105.field1711 & 127;
               if(var1 < 0) {
                  class105.field1712[~var1] = false;
               } else {
                  if(!class105.field1712[var1] && class105.field1716 < class105.field1715.length - 1) {
                     class105.field1715[++class105.field1716 - 1] = var1;
                  }

                  class105.field1712[var1] = true;
               }
            }
         }

         class105.field1717 = class105.field1713;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)LSpritePixels;",
      garbageValue = "-70"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var2 << 38) + (long)var0 + ((long)var1 << 16);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = PlayerComposition.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = PlayerComposition.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(null == var21) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.notedTemplate != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var22) {
               return null;
            }
         } else if(var9.field2968 != -1) {
            var22 = createSprite(var9.field2938, var1, var2, var3, 0, false);
            if(null == var22) {
               return null;
            }
         } else if(var9.field2952 != -1) {
            var22 = createSprite(var9.field2978, var1, 0, 0, 0, false);
            if(null == var22) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method3975(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method3977();
         class84.method1642();
         class84.method1646(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field2952 != -1) {
            var22.method4121(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * class84.field1428[var9.xan2d] >> 16;
         int var18 = var16 * class84.field1452[var9.xan2d] >> 16;
         var21.method1568();
         var21.method1580(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var21.modelHeight / 2 + var17 + var9.offsetY2d, var9.offsetY2d + var18);
         if(var9.field2968 != -1) {
            var22.method4121(0, 0);
         }

         if(var2 >= 1) {
            var8.method4110(1);
         }

         if(var2 >= 2) {
            var8.method4110(16777215);
         }

         if(var3 != 0) {
            var8.method4177(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.method4121(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = class205.field3070;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method3919(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method4013(var15);
         class84.method1642();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-377676370"
   )
   public static void method1904(class182 var0) {
      Overlay.field3030 = var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Ljava/lang/String;Ljava/lang/String;I)LFont;",
      garbageValue = "-1462052633"
   )
   public static Font method1905(class182 var0, class182 var1, String var2, String var3) {
      int var4 = var0.method3284(var2);
      int var5 = var0.method3285(var4, var3);
      return class44.method825(var0, var1, var4, var5);
   }
}
