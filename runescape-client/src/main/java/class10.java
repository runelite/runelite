import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public final class class10 extends class9 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1963795763
   )
   final int field253;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1766371011
   )
   final int field252;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2117141419
   )
   final int field255;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1375918593
   )
   final int field254;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 789485013
   )
   final int field259;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1595276763
   )
   final int field251;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1660879203
   )
   final int field257;

   @ObfuscatedSignature(
      signature = "(Len;IIII)V"
   )
   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field253 = var2 + var1.field1892 - var1.field1877;
      this.field252 = var3 + var1.field1875 - var1.field1878;
      this.field255 = var4 + var1.field1876 - var1.field1879;
      this.field254 = var2 + var1.field1877 + var1.field1892;
      this.field259 = var3 + var1.field1878 + var1.field1875;
      this.field251 = var4 + var1.field1876 + var1.field1879;
      this.field257 = var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2102608092"
   )
   final void vmethod54() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field253:this.field254;
         int var2 = (var4 & 2) == 0?this.field252:this.field259;
         int var3 = (var4 & 4) == 0?this.field255:this.field251;
         if((var4 & 1) == 0) {
            class243.method4378(var1, var2, var3, this.field254, var2, var3, this.field257);
         }

         if((var4 & 2) == 0) {
            class243.method4378(var1, var2, var3, var1, this.field259, var3, this.field257);
         }

         if((var4 & 4) == 0) {
            class243.method4378(var1, var2, var3, var1, var2, this.field251, this.field257);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljb;",
      garbageValue = "1778826247"
   )
   public static class261 method55(int var0) {
      class261 var1 = (class261)class261.field3482.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class261.field3479.getConfigData(32, var0);
         var1 = new class261();
         if(var2 != null) {
            var1.method4654(new Buffer(var2));
         }

         class261.field3482.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "736295515"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lkd;",
      garbageValue = "1389661422"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = (long)var0 + ((long)var1 << 16) + ((long)var2 << 38) + ((long)var4 << 40) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class250.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class250.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(var21 == null) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.notedTemplate != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var22 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field3594 != -1) {
            var22 = createSprite(var9.field3593, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.method2707();
         Graphics3D.method2748(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.field3594 != -1) {
            var22.drawAt(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var21.method2616();
         var21.method2629(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var21.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var22.drawAt(0, 0);
         }

         if(var2 >= 1) {
            var8.method5274(1);
         }

         if(var2 >= 2) {
            var8.method5274(16777215);
         }

         if(var3 != 0) {
            var8.method5328(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.drawAt(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = ItemComposition.field3547;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4931(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.method2707();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
