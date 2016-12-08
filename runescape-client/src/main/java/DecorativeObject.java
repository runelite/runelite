import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -591507747
   )
   int field1585;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1780926329
   )
   @Export("x")
   int x;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -360880061
   )
   int field1587 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 402382263
   )
   int field1588;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1517714565
   )
   int field1589;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -368063159
   )
   int field1590;
   @ObfuscatedName("c")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 40894319
   )
   @Export("y")
   int y;
   @ObfuscatedName("u")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -779429801
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1356978621
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("p")
   static int[][][] field1596;
   @ObfuscatedName("qh")
   static Image field1597;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "10"
   )
   public static void method1873(Component var0) {
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1709 = -1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass15;B)V",
      garbageValue = "1"
   )
   static final void method1874(class15 var0) {
      if(class5.localPlayer.x >> 7 == Client.flagX && class5.localPlayer.y >> 7 == Client.flagY) {
         Client.flagX = 0;
      }

      int var1 = class45.field900;
      int[] var2 = class45.field902;
      int var3 = var1;
      if(var0 == class15.field168 || var0 == class15.field167) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class15.field168) {
            var5 = class5.localPlayer;
            var6 = class5.localPlayer.field273 << 14;
         } else if(class15.field167 == var0) {
            var5 = Client.cachedPlayers[Client.field416];
            var6 = Client.field416 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class15.field166 && Client.field416 == var2[var4]) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod702() && !var5.field268) {
            var5.field266 = false;
            if((Client.field314 && var1 > 50 || var1 > 200) && class15.field168 != var0 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field266 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field257) {
                  var5.field266 = false;
                  var5.field255 = ChatLineBuffer.method896(var5.x, var5.y, class63.plane);
                  class159.region.method1678(class63.plane, var5.x, var5.y, var5.field255, 60, var5, var5.angle, var6, var5.field262, var5.field247, var5.field264, var5.field265);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field391 == Client.field390[var7][var8]) {
                        continue;
                     }

                     Client.field390[var7][var8] = Client.field391;
                  }

                  var5.field255 = ChatLineBuffer.method896(var5.x, var5.y, class63.plane);
                  class159.region.method1677(class63.plane, var5.x, var5.y, var5.field255, 60, var5, var5.angle, var6, var5.field606);
               }
            }
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "21"
   )
   static final void method1875(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = 6 + var2;
      int var5 = class33.field757.method3781(var0, 250);
      int var6 = class33.field757.method3816(var0, 250) * 13;
      class219.method3899(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 0);
      class219.method3905(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 16777215);
      class33.field757.method3827(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class7.method86(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class36.canvas.getGraphics();
            TextureProvider.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            class36.canvas.repaint();
         }
      } else {
         class10.method142(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "-680637431"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class137.getItemDefinition(var0);
      if(var1 > 1 && null != var9.field2965) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field2978[var11] && var9.field2978[var11] != 0) {
               var10 = var9.field2965[var11];
            }
         }

         if(var10 != -1) {
            var9 = class137.getItemDefinition(var10);
         }
      }

      Model var22 = var9.getModel(1);
      if(var22 == null) {
         return null;
      } else {
         SpritePixels var21 = null;
         if(var9.field2980 != -1) {
            var21 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var21) {
               return null;
            }
         } else if(var9.field2989 != -1) {
            var21 = createSprite(var9.field2988, var1, var2, var3, 0, false);
            if(null == var21) {
               return null;
            }
         } else if(var9.field2955 != -1) {
            var21 = createSprite(var9.field2950, var1, 0, 0, 0, false);
            if(var21 == null) {
               return null;
            }
         }

         int[] var12 = class219.graphicsPixels;
         int var13 = class219.graphicsPixelsWidth;
         int var14 = class219.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class219.method3939(var15);
         var8 = new SpritePixels(36, 32);
         class219.setRasterBuffer(var8.image, 36, 32);
         class219.method3901();
         class84.method1604();
         class84.method1602(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field2955 != -1) {
            var21.method4048(0, 0);
         }

         int var16 = var9.field2954;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class84.field1435[var9.field2973] * var16 >> 16;
         int var18 = var16 * class84.field1446[var9.field2973] >> 16;
         var22.method1521();
         var22.method1538(0, var9.field2977, var9.field2942, var9.field2973, var9.field2958, var22.modelHeight / 2 + var17 + var9.field2959, var18 + var9.field2959);
         if(var9.field2989 != -1) {
            var21.method4048(0, 0);
         }

         if(var2 >= 1) {
            var8.method4129(1);
         }

         if(var2 >= 2) {
            var8.method4129(16777215);
         }

         if(var3 != 0) {
            var8.method4074(var3);
         }

         class219.setRasterBuffer(var8.image, 36, 32);
         if(var9.field2980 != -1) {
            var21.method4048(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class208 var19 = ItemComposition.field2946;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method3784(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class219.setRasterBuffer(var12, var13, var14);
         class219.method3924(var15);
         class84.method1604();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "-1213406417"
   )
   static void method1877(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var1 == var6.parentId) {
            class138.method2445(var6, var2, var3, var4);
            WallObject.method1839(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               Renderable.method1833(var0, var6, var4);
            }
         }
      }

   }
}
