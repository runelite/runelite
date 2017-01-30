import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class143 extends class68 {
   @ObfuscatedName("g")
   Deque field2006 = new Deque();
   @ObfuscatedName("p")
   class139 field2007;
   @ObfuscatedName("x")
   class51 field2008 = new class51();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass140;IB)V",
      garbageValue = "0"
   )
   void method2700(class140 var1, int var2) {
      if((this.field2007.field1940[var1.field1976] & 4) != 0 && var1.field1971 < 0) {
         int var3 = this.field2007.field1955[var1.field1976] / class57.field1047;
         int var4 = (1048575 + var3 - var1.field1977) / var3;
         var1.field1977 = var1.field1977 + var2 * var3 & 1048575;
         if(var4 <= var2) {
            if(this.field2007.field1943[var1.field1976] == 0) {
               var1.field1975 = class66.method1160(var1.field1968, var1.field1975.method1296(), var1.field1975.method1166(), var1.field1975.method1271());
            } else {
               var1.field1975 = class66.method1160(var1.field1968, var1.field1975.method1296(), 0, var1.field1975.method1271());
               this.field2007.method2611(var1, var1.field1965.field1998[var1.field1969] < 0);
            }

            if(var1.field1965.field1998[var1.field1969] < 0) {
               var1.field1975.method1162(-1);
            }

            var2 = var1.field1977 / var3;
         }
      }

      var1.field1975.vmethod2705(var2);
   }

   @ObfuscatedName("k")
   protected class68 vmethod2701() {
      class140 var1 = (class140)this.field2006.method2412();
      return (class68)(var1 == null?null:(var1.field1975 != null?var1.field1975:this.vmethod2702()));
   }

   @ObfuscatedName("j")
   protected class68 vmethod2702() {
      class140 var1;
      do {
         var1 = (class140)this.field2006.method2426();
         if(var1 == null) {
            return null;
         }
      } while(null == var1.field1975);

      return var1.field1975;
   }

   @ObfuscatedName("s")
   protected int vmethod2703() {
      return 0;
   }

   @ObfuscatedName("o")
   protected void vmethod2704(int[] var1, int var2, int var3) {
      this.field2008.vmethod2704(var1, var2, var3);

      for(class140 var6 = (class140)this.field2006.method2412(); null != var6; var6 = (class140)this.field2006.method2426()) {
         if(!this.field2007.method2541(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1966) {
                  this.method2730(var6, var1, var4, var5, var5 + var4);
                  var6.field1966 -= var5;
                  break;
               }

               this.method2730(var6, var1, var4, var6.field1966, var5 + var4);
               var4 += var6.field1966;
               var5 -= var6.field1966;
            } while(!this.field2007.method2542(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("c")
   protected void vmethod2705(int var1) {
      this.field2008.vmethod2705(var1);

      for(class140 var3 = (class140)this.field2006.method2412(); var3 != null; var3 = (class140)this.field2006.method2426()) {
         if(!this.field2007.method2541(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1966) {
                  this.method2700(var3, var2);
                  var3.field1966 -= var2;
                  break;
               }

               this.method2700(var3, var3.field1966);
               var2 -= var3.field1966;
            } while(!this.field2007.method2542(var3, (int[])null, 0, var2));
         }
      }

   }

   class143(class139 var1) {
      this.field2007 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "1666903290"
   )
   void method2730(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2007.field1940[var1.field1976] & 4) != 0 && var1.field1971 < 0) {
         int var6 = this.field2007.field1955[var1.field1976] / class57.field1047;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field1977) / var6;
            if(var7 > var4) {
               var1.field1977 += var4 * var6;
               break;
            }

            var1.field1975.vmethod2704(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1977 += var7 * var6 - 1048576;
            int var8 = class57.field1047 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1975;
            if(this.field2007.field1943[var1.field1976] == 0) {
               var1.field1975 = class66.method1160(var1.field1968, var10.method1296(), var10.method1166(), var10.method1271());
            } else {
               var1.field1975 = class66.method1160(var1.field1968, var10.method1296(), 0, var10.method1271());
               this.field2007.method2611(var1, var1.field1965.field1998[var1.field1969] < 0);
               var1.field1975.method1194(var8, var10.method1166());
            }

            if(var1.field1965.field1998[var1.field1969] < 0) {
               var1.field1975.method1162(-1);
            }

            var10.method1173(var8);
            var10.vmethod2704(var2, var3, var5 - var3);
            if(var10.method1177()) {
               this.field2008.method898(var10);
            }
         }
      }

      var1.field1975.vmethod2704(var2, var3, var4);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "963479114"
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
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class36.getItemDefinition(var0);
      if(var1 > 1 && null != var9.countObj) {
         int var10 = -1;

         for(int var21 = 0; var21 < 10; ++var21) {
            if(var1 >= var9.countCo[var21] && var9.countCo[var21] != 0) {
               var10 = var9.countObj[var21];
            }
         }

         if(var10 != -1) {
            var9 = class36.getItemDefinition(var10);
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
         } else if(var9.field2989 != -1) {
            var11 = createSprite(var9.field2962, var1, var2, var3, 0, false);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field2991 != -1) {
            var11 = createSprite(var9.field2990, var1, 0, 0, 0, false);
            if(null == var11) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method4001(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method3989();
         class84.method1678();
         class84.method1648(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field2991 != -1) {
            var11.method4144(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * class84.field1438[var9.xan2d] >> 16;
         int var18 = class84.field1452[var9.xan2d] * var16 >> 16;
         var22.method1602();
         var22.method1583(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var22.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.field2989 != -1) {
            var11.method4144(0, 0);
         }

         if(var2 >= 1) {
            var8.method4140(1);
         }

         if(var2 >= 2) {
            var8.method4140(16777215);
         }

         if(var3 != 0) {
            var8.method4141(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var11.method4144(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = class181.field2698;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method3875(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method4018(var15);
         class84.method1678();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
