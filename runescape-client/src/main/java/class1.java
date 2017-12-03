import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class1 {
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = -1839846535
   )
   static int field9;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static final class1 field10;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static final class1 field1;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static final class1 field2;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static final class1 field3;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static final class1 field4;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static final class1 field5;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static final class1 field6;
   @ObfuscatedName("h")
   @Export("userHome")
   static String userHome;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1558105435
   )
   final int field7;

   static {
      field10 = new class1(0);
      field1 = new class1(5);
      field2 = new class1(4);
      field3 = new class1(2);
      field4 = new class1(6);
      field5 = new class1(3);
      field6 = new class1(1);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lkx;",
      garbageValue = "-1378527525"
   )
   public static class296[] method2() {
      return new class296[]{class296.field3837, class296.field3840, class296.field3838, class296.field3836, class296.field3839};
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lks;",
      garbageValue = "2117442222"
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

      ItemComposition var9 = KitDefinition.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = KitDefinition.getItemDefinition(var10);
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
         Graphics3D.method2607(16, 16);
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
         var19.method2526(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var20.drawAt(0, 0);
         }

         if(var2 >= 1) {
            var8.method5201(1);
         }

         if(var2 >= 2) {
            var8.method5201(16777215);
         }

         if(var3 != 0) {
            var8.method5250(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         if(var9.notedTemplate != -1) {
            var20.drawAt(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class226.field2748.method4891(DecorativeObject.method2908(var1), 0, 9, 16776960, 1);
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

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(Ljj;IIII)V",
      garbageValue = "1132542682"
   )
   static void method1(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1068 < 50 && Client.field1067 != 0) {
         if(var0.field3676 != null && var1 < var0.field3676.length) {
            int var4 = var0.field3676[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1069[Client.field1068] = var5;
               Client.field1070[Client.field1068] = var6;
               Client.field1071[Client.field1068] = 0;
               Client.audioEffects[Client.field1068] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1072[Client.field1068] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1068;
            }
         }
      }
   }
}
