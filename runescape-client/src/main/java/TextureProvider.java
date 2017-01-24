import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("c")
   Deque field1201 = new Deque();
   @ObfuscatedName("s")
   class79[] field1202;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2117656295
   )
   int field1203;
   @ObfuscatedName("a")
   double field1204 = 1.0D;
   @ObfuscatedName("k")
   class182 field1206;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1928029803
   )
   int field1207 = 128;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -126285685
   )
   int field1208 = 0;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1400(double var1) {
      this.field1204 = var1;
      this.method1404();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "335690016"
   )
   public int vmethod1843(int var1) {
      return this.field1202[var1] != null?this.field1202[var1].field1308:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "10"
   )
   public boolean vmethod1844(int var1) {
      return this.field1202[var1].field1309;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "41"
   )
   public void method1404() {
      for(int var1 = 0; var1 < this.field1202.length; ++var1) {
         if(this.field1202[var1] != null) {
            this.field1202[var1].method1509();
         }
      }

      this.field1201 = new Deque();
      this.field1208 = this.field1203;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "849430739"
   )
   public void method1405(int var1) {
      for(int var2 = 0; var2 < this.field1202.length; ++var2) {
         class79 var3 = this.field1202[var2];
         if(null != var3 && var3.field1314 != 0 && var3.field1317) {
            var3.method1506(var1);
            var3.field1317 = false;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "-34"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1202[var1];
      if(null != var2) {
         if(null != var2.field1318) {
            this.field1201.method2326(var2);
            var2.field1317 = true;
            return var2.field1318;
         }

         boolean var3 = var2.method1507(this.field1204, this.field1207, this.field1206);
         if(var3) {
            if(this.field1208 == 0) {
               class79 var4 = (class79)this.field1201.method2329();
               var4.method1509();
            } else {
               --this.field1208;
            }

            this.field1201.method2326(var2);
            var2.field1317 = true;
            return var2.field1318;
         }
      }

      return null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1670147578"
   )
   public boolean vmethod1845(int var1) {
      return this.field1207 == 64;
   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1206 = var2;
      this.field1203 = var3;
      this.field1208 = this.field1203;
      this.field1204 = var4;
      this.field1207 = var6;
      int[] var7 = var1.method3191(0);
      int var8 = var7.length;
      this.field1202 = new class79[var1.method3192(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1202[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "1173554069"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0;
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = NPC.getItemDefinition(var0);
      if(var1 > 1 && null != var9.countObj) {
         int var19 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var19 = var9.countObj[var11];
            }
         }

         if(var19 != -1) {
            var9 = NPC.getItemDefinition(var19);
         }
      }

      Model var10 = var9.getModel(1);
      if(var10 == null) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.notedTemplate != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var20) {
               return null;
            }
         } else if(var9.field2954 != -1) {
            var20 = createSprite(var9.field2999, var1, var2, var3, 0, false);
            if(null == var20) {
               return null;
            }
         } else if(var9.field3002 != -1) {
            var20 = createSprite(var9.field3001, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method3903(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method3868();
         class84.method1633();
         class84.method1596(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field3002 != -1) {
            var20.method3971(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * class84.field1444[var9.xan2d] >> 16;
         int var18 = var16 * class84.field1453[var9.xan2d] >> 16;
         var10.method1518();
         var10.method1534(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var17 + var10.modelHeight / 2 + var9.offsetY2d, var9.offsetY2d + var18);
         if(var9.field2954 != -1) {
            var20.method3971(0, 0);
         }

         if(var2 >= 1) {
            var8.method3970(1);
         }

         if(var2 >= 2) {
            var8.method3970(16777215);
         }

         if(var3 != 0) {
            var8.method3968(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var20.method3971(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            ItemComposition.field2957.method3727(class178.method3169(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method3847(var15);
         class84.method1633();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
