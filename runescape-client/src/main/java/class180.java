import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class180 extends Node {
   @ObfuscatedName("e")
   byte[] field2691;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1591178407
   )
   int field2692;
   @ObfuscatedName("f")
   class116 field2693;
   @ObfuscatedName("k")
   class184 field2694;
   @ObfuscatedName("pw")
   static class230 field2695;
   @ObfuscatedName("bp")
   static class184 field2696;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "671270389"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var4 << 40) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class7.getItemDefinition(var0);
      if(var1 > 1 && null != var9.field2954) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field2993[var11] && var9.field2993[var11] != 0) {
               var10 = var9.field2954[var11];
            }
         }

         if(var10 != -1) {
            var9 = class7.getItemDefinition(var10);
         }
      }

      Model var20 = var9.getModel(1);
      if(null == var20) {
         return null;
      } else {
         SpritePixels var19 = null;
         if(var9.field2985 != -1) {
            var19 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var19) {
               return null;
            }
         } else if(var9.field2994 != -1) {
            var19 = createSprite(var9.field2973, var1, var2, var3, 0, false);
            if(var19 == null) {
               return null;
            }
         } else if(var9.field2996 != -1) {
            var19 = createSprite(var9.field2995, var1, 0, 0, 0, false);
            if(var19 == null) {
               return null;
            }
         }

         int[] var12 = class219.graphicsPixels;
         int var13 = class219.graphicsPixelsWidth;
         int var14 = class219.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class219.method3891(var15);
         var8 = new SpritePixels(36, 32);
         class219.setRasterBuffer(var8.image, 36, 32);
         class219.method3947();
         class84.method1626();
         class84.method1629(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field2996 != -1) {
            var19.method4032(0, 0);
         }

         int var16 = var9.field2959;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = class84.field1453[var9.field2960] * var16 >> 16;
         int var18 = class84.field1454[var9.field2960] * var16 >> 16;
         var20.method1546();
         var20.method1556(0, var9.field2953, var9.field2962, var9.field2960, var9.field2977, var9.field2964 + var17 + var20.modelHeight / 2, var18 + var9.field2964);
         if(var9.field2994 != -1) {
            var19.method4032(0, 0);
         }

         if(var2 >= 1) {
            var8.method4028(1);
         }

         if(var2 >= 2) {
            var8.method4028(16777215);
         }

         if(var3 != 0) {
            var8.method4029(var3);
         }

         class219.setRasterBuffer(var8.image, 36, 32);
         if(var9.field2985 != -1) {
            var19.method4032(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class155.field2112.method3779(class177.method3186(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class219.setRasterBuffer(var12, var13, var14);
         class219.method3892(var15);
         class84.method1626();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
