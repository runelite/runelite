import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("BoundingBox3D")
public final class BoundingBox3D extends BoundingBox {
   @ObfuscatedName("rd")
   @ObfuscatedGetter(
      intValue = 482328323
   )
   static int field250;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -593803019
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1526887609
   )
   @Export("int1")
   final int int1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -27905273
   )
   @Export("int2")
   final int int2;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1200763357
   )
   @Export("int3")
   final int int3;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1231412103
   )
   @Export("int4")
   final int int4;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -517625221
   )
   @Export("int5")
   final int int5;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1342539139
   )
   @Export("int6")
   final int int6;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 100589153
   )
   @Export("color")
   final int color;

   @ObfuscatedSignature(
      signature = "(Lek;IIII)V"
   )
   BoundingBox3D(Model var1, int var2, int var3, int var4, int var5) {
      this.int1 = var2 + var1.centerX - var1.extremeX;
      this.int2 = var3 + var1.centerY - var1.extremeY;
      this.int3 = var4 + var1.centerZ - var1.extremeZ;
      this.int4 = var2 + var1.extremeX + var1.centerX;
      this.int5 = var3 + var1.centerY + var1.extremeY;
      this.int6 = var4 + var1.extremeZ + var1.centerZ;
      this.color = var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-706888510"
   )
   public final void vmethod56() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.int1:this.int4;
         int var2 = (var4 & 2) == 0?this.int2:this.int5;
         int var3 = (var4 & 4) == 0?this.int3:this.int6;
         if((var4 & 1) == 0) {
            GameCanvas.method854(var1, var2, var3, this.int4, var2, var3, this.color);
         }

         if((var4 & 2) == 0) {
            GameCanvas.method854(var1, var2, var3, var1, this.int5, var3, this.color);
         }

         if((var4 & 4) == 0) {
            GameCanvas.method854(var1, var2, var3, var1, var2, this.int6, this.color);
         }
      }

   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1386515520"
   )
   static final void method57(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class38.region.method2987(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class38.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = GrandExchangeOffer.minimapSprite.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = Spotanim.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class318.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.width * 4 - var14.originalWidth) / 2;
               int var16 = (var13.length * 4 - var14.height) / 2;
               var14.method5806(var1 * 4 + var15 + 48, (104 - var2 - var13.length) * 4 + var16 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class38.region.method2885(var0, var1, var2);
      if(var5 != 0) {
         var6 = class38.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = Spotanim.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class318.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.width * 4 - var17.originalWidth) / 2;
               var18 = (var23.length * 4 - var17.height) / 2;
               var17.method5806(var1 * 4 + var12 + 48, var18 + (104 - var2 - var23.length) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = GrandExchangeOffer.minimapSprite.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class38.region.method3005(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = Spotanim.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class318.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.width * 4 - var20.originalWidth) / 2;
               int var21 = (var19.length * 4 - var20.height) / 2;
               var20.method5806(var9 + var1 * 4 + 48, var21 + (104 - var2 - var19.length) * 4 + 48);
            }
         }
      }

   }
}
