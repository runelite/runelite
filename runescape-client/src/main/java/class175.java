import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class175 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1892127697
   )
   static int field2644;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "566016310"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var1 << 16) + (long)var0 + ((long)var2 << 38) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class168.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class168.getItemDefinition(var10);
         }
      }

      Model var20 = var9.getModel(1);
      if(null == var20) {
         return null;
      } else {
         SpritePixels var19 = null;
         if(var9.notedTemplate != -1) {
            var19 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var19) {
               return null;
            }
         } else if(var9.field2995 != -1) {
            var19 = createSprite(var9.field2974, var1, var2, var3, 0, false);
            if(var19 == null) {
               return null;
            }
         } else if(var9.field3000 != -1) {
            var19 = createSprite(var9.field3003, var1, 0, 0, 0, false);
            if(var19 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method4094(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method4096();
         class84.method1695();
         class84.method1741(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field3000 != -1) {
            var19.method4284(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = class84.field1435[var9.xan2d] * var16 >> 16;
         int var18 = class84.field1432[var9.xan2d] * var16 >> 16;
         var20.method1684();
         var20.method1633(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var9.offsetY2d + var17 + var20.modelHeight / 2, var9.offsetY2d + var18);
         if(var9.field2995 != -1) {
            var19.method4284(0, 0);
         }

         if(var2 >= 1) {
            var8.method4295(1);
         }

         if(var2 >= 2) {
            var8.method4295(16777215);
         }

         if(var3 != 0) {
            var8.method4251(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var19.method4284(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            FrameMap.field1457.method3974(class85.method1751(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method4095(var15);
         class84.method1695();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "684767877"
   )
   static final int method3327(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var1 / 32 << 7) + (var0 / 4 << 10);
      return var3;
   }

   class175() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-939343050"
   )
   static final boolean method3328(Widget var0) {
      if(var0.field2309 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2309.length; ++var1) {
            int var2 = class107.method2094(var0, var1);
            int var3 = var0.field2192[var1];
            if(var0.field2309[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2309[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2309[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
