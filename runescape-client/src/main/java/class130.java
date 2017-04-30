import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class130 {
   @ObfuscatedName("t")
   static byte[][] field1963;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 875539095
   )
   static int field1964;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2021576253
   )
   static int field1965;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -880219777
   )
   static int field1966;
   @ObfuscatedName("q")
   static byte[][] field1967;
   @ObfuscatedName("p")
   static byte[][] field1968;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -37038109
   )
   static int field1969;

   class130() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "2112066031"
   )
   static synchronized byte[] method2602(int var0) {
      byte[] var1;
      if(var0 == 100 && field1964 > 0) {
         var1 = field1967[--field1964];
         field1967[field1964] = null;
         return var1;
      } else if(var0 == 5000 && field1966 > 0) {
         var1 = field1963[--field1966];
         field1963[field1966] = null;
         return var1;
      } else if(var0 == 30000 && field1965 > 0) {
         var1 = field1968[--field1965];
         field1968[field1965] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   static {
      field1964 = 0;
      field1966 = 0;
      field1965 = 0;
      field1967 = new byte[1000][];
      field1963 = new byte[250][];
      field1968 = new byte[50][];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-66"
   )
   static final int method2604(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & '\uff00') * var2 + var3 * (var0 & '\uff00') & 16711680) + ((var1 & 16711935) * var2 + (var0 & 16711935) * var3 & -16711936) >> 8;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-84"
   )
   static byte[] method2605(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-728473096"
   )
   static void method2606() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2776(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2777()) {
         int var1 = var0.id;
         if(class112.method2112(var1)) {
            boolean var2 = true;
            Widget[] var3 = class133.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class128.method2364(var4);
               if(var5 != null) {
                  class124.method2350(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "-274105130"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var1 << 16) + (long)var0 + ((long)var2 << 38);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class47.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var21 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var21 = var9.countObj[var11];
            }
         }

         if(var21 != -1) {
            var9 = class47.getItemDefinition(var21);
         }
      }

      Model var10 = var9.getModel(1);
      if(var10 == null) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.notedTemplate != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field3030 != -1) {
            var22 = createSprite(var9.field3029, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field3000 != -1) {
            var22 = createSprite(var9.field3016, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method4125(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method4123();
         class84.method1649();
         class84.method1652(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field3000 != -1) {
            var22.method4230(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * class84.field1433[var9.xan2d] >> 16;
         int var18 = class84.field1441[var9.xan2d] * var16 >> 16;
         var10.method1574();
         var10.method1586(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var9.offsetY2d + var17 + var10.modelHeight / 2, var18 + var9.offsetY2d);
         if(var9.field3030 != -1) {
            var22.method4230(0, 0);
         }

         if(var2 >= 1) {
            var8.method4226(1);
         }

         if(var2 >= 2) {
            var8.method4226(16777215);
         }

         if(var3 != 0) {
            var8.method4225(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.method4230(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = ItemComposition.field3005;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method3914(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method4086(var15);
         class84.method1649();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
