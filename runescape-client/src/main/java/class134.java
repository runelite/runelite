import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public abstract class class134 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1271826354"
   )
   public abstract void vmethod3136(Component var1);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "64"
   )
   public abstract void vmethod3142(Component var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "1703265640"
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

      ItemComposition var9 = MessageNode.getItemDefinition(var0);
      if(var1 > 1 && var9.field1214 != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1229[var11] && var9.field1229[var11] != 0) {
               var10 = var9.field1214[var11];
            }
         }

         if(var10 != -1) {
            var9 = MessageNode.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(var21 == null) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.field1219 != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field1226 != -1) {
            var22 = createSprite(var9.field1225, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field1184 != -1) {
            var22 = createSprite(var9.field1227, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = class82.graphicsPixels;
         int var13 = class82.graphicsPixelsWidth;
         int var14 = class82.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class82.method1825(var15);
         var8 = new SpritePixels(36, 32);
         class82.setRasterBuffer(var8.image, 36, 32);
         class82.method1851();
         class94.method2118();
         class94.method2121(16, 16);
         class94.rasterGouraudLowRes = false;
         if(var9.field1184 != -1) {
            var22.method1746(0, 0);
         }

         int var16 = var9.field1232;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * class94.field1670[var9.field1215] >> 16;
         int var18 = class94.field1676[var9.field1215] * var16 >> 16;
         var21.method2347();
         var21.method2319(0, var9.field1193, var9.field1194, var9.field1215, var9.field1177, var21.modelHeight / 2 + var17 + var9.field1216, var9.field1216 + var18);
         if(var9.field1226 != -1) {
            var22.method1746(0, 0);
         }

         if(var2 >= 1) {
            var8.method1742(1);
         }

         if(var2 >= 2) {
            var8.method1742(16777215);
         }

         if(var3 != 0) {
            var8.method1743(var3);
         }

         class82.setRasterBuffer(var8.image, 36, 32);
         if(var9.field1219 != -1) {
            var22.method1746(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class227 var19 = class10.field161;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4157(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class82.setRasterBuffer(var12, var13, var14);
         class82.method1826(var15);
         class94.method2118();
         class94.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   public abstract int vmethod3138();
}
