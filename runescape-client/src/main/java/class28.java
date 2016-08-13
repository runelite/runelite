import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class28 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "1677657654"
   )
   static void method666(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         Sequence.method911(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "-873170521"
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
         if(null != var8) {
            return var8;
         }
      }

      ItemComposition var9 = class1.getItemDefinition(var0);
      if(var1 > 1 && null != var9.field1214) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1215[var11] && var9.field1215[var11] != 0) {
               var10 = var9.field1214[var11];
            }
         }

         if(var10 != -1) {
            var9 = class1.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(var19 == null) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.field1178 != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var20) {
               return null;
            }
         } else if(var9.field1226 != -1) {
            var20 = createSprite(var9.field1225, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field1213 != -1) {
            var20 = createSprite(var9.field1227, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = class82.graphicsPixels;
         int var13 = class82.graphicsPixelsWidth;
         int var14 = class82.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class82.method1883(var15);
         var8 = new SpritePixels(36, 32);
         class82.setRasterBuffer(var8.image, 36, 32);
         class82.method1885();
         class94.method2183();
         class94.method2187(16, 16);
         class94.rasterGouraudLowRes = false;
         if(var9.field1213 != -1) {
            var20.method1824(0, 0);
         }

         int var16 = var9.field1191;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class94.field1661[var9.field1188] * var16 >> 16;
         int var18 = var16 * class94.field1662[var9.field1188] >> 16;
         var19.method2402();
         var19.method2414(0, var9.field1193, var9.field1194, var9.field1188, var9.field1179, var19.modelHeight / 2 + var17 + var9.field1196, var9.field1196 + var18);
         if(var9.field1226 != -1) {
            var20.method1824(0, 0);
         }

         if(var2 >= 1) {
            var8.method1802(1);
         }

         if(var2 >= 2) {
            var8.method1802(16777215);
         }

         if(var3 != 0) {
            var8.method1803(var3);
         }

         class82.setRasterBuffer(var8.image, 36, 32);
         if(var9.field1178 != -1) {
            var20.method1824(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class47.field1072.method4170(Frames.method2393(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class82.setRasterBuffer(var12, var13, var14);
         class82.method1897(var15);
         class94.method2183();
         class94.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
