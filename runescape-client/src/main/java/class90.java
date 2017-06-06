import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class90 {
   @ObfuscatedName("i")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("c")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIZS)LSpritePixels;",
      garbageValue = "-28018"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = Buffer.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var22 = 0; var22 < 10; ++var22) {
            if(var1 >= var9.countCo[var22] && var9.countCo[var22] != 0) {
               var10 = var9.countObj[var22];
            }
         }

         if(var10 != -1) {
            var9 = Buffer.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(var21 == null) {
         return null;
      } else {
         SpritePixels var11 = null;
         if(var9.notedTemplate != -1) {
            var11 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field3492 != -1) {
            var11 = createSprite(var9.field3533, var1, var2, var3, 0, false);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field3536 != -1) {
            var11 = createSprite(var9.field3535, var1, 0, 0, 0, false);
            if(var11 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method4957(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method4919();
         class136.method2595();
         class136.method2593(16, 16);
         class136.rasterGouraudLowRes = false;
         if(var9.field3536 != -1) {
            var11.method5047(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class136.SINE[var9.xan2d] * var16 >> 16;
         int var18 = class136.COSINE[var9.xan2d] * var16 >> 16;
         var21.method2496();
         var21.method2508(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var21.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.field3492 != -1) {
            var11.method5047(0, 0);
         }

         if(var2 >= 1) {
            var8.method5043(1);
         }

         if(var2 >= 2) {
            var8.method5043(16777215);
         }

         if(var3 != 0) {
            var8.method5085(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var11.method5047(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = WidgetNode.field844;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4737(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method4928(var15);
         class136.method2595();
         class136.rasterGouraudLowRes = true;
         return var8;
      }
   }

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("e3742b11d7490d979210f90045104de498f2adcb731ae9d59e889bf16c6bd47a0a0d27d7f0e8e181adafefd93f76469596f023b8e35523dc8ab4b484553eb4187a838040f8258329fba3111d7bd996a5cb27ee67ead5e0c946afb73c653ac7dc5ac15aff03aedf63563b7f01cd0d820e060df0ac9a0977330fa59b3615935231", 16);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   public static void method1705() {
      if(class59.mouse != null) {
         class59 var0 = class59.mouse;
         synchronized(class59.mouse) {
            class59.mouse = null;
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-1898759358"
   )
   static final void method1706(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -ChatLineBuffer.method1866(var4 + var2 + 932731, var3 + 556238 + var5) * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class61.overlayIds[var1][var2][var3] = var0.readByte();
               class61.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class13.overlayRotations[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class61.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
