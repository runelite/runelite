import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class31 {
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   static Font field447;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field452;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 178354685
   )
   final int field450;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1333329269
   )
   final int field448;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1631470609
   )
   final int field449;

   class31(int var1, int var2, int var3) {
      this.field450 = var1;
      this.field448 = var2;
      this.field449 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-176341843"
   )
   static int method303(int var0, int var1) {
      Overlay var2 = class61.method1098(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else {
         int var3;
         if(var2.texture >= 0) {
            var3 = class169.method3211(Graphics3D.textureLoader.getAverageTextureRGB(var2.texture), 96);
            return Graphics3D.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var3 = class21.method179(var2.hue, var2.saturation, var2.lightness);
            int var4 = class169.method3211(var3, 96);
            return Graphics3D.colorPalette[var4] | -16777216;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lkd;",
      garbageValue = "1238891309"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + (long)var0 + ((long)var1 << 16) + ((long)var2 << 38);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class169.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class169.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(var19 == null) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.notedTemplate != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var20 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field3497 != -1) {
            var20 = createSprite(var9.field3536, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.method2616();
         Graphics3D.method2619(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.field3497 != -1) {
            var20.method5019(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var19.method2515();
         var19.method2528(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var20.method5019(0, 0);
         }

         if(var2 >= 1) {
            var8.method5033(1);
         }

         if(var2 >= 2) {
            var8.method5033(16777215);
         }

         if(var3 != 0) {
            var8.method5094(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var20.method5019(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            ItemComposition.field3489.method4773(Permission.method4124(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.method2616();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
