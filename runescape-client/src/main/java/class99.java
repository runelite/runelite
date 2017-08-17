import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class99 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 204070073
   )
   static int field1534;
   @ObfuscatedName("j")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final IterableHashTable field1530;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   static final class202 field1531;
   @ObfuscatedName("o")
   public static boolean field1532;

   static {
      chatLineMap = new HashMap();
      field1530 = new IterableHashTable(1024);
      field1531 = new class202();
      field1534 = 0;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lda;I)V",
      garbageValue = "1789250056"
   )
   static final void method1859(class120 var0) {
      var0.field1727 = false;
      if(var0.field1729 != null) {
         var0.field1729.field1760 = 0;
      }

      for(class120 var1 = var0.vmethod3894(); var1 != null; var1 = var0.vmethod3888()) {
         method1859(var1);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lkp;",
      garbageValue = "2140311108"
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

      ItemComposition var9 = SoundTask.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = SoundTask.getItemDefinition(var10);
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
         } else if(var9.field3530 != -1) {
            var22 = createSprite(var9.field3529, var1, 0, 0, 0, false);
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
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.method2614();
         Graphics3D.method2677(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.field3530 != -1) {
            var22.method5172(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var21.method2528();
         var21.method2563(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var21.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var22.method5172(0, 0);
         }

         if(var2 >= 1) {
            var8.method5087(1);
         }

         if(var2 >= 2) {
            var8.method5087(16777215);
         }

         if(var3 != 0) {
            var8.method5088(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.method5172(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = ISAACCipher.field2433;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4780(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.method2614();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
