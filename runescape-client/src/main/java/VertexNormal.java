import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1197883795
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -472553091
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2104167247
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1590877659
   )
   @Export("z")
   int z;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "2146476337"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var4 << 40) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = ItemComposition.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var21 = 0; var21 < 10; ++var21) {
            if(var1 >= var9.countCo[var21] && var9.countCo[var21] != 0) {
               var10 = var9.countObj[var21];
            }
         }

         if(var10 != -1) {
            var9 = ItemComposition.getItemDefinition(var10);
         }
      }

      Model var22 = var9.getModel(1);
      if(var22 == null) {
         return null;
      } else {
         SpritePixels var11 = null;
         if(var9.notedTemplate != -1) {
            var11 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field3548 != -1) {
            var11 = createSprite(var9.field3547, var1, var2, var3, 0, false);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field3543 != -1) {
            var11 = createSprite(var9.field3549, var1, 0, 0, 0, false);
            if(var11 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method4963(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method4964();
         class136.method2594();
         class136.method2597(16, 16);
         class136.rasterGouraudLowRes = false;
         if(var9.field3543 != -1) {
            var11.method5097(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * class136.SINE[var9.xan2d] >> 16;
         int var18 = class136.COSINE[var9.xan2d] * var16 >> 16;
         var22.method2515();
         var22.method2528(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var9.offsetY2d + var22.modelHeight / 2 + var17, var18 + var9.offsetY2d);
         if(var9.field3548 != -1) {
            var11.method5097(0, 0);
         }

         if(var2 >= 1) {
            var8.method5147(1);
         }

         if(var2 >= 2) {
            var8.method5147(16777215);
         }

         if(var3 != 0) {
            var8.method5095(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var11.method5097(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = CombatInfo1.field1292;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4785(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method5048(var15);
         class136.method2594();
         class136.rasterGouraudLowRes = true;
         return var8;
      }
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-2104"
   )
   public static void method2591() {
      try {
         if(class203.field2515 == 1) {
            int var0 = class203.field2517.method3710();
            if(var0 > 0 && class203.field2517.method3757()) {
               var0 -= class155.field2261;
               if(var0 < 0) {
                  var0 = 0;
               }

               class203.field2517.method3773(var0);
               return;
            }

            class203.field2517.method3728();
            class203.field2517.method3713();
            if(class203.field2516 != null) {
               class203.field2515 = 2;
            } else {
               class203.field2515 = 0;
            }

            class210.field2608 = null;
            class18.field328 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class203.field2517.method3728();
         class203.field2515 = 0;
         class210.field2608 = null;
         class18.field328 = null;
         class203.field2516 = null;
      }

   }

   VertexNormal() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1505167002"
   )
   public static void method2592() {
      class95.field1493 = null;
      class286.field3790 = null;
      class286.field3793 = null;
      class241.field3293 = null;
      class174.field2410 = null;
      class31.field449 = null;
   }
}
