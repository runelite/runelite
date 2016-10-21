import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class53 extends CacheableNode {
   @ObfuscatedName("e")
   public static NodeCache field1137 = new NodeCache(64);
   @ObfuscatedName("f")
   public static class170 field1138;
   @ObfuscatedName("n")
   public boolean field1139 = false;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1712672660"
   )
   void method1081(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1139 = true;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-903419821"
   )
   public void method1082(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method1081(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IIB)Lclass227;",
      garbageValue = "2"
   )
   public static class227 method1083(class170 var0, class170 var1, int var2, int var3) {
      byte[] var5 = var0.method3304(var2, var3);
      boolean var4;
      if(null == var5) {
         var4 = false;
      } else {
         class13.method154(var5);
         var4 = true;
      }

      if(!var4) {
         return null;
      } else {
         byte[] var6 = var1.method3304(var2, var3);
         class227 var8;
         if(null == var6) {
            var8 = null;
         } else {
            class227 var7 = new class227(var6, class189.field3050, class79.field1431, class79.field1432, XItemContainer.field221, class137.field2130, BufferProvider.field1450);
            class14.method161();
            var8 = var7;
         }

         return var8;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "1169813353"
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
         if(null != var8) {
            return var8;
         }
      }

      ItemComposition var9 = class45.getItemDefinition(var0);
      if(var1 > 1 && var9.field1189 != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1190[var11] && var9.field1190[var11] != 0) {
               var10 = var9.field1189[var11];
            }
         }

         if(var10 != -1) {
            var9 = class45.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(null == var19) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.field1192 != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var20) {
               return null;
            }
         } else if(var9.field1201 != -1) {
            var20 = createSprite(var9.field1188, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field1203 != -1) {
            var20 = createSprite(var9.field1202, var1, 0, 0, 0, false);
            if(null == var20) {
               return null;
            }
         }

         int[] var12 = class82.graphicsPixels;
         int var13 = class82.graphicsPixelsWidth;
         int var14 = class82.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class82.method1842(var15);
         var8 = new SpritePixels(36, 32);
         class82.setRasterBuffer(var8.image, 36, 32);
         class82.method1844();
         class94.method2132();
         class94.method2135(16, 16);
         class94.rasterGouraudLowRes = false;
         if(var9.field1203 != -1) {
            var20.method1763(0, 0);
         }

         int var16 = var9.field1166;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class94.field1635[var9.field1184] * var16 >> 16;
         int var18 = var16 * class94.field1646[var9.field1184] >> 16;
         var19.method2377();
         var19.method2334(0, var9.field1174, var9.field1198, var9.field1184, var9.field1170, var19.modelHeight / 2 + var17 + var9.field1171, var18 + var9.field1171);
         if(var9.field1201 != -1) {
            var20.method1763(0, 0);
         }

         if(var2 >= 1) {
            var8.method1819(1);
         }

         if(var2 >= 2) {
            var8.method1819(16777215);
         }

         if(var3 != 0) {
            var8.method1760(var3);
         }

         class82.setRasterBuffer(var8.image, 36, 32);
         if(var9.field1192 != -1) {
            var20.method1763(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            ItemComposition.field1158.method4096(class20.method563(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class82.setRasterBuffer(var12, var13, var14);
         class82.method1862(var15);
         class94.method2132();
         class94.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
