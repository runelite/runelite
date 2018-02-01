import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public enum class27 implements MouseWheel {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field372(3, (byte)0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field371(2, (byte)1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field370(1, (byte)2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field368(0, (byte)3);

   @ObfuscatedName("pt")
   @ObfuscatedSignature(
      signature = "Lls;"
   )
   @Export("platformInfo")
   static MachineInfo platformInfo;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2094947373
   )
   final int field369;
   @ObfuscatedName("a")
   final byte field373;

   class27(int var3, byte var4) {
      this.field369 = var3;
      this.field373 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.field373;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-92"
   )
   public static int method230(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Lap;",
      garbageValue = "-2133843812"
   )
   static class27[] method229() {
      return new class27[]{field372, field371, field368, field370};
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)Lko;",
      garbageValue = "15"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var4 << 40);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = CombatInfo1.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = CombatInfo1.getItemDefinition(var10);
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
         } else if(var9.int3 != -1) {
            var20 = createSprite(var9.int2, var1, 0, 0, 0, false);
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
         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.method2745(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.int3 != -1) {
            var20.drawAt(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var19.calculateBoundsCylinder();
         var19.method2672(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var20.drawAt(0, 0);
         }

         if(var2 >= 1) {
            var8.method5582(1);
         }

         if(var2 >= 2) {
            var8.method5582(16777215);
         }

         if(var3 != 0) {
            var8.method5533(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         if(var9.notedTemplate != -1) {
            var20.drawAt(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            KitDefinition.field3418.method5225(class239.getItemStackAmountText(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(Lio;Ljava/lang/String;I)V",
      garbageValue = "-1253177479"
   )
   static void method228(IndexData var0, String var1) {
      class63 var2 = new class63(var0, var1);
      Client.field1075.add(var2);
   }
}
